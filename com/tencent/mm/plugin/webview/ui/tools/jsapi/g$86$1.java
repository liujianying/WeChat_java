package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.86;

class g$86$1 implements OnClickListener {
    final /* synthetic */ 86 qjN;

    g$86$1(86 86) {
        this.qjN = 86;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.j(this.qjN.qiK).startActivity(new Intent("android.settings.NFC_SETTINGS"));
        g.a(this.qjN.qiK, this.qjN.qiH, "nfcCheckState:nfc_off", null);
    }
}
