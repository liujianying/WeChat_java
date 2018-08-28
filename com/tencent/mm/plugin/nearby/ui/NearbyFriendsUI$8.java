package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.report.service.g;

class NearbyFriendsUI$8 implements a$a {
    final /* synthetic */ NearbyFriendsUI lCf;

    NearbyFriendsUI$8(NearbyFriendsUI nearbyFriendsUI) {
        this.lCf = nearbyFriendsUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (NearbyFriendsUI.d(this.lCf)) {
            return false;
        }
        NearbyFriendsUI.e(this.lCf);
        if (this.lCf.dJO) {
            if (NearbyFriendsUI.f(this.lCf) != null) {
                NearbyFriendsUI.f(this.lCf).dismiss();
                NearbyFriendsUI.a(this.lCf, null);
            }
            g.vw(11);
            return false;
        }
        if (z) {
            if (NearbyFriendsUI.f(this.lCf) != null) {
                NearbyFriendsUI.f(this.lCf).setMessage(this.lCf.getString(R.l.nearby_friend_finding));
            }
            NearbyFriendsUI.a(this.lCf, new NearbyFriendsUI$a(this.lCf, f2, f, (int) d2));
            e.RW().a(2001, i != 0, NearbyFriendsUI.g(this.lCf) == null ? false : NearbyFriendsUI.g(this.lCf).dSc, f, f2, (int) d2);
            NearbyFriendsUI.a(this.lCf, new c(NearbyFriendsUI.h(this.lCf), NearbyFriendsUI.i(this.lCf).dRT, NearbyFriendsUI.i(this.lCf).dRS, NearbyFriendsUI.i(this.lCf).accuracy, i, "", ""));
            au.DF().a(NearbyFriendsUI.b(this.lCf), 0);
        } else {
            g.vw(11);
            if (NearbyFriendsUI.f(this.lCf) != null) {
                NearbyFriendsUI.f(this.lCf).dismiss();
                NearbyFriendsUI.a(this.lCf, null);
            }
            NearbyFriendsUI.j(this.lCf);
            this.lCf.findViewById(R.h.nearby_friend_locate_failed).setVisibility(0);
            NearbyFriendsUI.k(this.lCf).setVisibility(8);
            NearbyFriendsUI.l(this.lCf);
        }
        return false;
    }
}
