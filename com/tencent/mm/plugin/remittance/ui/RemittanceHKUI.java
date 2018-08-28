package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;

public class RemittanceHKUI extends RemittanceBaseUI {
    private int mCL;
    private String mCM;
    private String mCN;
    private String mCO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1529);
        jr(1257);
        this.mCL = getIntent().getIntExtra("hk_currency", 0);
        this.mCM = getIntent().getStringExtra("hk_currencyuint");
        this.mCN = getIntent().getStringExtra("hk_notice");
        this.mCO = getIntent().getStringExtra("hk_notice_url");
        this.hXD.setTitleText(this.mCM);
        this.mze.setText(this.mCM);
    }

    public void onDestroy() {
        super.onDestroy();
        js(1529);
        js(1257);
    }

    public final void brm() {
    }

    public final void a(String str, String str2, String str3, fo foVar) {
        x.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i = 0;
        if (this.myU == 33) {
            i = 1;
        }
        a(new q(Math.round(this.myQ * 100.0d), this.cYO, this.myS, this.mzh, this.cZG, this.myV, this.mCL, i), true, false);
    }

    public final void brp() {
        s.makeText(this.mController.tml, getString(i.remittance_os_amount_lowest_limit, new Object[]{this.mCM}), 0).show();
    }

    public final void brs() {
        if (!bi.oW(this.mCN)) {
            TextView textView = (TextView) findViewById(f.banner_tips);
            textView.setText(this.mCN);
            textView.setOnClickListener(new 1(this));
        }
    }

    public final void brn() {
        int i;
        x.d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.myU == 33) {
            i = 1;
        } else {
            i = 0;
        }
        a(new p(this.cYO, this.myV, this.mCL, ((long) this.myQ) * 100, i), false, false);
    }

    public final void b(int i, int i2, String str, l lVar, boolean z) {
        if (lVar instanceof q) {
            q qVar = (q) lVar;
            if (i != 0 || i2 != 0) {
                h.b(this.mController.tml, str, "", false);
                return;
            } else if (bi.oW(qVar.mxv)) {
                x.e("MicroMsg.RemittanceHKUI", "empty payurl");
                return;
            } else {
                e.r(this.mController.tml, qVar.mxv, 4);
                return;
            }
        }
        super.b(i, i2, str, lVar, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void brw() {
    }
}
