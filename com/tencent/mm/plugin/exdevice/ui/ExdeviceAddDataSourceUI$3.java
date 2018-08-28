package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ExdeviceAddDataSourceUI$3 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;
    final /* synthetic */ String iAn;

    ExdeviceAddDataSourceUI$3(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI, String str) {
        this.iAm = exdeviceAddDataSourceUI;
        this.iAn = str;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.a(this.iAm, h.a(this.iAm.mController.tml, this.iAm.getString(R.l.app_waiting), true, new 1(this)));
    }
}
