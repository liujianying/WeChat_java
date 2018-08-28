package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class ComposeUI$23 implements OnFocusChangeListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$23(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ComposeUI.j(this.mfs).setSelection(ComposeUI.j(this.mfs).getText().length());
        }
    }
}
