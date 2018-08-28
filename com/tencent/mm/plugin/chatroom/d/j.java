package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alf;
import com.tencent.mm.protocal.c.alg;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private final b diG;
    private e diJ = null;

    public final int getType() {
        return 339;
    }

    public j(String str) {
        a aVar = new a();
        aVar.dIG = new alf();
        aVar.dIH = new alg();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.dIF = 339;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((alf) this.diG.dID.dIL).jTu = str;
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            au.HU();
            int intValue = ((Integer) c.DT().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                au.HU();
                c.DT().set(135176, Integer.valueOf(intValue - 1));
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
