package com.picpay.picapaysimplificado.services;

import com.picpay.picapaysimplificado.domain.user.User;
import com.picpay.picapaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {

        String userEmail = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(userEmail, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception("Serviço notificação fora do ar");
        }
    }


}
