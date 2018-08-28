package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_BYTE = 275;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "shareEmoticon";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiShareEmotion", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiShareEmotion", "data is null");
            aVar.tp(a.f("shareEmoticon:fail_null_data", null));
            return;
        }
        String optString = ti.optString("base64DataString");
        String optString2 = ti.optString("url");
        String L;
        if (bi.oW(optString)) {
            x.i("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon use url:%s", new Object[]{optString2});
            File file = new File(context.getCacheDir(), g.u(optString2.getBytes()));
            if (file.exists()) {
                optString2 = g.m(file);
                au.HU();
                L = EmojiLogic.L(c.Gg(), "", optString2);
                if (!FileOp.cn(L)) {
                    FileOp.y(file.getAbsolutePath(), L);
                }
                b(context, optString2, aVar);
                return;
            }
            com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
            aVar2.dXy = true;
            aVar2.dXA = file.getAbsolutePath();
            aVar2.dYc = new Object[]{file.getAbsolutePath()};
            i.aDZ().a(optString2, null, aVar2.Pt(), new 1(this, optString2, context, aVar));
            return;
        }
        x.i("MicroMsg.GameJsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (bi.bC(decode)) {
                aVar.tp(a.f("shareEmoticon:fail", null));
                return;
            }
            optString = g.u(decode);
            au.HU();
            L = EmojiLogic.L(c.Gg(), "", optString);
            if (!(e.cn(L) && g.cu(L).equalsIgnoreCase(optString))) {
                e.b(L, decode, decode.length);
            }
            b(context, optString, aVar);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            aVar.tp(a.f("shareEmoticon:fail_base64_decode_fail", null));
        }
    }

    final void b(Context context, String str, GameJsApiMMTask.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        if (context instanceof MMActivity) {
            ((MMActivity) context).geJ = new 2(this, aVar);
            com.tencent.mm.bg.d.b(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & 65535);
        }
    }
}
