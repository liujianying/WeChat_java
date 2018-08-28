package com.tencent.mm.aw;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class e {
    private static e ehB = null;
    public at dRY = new at(1, "speex_worker");
    private byte[] dol = new byte[0];
    private String ehC;
    private com.tencent.mm.ab.e ehD = new 3(this);

    public static e RQ() {
        if (ehB == null) {
            ehB = new e();
        }
        return ehB;
    }

    public final void b(a aVar) {
        x.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.dRY.c(aVar);
    }

    public final void start() {
        if (ao.isWifi(ad.getContext())) {
            new ag(Looper.getMainLooper()).postDelayed(new 2(this), 100);
        }
    }

    private static File bo(int i, int i2) {
        File file = new File(b.RH());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i3 = 0;
        file = null;
        while (listFiles != null && i3 < listFiles.length) {
            file = listFiles[i3];
            if (file != null && file.isFile()) {
                x.d("MicroMsg.SpeexUploadCore", "file " + file.getPath());
                String path = file.getPath();
                long length = file.length();
                if (!file.getName().endsWith(".spx")) {
                    file = null;
                } else if (length >= ((long) i) && length <= ((long) i2)) {
                    return file;
                } else {
                    x.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[]{path, Integer.valueOf(i), Integer.valueOf(i2)});
                    com.tencent.mm.a.e.deleteFile(path);
                    file = null;
                }
            }
            i3++;
        }
        return file;
    }
}
