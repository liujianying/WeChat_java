package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class DisasterUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ DisasterUI ePM;

    DisasterUI$2(DisasterUI disasterUI) {
        this.ePM = disasterUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(13939, new Object[]{Integer.valueOf(3)});
        x.i("MicroMsg.DisasterUI", "summerdiz back");
        this.ePM.finish();
        return true;
    }
}
