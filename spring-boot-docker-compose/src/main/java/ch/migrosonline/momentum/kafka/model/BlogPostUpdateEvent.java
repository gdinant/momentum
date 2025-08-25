package ch.migrosonline.momentum.kafka.model;

public record BlogPostUpdateEvent(String title, String slug, String body) {

}
