package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class e {
    public static void DB(String str) {
        if (!bi.oW(str)) {
            FileDownloadTaskInfo yO = d.aCU().yO(str);
            c DC = ((c) g.l(c.class)).aSl().DC(str);
            if (yO == null || yO.id <= 0) {
                if (DC != null) {
                    a(str, 0, "", 0, 3, 0, DC.field_noWifi, DC.field_noSdcard, DC.field_noEnoughSpace, DC.field_lowBattery, DC.field_continueDelay, "");
                } else {
                    a(str, 0, "", 0, 3, 0, false, false, false, false, false, "");
                }
            } else if (DC != null) {
                a(str, yO.id, yO.url, yO.gTK == 0 ? 0 : (int) ((yO.icq * 100) / yO.gTK), 3, 0, DC.field_noWifi, DC.field_noSdcard, DC.field_noEnoughSpace, DC.field_lowBattery, DC.field_continueDelay, "");
            } else {
                a(str, yO.id, yO.url, yO.gTK == 0 ? 0 : (int) ((yO.icq * 100) / yO.gTK), 3, 0, false, false, false, false, false, "");
            }
        }
    }

    static void U(String str, int i, int i2) {
        if (!bi.oW(str) && ((c) g.l(c.class)).aSl().DC(str) != null) {
            C(str, i, i2);
        }
    }

    static void C(String str, int i, int i2) {
        if (!bi.oW(str)) {
            FileDownloadTaskInfo yO = d.aCU().yO(str);
            if (yO == null || yO.id <= 0) {
                a(str, 0, "", 0, i, i2, false, false, false, false, false, "");
            } else {
                a(str, yO.id, yO.url, yO.gTK == 0 ? 0 : (int) ((yO.icq * 100) / yO.gTK), i, i2, false, false, false, false, false, "");
            }
        }
    }

    private static void a(String str, long j, String str2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3) {
        String str4;
        x.i("MicroMsg.GameSilentDownloadReporter", "reportInfo, appId:%s, downloadId:%d, downloadUrl:%s, downloadedPct:%d, finishType:%d, errCode:%d, noWifi:%b, noSdcard:%b, noEnoughSpace:%b, lowBattery:%b, continueDelay:%b", new Object[]{str, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)});
        try {
            if (bi.oW(str2)) {
                str4 = str2;
            } else {
                str4 = URLEncoder.encode(str2, "UTF-8");
            }
            try {
                if (!bi.oW(str3)) {
                    str3 = URLEncoder.encode(str3, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
            }
        } catch (UnsupportedEncodingException e2) {
            str4 = str2;
        }
        Object[] objArr = new Object[12];
        objArr[0] = str;
        objArr[1] = Long.valueOf(j);
        objArr[2] = str4;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = Integer.valueOf(z2 ? 1 : 0);
        objArr[8] = Integer.valueOf(z3 ? 1 : 0);
        objArr[9] = Integer.valueOf(z4 ? 1 : 0);
        objArr[10] = Integer.valueOf(z5 ? 1 : 0);
        objArr[11] = str3;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i4 = 0; i4 < 11; i4++) {
            stringBuilder.append(String.valueOf(objArr[i4])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[11]));
        g.DF().a(new am(15547, stringBuilder.toString()), 0);
    }
}
