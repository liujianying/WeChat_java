package com.tencent.mm.plugin.hce.ui;

import android.content.ComponentName;
import android.content.Intent;

class HCETransparentUI$6 implements Runnable {
    final /* synthetic */ HCETransparentUI kjt;
    final /* synthetic */ ComponentName kjv;

    HCETransparentUI$6(HCETransparentUI hCETransparentUI, ComponentName componentName) {
        this.kjt = hCETransparentUI;
        this.kjv = componentName;
    }

    public final void run() {
        HCETransparentUI.g(this.kjt);
        Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
        intent.putExtra("category", "payment");
        intent.putExtra("component", this.kjv);
        this.kjt.startActivityForResult(intent, 2);
    }
}
