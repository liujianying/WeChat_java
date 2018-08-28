package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_BYTE = 111;
    public static final String NAME = "batchViewCard";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiBatchViewCard", "invoke");
        String optString = jSONObject.optString("card_list");
        String optString2 = jSONObject.optString("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", optString);
        intent.putExtra("key_template_id", optString2);
        intent.putExtra("key_from_scene", 7);
        GameWebViewUI pageActivity = dVar.getPageActivity();
        pageActivity.geJ = new 1(this, dVar, i);
        com.tencent.mm.bg.d.a(pageActivity, "card", ".ui.CardViewEntranceUI", intent, hashCode() & 65535, false);
    }
}
