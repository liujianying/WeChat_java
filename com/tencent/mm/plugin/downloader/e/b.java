package com.tencent.mm.plugin.downloader.e;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static void a(long j, float f, int i) {
        x.d("MicroMsg.FileDownloadSP", "speed = " + f);
        String str = Math.round(100.0f * f) + "_" + i;
        x.d("MicroMsg.FileDownloadSP", "speedStr = " + str);
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("download_pref", 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(String.valueOf(j), "");
            if (bi.oW(string)) {
                str = "1_" + str + "|";
            } else {
                String[] split = string.split("\\|");
                str = string + (bi.getInt(split[split.length - 1].split("_")[0], 0) + 1) + "_" + str + "|";
            }
            x.d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = " + str);
            sharedPreferences.edit().putString(String.valueOf(j), str).apply();
        }
    }
}
