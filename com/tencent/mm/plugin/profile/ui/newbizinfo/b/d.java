package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public String aAL;
    public String ceR;
    public int dMk;
    public String id;
    public List<d> lZm;
    public String name;
    public int type;
    public String value;

    public static d Y(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.ServiceInfo", "json is null, err");
            return null;
        }
        d dVar = new d();
        try {
            dVar.id = jSONObject.optString("id", "");
            dVar.type = jSONObject.optInt("type");
            dVar.name = jSONObject.optString("name");
            dVar.aAL = jSONObject.optString("key");
            dVar.value = jSONObject.optString("value");
            dVar.dMk = jSONObject.optInt("acttype", -1);
            dVar.ceR = jSONObject.optString("native_url");
            dVar.lZm = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("sub_button_list");
            if (optJSONArray == null) {
                return dVar;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                d Y = Y(optJSONArray.optJSONObject(i));
                if (Y != null) {
                    dVar.lZm.add(Y);
                }
            }
            return dVar;
        } catch (Exception e) {
            x.k("MicroMsg.ServiceInfo", "", new Object[]{e});
            return dVar;
        }
    }
}
