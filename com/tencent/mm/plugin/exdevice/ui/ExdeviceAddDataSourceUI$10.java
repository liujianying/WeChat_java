package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.b;
import com.tencent.mm.ui.base.h;

class ExdeviceAddDataSourceUI$10 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;
    final /* synthetic */ b iAq;

    ExdeviceAddDataSourceUI$10(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI, b bVar) {
        this.iAm = exdeviceAddDataSourceUI;
        this.iAq = bVar;
    }

    public final void run() {
        h.a(this.iAm, R.l.exdevice_connect_failed_tips, R.l.exdevice_connect_failed, R.l.exdevice_connect_failed_confirm, R.l.exdevice_connect_help, false, new 1(this), new 2(this)).show();
    }
}
