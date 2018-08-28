package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class BankRemitSelectPayeeUI$3 implements OnItemLongClickListener {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;

    BankRemitSelectPayeeUI$3(BankRemitSelectPayeeUI bankRemitSelectPayeeUI) {
        this.mwE = bankRemitSelectPayeeUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        BankRemitSelectPayeeUI.b(this.mwE).a(view, i, j, this.mwE, this.mwE);
        return true;
    }
}
