package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends l implements k {
    Map<String, String> dNV = new HashMap();
    public b diG;
    private e diJ;

    public p(LinkedList<ht> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ht htVar = (ht) it.next();
            String str = htVar.riE;
            String str2 = htVar.riK;
            if (!(str2 == null || str == null)) {
                this.dNV.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.dIG = new aaj();
        aVar.dIH = new aak();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.dIF = 1365;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((aaj) this.diG.dID.dIL).rFT = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1365;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        return a(eVar, this.diG, this);
    }
}
