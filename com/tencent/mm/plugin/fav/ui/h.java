package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import com.tencent.mm.y.g.a;
import java.util.LinkedList;
import java.util.List;

public final class h {
    static /* synthetic */ void b(Context context, String str, vx vxVar) {
        b bVar = new b(com.tencent.mm.plugin.fav.a.b.b(vxVar));
        wa waVar;
        if (bVar.exists()) {
            b bVar2 = new b(com.tencent.mm.plugin.fav.a.b.c(vxVar));
            String uri = bVar2.exists() ? bVar2.cBX().toString() : com.tencent.mm.plugin.fav.a.b.aKO() + g.u(bi.aG(vxVar.bJv, "").getBytes());
            x.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{bVar.cBX().toString(), uri});
            bri bri = null;
            waVar = vxVar.rAo;
            if (waVar != null) {
                bri = new bri();
                bri.dyO = waVar.dyO;
                bri.dyL = waVar.dyL;
                bri.rBq = waVar.rBq;
                bri.dyJ = waVar.dyJ;
                bri.dyM = waVar.dyM;
                bri.dyP = waVar.dyP;
                bri.dyQ = waVar.dyQ;
            }
            if (bri != null) {
                com.tencent.mm.plugin.messenger.a.g.bcT().a(context, str, bVar.cBX().toString(), uri, 1, vxVar.duration, bri, vxVar.bZN);
                return;
            } else {
                com.tencent.mm.plugin.messenger.a.g.bcT().a(context, str, bVar.cBX().toString(), uri, 1, vxVar.duration, vxVar.bZN);
                return;
            }
        }
        String str2 = vxVar.rzv;
        if (!bi.oW(str2)) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            str2 = bi.aG(vxVar.title, context.getResources().getString(i.favorite_video));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = str2;
            wXMediaMessage.description = vxVar.desc;
            wXMediaMessage.thumbData = bi.readFromFile(com.tencent.mm.plugin.fav.a.b.c(vxVar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = bi.readFromFile(com.tencent.mm.plugin.fav.a.b.aKO() + g.u(bi.aG(vxVar.bJv, "").getBytes()));
            }
            a aVar = new a();
            aVar.dwr = 3;
            waVar = vxVar.rAo;
            if (waVar != null) {
                aVar.dyO = waVar.dyO;
                aVar.dyL = waVar.dyL;
                aVar.dyK = waVar.rBq;
                aVar.dyJ = waVar.dyJ;
                aVar.dyM = waVar.dyM;
                aVar.dyP = waVar.dyP;
                aVar.dyQ = waVar.dyQ;
            }
            ((ab) com.tencent.mm.kernel.g.l(ab.class)).a(aVar, wXMediaMessage, str);
        }
    }

    public static void a(Context context, String str, String str2, com.tencent.mm.plugin.fav.a.g gVar, Runnable runnable) {
        List linkedList = new LinkedList();
        linkedList.add(gVar);
        a(context, str, str2, linkedList, runnable);
    }

    public static void a(Context context, String str, String str2, List<com.tencent.mm.plugin.fav.a.g> list, Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            ah.A(runnable);
        } else if (bi.oW(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            ah.A(runnable);
        } else if (list.isEmpty()) {
            x.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            ah.A(runnable);
        } else {
            com.tencent.mm.kernel.g.Em().H(new 1(str, list, context, str2, runnable));
        }
    }

    public static void a(Context context, String str, com.tencent.mm.plugin.fav.a.g gVar, vx vxVar, Runnable runnable) {
        if (context == null) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
        } else if (bi.oW(str)) {
            x.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
        } else {
            if (gVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (vxVar == null) {
                x.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
            } else {
                com.tencent.mm.kernel.g.Em().H(new 4(str, gVar, vxVar, runnable));
            }
        }
    }

    public static String i(vx vxVar) {
        b bVar = new b(com.tencent.mm.plugin.fav.a.b.c(vxVar));
        if (bVar.exists()) {
            return bVar.cBX().toString();
        }
        return com.tencent.mm.plugin.fav.a.b.aKO() + g.u(bi.aG(vxVar.bJv, "").getBytes());
    }
}
