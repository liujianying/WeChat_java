package com.tencent.mm.sandbox.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.h;

final class d$a implements h {
    final /* synthetic */ d sEc;

    private d$a(d dVar) {
        this.sEc = dVar;
    }

    /* synthetic */ d$a(d dVar, byte b) {
        this(dVar);
    }

    public final void onDownloadFinish(int i) {
        x.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
        k.eA(5, i);
        if (i != f$k.AppCompatTheme_spinnerStyle) {
            if (i == 100) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(64, 64, 4, 3, 1, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(64, 3, 1, false);
            }
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("tbs_download_finished", true);
            edit.apply();
        }
    }

    public final void onInstallFinish(int i) {
        x.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
        k.eA(6, i);
        if (i == 200 || i == 220) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(64, 64, 7, 6, 1, 1, false);
            d.a(this.sEc);
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(64, 6, 1, false);
    }

    public final void onDownloadProgress(int i) {
    }
}
