package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.collect.b.s;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String cZG = "";
    private WalletFormView hXD;
    private TextView hXE;

    static /* synthetic */ void c(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        if (bi.oW(collectCreateQRCodeUI.cZG)) {
            collectCreateQRCodeUI.hXE.setTextColor(collectCreateQRCodeUI.getResources().getColor(a$c.link_color));
            collectCreateQRCodeUI.hXE.setText(i.collect_main_add_desc_title);
            return;
        }
        h hVar = new h(collectCreateQRCodeUI.mController.tml);
        String string = collectCreateQRCodeUI.getString(i.collect_main_add_desc_title_simple_change);
        CharSequence a = j.a(collectCreateQRCodeUI, collectCreateQRCodeUI.getString(i.collect_main_add_desc_title_changed, new Object[]{collectCreateQRCodeUI.cZG, string}));
        CharSequence spannableString = new SpannableString(a);
        spannableString.setSpan(hVar, a.length() - string.length(), a.length(), 33);
        collectCreateQRCodeUI.hXE.setTextColor(collectCreateQRCodeUI.getResources().getColor(a$c.hint_text_color));
        collectCreateQRCodeUI.hXE.setText(spannableString);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1335);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        js(1335);
    }

    protected final void initView() {
        setMMTitle(i.collect_create_qrcode_title);
        setBackBtn(new 1(this));
        this.hXD = (WalletFormView) findViewById(f.money_ev);
        a.f(this.hXD);
        CharSequence stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (bi.oW(stringExtra)) {
            this.hXD.getTitleTv().setText(v.cDm());
        } else {
            this.hXD.getTitleTv().setText(stringExtra);
        }
        this.hXD.a(new 2(this));
        d(this.hXD, 2, false);
        ((Button) findViewById(f.next_btn)).setOnClickListener(new 3(this));
        this.hXE = (TextView) findViewById(f.collect_main_add_desc);
        this.hXE.setOnClickListener(new 4(this));
    }

    protected final int getLayoutId() {
        return g.collect_create_qrcode;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Intent intent;
        if (lVar instanceof s) {
            if (i != 0 || i2 != 0) {
                return false;
            }
            s sVar = (s) lVar;
            intent = new Intent();
            intent.putExtra("ftf_pay_url", sVar.hUK);
            intent.putExtra("ftf_fixed_fee", sVar.hUL);
            intent.putExtra("ftf_fixed_fee_type", sVar.bJg);
            intent.putExtra("ftf_fixed_desc", sVar.desc);
            setResult(-1, intent);
            finish();
            return true;
        } else if (!(lVar instanceof m)) {
            return false;
        } else {
            m mVar = (m) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[]{mVar});
                return false;
            } else if (mVar.hUm == 0) {
                intent = new Intent();
                intent.putExtra("ftf_pay_url", mVar.hUo);
                intent.putExtra("ftf_fixed_fee", ((double) mVar.cfh) / 100.0d);
                intent.putExtra("ftf_fixed_desc", mVar.desc);
                intent.putExtra("key_currency_unit", mVar.hUx);
                setResult(-1, intent);
                finish();
                return true;
            } else if (mVar.hUp == 0) {
                com.tencent.mm.ui.base.h.b(this.mController.tml, mVar.hUn, mVar.hUq, false);
                return true;
            } else if (mVar.hUp != 1) {
                return false;
            } else {
                if (!(bi.oW(mVar.hUr) || bi.oW(mVar.hUs))) {
                    com.tencent.mm.ui.base.h.a(this.mController.tml, mVar.hUn, mVar.hUq, mVar.hUs, mVar.hUr, new 5(this, mVar), new 6(this));
                }
                return true;
            }
        }
    }
}
