package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void l(long j, int i) {
        b Ak = ad.aHe().Ak(String.valueOf(j));
        if (Ak == null) {
            x.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Ak.field_deviceType).append(',');
        stringBuilder.append(Ak.field_deviceID).append(',');
        stringBuilder.append(i);
        h.mEJ.k(11232, stringBuilder.toString());
    }
}
