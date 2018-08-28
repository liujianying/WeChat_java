package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    protected final void brl() {
        a(new e(this.cYO), false, false);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        super.d(i, i2, str, lVar);
        if (lVar instanceof e) {
            this.myK = false;
        }
        if (i != 0 || i2 != 0 || !(lVar instanceof e)) {
            return false;
        }
        e eVar = (e) lVar;
        this.cYO = eVar.username;
        if (bi.oW(this.cYO)) {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.fdx);
            finish();
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("fee", eVar.hUL);
        intent.putExtra("desc", eVar.desc);
        intent.putExtra("scan_remittance_id", eVar.myc);
        intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.abZ(eVar.myb));
        g.Ek();
        if (((i) g.l(i.class)).FR().Yf(this.cYO) != null) {
            c(this.cYO, eVar.scene, intent);
        } else {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
            am.a.dBr.a(this.cYO, "", new 1(this, bi.VF(), eVar, intent));
        }
        return true;
    }

    protected final void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.fdx + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.setClass(this, PayURemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.fdx);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
