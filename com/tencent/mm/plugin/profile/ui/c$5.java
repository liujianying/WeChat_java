package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;

class c$5 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ c lVT;

    c$5(c cVar, l lVar) {
        this.lVT = cVar;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().b(536, this.lVT);
        cv cvVar = new cv();
        cvVar.bKm.opType = 2;
        cvVar.bKm.bKq = this.bFp;
        a.sFg.m(cvVar);
    }
}
