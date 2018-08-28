package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_BYTE = 104;
    public static final String NAME = "chooseImage";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiChooseImage", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseImage", "data is null");
            dVar.E(i, a.f("chooseImage:fail_invalid_data", null));
            return;
        }
        int i2;
        Serializable valueOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        int i3 = 0;
        if (optJSONArray != null) {
            x.i("MicroMsg.GameJsApiChooseImage", "sourceType = " + optJSONArray.toString());
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optString(i2).equals("album")) {
                    i3 |= 1;
                } else if (optJSONArray.optString(i2).equals("camera")) {
                    i3 |= 2;
                }
            }
        }
        i2 = i3;
        if (i2 == 0) {
            i2 = 3;
        }
        x.i("MicroMsg.GameJsApiChooseImage", "real scene = %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 2 || i2 == 3) {
            x.d("MicroMsg.GameJsApiChooseImage", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(pageActivity, "android.permission.CAMERA", 113, "", ""))});
            if (!com.tencent.mm.pluginsdk.permission.a.a(pageActivity, "android.permission.CAMERA", 113, "", "")) {
                dVar.E(i, a.f("chooseImage:fail_android_permission_denied", null));
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean valueOf2 = Boolean.valueOf(false);
        Boolean valueOf3 = Boolean.valueOf(false);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (optJSONArray2.optString(i3).equals("original")) {
                    valueOf2 = Boolean.valueOf(true);
                } else if (optJSONArray2.optString(i3).equals("compressed")) {
                    valueOf3 = Boolean.valueOf(true);
                }
            }
        }
        Object valueOf4;
        if (valueOf2.booleanValue() && !valueOf3.booleanValue()) {
            i3 = 7;
            valueOf4 = Boolean.valueOf(true);
        } else if (valueOf2.booleanValue() || !valueOf3.booleanValue()) {
            i3 = 8;
            valueOf4 = Boolean.valueOf(false);
        } else {
            i3 = 7;
            valueOf4 = Boolean.valueOf(false);
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", valueOf4);
        intent.putExtra("query_media_type", 1);
        x.i("MicroMsg.GameJsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(optInt), Integer.valueOf(i3), valueOf4});
        pageActivity.geJ = new 1(this, dVar, i, pageActivity);
        com.tencent.mm.bg.d.a(pageActivity, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
    }
}
