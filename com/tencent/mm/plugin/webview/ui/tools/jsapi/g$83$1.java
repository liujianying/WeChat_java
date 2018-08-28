package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.83;
import com.tencent.mm.sdk.b.a;

class g$83$1 implements OnCancelListener {
    final /* synthetic */ 83 qjK;

    g$83$1(83 83) {
        this.qjK = 83;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        fi fiVar = new fi();
        fiVar.bNF.bNI = 3;
        a.sFg.m(fiVar);
        g.a(this.qjK.qiK, this.qjK.qiH, "translateVoice:fail", null);
    }
}
