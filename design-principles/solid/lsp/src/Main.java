import ok.impl.Duck;
import wrong.Ostrich;

public class Main {
    public static void main(String[] args) {
        /**
         * Look to this bad example
         * **/
        Ostrich ostrich = new Ostrich();
        ostrich.fly(); /** logic error **/
        /** check the ok folder to see the solution to this design issue**/

        /**
         * The good example
         * **/
        ok.impl.Ostrich ostrichOk = new ok.impl.Ostrich();
        ostrichOk.eat();
        ostrichOk.chirp();
        /** Now ostrich can only access what it needs**/

        Duck duck = new Duck();
        duck.chirp();
        duck.eat();
        duck.fly();
        duck.swim();
        /** Now duck can only access what it needs**/

    }
}