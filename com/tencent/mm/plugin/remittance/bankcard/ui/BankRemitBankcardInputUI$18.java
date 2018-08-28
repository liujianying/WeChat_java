package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$18 implements OnItemClickListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$18(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", new Object[]{Integer.valueOf(i)});
        BankRemitBankcardInputUI.a(this.mve, false);
        BankRemitBankcardInputUI.a(this.mve, (TransferRecordParcel) adapterView.getAdapter().getItem(i));
        BankRemitBankcardInputUI.E(this.mve);
        BankRemitBankcardInputUI.a(this.mve, BankRemitBankcardInputUI.F(this.mve).muA, BankRemitBankcardInputUI.A(this.mve), BankRemitBankcardInputUI.F(this.mve).lMV);
        ah.i(new 1(this), 500);
        BankRemitBankcardInputUI.f(this.mve).dismiss();
        this.mve.YC();
    }
}
