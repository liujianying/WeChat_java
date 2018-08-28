package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ak.o;

class g$7 implements OnCancelListener {
    final /* synthetic */ String dUT;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$7(g gVar, String str, i iVar) {
        this.qiK = gVar;
        this.dUT = str;
        this.qiH = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        o.Pe().lF(this.dUT);
        g.a(this.qiK, this.qiH, "send_service_app_msg:fail", null);
    }
}
