package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.h$a;

public class RemittanceUI extends RemittanceBaseUI {
    public final void brm() {
        if (brv()) {
            g.Ek();
            this.mzl = (String) g.Ei().DT().get(a.sVi, "");
            g.Ek();
            this.mzm = (String) g.Ei().DT().get(a.sVm, "");
            g.Ek();
            this.mzn = ((Integer) g.Ei().DT().get(a.sVn, Integer.valueOf(0))).intValue();
            if (bi.oW(this.mzl) || bi.oW(this.mzm)) {
                ae.a(true, null);
            } else {
                ae.a(false, null);
            }
            x.d("MicroMsg.RemittanceUI", "do before transfer");
            a(new e(this.cYO), false, false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.h(15386, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        jr(2783);
    }

    public void a(String str, String str2, String str3, fo foVar) {
        if (this.myP != null) {
            this.myP.i(3, new Object[]{Integer.valueOf(this.myU), Double.valueOf(this.myQ)});
        }
        int intExtra = getIntent().getIntExtra("pay_channel", -1);
        String str4 = "";
        if (!bi.G(new String[0])) {
            g.Ek();
            ab Ye = ((i) g.l(i.class)).FR().Ye(this.cYO);
            if (Ye != null) {
                str4 = Ye.BL();
            } else {
                x.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.cYO);
            }
        }
        if (bi.oW(str3)) {
            this.mzs = true;
        } else {
            this.mzs = false;
        }
        x.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", new Object[]{Integer.valueOf(intExtra)});
        l vVar = new v(this.myQ, "1", this.cYO, this.mzk, this.myU, this.fdx, str, str2, this.myV, intExtra, this.mzp, str3, this.myR, str4, this.mzk, foVar);
        vVar.dox = "RemittanceProcess";
        a(vVar, true, true);
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof e)) {
            return super.d(i, i2, str, lVar);
        }
        e eVar = (e) lVar;
        eVar.a(new 3(this, eVar)).b(new h$a() {
            public final void g(int i, int i2, String str, l lVar) {
                x.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
        }).c(new 1(this, eVar));
        return true;
    }

    public final void brp() {
        s.makeText(this.mController.tml, com.tencent.mm.plugin.wxpay.a.i.remittance_amount_lowest_limit, 0).show();
    }

    public void onDestroy() {
        super.onDestroy();
        js(2783);
    }

    public final void brs() {
        final sy syVar = new sy();
        syVar.cdO.buF = "7";
        syVar.bJX = new Runnable() {
            public final void run() {
                if (bi.oW(syVar.cdP.cdQ)) {
                    x.i("MicroMsg.RemittanceUI", "no bulletin data");
                } else {
                    com.tencent.mm.wallet_core.ui.e.a((TextView) RemittanceUI.this.findViewById(f.banner_tips), syVar.cdP.cdQ, syVar.cdP.content, syVar.cdP.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.sFg.m(syVar);
    }
}
