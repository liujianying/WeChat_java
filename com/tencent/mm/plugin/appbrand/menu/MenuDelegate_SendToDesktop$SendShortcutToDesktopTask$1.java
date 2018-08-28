package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.SendShortcutToDesktopTask;
import com.tencent.mm.plugin.report.service.h;

class MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$1 implements Runnable {
    final /* synthetic */ SendShortcutToDesktopTask gjr;
    final /* synthetic */ Context val$context;

    MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$1(SendShortcutToDesktopTask sendShortcutToDesktopTask, Context context) {
        this.gjr = sendShortcutToDesktopTask;
        this.val$context = context;
    }

    public final void run() {
        if (SendShortcutToDesktopTask.a(this.gjr, m.f(this.val$context, SendShortcutToDesktopTask.a(this.gjr), SendShortcutToDesktopTask.b(this.gjr)))) {
            h.mEJ.a(443, 1, 1, false);
        }
        SendShortcutToDesktopTask.c(this.gjr);
    }
}
