package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class NearbyFriendsIntroUI$1 implements OnClickListener {
    final /* synthetic */ NearbyFriendsIntroUI lBN;

    NearbyFriendsIntroUI$1(NearbyFriendsIntroUI nearbyFriendsIntroUI) {
        this.lBN = nearbyFriendsIntroUI;
    }

    public final void onClick(View view) {
        if (NearbyFriendsIntroUI.a(this.lBN) == null) {
            NearbyFriendsIntroUI.a(this.lBN, h.a(this.lBN.mController.tml, this.lBN.getString(R.l.app_tip), NearbyFriendsIntroUI.b(this.lBN), new 1(this), null));
        } else {
            NearbyFriendsIntroUI.a(this.lBN).show();
        }
    }
}
