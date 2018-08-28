package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.chatroom.d.k;

class e$11 implements OnCancelListener {
    final /* synthetic */ k hMh;
    final /* synthetic */ e tOC;

    e$11(e eVar, k kVar) {
        this.tOC = eVar;
        this.hMh = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hMh);
    }
}
