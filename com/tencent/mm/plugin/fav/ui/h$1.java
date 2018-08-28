package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class h$1 implements Runnable {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ String jaj;
    final /* synthetic */ List jak;
    final /* synthetic */ String jal;
    final /* synthetic */ Context val$context;

    h$1(String str, List list, Context context, String str2, Runnable runnable) {
        this.jaj = str;
        this.jak = list;
        this.val$context = context;
        this.jal = str2;
        this.bzs = runnable;
    }

    public final void run() {
        for (String str : bi.F(this.jaj.split(","))) {
            for (g gVar : this.jak) {
                if (gVar != null) {
                    h.mEJ.h(10925, new Object[]{Integer.valueOf(gVar.field_type), Integer.valueOf(gVar.field_id)});
                    Iterator it;
                    String str2;
                    byte[] readFromFile;
                    Context context;
                    wk wkVar;
                    lz lzVar;
                    byte[] readFromFile2;
                    switch (gVar.field_type) {
                        case 1:
                            com.tencent.mm.plugin.messenger.a.g.bcT().D(str, gVar.field_favProto.desc, s.hQ(str));
                            break;
                        case 2:
                            it = gVar.field_favProto.rBI.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.messenger.a.g.bcT().a(this.val$context, str, b.b((vx) it.next()), 0, "", "");
                            }
                            break;
                        case 4:
                            h.b(this.val$context, str, b.c(gVar));
                            break;
                        case 5:
                            if (gVar != null) {
                                vx c = b.c(gVar);
                                xa xaVar = gVar.field_favProto.rAN;
                                wr wrVar = gVar.field_favProto.rBG;
                                a aVar = new a();
                                if (xaVar != null) {
                                    aVar.title = xaVar.title;
                                    str2 = xaVar.thumbUrl;
                                    if (bi.oW(str2)) {
                                        str2 = bi.aG(c.bJv, "");
                                    }
                                    aVar.thumburl = str2;
                                }
                                if (bi.oW(aVar.title)) {
                                    aVar.title = c.title;
                                }
                                if (xaVar != null) {
                                    aVar.description = xaVar.desc;
                                }
                                if (bi.oW(aVar.description)) {
                                    aVar.description = c.desc;
                                }
                                if (gVar.field_favProto.rAN != null) {
                                    aVar.url = gVar.field_favProto.rAN.rCn;
                                }
                                if (wrVar != null && bi.oW(aVar.url)) {
                                    aVar.url = wrVar.egr;
                                }
                                if (!bi.oW(c.canvasPageXml)) {
                                    aVar.canvasPageXml = c.canvasPageXml;
                                }
                                aVar.action = "view";
                                aVar.type = 5;
                                aVar.bZN = c.bZN;
                                readFromFile = bi.readFromFile(b.c(c));
                                if (readFromFile == null) {
                                    str2 = xaVar == null ? null : xaVar.thumbUrl;
                                    if (bi.oW(str2)) {
                                        str2 = bi.aG(c.bJv, "");
                                    }
                                    readFromFile = bi.readFromFile(b.aKO() + com.tencent.mm.a.g.u(str2.getBytes()));
                                }
                                String str3 = "fav_" + q.GF() + "_" + gVar.field_id;
                                String ic = u.ic(str3);
                                u.b v = u.Hx().v(ic, true);
                                v.p("prePublishId", str3);
                                v.p("preUsername", gVar.field_fromUser);
                                v.p("sendAppMsgScene", Integer.valueOf(1));
                                v.p("adExtStr", c.bZN);
                                com.tencent.mm.plugin.messenger.a.g.bcT().a(str, readFromFile, a.a(aVar, null, null), ic);
                                break;
                            }
                            x.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                            break;
                        case 6:
                            we weVar = gVar.field_favProto.rAL;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("<msg>");
                            stringBuilder.append("<location ");
                            stringBuilder.append("x=\"").append(weVar.lat).append("\" ");
                            stringBuilder.append("y=\"").append(weVar.lng).append("\" ");
                            stringBuilder.append("scale=\"").append(weVar.bSz).append("\" ");
                            stringBuilder.append("label=\"").append(bi.aG(weVar.label, "")).append("\" ");
                            stringBuilder.append("maptype=\"0\" ");
                            stringBuilder.append("poiname=\"").append(bi.aG(weVar.bWB, "")).append("\" ");
                            stringBuilder.append("/>");
                            stringBuilder.append("</msg>");
                            com.tencent.mm.plugin.messenger.a.g.bcT().D(str, stringBuilder.toString(), 48);
                            break;
                        case 7:
                            Context context2 = this.val$context;
                            vx c2 = b.c(gVar);
                            WXMusicObject wXMusicObject = new WXMusicObject();
                            wXMusicObject.musicUrl = c2.rzv;
                            wXMusicObject.musicDataUrl = c2.rzx;
                            wXMusicObject.musicLowBandUrl = c2.rzz;
                            wXMusicObject.musicLowBandDataUrl = c2.rzz;
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXMusicObject;
                            wXMediaMessage.title = c2.title;
                            wXMediaMessage.description = c2.desc;
                            readFromFile = bi.readFromFile(b.c(c2));
                            if (readFromFile == null) {
                                readFromFile = bi.readFromFile(b.aKO() + com.tencent.mm.a.g.u(bi.aG(c2.bJv, "").getBytes()));
                            }
                            wXMediaMessage.thumbData = readFromFile;
                            str2 = gVar.field_favProto.rBG.appId;
                            ((ab) com.tencent.mm.kernel.g.l(ab.class)).a(wXMediaMessage, str2, ac.a.dBp.q(context2, str2), str);
                            break;
                        case 8:
                            h.a(str, gVar, b.c(gVar));
                            break;
                        case 10:
                            context = this.val$context;
                            wkVar = gVar.field_favProto.rAP;
                            lzVar = new lz();
                            lzVar.bWu.opType = 0;
                            lzVar.bWu.bWw = wkVar.info;
                            lzVar.bWu.context = context;
                            com.tencent.mm.sdk.b.a.sFg.m(lzVar);
                            if (!lzVar.bWv.bJm) {
                                break;
                            }
                            readFromFile2 = bi.readFromFile(b.aKO() + com.tencent.mm.a.g.u(bi.aG(wkVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bi.readFromFile(lzVar.bWv.bOX);
                            }
                            com.tencent.mm.plugin.messenger.a.g.bcT().a(str, readFromFile2, lzVar.bWv.bWx, null);
                            break;
                        case 11:
                            context = this.val$context;
                            wkVar = gVar.field_favProto.rAP;
                            lzVar = new lz();
                            lzVar.bWu.opType = 1;
                            lzVar.bWu.bWw = wkVar.info;
                            lzVar.bWu.context = context;
                            com.tencent.mm.sdk.b.a.sFg.m(lzVar);
                            if (!lzVar.bWv.bJm) {
                                break;
                            }
                            readFromFile2 = bi.readFromFile(b.aKO() + com.tencent.mm.a.g.u(bi.aG(wkVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bi.readFromFile(lzVar.bWv.bOX);
                            }
                            com.tencent.mm.plugin.messenger.a.g.bcT().a(str, readFromFile2, lzVar.bWv.bWx, null);
                            break;
                        case 14:
                        case 18:
                            x.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[]{Integer.valueOf(gVar.field_id)});
                            h$a a = h$a.a(this.val$context, gVar);
                            wl wlVar = new wl();
                            try {
                                x.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                wlVar.aG(gVar.field_favProto.toByteArray());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                x.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[]{e.getMessage()});
                            }
                            LinkedList linkedList = wlVar.rBI;
                            it = linkedList.iterator();
                            int i = 0;
                            while (it.hasNext()) {
                                vx vxVar = (vx) it.next();
                                if (!(vxVar.rAi == null || vxVar.rAi.rBa == null || vxVar.rAi.rBa.type != 3)) {
                                    vxVar.CF(1);
                                    vxVar.UC(this.val$context.getString(i.app_not_show));
                                    linkedList.set(i, vxVar);
                                    wlVar.ar(linkedList);
                                }
                                i++;
                            }
                            mw mwVar = new mw();
                            mwVar.bXL.type = 2;
                            mwVar.bXL.toUser = str;
                            mwVar.bXL.bXO = wlVar;
                            mwVar.bXL.title = a.title;
                            mwVar.bXL.desc = a.desc;
                            mwVar.bXL.bOX = a.bOX;
                            mwVar.bXL.bXT = a.jap;
                            com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                            break;
                        case 15:
                            context = this.val$context;
                            wu wuVar = gVar.field_favProto.rAR;
                            rl rlVar = new rl();
                            rlVar.cci.opType = 0;
                            rlVar.cci.cck = wuVar.info;
                            rlVar.cci.context = context;
                            com.tencent.mm.sdk.b.a.sFg.m(rlVar);
                            x.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[]{Boolean.valueOf(rlVar.ccj.bJm), wuVar.thumbUrl});
                            if (!rlVar.ccj.bJm) {
                                break;
                            }
                            readFromFile2 = bi.readFromFile(b.aKO() + com.tencent.mm.a.g.u(bi.aG(wuVar.thumbUrl, "").getBytes()));
                            if (readFromFile2 == null) {
                                readFromFile2 = bi.readFromFile(rlVar.ccj.bOX);
                            }
                            com.tencent.mm.plugin.messenger.a.g.bcT().a(str, readFromFile2, rlVar.ccj.bWx, null);
                            break;
                        case 16:
                            h.a(this.val$context, str, b.c(gVar));
                            break;
                        case 17:
                            str2 = b.c(gVar).desc;
                            com.tencent.mm.plugin.messenger.a.g.bcT().D(str, str2, com.tencent.mm.storage.ab.XR(bd.a.YV(str2).otZ) ? 66 : 42);
                            break;
                        default:
                            break;
                    }
                }
                x.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[]{Integer.valueOf(this.jak.size())});
            }
            if (!bi.oW(this.jal)) {
                com.tencent.mm.plugin.messenger.a.g.bcT().D(str, this.jal, s.hQ(str));
            }
        }
        ah.A(this.bzs);
    }

    public final String toString() {
        return super.toString() + "|sendFavMsg";
    }
}
