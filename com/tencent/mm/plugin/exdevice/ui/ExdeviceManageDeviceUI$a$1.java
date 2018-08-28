package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class ExdeviceManageDeviceUI$a$1 implements d {
    final /* synthetic */ a iDr;

    ExdeviceManageDeviceUI$a$1(a aVar) {
        this.iDr = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int itemId = menuItem.getItemId();
        x.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[]{Integer.valueOf(itemId), Integer.valueOf(this.iDr.getCount())});
        if (itemId >= 0 && itemId < r1) {
            a.a(this.iDr, itemId);
            a.a(this.iDr, (b) a.a(this.iDr).get(itemId));
            this.iDr.notifyDataSetChanged();
        }
    }
}
