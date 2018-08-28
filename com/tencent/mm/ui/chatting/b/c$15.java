package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;

class c$15 implements OnClickListener {
    final /* synthetic */ c tOm;

    c$15(c cVar) {
        this.tOm = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.c(this.tOm).field_hadAlert = 1;
        d c = c.c(this.tOm);
        if (c != null) {
            c.field_brandFlag &= -5;
            f.g(c);
        }
        z.Nj().kT(this.tOm.bAG.getTalkerUserName());
    }
}
