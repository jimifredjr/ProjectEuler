package application;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import problems.ten.ProblemOne;

@SpringBootApplication
@EnableJms
public class Application {

	@Value("${spring.activemq.user}")
	private String username;
	
	@Value("${spring.activemq.password}")
	private String password;
	
	@Value("${spring.activemq.broker-url}")
	private String amqUrl;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Going to send message");
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("mailBox", new ProblemOne());
		System.out.println("Going to send message");
	}
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	 @Bean
	  public ActiveMQConnectionFactory activeMQConnectionFactory() {
	    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(amqUrl);

	    return activeMQConnectionFactory;
	  }
	 
	 @Bean
	  public CachingConnectionFactory cachingConnectionFactory() {
	    return new CachingConnectionFactory(activeMQConnectionFactory());
	  }
	 
	 @Bean
	  public JmsTemplate jmsTemplate() {
	    return new JmsTemplate(cachingConnectionFactory());
	  }

	  @Bean
	  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(activeMQConnectionFactory());
	    factory.setConcurrency("3-10");

	    return factory;
	  }
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
        };
    }

}
