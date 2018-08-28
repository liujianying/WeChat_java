package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class MMAppMgr$10 implements OnClickListener {
    final /* synthetic */ int eaV;

    MMAppMgr$10(int i) {
        this.eaV = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.HU();
        c.DT().set(65, Integer.valueOf(this.eaV + 1));
    }
}
