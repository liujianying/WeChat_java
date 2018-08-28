package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class ModSafeDeviceNameUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ModSafeDeviceNameUI eOB;

    ModSafeDeviceNameUI$2(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.eOB = modSafeDeviceNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ModSafeDeviceNameUI.a(this.eOB, ModSafeDeviceNameUI.a(this.eOB).getText().toString());
        if (!bi.oW(ModSafeDeviceNameUI.b(this.eOB))) {
            this.eOB.YC();
            l cVar = new c(ModSafeDeviceNameUI.c(this.eOB), ModSafeDeviceNameUI.b(this.eOB), ModSafeDeviceNameUI.d(this.eOB));
            g.DF().a(cVar, 0);
            ModSafeDeviceNameUI.a(this.eOB, h.a(this.eOB, a.af(this.eOB, j.app_waiting), true, new 1(this, cVar)));
        }
        return true;
    }
}
