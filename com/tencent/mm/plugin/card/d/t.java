package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t {
    public static ArrayList<la> yi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("used_store_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList<la> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = new la();
                    obj.name = jSONObject.optString("name");
                    obj.descriptor = jSONObject.optString("descriptor");
                    obj.hvl = jSONObject.optString("phone");
                    obj.country = jSONObject.optString("country");
                    obj.csK = jSONObject.optString("province");
                    obj.csL = jSONObject.optString("city");
                    obj.dRH = jSONObject.optString("address");
                    obj.rnu = (float) jSONObject.optDouble("distance");
                    obj.bUg = (float) jSONObject.optDouble("longitude");
                    obj.bSx = (float) jSONObject.optDouble("latitude");
                    obj.hwI = jSONObject.optString("jump_url");
                    obj.rnv = jSONObject.optString("app_brand_user_name");
                    obj.rnw = jSONObject.optString("app_brand_pass");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShopInfoItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
