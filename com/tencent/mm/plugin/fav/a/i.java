package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static List<a> iVX;
    private static String iVY = "";
    private static String iVZ = "";
    private static long iWa = 0;

    public static void start() {
        iVX = new Vector();
    }

    public static void end() {
        if (iVX == null) {
            iVX = null;
            aLm();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (a aVar : iVX) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", aVar.bVs);
                jSONObject.put("tbe", aVar.iWb);
                jSONObject.put("in", aVar.in);
                jSONObject.put("sid", aVar.iVU);
            } catch (JSONException e) {
                x.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
            }
            stringBuilder.append(jSONObject.toString()).append(";");
            if (stringBuilder.length() > 3072) {
                iVX = null;
                aLm();
                return;
            }
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() > 3072) {
            iVX = null;
            aLm();
            return;
        }
        String[] strArr = new String[3];
        int i = 0;
        while (i < 3) {
            try {
                strArr[i] = "";
                i++;
            } catch (Throwable th) {
                x.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + th.getMessage());
            }
        }
        for (i = 0; i < 3; i++) {
            if (stringBuilder2.length() <= 1024) {
                strArr[i] = stringBuilder2;
                break;
            }
            strArr[i] = stringBuilder2.substring(0, 1024);
            stringBuilder2 = stringBuilder2.substring(1024);
        }
        h.mEJ.h(15508, new Object[]{strArr[0], strArr[1], strArr[2]});
        iVX = null;
        aLm();
    }

    private static void aLm() {
        iVY = "";
        iVZ = "";
        iWa = 0;
    }

    public static void cJ(String str, String str2) {
        if (!bi.oW(iVY)) {
            cK(iVY, iVZ);
        }
        iVY = str;
        iVZ = str2;
        iWa = System.currentTimeMillis();
    }

    public static void Bk(String str) {
        cJ(str, "");
    }

    private static void cK(String str, String str2) {
        if (!bi.oW(str) && str.equals(iVY)) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - iWa);
            iWa /= 1000;
            if (bi.oW(str2)) {
                str2 = "-1";
            }
            long j = iWa;
            if (iVX != null) {
                a aVar = new a((byte) 0);
                aVar.bVs = str;
                aVar.iWb = j;
                aVar.in = currentTimeMillis;
                if (bi.oW(str2)) {
                    aVar.iVU = "-1";
                } else {
                    aVar.iVU = str2;
                }
                if (iVX != null) {
                    iVX.add(aVar);
                }
            }
            aLm();
        }
    }

    public static void Bl(String str) {
        cK(str, "");
    }
}
