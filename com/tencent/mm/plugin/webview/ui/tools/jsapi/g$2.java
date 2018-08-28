package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.webview.a.a;

class g$2 implements OnClickListener {
    final /* synthetic */ g qiK;

    g$2(g gVar) {
        this.qiK = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.ezn.h(new Intent(), g.j(this.qiK));
    }
}
