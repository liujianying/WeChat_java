package com.tencent.mm.ak.a.g;

import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String bnC = h.getExternalStorageDirectory().getAbsolutePath();
    public static final String bnE = (bnC + "/tencent/MicroMsg/");
    public static final String dYs = (bnE + ".tmp");
    public static long dYt = 0;

    public static String Pw() {
        x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", new Object[]{dYs + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()))});
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dYs);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        return r0;
    }

    public static boolean Px() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - dYt > 86400000) {
            x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            dYt = currentTimeMillis;
            return true;
        }
        x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        return false;
    }

    public static boolean Py() {
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dYs);
        try {
            if (!bVar.exists() || bVar.isFile()) {
                return true;
            }
            a(bVar, true);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            return false;
        }
    }

    private static void a(com.tencent.mm.vfs.b bVar, boolean z) {
        if (bVar != null && bVar.exists() && bVar.isDirectory()) {
            com.tencent.mm.vfs.b[] cBY = bVar.cBY();
            if (cBY != null && cBY.length > 0) {
                for (com.tencent.mm.vfs.b bVar2 : cBY) {
                    if (bVar2 != null && bVar2.exists()) {
                        if (!bVar2.isFile()) {
                            int i;
                            x.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(bVar2.lastModified())});
                            if (System.currentTimeMillis() - bVar2.lastModified() >= 259200000) {
                                i = 1;
                            } else {
                                boolean i2 = false;
                            }
                            if (i2 != 0 && z) {
                                a(bVar2, false);
                            }
                        } else if (bVar2 != null && bVar2.isFile() && bVar2.exists()) {
                            bVar2.delete();
                        }
                    }
                }
            }
            bVar.delete();
        }
    }
}
