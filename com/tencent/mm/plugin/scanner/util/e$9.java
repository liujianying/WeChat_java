package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;

class e$9 implements OnCancelListener {
    final /* synthetic */ h fGW;
    final /* synthetic */ e mMX;

    e$9(e eVar, h hVar) {
        this.mMX = eVar;
        this.fGW = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.fGW);
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(1, null);
        }
    }
}
