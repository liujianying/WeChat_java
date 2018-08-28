package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f {
    public static String yV(String str) {
        Exception e;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    x.i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        x.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", new Object[]{e.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return "";
        } catch (Exception e3) {
            e = e3;
            x.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", new Object[]{e.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return "";
        }
    }

    public static a c(e eVar) {
        a aVar = new a();
        aVar.field_downloadUrl = eVar.fhq;
        aVar.field_secondaryUrl = eVar.ica;
        aVar.field_fileSize = eVar.icb;
        aVar.field_downloadUrlHashCode = eVar.fhq.hashCode();
        aVar.field_fileName = eVar.mFileName;
        aVar.field_fileType = eVar.icd;
        aVar.field_md5 = eVar.icc;
        aVar.field_appId = eVar.mAppId;
        aVar.field_autoInstall = eVar.ice;
        aVar.field_showNotification = eVar.fHC;
        aVar.field_packageName = eVar.mPackageName;
        aVar.field_autoDownload = eVar.icg;
        aVar.field_scene = eVar.fdx;
        aVar.field_downloadInWifi = eVar.fGM;
        aVar.field_fromWeApp = eVar.icj;
        aVar.field_extInfo = eVar.fHA;
        return aVar;
    }
}
