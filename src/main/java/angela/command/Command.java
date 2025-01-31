package angela.command;

import java.io.IOException;
import java.util.ArrayList;

import angela.datetime.DateTable;
import angela.task.TaskList;
import angela.util.BotStorage;
import angela.util.Ui;

/**
 * Inherits by all the Command classes
 */
public abstract class Command {

    /**
     * Executes the behavior of the class
     *
     * @param taskList   Reference of the <code>TaskList</code> object
     * @param ui         Reference of the <code>Ui</code> object
     * @param botStorage Reference of the <code>BotStorage</code> object
     * @param dateTable  Reference of the <code>DateTable</code> object
     * @return The array string represent the display text
     * @throws IOException If an I/O error occur
     */
    public abstract ArrayList<String> execute(TaskList taskList, Ui ui,
            BotStorage botStorage, DateTable dateTable) throws IOException;

    /**
     * Checks if the command is the exit command
     *
     * @return True if this is an exit command and False otherwise
     */
    public abstract boolean isExit();
}
