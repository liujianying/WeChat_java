package com.tencent.liteav.network;

import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f.a;
import java.util.Iterator;
import java.util.Vector;

class TXCStreamDownloader$2 implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ TXCStreamDownloader c;

    TXCStreamDownloader$2(TXCStreamDownloader tXCStreamDownloader, boolean z, String str) {
        this.c = tXCStreamDownloader;
        this.a = z;
        this.b = str;
    }

    public void a(int i, String str, Vector<d> vector) {
        if (i != 0 || vector == null || vector.isEmpty()) {
            this.c.onNotifyEvent(12030, null);
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), com.tencent.liteav.basic.datareport.a.as, i, str);
            TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, play stream with raw url");
            if (TXCStreamDownloader.access$400(this.c)) {
                TXCStreamDownloader.access$1000(this.c, this.b, this.a);
                if (TXCStreamDownloader.access$600(this.c) != null) {
                    TXCStreamDownloader.access$600(this.c).postDelayed(TXCStreamDownloader.access$700(this.c), 2000);
                }
            }
        } else if (TXCStreamDownloader.access$400(this.c)) {
            if (TXCStreamDownloader.access$500(this.c) != null) {
                int i2;
                int i3 = 0;
                Iterator it = vector.iterator();
                while (true) {
                    i2 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    d dVar = (d) it.next();
                    if (dVar != null && dVar.b && dVar.a != null && dVar.a.length() > 0) {
                        i2++;
                    }
                    i3 = i2;
                }
                this.c.setStatusValue(7116, Long.valueOf((long) i2));
                this.c.setStatusValue(7112, Long.valueOf(2));
                TXCStreamDownloader.access$500(this.c).startDownload(vector, true, true, this.a);
            }
            if (TXCStreamDownloader.access$600(this.c) != null) {
                TXCStreamDownloader.access$600(this.c).postDelayed(TXCStreamDownloader.access$700(this.c), 2000);
            }
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), com.tencent.liteav.basic.datareport.a.as, i, TXCStreamDownloader.access$800(this.c).b());
        } else {
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$900(this.c), com.tencent.liteav.basic.datareport.a.as, -4, "livePlayer have been stopped");
        }
    }
}
