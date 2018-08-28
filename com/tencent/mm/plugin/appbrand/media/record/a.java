package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.e.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static b ghX = null;
    private static String ghY = null;
    private static a ghZ = null;
    private static al gia = null;

    public interface a {
        void kz(int i);
    }

    private static void SO() {
        if (gia != null) {
            gia.SO();
        }
        gia = null;
    }

    public static boolean a(String str, a aVar, int i) {
        x.i("MicroMsg.Record.AudioRecorder", "startRecord");
        lg(1);
        if (bi.oW(str)) {
            x.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
            return false;
        }
        b bVar = new b(com.tencent.mm.compatible.b.b.a.daN);
        ghX = bVar;
        if (bVar.bDq == com.tencent.mm.compatible.b.b.a.daM) {
            if (bVar.bDo != null) {
                bVar.bDo.reset();
            }
        } else if (bVar.bDr != b.b.bDC) {
            bVar.release();
            bVar.wj();
        }
        ghX.wh();
        ghX.wi();
        ghX.wg();
        ghX.setOutputFile(str);
        ghX.a(new 2());
        try {
            ghX.prepare();
            ghX.start();
            ghZ = aVar;
            ghY = str;
            long j = (long) i;
            SO();
            al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean vD() {
                    a.lg(1);
                    return false;
                }
            }, false);
            gia = alVar;
            alVar.J(j, j);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", new Object[]{bi.i(e)});
            return false;
        }
    }

    public static void lg(int i) {
        x.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", new Object[]{Integer.valueOf(i)});
        if (!bi.oW(ghY)) {
            if (ghX == null) {
                x.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
                return;
            }
            ghX.wk();
            ghX.release();
            ghX = null;
            SO();
            ghY = null;
            if (ghZ != null) {
                ghZ.kz(i);
            }
            ghZ = null;
        }
    }
}
