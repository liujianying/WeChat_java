package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class NearbyFriendsUI$5 implements OnClickListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$5(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lCf.finish();
    }
}
