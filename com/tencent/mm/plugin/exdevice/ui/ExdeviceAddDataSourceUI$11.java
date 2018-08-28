package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$11 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$11(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.c(this.iAm).notifyDataSetChanged();
    }
}
