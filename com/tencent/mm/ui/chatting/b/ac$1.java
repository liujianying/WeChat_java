package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class ac$1 implements OnCancelListener {
    final /* synthetic */ bd dAB;
    final /* synthetic */ t tRn;
    final /* synthetic */ ac tRo;

    ac$1(ac acVar, bd bdVar, t tVar) {
        this.tRo = acVar;
        this.dAB = bdVar;
        this.tRn = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[]{Long.valueOf(this.dAB.field_msgId)});
        au.DF().c(this.tRn);
    }
}
