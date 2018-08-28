package com.tencent.mm.u.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends l implements k {
    private final b diG;
    private e doG;
    private a<c> doJ;

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3, a<c> aVar) {
        this(str, linkedList, i, str2, str3, i2, i3);
        this.doJ = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i, String str2, String str3, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.dIG = new aox();
        aVar.dIH = new aoy();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.dIF = 1029;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aox aox = (aox) this.diG.dID.dIL;
        aox.jQb = str;
        aox.rQZ = linkedList;
        aox.rRe = i;
        aox.jPK = str2;
        aox.rRf = str3;
        aox.rRb = i2;
        if (i3 > 0) {
            aox.rRc = new chf();
            aox.rRc.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.doJ != null) {
            this.doJ.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1029;
    }

    public final aoy CW() {
        return (aoy) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
