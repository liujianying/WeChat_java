package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyFriendsUI$9 implements OnClickListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$9(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onClick(View view) {
        NearbyFriendsUI.k(this.lCf).removeHeaderView(NearbyFriendsUI.m(this.lCf));
        NearbyFriendsUI.n(this.lCf);
        Intent intent = new Intent(this.lCf, NearbySayHiListUI.class);
        intent.putExtra("k_say_hi_type", 2);
        intent.putExtra("show_clear_header", true);
        this.lCf.startActivityForResult(intent, 2009);
    }
}
