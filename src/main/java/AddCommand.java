import java.io.IOException;

public class AddCommand extends Command{
    private String description;
    private String fullInput;
    private String type;
    private final BotException exception = new BotException();

    public AddCommand(String fullInput, String description, String type) {
        this.description = description;
        this.fullInput = fullInput;
        this.type = type;
    }

    private void printTask(DateTable dateTable, Storage storage, Task task) throws IOException {
        if (!task.getType().equals("T")) {
            dateTable.addDate(task);
        }
        storage.addTaskToText(task);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage, DateTable dateTable)
            throws IOException {
        if (type.equals("T") && fullInput.length() == 4) {
            exception.emptyDescription("todo");
        } else if (type.equals("D") && fullInput.length() == 8) {
            exception.emptyDescription("deadline");
        } else if (type.equals("E") && fullInput.length() == 5) {
            exception.emptyDescription("event");
        } else {
            Task task = new Task(description, type);
            taskList.addTask(task);
            ui.showTask(task, taskList.getTotalTask());
            printTask(dateTable, storage, task);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
