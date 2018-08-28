package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;

class c$14 implements OnClickListener {
    final /* synthetic */ c tOm;
    final /* synthetic */ boolean tOr;

    c$14(c cVar, boolean z) {
        this.tOm = cVar;
        this.tOr = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.c(this.tOm).field_hadAlert = 1;
        d c = c.c(this.tOm);
        if (c != null) {
            c.field_brandFlag |= 4;
            f.g(c);
        }
        if (this.tOr) {
            this.tOm.bAG.tTq.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            return;
        }
        z.Nj().kT(this.tOm.bAG.getTalkerUserName());
    }
}
