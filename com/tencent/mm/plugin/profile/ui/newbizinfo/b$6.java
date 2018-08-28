package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;

class b$6 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ b lYu;

    b$6(b bVar, l lVar) {
        this.lYu = bVar;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().b(536, this.lYu);
        cv cvVar = new cv();
        cvVar.bKm.opType = 2;
        cvVar.bKm.bKq = this.bFp;
        a.sFg.m(cvVar);
    }
}
