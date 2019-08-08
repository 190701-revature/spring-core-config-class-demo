package com.revature.model;

import java.time.LocalDateTime;

public class Food {
	private String name;
	private boolean packaged;
	private LocalDateTime expirationDate;
	private FoodType foodType;
	private Dish dish;

	public String getName() {
		return name;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPackaged() {
		return packaged;
	}

	public void setPackaged(boolean packaged) {
		this.packaged = packaged;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (packaged ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (foodType != other.foodType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (packaged != other.packaged)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", packaged=" + packaged + ", expirationDate=" + expirationDate + ", foodType="
				+ foodType + ", dish=" + dish + "]";
	}

	public Food(String name, boolean packaged, LocalDateTime expirationDate, FoodType foodType) {
		super();
		this.name = name;
		this.packaged = packaged;
		this.expirationDate = expirationDate;
		this.foodType = foodType;
	}

	public Food() {
		super();
	}

	public enum FoodType {
		FRUIT, MEAT, VEGETABLE, GRAIN, SEAFOOD, NUTS, DAIRY
	}

}
