package com.example.SIH.MailingService.Controller;


import com.example.SIH.MailingService.Services.PushNotificationService;
import com.example.SIH.MailingService.entitiy.PushNotificationRequest;
import com.example.SIH.MailingService.entitiy.PushNotificationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class PushNotificationController {

        private PushNotificationService pushNotificationService;

        public PushNotificationController(PushNotificationService pushNotificationService) {
            this.pushNotificationService = pushNotificationService;
        }

        @PostMapping("/notification/topic")
        public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
            pushNotificationService.sendPushNotificationWithoutData(request);
            return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
        }

        @PostMapping("/notification/token")
        public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
            pushNotificationService.sendPushNotificationToToken(request);
            return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
        }

        @PostMapping("/notification/data")
        public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
            pushNotificationService.sendPushNotification(request);
            return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
        }

        @GetMapping("/notification")
        public ResponseEntity sendSampleNotification() {
            PushNotificationRequest reques = new PushNotificationRequest("test","test","test","fa_wBxK8V9o96U0SqfXmM_:APA91bGhF-ksMA16DcIULz4dh9r9UTXbK8gEyBRVWEgkvoxiwWkDwNgb9O7XDogtITiUKQUTqllSrCgoBrEFBtwdEI9Gw2dhGXBwq3iSo5AQRF4Qkhpd8luza5DmCe_SiTVYptoZ06LI");
            pushNotificationService.sendPushNotificationToToken(reques);
            return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
        }
    }

