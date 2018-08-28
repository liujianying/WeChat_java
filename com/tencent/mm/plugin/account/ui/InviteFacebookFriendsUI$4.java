package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.account.ui.q.e;
import com.tencent.mm.ui.base.h;

class InviteFacebookFriendsUI$4 implements OnItemClickListener {
    final /* synthetic */ InviteFacebookFriendsUI eQB;

    InviteFacebookFriendsUI$4(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.eQB = inviteFacebookFriendsUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (InviteFacebookFriendsUI.a(this.eQB).Yx().length >= 50) {
            h.i(this.eQB, e.facebook_invitefriends_tips_max, e.app_tip);
            return;
        }
        InviteFacebookFriendsUI.a(this.eQB).jh(i - InviteFacebookFriendsUI.b(this.eQB).getHeaderViewsCount());
        if (InviteFacebookFriendsUI.a(this.eQB).Yx().length > 0) {
            this.eQB.showOptionMenu(true);
        } else {
            this.eQB.showOptionMenu(false);
        }
    }
}
