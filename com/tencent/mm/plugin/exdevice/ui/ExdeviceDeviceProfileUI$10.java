package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;

class ExdeviceDeviceProfileUI$10 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$10(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI, l lVar) {
        this.iCP = exdeviceDeviceProfileUI;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().b(536, this.iCP);
        cv cvVar = new cv();
        cvVar.bKm.opType = 2;
        cvVar.bKm.bKq = this.bFp;
        a.sFg.m(cvVar);
    }
}
