package com.tencent.mm.bx;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class a {
    public static int aH(float f) {
        return (int) ((ad.getContext().getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = 1;
        while (options.outWidth / i4 > i) {
            i4++;
        }
        while (i3 / i4 > i2) {
            i4++;
        }
        return i4;
    }

    public static void abD(String str) {
        int i = 0;
        x.i("MicroMsg.MMPhotoEditUtil", "[deleteDirAllFile] dir:%s", new Object[]{str});
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isFile() && !bi.oW(file2.getName()) && file2.getName().startsWith("wx_photo_edit_")) {
                        file2.delete();
                    }
                    i++;
                }
            }
        }
    }
}
