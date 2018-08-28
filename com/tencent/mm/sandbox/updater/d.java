package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.bf.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.f;

public final class d implements a {
    private Intent intent;
    private Notification owf;
    private a sDY;
    private int sDZ;
    private boolean sEa;
    private boolean sEb;

    /* synthetic */ d(byte b) {
        this();
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.sEa) {
            String bQ = bi.bQ(ad.getContext());
            x.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", new Object[]{bQ});
            if (bi.oW(bQ) || !bQ.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ad.getContext().sendBroadcast(intent);
                Context context = ad.getContext();
                android.support.v4.app.z.d dVar2 = new android.support.v4.app.z.d(context);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                dVar2.Y(a.cbg());
                dVar2.b(context.getString(R.l.webview_tbs_install_success_title));
                dVar2.c(context.getString(R.l.webview_tbs_install_success_content));
                dVar2.j(2, false);
                dVar2.u(true);
                dVar2.pu = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
                dVar.owf = dVar2.build();
                notificationManager.notify(dVar.sDZ, dVar.owf);
                intent = new Intent();
                intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                ad.getContext().sendBroadcast(intent);
            }
        }
    }

    static {
        r.a(ad.getContext(), new 1());
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.cdndownloader.e.a.aAr());
    }

    public static d cgU() {
        return b.sEd;
    }

    private d() {
        this.sDY = null;
        this.intent = new Intent();
        this.owf = null;
        this.sDZ = 999;
        this.sEa = false;
        this.sEb = false;
    }

    public final void la(boolean z) {
        if (this.sDY == null) {
            x.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            return;
        }
        Context context = ad.getContext();
        boolean isDownloading = f.isDownloading();
        boolean needDownload = f.needDownload(context, this.sEa | this.sEb);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean isDownloadForeground = f.isDownloadForeground();
        x.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isDownloading), Boolean.valueOf(needDownload), Boolean.valueOf(booleanExtra)});
        if ((z || booleanExtra) && !isDownloading && needDownload) {
            cgV();
            k.kB(3);
        } else if (!z && !booleanExtra && isDownloading && !isDownloadForeground) {
            f.stopDownload();
            k.kB(4);
        }
    }

    private void cgV() {
        f.startDownload(ad.getContext());
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", new Object[]{Boolean.valueOf(this.sEb), Boolean.valueOf(this.sEa)});
            if (this.sEb || this.sEa) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
    }

    public final boolean ao(Intent intent) {
        this.intent = intent;
        this.sEa = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.sEb = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        x.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", new Object[]{Boolean.valueOf(this.sEa), Boolean.valueOf(this.sEb)});
        if (f.isDownloading()) {
            x.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            return true;
        }
        Context context = ad.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        x.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[]{Integer.valueOf(installedTbsCoreVersion), Boolean.valueOf(f.needDownload(context, this.sEa | this.sEb)), Boolean.valueOf(ao.isWifi(context)), Boolean.valueOf(this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false))});
        if ((!ao.isWifi(context) && !r5) || !r4) {
            return false;
        }
        if (this.sDY == null) {
            this.sDY = new a(this, (byte) 0);
            com.tencent.xweb.x5.sdk.d.a(this.sDY);
            k.kB(2);
        }
        cgV();
        k.kB(3);
        return true;
    }

    public final boolean isBusy() {
        x.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", new Object[]{Boolean.valueOf(f.isDownloading()), Boolean.valueOf(com.tencent.xweb.x5.sdk.d.getTBSInstalling())});
        if (f.isDownloading() || r3) {
            return true;
        }
        return false;
    }

    public final void onDestroy() {
        x.i("MicroMsg.TBSDownloadMgr", "onDestroy");
    }
}
