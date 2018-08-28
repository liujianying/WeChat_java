package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public String bgn;
    public String jmW;
    public String lZd;
    public int lZe;
    public String userName;

    public static a W(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.BizAccount", "json is null, err");
            return null;
        }
        a aVar = new a();
        try {
            aVar.userName = jSONObject.optString("UserName");
            aVar.bgn = jSONObject.optString("NickName");
            aVar.jmW = jSONObject.optString("HeadImgUrl");
            aVar.lZd = jSONObject.optString("FriendSubscribeDesc");
            aVar.lZe = jSONObject.optInt("IsSubscribed");
            return aVar;
        } catch (Exception e) {
            x.k("MicroMsg.BizAccount", "", new Object[]{e});
            return aVar;
        }
    }
}
