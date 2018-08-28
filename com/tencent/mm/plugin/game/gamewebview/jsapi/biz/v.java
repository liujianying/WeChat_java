package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_BYTE = 14;
    public static final String NAME = "hideOptionMenu";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiHideOptionMenu", "invoke");
        e actionBar = dVar.getActionBar();
        if (actionBar == null) {
            x.e("MicroMsg.GameJsApiHideOptionMenu", "actionBar is null");
            return;
        }
        if (actionBar.jKe != null) {
            i iVar = actionBar.jKe;
            iVar.jKr.clear();
            iVar.jKr.addAll(iVar.jKs.values());
            iVar.jKr.removeAll(iVar.jKt);
        }
        dVar.E(i, a.f("hideOptionMenu:ok", null));
    }
}
