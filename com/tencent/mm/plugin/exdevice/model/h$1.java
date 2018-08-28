package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.sdk.platformtools.x;

class h$1 extends a {
    final /* synthetic */ h ivb;

    h$1(h hVar) {
        this.ivb = hVar;
    }

    public final void a(int i, int i2, String str, String str2, String str3, int i3, byte[] bArr) {
        x.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Integer.valueOf(i3), b.aq(bArr)});
        if (1 == i) {
            ad.aHp().h(str3, str2, false);
        } else if (2 == i) {
            ad.aHp().h(str3, str2, true);
        } else {
            x.e(h.TAG, "unknown message type %d", new Object[]{Integer.valueOf(i)});
        }
        if (ad.aHe().cX(b.Az(str2)) != null) {
            x.d(h.TAG, "the founded device hasn't been binded");
        }
    }
}
