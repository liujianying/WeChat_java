package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearbyFriendShowSayHiUI$3 implements OnClickListener {
    final /* synthetic */ NearbyFriendShowSayHiUI lBM;

    NearbyFriendShowSayHiUI$3(NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI) {
        this.lBM = nearbyFriendShowSayHiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.lBM, NearbySayHiListUI.class);
        intent.putExtra("k_say_hi_type", 2);
        intent.putExtra("show_clear_header", true);
        this.lBM.startActivityForResult(intent, 2009);
    }
}
