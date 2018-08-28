package com.tencent.mm.plugin.account.security.ui;

import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

class MySafeDeviceListUI$4 implements b {
    final /* synthetic */ MySafeDeviceListUI eOK;
    final /* synthetic */ d eOM;

    MySafeDeviceListUI$4(MySafeDeviceListUI mySafeDeviceListUI, d dVar) {
        this.eOK = mySafeDeviceListUI;
        this.eOM = dVar;
    }

    public final boolean p(CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(this.eOM.field_name)) {
            return true;
        }
        if (trim.length() <= 0) {
            h.bA(this.eOK.mController.tml, this.eOK.getString(j.safe_device_edit_empty_tips));
            return false;
        }
        c cVar = new c(this.eOM.field_uid, trim, this.eOM.field_devicetype);
        g.DF().a(cVar, 0);
        if (MySafeDeviceListUI.c(this.eOK) != null) {
            MySafeDeviceListUI.c(this.eOK).dismiss();
        }
        MySafeDeviceListUI.a(this.eOK, h.a(this.eOK, a.af(this.eOK, j.app_waiting), true, new 1(this, cVar)));
        return true;
    }
}
