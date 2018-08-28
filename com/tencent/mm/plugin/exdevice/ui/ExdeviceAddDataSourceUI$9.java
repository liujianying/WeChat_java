package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceAddDataSourceUI$9 implements Runnable {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$9(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final void run() {
        ExdeviceAddDataSourceUI.e(this.iAm).setVisibility(8);
        ExdeviceAddDataSourceUI.c(this.iAm).notifyDataSetChanged();
    }
}
