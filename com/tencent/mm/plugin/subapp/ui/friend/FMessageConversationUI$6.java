package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.ui.MMWizardActivity;

class FMessageConversationUI$6 implements OnItemClickListener {
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$6(FMessageConversationUI fMessageConversationUI) {
        this.ose = fMessageConversationUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0) {
            return;
        }
        if (l.XC() != a.eKt) {
            Intent intent = new Intent(this.ose.mController.tml, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 5);
            MMWizardActivity.D(this.ose.mController.tml, intent);
            return;
        }
        this.ose.startActivity(new Intent(this.ose.mController.tml, MobileFriendUI.class));
    }
}
