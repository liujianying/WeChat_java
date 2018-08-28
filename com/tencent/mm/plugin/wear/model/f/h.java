package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.cef;
import com.tencent.mm.protocal.c.ceg;
import java.util.List;

public final class h extends b {
    private long bJC;
    private long cfh;
    private String cfi;
    private List<String> cfj;

    public h(long j, long j2, String str, List<String> list) {
        this.bJC = j;
        this.cfh = j2;
        this.cfi = str;
        this.cfj = list;
    }

    protected final void send() {
        cef cef = new cef();
        cef.szm = this.cfh;
        cef.szl = this.bJC;
        cef.szn = this.cfi;
        try {
            if (this.cfj != null) {
                for (String split : this.cfj) {
                    String[] split2 = split.split("=");
                    ceg ceg = new ceg();
                    ceg.szk = split2[0];
                    ceg.hcS = split2[1];
                    if (ceg.hcS.startsWith("wxid")) {
                        ceg.hcS = r.gT(ceg.hcS);
                    }
                    ceg.szm = Long.valueOf(split2[2]).longValue();
                    cef.szo.add(ceg);
                }
            }
            a.bSl();
            com.tencent.mm.plugin.wear.model.e.r.b(20015, cef.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.cfh > 0) {
            com.tencent.mm.plugin.wear.model.c.a.jO(true);
        } else {
            com.tencent.mm.plugin.wear.model.c.a.jO(false);
        }
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
