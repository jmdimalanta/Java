public class Gorilla extends Mammal {
    public Gorilla(){
        this.energyLevel = 400;
    }
    public Gorilla throwSomething(){
        System.out.println("The gorilla has thrown something!");
        this.energyLevel -= 5;
        this.displayEnergy();
        return this;
    }
    public Gorilla eatBananas(){
        System.out.println("The gorilla is satisfied!");
        this.energyLevel += 10;
        this.displayEnergy();
        return this;
    }
    public Gorilla climb(){
        System.out.println("The gorilla climbed a tree!");
        this.energyLevel -= 10;
        this.displayEnergy();
        return this;
    }
}
