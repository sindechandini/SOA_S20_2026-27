package com.klu.orderapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository or;

    @Value("${restaurant.url}")
    private String url;

    @Autowired
    private RestTemplate rt;

    public String insert(Order o) {
        try {
            RestaurantDTO dto = rt.getForObject(url + "/" + o.getRid(), RestaurantDTO.class);
            if (dto == null) {
                return "Restaurant not exists";
            }
        } catch (HttpClientErrorException.NotFound e) {
            return "Restaurant not exists";
        } catch (RestClientException e) {
            return "Failed to communicate with Restaurant service: " + e.getMessage();
        }

        or.save(o);
        return "Order Placed Successfully";
    }

    public List<Order> retrieve() {
        return or.findAll();
    }
}