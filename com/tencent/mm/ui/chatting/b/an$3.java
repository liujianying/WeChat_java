package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

class an$3 implements OnClickListener {
    final /* synthetic */ an tTe;
    final /* synthetic */ ArrayList tTf;

    an$3(an anVar, ArrayList arrayList) {
        this.tTe = anVar;
        this.tTf = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        an.a(this.tTe, this.tTf);
    }
}
