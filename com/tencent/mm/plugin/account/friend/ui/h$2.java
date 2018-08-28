package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ae;

class h$2 implements OnCancelListener {
    final /* synthetic */ h eNl;
    final /* synthetic */ ae eNm;

    h$2(h hVar, ae aeVar) {
        this.eNl = hVar;
        this.eNm = aeVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eNm);
        this.eNl.eNk.ck(false);
    }
}
