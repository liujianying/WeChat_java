package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.af.a.b.a;
import com.tencent.mm.sdk.platformtools.x;

class n$3 implements a {
    final /* synthetic */ n mGo;

    n$3(n nVar) {
        this.mGo = nVar;
    }

    public final void a(String str, String str2, byte[] bArr, int i, int i2) {
        x.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2), str});
        l.mFT.aXS();
        mu muVar = new mu();
        muVar.bXK.filePath = str;
        muVar.bXK.result = str2;
        muVar.bXK.bJr = i;
        muVar.bXK.bJs = i2;
        com.tencent.mm.sdk.b.a.sFg.m(muVar);
    }

    public final void Kg(String str) {
        x.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[]{str});
        mt mtVar = new mt();
        mtVar.bXJ.filePath = str;
        com.tencent.mm.sdk.b.a.sFg.m(mtVar);
    }
}
