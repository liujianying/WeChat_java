package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$c;

class ExdeviceRankInfoUI$19 implements n$c {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$19(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void a(l lVar) {
        int i;
        if (x.getLogLevel() == 0) {
            i = 2;
        } else {
            i = g.AT().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
        }
        if (i == 2) {
            lVar.a(3, this.iFG.getString(R.l.exdevice_opt_menu_share_sport_appbrand), R.k.bottomsheet_icon_transmit);
        }
        lVar.a(0, this.iFG.getString(R.l.exdevice_opt_menu_send_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a(1, this.iFG.getString(R.l.exdevice_opt_menu_share_to_timeline), R.k.bottomsheet_icon_moment);
        lVar.a(2, this.iFG.getString(R.l.exdevice_opt_menu_donate), R.k.bottomsheet_icon_donate);
    }
}
