package com.tencent.mm.plugin.af.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.af.a.c.a;

class c$2 implements OnClickListener {
    final /* synthetic */ a mje;
    final /* synthetic */ Intent mjf;

    c$2(a aVar, Intent intent) {
        this.mje = aVar;
        this.mjf = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mje.getContext().startActivity(this.mjf);
    }
}
