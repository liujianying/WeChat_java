package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$1 implements Runnable {
    final /* synthetic */ long jEc;
    final /* synthetic */ MMSightEditUI llg;

    MMSightEditUI$1(MMSightEditUI mMSightEditUI, long j) {
        this.llg = mMSightEditUI;
        this.jEc = j;
    }

    public final void run() {
        x.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[]{Long.valueOf(bi.bI(this.jEc))});
        if (CaptureMMProxy.getInstance() != null) {
            q.fd(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        MMSightEditUI.a(this.llg);
    }
}
