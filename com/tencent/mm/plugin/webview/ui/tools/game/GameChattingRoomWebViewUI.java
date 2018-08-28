package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private String jumpUrl = "";
    private int qfF = 4;
    private int qfG = 5;
    final a qfH = new 1(this);
    final a qfI = new 2(this);

    protected final boolean Du(String str) {
        return true;
    }

    protected final void Ro(String str) {
        x.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[]{str});
        this.jumpUrl = str;
        String stringExtra = getIntent().getStringExtra("action");
        if (stringExtra != null) {
            String string;
            if (getIntent().getStringExtra("app_name") == null) {
                string = getString(R.l.app_back);
            } else {
                string = getString(R.l.confirm_dialog_back_app, new Object[]{r1});
            }
            String string2 = getString(R.l.confirm_dialog_stay_in_weixin);
            if (stringExtra.equals("action_create")) {
                g.a(this.mController, getString(R.l.created_chatroom), string, string2, this.qfH, this.qfI);
            } else if (stringExtra.equals("action_join")) {
                g.a(this.mController, getString(R.l.joined_chatroom), string, string2, this.qfH, this.qfI);
            }
        }
    }
}
