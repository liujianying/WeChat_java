package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqpinyin.voicerecoapi.c;

class e$1 implements a {
    final /* synthetic */ e eqC;

    e$1(e eVar) {
        this.eqC = eVar;
    }

    public final void s(byte[] bArr, int i) {
        int i2;
        x.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[]{Integer.valueOf(i)});
        c.a aVar = new c.a();
        short[] sArr = new short[(i / 2)];
        for (i2 = 0; i2 < i / 2; i2++) {
            sArr[i2] = (short) ((bArr[i2 * 2] & b.CTRL_BYTE) | (bArr[(i2 * 2) + 1] << 8));
        }
        if (this.eqC.eqA != null) {
            this.eqC.eqA.a(sArr, i / 2, aVar);
        }
        e.a(this.eqC, sArr, i / 2);
        if (this.eqC.eqz != null) {
            i2 = this.eqC.eqz.a(new g.a(bArr, i));
        } else {
            i2 = -1;
        }
        if (-1 == i2) {
            e.a(this.eqC);
            x.e("MicroMsg.SceneVoiceAddr", "write to file failed");
            return;
        }
        e eVar = this.eqC;
        eVar.equ = i2 + eVar.equ;
        if (this.eqC.equ > 3300 && !this.eqC.eqv) {
            x.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
            this.eqC.handler.sendEmptyMessage(0);
            this.eqC.eqv = true;
        }
        if (aVar.vgN == 2 || aVar.vgN == 3) {
            x.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.vgN);
            e.a(this.eqC);
        }
    }

    public final void aN(int i, int i2) {
    }
}
