package com.tencent.mm.plugin.wallet_ecard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_ecard.a.1.1;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.a;

class a$1$1$1 implements a {
    final /* synthetic */ 1 pBt;

    a$1$1$1(1 1) {
        this.pBt = 1;
    }

    public final Intent n(int i, Bundle bundle) {
        x.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[]{Integer.valueOf(i)});
        if (i == -1) {
            this.pBt.pBq.bJS.retCode = 0;
            h.mEJ.h(14954, new Object[]{f.cfF(), "openEcard:ok"});
        } else {
            this.pBt.pBq.bJS.retCode = -1;
            if (!f.cfE()) {
                h.mEJ.h(14954, new Object[]{f.cfF(), "openEcard:fail"});
            }
        }
        this.pBt.pBq.bJR.bJX.run();
        if (!f.cfE()) {
            f.cfG();
        }
        return null;
    }
}
