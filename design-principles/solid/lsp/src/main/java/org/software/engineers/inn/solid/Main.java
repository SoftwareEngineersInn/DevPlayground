package org.software.engineers.inn.solid;

import org.software.engineers.inn.solid.ok.impl.Duck;
import org.software.engineers.inn.solid.ok.impl.Ostrich;
//import org.software.engineers.inn.solid.wrong.Ostrich;

public class Main {
    public static void main(String[] args) {
        /**
         * Look to this bad example
         * **/
        //Ostrich ostrichWrong = new Ostrich();
        //ostrichWrong.fly(); /** logic error **/
        /** check the ok folder to see the solution to this design issue**/

        /**
         * The good example
         * **/
        Ostrich ostrich = new Ostrich();
        ostrich.eat();
        ostrich.chirp();
        /** Now ostrich can only access what it needs**/

        Duck duck = new Duck();
        duck.chirp();
        duck.eat();
        duck.fly();
        duck.swim();
        /** Now duck can only access what it needs**/
    }
}