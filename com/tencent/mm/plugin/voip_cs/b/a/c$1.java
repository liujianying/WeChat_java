package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c oYa;

    c$1(c cVar) {
        this.oYa = cVar;
    }

    public final void s(byte[] bArr, int i) {
        if (i <= 0) {
            x.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
            return;
        }
        x.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
        x.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + b.bMv().kqx.recordCallback(bArr, i, 200));
    }

    public final void aN(int i, int i2) {
        x.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
