package ch.migrosonline.momentum.rabbitmq.model;

public record ProcessedBlogPostMessage(String slug, String title, String body, String sentiment) {

}
