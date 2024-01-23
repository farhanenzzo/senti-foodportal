package com.farhan.sentimentAi.Controller;

import com.farhan.sentimentAi.DTO.AvgPositive.AvgPositiveList;
import com.farhan.sentimentAi.DTO.AvgPositive.AvgPositiveByCity;
import com.farhan.sentimentAi.DTO.Form.SentimentRequest;
import com.farhan.sentimentAi.DTO.Priom.AiModelResponseDto;
import com.farhan.sentimentAi.DTO.ResCount.ResCountByCity;
import com.farhan.sentimentAi.DTO.ResCount.ResCountList;
import com.farhan.sentimentAi.DTO.SentimentByRes.FlaskLRModel;
import com.farhan.sentimentAi.DTO.TopN.TopNList;
import com.farhan.sentimentAi.DTO.UniqueResCount.UniqueCountDto;
import com.farhan.sentimentAi.Domain.Location;
import com.farhan.sentimentAi.Domain.ResDomain;
import com.farhan.sentimentAi.Repository.LocationRepository;
import com.farhan.sentimentAi.Repository.RestaurantRepo;
import com.farhan.sentimentAi.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping(value = "/pred")
public class RestaurantController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @GetMapping
    public String showPredictPage(Model model) {
        List<ResDomain> restaurantNames = restaurantRepo.findAll();
        List<Location> locations = locationRepository.findAll();

        String resCountApi = "http://localhost:5000/unique_count/";
        UniqueCountDto uniqueResCountDto = restTemplate.getForObject(resCountApi + "restaurants", UniqueCountDto.class);
        UniqueCountDto uniqueCityCountDto = restTemplate.getForObject(resCountApi + "city", UniqueCountDto.class);

        if (uniqueResCountDto != null) {
            model.addAttribute("resCount", uniqueResCountDto);
        }
        if (uniqueCityCountDto != null) {
            model.addAttribute("cityCount", uniqueCityCountDto);
        }

        //  *****************************************************************************

        String resCountByCityApi = "http://localhost:5000/restaurant_count_in_each_city";
        ResCountList resCountList = restTemplate.getForObject(resCountByCityApi, ResCountList.class);

        List<List<Object>> resCountByCityChart = new ArrayList<>();
        resCountByCityChart.add(List.of("city", "count"));

        assert resCountList != null;
        for (ResCountByCity resCountByCity : resCountList.getCity_counts()) {
            resCountByCityChart.add(List.of(resCountByCity.getCity(), resCountByCity.getRestaurant_count()));
        }

        //  *****************************************************************************

        String avgPositiveScoreByCityApi = "http://localhost:5000/average_positive_sentiment_percentages";
        AvgPositiveList avgPositiveList = restTemplate.getForObject(avgPositiveScoreByCityApi, AvgPositiveList.class);
        System.out.println(avgPositiveList);

        List<List<Object>> avgPositiveScoreByCityChart = new ArrayList<>();
        avgPositiveScoreByCityChart.add(List.of("city", "pos"));
        assert avgPositiveList != null;
        for (AvgPositiveByCity avgPositiveByCity : avgPositiveList.getAvg_pos_senti_by_city()) {
            avgPositiveScoreByCityChart.add(List.of(avgPositiveByCity.getCity(), avgPositiveByCity.getAverage_positive_sentiment_percentage()));
        }

        //  *****************************************************************************


        model.addAttribute("resCountByCityChart", resCountByCityChart);
        model.addAttribute("avgPositiveScoreByCityChart", avgPositiveScoreByCityChart);

        model.addAttribute("sentimentRequest", new SentimentRequest());
        model.addAttribute("restaurantNames", restaurantNames);
        model.addAttribute("locations", locations);
        model.addAttribute("text", "");


        return "pred";
    }

    @PostMapping("/topN")
    public String predictTopN(SentimentRequest request, RedirectAttributes redirectAttributes) {
        if(Objects.nonNull(request.getLocationName()) && !request.getLocationName().isBlank()) {
            String topNApi = "http://localhost:5000/top_restaurants_by_positive_sentiment/";
            TopNList topNList = restTemplate.getForObject(topNApi + request.getLocationName() + "/" + request.getTopN(), TopNList.class);
            System.out.println(topNList);

            redirectAttributes.addFlashAttribute("topNByCity", topNList);
        }
        return "redirect:/pred";
    }

    @PostMapping("/textPrediction")
    public String predictText(SentimentRequest request, RedirectAttributes redirectAttributes) {

        String apiUrl = "http://127.0.0.1:5000/predict_sentiment";
        AiModelResponseDto aiModelResponseDto = restTemplate.postForObject(apiUrl, request, AiModelResponseDto.class);

        redirectAttributes.addFlashAttribute("textReview", aiModelResponseDto);
        return "redirect:/pred";
    }

    @PostMapping("/restaurantPrediction")
    public String predictRestaurant(SentimentRequest request, RedirectAttributes redirectAttributes) {
        if (Objects.nonNull(request.getRestaurantName()) && !request.getRestaurantName().isBlank()) {
            String flaskApiUrl = "http://localhost:5000/";
            FlaskLRModel flaskLrModel = restTemplate.getForObject(flaskApiUrl + request.getRestaurantName(), FlaskLRModel.class);

            List<List<Object>> a = new ArrayList<>();

            a.add(List.of("Sentiment Type", "Percentage"));
            assert flaskLrModel != null;
            a.add(List.of(flaskLrModel.getSentimentLabelPercentage().get(0).getSentimentTitle(), flaskLrModel.getSentimentLabelPercentage().get(0).getSentimentPercentage()));
            a.add(List.of(flaskLrModel.getSentimentLabelPercentage().get(1).getSentimentTitle(), flaskLrModel.getSentimentLabelPercentage().get(1).getSentimentPercentage()));
            a.add(List.of(flaskLrModel.getSentimentLabelPercentage().get(2).getSentimentTitle(), flaskLrModel.getSentimentLabelPercentage().get(2).getSentimentPercentage()));


            redirectAttributes.addFlashAttribute("result", flaskLrModel);
            redirectAttributes.addFlashAttribute("barChartData", a);

        }
        return "redirect:/pred";
    }
}
