package com.example.testtgbot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("webhook")
public class WebhookProperties {
  private String path;
}
