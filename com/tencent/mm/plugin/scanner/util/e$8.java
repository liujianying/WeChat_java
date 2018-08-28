package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.openim.b.e;

class e$8 implements OnCancelListener {
    final /* synthetic */ e mMX;
    final /* synthetic */ e mNa;

    e$8(e eVar, e eVar2) {
        this.mMX = eVar;
        this.mNa = eVar2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mNa);
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(1, null);
        }
    }
}
