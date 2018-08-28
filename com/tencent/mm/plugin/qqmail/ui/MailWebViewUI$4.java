package com.tencent.mm.plugin.qqmail.ui;

import android.webkit.ConsoleMessage;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.j;

class MailWebViewUI$4 extends j {
    final /* synthetic */ MailWebViewUI mhK;

    MailWebViewUI$4(MailWebViewUI mailWebViewUI) {
        this.mhK = mailWebViewUI;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String Ug = s.Ug(consoleMessage != null ? consoleMessage.message() : null);
        if (!Ug.startsWith("weixin://private/getcontentwidth/")) {
            return super.onConsoleMessage(consoleMessage);
        }
        x.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = " + Ug);
        MailWebViewUI.b(this.mhK, Ug);
        return true;
    }
}
