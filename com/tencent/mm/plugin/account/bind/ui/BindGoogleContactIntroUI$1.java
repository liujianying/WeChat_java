package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class BindGoogleContactIntroUI$1 implements OnClickListener {
    final /* synthetic */ BindGoogleContactIntroUI eFc;

    BindGoogleContactIntroUI$1(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.eFc = bindGoogleContactIntroUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.eFc, BindGoogleContactUI.class);
        intent.putExtra("enter_scene", BindGoogleContactIntroUI.a(this.eFc));
        this.eFc.startActivity(intent);
    }
}
