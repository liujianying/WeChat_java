package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends l implements k {
    Map<String, String> dNW = new HashMap();
    Object data;
    public b diG;
    private e diJ;

    public r(LinkedList<iw> linkedList, Object obj) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            iw iwVar = (iw) it.next();
            LinkedList linkedList2 = iwVar.rkj;
            String str = iwVar.riK;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.dNW.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.dIG = new aap();
        aVar.dIH = new aaq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.dIF = 1353;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((aap) this.diG.dID.dIL).rFV = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1353;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        return a(eVar, this.diG, this);
    }
}
