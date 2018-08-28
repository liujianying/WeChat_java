package com.tencent.mm.plugin.j.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;

public final class b implements Runnable {
    private int count = 0;
    public boolean isStop = false;

    public final void run() {
        if (!this.isStop) {
            String Gb = c.Gb();
            this.count = 0;
            long a = a(Gb, new PLong());
            if (!this.isStop) {
                Gb = c.Gc();
                this.count = 0;
                long a2 = a(Gb, new PLong());
                if (!this.isStop) {
                    au.HU();
                    Gb = com.tencent.mm.model.c.getAccVideoPath();
                    this.count = 0;
                    long a3 = a(Gb, new PLong());
                    if (!this.isStop) {
                        au.HU();
                        Gb = com.tencent.mm.model.c.Gd();
                        this.count = 0;
                        long a4 = a(Gb, new PLong());
                        if (!this.isStop) {
                            long nC = (com.tencent.mm.plugin.j.b.avr().avs().nC(43) + com.tencent.mm.plugin.j.b.avr().avs().nC(62)) + com.tencent.mm.plugin.j.b.avr().avs().nC(44);
                            long nD = (com.tencent.mm.plugin.j.b.avr().avs().nD(43) + com.tencent.mm.plugin.j.b.avr().avs().nD(62)) + com.tencent.mm.plugin.j.b.avr().avs().nD(44);
                            if (!this.isStop) {
                                long nC2 = com.tencent.mm.plugin.j.b.avr().avs().nC(3);
                                long nD2 = com.tencent.mm.plugin.j.b.avr().avs().nD(3);
                                if (!this.isStop) {
                                    long nC3 = com.tencent.mm.plugin.j.b.avr().avs().nC(34);
                                    long nD3 = com.tencent.mm.plugin.j.b.avr().avs().nD(34);
                                    long nC4 = com.tencent.mm.plugin.j.b.avr().avs().nC(49);
                                    long nD4 = com.tencent.mm.plugin.j.b.avr().avs().nD(49);
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf(43), Long.valueOf(nC), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nD)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf(3), Long.valueOf(nC2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nD2)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf(34), Long.valueOf(nC3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nD3)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf(49), Long.valueOf(nC4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(nD4)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf("image".hashCode()), Long.valueOf(a), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r3.value)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf("image2".hashCode()), Long.valueOf(a2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r6.value)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf("video".hashCode()), Long.valueOf(a3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r7.value)});
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf("voice".hashCode()), Long.valueOf(a4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(r12.value)});
                                    long longValue = ((Long) g.Ei().DT().get(a.sYl, Long.valueOf(0))).longValue();
                                    long longValue2 = ((Long) g.Ei().DT().get(a.sYm, Long.valueOf(0))).longValue() - longValue;
                                    h.mEJ.h(14556, new Object[]{Integer.valueOf("cost".hashCode()), Integer.valueOf(0), Long.valueOf(longValue), Long.valueOf(r34), Long.valueOf(longValue2)});
                                    x.i("MicroMsg.ReportTask", "report wx[%d %d %d %d] folder[%d %d %d %d] count_wx[%d %d %d %d] count_folder[%d %d %d %d]", new Object[]{Long.valueOf(nC), Long.valueOf(nC2), Long.valueOf(nC3), Long.valueOf(nC4), Long.valueOf(a3), Long.valueOf(a2), Long.valueOf(a4), Long.valueOf(a), Long.valueOf(nD), Long.valueOf(nD2), Long.valueOf(nD3), Long.valueOf(nD4), Long.valueOf(r7.value), Long.valueOf(r6.value), Long.valueOf(r12.value), Long.valueOf(r3.value)});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private long a(String str, PLong pLong) {
        long j = 0;
        if (this.count >= 10) {
            if (this.isStop) {
                return -1;
            }
            this.count = 0;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long a = a(append.append(str22).toString(), pLong);
                    if (a == -1) {
                        return -1;
                    }
                    j += a;
                }
                return j;
            }
        }
        long length = file.length();
        if (length <= 0) {
            return length;
        }
        pLong.value++;
        return length;
    }
}
