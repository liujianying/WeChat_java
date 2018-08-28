package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ClearCacheUI$2 implements OnClickListener {
    final /* synthetic */ ClearCacheUI thq;

    ClearCacheUI$2(ClearCacheUI clearCacheUI) {
        this.thq = clearCacheUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.thq.finish();
    }
}
