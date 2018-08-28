package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$4 implements Runnable {
    final /* synthetic */ String fUV;
    final /* synthetic */ a nfn;
    final /* synthetic */ int nfo;
    final /* synthetic */ b nfp;
    final /* synthetic */ List nfq;
    final /* synthetic */ String nfr;

    public b$4(b bVar, String str, List list, String str2, a aVar, int i) {
        this.nfp = bVar;
        this.fUV = str;
        this.nfq = list;
        this.nfr = str2;
        this.nfn = aVar;
        this.nfo = i;
    }

    public final void run() {
        int i;
        long j;
        String Ll = d.Ll(this.fUV);
        if (!e.cn(Ll)) {
            x.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
            try {
                c.a(d.ad(this.fUV, 320, aq.CTRL_BYTE), 60, CompressFormat.JPEG, Ll, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String) this.nfq.get(0));
        int i2 = 1;
        while (true) {
            i = i2;
            if (i >= this.nfq.size()) {
                break;
            }
            stringBuilder.append(',');
            stringBuilder.append((String) this.nfq.get(i));
            i2 = i + 1;
        }
        String stringBuilder2 = stringBuilder.toString();
        Cursor b = o.Ta().dCZ.b("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
        if (b == null) {
            j = 0;
        } else {
            j = 0;
            if (b.moveToFirst()) {
                j = b.getLong(0);
            }
            b.close();
        }
        long j2 = 1 + j;
        i2 = 0;
        while (true) {
            i = i2;
            if (i < this.nfq.size()) {
                String str = (String) this.nfq.get(i);
                x.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", new Object[]{str, Long.valueOf(j2), stringBuilder2, this.nfr});
                String nJ = s.nJ(str);
                o.Ta();
                String nL = s.nL(nJ);
                o.Ta();
                String nK = s.nK(nJ);
                x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", new Object[]{str, Long.valueOf(e.y(Ll, nL))});
                if (e.y(Ll, nL) <= 0) {
                    x.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", new Object[]{Ll, nL, Integer.valueOf(i)});
                    b.a(this.nfn, i);
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{str, Long.valueOf(e.y(this.fUV, nK))});
                    if (e.y(this.fUV, nK) <= 0) {
                        x.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", new Object[]{this.fUV, nK, Integer.valueOf(i)});
                        b.a(this.nfn, i);
                    } else {
                        int i3 = this.nfo;
                        nK = this.nfr;
                        r rVar = new r();
                        rVar.fileName = nJ;
                        rVar.enM = i3;
                        rVar.bWJ = str;
                        rVar.enF = (String) g.Ei().DT().get(2, "");
                        rVar.createTime = bi.VE();
                        rVar.enK = bi.VE();
                        rVar.enS = null;
                        rVar.elu = null;
                        rVar.enQ = 0;
                        rVar.enT = 3;
                        o.Ta();
                        i2 = s.nM(s.nK(nJ));
                        if (i2 <= 0) {
                            x.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:" + nJ);
                        } else {
                            rVar.dHI = i2;
                            o.Ta();
                            str = s.nL(nJ);
                            i3 = s.nM(str);
                            if (i3 <= 0) {
                                x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i3);
                            } else {
                                rVar.enJ = i3;
                                x.i("MicroMsg.VideoLogic", "initMassSendSight file:" + nJ + " thumbsize:" + rVar.enJ + " videosize:" + rVar.dHI);
                                rVar.status = 200;
                                x.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", new Object[]{Long.valueOf(j2), nK, stringBuilder2});
                                rVar.enU = stringBuilder2;
                                rVar.emf = j2;
                                rVar.cas = nK;
                                o.Ta().a(rVar);
                            }
                        }
                    }
                }
                i2 = i + 1;
            } else {
                t.bC(j2);
                e.deleteFile(this.fUV);
                e.deleteFile(Ll);
                return;
            }
        }
    }
}
