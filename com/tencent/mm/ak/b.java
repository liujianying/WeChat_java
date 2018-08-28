package com.tencent.mm.ak;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Stack;

public final class b implements a {
    private a dTf;
    public Stack<Long> dTg;
    long dTh = 0;
    public int dTi = 0;
    boolean dTj = false;
    public long dTk = 0;
    int dTl = 0;
    boolean dTm = false;
    long dTn = 0;
    long dTo = 0;
    int dTp;
    int dTq;
    al dTr = new al(new 1(this), false);
    c dTs = new 2(this);
    c dTt = new 3(this);

    public b(Looper looper) {
        this.dTf = new a(this, looper);
        this.dTg = new Stack();
        this.dTp = Process.myUid();
        Integer num = (Integer) g.Ei().DT().get(327681, null);
        int intValue = (num == null || 3 == num.intValue()) ? 1 : num.intValue();
        this.dTq = intValue;
        com.tencent.mm.sdk.b.a.sFg.b(this.dTs);
        com.tencent.mm.sdk.b.a.sFg.b(this.dTt);
    }

    public final void start() {
        this.dTf.sendEmptyMessage(1);
    }

    public final void bB(boolean z) {
        x.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + z);
        this.dTj = z;
        this.dTk = System.currentTimeMillis();
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public static void a(long j, long j2, boolean z) {
        if (!z) {
            x.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
        } else if (ao.isWifi(ad.getContext())) {
            x.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        } else {
            long a = bi.a((Long) g.Ei().DT().get(aa.a.sPH, null), 0);
            long WV = bi.WV((String) DateFormat.format("M", System.currentTimeMillis()));
            x.d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", new Object[]{Long.valueOf(1 + a), Long.valueOf(WV)});
            g.Ei().DT().a(aa.a.sPH, Long.valueOf(a + 1));
            g.Ei().DT().a(aa.a.sPI, Long.valueOf(WV));
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        if (i3 == 0 && i4 == 0) {
            a(j, j2, true);
        } else {
            x.e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
        }
        this.dTh = 0;
        com.tencent.mm.modelcontrol.c.NM();
        if (com.tencent.mm.modelcontrol.c.NN()) {
            this.dTn = TrafficStats.getUidRxBytes(this.dTp);
            this.dTo = TrafficStats.getUidTxBytes(this.dTp);
            this.dTr.J(1000, 1000);
            return;
        }
        x.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.dTg) {
            this.dTg.clear();
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        x.i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
    }
}
