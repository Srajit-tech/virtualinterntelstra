package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.domain.Message;

import au.com.telstra.simcardactivator.domain.actuatorrequest;
import au.com.telstra.simcardactivator.domain.actuatorresponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MessageController {

//    @PostMapping("/activeSIM")
//    public void activateSIMCard(@RequestBody Message simCard) {
//        actuator actuatorResult = new RestTemplateBuilder().build().postForObject("http://localhost:8080/actuate", simCard, actuator.class);
//
//        System.out.println(actuatorResult);
//    }
    @PostMapping("/activateSim")
    public String addEmployee1(@RequestBody Message msg, UriComponentsBuilder builder) {

        actuatorrequest actuatorReq = new actuatorrequest(msg.getIccid());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<actuatorrequest> actuatorRequestEntity = new HttpEntity<>(actuatorReq, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<actuatorresponse> response = restTemplate.exchange(
                "http://localhost:8444/actuate",
                HttpMethod.POST,
                actuatorRequestEntity,
                actuatorresponse.class
        );

        if (response.getBody() != null && response.getBody().isSuccess()) {
            return "SIM activation successful";
        } else {
            return "SIM activation failed";
        }
    }

}