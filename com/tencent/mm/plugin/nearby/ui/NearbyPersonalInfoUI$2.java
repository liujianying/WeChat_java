package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.sdk.platformtools.bi;

class NearbyPersonalInfoUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyPersonalInfoUI lCt;

    NearbyPersonalInfoUI$2(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        this.lCt = nearbyPersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        bl IC;
        if (NearbyPersonalInfoUI.a(this.lCt) != -1) {
            IC = bl.IC();
            IC.sex = NearbyPersonalInfoUI.a(this.lCt);
            bl.a(IC);
        }
        IC = bl.ID();
        if (IC == null) {
            NearbyPersonalInfoUI.b(this.lCt);
        } else {
            String oV = bi.oV(IC.getProvince());
            bi.oV(IC.getCity());
            int i = IC.sex;
            if (bi.oW(oV) || i == 0) {
                NearbyPersonalInfoUI.b(this.lCt);
            } else {
                this.lCt.startActivity(new Intent(this.lCt, NearbyFriendsUI.class));
                bl IC2 = bl.IC();
                if (i != -1) {
                    IC2.sex = i;
                }
                au.HU();
                c.FQ().b(new a(1, bl.a(IC2)));
                this.lCt.finish();
            }
        }
        return true;
    }
}
