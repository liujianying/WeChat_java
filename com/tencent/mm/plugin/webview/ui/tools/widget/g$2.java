package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;

class g$2 implements OnClickListener {
    final /* synthetic */ Callback jJY;
    final /* synthetic */ String jJZ;
    final /* synthetic */ g qkF;

    g$2(g gVar, Callback callback, String str) {
        this.qkF = gVar;
        this.jJY = callback;
        this.jJZ = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jJY.invoke(this.jJZ, false, false);
    }
}
