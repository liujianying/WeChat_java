package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class i$1 implements OnClickListener {
    final /* synthetic */ MobileInputUI eSB;
    final /* synthetic */ i eSC;

    i$1(i iVar, MobileInputUI mobileInputUI) {
        this.eSC = iVar;
        this.eSB = mobileInputUI;
    }

    public final void onClick(View view) {
        this.eSB.eRw[0] = 1;
        Intent intent = new Intent();
        intent.putExtra("from_switch_account", this.eSB.eSf);
        intent.setClass(this.eSB, LoginUI.class);
        this.eSB.startActivity(intent);
        this.eSB.finish();
    }
}
