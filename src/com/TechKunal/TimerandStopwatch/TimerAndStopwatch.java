package com.TechKunal.TimerandStopwatch;

import java.util.Timer;
import java.util.TimerTask;

public class TimerAndStopwatch {
    private static int seconds = 0;
    private static Timer timer = new Timer();
    private static boolean isRunning = false;

    public static void main(String[] args) {
        System.out.println("Press 1 to start the timer.");
        System.out.println("Press 2 to start the stopwatch.");
        System.out.println("Press 3 to stop the stopwatch.");
        System.out.println("Press 0 to exit.");

        char choice;
        do {
            choice = getUserInput();
            switch (choice) {
                case '1':
                    startTimer();
                    break;
                case '2':
                    startStopwatch();
                    break;
                case '3':
                    stopStopwatch();
                    break;
                case '0':
                    System.out.println("Exiting...");
                    timer.cancel();
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        } while (choice != '0');
    }

    private static char getUserInput() {
        try {
            char inputChar = (char) System.in.read();
            // Consume the newline character left in the buffer after reading the char.
            System.in.skip(System.in.available());
            return inputChar;
        } catch (Exception e) {
            return ' ';
        }
    }

    private static void startTimer() {
        if (!isRunning) {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    seconds++;
                    System.out.println("Timer: " + seconds + " seconds");
                }
            };
            timer.scheduleAtFixedRate(timerTask, 1000, 1000);
            isRunning = true;
        } else {
            System.out.println("Timer is already running.");
        }
    }

    private static void startStopwatch() {
        if (!isRunning) {
            TimerTask stopwatchTask = new TimerTask() {
                @Override
                public void run() {
                    seconds++;
                    System.out.println("Stopwatch: " + seconds + " seconds");
                }
            };
            timer.scheduleAtFixedRate(stopwatchTask, 1000, 1000);
            isRunning = true;
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    private static void stopStopwatch() {
        if (isRunning) {
            timer.cancel();
            timer.purge();
            isRunning = false;
            System.out.println("Stopwatch stopped at " + seconds + " seconds.");
            seconds = 0;
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }
}

