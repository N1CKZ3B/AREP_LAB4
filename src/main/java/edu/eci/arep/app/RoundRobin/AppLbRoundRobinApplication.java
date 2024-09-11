package edu.eci.arep.app.RoundRobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        basePackages = {"edu.eci.arep.app.RoundRobin"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.app.RoundRobin.LoadBalancerController.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.app.RoundRobin.WebController.class)
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = edu.eci.arep.app.LogController.class)
        }
)
public class AppLbRoundRobinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppLbRoundRobinApplication.class, args);
    }
}
