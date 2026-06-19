package com.cts.elearn.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.elearn.dao.PurchaseHistoryRepository;
import com.cts.elearn.entity.PurchaseHistory;

@Configuration
public class PurchaseDataLoader {

    @Bean
    CommandLineRunner loadPurchases(
            PurchaseHistoryRepository repo) {

        return args -> {

            if(repo.count() == 0) {

                PurchaseHistory purchase1 =
                        new PurchaseHistory();

                purchase1.setLearnerId(2L);   // Anil
                purchase1.setCourseId(1L);    // Java Course
                purchase1.setServiceId(1L);   // Full Access
                purchase1.setEventId(
                        "PURCHASE-1001");

                repo.save(purchase1);

                PurchaseHistory purchase2 =
                        new PurchaseHistory();

                purchase2.setLearnerId(2L);
                purchase2.setCourseId(2L);    // Kafka
                purchase2.setServiceId(1L);
                purchase2.setEventId(
                        "PURCHASE-1002");

                repo.save(purchase2);

                PurchaseHistory purchase3 =
                        new PurchaseHistory();

                purchase3.setLearnerId(2L);
                purchase3.setCourseId(4L);    // LLB
                purchase3.setServiceId(2L);   // Limited Access
                purchase3.setEventId(
                        "PURCHASE-1003");

                repo.save(purchase3);

                System.out.println(
                        "Sample Purchase History Loaded");
            }
        };
    }
}