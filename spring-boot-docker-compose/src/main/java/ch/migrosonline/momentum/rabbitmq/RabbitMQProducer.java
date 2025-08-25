package ch.migrosonline.momentum.rabbitmq;

import ch.migrosonline.momentum.rabbitmq.model.ProcessedBlogPostMessage;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

	private final RabbitTemplate rabbitTemplate;

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(ProcessedBlogPostMessage history) {
		rabbitTemplate.convertAndSend("processed-blog-post-exchange", "blog-post.processed", history);
	}

}