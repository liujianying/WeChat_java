package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

class NearbyFriendsIntroUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 lBO;

    NearbyFriendsIntroUI$1$1(1 1) {
        this.lBO = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        au.HU();
        c.DT().set(4103, Boolean.valueOf(true));
        au.HU();
        x DT = c.DT();
        if (NearbyFriendsIntroUI.c(this.lBO.lBN).isChecked()) {
            z = false;
        }
        DT.set(4104, Boolean.valueOf(z));
        bl ID = bl.ID();
        if (ID == null) {
            this.lBO.lBN.startActivity(new Intent(this.lBO.lBN, NearbyPersonalInfoUI.class));
        } else {
            String oV = bi.oV(ID.getProvince());
            bi.oV(ID.getCity());
            int a = bi.a(Integer.valueOf(ID.sex), 0);
            if (oV.equals("") || a == 0) {
                this.lBO.lBN.startActivity(new Intent(this.lBO.lBN, NearbyPersonalInfoUI.class));
            } else {
                this.lBO.lBN.startActivity(new Intent(this.lBO.lBN, NearbyFriendsUI.class));
            }
        }
        this.lBO.lBN.finish();
    }
}
