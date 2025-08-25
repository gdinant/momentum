package ch.migrosonline.momentum.kafka;

import ch.migrosonline.momentum.kafka.model.BlogPostUpdateEvent;
import ch.migrosonline.momentum.processor.BlogProcessor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BlogPostUpdateEventListener {

	private final BlogProcessor blogProcessor;

	public BlogPostUpdateEventListener(BlogProcessor blogProcessor) {
		this.blogProcessor = blogProcessor;
	}

	@KafkaListener(topics = "blog.updates")
	void onErasureRequest(BlogPostUpdateEvent event) {

		blogProcessor.process(event.slug(), event.title(), event.body());
	}

}
