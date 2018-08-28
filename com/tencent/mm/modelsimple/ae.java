package com.tencent.mm.modelsimple;

import com.tencent.mm.aa.n;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class ae {
    private static e diJ = null;
    private static boolean egv = false;
    private static int egw = 3;
    private static long egx = 0;

    public static void run() {
        if (egv) {
            x.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            return;
        }
        if (egx == 0 || bi.bI(egx) > 180000) {
            egx = bi.VG();
            egw = 3;
        }
        if (egw <= 0) {
            x.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            return;
        }
        egw--;
        final String str = com.tencent.mm.compatible.util.e.dgs + "temp.avatar.hd";
        if (new File(str).exists()) {
            if (diJ == null) {
                diJ = new e() {
                    public final void a(int i, int i2, String str, l lVar) {
                        x.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.a.e.deleteFile(str);
                        }
                        ae.egv = false;
                        g.DF().b(157, ae.diJ);
                    }
                };
            }
            g.DF().a(157, diJ);
            g.DF().a(new n(1, str), 0);
            egv = true;
            return;
        }
        x.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
    }
}
