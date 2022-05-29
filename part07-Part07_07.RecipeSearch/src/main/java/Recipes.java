import java.util.Scanner;
import java.util.ArrayList;

public class Recipes {
    
    private Scanner scanner;
    private ArrayList<String> ingredients;
    private String name;
    private int cookTime;

    
    public Recipes(String name, int cookTime, ArrayList<String> ingredients){
        this.scanner = new Scanner(System.in);
        this.ingredients = new ArrayList<String>(ingredients);
        this.name = name;
        this.cookTime = cookTime;
    }
    public String getName(){
        return this.name;
    }
    public int getCookTime(){
        return this.cookTime;
    }
    public void printIngredients(){
        for(int i = 0; i < this.ingredients.size(); i++){
            System.out.println(this.ingredients.get(i));
        }
    }
    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }
    public String toString(){
        return "" + this.name + ", cooking time: " + this.cookTime;
    }
}
