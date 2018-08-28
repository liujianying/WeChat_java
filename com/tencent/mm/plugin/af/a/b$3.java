package com.tencent.mm.plugin.af.a;

import com.tencent.mm.plugin.af.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$3 implements Runnable {
    final /* synthetic */ b miZ;
    final /* synthetic */ d mja;

    b$3(b bVar, d dVar) {
        this.miZ = bVar;
        this.mja = dVar;
    }

    public final void run() {
        b bVar = this.miZ;
        d dVar = this.mja;
        x.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[]{bVar.miU, dVar});
        List<a> list = (List) bVar.miS.get(bVar.miU);
        if (list != null && dVar != null) {
            x.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[]{Integer.valueOf(list.size())});
            for (a a : list) {
                a.a(bVar.miU, dVar.result, dVar.mjh, dVar.bJr, dVar.bJs);
            }
        } else if (list != null) {
            for (a a2 : list) {
                a2.Kg(bVar.miU);
            }
        }
        bVar.miS.remove(bVar.miU);
        bVar.miT.remove(bVar.miU);
        bVar.miU = null;
        bVar.miV = null;
        bVar.bpp();
    }
}
