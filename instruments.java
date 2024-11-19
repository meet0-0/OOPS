
/*a. Create an abstract class Instrument which is having the abstract
    function play.
    Create three more sub classes from Instrument which is Piano,
    Flute and Guitar. Override the play method inside all three classes
    printing a message.
    “Piano is playing tan tan tan tan” for Piano class
    “Flute is playing toot toot toot toot” for Flute class
    “Guitar is playing tin tin tin” for Guitar class
    You must not allow the user to declare an object of
    Instrument class.
    Create an array of 10 Instruments.
    Assign different type of instrument-to-instrument reference.
    Check for the polymorphic behavior of play method.
    Create a compartment of a type as decided by a randomly generated
    integer in the range 1 to 4. Check the polymorphic behaviour of the
    notice method.
 */

import java.util.Random;

abstract class Instrument {

    public abstract void play();
}

class Piano extends Instrument {

    //@Override
    public void play() {
        System.out.println("Piano is playing tan tan tan tan");
    }
}

class Flute extends Instrument {

   @Override
    public void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}

class Guitar extends Instrument {

    @Override
    public void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}

public class instruments {

    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[10];

        for (int i = 0; i < instruments.length; i++) {
            Random random = new Random();
            int randInt = random.nextInt(3);

            switch (randInt) {
                case 0:
                    instruments[i] = new Piano();
                    break;
                case 1:
                    instruments[i] = new Flute();
                    break;
                case 2:
                    instruments[i] = new Guitar();
                    break;
            }
        }

        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
