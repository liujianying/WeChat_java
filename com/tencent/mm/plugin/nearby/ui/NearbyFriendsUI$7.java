package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class NearbyFriendsUI$7 implements OnCancelListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$7(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lCf.dJO = true;
        g.vw(11);
        if (NearbyFriendsUI.b(this.lCf) != null) {
            au.DF().c(NearbyFriendsUI.b(this.lCf));
        }
        x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
        if (!NearbyFriendsUI.c(this.lCf)) {
            this.lCf.finish();
            x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
        }
    }
}
