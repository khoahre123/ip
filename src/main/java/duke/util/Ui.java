package duke.util;

import java.util.ArrayList;
import java.util.Scanner;

import duke.task.Task;

/**
 * Represents a helper program to read from and write to interface
 */
public class Ui {
    private final Scanner sc;

    /**
     * Initialize an Ui interface
     * @param sc System scanner
     */
    public Ui(Scanner sc) {
        //String logo = " ____        _        \n"
        //        + "|  _ \\ _   _| | _____ \n"
        //        + "| | | | | | | |/ / _ \\\n"
        //        + "| |_| | |_| |   <  __/\n"
        //        + "|____/ \\__,_|_|\\_\\___|\n";
        this.sc = sc;
        startChat();
    }

    /**
     * Prints out the welcoming text when user initialize the bot
     */
    public void startChat() {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.HELLO);
        System.out.println(" What can I do for you?");
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out the goodbye text when user end the bot
     */
    public void endChat() {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.GOODBYE);
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out all the task in the current list
     *
     * @param storingList Current task list
     */
    public void showTaskList(ArrayList<Task> storingList) {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(" Here are the tasks in your list:");

        for (int i = 1; i <= storingList.size(); i++) {
            System.out.println(" " + i + "." + storingList.get(i - 1));
        }

        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out the response based on changing state of the task
     *
     * @param task   Task that changing state
     * @param isDone State of the task
     */
    public void showTaskMark(Task task, boolean isDone) {
        if (isDone) {
            task.changeTaskDone();
            System.out.println(TypicalString.LONG_LINE);
            System.out.println(" Nice! I've marked this task as done: ");
        } else {
            task.changeTaskUndone();
            System.out.println(TypicalString.LONG_LINE);
            System.out.println(" OK, I've marked this task as not done yet: ");
        }
        System.out.println("  " + task);
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out the task and total number of tasks after adding
     *
     * @param task    Task that just been added in
     * @param numTask Number of tasks after adding
     */
    public void showAllTask(Task task, int numTask) {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.ADDED_TASK);
        System.out.println("  " + task);
        System.out.println(" Now you have " + numTask + " tasks in the list.");
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out the task that been deleted and the number of tasks afterwards
     *
     * @param task    Task that just been deleted
     * @param numTask Number of tasks left
     */
    public void showDeleteTask(Task task, int numTask) {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(" Noted. I've removed this task: ");
        System.out.println("  " + task);
        System.out.println(" Now you have " + numTask + " tasks in the list.");
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints out the list of tasks in a specific date
     *
     * @param eventList Collection of tasks on the date
     */
    public void showDate(ArrayList<Task> eventList) {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println("You have " + eventList.size()
                + " deadlines/events in the day:");

        for (int i = 1; i <= eventList.size(); i++) {
            System.out.println(i + "." + eventList.get(i - 1));
        }

        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Prints results that match with the keyword
     *
     * @param numIndex        Current number of task that match with the keyword
     * @param storingListSize Current size of <code>TaskList</code>
     * @param task            Task that been matched with keyword
     */
    public void showSearchResult(int numIndex, int storingListSize, Task task) {
        if (numIndex == 1) {
            System.out.println(TypicalString.LONG_LINE);
            System.out.println(" Here are the matching tasks in your list:");
        }

        System.out.println(" " + numIndex + "." + task);

        if (numIndex == (storingListSize - 1)) {
            System.out.println(TypicalString.LONG_LINE);
        }
    }

    /**
     * Prints out the error message when loading the bot
     */
    public void showLoadingError() {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(" Sorry, some problem have occurred during initialization: ");
        System.out.println(TypicalString.LONG_LINE);
    }

    /**
     * Returns the input string from scanner
     *
     * @return Input string
     */
    public String readCommand() {
        return sc.nextLine();
    }

    public enum TypicalString {
        LONG_LINE {
            public String toString() {
                return "____________________________________________________________";
            }
        },
        ADDED_TASK {
            public String toString() {
                return " Got it. I've added this task:";
            }
        },
        HELLO {
            public String toString() {
                return " Hello! I'm Duke";
            }
        },
        GOODBYE {
            public String toString() {
                return " Bye. Hope to see you again soon!";
            }
        }
    }
}
