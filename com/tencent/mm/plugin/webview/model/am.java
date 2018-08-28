package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ah.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.HashSet;
import java.util.Set;

public final class am extends a {
    public static String pSK = "";

    public final int getType() {
        return 2;
    }

    public final void l(Context context, Intent intent) {
        String wO = c.wO(s.j(intent, "id"));
        String wO2 = c.wO(s.j(intent, "ext_info"));
        Object j = s.j(intent, "token");
        if (TextUtils.isEmpty(wO) || TextUtils.isEmpty(wO2) || TextUtils.isEmpty(j)) {
            x.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        if (!j.equals(d.bU(wO2, stringBuilder.append(com.tencent.mm.model.c.Df()).toString()))) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                x.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                return;
            }
            Set hashSet = new HashSet();
            for (String bU : stringSet) {
                hashSet.add(c.bU(wO2, bU));
            }
            if (!hashSet.contains(j)) {
                x.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", new Object[]{j});
                Toast.makeText(context, context.getString(R.l.wv_launch_shortcut_fail), 1).show();
                return;
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        String bU2 = "https://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + wO2;
        if (!bi.oW(pSK)) {
            bU2 = bU2 + "&" + pSK;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", bU2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", wO2);
        intent2.addFlags(67108864);
        intent2.addFlags(268435456);
        com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        z.Nk().km(wO);
        Object j2 = s.j(intent, "digest");
        if (TextUtils.isEmpty(j2)) {
            x.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            return;
        }
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(wO);
        if (Yg == null || bi.oW(Yg.BK())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            return;
        }
        String BK = Yg.BK();
        j kc = q.KH().kc(wO);
        if (kc == null || bi.oW(kc.Ky())) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
        } else if (j2.equals(g.u((BK + kc.Ky()).getBytes()))) {
            x.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
        } else {
            Bitmap a = com.tencent.mm.aa.c.a(wO, false, -1);
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                return;
            }
            x.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", new Object[]{BK});
            d.f(context, wO, wO2, c.wO(s.j(intent, "ext_info_1")));
            ah.i(new 1(this, wO, wO2), 1000);
        }
    }
}
