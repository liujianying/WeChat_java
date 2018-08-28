package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_ecard.a.1;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements e {
    final /* synthetic */ a pBp;
    final /* synthetic */ cn pBq;
    final /* synthetic */ String pBr;
    final /* synthetic */ 1 pBs;

    a$1$1(1 1, a aVar, cn cnVar, String str) {
        this.pBs = 1;
        this.pBp = aVar;
        this.pBq = cnVar;
        this.pBr = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(580, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.SubCoreECard", "jsapi check success");
            f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
            Context context = (Context) this.pBp.YC.get();
            if (context == null || !(context instanceof Activity)) {
                this.pBq.bJS.retCode = -1;
                this.pBq.bJR.bJX.run();
                return;
            }
            b.a(bi.getInt(this.pBq.bJR.bJW, 0), this.pBq.bJR.token, this.pBq.bJR.bJV, this.pBr, context, new 1(this));
            return;
        }
        x.e("MicroMsg.SubCoreECard", "jsapi check fail");
        this.pBq.bJS.retCode = -1;
        this.pBq.bJR.bJX.run();
    }
}
