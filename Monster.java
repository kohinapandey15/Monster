import java.lang.reflect.Field;
import java.util.Random;
import java.util.Scanner;

class Monster {

    String eyeColor;
    String featherColor;
    String magicalAbilities;
    int size;
    int strength;
    int durability;
    String weakness;
    int aggressionLevel;


    public Monster(String eyeColor, String featherColor, String magicalAbilities,
            int size, int strength, int durability, String weakness, int aggressionLevel) {
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }


    public void printTraits() {
        System.out.println("Monster Traits:");
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Feather Color: " + featherColor);
        System.out.println("Magical Abilities: " + magicalAbilities);
        System.out.println("Size: " + size);
        System.out.println("Strength: " + strength);
        System.out.println("Durability: " + durability);
        System.out.println("Weakness: " + weakness);
        System.out.println("Aggression Level: " + aggressionLevel);


    }
}
