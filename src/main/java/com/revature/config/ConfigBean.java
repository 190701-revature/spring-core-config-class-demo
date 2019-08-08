package com.revature.config;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.revature.model.Dish;
import com.revature.model.Food;

/*
 * @Configuration - is used to define a class as a Spring bean that
 * 	provides configuration to Spring
 * @Bean - Defined a method as a bean definition, using the return type
 * 	as the type of the bean, and the method name as the bean identifier. Also
 * 	allows some bean configuration.
 * @Primary - Defines a bean as the primary bean of that type.
 * @Lazy - Defines a bean to initialize lazily if it is a singleton. By default
 * 	singletons initialize eagerly. Prototypes always initialize lazily.
 * @Scope - Defines bean scope (Such as prototype or singleton)
 */
@Configuration
public class ConfigBean {
	
	/*
	 * With a configuration bean, we write 'getter' style methods which act
	 * as the method to create and configure individual beans for Spring
	 */
	
	@Primary
	@Bean(autowire = Autowire.BY_TYPE)
	public Food pizza() {
		Food veggiePizza = new Food();
		veggiePizza.setFoodType(Food.FoodType.VEGETABLE);
		veggiePizza.setName("Veggie Pizza");
		veggiePizza.setPackaged(true);
		veggiePizza.setExpirationDate(LocalDateTime.now().plus(1, ChronoUnit.HOURS));
		veggiePizza.setDish(plate());
		return veggiePizza;
	}
	
	@Bean(name = {"chickenSoup"})
	public Food soup() {
		Food soup = new Food();
		soup.setName("Chicken Noodle Soup");
		soup.setFoodType(Food.FoodType.MEAT);
		soup.setPackaged(false);
		soup.setExpirationDate(LocalDateTime.now().plusHours(3));
		soup.setDish(bowl());
		return soup;
	}
	
	@Lazy
	@Scope(scopeName = "prototype")
	@Bean(name = {"toGoSoup"})
	public Food toGoSoup() {
		Food soup = new Food();
		soup.setName("Chicken Noodle Soup");
		soup.setFoodType(Food.FoodType.MEAT);
		soup.setPackaged(false);
		soup.setExpirationDate(LocalDateTime.now().plusHours(3));
		soup.setDish(thermos());
		return soup;
	}
	
	@Primary
	@Bean
	public Dish plate() {
		Dish plate = new Dish();
		plate.setDishType(Dish.DishType.PLATE);
		return plate;
	}
	
	@Bean
	public Dish bowl() {
		Dish bowl = new Dish();
		bowl.setDishType(Dish.DishType.BOWL);
		return bowl;
	}
	
	@Bean
	public Dish thermos() {
		Dish thermos = new Dish();
		thermos.setDishType(Dish.DishType.THERMOS);
		return thermos;
	}
}
