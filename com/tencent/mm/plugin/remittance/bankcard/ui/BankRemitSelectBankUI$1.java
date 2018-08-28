package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;

class BankRemitSelectBankUI$1 implements OnItemClickListener {
    final /* synthetic */ BankRemitSelectBankUI mwu;

    BankRemitSelectBankUI$1(BankRemitSelectBankUI bankRemitSelectBankUI) {
        this.mwu = bankRemitSelectBankUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        fg fgVar = (fg) ((d) adapterView.getAdapter().getItem(i)).data;
        if (fgVar != null) {
            BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(fgVar);
            Intent intent = new Intent();
            intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
            this.mwu.setResult(-1, intent);
            this.mwu.finish();
            return;
        }
        x.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[]{Integer.valueOf(i)});
    }
}
