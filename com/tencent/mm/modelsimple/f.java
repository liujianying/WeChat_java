package com.tencent.mm.modelsimple;

import com.tencent.mm.a.n;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.protocal.o$b;
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

public final class f extends l implements k {
    public byte[] content;
    private q dJM;
    private e diJ;
    public String eeZ = "";

    public f(List<String> list, byte[] bArr) {
        boolean z = true;
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.dJM = new a();
        a aVar = (a) this.dJM.KV();
        aVar.bOh = s$l.AppCompatTheme_switchStyle;
        aVar.bWA = 0;
        aVar.egS = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.qWM = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        aVar.qWN = bArr;
        x.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=" + currentTimeMillis);
        x.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + n.r(bArr, 0));
    }

    public f(com.tencent.mm.protocal.k.e eVar) {
        o$b o_b = (o$b) eVar;
        this.eeZ = o_b.eeZ;
        this.content = o_b.content;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 10;
    }

    public final boolean KX() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
