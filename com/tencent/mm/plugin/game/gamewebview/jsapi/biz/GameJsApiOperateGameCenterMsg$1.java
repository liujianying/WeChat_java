package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg.OperateGameCenterMsgTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class GameJsApiOperateGameCenterMsg$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ OperateGameCenterMsgTask jHo;
    final /* synthetic */ GameJsApiOperateGameCenterMsg jHp;

    GameJsApiOperateGameCenterMsg$1(GameJsApiOperateGameCenterMsg gameJsApiOperateGameCenterMsg, OperateGameCenterMsgTask operateGameCenterMsgTask, d dVar, int i) {
        this.jHp = gameJsApiOperateGameCenterMsg;
        this.jHo = operateGameCenterMsgTask;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void run() {
        this.jHo.ahB();
        Map hashMap = new HashMap();
        hashMap.put("result", bi.oV(this.jHo.result));
        this.jGF.E(this.doP, GameJsApiOperateGameCenterMsg.f("getGameMessages:ok", hashMap));
    }
}
