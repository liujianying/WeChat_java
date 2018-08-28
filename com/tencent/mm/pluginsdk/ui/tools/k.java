package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;

public final class k {
    private static String qTu = null;
    private static final String[] qTv = new String[]{"", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use"};

    public static void kB(int i) {
        eA(i, 0);
    }

    public static void eA(int i, int i2) {
        if (i <= 0 || i > 7) {
            x.e("MicroMsg.TBSReporter", "report invalid scene = %d", Integer.valueOf(i));
            return;
        }
        x.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", Integer.valueOf(i), qTv[i], Integer.valueOf(i2));
        Context context = ad.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        String fa = fa(context);
        h.mEJ.a(11633, false, true, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), fa, Integer.valueOf(i2));
    }

    private static String fa(Context context) {
        if (qTu != null) {
            return qTu;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(ad.getPackageName(), FileUtils.S_IWUSR);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("com.tencent.mtt.TBS_CODE");
                if (!bi.oW(string)) {
                    qTu = string;
                    return string;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", e.getMessage());
        }
        return null;
    }
}
