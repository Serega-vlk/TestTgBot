package com.example.testtgbot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Service
public class TelegramBot extends SpringWebhookBot {
  private final TelegramProperties telegramProperties;
  private final WebhookProperties webhookProperties;

  public TelegramBot(TelegramProperties telegramProperties,
                     WebhookProperties webhookProperties,
                     SetWebhook setWebhook) {
    super(setWebhook, telegramProperties.getToken());
    this.telegramProperties = telegramProperties;
    this.webhookProperties = webhookProperties;
  }

  @Override
  public String getBotUsername() {
    return telegramProperties.getUsername();
  }

  @Override
  public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
    return new SendMessage(update.getMessage().getChatId().toString(), update.getMessage().getText());
  }

  @Override
  public String getBotPath() {
    return webhookProperties.getPath();
  }
}
