package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.a.c;

class c$14 implements OnCancelListener {
    final /* synthetic */ c hpy;
    final /* synthetic */ c lVT;

    c$14(c cVar, c cVar2) {
        this.lVT = cVar;
        this.hpy = cVar2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hpy);
        au.DF().b(1394, this.lVT);
    }
}
