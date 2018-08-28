package com.tencent.mm.plugin.j;

import com.tencent.mm.g.a.cd;
import com.tencent.mm.plugin.j.b.11;
import com.tencent.mm.plugin.j.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$11$1 implements Runnable {
    final /* synthetic */ cd htf;
    final /* synthetic */ 11 htg;

    b$11$1(11 11, cd cdVar) {
        this.htg = 11;
        this.htf = cdVar;
    }

    public final void run() {
        if (this.htf != null && !bi.oW(this.htf.bJB.talker)) {
            try {
                b avs = b.avr().avs();
                long j = this.htf.bJB.bJC;
                String str = this.htf.bJB.talker;
                int i = this.htf.bJB.msgType;
                String[] strArr = new String[]{String.valueOf(j), String.valueOf(i), str};
                int delete = avs.diF.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", strArr);
                x.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", new Object[]{Long.valueOf(j), Integer.valueOf(i), str, Integer.valueOf(delete)});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                h.mEJ.a(664, 6, 1, false);
            }
        }
    }
}
