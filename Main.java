import java.lang.reflect.Field;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Monster monster1 = createMonster("Monster 1");
        Monster monster2 = createMonster("Monster 2");

        Monster babyMonster = createBabyMonster(monster1, monster2);

        System.out.println("Monster 1:");
        monster1.printTraits();

        System.out.println("Monster 2:");
        monster2.printTraits();

        System.out.println("Baby Monster:");
        babyMonster.printTraits();
    }

    private static Monster createMonster(String monsterName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter traits for " + monsterName + ":");
//        System.out.print("Eye Color: ");
//        String eyeColor = scanner.nextLine();
//        System.out.print("featherColor: ");
//        String featherColor = scanner.nextLine();
//        System.out.print("magicalAbilities: ");
//        String magicalAbilities = scanner.nextLine();
//        System.out.print("size: ");
//        int size = scanner.nextInt();
//        System.out.print("strength: ");
//        int strength = scanner.nextInt();
//        System.out.print("durability: ");
//        int durability = scanner.nextInt();
//        System.out.print("weakness: ");
//        String weakness = scanner.next();
//        System.out.print("aggressionLevel: ");
//        int aggressionLevel = scanner.nextInt();

        Monster monster = new Monster("","","",0,0,0,"",0);

        for(Field field : Monster.class.getDeclaredFields()){
            System.out.print(field.getName() + ": ");
            String input = scanner.nextLine();

            if(field.getType() == String.class) {
                setField(monster, field, input);
            }
            else if(field.getType()==int.class){
                int v = Integer.parseInt(input);
                setField(monster, field, v);
            }

        }


       // return new Monster(eyeColor, featherColor, magicalAbilities, size, strength, durability, weakness, aggressionLevel);
        return monster;
    }

    private static Monster createBabyMonster(Monster parent1, Monster parent2) throws IllegalAccessException {
//        Monster babyMonster = new Monster(
//                getRandomTrait(parent1.eyeColor, parent2.eyeColor),
//                getRandomTrait(parent1.featherColor, parent2.featherColor),
//                getRandomTrait(parent1.magicalAbilities, parent2.magicalAbilities),
//                getRandomTrait(parent1.size, parent2.size),
//                getRandomTrait(parent1.strength, parent2.strength),
//                getRandomTrait(parent1.durability, parent2.durability),
//                getRandomTrait(parent1.weakness, parent2.weakness),
//                getRandomTrait(parent1.aggressionLevel, parent2.aggressionLevel)
//        );

        Monster babyMonster = new Monster("","","",0,0,0,"",0);

        for(Field field : Monster.class.getDeclaredFields()){

            setField(babyMonster, field, getRandomTrait(getFieldValue(parent1,field),getFieldValue(parent2,field)));
        }
        return babyMonster;
    }
    private static <T> T getRandomTrait(T trait1, T trait2) {

        return new Random().nextBoolean() ? trait1 : trait2;
    }

    private static <T> void setField(Object obj, Field field, T value){
        try{
            field.setAccessible(true);
            field.set(obj,value);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T getFieldValue(Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return (T) field.get(obj);
    }

}

