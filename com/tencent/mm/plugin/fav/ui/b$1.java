package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ch;

class b$1 implements OnClickListener {
    final /* synthetic */ ch iXT;

    b$1(ch chVar) {
        this.iXT = chVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            b.a(this.iXT);
        }
    }
}
