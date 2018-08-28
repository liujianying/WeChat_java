package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SDKOAuthUI$4 implements OnClickListener {
    final /* synthetic */ String dJG;
    final /* synthetic */ SDKOAuthUI pWs;

    SDKOAuthUI$4(SDKOAuthUI sDKOAuthUI, String str) {
        this.pWs = sDKOAuthUI;
        this.dJG = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SDKOAuthUI.b(this.pWs, this.dJG);
    }
}
