package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$11 implements OnClickListener {
    final /* synthetic */ e mMX;

    e$11(e eVar) {
        this.mMX = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(1, null);
        }
    }
}
