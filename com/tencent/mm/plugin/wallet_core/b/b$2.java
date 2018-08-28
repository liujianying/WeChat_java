package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$2 extends g {
    final /* synthetic */ b piV;

    b$2(b bVar, MMActivity mMActivity, i iVar) {
        this.piV = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof a) {
                b.a(this.piV).putString("kreq_token", ((a) lVar).token);
                if (this.piV.c(this.fEY, b.b(this.piV))) {
                    x.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                    this.uXK.a(new y(null, 12), false);
                    return true;
                }
                x.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                this.piV.a(this.fEY, 0, b.c(this.piV));
                return true;
            } else if (lVar instanceof y) {
                x.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                this.piV.a(this.fEY, 0, b.d(this.piV));
                return true;
            }
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        this.piV.y(new Object[]{"onNext", objArr});
        x.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
        Authen authen = (Authen) objArr[0];
        authen.bWA = b.e(this.piV);
        this.uXK.a(new a(authen), true, 1);
        return true;
    }
}
