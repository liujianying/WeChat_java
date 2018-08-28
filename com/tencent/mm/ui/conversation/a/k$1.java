package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.be.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.LauncherUI;

class k$1 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$1(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        bc.Ig().ba(this.bpX, this.tiP);
        Context context = (Context) this.usq.qJS.get();
        if (context != null) {
            h.mEJ.h(11002, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
            au.HU();
            boolean d = bi.d((Boolean) c.DT().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (d) {
                bl ID = bl.ID();
                if (ID == null) {
                    d.A(context, "nearby", ".ui.NearbyPersonalInfoUI");
                    return;
                }
                String oV = bi.oV(ID.getProvince());
                int a = bi.a(Integer.valueOf(ID.sex), 0);
                if (bi.oW(oV) || a == 0) {
                    d.A(context, "nearby", ".ui.NearbyPersonalInfoUI");
                    return;
                }
                LauncherUI cpQ = LauncherUI.cpQ();
                if (cpQ != null) {
                    cpQ.tkn.tjF.ZS("tab_find_friend");
                }
                a.eF(context);
                return;
            }
            d.A(context, "nearby", ".ui.NearbyFriendsIntroUI");
        }
    }
}
