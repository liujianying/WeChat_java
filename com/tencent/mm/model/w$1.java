package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.w.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class w$1 extends ag {
    final /* synthetic */ w dBg;

    w$1(w wVar, Looper looper) {
        this.dBg = wVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            if (this.dBg.dBf != null) {
                c cVar = (c) message.obj;
                if (cVar.dBk && q.Pn()) {
                    String lZ = q.lZ(cVar.url);
                    x.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[]{lZ, cVar.filename, cVar.url});
                    Bitmap Wb = com.tencent.mm.sdk.platformtools.c.Wb(cVar.filename);
                    if (Wb == null) {
                        x.d("MicroMsg.GetPicService", "decode webp picture failed");
                        w.a(this.dBg, 14, 1);
                    } else if (!bi.oW(lZ)) {
                        if (lZ.toLowerCase().contains("png")) {
                            x.d("MicroMsg.GetPicService", "convert webp to png");
                            com.tencent.mm.sdk.platformtools.c.a(Wb, 100, CompressFormat.PNG, cVar.filename, true);
                        } else {
                            x.d("MicroMsg.GetPicService", "convert webp to jpg");
                            com.tencent.mm.sdk.platformtools.c.a(Wb, 100, CompressFormat.JPEG, cVar.filename, true);
                        }
                    }
                }
                int cm = e.cm(cVar.filename);
                if (cm > 0 && g.Eg().Dx()) {
                    a.dBs.aY(cm, 0);
                }
                ah.A(new 1(this, cVar));
            }
        } catch (Throwable e) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e)});
        }
    }
}
