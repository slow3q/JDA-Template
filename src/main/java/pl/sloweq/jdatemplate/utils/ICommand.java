package pl.sloweq.jdatemplate.utils;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public interface ICommand {

    SlashCommandData data();

    void execute(SlashCommandInteractionEvent event);
}
