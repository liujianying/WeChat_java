package com.tencent.mm.plugin.j.c;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.j.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

public final class c implements Runnable {
    private String hth;
    private long hti;
    private a htj;
    public boolean isStop;
    private int limit;

    public c(String str, long j, int i, a aVar) {
        this.hth = str;
        this.hti = j;
        this.limit = i;
        this.htj = aVar;
        x.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.hti), Integer.valueOf(this.limit)});
    }

    public final void run() {
        int i = 0;
        if (!this.isStop) {
            long VG = bi.VG();
            Cursor cursor = null;
            try {
                au.HU();
                cursor = com.tencent.mm.model.c.FT().d(this.hth, this.hti, this.limit);
                VG = bi.bI(VG);
                b.avr();
                b.p(this.limit, VG);
                while (cursor.moveToNext()) {
                    i++;
                    bd bdVar = new bd();
                    bdVar.d(cursor);
                    b.avr().K(bdVar);
                    b.avr().cc(bdVar.field_msgId);
                    if (this.isStop) {
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                x.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.limit)});
                if (i < this.limit) {
                    b avr = b.avr();
                    b.avr();
                    avr.cc(b.avt());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ScanMsgTask", e, "", new Object[0]);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (this.htj != null) {
                this.htj.finish();
            }
        }
    }
}
