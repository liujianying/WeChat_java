package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;

public class be {
    private static be jOC;
    private static TMQQDownloaderOpenSDK jOD;

    private be() {
    }

    public static be aUD() {
        if (jOC == null) {
            synchronized (be.class) {
                if (jOC == null) {
                    jOC = new be();
                }
            }
        }
        return jOC;
    }

    private static TMQQDownloaderOpenSDK aUE() {
        if (jOD == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            jOD = instance;
            instance.initQQDownloaderOpenSDK(ad.getContext());
        }
        return jOD;
    }

    public static void aUF() {
        boolean z = false;
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(jOD == null);
        if (jOC == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (jOD != null) {
            jOD.destroyQQDownloaderOpenSDK();
        }
        jOD = null;
        jOC = null;
    }

    public static void am(Context context, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
        } else if (context == null) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
        } else {
            x.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[]{str});
            TMQQDownloaderOpenSDKParam Dz = new a((byte) 0).Dz(str);
            try {
                aUD();
                aUE().startToDownloadTaskList(context, Dz, true, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
            }
        }
    }

    public static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        try {
            aUD();
            TMAssistantDownloadTaskInfo downloadTaskState = aUE().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                return downloadTaskState.mState;
            }
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[]{e.getMessage()});
        }
        return -1;
    }

    public static int i(Context context, String str, int i) {
        int i2 = -1;
        if (bi.oW(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
        } else {
            try {
                PackageInfo packageInfo = p.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i2 = 1;
                } else {
                    x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[]{Integer.valueOf(packageInfo.versionCode)});
                    i2 = packageInfo.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[]{e.getMessage()});
            }
            x.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[]{Integer.valueOf(i2)});
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            return;
        }
        TMQQDownloaderOpenSDKParam Dz = new a((byte) 0).Dz(str);
        try {
            aUD();
            aUE().startToAuthorized(context, Dz, "1");
        } catch (Exception e) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[]{e.getMessage()});
        }
    }
}
