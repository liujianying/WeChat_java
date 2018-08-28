package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.xweb.f;

class g$3 implements OnClickListener {
    final /* synthetic */ f jKb;
    final /* synthetic */ g qkF;

    g$3(g gVar, f fVar) {
        this.qkF = gVar;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jKb.cancel();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.qkF.onClose();
    }
}
