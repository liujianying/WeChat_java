package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$2 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$2(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void run() {
        if (ExdeviceAddDataSourceUI.f(this.iAm) != null && ExdeviceAddDataSourceUI.f(this.iAm).isShowing()) {
            ExdeviceAddDataSourceUI.f(this.iAm).dismiss();
        }
    }
}
