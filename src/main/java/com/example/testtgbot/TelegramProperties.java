package com.example.testtgbot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("telegram")
public class TelegramProperties {
  private String token;
  private String username;
}
