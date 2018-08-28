package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;

public final class l implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.dIN == null || aVar.dIN.rcl == null) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            return;
        }
        String a = ab.a(aVar.dIN.rcl);
        x.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + a);
        String W = W(a, "<TimelineObject", "</TimelineObject>");
        if (bi.oW(W)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            return;
        }
        String W2 = W(a, "<RecXml", "</RecXml>");
        if (bi.oW(W2)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            return;
        }
        a = W(a, "<ADInfo", "</ADInfo>");
        if (bi.oW(a)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            return;
        }
        bsu ng = e.ng(W);
        bfl bfl = new bfl();
        bfl.sgL = ab.oT(a);
        bpm bpm = new bpm();
        bfl.sgK = bpm;
        bpm.snA = ab.oT(W2);
        boy boy = new boy();
        boy.rlK = new BigInteger(ng.ksA).longValue();
        boy.lOH = ng.lOH;
        boy.rdS = ng.hbL;
        boy.smH = ab.O(W.getBytes());
        bpm.slX = boy;
        com.tencent.mm.plugin.sns.model.a.b(bfl);
    }

    private static String W(String str, String str2, String str3) {
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            return "";
        }
        return str.substring(indexOf, indexOf2 + str3.length());
    }
}
