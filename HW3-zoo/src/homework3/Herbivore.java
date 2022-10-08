package homework3;
import homework3.EFoodType;
import homework3.IEdible;
import homework3.Animal;
import homework3.Elephant;
import homework3.Giraffe;
import homework3.Turtle;
import homework3.Plant;
import homework3.MessageUtility;

/**
 * 
 * @author Ilan Shklover,Shira Cohen.
 * This class represents the animals who eat plants only.
 */
public class Herbivore implements IDiet {
	
	/**
	 *Checks if the animal can eat the 'food' received as a parameter.
	 *@param - something edible for animal(other animal or plant)
	 *@return - True if the animal is able to eat the food in parameter 'food',else false.
	 **/
	public boolean canEat(EFoodType food) {
		MessageUtility.logBooleanFunction("Herbivore","canEat", food, food == EFoodType.VEGETABLE);
		return food == EFoodType.VEGETABLE;
	}
	
	
	/**
	 *Performs simulation of eating.
	 *@param animal - A certain animal.
	 *@param food - Something edible which can be an animal or a plant.
	 *@return - If the animal can eat the 'food' received as a parameter,
	 *then the amount of weight the animal will gain from this meal will be returned.
	 **/
    public double eat(Animal animal, IEdible food) {
		if(this.canEat(food.getFoodtype()))
			return animal.get_weight()*0.07;
		return 0;
    }
		    
	
	
}