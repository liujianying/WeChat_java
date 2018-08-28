package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class l$4 extends c<hv> {
    final /* synthetic */ l kDB;

    l$4(l lVar) {
        this.kDB = lVar;
        this.sFo = hv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hv hvVar = (hv) bVar;
        j aZh = l.aZh();
        bd bdVar = hvVar.bRi.bGS;
        ImageView imageView = hvVar.bRi.bRk;
        ProgressBar progressBar = hvVar.bRi.bRm;
        ImageView imageView2 = hvVar.bRi.bRl;
        int i = hvVar.bRi.bRn;
        int i2 = hvVar.bRi.w;
        int i3 = hvVar.bRi.h;
        String str = bdVar.field_content;
        if (!bi.oW(str)) {
            String trim;
            bd.b GS;
            aZh.w = i2;
            aZh.h = i3;
            if (aZh.w <= 0 || aZh.h <= 0) {
                aZh.w = h.CTRL_INDEX;
                aZh.h = h.CTRL_INDEX;
            }
            boolean z = bdVar.field_isSend == 0;
            if (s.fq(bdVar.field_talker) && z) {
                int iA = com.tencent.mm.model.bd.iA(str);
                if (iA != -1) {
                    trim = str.substring(iA + 1).trim();
                    GS = ((i) g.l(i.class)).bcY().GS(trim);
                    if (bdVar.cGH != 5 || aZh.kDa.contains(Long.valueOf(bdVar.field_msgId))) {
                        x.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.cGH)});
                        imageView2.setVisibility(0);
                        progressBar.setVisibility(8);
                    } else {
                        com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(bdVar.field_msgId, (float) GS.kCw, (float) GS.kCx, (int) (((double) GS.bSz) * 1.1d), 0);
                        progressBar.setVisibility(0);
                        imageView2.setVisibility(8);
                        k aZg = l.aZg();
                        aZg.w = i2;
                        aZg.h = i3;
                        if (aZg.w <= 0 || aZg.h <= 0) {
                            aZg.w = h.CTRL_INDEX;
                            aZg.h = h.CTRL_INDEX;
                        }
                        String b = k.b(bVar2);
                        if (e.cn(b)) {
                            if (!g.Eg().Dx()) {
                                b = "";
                            }
                        } else if (aZg.kDc == null || !aZg.kDc.toString().equals(bVar2.toString())) {
                            Iterator it = aZg.kDb.iterator();
                            while (it.hasNext()) {
                                if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                                    x.i("MicroMsg.StaticMapServer", "has add queue");
                                    aZg.OA();
                                    b = "";
                                    break;
                                }
                            }
                            aZg.kDb.add(bVar2);
                            x.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", new Object[]{Integer.valueOf(aZg.kDb.size()), Integer.valueOf(aZg.w), Integer.valueOf(aZg.h)});
                            aZg.OA();
                            b = "";
                        } else {
                            x.i("MicroMsg.StaticMapServer", "has add queue");
                            aZg.OA();
                            b = "";
                        }
                        if (bi.oW(b) || !e.cn(b)) {
                            aZh.kCV.put(Long.valueOf(bVar2.qyC), GS);
                            aZh.kCZ.put(Long.valueOf(bdVar.field_msgId), Integer.valueOf(i));
                            aZh.kCY.put(GS, bdVar);
                            aZh.kCU.put(Long.valueOf(bdVar.field_msgId), new WeakReference(imageView));
                            aZh.kCW.put(Long.valueOf(bdVar.field_msgId), new WeakReference(progressBar));
                            aZh.kCX.put(Long.valueOf(bdVar.field_msgId), new WeakReference(imageView2));
                            aZh.start();
                        } else {
                            x.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", new Object[]{Integer.valueOf(i)});
                            if (g.Eg().Dx()) {
                                Bitmap a = o.Pf().a(bdVar.field_msgId, b, i, aZh.w, aZh.h, z);
                                if (!(a == null || a.isRecycled())) {
                                    imageView.setImageBitmap(a);
                                    progressBar.setVisibility(8);
                                    imageView2.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
            trim = str;
            GS = ((i) g.l(i.class)).bcY().GS(trim);
            if (bdVar.cGH != 5) {
            }
            x.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.cGH)});
            imageView2.setVisibility(0);
            progressBar.setVisibility(8);
        }
        return false;
    }
}
