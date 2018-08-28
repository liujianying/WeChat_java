package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.85;

class g$85$1 implements OnClickListener {
    final /* synthetic */ 85 qjM;

    g$85$1(85 85) {
        this.qjM = 85;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.A(g.j(this.qjM.qiK), "setting", ".ui.setting.SettingsAboutSystemUI");
        g.a(this.qjM.qiK, this.qjM.qiH, "nfcCheckState:nfc_wechat_setting_off", null);
    }
}
