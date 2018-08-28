package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NearbyFriendsIntroUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendsIntroUI lBN;

    NearbyFriendsIntroUI$2(NearbyFriendsIntroUI nearbyFriendsIntroUI) {
        this.lBN = nearbyFriendsIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lBN.YC();
        this.lBN.finish();
        return true;
    }
}
