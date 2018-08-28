package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public static void b(LinkedList<ly> linkedList, int i) {
        if (linkedList != null) {
            int size = linkedList.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    ly lyVar = (ly) linkedList.get(i3);
                    c axi = am.axi();
                    String str = lyVar.cac;
                    int i4 = ((size - i3) * 10) + i;
                    String str2 = lyVar.hyB;
                    i2 = lyVar.end_time;
                    if (bi.oW(str)) {
                        x.w("MicroMsg.CardInfoStorage", "cardId null");
                    } else {
                        axi.diF.fV("UserCardInfo", "update UserCardInfo set stickyIndex=" + i4 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i2 + " where card_id='" + str + "'");
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void c(LinkedList<ly> linkedList, int i) {
        if (linkedList != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    ly lyVar = (ly) linkedList.get(i3);
                    am.axi().diF.fV("UserCardInfo", "update UserCardInfo set stickyIndex=" + i + ", label_wording='" + (lyVar.rqh != null ? lyVar.rqh : "") + "' where card_id='" + lyVar.cac + "'");
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static abv xU(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.CardStickyHelper", "jsonRet null");
            return null;
        }
        abv abv = new abv();
        try {
            JSONObject jSONObject = new JSONObject(str);
            abv.rGo = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                abv.rGr = new ma();
                abv.rGr.rqj = H(jSONObject2.optJSONObject("expiring_list"));
                abv.rGr.rqk = H(jSONObject2.optJSONObject("member_card_list"));
                abv.rGr.rql = H(jSONObject2.optJSONObject("nearby_list"));
                abv.rGr.rqm = H(jSONObject2.optJSONObject("label_list"));
                abv.rGr.rqn = H(jSONObject2.optJSONObject("first_list"));
                if (!(abv.rGr.rqn == null || abv.rGr.rqn.rqi == null)) {
                    for (int size = abv.rGr.rqn.rqi.size() - 1; size >= 0; size--) {
                        ly lyVar = (ly) abv.rGr.rqn.rqi.get(size);
                        if (!bi.oW(lyVar.cac)) {
                            CardInfo xm = am.axi().xm(lyVar.cac);
                            if (!(xm == null || xm.avT())) {
                                abv.rGr.rqn.rqi.remove(size);
                            }
                        }
                    }
                }
                abv.rGs = jSONObject2.optString("red_dot_wording");
                abv.rGt = jSONObject2.optInt("show_red_dot", 0) == 1;
                Object optString = jSONObject2.optString("title");
                if (optString == null) {
                    optString = "";
                }
                am.axn().putValue("key_card_entrance_tips", optString);
                abv.rGu = jSONObject2.optInt("top_scene", 100);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return abv;
    }

    private static lz H(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            return null;
        }
        lz lzVar = new lz();
        lzVar.rqi = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("item_list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ly lyVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    lyVar = null;
                } else {
                    lyVar = new ly();
                    lyVar.hyB = jSONObject2.optString("announcement");
                    lyVar.cac = jSONObject2.optString("card_id");
                    lyVar.end_time = jSONObject2.optInt("end_time", 0);
                    lyVar.rqg = jSONObject2.optInt("update_time", 0);
                    lyVar.rqh = jSONObject2.optString("label_wording");
                }
                if (lyVar == null || (((long) lyVar.end_time) <= bi.VE() && lyVar.end_time != 0)) {
                    x.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    lzVar.rqi.add(lyVar);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return lzVar;
    }

    public static String a(Context context, int i, CardInfo cardInfo) {
        switch (i % 10) {
            case 0:
                return context.getString(g.card_sticky_order_title);
            case 1:
                return context.getString(g.card_sticky_nearby_title);
            case 2:
                return context.getString(g.card_sticky_member_card_title);
            case 3:
                return context.getString(g.card_sticky_expiring_title);
            case 4:
                return cardInfo.field_label_wording;
            default:
                return null;
        }
    }
}
