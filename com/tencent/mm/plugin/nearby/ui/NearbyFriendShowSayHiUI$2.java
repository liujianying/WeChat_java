package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyFriendShowSayHiUI$2 implements OnClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI lBM;

    NearbyFriendShowSayHiUI$2(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.lBM = nearbyFriendShowSayHiUI;
    }

    public final void onClick(View view) {
        this.lBM.startActivity(new Intent(this.lBM, NearbyFriendsUI.class));
    }
}
