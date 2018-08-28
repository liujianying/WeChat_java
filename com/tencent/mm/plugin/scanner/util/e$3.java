package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;

class e$3 implements OnCancelListener {
    final /* synthetic */ e mMX;
    final /* synthetic */ h mMY;

    e$3(e eVar, h hVar) {
        this.mMX = eVar;
        this.mMY = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mMY);
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(1, null);
        }
    }
}
