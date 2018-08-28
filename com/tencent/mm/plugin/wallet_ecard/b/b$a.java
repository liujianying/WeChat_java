package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$a extends g {
    final /* synthetic */ b pCf;

    public b$a(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        b.D(this.pCf).putString(a.pBI, str);
        b.E(this.pCf).putString(a.pBJ, str2);
        this.uXK.a(new t("", str, null), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Bundle bundle;
        if (lVar instanceof t) {
            t tVar = (t) lVar;
            if (i == 0 && i2 == 0) {
                bundle = new Bundle();
                if (tVar.pjz == null || !tVar.pjz.pnr) {
                    bundle.putBoolean(a.pBO, true);
                    this.pCf.a(this.fEY, 0, bundle);
                    return false;
                }
                String string = b.F(this.pCf).getString(a.pBI);
                String string2 = b.G(this.pCf).getString(a.pBJ);
                String str2 = tVar.pjz.lMV;
                b.H(this.pCf).putString(a.pBK, str2);
                this.uXK.jr(1985);
                this.uXK.a(new d(b.b(this.pCf), b.e(this.pCf), string, string2, str2, b.m(this.pCf), false), true);
                return false;
            }
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{tVar});
            h.b(this.fEY, b.d(this.fEY, str), "", false);
            return false;
        } else if (!(lVar instanceof d)) {
            return false;
        } else {
            this.uXK.js(1985);
            l lVar2 = (d) lVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{lVar2});
                h.b(this.fEY, b.d(this.fEY, str), "", false);
            } else if (lVar2.pBY.hwV == 0) {
                bundle = new Bundle();
                bundle.putBoolean(a.pBO, false);
                if (lVar2.pBY.rhf == null || bi.oW(lVar2.pBY.rhf.title)) {
                    x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                    bundle.putBoolean(a.pBN, true);
                    bundle.putString(a.pBL, lVar2.pBY.rhd);
                    bundle.putString(a.pBM, lVar2.pBY.saK);
                } else {
                    x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                    bundle.putBoolean(a.pBN, false);
                    b.I(this.pCf).putString(a.pBR, lVar2.pBY.rhf.title);
                }
                this.pCf.a(this.fEY, 0, bundle);
            } else if (!(b.a((WalletBaseUI) this.fEY, lVar2.pBY.rhe) || b.a((WalletBaseUI) this.fEY, lVar2, lVar2.hUm, lVar2.hUn, lVar2.pBY.hwV, lVar2.pBY.hwW))) {
                h.b(this.fEY, b.d(this.fEY, lVar2.pBY.hwW, lVar2.hUn, str), "", false);
            }
            return true;
        }
    }
}
