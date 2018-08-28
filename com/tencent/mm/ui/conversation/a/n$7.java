package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class n$7 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ n usU;

    n$7(n nVar, int i) {
        this.usU = nVar;
        this.bpX = i;
    }

    public final void onClick(View view) {
        try {
            ao.startSettingItent((Context) this.usU.qJS.get(), this.bpX);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
        }
    }
}
