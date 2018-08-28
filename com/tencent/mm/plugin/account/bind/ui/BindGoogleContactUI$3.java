package com.tencent.mm.plugin.account.bind.ui;

import android.webkit.ConsoleMessage;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.j;

class BindGoogleContactUI$3 extends j {
    final /* synthetic */ BindGoogleContactUI eFm;

    BindGoogleContactUI$3(BindGoogleContactUI bindGoogleContactUI) {
        this.eFm = bindGoogleContactUI;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String Ug = s.Ug(consoleMessage != null ? consoleMessage.message() : null);
        if (!Ug.toLowerCase().startsWith("weixin://private/googlegetcode")) {
            return super.onConsoleMessage(consoleMessage);
        }
        BindGoogleContactUI.a(this.eFm, Ug);
        return true;
    }
}
