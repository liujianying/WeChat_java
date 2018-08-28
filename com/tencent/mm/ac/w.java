package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class w extends l implements k {
    public String dMD;
    public int dME;
    public b diG;
    private e diJ;
    public String tag;

    public w(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private w(String str, LinkedList<String> linkedList, byte b) {
        this.dME = 1;
        a aVar = new a();
        aVar.dIG = new apt();
        aVar.dIH = new apu();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.dIF = 675;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        apt apt = (apt) this.diG.dID.dIL;
        apt.rSp = str;
        apt.rSs = linkedList;
        this.dMD = str;
        this.dME = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 675;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        return a(eVar, this.diG, this);
    }

    public final apu MV() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (apu) this.diG.dIE.dIL;
    }
}
