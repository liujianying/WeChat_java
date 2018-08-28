package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    public byte[] hax;
    private final String id;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new zt();
        aVar.dIH = new zu();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.dIF = 596;
        this.diG = aVar.KT();
        zt ztVar = (zt) this.diG.dID.dIL;
        ztVar.ID = str;
        ztVar.rFA = y.cgt().ver;
        this.id = str;
        x.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[]{ztVar.ID, Integer.valueOf(ztVar.rFA)});
    }

    public final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 596;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.hax = ((zu) this.diG.dIE.dIL).reV.siK.lR;
            String str2 = "MicroMsg.NetSceneGetBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.hax == null ? 0 : this.hax.length);
            x.i(str2, str3, objArr);
            if (this.hax != null) {
                str2 = "";
                for (byte b : this.hax) {
                    str2 = str2 + Integer.toHexString(b & 255) + " ";
                }
                x.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[]{str2});
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
