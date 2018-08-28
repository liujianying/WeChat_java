package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView mwt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.bank_remit_select_bank_title);
        jr(1399);
        initView();
        x.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        h hVar = new h();
        hVar.m(this);
        a(hVar, true, true);
    }

    protected final void initView() {
        this.mwt = (BankRemitSortView) findViewById(f.brsb_sort_view);
        this.mwt.setOnItemClickListener(new 1(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof h) {
            h hVar = (h) lVar;
            hVar.a(new 4(this, hVar)).b(new 3(this, hVar)).c(new 2(this, hVar));
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.bank_remit_select_bank_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1399);
    }
}
