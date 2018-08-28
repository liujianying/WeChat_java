package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.10;

class ExdeviceAddDataSourceUI$10$1 implements OnClickListener {
    final /* synthetic */ 10 iAr;

    ExdeviceAddDataSourceUI$10$1(10 10) {
        this.iAr = 10;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.iAr.iAm.iAe.remove(this.iAr.iAq);
        this.iAr.iAm.iAd.aQ(this.iAr.iAm.iAe);
        this.iAr.iAm.iAd.notifyDataSetChanged();
    }
}
