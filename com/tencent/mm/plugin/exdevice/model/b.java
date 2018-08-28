package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
