package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class RegSetInfoUI$21 implements OnClickListener {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$21(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent;
        if (RegSetInfoUI.H(this.eWJ) == 2) {
            intent = new Intent(this.eWJ, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 2);
        } else {
            intent = new Intent(this.eWJ, RegByMobileRegAIOUI.class);
        }
        intent.addFlags(67108864);
        this.eWJ.startActivity(intent);
        this.eWJ.finish();
    }
}
