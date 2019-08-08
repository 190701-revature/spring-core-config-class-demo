package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.ConfigBean;
import com.revature.model.Dish;
import com.revature.model.Food;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(ConfigBean.class);
		
		Food food = applicationContext.getBean(Food.class);
		System.out.println(food);
		
		Food soup = applicationContext.getBean("chickenSoup", Food.class);
		System.out.println(soup);
		
		Food toGoSoup = applicationContext.getBean("toGoSoup", Food.class);
		System.out.println(toGoSoup);
		
		Food soup2 = applicationContext.getBean("chickenSoup", Food.class);
		Food toGoSoup2 = applicationContext.getBean("toGoSoup", Food.class);
		
		System.out.println("Soup: " + (soup == soup2));
		System.out.println("toGoSoup: " + (toGoSoup == toGoSoup2));

	}
}
