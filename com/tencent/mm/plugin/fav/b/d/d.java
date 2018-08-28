package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d implements e, z {
    private static Map<Integer, a> bFf = new HashMap();
    private static Map<Integer, Integer> iXO = new HashMap();
    private Queue<g> bFd = new LinkedList();
    private boolean bFh = false;
    private boolean bFi = false;
    public int bFj = 0;
    private long bFk = 0;
    public al bFo = new al(com.tencent.mm.kernel.g.Em().lnJ.getLooper(), new 3(this), false);

    static /* synthetic */ void A(g gVar) {
        wo woVar = new wo();
        StringBuffer stringBuffer = new StringBuffer();
        woVar.rbY = gVar.field_id;
        stringBuffer.append("favid:" + gVar.field_id);
        woVar.rBL = new LinkedList();
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.rAA != 0) {
                xf xfVar = new xf();
                if (vxVar.rAA > 0) {
                    xfVar.rro = vxVar.jdM;
                    xfVar.rru = 0;
                    xfVar.hcd = vxVar.rAA;
                } else {
                    xfVar.rro = vxVar.jdM;
                    xfVar.rru = 1;
                    xfVar.hcd = -vxVar.rAA;
                }
                stringBuffer.append(" fileId:" + xfVar.rro + " IsThumb:" + xfVar.rru + " status:" + xfVar.hcd);
                woVar.rBL.add(xfVar);
                vxVar.CI(0);
            }
        }
        x.i("MicroMsg.Fav.FavModService", "checkFavItem %s", new Object[]{stringBuffer.toString()});
        if (woVar.rBL.size() > 0) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).checkFavItem(woVar);
        }
    }

    static /* synthetic */ boolean d(d dVar) {
        dVar.bFk = System.currentTimeMillis();
        if (!dVar.bFh && dVar.bFd.size() == 0) {
            List<g> aLE = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLE();
            if (!(aLE == null || aLE.size() == 0)) {
                for (g gVar : aLE) {
                    if (bFf.containsKey(Integer.valueOf(gVar.field_id))) {
                        x.i("MicroMsg.Fav.FavModService", "File is Already running:" + gVar.field_id);
                    } else {
                        if (!iXO.containsKey(Integer.valueOf(gVar.field_id))) {
                            iXO.put(Integer.valueOf(gVar.field_id), Integer.valueOf(3));
                        }
                        dVar.bFd.add(gVar);
                        bFf.put(Integer.valueOf(gVar.field_id), null);
                    }
                }
                x.i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + bFf.size() + ",send:" + dVar.bFd.size() + "]");
                dVar.bFd.size();
            }
        }
        if (!dVar.bFh && dVar.bFd.size() <= 0) {
            dVar.e();
            x.i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
            return false;
        } else if (dVar.bFh || dVar.bFd.size() <= 0) {
            return false;
        } else {
            g gVar2 = (g) dVar.bFd.poll();
            if (gVar2 == null || gVar2.field_id <= 0) {
                return false;
            }
            dVar.bFh = true;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (gVar2.aLl()) {
                x.i("MicroMsg.Fav.FavModService", "Resend Item %d", new Object[]{Long.valueOf(gVar2.field_localId)});
                com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.fav.a.al(gVar2.field_id, linkedList, linkedList2, g.s(gVar2), (byte) 0), 0);
            } else if (gVar2.field_type != 18) {
                a(gVar2.field_localId, linkedList, linkedList2);
                com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.fav.a.al(gVar2.field_id, linkedList, linkedList2), 0);
            } else {
                auj auj = new auj();
                auj.rXA = 1;
                auj.rXB = (int) bi.VE();
                linkedList.add(auj);
                com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.fav.a.al(gVar2.field_id, linkedList, linkedList2, g.s(gVar2)), 0);
            }
            return true;
        }
    }

    public d() {
        com.tencent.mm.kernel.g.DF().a(426, this);
    }

    public final void a(final int i, final int i2, String str, final l lVar) {
        if (lVar.getType() == 426 && (lVar instanceof com.tencent.mm.plugin.fav.a.al)) {
            com.tencent.mm.kernel.g.Em().H(new Runnable() {
                public final void run() {
                    d.this.bFh = false;
                    int i = ((com.tencent.mm.plugin.fav.a.al) lVar).iXb;
                    d.bFf.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        d.this.bFj = d.this.bFj - 1;
                    }
                    g dz = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) i);
                    if (dz != null && dz.field_itemStatus != 10) {
                        if (i != 0 || i2 != 0) {
                            Integer valueOf = Integer.valueOf(bi.a((Integer) d.iXO.get(Integer.valueOf(i)), 0));
                            if (!(i == 1 || i == 0)) {
                                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                            }
                            if (valueOf.intValue() <= 0) {
                                int cA = h.cA(i, i2);
                                com.tencent.mm.plugin.report.service.h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(dz.field_type), Integer.valueOf(cA), Long.valueOf(b.b(dz)), Long.valueOf(h.dr(dz.field_localId))});
                                d.iXO.remove(Integer.valueOf(i));
                                x.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", new Object[]{Integer.valueOf(i)});
                                dz.field_itemStatus = 18;
                                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dz, new String[]{"localId"});
                            }
                        } else if (dz.field_itemStatus == 17) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(dz.field_type), Integer.valueOf(0), Long.valueOf(b.b(dz)), Long.valueOf(h.dr(dz.field_localId))});
                            x.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", new Object[]{Integer.valueOf(dz.field_id)});
                            dz.field_itemStatus = 10;
                            d.A(dz);
                            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dz, new String[]{"localId"});
                            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().dv(dz.field_localId);
                        }
                        if (d.this.bFj <= 0) {
                            x.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                            d.this.e();
                        } else if (!d.d(d.this)) {
                            d.startSync();
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }
    }

    public final void run() {
        com.tencent.mm.kernel.g.Em().H(new 2(this));
    }

    /* renamed from: wx */
    public final void e() {
        this.bFd.clear();
        bFf.clear();
        this.bFi = false;
        this.bFh = false;
        iXO.clear();
    }

    public static void startSync() {
        com.tencent.mm.kernel.g.DF().a(new aj(), 0);
    }

    private static void a(long j, LinkedList<auj> linkedList, LinkedList<aum> linkedList2) {
        auj auj = new auj();
        auj.rXA = 4;
        auj.rXB = 0;
        linkedList.add(auj);
        x.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", new Object[]{Long.valueOf(j), Integer.valueOf(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().du(j).size())});
        for (c cVar : r0) {
            boolean Bb = b.Bb(cVar.field_dataId);
            if (bi.oW(cVar.field_cdnUrl) || Bb) {
                x.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{cVar.field_cdnUrl, Boolean.valueOf(Bb), Long.valueOf(j)});
            } else {
                aum aum = new aum();
                aum.jSt = "dataitem." + cVar.field_dataId + ".cdn_dataurl";
                aum.mEl = cVar.field_cdnUrl;
                linkedList2.add(aum);
                aum = new aum();
                aum.jSt = "dataitem." + cVar.field_dataId + ".cdn_datakey";
                aum.mEl = cVar.field_cdnKey;
                linkedList2.add(aum);
                aum = new aum();
                aum.jSt = "dataitem." + cVar.field_dataId;
                aum.rXG = "datastatus";
                aum.mEl = "0";
                linkedList2.add(aum);
                g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(cVar.field_favLocalId);
                if (dy != null) {
                    if ((dy.field_type == 4 ? 1 : 0) != 0) {
                        vx a = b.a(dy, cVar.field_dataId);
                        if (a != null) {
                            aum aum2 = new aum();
                            aum2.jSt = "dataitem." + cVar.field_dataId + ".stream_videoid";
                            aum2.mEl = a.rzY;
                            linkedList2.add(aum2);
                        }
                    }
                }
            }
        }
    }
}
