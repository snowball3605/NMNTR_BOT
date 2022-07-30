package com.snow.main.event;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class onready  extends ListenerAdapter {

    public static class Step {
        static int Step_1;
    }

    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("機械人由雪球製作");
        System.out.println("bot made by snowball");
        System.out.println("Copyright © 2022 NRTS SERVER");
        System.out.println("版權所有 © 2022 NRTS SERVER");
        System.out.println("--------------------------------");
        System.out.println("bot is ready");
    }
    }
