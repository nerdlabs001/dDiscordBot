package com.denizenscript.ddiscordbot.events;

import com.denizenscript.ddiscordbot.DiscordScriptEvent;
import net.aufdemrand.denizencore.scripts.containers.ScriptContainer;
import net.aufdemrand.denizencore.utilities.CoreUtilities;

public class DiscordUserJoinsScriptEvent extends DiscordScriptEvent {

    public static DiscordUserJoinsScriptEvent instance;

    // <--[event]
    // @Events
    // discord user joins
    //
    // @Regex ^on discord user join$
    // @Switch for <bot>
    //
    // @Triggers when a Discord user joins a guild.
    //
    // @Plugin dDiscordBot
    //
    // @Context
    // <context.bot> returns the Denizen ID of the bot.
    // <context.group> returns the group ID.
    // <context.group_name> returns the group name.
    // <context.user_id> returns the user's internal ID.
    // <context.user_name> returns the user's name.
    // <context.self> returns the bots own Discord user ID.
    // -->

    @Override
    public boolean couldMatch(ScriptContainer scriptContainer, String s) {
        return CoreUtilities.toLowerCase(s).startsWith("discord user joins");
    }

    @Override
    public String getName() {
        return "DiscordUserJoins";
    }
}
