package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.h;

final class AppBrandTBSDownloadProxyUI$a implements h {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    private AppBrandTBSDownloadProxyUI$a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    /* synthetic */ AppBrandTBSDownloadProxyUI$a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI, byte b) {
        this(appBrandTBSDownloadProxyUI);
    }

    public final void onDownloadFinish(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
        k.eA(5, i);
        if (i == 100 || i == 120 || i == 122) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(366, 4, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.a(366, 5, 1, false);
        }
        SharedPreferences sharedPreferences;
        Editor edit;
        if (i != 110) {
            if (i == 100 || i == 120 || i == 122) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(64, 64, 4, 3, 1, 1, false);
            } else {
                AppBrandTBSDownloadProxyUI.d(this.gws);
                d.a(AppBrandTBSDownloadProxyUI.e(this.gws));
                com.tencent.mm.plugin.report.service.h.mEJ.a(64, 3, 1, false);
                this.gws.setResult(0, new Intent());
                this.gws.finish();
            }
            sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
                return;
            }
            return;
        }
        sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
            edit = sharedPreferences.edit();
            edit.putBoolean("tbs_download_finished", true);
            edit.apply();
        }
        AppBrandTBSDownloadProxyUI.d(this.gws);
        d.a(AppBrandTBSDownloadProxyUI.e(this.gws));
        this.gws.setResult(0, new Intent());
        this.gws.finish();
    }

    public final void onInstallFinish(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
        if (this.gws.tipDialog != null) {
            this.gws.tipDialog.dismiss();
            this.gws.tipDialog = null;
        }
        k.eA(6, i);
        if (i == 200 || i == 220) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(64, 64, 7, 6, 1, 1, false);
            com.tencent.mm.plugin.report.service.h.mEJ.a(366, 6, 1, false);
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            this.gws.sendBroadcast(intent);
            AppBrandTBSDownloadProxyUI.d(this.gws);
            d.a(AppBrandTBSDownloadProxyUI.e(this.gws));
            this.gws.setResult(-1, new Intent());
            this.gws.finish();
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(64, 6, 1, false);
        com.tencent.mm.plugin.report.service.h.mEJ.a(366, 7, 1, false);
        AppBrandTBSDownloadProxyUI.d(this.gws);
        d.a(AppBrandTBSDownloadProxyUI.e(this.gws));
        this.gws.setResult(0, new Intent());
        this.gws.finish();
    }

    public final void onDownloadProgress(int i) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[]{Integer.valueOf(i)});
        if (this.gws.tipDialog != null) {
            ah.A(new 1(this, i));
        }
    }
}
