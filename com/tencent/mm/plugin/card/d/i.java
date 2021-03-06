package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class i {
    public static f xT(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.hwk = jSONObject.optString("empty_tips");
            fVar.hwl = jSONObject.optString("shoppingmall_title");
            fVar.hwm = jSONObject.optString("shoppingmall_url");
            fVar.hwn = jSONObject.optInt("is_show") != 0;
            return fVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardMallItemParser", e, "", new Object[0]);
            return null;
        }
    }
}
