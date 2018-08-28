package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class ExdeviceProfileUI$26$1 implements c {
    final /* synthetic */ 26 iEF;

    ExdeviceProfileUI$26$1(26 26) {
        this.iEF = 26;
    }

    public final void a(l lVar) {
        if (!bi.oW(this.iEF.iEx.ixv)) {
            lVar.e(5, this.iEF.iEx.getString(R.l.exdevice_profile_complain));
        }
        lVar.e(3, this.iEF.iEx.getString(R.l.exdevice_profile_add_black_list));
    }
}
