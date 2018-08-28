package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ComposeUI$7 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$7(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        ComposeUI.z(this.mfs).setVisibility(8);
        ComposeUI.A(this.mfs).setVisibility(0);
        ComposeUI.B(this.mfs).setVisibility(0);
        ComposeUI.z(this.mfs).post(new 1(this));
    }
}
