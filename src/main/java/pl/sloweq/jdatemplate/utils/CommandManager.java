package pl.sloweq.jdatemplate.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public final class CommandManager extends ListenerAdapter {

    private Map<String, ICommand> commands = new HashMap<>();

    public CommandManager(ICommand... commands) {
        for (ICommand command : commands) {
            this.commands.put(command.data().getName(), command);
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().updateCommands()
                .addCommands(commands.values().stream().map(ICommand::data).toList())
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        ICommand command = commands.get(event.getName());
        if (command == null) {
            event.replyEmbeds(new EmbedBuilder().setColor(ColorUtil.RED).setDescription("Nieznana komenda.").build())
                    .setEphemeral(true)
                    .queue();
            return;
        }
        command.execute(event);
    }
}