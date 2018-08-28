package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class a$g implements Runnable {
    final /* synthetic */ a oDo;
    private String oDt;
    private boolean oDu;
    private Integer oDv;
    private String serverIP;

    public a$g(a aVar, String str, String str2, boolean z, Integer num) {
        this.oDo = aVar;
        this.oDt = str;
        this.serverIP = str2;
        this.oDu = z;
        this.oDv = num;
    }

    public final void run() {
        a aVar = this.oDo;
        String str = this.oDt;
        String str2 = this.serverIP;
        Integer num = this.oDv;
        for (int i = 1; i <= 3; i++) {
            List A = b.A(new String[]{"ping", "-c 1", "-t 64", str});
            if (A.size() == 2) {
                String str3 = (String) A.get(0);
                if (bi.oW(str3)) {
                    x.e("MicroMsg.MMTraceRoute", "runcommand err " + str);
                    aVar.a(str2, "run command err ", num);
                } else {
                    String obj = A.get(1).toString();
                    if (b.OA(str3) > 0) {
                        if (!bi.oW(b.Oz(str3))) {
                            str3 = String.format(" %sms ", new Object[]{b.Oz(str3)});
                        } else if (bi.oW(obj)) {
                            str3 = String.format("unable to get time", new Object[0]);
                        } else {
                            str3 = String.format(" %sms ", new Object[]{obj});
                        }
                    } else {
                        str3 = String.format(" router no response ", new Object[0]);
                    }
                    if (i == 3) {
                        str3 = str3 + "\n";
                    }
                    aVar.a(str2, str3, num);
                }
            } else if (i == 3) {
                aVar.a(str2, " router no response\n", num);
            } else {
                aVar.a(str2, " router no response", num);
            }
        }
    }
}
