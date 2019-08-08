package com.revature.model;

public class Dish {

	private DishType dishType;

	public Dish() {
		super();
	}

	public Dish(DishType dishType) {
		super();
		this.dishType = dishType;
	}

	@Override
	public String toString() {
		return "Dish [dishType=" + dishType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishType == null) ? 0 : dishType.hashCode());
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
		Dish other = (Dish) obj;
		if (dishType != other.dishType)
			return false;
		return true;
	}

	public DishType getDishType() {
		return dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}

	public enum DishType {
		CUP, PLATE, BOWL, THERMOS
	}
}
