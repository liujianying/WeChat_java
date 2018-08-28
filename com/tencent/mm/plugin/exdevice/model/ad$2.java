package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class ad$2 implements Runnable {
    final /* synthetic */ ad iwz;

    ad$2(ad adVar) {
        this.iwz = adVar;
    }

    public final void run() {
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
        boolean hasSystemFeature2 = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
        if (hasSystemFeature && hasSystemFeature2) {
            h.mEJ.a(11891, "3", true, true);
        } else if (hasSystemFeature) {
            h.mEJ.a(11891, "1", true, true);
        } else if (hasSystemFeature2) {
            h.mEJ.a(11891, "2", true, true);
        }
        x.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", new Object[]{Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2)});
    }
}
