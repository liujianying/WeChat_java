package com.tencent.mm.u.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends l implements k {
    private final b diG;
    private e doG;
    private a<d> doK;

    public d(String str, LinkedList<String> linkedList, String str2, int i, a<d> aVar) {
        this(str, linkedList, 0, str2, 0, i, -1, aVar);
    }

    public d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4, a<d> aVar) {
        this(str, linkedList, i, str2, i2, i3, i4);
        this.doK = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i, String str2, int i2, int i3, int i4) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        a aVar = new a();
        aVar.dIG = new aov();
        aVar.dIH = new aow();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.dIF = 1117;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aov aov = (aov) this.diG.dID.dIL;
        if (i4 > 0) {
            aov.rRc = new chf();
            aov.rRc.scene = i4;
        }
        aov.jQb = str;
        aov.rQZ = linkedList;
        aov.rRe = i;
        aov.rRf = str2;
        aov.rRb = i2;
        aov.rRa = i3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.doG != null) {
            this.doG.a(i2, i3, str, this);
        }
        if (this.doK != null) {
            this.doK.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1117;
    }

    public final aow CX() {
        return (aow) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
