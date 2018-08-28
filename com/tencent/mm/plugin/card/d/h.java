package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class h {
    public static ArrayList<ky> aZ(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            return null;
        }
        JSONArray optJSONArray;
        if (i == 8 || i == 0) {
            try {
                optJSONArray = new JSONObject(str).optJSONArray("card_list");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                return null;
            }
        } else if (i == 26) {
            optJSONArray = new JSONArray(str);
        } else {
            optJSONArray = new JSONArray(str);
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            x.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
            return null;
        }
        ArrayList<ky> arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            ky kyVar = new ky();
            kyVar.huU = optJSONObject.optString(i == 26 ? "cardId" : "card_id");
            kyVar.cad = optJSONObject.optString(i == 26 ? "cardExt" : "card_ext");
            arrayList.add(kyVar);
        }
        return arrayList;
    }

    public static String a(LinkedList<e> linkedList, boolean z, int i) {
        if (linkedList.size() == 0) {
            x.e("MicroMsg.CardListItemParser", "parseCardListItemToJson list == null || list.size() == 0");
            return "";
        }
        x.i("MicroMsg.CardListItemParser", "parseCardListItemToJson is_succ:" + z + " scene:" + i);
        JSONStringer jSONStringer = new JSONStringer();
        if (i == 8) {
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
                return "";
            }
        }
        jSONStringer.array();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            jSONStringer.object();
            jSONStringer.key(i == 26 ? "cardId" : "card_id");
            jSONStringer.value(eVar.huU);
            jSONStringer.key(i == 26 ? "cardExt" : "card_ext");
            jSONStringer.value(eVar.cad == null ? "" : eVar.cad);
            jSONStringer.key(i == 26 ? "isSuccess" : "is_succ");
            if (z) {
                jSONStringer.value(i == 26 ? Boolean.valueOf(true) : Integer.valueOf(1));
            } else {
                jSONStringer.value(i == 26 ? Boolean.valueOf(false) : Integer.valueOf(0));
            }
            jSONStringer.key("code");
            jSONStringer.value(eVar.code == null ? "" : eVar.code);
            jSONStringer.endObject();
        }
        jSONStringer.endArray();
        if (i == 8) {
            jSONStringer.endObject();
        }
        return jSONStringer.toString();
    }

    public static String ba(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardListItemParser", "parseCardListItemArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardListItemParser", "parseCardListItemArray cardItemListJson is null");
                return null;
            }
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.array();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                jSONStringer.object();
                jSONStringer.key(i == 26 ? "cardId" : "card_id");
                jSONStringer.value(optJSONObject.optString("card_id"));
                jSONStringer.key(i == 26 ? "cardExt" : "card_ext");
                jSONStringer.value(optJSONObject.optString("card_ext"));
                jSONStringer.key(i == 26 ? "isSuccess" : "is_succ");
                if (i != 26) {
                    jSONStringer.value((long) optJSONObject.optInt("is_succ"));
                } else if (optJSONObject.optInt("is_succ") == 1) {
                    jSONStringer.value(true);
                } else {
                    jSONStringer.value(false);
                }
                jSONStringer.key("code");
                if (TextUtils.isEmpty(optJSONObject.optString("encrypt_code"))) {
                    jSONStringer.value(optJSONObject.optString("code"));
                } else {
                    jSONStringer.value(optJSONObject.optString("encrypt_code"));
                }
                jSONStringer.endObject();
                x.i("MicroMsg.CardListItemParser", "parseJsonToArray item" + i2 + "  is_succ:" + optJSONObject.optInt(i == 26 ? "isSuccess" : "is_succ"));
            }
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardListItemParser", e, "", new Object[0]);
            return "";
        }
    }
}
