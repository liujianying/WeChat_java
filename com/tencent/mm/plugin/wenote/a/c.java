package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements p, com.tencent.mm.plugin.record.a.c {
    public final void d(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar.field_type != 18) {
            x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[]{Long.valueOf(cVar.field_favLocalId)});
            return;
        }
        if (cVar.field_status == 3 && e.cn(cVar.field_path) && cVar.field_path.endsWith("..htm")) {
            f.t(cVar.field_favLocalId, cVar.field_path);
        }
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_favLocalId = cVar.field_favLocalId;
        eVar.field_dataId = cVar.field_dataId;
        eVar.field_status = cVar.field_status;
        eVar.field_offset = cVar.field_offset;
        eVar.field_totalLen = cVar.field_totalLen;
        eVar.field_path = cVar.field_path;
        a(eVar);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_localId = fVar.field_localId;
        eVar.field_dataId = fVar.field_dataId;
        eVar.field_status = fVar.field_status;
        eVar.field_offset = fVar.field_offset;
        eVar.field_totalLen = fVar.field_totalLen;
        eVar.field_path = fVar.field_path;
        a(eVar);
    }

    private static void a(com.tencent.mm.plugin.wenote.model.e eVar) {
        int i = 0;
        d dVar = com.tencent.mm.plugin.wenote.model.c.bZb().qnC;
        if (dVar != null) {
            int i2 = (eVar.field_status == 3 || eVar.field_status == 2) ? true : 0;
            if (i2 != 0 && e.cn(eVar.field_path)) {
                String str = (String) dVar.qnH.get(eVar.field_dataId);
                if (!bi.oW(str)) {
                    x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[]{str});
                    if (!eVar.field_dataId.endsWith("_t") || dVar.qnI.get(str) == null) {
                        n nVar;
                        if (str.equals("WeNoteHtmlFile")) {
                            v vVar;
                            x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                            if (dVar.qnE.bVe == -1) {
                                vVar = (v) dVar.qnG.get(Long.toString(dVar.qnE.bJC));
                            } else {
                                vVar = (v) dVar.qnG.get(Long.toString(dVar.qnE.bVe));
                            }
                            if (vVar != null) {
                                try {
                                    vVar.qpu = com.tencent.mm.plugin.wenote.b.c.Sv(eVar.field_path);
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bZD = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();
                                    str = vVar.qpu;
                                    if (!(bi.oW(str) || bZD.gBc == null)) {
                                        ArrayList So = b.So(str);
                                        if (So != null && So.size() > 0) {
                                            synchronized (bZD) {
                                                try {
                                                    x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[]{Boolean.valueOf(bZD.qpW)});
                                                    au.Em().h(new c$2(bZD, So), bZD.qpW ? 500 : 1000);
                                                } catch (Exception e) {
                                                    x.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[]{e.toString()});
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e2, "", new Object[0]);
                                }
                            } else {
                                return;
                            }
                        } else if (dVar.qnH.containsValue("WeNoteHtmlFile")) {
                            v vVar2;
                            if (dVar.qnE.bVe == -1) {
                                vVar2 = (v) dVar.qnG.get(Long.toString(dVar.qnE.bJC));
                            } else {
                                vVar2 = (v) dVar.qnG.get(Long.toString(dVar.qnE.bVe));
                            }
                            if (vVar2 != null && vVar2.qpv != null) {
                                Iterator it = vVar2.qpv.iterator();
                                while (it.hasNext()) {
                                    nVar = (n) it.next();
                                    if (nVar.qpc.equals(str)) {
                                        nVar.qpd = true;
                                        if (nVar.type == 4) {
                                            u uVar = (u) nVar;
                                            uVar.fTs = d.qnQ;
                                            vx Se = dVar.Se(eVar.field_dataId);
                                            if (Se == null) {
                                                x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                            } else {
                                                i = Se.duration;
                                            }
                                            uVar.length = (int) f.bD((long) i);
                                            uVar.qps = f.C(ad.getContext(), uVar.length);
                                        } else if (nVar.getType() == 2) {
                                            com.tencent.mm.plugin.wenote.b.c.fx(eVar.field_path, ((n) dVar.qnI.get(str)).bVd);
                                        } else {
                                            nVar.bVd = eVar.field_path;
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(str, nVar);
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            kq kqVar = new kq();
                            kqVar.bVa.bUR = str;
                            kqVar.bVa.bVd = eVar.field_path;
                            kqVar.bVa.type = 1;
                            kqVar.bVa.bUV = ((n) dVar.qnI.get(str)).type;
                            if (kqVar.bVa.bUV != 4) {
                                nVar = (n) dVar.qnI.get(str);
                                if (kqVar.bVa.bUV != 2) {
                                    nVar.bVd = eVar.field_path;
                                } else {
                                    com.tencent.mm.plugin.wenote.b.c.fx(eVar.field_path, nVar.bVd);
                                }
                                nVar.qpd = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(str, nVar);
                            }
                            if (5 != kqVar.bVa.bUV) {
                                if (kqVar.bVa.bUV == 4) {
                                    int i3;
                                    vx Se2 = dVar.Se(eVar.field_dataId);
                                    if (Se2 == null) {
                                        x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                        i3 = 0;
                                    } else {
                                        i3 = Se2.duration;
                                    }
                                    kqVar.bVa.bOT = i3;
                                    ((n) dVar.qnI.get(str)).bVd = eVar.field_path;
                                    ((n) dVar.qnI.get(str)).qpd = true;
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.qnI.get(str));
                                }
                                x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[]{kqVar.bVa.bUR, kqVar.bVa.bVd});
                            } else {
                                return;
                            }
                        }
                        dVar.qnH.remove(eVar.field_dataId);
                        return;
                    }
                    if (((n) dVar.qnI.get(str)).getType() == 2) {
                        ((n) dVar.qnI.get(str)).bVd = eVar.field_path;
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.qnI.get(str));
                    dVar.qnH.remove(eVar.field_dataId);
                    return;
                }
                return;
            }
            return;
        }
        return;
    }
}
