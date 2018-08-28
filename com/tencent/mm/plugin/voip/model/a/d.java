package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bzx;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends n<bzx, bzy> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        a aVar = new a();
        aVar.dIG = new bzx();
        aVar.dIH = new bzy();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        aVar.dIF = 249;
        aVar.dII = 249;
        aVar.dIJ = 1000000249;
        this.diG = aVar.KT();
        bzx bzx = (bzx) this.diG.dID.dIL;
        bzx.rxG = i;
        bzx.rxH = j;
        bzx.seq = i2;
        bzx.svM = i3;
        bzx.svN = i4;
        bzx.svO = i5;
        bzx.svP = i6;
        bzx.svQ = 1;
        bzx.rfy = new bhy().S(bArr, i7);
    }

    public final int getType() {
        return 249;
    }

    public final void dP(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bzy) bLq()) != null) {
                x.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[]{Integer.valueOf(((bzy) bLq()).rxG), Long.valueOf(((bzy) bLq()).rxH), Integer.valueOf(((bzy) bLq()).seq)});
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    }

    public final e bLm() {
        return new 1(this);
    }
}
