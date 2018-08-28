package com.tencent.mm.plugin.websearch.api;

import android.util.Base64;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    public static bjk pLM;

    public static bjk bSX() {
        if (pLM == null) {
            String bSY = bSY();
            pLM = new bjk();
            bSY = ad.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(bSY, "");
            if (!bi.oW(bSY)) {
                try {
                    pLM.aG(Base64.decode(bSY.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return pLM;
    }

    public static String bSY() {
        return "key_pb_history_list" + q.GF();
    }

    public static String bSZ() {
        int i = 0;
        bjk bSX = bSX();
        int size = bSX.hbG.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            while (true) {
                int i2 = i;
                if (i2 >= bSX.hbG.size() || i2 >= size) {
                    jSONObject2.put("items", jSONArray2);
                    jSONObject2.put("count", jSONArray2.length());
                    jSONObject2.put("type", 4);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put("ret", 0);
                } else {
                    bjj bjj = (bjj) bSX.hbG.get(i2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", bjj.sjx);
                    jSONArray2.put(jSONObject3);
                    i = i2 + 1;
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put("type", 4);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
