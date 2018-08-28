package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class a extends l implements k {
    private static final String TAG = TAG;
    public static final a mjn = new a((byte) 0);
    final b diG;
    private e diJ;

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        b.c.b.e.i(eVar, "dispatcher");
        b.c.b.e.i(eVar2, "callback");
        this.diJ = eVar2;
        return a(eVar, (q) this.diG, (k) this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        e eVar = this.diJ;
        if (eVar != null) {
            eVar.a(i2, i3, str, (l) this);
        }
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SOCKET_TIMEOUT;
    }
}
