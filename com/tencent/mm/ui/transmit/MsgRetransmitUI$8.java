package com.tencent.mm.ui.transmit;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d$a;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import java.util.HashMap;
import java.util.Map.Entry;

class MsgRetransmitUI$8 implements d$a {
    final /* synthetic */ String dMs;
    final /* synthetic */ f dVv;
    final /* synthetic */ int mjd;
    final /* synthetic */ MsgRetransmitUI uDL;
    final /* synthetic */ String uDN;
    final /* synthetic */ String uDO;

    MsgRetransmitUI$8(MsgRetransmitUI msgRetransmitUI, String str, int i, String str2, String str3, f fVar) {
        this.uDL = msgRetransmitUI;
        this.dMs = str;
        this.mjd = i;
        this.uDN = str2;
        this.uDO = str3;
        this.dVv = fVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        Object obj2;
        if (i3 == 0 && i4 == 0) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj instanceof HashMap) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap != null) {
                for (Entry entry : hashMap.entrySet()) {
                    Long l = (Long) entry.getKey();
                    e eVar = (e) entry.getValue();
                    this.uDL.fileName = o.Pf().o(com.tencent.mm.ak.f.c(eVar), "", "");
                    if (obj2 != null) {
                        au.HU();
                        c.FT().dX(l.longValue());
                        MsgRetransmitUI.a(this.uDL, this.dMs, this.mjd, this.uDN, this.uDO, this.dVv);
                    }
                }
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
