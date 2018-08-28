package com.tencent.mm.plugin.monitor;

import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.plugin.monitor.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class b$14 implements Runnable {
    final /* synthetic */ b lsb;
    final /* synthetic */ a lso;
    final Map<String, Integer> lsp = this.lsq;
    final /* synthetic */ Map lsq;
    final /* synthetic */ a lsr;
    final /* synthetic */ File lss;

    b$14(b bVar, Map map, a aVar, File file, a aVar2) {
        this.lsb = bVar;
        this.lsq = map;
        this.lsr = aVar;
        this.lss = file;
        this.lso = aVar2;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", new Object[]{this.lsr, Integer.valueOf(this.lsq.size())});
        long currentTimeMillis = System.currentTimeMillis();
        b.a(this.lsb, this.lss, this.lsr, this.lsp);
        if (this.lsq.size() > 0) {
            Iterator it = this.lsq.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.lsr.lrF.add(new b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
            }
        }
        this.lsr.lrE = System.currentTimeMillis() - currentTimeMillis;
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", new Object[]{Long.valueOf(this.lsr.lrE), Integer.valueOf(this.lsq.values().size()), this.lsr, Long.valueOf(Thread.currentThread().getId())});
        this.lso.a(0, this.lsr);
    }
}
