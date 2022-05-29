import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface{
    
    private Scanner scanner;
    private ArrayList<Recipes> recipes;
    private ArrayList<String> ingredients;
    
    
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.recipes = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }
    
    public void start(){
        this.addRecipes(this.fileName());
        this.commandList();
        this.commands();
        
        

    }
    
    public String fileName(){
        System.out.println("File to read: ");
        String file = this.scanner.nextLine();
        return file;
    }
    
    public void commandList(){
        System.out.println("Commands:");
        System.out.println("list - lists the receipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
    
    public void commands(){
        while(true){
            System.out.println("Enter a command:");
            String command = this.scanner.nextLine();
            
            if(command.equals("stop")){
                break;
            }else if(command.equals("list")){
                this.printRecipes();
            }else if(command.equals("find name")){
                this.findRecipebyName();
            }else if(command.equals("find cooking time")){
                this.findRecipeByCookTime();
            }else if(command.equals("find ingredient")){
                this.findRecipeByIngredient();
            }
        }
    }
    
    public void addRecipes(String file){
        try(Scanner fileReader = new Scanner(Paths.get(file))){
            
            
            while(fileReader.hasNextLine()){
                String name = fileReader.nextLine();
                int cookTime = Integer.valueOf(fileReader.nextLine());
                    while(fileReader.hasNextLine()){
                        String ingredient = fileReader.nextLine();
                        this.ingredients.add(ingredient);
                        if(ingredient.isEmpty()){
                            
                            break;
                        }
                    }
                this.recipes.add(new Recipes(name, cookTime, this.ingredients)); 
                this.ingredients.clear();
            }
        }
        catch(Exception e){
            System.out.println("Error has occured");
        }
    }
    
    public void printRecipes(){
        for(int i = 0; i < this.recipes.size(); i++){
            System.out.println(this.recipes.get(i));
        }
    }
    
    public void findRecipebyName(){
        System.out.println("Searched word:");
        String name = this.scanner.nextLine();
        for(Recipes recipes : this.recipes){
            if(recipes.getName().contains(name)){
                System.out.println(recipes);
            }else{
                continue;
            }
        }
    }
    
    public void findRecipeByCookTime(){
        System.out.println("Max cooking time:");
        int maxTime = Integer.valueOf(this.scanner.nextLine());
        for(int i = 0; i < this.recipes.size(); i++){
            if(this.recipes.get(i).getCookTime() <= maxTime){
                System.out.println(this.recipes.get(i));
            }
        }
    }
    public void findRecipeByIngredient(){
        System.out.println("Ingredient:");
        String input = this.scanner.nextLine();
        
        for(Recipes recipes : this.recipes){
            if(recipes.getIngredients().contains(input)){
                System.out.println(recipes);
            }
        }
    }
}