import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Duke{

    private static TaskList todoList = new TaskList();

    /**
     * Main driver class for Duke.
     *
     */
    public static void main(String[] args) {
        dukePrint("Hello! I'm Duke", "What can I do for you?");
        Scanner consoleScanner = new Scanner(System.in);
        String userCommand = "";
        String userInput;
        while (!userCommand.equals("exit")) {
            userInput = consoleScanner.nextLine();
            userCommand = userInput.split(" ",2)[0];
            switch(userCommand) {
                case "list":
                    dukePrint(todoList);
                    break;
                case "done":
                    ListItem target = todoList.lst.get(Integer.parseInt(userInput.split(" ", 2)[1]) - 1);
                    target.done();
                    dukePrint("Nice! I've marked this task as done:", "  " + target);
                    break;
                case "todo":
                case "event":
                case "deadline":
                    try {
                        addToTodo(userInput.split(" ", 2)[1], userCommand);
                    }
                    //try to catch more exceptions
                    catch (Exception e) {
                        dukePrint("☹ OOPS!!! The description of a " + userCommand + " cannot be empty.");
                    }
                    break;
                case "delete":
                    try {
                        removeFromTodo(userInput.split(" ", 2)[1]);
                    }
                    catch (Exception e) {
                        dukePrint("Nothing to delete");
                    }
                    break;
                default:
                    dukePrint("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

        }

        dukePrint("Bye. Hope to see you again soon!");
    }

    /**
     * Echos string.
     * @param echoedString targeted String to be echoed
     */
    private static void echo(String echoedString) {
        dukePrint(echoedString);
    }

    /**
     * Prints what Duke says in correct format.
     * @param texts any number of String arguments
     *              each prints on a new line.
     */

    private static void dukePrint(Object... texts) {
        System.out.println("    _____________________________");
        for (Object text : texts) {
            System.out.println("     " + text);
        }
        System.out.println("    _____________________________");

    }


    private static void addToTodo(String description, String command) {
        todoList.lst.add(new ListItem(description, command));
        dukePrint("Got it. I've added this task:" + "\n      " + todoList.lst.get(todoList.lst.size() - 1),
                "Now you have " + todoList.lst.size() + " tasks in the list.");
    }
    private static void removeFromTodo(String description) {
        ListItem target = todoList.lst.get(Integer.parseInt(description) - 1);
        todoList.lst.remove(target);
        dukePrint("Noted. I've removed this task:" + "\n      " + target,
                "Now you have " + todoList.lst.size() + " tasks in the list.");
    }

}
