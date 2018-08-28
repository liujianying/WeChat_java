package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.a;

class RegSetInfoUI$24 implements OnClickListener {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$24(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.pU("R400_100_signup");
        Intent intent = new Intent(this.eWJ, LoginUI.class);
        intent.addFlags(67108864);
        this.eWJ.startActivity(intent);
        this.eWJ.finish();
    }
}
