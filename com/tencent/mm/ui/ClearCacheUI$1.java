package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ClearCacheUI$1 implements OnClickListener {
    final /* synthetic */ long thp;
    final /* synthetic */ ClearCacheUI thq;

    ClearCacheUI$1(ClearCacheUI clearCacheUI, long j) {
        this.thq = clearCacheUI;
        this.thp = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ClearCacheUI.a(this.thq, this.thp);
        this.thq.finish();
    }
}
