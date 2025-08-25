package ch.migrosonline.momentum.context;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQContext {

	@Bean
	Queue queue() {
		return new Queue("processed-blog-post-queue", false);
	}

	@Bean
	Exchange exchange() {
		return new DirectExchange("processed-blog-post-exchange");
	}

	@Bean
	Binding binding(Queue queue, Exchange exchange) {

		return BindingBuilder.bind(queue)
			.to(exchange)
			.with("blog-post.processed")
			.noargs();
	}

}
