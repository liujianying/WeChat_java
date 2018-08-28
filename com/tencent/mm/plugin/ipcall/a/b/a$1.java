package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a kpZ;

    public a$1(a aVar) {
        this.kpZ = aVar;
    }

    public final int P(byte[] bArr, int i) {
        if (!this.kpZ.bTv) {
            return -1;
        }
        if (i.aXq().kqx.playCallback(bArr, i) >= 0) {
            return 0;
        }
        x.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", new Object[]{Integer.valueOf(i.aXq().kqx.playCallback(bArr, i))});
        return -1;
    }
}
