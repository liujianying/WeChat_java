package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$13 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$13(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        if (RechargeUI.e(this.mqE).mpe) {
            RechargeUI.e(this.mqE).setInput(null);
            return;
        }
        this.mqE.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
    }
}
