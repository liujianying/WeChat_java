package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMWizardActivity;

class BindQQUI$5 implements OnClickListener {
    final /* synthetic */ BindQQUI eHn;

    BindQQUI$5(BindQQUI bindQQUI) {
        this.eHn = bindQQUI;
    }

    public final void onClick(View view) {
        MMWizardActivity.D(this.eHn, new Intent(this.eHn, VerifyQQUI.class));
    }
}
