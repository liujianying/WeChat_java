package com.tencent.mm.plugin.sight.encode.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b.2;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ String fUV;
    final /* synthetic */ a nfn;
    final /* synthetic */ int nfo;
    final /* synthetic */ b nfp;

    public b$3(b bVar, String str, a aVar, String str2, int i) {
        this.nfp = bVar;
        this.bAd = str;
        this.nfn = aVar;
        this.fUV = str2;
        this.nfo = i;
    }

    public final void run() {
        x.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", new Object[]{this.bAd});
        String nJ = s.nJ(this.bAd);
        if (-1 == t.a(nJ, this.bAd, null, 62)) {
            x.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", new Object[]{nJ});
            b.a(this.nfn, -1);
            return;
        }
        String Ll = d.Ll(this.fUV);
        if (!e.cn(Ll)) {
            x.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
            try {
                c.a(d.ad(this.fUV, 320, 240), 60, CompressFormat.JPEG, Ll, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
            }
        }
        o.Ta();
        e.y(Ll, s.nL(nJ));
        o.Ta();
        x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{this.bAd, Long.valueOf(e.y(this.fUV, s.nK(nJ)))});
        if (e.y(this.fUV, s.nK(nJ)) <= 0) {
            x.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", new Object[]{this.fUV, r0});
            b.a(this.nfn, -1);
            t.nP(nJ);
            return;
        }
        t.l(nJ, this.nfo, 62);
        t.nR(nJ);
        a aVar = this.nfn;
        if (aVar != null) {
            ah.A(new 2(aVar));
        }
        e.deleteFile(this.fUV);
        e.deleteFile(Ll);
    }
}
