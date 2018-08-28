package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ak.o;

class g$9 implements OnCancelListener {
    final /* synthetic */ String dUT;
    final /* synthetic */ g qiK;

    g$9(g gVar, String str) {
        this.qiK = gVar;
        this.dUT = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        o.Pe().lF(this.dUT);
        g.a(this.qiK, g.k(this.qiK), "send_app_msg:cancel", null);
    }
}
