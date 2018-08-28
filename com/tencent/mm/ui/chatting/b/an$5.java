package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.j;

class an$5 implements OnCancelListener {
    final /* synthetic */ an tTe;
    final /* synthetic */ j tTg;

    an$5(an anVar, j jVar) {
        this.tTe = anVar;
        this.tTg = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tTg.cbu();
    }
}
