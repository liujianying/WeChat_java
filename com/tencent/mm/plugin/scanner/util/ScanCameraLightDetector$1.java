package com.tencent.mm.plugin.scanner.util;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ScanCameraLightDetector$1 extends ag {
    final /* synthetic */ ScanCameraLightDetector mNC;

    public ScanCameraLightDetector$1(ScanCameraLightDetector scanCameraLightDetector, Looper looper) {
        this.mNC = scanCameraLightDetector;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 233) {
            a aVar = (a) message.obj;
            if (aVar != null) {
                long VG = bi.VG();
                x.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[]{Boolean.valueOf(ScanCameraLightDetector.r(aVar.lho, aVar.width, aVar.height)), Float.valueOf(ScanCameraLightDetector.a(this.mNC)), Long.valueOf(bi.bI(VG))});
                if (ScanCameraLightDetector.r(aVar.lho, aVar.width, aVar.height)) {
                    x.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                    ah.A(new 1(this));
                    return;
                }
                x.i("MicroMsg.ScanCameraLightDetector", "not dark");
                ah.A(new 2(this));
            }
        }
    }
}
