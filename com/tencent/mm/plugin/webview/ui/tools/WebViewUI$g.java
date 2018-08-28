package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.xweb.x5.a.a.a.a.b;

protected class WebViewUI$g extends b {
    final /* synthetic */ WebViewUI pZJ;

    public WebViewUI$g(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        String str2 = null;
        String str3 = "MicroMsg.WebViewUI";
        String str4 = "method = %s, bundler == null ? %b, invoker == null ? %b";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        objArr[2] = Boolean.valueOf(this.pZJ.gcO == null);
        x.i(str3, str4, objArr);
        if (bi.oW(str) || bundle == null || this.pZJ.gcO == null) {
            return str2;
        }
        String QT;
        try {
            QT = this.pZJ.gcO.QT("WebviewEnableTbsDownload");
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "get dynamic config failed");
            QT = str2;
        }
        x.i("MicroMsg.WebViewUI", "enable value = %s", new Object[]{QT});
        if (bi.oW(QT) || !QT.equals("0")) {
            Bundle g;
            if (str.equals(JsApiAddDownloadTask.NAME)) {
                try {
                    g = this.pZJ.gcO.g(14, bundle);
                    if (g != null) {
                        return Long.valueOf(g.getLong("download_id", 0));
                    }
                } catch (RemoteException e2) {
                    x.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
                }
            }
            if (str.equals(JsApiCancelDownloadTask.NAME)) {
                try {
                    g = this.pZJ.gcO.g(16, bundle);
                    if (g != null) {
                        return Boolean.valueOf(g.getBoolean("cancel_result", false));
                    }
                } catch (RemoteException e3) {
                    x.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
                }
            }
            if (str.equals("queryDownloadTask")) {
                try {
                    g = this.pZJ.gcO.g(15, bundle);
                    if (g != null) {
                        return Integer.valueOf(g.getInt("download_state", 0));
                    }
                } catch (RemoteException e4) {
                    x.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
                }
            }
            if (str.equals("installDownloadTask")) {
                try {
                    g = this.pZJ.gcO.g(17, bundle);
                    if (g != null) {
                        return Boolean.valueOf(g.getBoolean("install_result"));
                    }
                } catch (RemoteException e5) {
                    x.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
                }
            }
            if (str.equals("getDrawable")) {
                str3 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                int i = bundle.getInt("resourceId");
                if (!bi.oW(str3) && i > 0) {
                    try {
                        return a.b(this.pZJ.getPackageManager().getResourcesForApplication(str3), i);
                    } catch (Exception e6) {
                        x.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", new Object[]{str3, e6.getMessage()});
                    }
                }
            }
            if (!str.equals("getShareUrl")) {
                return str2;
            }
            try {
                x.i("MicroMsg.WebViewUI", "getShareUrl by x5 core, shareurl = %s", new Object[]{this.pZJ.gcO.Dp(this.pZJ.mhH.getUrl())});
                return this.pZJ.gcO.Dp(this.pZJ.mhH.getUrl());
            } catch (Exception e7) {
                x.e("MicroMsg.WebViewUI", "getShare url failed");
                return str2;
            }
        }
        x.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
        return str2;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return this.pZJ.pZm.z(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return this.pZJ.pZm.B(motionEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return this.pZJ.pZm.A(motionEvent);
    }

    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return this.pZJ.pZm.b(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        this.pZJ.pZm.onScrollChanged(i, i2, i3, i4, view);
    }

    public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        this.pZJ.pZm.c(i, i2, z, z2);
    }

    public final void computeScroll(View view) {
        this.pZJ.pZm.akr();
    }

    public final boolean onShowLongClickPopupMenu() {
        if (this.pZJ.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            return false;
        }
        return true;
    }
}
