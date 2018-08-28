package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static final int els = b.AC();
    String bOX = null;
    Context context = null;
    int duration = 0;
    public a elt = null;
    String elu = null;
    final AsyncTask<String, Integer, String> elv = new AsyncTask<String, Integer, String>() {
        int ret = 0;

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (c.this.elt != null) {
                c.this.elt.b(this.ret, c.this.fileName, c.this.elu, c.this.duration);
            }
        }

        private String SI() {
            com.tencent.mm.compatible.j.a.a j;
            Throwable e;
            this.ret = 0;
            boolean is2G = ao.is2G(ad.getContext());
            try {
                j = com.tencent.mm.compatible.j.a.j(c.this.context, c.this.intent);
            } catch (Throwable e2) {
                x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e2)});
                j = null;
            }
            if (j == null) {
                x.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                h.mEJ.a(106, 244, 1, false);
                this.ret = -50005;
                return null;
            }
            c.this.elu = j.filename;
            int cm = e.cm(c.this.elu);
            x.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", new Object[]{Boolean.valueOf(is2G), Integer.valueOf(cm), Integer.valueOf(j.duration), c.this.elu});
            if (cm <= 0) {
                h.mEJ.a(106, 244, 1, false);
                this.ret = -50001;
                return null;
            }
            if (cm > (is2G ? 10485760 : c.els)) {
                h.mEJ.a(106, 245, 1, false);
                this.ret = -50002;
                return null;
            }
            j.q(c.this.elu, c.this.videoPath, false);
            c.this.duration = j.duration / 1000;
            Object obj = 1;
            if (j.bitmap != null) {
                try {
                    com.tencent.mm.sdk.platformtools.c.a(j.bitmap, 60, CompressFormat.JPEG, c.this.bOX, true);
                    try {
                        h.mEJ.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e2 = e3;
                        obj = null;
                        x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e2)});
                        if (obj != null) {
                            try {
                                h.mEJ.a(106, 232, 1, false);
                                com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, CompressFormat.JPEG, c.this.bOX, true);
                            } catch (Throwable e22) {
                                x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e22)});
                            }
                        }
                        if (!e.cn(c.this.videoPath)) {
                            this.ret = -50003;
                        }
                        if (!e.cn(c.this.bOX)) {
                            this.ret = -50004;
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e22)});
                    if (obj != null) {
                        try {
                            h.mEJ.a(106, 232, 1, false);
                            com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, CompressFormat.JPEG, c.this.bOX, true);
                        } catch (Throwable e222) {
                            x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e222)});
                        }
                    }
                    if (e.cn(c.this.videoPath)) {
                        this.ret = -50003;
                    }
                    if (e.cn(c.this.bOX)) {
                        this.ret = -50004;
                    }
                    return null;
                }
            }
            if (obj != null) {
                try {
                    h.mEJ.a(106, 232, 1, false);
                    com.tencent.mm.sdk.platformtools.c.a(com.tencent.mm.sdk.platformtools.c.ah(-16777216, 320, 480), 60, CompressFormat.JPEG, c.this.bOX, true);
                } catch (Throwable e2222) {
                    x.e("MicroMsg.ImportVideo", "exception:%s", new Object[]{bi.i(e2222)});
                }
            }
            if (e.cn(c.this.videoPath)) {
                this.ret = -50003;
            }
            if (e.cn(c.this.bOX)) {
                this.ret = -50004;
            }
            return null;
        }
    };
    String fileName = null;
    Intent intent = null;
    String videoPath = null;

    public interface a {
        void b(int i, String str, String str2, int i2);
    }

    public final void a(Context context, Intent intent, a aVar) {
        this.context = context;
        this.intent = intent;
        this.fileName = s.nJ((String) g.Ei().DT().get(2, ""));
        o.Ta();
        this.bOX = s.nL(this.fileName);
        o.Ta();
        this.videoPath = s.nK(this.fileName);
        this.elt = aVar;
        this.elv.execute(new String[0]);
    }
}
