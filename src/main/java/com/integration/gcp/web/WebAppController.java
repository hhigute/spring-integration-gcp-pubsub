package com.integration.gcp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.integration.gcp.publisher.PubsubOutboundGateway;

@RestController
public class WebAppController {

  @Autowired
  private PubsubOutboundGateway messagingGateway;
 
  @PostMapping("/publishMessage")
  public RedirectView publishMessage(@RequestParam("message") String message) {
    messagingGateway.sendToPubsub(message);
    return new RedirectView("/");
  }
}