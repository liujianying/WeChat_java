package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_BYTE = 254;
    public static final String NAME = "chooseMedia";
    private MMActivity.a fEk = new 4(this);
    int fFw;
    GameWebViewUI jGT;
    d jGU;

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiChooseMedia", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseMedia", "data is null");
            dVar.E(i, a.f("doChooseMedia:fail_invalid_data", null));
            return;
        }
        this.jGU = dVar;
        this.fFw = i;
        this.jGT = dVar.getPageActivity();
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.jGT, "android.permission.CAMERA", 119, "", ""))});
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.jGT, "android.permission.RECORD_AUDIO", 120, "", ""))});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.jGT, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String oV = bi.oV(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            x.i("MicroMsg.GameJsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{oV, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3});
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_count", optInt);
            if (min <= 0) {
                min = 10;
            }
            intent.putExtra("key_pick_local_media_duration", min);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("key_pick_local_media_video_type", 2);
            intent.putExtra("key_pick_local_media_sight_type", optString);
            intent.putExtra("key_pick_local_pic_query_source_type", (optString3.contains("original") ^ optString3.contains("compressed")) != 0 ? 7 : 8);
            intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(optString3.contains("compressed")));
            if (bi.oW(oV)) {
                str = "album|camera";
            } else {
                str = oV;
            }
            if (str.contains("album") && str.contains("camera")) {
                k kVar = new k(this.jGT);
                kVar.b(null, new 1(this), new 2(this, optString2, intent));
                kVar.d(new 3(this, dVar, i));
                kVar.bEo();
                return;
            } else if (str.contains("album")) {
                K(intent);
                return;
            } else if (str.contains("camera")) {
                a(optString2, intent);
                return;
            } else {
                dVar.E(i, a.f("chooseMedia:fail_sourceType_error", null));
                return;
            }
        }
        dVar.E(i, a.f("doChooseMedia:fail_no_user_permission", null));
    }

    final void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.jGT.geJ = this.fEk;
        com.tencent.mm.bg.d.a(this.jGT, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }

    final void K(Intent intent) {
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", 4096);
        this.jGT.geJ = this.fEk;
        com.tencent.mm.bg.d.a(this.jGT, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }
}
