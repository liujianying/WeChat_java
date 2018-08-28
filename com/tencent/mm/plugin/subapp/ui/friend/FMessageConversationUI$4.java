package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMWizardActivity;

class FMessageConversationUI$4 implements OnClickListener {
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$4(FMessageConversationUI fMessageConversationUI) {
        this.ose = fMessageConversationUI;
    }

    public final void onClick(View view) {
        au.HU();
        if (bi.oW((String) c.DT().get(6, null))) {
            Intent intent = new Intent(this.ose.mController.tml, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 5);
            MMWizardActivity.D(this.ose, intent);
            return;
        }
        this.ose.startActivity(new Intent(this.ose, MobileFriendUI.class));
    }
}
