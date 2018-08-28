package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.n.8;

class n$8$1 implements OnClickListener {
    final /* synthetic */ 8 usW;

    n$8$1(8 8) {
        this.usW = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.usW.usU.gYR.setVisibility(8);
            this.usW.usU.usT = true;
            ao.startSettingItent((Context) this.usW.usU.qJS.get(), this.usW.bpX);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
        }
    }
}
