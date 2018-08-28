package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;

class e$7 implements OnCancelListener {
    final /* synthetic */ f hkM;
    final /* synthetic */ e mMX;

    e$7(e eVar, f fVar) {
        this.mMX = eVar;
        this.hkM = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hkM);
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(1, null);
        }
    }
}
