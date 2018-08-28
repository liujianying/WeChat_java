package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.i;
import com.tencent.mm.y.m;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class l {

    /* renamed from: com.tencent.mm.ui.chatting.l$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ List gco;

        AnonymousClass1(List list) {
            this.gco = list;
        }

        public final void run() {
            List<bd> list = this.gco;
            if (!bi.cX(list)) {
                for (bd bdVar : list) {
                    if (bdVar.cky()) {
                        List<m> list2 = ((a) g.l(a.class)).wS(bdVar.field_content).dzs;
                        if (list2 != null) {
                            for (m mVar : list2) {
                                if (!bi.oW(mVar.dzI) && i.gr(mVar.dzD)) {
                                    b.Ka().a(new 2(mVar), mVar.dzI, null, ((com.tencent.mm.modelappbrand.g) g.l(com.tencent.mm.modelappbrand.g.class)).bc(112, 90));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void b(String str, com.tencent.mm.y.g.a aVar, String str2) {
        Bitmap bitmap = null;
        try {
            byte[] bArr = new byte[0];
            if (!bi.oW(str2) && (str2.startsWith("http://") || str2.startsWith("https://"))) {
                bitmap = b.Ka().a(str2, null);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                x.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                x.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i = s.fq(str) ? 1 : 0;
            com.tencent.mm.pluginsdk.model.app.l.a(aVar, aVar.dyT, aVar.title, str, null, bArr);
            h.mEJ.h(14127, new Object[]{aVar.dyT, aVar.dyS, aVar.dyR, aVar.title, aVar.description, "", aVar.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e, "", new Object[0]);
            x.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public static com.tencent.mm.y.g.a a(String str, m mVar) {
        com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
        aVar.title = mVar.title;
        aVar.description = mVar.dzA;
        aVar.type = 33;
        aVar.dyS = mVar.dzD;
        aVar.dyR = mVar.dzE;
        aVar.dyT = mVar.dzH;
        aVar.dyZ = mVar.dzG;
        aVar.dza = mVar.dzF;
        aVar.dyV = "";
        aVar.dyU = 2;
        aVar.url = mVar.url;
        aVar.dzb = mVar.dzJ;
        aVar.bZM = "wxapp_" + mVar.dzH + mVar.dzE;
        aVar.bZG = mVar.dzD;
        aVar.bZH = mVar.dzK;
        com.tencent.mm.y.a aVar2 = new com.tencent.mm.y.a();
        aVar2.dvC = false;
        aVar2.dvD = "";
        aVar.a(aVar2);
        if (bi.oW(aVar.thumburl)) {
            j kc = q.KH().kc(str);
            if (kc != null) {
                aVar.thumburl = kc.Kx();
            }
        }
        return aVar;
    }

    public static boolean e(bd bdVar, int i) {
        if (bdVar == null || !bdVar.cky()) {
            return false;
        }
        List list = ((a) g.l(a.class)).wS(bdVar.field_content).dzs;
        if (bi.cX(list)) {
            return false;
        }
        if (i < 0 || i >= list.size()) {
            i = 0;
        }
        if (i.gr(((m) list.get(i)).dzD)) {
            return true;
        }
        return false;
    }
}
