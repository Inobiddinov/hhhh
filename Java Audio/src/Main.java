import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
       File file = new File("111.wav");
       Scanner scan = new Scanner(System.in);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);


        String response = "";
        while (!response.equals("Q")){
            System.out.println("P = play, S = stop, R= reset, Q = quit.");
            System.out.println("Enter your Choice here:");
            response = scan.next();
            response = response.toUpperCase();

            switch (response) {
                case "P" -> clip.start();
                case "S" -> clip.stop();
                case "R" -> clip.setMicrosecondPosition(0);
                case "Q" -> {
                    clip.close();
                    System.out.println("Bye See you soon");
                }
                default -> System.out.println("not valid value Can you try it again:");
            }
        }
        clip.start();
    }
}