package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$8 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$8(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.c(this.iAm).aQ(ExdeviceAddDataSourceUI.d(this.iAm));
        ExdeviceAddDataSourceUI.c(this.iAm).notifyDataSetChanged();
    }
}
