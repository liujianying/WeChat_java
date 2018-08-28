package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.af.a.b.2;
import com.tencent.mm.plugin.af.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public c mGl = new 1(this);
    public c mGm = new 2(this);
    a mGn = new 3(this);

    public final boolean h(b bVar) {
        if (bVar != null) {
            if (bVar instanceof ms) {
                l.mFT.reset();
                l.mFT.vy(l.mFS);
                ms msVar = (ms) bVar;
                com.tencent.mm.plugin.scanner.c.brY().mFg.a(msVar.bXH.filePath, this.mGn, msVar.bXH.bXI);
            } else if (bVar instanceof ak) {
                l.mFT.aXS();
                ak akVar = (ak) bVar;
                com.tencent.mm.plugin.af.a.b bVar2 = com.tencent.mm.plugin.scanner.c.brY().mFg;
                String str = akVar.bHM.filePath;
                x.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(this.mGn.hashCode())});
                if (bi.oW(str)) {
                    x.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    bVar2.guJ.post(new 2(bVar2, str, r2));
                }
            }
        }
        return false;
    }
}
