package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_BYTE = 274;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "addToEmoticon";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiAddToEmotion", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            x.e("MicroMsg.GameJsApiAddToEmotion", "bundle is null");
            aVar.tp(a.f("addToEmoticon:fail_null_data", null));
            return;
        }
        String optString = ti.optString("base64DataString");
        String optString2 = ti.optString("thumbUrl");
        String optString3 = ti.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bi.oW(optString)) {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (bi.bC(decode)) {
                    aVar.tp(a.f("addToEmoticon:fail", null));
                    return;
                }
                optString = g.u(decode);
                au.HU();
                optString3 = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", optString);
                if (!(e.cn(optString3) && g.cu(optString3).equalsIgnoreCase(optString))) {
                    e.b(optString3, decode, decode.length);
                }
                a(context, optString, optString2, aVar);
            } catch (Exception e) {
                x.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon error:" + e.getMessage());
                aVar.tp(a.f("addToEmoticon:fail", null));
            }
        } else if (bi.oW(optString3)) {
            x.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            aVar.tp(a.f("addToEmoticon:fail_base64DataString_and_url_is_null", null));
        } else {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[]{optString3});
            File file = new File(context.getCacheDir(), g.u(optString3.getBytes()));
            if (file.exists()) {
                optString = g.m(file);
                au.HU();
                optString3 = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", optString);
                if (!FileOp.cn(optString3)) {
                    FileOp.y(file.getAbsolutePath(), optString3);
                }
                a(context, optString, optString2, aVar);
                return;
            }
            com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
            aVar2.dXy = true;
            aVar2.dXA = file.getAbsolutePath();
            aVar2.dYc = new Object[]{file.getAbsolutePath()};
            i.aDZ().a(optString3, null, aVar2.Pt(), new 1(this, optString3, context, optString2, aVar));
        }
    }

    static void a(Context context, String str, String str2, GameJsApiMMTask.a aVar) {
        au.HU();
        String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", str);
        EmojiInfo Zy = i.aEA().igx.Zy(str);
        if (Zy == null && e.cn(L)) {
            int i = o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.tcB;
            emojiInfo.field_type = i;
            emojiInfo.field_size = e.cm(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            i.aEA().igx.n(emojiInfo);
            Zy = emojiInfo;
        }
        if (Zy != null) {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddAction %b", new Object[]{Boolean.valueOf(i.aEw().a(context, Zy, 18, q.GF()))});
            if (i.aEw().a(context, Zy, 18, q.GF())) {
                aVar.tp(a.f("addToEmoticon:ok", null));
                return;
            } else {
                aVar.tp(a.f("addToEmoticon:fail", null));
                return;
            }
        }
        aVar.tp(a.f("addToEmoticon:fail", null));
    }
}
