package pl.sloweq.jdatemplate.listeners;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static pl.sloweq.jdatemplate.utils.LogUtil.log;

public class Startup extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        log.info(event.getJDA().getSelfUser().getName() + " is ready!");
        event.getJDA().updateCommands()
                .queue();
    }
}
