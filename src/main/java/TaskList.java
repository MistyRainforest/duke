import java.util.ArrayList;

public class TaskList {

    static ArrayList<ListItem> lst = new ArrayList<>();
    private static String filename = "data/duke.txt";

    TaskList(String filepath) {
        TaskList.filename = filepath;

    }

    TaskList(ArrayList<ListItem> loadedList) {
        lst = loadedList;
    }

    /**
     * adds an item to the todoList
     * @param description of the list item
     * @param command type of item it is
     * @param date due date if any for the item
     * @return Output string for Duke to print
     */
    static String[] addToTodo(String description, String command, String date) {
        lst.add(new ListItem(description, command, date));

        String[] ret = {"Got it. I've added this task:", lst.get(lst.size() - 1).toString(),
                "Now you have " + lst.size() + " tasks in the list."};
        return ret;
    }

    /**
     * removes an item from list based off of index
     * @param index of the item to be removed
     * @return Output string for Duke to print
     */
    static String[] removeFromTodo(String index) {
        ListItem target = lst.get(Integer.parseInt(index) - 1);
        lst.remove(target);
        String[] ret = {"Noted. I've removed this task:", target.toString() ,
                ("Now you have " + lst.size() + " tasks in the list.")};
        return ret;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < TaskList.lst.size(); i++) {
            toReturn = toReturn.concat((i + 1) + "." + TaskList.lst.get(i).toString() + "\n     ");
        }
        if (TaskList.lst.size() < 1) {
            return "To do list is Empty :)";
        }
        return toReturn.substring(0, toReturn.length() - 6);
    }
}
