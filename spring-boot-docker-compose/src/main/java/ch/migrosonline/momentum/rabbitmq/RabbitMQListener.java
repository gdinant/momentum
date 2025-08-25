package ch.migrosonline.momentum.rabbitmq;

import ch.migrosonline.momentum.rabbitmq.model.ProcessedBlogPostMessage;
import ch.migrosonline.momentum.repository.BlogRepository;
import ch.migrosonline.momentum.repository.model.BlogEntity;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

	private final BlogRepository blogRepository;

	public RabbitMQListener(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@RabbitListener(queues = "processed-blog-post-queue")
	void receiveMessage(ProcessedBlogPostMessage message) {

		var blog = new BlogEntity();
		blog.setSlug(message.slug());
		blog.setTitle(message.title());
		blog.setBody(message.body());

		var result = blogRepository.save(blog);
		System.out.println("Saved: " + result);
	}

}