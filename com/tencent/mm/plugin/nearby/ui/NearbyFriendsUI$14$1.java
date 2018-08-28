package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.14;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class NearbyFriendsUI$14$1 implements d {
    final /* synthetic */ 14 lCh;

    NearbyFriendsUI$14$1(14 14) {
        this.lCh = 14;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (i) {
            case 0:
                NearbyFriendsUI.a(this.lCh.lCf, 4);
                NearbyFriendsUI.t(this.lCh.lCf);
                au.HU();
                c.DT().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.lCh.lCf)));
                NearbyFriendsUI.u(this.lCh.lCf);
                return;
            case 1:
                NearbyFriendsUI.a(this.lCh.lCf, 3);
                NearbyFriendsUI.t(this.lCh.lCf);
                au.HU();
                c.DT().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.lCh.lCf)));
                NearbyFriendsUI.u(this.lCh.lCf);
                return;
            case 2:
                NearbyFriendsUI.a(this.lCh.lCf, 1);
                NearbyFriendsUI.t(this.lCh.lCf);
                au.HU();
                c.DT().set(16386, Integer.valueOf(NearbyFriendsUI.h(this.lCh.lCf)));
                NearbyFriendsUI.u(this.lCh.lCf);
                return;
            case 3:
                Intent intent = new Intent(this.lCh.lCf, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                this.lCh.lCf.startActivityForResult(intent, 2009);
                return;
            case 4:
                NearbyFriendsUI.b(this.lCh.lCf, new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", ""));
                au.DF().a(NearbyFriendsUI.v(this.lCh.lCf), 0);
                NearbyFriendsUI nearbyFriendsUI = this.lCh.lCf;
                Context context = this.lCh.lCf.mController.tml;
                this.lCh.lCf.getString(R.l.app_tip);
                NearbyFriendsUI.a(nearbyFriendsUI, h.a(context, this.lCh.lCf.getString(R.l.nearby_friend_clearing_location), true, new 1(this)));
                return;
            default:
                return;
        }
    }
}
