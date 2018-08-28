package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.smtt.sdk.WebView;

class l$5 implements OnCancelListener {
    final /* synthetic */ r eRC;
    final /* synthetic */ l eSI;

    l$5(l lVar, r rVar) {
        this.eSI = lVar;
        this.eRC = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRC);
        g.DF().b(WebView.NORMAL_MODE_ALPHA, this.eSI);
    }
}
