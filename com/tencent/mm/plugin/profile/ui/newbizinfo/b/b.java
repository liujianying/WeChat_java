package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public List<String> dhI;
    public String fIa;
    public String lZf;
    public int lZg;
    public List<String> lZh;
    public String lZi;
    public String lZj;
    public String lZk;
    public int status;
    public String title;
    public int type;

    public static b X(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.MessageInfo", "json is null, err");
            return null;
        }
        b bVar = new b();
        try {
            bVar.title = jSONObject.optString("Title");
            bVar.fIa = jSONObject.optString("CoverImgUrl");
            bVar.lZf = jSONObject.optString("ArticleUrl");
            bVar.lZg = jSONObject.optInt("IsOriginalArticle", 0);
            bVar.lZh = new ArrayList();
            bVar.dhI = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("UserInfoList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("HeadImgUrl");
                    String optString2 = optJSONObject.optString("UserName");
                    if (!(bi.oW(optString) || bi.oW(optString2))) {
                        bVar.lZh.add(optString);
                        bVar.dhI.add(optString2);
                    }
                }
            }
            bVar.lZi = jSONObject.optString("UserInfoListDesc");
            bVar.status = jSONObject.optInt("Status");
            bVar.type = jSONObject.optInt("Type");
            bVar.lZj = jSONObject.optString("AppMsgId");
            bVar.lZk = jSONObject.optString("ItemIndex");
            return bVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MessageInfo", e, "", new Object[0]);
            return bVar;
        }
    }
}
