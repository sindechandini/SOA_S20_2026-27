package com.example.gatewayapplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayapplicationApplicationTests {
 public static void main(String[] args) {
  SpringApplication.run(GatewayapplicationApplicationTests.class, args);
 }
}