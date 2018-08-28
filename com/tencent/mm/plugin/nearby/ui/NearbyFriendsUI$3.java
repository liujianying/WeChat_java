package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class NearbyFriendsUI$3 implements OnCancelListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$3(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(NearbyFriendsUI.x(this.lCf));
    }
}
