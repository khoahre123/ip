import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

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

    private static void addTask(ArrayList<TaskStorage> taskStorages, int numTask) {
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.ADDED_TASK);
        System.out.println("  " + taskStorages.get(taskStorages.size() - 1));
        System.out.println(" Now you have " + numTask +  " tasks in the list.");
        System.out.println(TypicalString.LONG_LINE);
    }

    private static boolean checkNumeric(String string) {
        return string.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        //String logo = " ____        _        \n"
        //        + "|  _ \\ _   _| | _____ \n"
        //        + "| | | | | | | |/ / _ \\\n"
        //        + "| |_| | |_| |   <  __/\n"
        //        + "|____/ \\__,_|_|\\_\\___|\n";
        //System.out.println("Hello from\n" + logo);
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.HELLO);
        System.out.println(" What can I do for you?");
        System.out.println(TypicalString.LONG_LINE);

        Scanner sc = new Scanner(System.in);
        String nextWord = sc.nextLine();
        int taskNumber = 0;
        ArrayList<TaskStorage> storingList = new ArrayList<>();
        BotException exception = new BotException();

        int commandIndex = nextWord.indexOf(" ");
        String commandWord;
        String restWord;
        if (commandIndex == -1) {
            commandWord = nextWord;
            restWord = nextWord;
        } else {
            commandWord = nextWord.substring(0, commandIndex);
            restWord = nextWord.substring(commandIndex + 1);
        }

        while (! nextWord.equals("bye")) {
            if (commandWord.equals("list")) {
                System.out.println(TypicalString.LONG_LINE);
                System.out.println(" Here are the tasks in your list:");
                for (int i = 1; i <= storingList.size(); i++) {
                    System.out.println(" " + i + "." + storingList.get(i - 1));
                }
                System.out.println(TypicalString.LONG_LINE);
            } else if (commandWord.equals("mark")) {
                if (! checkNumeric(restWord)) {
                    exception.notNumeric("mark");
                } else {
                    TaskStorage temp = storingList.get(Integer.parseInt(restWord) - 1);
                    temp.taskDone();
                    System.out.println(TypicalString.LONG_LINE);
                    System.out.println(" Nice! I've marked this task as done: ");
                    System.out.println("  " + temp);
                    System.out.println(TypicalString.LONG_LINE);
                }
            } else if (commandWord.equals("unmark")) {
                if (! checkNumeric(restWord)) {
                    exception.notNumeric("unmark");
                } else {
                    TaskStorage temp = storingList.get(Integer.parseInt(restWord) - 1);
                    temp.taskUndone();
                    System.out.println(TypicalString.LONG_LINE);
                    System.out.println(" OK, I've marked this task as not done yet: ");
                    System.out.println("  " + temp);
                    System.out.println(TypicalString.LONG_LINE);
                }
            } else if (commandWord.equals("todo")) {
                if (nextWord.length() == 4) {
                    exception.emptyDescription("todo");
                } else {
                    taskNumber += 1;
                    storingList.add(new TaskStorage(restWord, "T"));
                    addTask(storingList, taskNumber);
                }
            } else if (commandWord.equals("deadline")) {
                if (nextWord.length() == 8) {
                    exception.emptyDescription("deadline");
                } else {
                    taskNumber += 1;
                    storingList.add(new TaskStorage(restWord, "D"));
                    addTask(storingList, taskNumber);
                }
            } else if (commandWord.equals("event")) {
                if (nextWord.length() == 5) {
                    exception.emptyDescription("event");
                } else {
                    taskNumber += 1;
                    storingList.add(new TaskStorage(restWord, "E"));
                    addTask(storingList, taskNumber);
                }
            } else if (commandWord.equals("delete")) {
                if (! checkNumeric(restWord)) {
                    exception.notNumeric("delete");
                } else {
                    TaskStorage temp = storingList.remove( Integer.parseInt(restWord) - 1);
                    System.out.println(TypicalString.LONG_LINE);
                    System.out.println(" Noted. I've removed this task: ");
                    System.out.println("  " + temp);
                    taskNumber -= 1;
                    System.out.println(" Now you have " + taskNumber + " tasks in the list.");
                    System.out.println(TypicalString.LONG_LINE);
                }
            } else {
                exception.wrongSyntax();
            }
            nextWord = sc.nextLine();
            commandIndex = nextWord.indexOf(" ");
            if (commandIndex == -1) {
                commandWord = nextWord;
                restWord = nextWord;
            } else {
                commandWord = nextWord.substring(0, commandIndex);
                restWord = nextWord.substring(commandIndex + 1);
            }
        }
        System.out.println(TypicalString.LONG_LINE);
        System.out.println(TypicalString.GOODBYE);
        System.out.println(TypicalString.LONG_LINE);
    }
}
