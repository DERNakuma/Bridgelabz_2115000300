import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealName();
}

class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}


class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }

    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generated Meal Plan: " + meal.getMealName());
    }
}

public class MealPlanGen{
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal("Vegetable Stir Fry"));
        vegetarianMeals.addMeal(new VegetarianMeal("Lentil Soup"));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Tofu Salad"));
        veganMeals.addMeal(new VeganMeal("Quinoa Bowl"));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Grilled Chicken with Avocado"));
        ketoMeals.addMeal(new KetoMeal("Egg Muffins"));

        Meal<HighProteinMeal> highProteinMeals = new Meal<>();
        highProteinMeals.addMeal(new HighProteinMeal("Steak with Asparagus"));
        highProteinMeals.addMeal(new HighProteinMeal("Salmon with Broccoli"));

        System.out.println("Generating personalized meal plans:");
        Meal.generateMealPlan(new VegetarianMeal("Vegetable Stir Fry"));
        Meal.generateMealPlan(new VeganMeal("Tofu Salad"));
        Meal.generateMealPlan(new KetoMeal("Grilled Chicken with Avocado"));
        Meal.generateMealPlan(new HighProteinMeal("Steak with Asparagus"));
    }
}
