package com.tencent.mm.u.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e doG;
    private a<b> doI;

    public b(String str, LinkedList<String> linkedList, int i, int i2, int i3, a<b> aVar) {
        this(str, linkedList, i, i2, i3);
        this.doI = aVar;
    }

    public b(String str, LinkedList<String> linkedList, int i, a<b> aVar) {
        this(str, linkedList, 0, i, -1, aVar);
    }

    private b(String str, LinkedList<String> linkedList, int i, int i2, int i3) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.dIG = new aor();
        aVar.dIH = new aos();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.dIF = 1158;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aor aor = (aor) this.diG.dID.dIL;
        if (i3 > 0) {
            aor.rRc = new chf();
            aor.rRc.scene = i3;
        }
        aor.jQb = str;
        aor.rQZ = linkedList;
        aor.rRb = i;
        aor.rRa = i2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.doI != null) {
            this.doI.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1158;
    }

    public final aos CV() {
        return (aos) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
