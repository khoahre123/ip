package angela.util;

import java.util.ArrayList;

import angela.task.Task;

/**
 * Represents a helper program to read from and write to interface
 */
public class Ui {

    /**
     * Initialize an Ui interface
     */
    public Ui() {
        startChat();
    }

    /**
     * Prints out the welcoming text when user initialize the bot
     */
    public String startChat() {
        return TypicalString.HELLO + "\n" + " What can I do for you?";
    }

    /**
     * Prints out the goodbye text when user end the bot
     */
    public String endChat() {
        return TypicalString.GOODBYE.toString();
    }

    /**
     * Prints out all the task in the current list
     *
     * @param storingList Current task list
     */
    public String showTaskList(ArrayList<Task> storingList) {
        StringBuilder reply = new StringBuilder(" Here are the tasks in your list:");

        for (int i = 1; i <= storingList.size(); i++) {
            reply.append("\n");
            reply.append(" ").append(i).append(".").append(storingList.get(i - 1));
        }
        return reply.toString();
    }

    /**
     * Prints out the response based on changing state of the task
     *
     * @param task   Task that changing state
     * @param isDone State of the task
     */
    public String showTaskMark(Task task, boolean isDone) {
        return task.changeTaskStatus(isDone);
    }

    /**
     * Prints out the task and total number of tasks after adding
     *
     * @param task    Task that just been added in
     * @param numTask Number of tasks after adding
     */
    public String showAllTask(Task task, int numTask) {
        String reply = TypicalString.ADDED_TASK + "\n";
        reply += "  " + task + "\n";
        reply += " Now you have " + numTask + " tasks in the list.";
        return reply;
    }

    /**
     * Prints out the task that been deleted and the number of tasks afterwards
     *
     * @param task    Task that just been deleted
     * @param numTask Number of tasks left
     */
    public String showDeleteTask(Task task, int numTask) {
        String reply = " Noted. I've removed this task: " + "\n";
        reply += "  " + task + "\n";
        reply += " Now you have " + numTask + " tasks in the list.";
        return reply;
    }

    /**
     * Prints out the list of tasks in a specific date
     *
     * @param eventList Collection of tasks on the date
     */
    public String showDate(ArrayList<Task> eventList) {
        StringBuilder reply = new StringBuilder("You have " + eventList.size()
                + " deadlines/events in the day:");

        for (int i = 1; i <= eventList.size(); i++) {
            reply.append("\n");
            reply.append(i).append(".").append(eventList.get(i - 1));
        }
        return reply.toString();
    }

    /**
     * Prints results that match with the keyword
     *
     * @param numIndex        Current number of task that match with the keyword
     * @param task            Task that been matched with keyword
     */
    public String showSearchResult(int numIndex, Task task) {
        String reply = "";
        if (numIndex == 1) {
            reply += TypicalString.MATCH_TASK;
        }
        reply += " " + numIndex + "." + task + "\n";
        return reply;
    }

    /**
     * Prints out the error message when loading the bot
     */
    public String showLoadingError() {
        return " Sorry, some problem have occurred during initialization: ";
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
        },
        MATCH_TASK {
            public String toString() {
                return " Here are the matching tasks in your list:" + "\n";
            }
        }
    }
}
