package com.tencent.mm.plugin.hce.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class HCETransparentUI$5 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ HCETransparentUI kjt;

    HCETransparentUI$5(HCETransparentUI hCETransparentUI, int i, String str) {
        this.kjt = hCETransparentUI;
        this.bFr = i;
        this.dJG = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HCETransparentUI.a(this.kjt, this.bFr, this.dJG);
    }
}
