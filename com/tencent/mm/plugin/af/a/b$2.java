package com.tencent.mm.plugin.af.a;

import com.tencent.mm.plugin.af.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$2 implements Runnable {
    final /* synthetic */ String miW;
    final /* synthetic */ a miX;
    final /* synthetic */ b miZ;

    public b$2(b bVar, String str, a aVar) {
        this.miZ = bVar;
        this.miW = str;
        this.miX = aVar;
    }

    public final void run() {
        b bVar = this.miZ;
        String str = this.miW;
        a aVar = this.miX;
        List<a> list = (List) bVar.miS.get(str);
        if (list != null) {
            for (a aVar2 : list) {
                if (aVar2 != null && aVar2 == aVar) {
                    list.remove(aVar2);
                    break;
                }
            }
        } else {
            x.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
        }
        if (list != null && list.isEmpty()) {
            bVar.miS.remove(str);
            bVar.dWH.remove(str);
            bVar.miT.remove(str);
            if (bVar.miU != null && bVar.miU.equals(str)) {
                a aVar3 = bVar.miV;
                x.i("MicroMsg.scanner.DecodeFile", "cancelled");
                aVar3.fE = true;
                bVar.miV = null;
            }
            bVar.bpp();
        }
    }
}
