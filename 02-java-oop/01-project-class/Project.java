/**
 * Project
 */
public class Project {
    private String name;
    private String description;

    public String elevatorPitch(){
        return this.name + " : " + this.description;
    }

    public Project(){
        this.name = "Given Name";
        this.description = "Given Description";
    }

    public Project(String name) {
        this.name = "Given Name";
    }

    public Project(String name, String description) {
        this.name = "Given Name";
        this.description = "Given Description";
    }

    //getter
    public String getName(){
        return this.name;
    }
    
    //setter
    public void setName(String name){
        this.name = name;
    }
    //getter
    public String getDescription(){
        return this.description;
    }

    //setter
    public void setDescription(){
        this.description = description;
    }

    
}