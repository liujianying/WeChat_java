package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class NearbyFriendsUI$13 implements OnClickListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$13(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onClick(View view) {
        c.a(NearbyFriendsUI.k(this.lCf));
    }
}
