package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.freewifi.m;

class FreeWifiFrontPageUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiFrontPageUI jnd;

    FreeWifiFrontPageUI$5(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.jnd = freeWifiFrontPageUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        m.dm(this.jnd);
    }
}
