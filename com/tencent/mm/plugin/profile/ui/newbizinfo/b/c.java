package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.g.c.df;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends df {
    public static a dzU;
    private List<b> juC;
    private List<d> lYV;
    private List<a> lZl;

    static {
        a aVar = new a();
        aVar.sKy = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.sKA.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "username";
        aVar.columns[1] = "originalArticleCount";
        aVar.sKA.put("originalArticleCount", "INTEGER default '1' ");
        stringBuilder.append(" originalArticleCount INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "friendSubscribeCount";
        aVar.sKA.put("friendSubscribeCount", "INTEGER default '1' ");
        stringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "allArticleWording";
        aVar.sKA.put("allArticleWording", "TEXT");
        stringBuilder.append(" allArticleWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "historyArticlesUrl";
        aVar.sKA.put("historyArticlesUrl", "TEXT");
        stringBuilder.append(" historyArticlesUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "userRole";
        aVar.sKA.put("userRole", "INTEGER default '1' ");
        stringBuilder.append(" userRole INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "banReason";
        aVar.sKA.put("banReason", "TEXT");
        stringBuilder.append(" banReason TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showRecommendArticle";
        aVar.sKA.put("showRecommendArticle", "INTEGER default '0' ");
        stringBuilder.append(" showRecommendArticle INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showService";
        aVar.sKA.put("showService", "INTEGER default '0' ");
        stringBuilder.append(" showService INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "messageListStr";
        aVar.sKA.put("messageListStr", "TEXT");
        stringBuilder.append(" messageListStr TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "serviceInfoListStr";
        aVar.sKA.put("serviceInfoListStr", "TEXT");
        stringBuilder.append(" serviceInfoListStr TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "bizAccountListStr";
        aVar.sKA.put("bizAccountListStr", "TEXT");
        stringBuilder.append(" bizAccountListStr TEXT");
        aVar.columns[12] = "rowid";
        aVar.sql = stringBuilder.toString();
        dzU = aVar;
    }

    public final a AX() {
        return dzU;
    }

    public final List<b> bnM() {
        if (this.juC == null) {
            this.juC = JL(this.field_messageListStr);
        }
        return this.juC;
    }

    public final List<d> bnN() {
        if (this.lYV == null) {
            this.lYV = JJ(this.field_serviceInfoListStr);
        }
        return this.lYV;
    }

    public final boolean bnO() {
        return !bi.oW(this.field_allArticleWording);
    }

    public final boolean awi() {
        return this.field_userRole == 1;
    }

    public final boolean bnP() {
        return this.field_showRecommendArticle == 1;
    }

    public final boolean bnQ() {
        return this.field_showService == 1;
    }

    public static c a(String str, ih ihVar) {
        c cVar = new c();
        cVar.field_username = str;
        for (ii iiVar : ihVar.rgX) {
            if (iiVar.riD.equals("OriginalArticleCount")) {
                cVar.field_originalArticleCount = bi.getInt(iiVar.mEl, -1);
            } else if (iiVar.riD.equals("FriendSubscribeCount")) {
                cVar.field_friendSubscribeCount = bi.getInt(iiVar.mEl, -1);
            } else if (iiVar.riD.equals("AllArticleWording")) {
                cVar.field_allArticleWording = iiVar.mEl;
            } else if (iiVar.riD.equals("HistoryArticlesUrl")) {
                cVar.field_historyArticlesUrl = iiVar.mEl;
            } else if (iiVar.riD.equals("ArticleList")) {
                cVar.field_messageListStr = iiVar.mEl;
                cVar.juC = JL(cVar.field_messageListStr);
            } else if (iiVar.riD.equals("BizAccountList")) {
                cVar.field_bizAccountListStr = iiVar.mEl;
                cVar.lZl = JK(cVar.field_bizAccountListStr);
            } else if (iiVar.riD.equals("MenuInfo")) {
                cVar.field_serviceInfoListStr = iiVar.mEl;
                cVar.lYV = JJ(cVar.field_serviceInfoListStr);
            } else if (iiVar.riD.equals("UserRole")) {
                cVar.field_userRole = bi.getInt(iiVar.mEl, 0);
            } else if (iiVar.riD.equals("BanReason")) {
                cVar.field_banReason = iiVar.mEl;
            } else if (iiVar.riD.equals("ShowRecommendArticle")) {
                cVar.field_showRecommendArticle = bi.getInt(iiVar.mEl, 0);
            } else if (iiVar.riD.equals("ShowService")) {
                cVar.field_showService = bi.getInt(iiVar.mEl, 0);
            }
        }
        return cVar;
    }

    private static List<d> JJ(String str) {
        List arrayList = new ArrayList();
        if (!bi.oW(str)) {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("button_list"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    d Y = d.Y(jSONArray.getJSONObject(i));
                    if (Y != null) {
                        arrayList.add(Y);
                    }
                }
            } catch (JSONException e) {
                x.k("MicroMsg.ProfileInfo", "", new Object[]{e});
            }
        }
        return arrayList;
    }

    private static List<a> JK(String str) {
        List arrayList = new ArrayList();
        if (!bi.oW(str)) {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("BizAccount"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    a W = a.W(jSONArray.getJSONObject(i));
                    if (W != null) {
                        arrayList.add(W);
                    }
                }
            } catch (JSONException e) {
                x.k("MicroMsg.ProfileInfo", "", new Object[]{e});
            }
        }
        return arrayList;
    }

    private static List<b> JL(String str) {
        List arrayList = new ArrayList();
        if (!bi.oW(str)) {
            try {
                JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("ArticleInfo"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    b X = b.X(jSONArray.getJSONObject(i));
                    if (X != null) {
                        arrayList.add(X);
                    }
                }
            } catch (JSONException e) {
                x.k("MicroMsg.ProfileInfo", "", new Object[]{e});
            }
        }
        return arrayList;
    }
}
