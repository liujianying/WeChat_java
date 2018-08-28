package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public final b ejL;
    private e mbu;

    public c() {
        a aVar = new a();
        aVar.dIG = new ael();
        aVar.dIH = new aem();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        this.ejL = aVar.KT();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.mbu.a(i2, i3, str, this);
    }

    public final int getType() {
        return 630;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.mbu = eVar2;
        return a(eVar, this.ejL, this);
    }
}
