package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.12;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class ExdeviceProfileUI$12$1 implements c {
    final /* synthetic */ 12 iEA;

    ExdeviceProfileUI$12$1(12 12) {
        this.iEA = 12;
    }

    public final void a(l lVar) {
        lVar.a(0, this.iEA.iEx.getString(R.l.exdevice_opt_menu_send_to_friend), R.k.bottomsheet_icon_transmit);
        lVar.a(1, this.iEA.iEx.getString(R.l.exdevice_opt_menu_share_to_timeline), R.k.bottomsheet_icon_moment);
    }
}
