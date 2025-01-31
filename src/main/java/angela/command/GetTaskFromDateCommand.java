package angela.command;

import java.util.ArrayList;

import angela.datetime.DateTable;
import angela.task.TaskList;
import angela.util.BotStorage;
import angela.util.Ui;


/**
 * Extracts events on a specific date command
 */
public class GetTaskFromDateCommand extends angela.command.Command {
    private final String description;

    /**
     * Initializes a Get Task From Date Command
     *
     * @param description The date that we need to find task on
     */
    public GetTaskFromDateCommand(String description) {
        this.description = description;
    }

    /**
     * Extracts the events from the <code>DateTime</code> for a specific date
     * using command description
     *
     * @param taskList   Reference of the <code>TaskList</code> object
     * @param ui         Reference of the <code>Ui</code> object
     * @param botStorage Reference of the <code>BotStorage</code> object
     * @param dateTable  Reference of the <code>DateTable</code> object
     * @return The array string represent the display text
     */
    @Override
    public ArrayList<String> execute(TaskList taskList, Ui ui, BotStorage botStorage, DateTable dateTable) {
        return dateTable.getEventOnDate(description);
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
