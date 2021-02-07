package com.githubwebhook.webhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class WebhookApplication {

	public static void main(String[] args)
	{


			ApplicationContext ctx = SpringApplication.run(WebhookApplication.class, args);
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames)
			{
				System.out.println(beanName);
			}
	}

}
