package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.card.d.d.b;

class d$1 implements OnClickListener {
    final /* synthetic */ b hIF;
    final /* synthetic */ String htu;

    d$1(b bVar, String str) {
        this.hIF = bVar;
        this.htu = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.hIF.avQ();
    }
}
