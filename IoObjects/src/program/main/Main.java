package program.main;

import models.Cat;
import models.Dog;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //version 1 with Serializable
        Cat cat1 = new Cat("Valera", "Scottish", "grey", 15);

        //objectToFile("cat1.txt", cat1);
        Cat cat2 = (Cat)objectFromFile("cat1.txt");
        System.out.println(cat2);

        //version 2 with Externalizable
        Dog dog1 = new Dog("Jack", "Scottish", "black", 7);
        //objectToFileEx("dog1.txt", dog1);
        Dog dog2 = (Dog) objectFromFileEx("dog1.txt");
        System.out.println(dog2);
    }

    private static Object objectFromFileEx(String file) {
    Dog dog = new Dog("", "", "", 0);

        try (FileInputStream in = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(in);
                ){
            dog.readExternal(ois);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dog;
    }

    private static void objectToFileEx(String file, Dog dog) {
    try (FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        ) {
        dog.writeExternal(oos);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    private static Object objectFromFile(String file) {
        Object obj = null;

        try (FileInputStream in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in)
        ){
            obj = ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return obj;
    }

    private static void objectToFile(String file, Cat cat1) {
        try (FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
        ){
            oos.writeObject(cat1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}