package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.f;

class p$5 implements OnCancelListener {
    final /* synthetic */ p mLr;
    final /* synthetic */ f mLs;

    p$5(p pVar, f fVar) {
        this.mLr = pVar;
        this.mLs = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mLs);
        this.mLr.mKp.hu(false);
        this.mLr.mLh = false;
    }
}
