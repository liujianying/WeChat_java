package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class n$2 implements a {
    final /* synthetic */ n usU;

    n$2(n nVar) {
        this.usU = nVar;
    }

    public final boolean vD() {
        this.usU.usM++;
        x.v("MicroMsg.NetWarnView", "timer fired, percent:%d", new Object[]{Integer.valueOf(this.usU.usM)});
        if (this.usU.usM > 99) {
            return false;
        }
        if (this.usU.oDy == 1) {
            this.usU.eCm.setText(((Context) this.usU.qJS.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[]{Integer.valueOf(this.usU.usM)}));
        }
        return true;
    }
}
