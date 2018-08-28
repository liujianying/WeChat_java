package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class GameJsApiOperateGameCenterMsg extends a {
    public static final int CTRL_BYTE = 174;
    public static final String NAME = "operateGameCenterMsg";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        String str = null;
        x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiOperateGameCenterMsg", "data is null");
            dVar.E(i, a.f("getGameMessages:fail_invalid_data", null));
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        OperateGameCenterMsgTask operateGameCenterMsgTask = new OperateGameCenterMsgTask();
        operateGameCenterMsgTask.nc = optInt;
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        operateGameCenterMsgTask.bPE = str;
        operateGameCenterMsgTask.fFC = new 1(this, operateGameCenterMsgTask, dVar, i);
        operateGameCenterMsgTask.ahA();
        GameWebViewMainProcessService.a(operateGameCenterMsgTask);
    }
}
