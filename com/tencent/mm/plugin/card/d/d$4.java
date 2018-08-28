package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.card.d.d.b;

class d$4 implements OnClickListener {
    final /* synthetic */ b hIF;

    d$4(b bVar) {
        this.hIF = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.hIF.ayM();
    }
}
