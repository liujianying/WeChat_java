package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.f;

class a$1 implements OnCancelListener {
    final /* synthetic */ f mLs;
    final /* synthetic */ a mMD;

    public a$1(a aVar, f fVar) {
        this.mMD = aVar;
        this.mLs = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.mMD.bsT();
        au.DF().c(this.mLs);
    }
}
