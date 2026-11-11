package pl.sloweq.jdatemplate;

import net.dv8tion.jda.api.JDABuilder;
import pl.sloweq.jdatemplate.listeners.Startup;
import pl.sloweq.jdatemplate.utils.CommandManager;

public final class Main {
    static void main(String[] args) {

        CommandManager commandManager = new CommandManager(

        );

        JDABuilder.createLight("TOKEN")
                .addEventListeners(
                        // Helper classes
                        new Startup(),
                        new CommandManager()
                        // Other Listeners
                )
                .build();
    }
}
