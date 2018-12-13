package com.denizenscript.ddiscordbot.events;

import net.aufdemrand.denizencore.events.ScriptEvent;
import net.aufdemrand.denizencore.objects.Element;
import net.aufdemrand.denizencore.objects.dObject;
import net.aufdemrand.denizencore.scripts.containers.ScriptContainer;
import net.aufdemrand.denizencore.utilities.CoreUtilities;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;

public class DiscordNewUserScriptEvent extends ScriptEvent {
    public static DiscordNewUserScriptEvent instance;

    // <--[event]
    // @Events
    // discord user joined (by <bot>)
    //
    // @Regex ^on discord user join(by [^\s]+)?$
    //
    // @Triggers when a Discord user joins a guild.
    //
    // @Plugin dDiscordBot
    //
    // @Context
    // <context.bot> returns the ID of the bot.
    // <context.group> returns the group ID.
    // <context.group_name> returns the group name.
    // <context.user_id> returns the author's internal ID.
    // <context.user_name> return's the author's name.
    //
    // -->

    @Override
    public boolean couldMatch(ScriptContainer scriptContainer, String s) {
        return CoreUtilities.toLowerCase(s).startsWith("discord user joined");
    }

    @Override
    public boolean matches(ScriptContainer scriptContainer, String s) {
        String lower = CoreUtilities.toLowerCase(s);
        if (lower.equals("discord user joined")) {
            return true;
        }
        else if (CoreUtilities.xthArgEquals(4, lower, botID)) {
            return true;
        }
        return false;
    }

    public String botID;

    public UserJoinEvent mre;

    @Override
    public dObject getContext(String name) {
        if (name.equals("bot")) {
            return new Element(botID);
        }
        else if (name.equals("group")) {
            return new Element(mre.getGuild().getLongID());
        }
        else if (name.equals("group_name")) {
            return new Element(mre.getGuild().getName());
        }
        else if (name.equals("user_id")) {
            return new Element(mre.getUser().getLongID());
        }
        else if (name.equals("user_name")) {
            return new Element(mre.getUser().getName());
        }
        return super.getContext(name);
    }

    @Override
    public String getName() {
        return "DiscordNewUser";
    }

    boolean enab = false;

    @Override
    public void init() {
        enab = true;
    }

    @Override
    public void destroy() {
        enab = false;
    }
}