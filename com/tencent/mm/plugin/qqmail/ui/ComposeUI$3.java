package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ComposeUI$3 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$3(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        ComposeUI.j(this.mfs).getText().clear();
        ComposeUI.j(this.mfs).requestFocus();
    }
}
