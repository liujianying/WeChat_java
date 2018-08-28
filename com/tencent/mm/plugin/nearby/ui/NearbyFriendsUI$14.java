package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

class NearbyFriendsUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$14(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.lCf, 1, false);
        dVar.ofq = new 1(this);
        dVar.ofp = new c() {
            public final void a(l lVar) {
                lVar.eR(-1, R.l.nearby_friend_location_findmm);
                lVar.eR(-1, R.l.nearby_friend_location_findgg);
                lVar.eR(-1, R.l.nearby_friend_location_findall);
                lVar.eR(-1, R.l.say_hi_list_lbs_title);
                lVar.eR(-1, R.l.nearby_friend_clear_location_exit);
            }
        };
        dVar.bXO();
        return true;
    }
}
