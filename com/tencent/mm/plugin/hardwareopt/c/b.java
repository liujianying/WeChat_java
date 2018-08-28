package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, amg> {
    private boolean kjk = false;

    public final /* synthetic */ Object call(Object obj) {
        amg amg = (amg) obj;
        long longValue = ((Long) g.Ei().DT().get(aa.a.sYv, Long.valueOf(-1))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[]{Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue)});
        if (!this.kjk && currentTimeMillis - longValue < 86400000) {
            x.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
            return Boolean.valueOf(false);
        } else if (!this.kjk && (amg == null || amg.rOP == null)) {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
            h.mEJ.a(661, 1, 1, false);
            return Boolean.valueOf(false);
        } else if (this.kjk || !bi.oW(amg.rOP.imei)) {
            x.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
            h hVar = h.mEJ;
            Object[] objArr = new Object[41];
            objArr[0] = amg.rOP.imei;
            objArr[1] = amg.rOP.rgo;
            objArr[2] = amg.rOP.rgp;
            objArr[3] = amg.rOP.rgq;
            objArr[4] = amg.rOQ.rmF;
            objArr[5] = amg.rOQ.rmD;
            objArr[6] = amg.rOQ.rgp;
            objArr[7] = amg.rOQ.rmG;
            objArr[8] = Integer.valueOf(amg.rOQ.rmE);
            objArr[9] = Integer.valueOf(amg.rOR.rWK);
            objArr[10] = Integer.valueOf(amg.rOR.rWL);
            objArr[11] = Integer.valueOf(amg.rOS.sps);
            objArr[12] = Integer.valueOf(amg.rOS.spt ? 1 : 0);
            objArr[13] = Integer.valueOf(amg.rOW.rDB ? 1 : 0);
            objArr[14] = Integer.valueOf(amg.rOW.rDC ? 1 : 0);
            objArr[15] = amg.rOT.sje;
            objArr[16] = Integer.valueOf(amg.rOT.density);
            objArr[17] = amg.rOU.rtO;
            objArr[18] = Integer.valueOf(amg.rOV.rCL ? 1 : 0);
            objArr[19] = Integer.valueOf(amg.rOV.rCM ? 1 : 0);
            objArr[20] = Integer.valueOf(amg.rOV.rCN ? 1 : 0);
            objArr[21] = Integer.valueOf(amg.rOV.rCO ? 1 : 0);
            objArr[22] = Integer.valueOf(amg.rOV.rCP ? 1 : 0);
            objArr[23] = Integer.valueOf(amg.rOV.rCQ ? 1 : 0);
            objArr[24] = Integer.valueOf(amg.rOV.rCR ? 1 : 0);
            objArr[25] = Integer.valueOf(amg.rOV.rDc ? 1 : 0);
            objArr[26] = Integer.valueOf(amg.rOV.rCS ? 1 : 0);
            objArr[27] = Integer.valueOf(amg.rOV.rCT ? 1 : 0);
            objArr[28] = Integer.valueOf(amg.rOV.rCU ? 1 : 0);
            objArr[29] = Integer.valueOf(amg.rOV.rCV ? 1 : 0);
            objArr[30] = Integer.valueOf(amg.rOV.rCW ? 1 : 0);
            objArr[31] = Integer.valueOf(amg.rOV.rCX ? 1 : 0);
            objArr[32] = Integer.valueOf(amg.rOV.rCY ? 1 : 0);
            objArr[33] = Integer.valueOf(amg.rOV.rCZ ? 1 : 0);
            objArr[34] = Integer.valueOf(amg.rOV.rDa ? 1 : 0);
            objArr[35] = Integer.valueOf(amg.rOV.rDb ? 1 : 0);
            objArr[36] = Integer.valueOf(amg.rOR.rWN);
            objArr[37] = Integer.valueOf(amg.rOR.rWM);
            objArr[38] = amg.rOU.rtP;
            objArr[39] = T(amg.rOU.rtQ);
            objArr[40] = Integer.valueOf(amg.rOW.rDD ? 1 : 0);
            hVar.h(14552, objArr);
            g.Ei().DT().a(aa.a.sYv, Long.valueOf(currentTimeMillis));
            h.mEJ.a(661, 0, 1, false);
            return Boolean.valueOf(true);
        } else {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
            h.mEJ.a(661, 2, 1, false);
            return Boolean.valueOf(false);
        }
    }

    public b(boolean z) {
        this.kjk = z;
    }

    private static String T(LinkedList<atq> linkedList) {
        JSONArray jSONArray = new JSONArray();
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    atq atq = (atq) it.next();
                    if (!(atq == null || bi.oW(atq.ldm))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", atq.ldm);
                        JSONArray jSONArray2 = new JSONArray();
                        if (atq.rWW != null) {
                            Iterator it2 = atq.rWW.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put((String) it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                return "";
            }
        }
        x.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        return "";
    }
}
