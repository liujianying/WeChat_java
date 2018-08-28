package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.3;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.b;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.c;

class ExdeviceAddDataSourceUI$3$1 implements OnCancelListener {
    final /* synthetic */ 3 iAo;

    ExdeviceAddDataSourceUI$3$1(3 3) {
        this.iAo = 3;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(ExdeviceAddDataSourceUI.g(this.iAo.iAm));
        ExdeviceAddDataSourceUI.h(this.iAo.iAm);
        b Aq = ExdeviceAddDataSourceUI.c(this.iAo.iAm).Aq(this.iAo.iAn);
        if (Aq != null) {
            Aq.iAt = c.iAu;
        }
    }
}
