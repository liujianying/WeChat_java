package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;

class c$1 implements OnClickListener {
    final /* synthetic */ d bAy;
    final /* synthetic */ c lVT;

    c$1(c cVar, d dVar) {
        this.lVT = cVar;
        this.bAy = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bAy.field_hadAlert = 1;
        this.bAy.field_brandFlag |= 4;
        this.lVT.a(this.bAy, true);
    }
}
