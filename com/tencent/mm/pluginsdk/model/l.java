package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends x {
    public String qyY;

    public l(String str, LinkedList<String> linkedList) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[]{str});
        this.qyY = str;
        a aVar = new a();
        aVar.dIG = new ajc();
        aVar.dIH = new ajd();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        aVar.dIF = 452;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        ajc ajc = (ajc) this.ivx.dID.dIL;
        ajc.jPc = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!bi.oW(str2)) {
                linkedList2.add(ab.oT(str2));
            }
        }
        ajc.rgF = linkedList2;
        ajc.rGU = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 != 0 || i3 != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final byte[] cbx() {
        try {
            return ((b) this.ivx.KV()).Ie();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            return null;
        }
    }

    public final void bg(byte[] bArr) {
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            return;
        }
        try {
            this.ivx.dIE.G(bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 14;
    }
}
