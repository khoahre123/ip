package angela.util;


import angela.command.AddTaskCommand;
import angela.command.ByeCommand;
import angela.command.Command;
import angela.command.DeleteTaskCommand;
import angela.command.FindTaskCommand;
import angela.command.GetTaskFromDateCommand;
import angela.command.HelpCommand;
import angela.command.ShowListCommand;
import angela.command.UpdateMarkCommand;
import angela.command.WrongSyntaxCommand;

/**
 * Helps to parse the input command into the respective Command Object
 */
public class Parser {
    private static String botCommandWord = "";
    private static String description = "";

    public Parser() {
    }

    /**
     * Reads the input command and separates into different components
     *
     * @param command User input command
     */
    private static void readInput(String command) {
        botCommandWord = separateCommandWord(command);
        description = separateDescription(command);
    }

    /**
     * Returns the key command word from the input command
     *
     * @param command      The user input command
     * @return The key command word
     */
    private static String separateCommandWord(String command) {
        int commandIndex = command.indexOf(" ");
        if (commandIndex == -1) {
            return command;
        } else {
            return command.substring(0, commandIndex);
        }
    }

    /**
     * Returns the description from the input command
     *
     * @param command      The user input command
     * @return The description
     */
    private static String separateDescription(String command) {
        int commandIndex = command.indexOf(" ");
        if (commandIndex == -1) {
            return command;
        } else {
            return command.substring(commandIndex + 1);
        }
    }

    /**
     * Returns a specific Command Object base on the input command
     *
     * @param fullInput The user input command
     * @return Command Object that suitable for the input command
     */
    public static Command parse(String fullInput) {
        readInput(fullInput);
        switch (botCommandWord) {
        case "list":
            return new ShowListCommand();
        case "mark":
            return new UpdateMarkCommand(description, true);
        case "unmark":
            return new UpdateMarkCommand(description, false);
        case "todo":
            return new AddTaskCommand(fullInput, description, "T");
        case "deadline":
            return new AddTaskCommand(fullInput, description, "D");
        case "event":
            return new AddTaskCommand(fullInput, description, "E");
        case "delete":
            return new DeleteTaskCommand(description);
        case "date":
            return new GetTaskFromDateCommand(description);
        case "bye":
            return new ByeCommand();
        case "find":
            return new FindTaskCommand(description);
        case "help":
            return new HelpCommand();
        default:
            return new WrongSyntaxCommand();
        }
    }
}
