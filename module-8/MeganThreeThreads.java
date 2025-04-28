// Megan Wheeler
// Assignment 8

// Follow the directions below:

// 1. Create a class titled [your first="" name="" here=""] ThreeThreads.
// 2. In this class, you are to use three threads to output three types of
//     characters to a text area for display.
// 3. In the first thread, you are to output random letter characters such
//     as a, b, c, d
// 4. In the second thread, you are to output random number digits such as
//     0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
// 5. In the third thread, you are to output random characters such as
//     !, @, #, $, %, &, *
// 6. Display a minimum of 10,000 for each of the three sets.
// 7. Write test code that ensures all methods function correctly.
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class MeganThreeThreads extends JFrame{
    private JTextArea textArea;
    private Random random = new Random();

    public MeganThreeThreads() {
        setTitle("Megan Three Threads Display");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font("monospaced", Font.PLAIN, 18));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        Thread thread1 = new Thread(new RandomLetterWriter());
        Thread thread2 = new Thread(new RandomDigitWriter());
        Thread thread3 = new Thread(new RandomSymbolWriter());

        thread1.start();
        thread2.start();
        thread3.start();
    }

    class RandomLetterWriter implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i <10_000; i++) {
                char letter = (char) (random.nextBoolean() ?
                    ('A' + random.nextInt(26)) :
                    ('a' + random.nextInt(26)));
                appendCharacter(letter);
                sleep();
            }
        }
    }

    class RandomDigitWriter implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i < 10_000; i++) {
                char digit = (char) ('0' + random.nextInt(10));
                appendCharacter(digit);
                sleep();
            }
        }
    }

    class RandomSymbolWriter implements Runnable {
        private final char[] symbols = {
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', 
            '-', '_', '=', '+', '[', ']', '{', '}', ';', ':', 
            '\'', '"', ',', '.', '<', '>', '/', '?', '\\', '|', '`', '~'
        };

        @Override
        public void run() {
            for(int i = 0; i < 10_000; i++) {
                char symbol = symbols[random.nextInt(symbols.length)];
                appendCharacter(symbol);
                sleep();
            }
        }
    }

    private void appendCharacter(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(Character.toString(c)));
    }

    private void sleep() {
        try {
            if (Thread.interrupted()) // Clears interrupted status!
            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MeganThreeThreads frame = new MeganThreeThreads();
            frame.setVisible(true);
        });
    }
}