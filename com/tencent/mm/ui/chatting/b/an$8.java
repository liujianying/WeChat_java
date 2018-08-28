package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelvideo.c;

class an$8 implements OnCancelListener {
    final /* synthetic */ c lbn;
    final /* synthetic */ an tTe;

    an$8(an anVar, c cVar) {
        this.tTe = anVar;
        this.lbn = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lbn.elt = null;
    }
}
