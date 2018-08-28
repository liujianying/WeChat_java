package com.tencent.mm.h;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public int bHB;
    public int bHC;
    public String bHD;
    public String cZY;
    public String cZZ;
    public int daa;
    public String desc;
    public int showType;
    public String url;

    public static c eX(String str) {
        if (bi.oW(str)) {
            return null;
        }
        c cVar = new c();
        Map z = bl.z(str, "e");
        if (z == null) {
            x.d("MicroMsg.BroadcastEntity", "this is not errmsg");
            return null;
        }
        cVar.desc = (String) z.get(".e.Content");
        cVar.url = (String) z.get(".e.Url");
        cVar.bHD = (String) z.get(".e.Title");
        cVar.bHC = bi.getInt((String) z.get(".e.Action"), 0);
        cVar.showType = bi.getInt((String) z.get(".e.ShowType"), 0);
        cVar.bHB = bi.getInt((String) z.get(".e.DispSec"), 30);
        cVar.cZY = (String) z.get(".e.Ok");
        cVar.cZZ = (String) z.get(".e.Cancel");
        cVar.daa = bi.getInt((String) z.get("e.Countdown"), 0);
        if (fB(cVar.showType)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) z.get(".e"));
            cVar.desc = jSONObject.getString("Content");
            cVar.url = jSONObject.getString("Url");
            cVar.bHD = jSONObject.getString("Title");
            cVar.bHC = bi.getInt(jSONObject.getString("Action"), 0);
            cVar.showType = bi.getInt(jSONObject.getString("ShowType"), 0);
            cVar.bHB = bi.getInt(jSONObject.getString("DispSec"), 30);
            cVar.cZY = (String) z.get(".e.Ok");
            cVar.cZZ = (String) z.get(".e.Cancel");
            cVar.daa = bi.getInt((String) z.get("e.Countdown"), 0);
            if (fB(cVar.showType)) {
                return cVar;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BroadcastEntity", e, "", new Object[0]);
        }
        return null;
    }

    private static boolean fB(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3 || i == 8) {
            return true;
        }
        return false;
    }
}
