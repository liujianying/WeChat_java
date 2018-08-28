package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c oYa;

    c$2(c cVar) {
        this.oYa = cVar;
    }

    public final int P(byte[] bArr, int i) {
        x.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
        int playCallback = b.bMv().kqx.playCallback(bArr, i);
        if (playCallback != 0) {
            x.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
        }
        return playCallback != 0 ? 1 : 0;
    }
}
