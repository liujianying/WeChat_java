package com.tencent.mm.u.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a extends l implements k {
    private final b diG;
    private e doG;
    private a<a> doH;

    public interface a<T extends l> {
        void b(int i, int i2, String str, T t);
    }

    public a(String str, LinkedList<String> linkedList, a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i, int i2, a<a> aVar) {
        this(str, linkedList, i, i2);
        this.doH = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i, int i2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new aot();
        aVar.dIH = new aou();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.dIF = 1157;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aot aot = (aot) this.diG.dID.dIL;
        if (i2 > 0) {
            aot.rRc = new chf();
            aot.rRc.scene = i2;
        }
        aot.jQb = str;
        aot.rQZ = linkedList;
        aot.rRb = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.doH != null) {
            this.doH.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1157;
    }

    public final aou CU() {
        return (aou) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
