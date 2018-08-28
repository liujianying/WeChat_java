package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.plugin.traceroute.b.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class a$i implements Runnable {
    private String ip;
    final /* synthetic */ a oDo;

    public a$i(a aVar, String str) {
        this.oDo = aVar;
        this.ip = str;
    }

    public final void run() {
        int i = 1;
        List A = b.A(new String[]{"ping", "-c 1", "-t 64", this.ip});
        if (A.size() != 2) {
            this.oDo.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
            return;
        }
        String str = (String) A.get(0);
        if (bi.oW(str)) {
            this.oDo.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
            x.e("MicroMsg.MMTraceRoute", "runcommand err");
            return;
        }
        int OA = b.OA(str);
        if (OA <= 0) {
            x.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
            this.oDo.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
            return;
        }
        String obj = A.get(1).toString();
        if (!bi.oW(b.Oz(str))) {
            str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(OA), b.Oz(str)});
        } else if (bi.oW(obj)) {
            str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(OA), "unknown"});
        } else {
            str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(OA), obj});
        }
        this.oDo.a(this.ip, str + "\n", Integer.valueOf(0));
        int i2 = (64 - OA) + 5;
        if (i2 < 0) {
            i2 = 64;
        }
        while (i < i2 && !this.oDo.bIL()) {
            h hVar = new h(this.oDo, this.ip, i);
            if (a.oDe != null) {
                a.oDe.execute(hVar);
            }
            i++;
        }
    }
}
