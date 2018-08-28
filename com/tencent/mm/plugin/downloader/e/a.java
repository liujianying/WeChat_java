package com.tencent.mm.plugin.downloader.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

public final class a {
    public static boolean yW(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
            return false;
        }
        x.i("MicroMsg.DownloadAppUtil", "installApk, path = " + str);
        if (e.cn(str)) {
            Uri fromFile = Uri.fromFile(new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, Downloads.CONTENT_TYPE_APK);
            intent.addFlags(268435456);
            try {
                ad.getContext().startActivity(intent);
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.DownloadAppUtil", "install app failed: " + fromFile.toString() + ", ex = " + e.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
        return false;
    }

    public static void a(String str, int i, long j, String str2) {
        gt gtVar = new gt();
        gtVar.bPU.appId = str;
        gtVar.bPU.scene = i;
        gtVar.bPU.bGm = j;
        gtVar.bPU.channelId = str2;
        gtVar.bPU.opType = 4;
        com.tencent.mm.sdk.b.a.sFg.m(gtVar);
    }
}
