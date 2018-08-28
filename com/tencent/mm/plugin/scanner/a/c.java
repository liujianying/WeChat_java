package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends l implements k {
    public b diG;
    private e diJ;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        a aVar = new a();
        aVar.dIG = new ib();
        aVar.dIH = new ic();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.dIF = 1068;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ib ibVar = (ib) this.diG.dID.dIL;
        ibVar.rem = str;
        ibVar.otY = i;
        ibVar.rjh = str2;
        ibVar.rjg = linkedList;
        ibVar.rjj = d2;
        ibVar.rji = d;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1068;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
