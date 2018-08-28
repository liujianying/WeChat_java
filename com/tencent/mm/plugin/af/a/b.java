package com.tencent.mm.plugin.af.a;

import android.os.Looper;
import com.tencent.mm.plugin.af.a.a.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b implements a$a {
    public List<String> dWH = new LinkedList();
    public ag guJ = new ag(Looper.getMainLooper());
    public Map<String, List<a>> miS = new HashMap();
    public Map<String, Set<Integer>> miT = new HashMap();
    String miU;
    a miV;

    public final void a(final String str, final a aVar, final Set<Integer> set) {
        x.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(aVar.hashCode())});
        if (bi.oW(str)) {
            x.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
        } else {
            this.guJ.post(new Runnable() {
                public final void run() {
                    b bVar = b.this;
                    String str = str;
                    a aVar = aVar;
                    bVar.miT.put(str, set);
                    if (bVar.miS.containsKey(str)) {
                        List<a> list = (List) bVar.miS.get(str);
                        if (list != null) {
                            if (list != null) {
                                Object obj;
                                if (list != null && list.size() != 0) {
                                    for (a aVar2 : list) {
                                        if (aVar2 != null && aVar2 == aVar) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                } else {
                                    x.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
                                }
                                obj = null;
                                if (obj == null) {
                                    list.add(aVar);
                                }
                            }
                            x.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
                        }
                        bVar.bpp();
                        return;
                    }
                    List linkedList = new LinkedList();
                    linkedList.add(aVar);
                    bVar.miS.put(str, linkedList);
                    bVar.dWH.add(str);
                    bVar.bpp();
                }
            });
        }
    }

    final void bpp() {
        if (this.miV != null) {
            x.d("MicroMsg.FileScanQueueService", "it is scanning");
        } else if (this.miS.isEmpty()) {
            x.d("MicroMsg.FileScanQueueService", "queue is empty");
        } else {
            this.miU = (String) this.dWH.get(0);
            this.dWH.remove(0);
            this.miV = new a();
            this.miV.bXI = (Set) this.miT.get(this.miU);
            a aVar = this.miV;
            String str = this.miU;
            x.i("MicroMsg.scanner.DecodeFile", "start decode file: " + str);
            aVar.miP = this;
            ah.A(new 1(aVar, str));
        }
    }

    public final int a(d dVar) {
        this.guJ.post(new 3(this, dVar));
        return 0;
    }
}
