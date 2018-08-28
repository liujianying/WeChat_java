package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbyFriendShowSayHiUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI lBM;

    NearbyFriendShowSayHiUI$1(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.lBM = nearbyFriendShowSayHiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lBM.YC();
        this.lBM.finish();
        return true;
    }
}
