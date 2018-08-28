package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.z.d;

class z$c$2 implements OnClickListener {
    final /* synthetic */ d pRy;

    public z$c$2(d dVar) {
        this.pRy = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pRy.goBack();
    }
}
