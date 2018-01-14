package handlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import toDoObjects.IMainList;
import toDoObjects.MainList;
import view.IViewController;
import view.ViewController;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CommandHandlerTest {
    ICommandHandler commandHandler;
    IViewController viewController;
    IMainList mainList;

    @Before
    public void init() {
        mainList = new MainList();
        commandHandler = new CommandHandler();
        viewController = new ViewController();
        viewController.addToViewer(mainList);

    }

    @Test
    public void canHandCreateListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
    }

    @Test
    public void canHandOpenListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
    }

    @Test
    public void canHandCreateDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
    }

    @Test
    public void canHandRenameCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("rename 1 New name", viewController));
    }

    @Test
    public void canHandDeleteDealCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
        assertTrue(commandHandler.handleCommand("delete deal 1", viewController));
    }

    @Test
    public void canHandDeleteListCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("delete list 1", viewController));
    }

    @Test
    public void canHandExitCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("exit", viewController));
    }

    @Test
    public void canHandChangeCommand() {
        assertTrue(commandHandler.handleCommand("create list Test", viewController));
        assertTrue(commandHandler.handleCommand("open 1", viewController));
        assertTrue(commandHandler.handleCommand("create deal new deal", viewController));
        assertTrue(commandHandler.handleCommand("change status 1 completed", viewController));
        assertTrue(commandHandler.handleCommand("change status 1 process", viewController));
    }

}
