package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMWizardActivity;

class MobileFriendUI$7 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$7(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(View view) {
        MMWizardActivity.D(this.eIS, new Intent(this.eIS, BindMContactIntroUI.class));
    }
}
