package com.tencent.mm.bv;

import android.os.Environment;
import android.os.Process;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.Executors;

public final class c {
    private static boolean tfw = false;
    public static a tfx = null;

    static /* synthetic */ void mp(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.MemoryDumpOperation", "Hprof error uploadPath %s ", new Object[]{str});
        } else if (zZ()) {
            File file = new File(str);
            if (file.exists()) {
                String b = p.b(file, true, null);
                if (b != null) {
                    File file2 = new File(b);
                    if (!ao.isWifi(ad.getContext()) && file2.length() > 5242880) {
                        x.i("MicroMsg.MemoryDumpOperation", "Hprof not wifi exceed max size, size " + file2.length());
                        return;
                    } else if (tfx == null) {
                        x.e("MicroMsg.MemoryDumpOperation", "Hprof upload : no file upload impl set!");
                        return;
                    } else {
                        x.i("MicroMsg.MemoryDumpOperation", "Hprof upload : %b", new Object[]{Boolean.valueOf(tfx.Jz(b))});
                        if (tfx.Jz(b)) {
                            e.l(new File(b.tfv));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.MemoryDumpOperation", "Hprof upload file is not exist");
        } else {
            x.e("MicroMsg.MemoryDumpOperation", "Hprof sdcard invalid.");
        }
    }

    public static void DC(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        switch (i) {
            case 1:
                z = false;
                z2 = true;
                z3 = false;
                z4 = true;
                break;
            case 2:
                z = false;
                z2 = true;
                z3 = true;
                z4 = true;
                break;
            case 3:
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            case 4:
                z = true;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            case 5:
                z = true;
                z2 = false;
                z3 = true;
                z4 = false;
                break;
            case 6:
                x.i("MicroMsg.MemoryDumpOperation", "GC NOW.");
                System.gc();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
            default:
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                break;
        }
        x.d("MicroMsg.MemoryDumpOperation", "hprof operate: dump:%b, checkWifi:%b, uploadSingal:%b,uploadAll:%b,", new Object[]{Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z)});
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                if (c.tfw) {
                    x.w("MicroMsg.MemoryDumpOperation", "Hprof is mUploading");
                    return;
                }
                String V;
                if (z4) {
                    V = b.V(true, false);
                } else {
                    V = null;
                }
                Process.setThreadPriority(10);
                boolean isWifi = ao.isWifi(ad.getContext());
                if (!z3 || isWifi) {
                    if (!z2 || r0 == null) {
                        V = z ? b.tfv : null;
                    }
                    c.tfw = true;
                    c.mp(V);
                    c.tfw = false;
                    return;
                }
                x.w("MicroMsg.MemoryDumpOperation", "Hprof no wifi");
            }
        });
    }

    static boolean zZ() {
        try {
            return Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e) {
            return false;
        }
    }
}
