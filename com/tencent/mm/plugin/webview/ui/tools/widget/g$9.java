package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.xweb.f;

class g$9 implements OnClickListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ g qkF;

    g$9(g gVar, f fVar) {
        this.qkF = gVar;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jKb.cancel();
    }
}
