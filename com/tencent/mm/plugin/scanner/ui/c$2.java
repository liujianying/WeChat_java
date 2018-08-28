package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class c$2 implements OnKeyListener {
    final /* synthetic */ String mGV;
    final /* synthetic */ c mGW;

    c$2(c cVar, String str) {
        this.mGW = cVar;
        this.mGV = str;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        c.a(this.mGW, this.mGV);
        return true;
    }
}
