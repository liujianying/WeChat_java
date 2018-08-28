package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class e$4 extends c<cm> {
    final /* synthetic */ e pUl;

    e$4(e eVar) {
        this.pUl = eVar;
        this.sFo = cm.class.getName().hashCode();
    }

    private static boolean a(cm cmVar) {
        if (cmVar instanceof cm) {
            Editor edit = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
            String value = g.AT().getValue("WebviewDownloadTbs");
            String value2 = g.AT().getValue("WebviewEnableTbs");
            String value3 = g.AT().getValue("WebviewSupportedTbsVersionSection");
            x.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[]{value, value2, value3});
            if (value != null) {
                edit.putString("tbs_download", value);
            }
            edit.apply();
            if ("1".equals(value) && "1".equals(value2)) {
                k.kB(1);
            }
            if (value != null) {
                try {
                    if ("0".equals(value)) {
                        x.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(ad.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                        ad.getContext().sendBroadcast(intent);
                    }
                } catch (Exception e) {
                    x.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
