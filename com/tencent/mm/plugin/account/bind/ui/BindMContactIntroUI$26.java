package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class BindMContactIntroUI$26 implements OnClickListener {
    final /* synthetic */ BindMContactIntroUI eGe;

    BindMContactIntroUI$26(BindMContactIntroUI bindMContactIntroUI) {
        this.eGe = bindMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MMWizardActivity.D(this.eGe, new Intent(this.eGe, BindMContactStatusUI.class));
    }
}
