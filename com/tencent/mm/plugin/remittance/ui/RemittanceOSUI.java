package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements c {
    private com.tencent.mm.sdk.b.c kZG = new 1(this);
    private int mCR;
    private String mCS;
    private String mCT;
    private String mCU;
    private String mCV;
    private boolean mCW = false;

    public final void brm() {
    }

    public final void bro() {
        h.mEJ.h(13337, new Object[]{Integer.valueOf(2)});
    }

    public final void brp() {
        s.makeText(this.mController.tml, getString(i.remittance_os_amount_lowest_limit, new Object[]{this.mCS}), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.sFg.a(this.kZG);
        this.uYO.jr(1622);
        this.uYO.jr(1574);
        initView();
        this.hXD.setTitleText("");
        q.Kp().a(this);
        this.mCR = getIntent().getIntExtra("os_currency", 0);
        this.mCS = getIntent().getStringExtra("os_currencyuint");
        this.mCT = getIntent().getStringExtra("os_currencywording");
        this.mCU = getIntent().getStringExtra("os_notice");
        this.mCV = getIntent().getStringExtra("os_notice_url");
        this.hXD.setTitleText(this.mCS);
        brs();
    }

    public final void a(String str, String str2, String str3, fo foVar) {
        String GH = com.tencent.mm.model.q.GH();
        if (bi.oW(GH)) {
            GH = com.tencent.mm.model.q.GF();
        }
        g.Ek();
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(this.cYO);
        String str4 = this.cYO;
        if (((int) Yg.dhP) != 0) {
            str4 = Yg.BL();
        }
        aa aaVar = new aa(this.myQ, GH, this.cYO, str4, str, this.mCR);
        aaVar.dox = "RemittanceProcess";
        a(aaVar, true, true);
        h.mEJ.h(13337, new Object[]{Integer.valueOf(1), Double.valueOf(this.myQ)});
    }

    protected final void KB(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.mCW = true;
    }

    protected final void KC(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.mCW = true;
    }

    public final void brs() {
        if (bi.oW(this.mCU)) {
            x.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        } else {
            e.a((TextView) findViewById(a$f.banner_tips), "", this.mCU, this.mCV);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.kZG);
        q.Kp().b(this);
        this.uYO.js(1622);
        this.uYO.js(1574);
    }

    public final void jX(String str) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.cYO);
        this.mCW = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return a$g.remittance_new_ui;
    }

    public final void b(int i, int i2, String str, l lVar, boolean z) {
        super.b(i, i2, str, lVar, z);
        if (i == 0 && i2 == 0 && (lVar instanceof aa)) {
            int i3;
            final aa aaVar = (aa) lVar;
            boolean i32;
            if (aaVar.mxB <= 0) {
                i32 = false;
            } else if (aaVar.myD == 0) {
                com.tencent.mm.ui.base.h.a(this, getString(i.remittance_remind_desc_os, new Object[]{Integer.valueOf(aaVar.mxB)}), getString(i.app_remind), getString(i.remittance_continue), getString(i.remittance_open_order_history_action), new 2(this, aaVar), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceOSUI.this.KC(aaVar.myC);
                    }
                });
                i32 = 1;
            } else if (aaVar.myD == 1) {
                com.tencent.mm.ui.base.h.a(this, getString(i.remittance_remind_desc_os, new Object[]{Integer.valueOf(aaVar.mxB)}), getString(i.app_remind), getString(i.remittance_continue), getString(i.remittance_open_order_history_action), new 4(this, aaVar), new 5(this, aaVar));
                i32 = 1;
            } else {
                i32 = false;
            }
            if (i32 == 0) {
                String str2 = ((aa) lVar).mxv;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
    }
}
