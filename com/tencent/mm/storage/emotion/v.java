package com.tencent.mm.storage.emotion;

import com.tencent.mm.br.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public final class v extends j {
    public HashMap<String, u> tdh;

    public final void cnP() {
        String str = (String) g.Ei().DT().get(a.tae, "");
        this.tdh = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                u uVar = new u();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                uVar.aAL = jSONObject.optString("key", "");
                uVar.position = jSONObject.optInt("position", 0);
                uVar.tdg = jSONObject.optInt("use_count", 0);
                uVar.dDj = jSONObject.optLong("last_time", 0);
                this.tdh.put(uVar.aAL, uVar);
            }
        } catch (JSONException e) {
            Log.w("SmileyUsageInfoStorage", "data error clear all");
            aPm();
        }
    }

    public final List<u> aEb() {
        if (this.tdh == null) {
            cnP();
        }
        List<u> arrayList = new ArrayList();
        for (u uVar : this.tdh.values()) {
            if (uVar.position >= 0 && uVar.position < e.cjH().apW()) {
                arrayList.add(uVar);
            }
        }
        Collections.sort(arrayList, new 1(this));
        return arrayList;
    }

    public final void aPm() {
        g.Ei().DT().a(a.tae, null);
        this.tdh = new HashMap();
    }
}
