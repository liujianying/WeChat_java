package com.tencent.mm.plugin.game.model;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    public static a qQ(int i) {
        a aVar = new a();
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100001");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            aVar.bWA = bi.getInt((String) ckq.get("game_homepage_jump"), 0);
            String str = (String) ckq.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(fJ, i, aVar.url, aVar.bWA);
            x.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", new Object[]{fJ.field_layerId, fJ.field_expId, Integer.valueOf(aVar.bWA), aVar.url});
            return aVar;
        }
        x.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fJ.field_startTime), Long.valueOf(fJ.field_endTime)});
        return aVar;
    }

    public static a bt(String str, int i) {
        a aVar = new a();
        if (bi.oW(str)) {
            x.e(TAG, "appid is null");
            return aVar;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100002");
        if (fJ.isValid()) {
            x.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[]{fJ.field_layerId});
            Map ckq = fJ.ckq();
            aVar.bWA = bi.getInt((String) ckq.get("game_detail_jump"), 0);
            String str2 = (String) ckq.get("game_detail_url");
            aVar.url = str2 == null ? "" : str2 + str;
            a(fJ, i, aVar.url, aVar.bWA);
            return aVar;
        }
        x.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fJ.field_startTime), Long.valueOf(fJ.field_endTime)});
        return aVar;
    }

    public static a aTu() {
        a aVar = new a();
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100003");
        if (fJ.isValid()) {
            x.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[]{fJ.field_layerId});
            Map ckq = fJ.ckq();
            aVar.bWA = bi.getInt((String) ckq.get("game_library_jump"), 0);
            String str = (String) ckq.get("game_library_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(fJ, 1005, aVar.url, aVar.bWA);
            return aVar;
        }
        x.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(fJ.field_startTime), Long.valueOf(fJ.field_endTime)});
        return aVar;
    }

    public static a aTv() {
        a aVar = new a();
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100022");
        if (!fJ.isValid()) {
            return aVar;
        }
        Map ckq = fJ.ckq();
        aVar.bWA = bi.getInt((String) ckq.get("game_message_jump"), 0);
        String str = (String) ckq.get("game_message_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        a(fJ, 1001, aVar.url, aVar.bWA);
        return aVar;
    }

    private static void a(c cVar, int i, String str, int i2) {
        if (cVar == null) {
            x.i(TAG, "ABTestItem is null");
            return;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (!bi.oW(str)) {
                jSONObject.put("url", str);
            }
            jSONObject.put("jumpType", i2);
            str2 = p.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
        } catch (UnsupportedEncodingException e2) {
        }
        x.i(TAG, "reportABTest : " + cVar.field_layerId + " , " + cVar.field_business + " , " + cVar.field_expId + " , " + cVar.field_sequence + " , " + cVar.field_prioritylevel + " , " + cVar.field_startTime + " , " + cVar.field_endTime + " , " + i + " , " + str2);
        h.mEJ.h(14841, new Object[]{cVar.field_layerId, cVar.field_business, cVar.field_expId, Long.valueOf(cVar.field_sequence), Integer.valueOf(cVar.field_prioritylevel), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), Integer.valueOf(i), str2});
    }
}
