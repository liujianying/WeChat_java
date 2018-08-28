package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.c.a;

class RegByEmailUI$2 implements OnClickListener {
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$2(RegByEmailUI regByEmailUI) {
        this.eUG = regByEmailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.pU(RegByEmailUI.f(this.eUG));
        this.eUG.YC();
        this.eUG.finish();
    }
}
