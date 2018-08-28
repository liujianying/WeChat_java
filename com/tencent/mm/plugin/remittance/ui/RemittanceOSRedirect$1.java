package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceOSRedirect$1 implements a {
    final /* synthetic */ long hWz;
    final /* synthetic */ RemittanceOSRedirect mCQ;
    final /* synthetic */ Intent val$intent;

    RemittanceOSRedirect$1(RemittanceOSRedirect remittanceOSRedirect, long j, Intent intent) {
        this.mCQ = remittanceOSRedirect;
        this.hWz = j;
        this.val$intent = intent;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
            q.KJ().jO(str);
        } else {
            x.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
        }
        this.mCQ.startActivity(this.val$intent);
        this.mCQ.finish();
    }
}
