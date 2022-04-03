public class Bat extends Mammal{
    public Bat(){
        this.energyLevel = 400;
    }

    public Bat fly(){
        System.out.println("The Bat flew: Wooooooshhhhh!");
        this.energyLevel -= 50;
        this.displayEnergy();
        return this;
    }

    public Bat eatHumans(){
        System.out.println("The Bat is feeding: Nom Nom Nom");
        this.energyLevel += 25;
        this.displayEnergy();
        return this;
    }

    public Bat attackTown(){
        System.out.println("The Bat attacks the town! Heeeeeellllllpppppppp!!!!!");
        this.energyLevel -= 100;
        this.displayEnergy();
        return this;
    }
}
