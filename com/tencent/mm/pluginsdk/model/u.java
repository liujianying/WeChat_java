package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u {
    private static long qzv;
    private static final Map<String, Object> qzw = new HashMap();

    static /* synthetic */ void fA(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(ad.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(268435456);
        ad.getContext().startActivity(intent);
    }

    static /* synthetic */ void fz(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        x.i("MicroMsg.TBSHelper", "TBS MiniQB cannot open this file:%s", new Object[]{str});
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        ad.getContext().sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static void al(Intent intent) {
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        if (System.currentTimeMillis() - qzv >= 1000 && !bi.oW(stringExtra)) {
            qzv = System.currentTimeMillis();
            Context context = ad.getContext();
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("path", stringExtra);
                jSONObject.putOpt("ext", stringExtra2);
                str = jSONObject.toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TBSHelper", e, "", new Object[0]);
            }
            x.i("MicroMsg.TBSHelper", "openFileByMiniQB, file pathinfo:%s", new Object[]{str});
            d.a(context, str, new 1(stringExtra, stringExtra2, context));
        }
    }

    public static void v(String str, Object obj) {
        qzw.put(str, obj);
        d.initTbsSettings(qzw);
    }
}
