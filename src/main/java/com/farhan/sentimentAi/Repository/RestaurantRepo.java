package com.farhan.sentimentAi.Repository;

import com.farhan.sentimentAi.Domain.ResDomain;
import jdk.jfr.StackTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<ResDomain, Integer> {
}
