package com.tencent.mm.plugin.wallet_ecard.b;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$d extends g {
    final /* synthetic */ b pCf;

    public b$d(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        ff ffVar = (ff) objArr[0];
        String string = b.l(this.pCf).getString(a.pBA, "");
        if (ffVar == null) {
            x.w("MicroMsg.OpenECardProcess", "empty bank item");
            return false;
        }
        this.uXK.jr(1985);
        this.uXK.a(new d(b.b(this.pCf), string, ffVar.rgc, ffVar.pjw, ffVar.lMV, b.m(this.pCf), true), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof d)) {
            return false;
        }
        this.uXK.js(1985);
        d dVar = (d) lVar;
        if (i != 0 || i2 != 0) {
            x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{dVar});
            h.b(this.fEY, b.d(this.fEY, new String[]{str}), "", false);
        } else if (dVar.pBY.hwV == 0) {
            b.n(this.pCf).putInt(a.pBC, a.pBS);
            b.o(this.pCf).putString(a.pBF, dVar.pBZ);
            b.p(this.pCf).putString(a.pBG, dVar.pCa);
            b.q(this.pCf).putString(a.pBH, dVar.pCb);
            Bundle bundle = new Bundle();
            if (dVar.pBY.rhf == null || bi.oW(dVar.pBY.rhf.title)) {
                x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                bundle.putBoolean(a.pBN, true);
                bundle.putString(a.pBL, dVar.pBY.rhd);
                bundle.putString(a.pBM, dVar.pBY.saK);
            } else {
                x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                bundle.putBoolean(a.pBN, false);
                b.r(this.pCf).putString(a.pBR, dVar.pBY.rhf.title);
            }
            this.pCf.a(this.fEY, 0, bundle);
        } else if (!(b.a((WalletBaseUI) this.fEY, dVar.pBY.rhe) || b.a((WalletBaseUI) this.fEY, dVar, dVar.hUm, dVar.hUn, dVar.pBY.hwV, dVar.pBY.hwW))) {
            h.b(this.fEY, b.d(this.fEY, new String[]{dVar.pBY.hwW, dVar.hUn, str}), "", false);
        }
        return true;
    }
}
