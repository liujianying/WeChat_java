package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.g.a.rc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceAddDataSourceUI$7 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$7(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void run() {
        x.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
        a.sFg.m(new rc());
    }
}
