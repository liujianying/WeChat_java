package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;

public final class u$a {
    private static boolean qzz = false;

    static {
        x.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
        r.a(ad.getContext(), new 1(), null, null);
    }

    public static void eP(Context context) {
        long j;
        long currentTimeMillis;
        x.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            j = sharedPreferences.getLong("last_check_xwalk", 0);
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j >= 1800000) {
                Editor edit = sharedPreferences.edit();
                edit.putLong("last_check_xwalk", currentTimeMillis);
                edit.apply();
                T(context, 4);
            }
        }
        int i = 1;
        x.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", new Object[]{Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false))});
        if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
            i = 2;
        } else if (e.chv()) {
            x.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
            return;
        }
        if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
            x.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", new Object[]{r2, Boolean.valueOf(ao.isWifi(context))});
            if (ao.isWifi(context)) {
                Object obj;
                Intent intent;
                if (sharedPreferences == null) {
                    x.e("MicroMsg.TBSDownloadChecker", "sp is null");
                } else {
                    j = sharedPreferences.getLong("last_check_ts", 0);
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j > 7200000) {
                        Editor edit2 = sharedPreferences.edit();
                        edit2.putLong("last_check_ts", currentTimeMillis);
                        edit2.apply();
                        obj = 1;
                        if (obj == null) {
                            x.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[]{Integer.valueOf(WebView.getInstalledTbsCoreVersion(context))});
                            if (WebView.getInstalledTbsCoreVersion(context) > 0) {
                                return;
                            }
                        }
                        intent = new Intent();
                        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                        intent.putExtra("intent_extra_download_type", i);
                        context.startService(intent);
                        x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                        return;
                    }
                }
                obj = null;
                if (obj == null) {
                    x.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", new Object[]{Integer.valueOf(WebView.getInstalledTbsCoreVersion(context))});
                    if (WebView.getInstalledTbsCoreVersion(context) > 0) {
                        return;
                    }
                }
                intent = new Intent();
                intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", i);
                context.startService(intent);
                x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                return;
            }
            x.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
            return;
        }
        x.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", new Object[]{sharedPreferences.getString("tbs_download", null)});
    }

    public static void T(Context context, int i) {
        if (!e.chv()) {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", i);
            context.startService(intent);
            x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
        }
    }

    public static void cbB() {
        if (e.chv()) {
            x.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
        } else if (f.il(ad.getContext()) && WebView.getInstalledTbsCoreVersion(ad.getContext()) <= 0) {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 1);
            ad.getContext().startService(intent);
            x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        }
    }

    public static boolean cbC() {
        return f.isDownloading() || d.getTBSInstalling() || qzz;
    }

    public static void kB(boolean z) {
        qzz = z;
    }

    public static int cbD() {
        if (!e.chv()) {
            if (d.getTbsVersion(ad.getContext()) < 36824) {
                x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", new Object[]{Integer.valueOf(d.getTbsVersion(ad.getContext()))});
                return 1;
            } else if (d.canOpenWebPlus(ad.getContext())) {
                x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", new Object[]{Integer.valueOf(r2)});
                return 0;
            } else {
                x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", new Object[]{Integer.valueOf(r2)});
                return 1;
            }
        } else if (com.tencent.mm.compatible.util.d.fS(17)) {
            x.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
            return 2;
        } else {
            x.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
            return 0;
        }
    }

    public static int cbE() {
        if (com.tencent.mm.compatible.util.d.fR(19) || com.tencent.mm.compatible.util.d.fS(16)) {
            return 1;
        }
        if (WebView.getInstalledTbsCoreVersion(ad.getContext()) > 0) {
            return 4;
        }
        if (f.isDownloading()) {
            return 2;
        }
        if (d.getTBSInstalling()) {
            return 3;
        }
        x.i("MicroMsg.TBSDownloadChecker", "oversea = %b", new Object[]{Boolean.valueOf(ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false))});
        if (ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
            return 2;
        }
        x.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
        return 0;
    }

    public static void eQ(Context context) {
        Intent intent = new Intent();
        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
        intent.putExtra("intent_extra_download_type", 2);
        intent.putExtra("intent_extra_download_ignore_network_type", true);
        context.startService(intent);
        x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
        }
    }
}
