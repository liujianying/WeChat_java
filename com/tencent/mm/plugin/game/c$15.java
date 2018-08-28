package com.tencent.mm.plugin.game;

import android.content.Intent;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class c$15 extends c<lh> {
    final /* synthetic */ c jFM;

    c$15(c cVar) {
        this.jFM = cVar;
        this.sFo = lh.class.getName().hashCode();
    }

    private static boolean a(lh lhVar) {
        int i;
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject(lhVar.bVG.extraInfo);
            str = jSONObject.optString("appId");
            i = bi.getInt(jSONObject.optString("ssid"), 0);
        } catch (JSONException e) {
            x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            i = 0;
        } catch (Exception e2) {
            x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", new Object[]{e2.getMessage()});
            i = 0;
        }
        Intent intent = new Intent();
        switch (lhVar.bVG.bVH) {
            case 0:
                intent.setClass(lhVar.bVG.context, GameCenterUI.class);
                if (lhVar.bVG.jumpType == 1) {
                    intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                }
                intent.putExtra("game_report_from_scene", 5);
                lhVar.bVG.context.startActivity(intent);
                an.a(lhVar.bVG.context, 5, 5, 1, 6, i, null);
                break;
            case 1:
                intent.setClass(lhVar.bVG.context, GameLibraryUI.class);
                if (lhVar.bVG.jumpType == 1) {
                    intent.putExtra("jump_game_center", "jump_game_center");
                }
                intent.putExtra("game_report_from_scene", 5);
                lhVar.bVG.context.startActivity(intent);
                an.a(lhVar.bVG.context, 5, 5, 1, 6, i, null);
                break;
            case 2:
                if (!bi.oW(str)) {
                    intent.setClass(lhVar.bVG.context, GameDetailUI.class);
                    intent.putExtra("game_app_id", str);
                    if (lhVar.bVG.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.bVG.context.startActivity(intent);
                    an.a(lhVar.bVG.context, 5, 5, 1, 6, i, null);
                    break;
                }
                break;
            case 3:
                intent.setClass(lhVar.bVG.context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", 5);
                lhVar.bVG.context.startActivity(intent);
                an.a(lhVar.bVG.context, 5, 5, 1, 6, i, null);
                break;
        }
        return false;
    }
}
