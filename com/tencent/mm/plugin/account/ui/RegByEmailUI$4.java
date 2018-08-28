package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.c.a;

class RegByEmailUI$4 implements OnClickListener {
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$4(RegByEmailUI regByEmailUI) {
        this.eUG = regByEmailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eUG.finish();
        a.pU("L2_signup");
        Intent intent = new Intent(this.eUG, LoginPasswordUI.class);
        intent.putExtra("email_address", RegByEmailUI.g(this.eUG));
        this.eUG.startActivity(intent);
    }
}
