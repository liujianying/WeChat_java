package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.c;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$g extends g {
    final /* synthetic */ b pCf;

    public b$g(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final CharSequence ui(int i) {
        return this.fEY.getIntent().getStringExtra(a.pBM);
    }

    public final boolean s(Object... objArr) {
        l dVar;
        int i = b.s(this.pCf).getInt(a.pBC);
        String e = b.e(this.pCf);
        x.i("MicroMsg.OpenECardProcess", "bind action: %s", new Object[]{Integer.valueOf(i)});
        if (i == a.pBS) {
            dVar = new d(b.b(this.pCf), e, b.t(this.pCf).getString(a.pBF), b.u(this.pCf).getString(a.pBG), b.v(this.pCf).getString(a.pBH), b.m(this.pCf), true, true);
        } else {
            dVar = new d(b.b(this.pCf), e, b.w(this.pCf).getString(a.pBI), b.x(this.pCf).getString(a.pBJ), b.y(this.pCf).getString(a.pBK), b.m(this.pCf), false, true);
        }
        this.uXK.jr(1985);
        this.uXK.a(dVar, true);
        return true;
    }

    public final boolean m(Object... objArr) {
        b.z(this.pCf).getString("key_pwd1");
        String string = b.A(this.pCf).getString("key_verify_code");
        String e = b.e(this.pCf);
        int i = b.B(this.pCf).getInt(a.pBy);
        c cVar = new c(b.b(this.pCf), e, string, this.fEY.getIntent().getStringExtra(a.pBL), i);
        this.uXK.jr(1986);
        this.uXK.a(cVar, true, 3);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof c) {
            this.uXK.js(1986);
            c cVar = (c) lVar;
            if (i == 0 && i2 == 0) {
                if (cVar.pBX.hwV == 0) {
                    Bundle bundle = new Bundle();
                    if (!(cVar.pBX.rhf == null || bi.oW(cVar.pBX.rhf.title))) {
                        x.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[]{cVar.pBX.rhf.title});
                        b.C(this.pCf).putString(a.pBR, cVar.pBX.rhf.title);
                    }
                    this.pCf.a(this.fEY, 0, bundle);
                } else if (!b.a((WalletBaseUI) this.fEY, cVar.pBX.rhe)) {
                    h.b(this.fEY, b.d(this.fEY, new String[]{cVar.pBX.hwW, str}), "", false);
                }
            }
            return true;
        } else if (!(lVar instanceof d)) {
            return false;
        } else {
            this.uXK.js(1985);
            d dVar = (d) lVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{dVar});
                h.b(this.fEY, b.d(this.fEY, new String[]{str}), "", false);
            } else if (dVar.pBY.hwV == 0) {
                this.fEY.getIntent().putExtra(a.pBL, dVar.pBY.rhd);
            } else if (!(b.a((WalletBaseUI) this.fEY, dVar.pBY.rhe) || b.a((WalletBaseUI) this.fEY, dVar, dVar.hUm, dVar.hUn, dVar.pBY.hwV, dVar.pBY.hwW))) {
                h.b(this.fEY, b.d(this.fEY, new String[]{dVar.pBY.hwW, dVar.hUn, str}), "", false);
            }
            return true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.pCf.b(this.fEY, new Bundle());
        super.onActivityResult(i, i2, intent);
    }
}
