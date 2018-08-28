package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.1;
import com.tencent.mm.ui.MMWizardActivity;

class RegByMobileSetPwdUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 eVI;
    final /* synthetic */ Intent val$intent;

    RegByMobileSetPwdUI$1$1(1 1, Intent intent) {
        this.eVI = 1;
        this.val$intent = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MMWizardActivity.D(this.eVI.eVH, this.val$intent);
    }
}
