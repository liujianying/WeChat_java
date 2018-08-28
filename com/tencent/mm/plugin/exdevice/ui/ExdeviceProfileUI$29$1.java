package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.storage.ab;

class ExdeviceProfileUI$29$1 implements OnClickListener {
    final /* synthetic */ 29 iEG;

    ExdeviceProfileUI$29$1(29 29) {
        this.iEG = 29;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        au.HU();
        ab Yg = c.FR().Yg(ExdeviceProfileUI.u(this.iEG.iEx));
        d.kB(37);
        s.f(Yg);
        ExdeviceProfileUI.v(this.iEG.iEx).cht();
        if (ExdeviceProfileUI.d(this.iEG.iEx) != null) {
            ExdeviceProfileUI.d(this.iEG.iEx).show();
        }
    }
}
