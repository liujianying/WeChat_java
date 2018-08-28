package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMWizardActivity;

class MobileFriendUI$2 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$2(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.eIS.mController.tml, BindMContactIntroUI.class);
        intent.putExtra("key_upload_scene", 6);
        MMWizardActivity.D(this.eIS, intent);
    }
}
