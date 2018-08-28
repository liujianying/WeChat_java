package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.plugin.traceroute.b.a.a;
import com.tencent.mm.plugin.traceroute.b.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Set;

class a$j implements Runnable {
    final /* synthetic */ a oDo;

    private a$j(a aVar) {
        this.oDo = aVar;
    }

    public /* synthetic */ a$j(a aVar, byte b) {
        this(aVar);
    }

    public final void run() {
        long VF;
        this.oDo.iF(false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long VF2 = bi.VF();
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(VF2)));
        for (Entry entry : this.oDo.oDi.entrySet()) {
            i iVar = new i(this.oDo, (String) entry.getKey());
            if (a.oDe != null) {
                a.oDe.execute(iVar);
            }
            a aVar = new a(this.oDo, (String) entry.getKey(), (Set) entry.getValue());
            if (a.oDe != null) {
                a.oDe.execute(aVar);
            }
        }
        while (!this.oDo.bIL() && a.oDe.getActiveCount() > 0) {
            x.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.oDe.getActiveCount()));
            VF = bi.VF();
            if (VF - VF2 >= 120000) {
                x.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((VF - VF2) / 1000));
                this.oDo.iF(true);
                this.oDo.stop();
                if (this.oDo.oDj != null) {
                    this.oDo.oDj.bIP();
                    return;
                }
                return;
            }
            try {
                Thread.sleep(500);
            } catch (Throwable e) {
                x.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
            }
        }
        VF = bi.VF();
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(VF)));
        x.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((VF - VF2) / 1000));
        if (this.oDo.oDk != null && !this.oDo.bIL()) {
            this.oDo.oDk.Zq();
        }
    }
}
