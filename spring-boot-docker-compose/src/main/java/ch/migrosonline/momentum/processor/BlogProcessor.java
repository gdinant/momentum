package ch.migrosonline.momentum.processor;

import java.util.Set;

import ch.migrosonline.momentum.rabbitmq.RabbitMQProducer;
import ch.migrosonline.momentum.rabbitmq.model.ProcessedBlogPostMessage;

import org.springframework.stereotype.Component;

@Component
public class BlogProcessor {

	private static final Set<String> GOOD_SENTIMENTS = Set.of("love", "greatest", "great", "good", "friend", "delicious");
	private static final Set<String> BAD_SENTIMENTS = Set.of("hate", "worst", "worse", "bad", "enemy", "disgusting");

	private final RabbitMQProducer rabbitMQProducer;

	public BlogProcessor(RabbitMQProducer rabbitMQProducer) {
		this.rabbitMQProducer = rabbitMQProducer;
	}

	public void process(String slug, String title, String body) {

		var sentiment = resolveSentiment(body);

		rabbitMQProducer.send(new ProcessedBlogPostMessage(slug, title, body, sentiment));
	}

	private String resolveSentiment(String body) {

		var lowerCaseBody = body.toLowerCase();
		var good = evaluateSentiment(lowerCaseBody, GOOD_SENTIMENTS);
		var bad = evaluateSentiment(lowerCaseBody, BAD_SENTIMENTS);
		var rank = good - bad;

		if (rank > 0) {
			return "GOOD";
		}

		if (rank < 0) {
			return "BAD";
		}

		return "NEUTRAL";

	}

	private Integer evaluateSentiment(String content, Set<String> sentiments) {

		return sentiments.stream().filter(content::contains).map(s -> 1).reduce(Integer::sum).orElse(0);
	}

}
