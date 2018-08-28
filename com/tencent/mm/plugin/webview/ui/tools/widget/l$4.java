package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.a;
import com.tencent.mm.sdk.platformtools.x;

class l$4 implements OnCancelListener {
    final /* synthetic */ a qln;
    final /* synthetic */ l qlo;

    l$4(l lVar, a aVar) {
        this.qlo = lVar;
        this.qln = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        this.qln.f(3, null);
    }
}
