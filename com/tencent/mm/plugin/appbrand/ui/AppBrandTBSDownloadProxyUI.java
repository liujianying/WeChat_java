package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;

@a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean gwr = false;
    private a gwp = null;
    private Runnable gwq;
    private Handler mHandler;
    p tipDialog;

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (!appBrandTBSDownloadProxyUI.isFinishing() && !appBrandTBSDownloadProxyUI.tlP) {
            6 6 = new 6(appBrandTBSDownloadProxyUI);
            if (DebuggerShell.aeq()) {
                6.onClick(null, 0);
                return;
            }
            7 7 = new 7(appBrandTBSDownloadProxyUI);
            c.a aVar = new c.a(appBrandTBSDownloadProxyUI.mController.tml);
            aVar.abu(appBrandTBSDownloadProxyUI.mController.tml.getString(j.app_brand_x5_install_tips));
            aVar.mF(false);
            aVar.Gt(j.app_brand_x5_install).a(6);
            aVar.Gu(j.app_brand_x5_cancel).b(7);
            aVar.anj().show();
            u.a.kB(true);
            h.mEJ.a(366, 1, 1, false);
        }
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (appBrandTBSDownloadProxyUI.gwp == null) {
            appBrandTBSDownloadProxyUI.gwp = new a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        d.a(appBrandTBSDownloadProxyUI.gwp);
        k.kB(3);
        f.startDownload(ad.getContext(), true);
    }

    static {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "TRACE_ORDER:AppBrandTBSDownloadProxyUI.java");
        r.a(ad.getContext(), new 1(), null, null);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = com.tencent.mm.ui.base.h.a(this.mController.tml, null, true, null);
        this.tipDialog.setOnCancelListener(new 5(this));
        j.a(getWindow());
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        sendBroadcast(intent);
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = d.getTBSInstalling();
        boolean isDownloadForeground = f.isDownloadForeground();
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[]{Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling)});
        if (isDownloading || tBSInstalling) {
            if (isDownloadForeground) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (gwr) {
                    setResult(0, new Intent());
                    finish();
                    return;
                }
                if (this.gwp == null) {
                    this.gwp = new a(this, (byte) 0);
                }
                d.a(this.gwp);
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                ActionBarActivity actionBarActivity = this.mController.tml;
                this.mController.tml.getString(j.app_tip);
                this.tipDialog = com.tencent.mm.ui.base.h.a(actionBarActivity, this.mController.tml.getString(j.app_brand_x5_installing_simple_tips), true, null);
                if (this.tipDialog.getWindow() != null) {
                    LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new 2(this));
                anA();
                return;
            }
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            f.stopDownload();
        }
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        f.a(this.mController.tml, false, true, new 3(this));
    }

    private void anA() {
        this.mHandler = new Handler();
        this.gwq = new 4(this);
        this.mHandler.postDelayed(this.gwq, 20000);
    }

    protected final void onDestroy() {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.gwq == null)) {
            this.mHandler.removeCallbacks(this.gwq);
        }
        super.onDestroy();
    }
}
