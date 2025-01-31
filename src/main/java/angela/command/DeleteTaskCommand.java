package angela.command;

import java.io.IOException;
import java.util.ArrayList;

import angela.datetime.DateTable;
import angela.exception.BotException;
import angela.task.Task;
import angela.task.TaskList;
import angela.util.BotStorage;
import angela.util.NumericChecker;
import angela.util.Ui;

/**
 * Deletes a specific task
 */
public class DeleteTaskCommand extends angela.command.Command {
    private final String description;
    private final BotException exception = new BotException();

    public DeleteTaskCommand(String description) {
        this.description = description;
    }


    /**
     * Checks the description of the command and delete a specified task
     * from <code>TaskList</code> and database file
     *
     * @param taskList   Reference of the <code>TaskList</code> object
     * @param ui         Reference of the <code>Ui</code> object
     * @param botStorage Reference of the <code>BotStorage</code> object
     * @param dateTable  Reference of the <code>DateTable</code> object
     * @return The array string represent the display text
     * @throws IOException If an I/O error occur
     */
    @Override
    public ArrayList<String> execute(TaskList taskList, Ui ui, BotStorage botStorage, DateTable dateTable)
            throws IOException {
        if (NumericChecker.isNumeric(description)) {
            int taskNumber = Integer.parseInt(description);
            assert taskNumber > -1 : "Task number should be a positive integer";
            Task removeTask = taskList.removeTask(taskNumber);
            botStorage.deleteTask(taskNumber);
            dateTable.deleteTaskOnDate(removeTask);
            return ui.showDeleteTask(removeTask, taskList.getTotalTask());
        } else {
            return exception.printNotNumericError("delete");
        }
    }

    /**
     * Checks if the command is the exit command
     *
     * @return False as this is not an exit command
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
