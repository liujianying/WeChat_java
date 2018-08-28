package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class MMAppMgr$11 implements OnClickListener {
    MMAppMgr$11() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.HU();
        c.DT().set(65, Integer.valueOf(5));
    }
}
