package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$c extends g {
    final /* synthetic */ b pCf;

    public b$c(b bVar, MMActivity mMActivity, i iVar) {
        this.pCf = bVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        if (((Integer) objArr[0]).intValue() == 1) {
            x.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
            int intValue = ((Integer) objArr[1]).intValue();
            String str = (String) objArr[2];
            this.uXK.jr(1958);
            this.uXK.a(new e(b.b(this.pCf), null, intValue, str), true);
        } else {
            x.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
            int intValue2 = ((Integer) objArr[1]).intValue();
            this.uXK.jr(1985);
            this.uXK.a(new d(b.b(this.pCf), b.e(this.pCf), intValue2), true);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Bundle bundle;
        if (lVar instanceof e) {
            this.uXK.js(1958);
            e eVar = (e) lVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{eVar});
                h.a(this.fEY, b.d(this.fEY, new String[]{str}), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b$c.this.pCf.b(b$c.this.fEY, null);
                    }
                });
            } else if (eVar.pCc.hwV == 0) {
                bundle = new Bundle();
                x.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[]{eVar.pCc.rhc});
                b.f(this.pCf).putString(a.pBA, eVar.pCc.rhc);
                x.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[]{eVar.token, Boolean.valueOf(eVar.pCc.saF), Boolean.valueOf(eVar.pCc.saG)});
                if (!bi.oW(eVar.token)) {
                    bundle.putBoolean(a.pBB, eVar.pCc.saF);
                }
                if (eVar.pCc.saG) {
                    bundle.putBoolean(a.pBQ, true);
                }
                bundle.putInt("key_ecard_proxy_action", 1);
                this.pCf.a(this.fEY, 0, bundle);
            } else if (!(b.a((WalletBaseUI) this.fEY, eVar.pCc.rhe) || b.a((WalletBaseUI) this.fEY, eVar, eVar.hUm, eVar.hUn, eVar.pCc.hwV, eVar.pCc.hwW))) {
                h.a(this.fEY, b.d(this.fEY, new String[]{eVar.pCc.hwW, eVar.hUn, str}), "", false, new 1(this));
            }
            this.fEY.finish();
            return true;
        } else if (!(lVar instanceof d)) {
            return false;
        } else {
            this.uXK.js(1985);
            d dVar = (d) lVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[]{dVar});
                h.a(this.fEY, b.d(this.fEY, new String[]{str}), "", false, new 4(this));
            } else if (dVar.pBY.hwV == 0) {
                b.g(this.pCf).putInt(a.pBC, a.pBS);
                b.h(this.pCf).putString(a.pBF, dVar.pBZ);
                b.i(this.pCf).putString(a.pBG, dVar.pCa);
                b.j(this.pCf).putString(a.pBH, dVar.pCb);
                bundle = new Bundle();
                if (dVar.pBY.rhf == null || bi.oW(dVar.pBY.rhf.title)) {
                    x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                    bundle.putBoolean(a.pBN, true);
                    bundle.putString(a.pBL, dVar.pBY.rhd);
                    bundle.putString(a.pBM, dVar.pBY.saK);
                } else {
                    x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                    bundle.putBoolean(a.pBN, false);
                    b.k(this.pCf).putString(a.pBR, dVar.pBY.rhf.title);
                }
                bundle.putInt("key_ecard_proxy_action", 2);
                this.pCf.a(this.fEY, 0, bundle);
            } else if (!(b.a((WalletBaseUI) this.fEY, dVar.pBY.rhe) || b.a((WalletBaseUI) this.fEY, dVar, dVar.hUm, dVar.hUn, dVar.pBY.hwV, dVar.pBY.hwW))) {
                h.a(this.fEY, b.d(this.fEY, new String[]{dVar.pBY.hwW, dVar.hUn, str}), "", false, new 3(this));
            }
            return true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        Bundle bundle = new Bundle();
        bundle.putInt("key_process_result_code", 0);
        this.pCf.b(this.fEY, bundle);
    }
}
