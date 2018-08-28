package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public String dxh;
    public int end_time;
    public String hoj;
    public String huU;
    public int huV;
    public String huW;
    public String huX;
    public String huY;
    public String huZ;
    public String hva;
    public String hvb;
    public int hvc;
    public String hvd;
    public String hve;
    public String hvf;
    public boolean hvg;
    public String title;
    public String userName;

    public static LinkedList<a> xk(String str) {
        LinkedList<a> linkedList = null;
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        try {
            return a(new JSONObject(str).optJSONArray("available_cards"), false);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            return linkedList;
        }
    }

    public static LinkedList<a> xl(String str) {
        LinkedList<a> linkedList = null;
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        try {
            return a(new JSONObject(str).optJSONArray("available_share_cards"), true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            return linkedList;
        }
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            a aVar = new a();
            aVar.huU = jSONObject.optString("card_tp_id");
            aVar.huV = jSONObject.optInt("card_type");
            aVar.dxh = jSONObject.optString("color");
            aVar.huW = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
            aVar.huX = jSONObject.optString("sub_title");
            aVar.huY = jSONObject.optString("aux_title");
            aVar.huZ = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.hva = jSONObject.optString("app_id");
            aVar.end_time = jSONObject.optInt("end_time");
            aVar.hvb = jSONObject.optString("card_user_id");
            aVar.hvc = jSONObject.optInt("choose_optional");
            aVar.hve = jSONObject.optString("invoice_item");
            aVar.hvf = jSONObject.optString("invoice_status");
            aVar.hvd = jSONObject.optString("invoice_title");
            aVar.hvg = z;
            linkedList.add(aVar);
        }
        return linkedList;
    }
}
