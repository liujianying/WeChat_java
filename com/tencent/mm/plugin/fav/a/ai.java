package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ai extends l implements k {
    private final b diG;
    private e diJ = null;
    private int iWP = 0;
    public g iWQ;
    private boolean iWR = true;
    private boolean iWS = false;
    HashMap<vx, Boolean> iWT = new HashMap();

    public ai(g gVar) {
        a aVar = new a();
        aVar.dIG = new ni();
        aVar.dIH = new nj();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.dIF = 404;
        aVar.dII = 197;
        aVar.dIJ = 1000000197;
        this.diG = aVar.KT();
        this.iWQ = gVar;
        Iterator it = gVar.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            this.iWT.put((vx) it.next(), Boolean.valueOf(false));
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i;
        this.diJ = eVar2;
        int i2 = 0;
        Iterator it = this.iWT.keySet().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            if (((Boolean) this.iWT.get((vx) it.next())).booleanValue()) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
        }
        if (i == 0) {
            x.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.iWP = -100;
            return -100;
        }
        int i3;
        int i4 = 0;
        ni niVar = (ni) this.diG.dID.dIL;
        niVar.hbG.clear();
        List list = this.iWQ.field_favProto.rBI;
        int i5 = 0;
        while (true) {
            i3 = i5;
            int i6 = i4;
            if (i3 >= list.size()) {
                i4 = i6;
                break;
            }
            vx vxVar = (vx) list.get(i3);
            if (!((Boolean) this.iWT.get(vxVar)).booleanValue()) {
                if (!vxVar.rAa) {
                    nh nhVar = new nh();
                    nhVar.rrr = (int) vxVar.rzJ;
                    nhVar.rrp = vxVar.rzF;
                    nhVar.rrq = vxVar.rzH;
                    nhVar.rro = String.valueOf(i3);
                    nhVar.rrt = vxVar.rzW;
                    nhVar.rrs = this.iWQ.field_sourceType;
                    nhVar.rru = 0;
                    niVar.hbG.add(nhVar);
                    i6++;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{nhVar.rro, nhVar.rrt, Integer.valueOf(nhVar.rrs), Integer.valueOf(nhVar.rrr), nhVar.rrp, nhVar.rrq});
                }
                if (vxVar.rAc) {
                    i4 = i6;
                } else {
                    nh nhVar2 = new nh();
                    nhVar2.rrr = (int) vxVar.rzU;
                    nhVar2.rrp = vxVar.rzQ;
                    nhVar2.rrq = vxVar.rzS;
                    nhVar2.rrt = vxVar.rzW;
                    nhVar2.rrs = this.iWQ.field_sourceType;
                    nhVar2.rro = i3 + "t";
                    nhVar2.rru = 1;
                    niVar.hbG.add(nhVar2);
                    i4 = i6 + 1;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", new Object[]{nhVar2.rro, nhVar2.rrt, Integer.valueOf(nhVar2.rrs), Integer.valueOf(nhVar2.rrr), nhVar2.rrp, nhVar2.rrq});
                }
                if (i4 >= 19) {
                    break;
                }
            } else {
                i4 = i6;
            }
            i5 = i3 + 1;
        }
        x.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3 + 1)});
        niVar.hbF = i4;
        if (i4 != 0) {
            return a(eVar, this.diG, this);
        }
        x.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
        this.iWP = -101;
        return -101;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.iWP), str});
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.iWP == -100) {
                x.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                ((ae) g.n(ae.class)).getFavItemInfoStorage().t(9, this.iWQ.field_localId);
                ((ae) g.n(ae.class)).getSendService().run();
                this.diJ.a(i2, i3, str, this);
                return;
            } else if (i2 == 3 && this.iWP == -101) {
                i3 = 0;
            } else {
                this.diJ.a(i2, i3, str, this);
                return;
            }
        }
        if (this.iWP != -101 && i2 == 0 && i3 == 0) {
            int i4;
            List list = ((nj) ((b) qVar).dIE.dIL).hbG;
            List list2 = this.iWQ.field_favProto.rBI;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= list.size()) {
                    break;
                }
                vw vwVar = (vw) list.get(i6);
                String str2 = vwVar.rro;
                if (!bi.oW(str2)) {
                    vx vxVar;
                    x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", new Object[]{Integer.valueOf(vwVar.hcd), str2});
                    if (vwVar.hcd == 1) {
                        if (str2.endsWith("t")) {
                            vxVar = (vx) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{vwVar.rze, vwVar.rmy, vwVar.rro, vwVar.rrp, Integer.valueOf(vwVar.rrr), vwVar.rrq});
                            vxVar.UE(vwVar.rmy);
                            vxVar.UD(vwVar.rze);
                            if (vwVar.rrr > 0) {
                                vxVar.fP((long) vwVar.rrr);
                                if (!(bi.oW(vwVar.rrp) || vwVar.rrp.equals(vxVar.rzQ))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", new Object[]{vwVar.rrp, vxVar.rzQ});
                                    vxVar.UR(vwVar.rrp);
                                }
                                if (!(bi.oW(vwVar.rrq) || vwVar.rrq.equals(vxVar.rzS))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", new Object[]{vwVar.rrq, vxVar.rzS});
                                    vxVar.US(vwVar.rrq);
                                }
                            }
                        } else {
                            vxVar = (vx) list2.get(bi.getInt(str2, 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", new Object[]{vwVar.rze, vwVar.rmy, vwVar.rro, vwVar.rrp, Integer.valueOf(vwVar.rrr), vwVar.rrq});
                            vxVar.UG(vwVar.rmy);
                            vxVar.UF(vwVar.rze);
                            if (!bi.oW(vwVar.rzf)) {
                                vxVar.UU(vwVar.rzf);
                            }
                            if (bi.oW(vxVar.rzF)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                vxVar.UM(vwVar.rrp);
                                vxVar.fO((long) vwVar.rrr);
                                vxVar.UN(vwVar.rrq);
                                b.a(vxVar, this.iWQ, 1, false);
                            }
                            if (!(bi.oW(vwVar.rrp) || vwVar.rrp.equals(vxVar.rzF))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", new Object[]{vwVar.rrp, vxVar.rzF});
                                vxVar.UM(vwVar.rrp);
                            }
                            if (!(bi.oW(vwVar.rrq) || vwVar.rrq.equals(vxVar.rzH))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", new Object[]{vwVar.rrq, vxVar.rzH});
                                vxVar.UN(vwVar.rrq);
                            }
                            if (vwVar.rrr > 0 && ((long) vwVar.rrr) != vxVar.rzJ) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(vwVar.rrr), Long.valueOf(vxVar.rzJ)});
                                vxVar.fO((long) vwVar.rrr);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.iWT.put((vx) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.valueOf(true));
                    } else {
                        this.iWT.put((vx) list2.get(bi.getInt(str2, 0)), Boolean.valueOf(true));
                    }
                    if (vwVar.hcd == 3 || vwVar.hcd == -2 || vwVar.hcd == -1) {
                        if (str2.endsWith("t")) {
                            vxVar = (vx) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (bi.oW(vxVar.rzQ)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", new Object[]{vxVar.rzQ});
                            } else {
                                this.iWR = false;
                                if (bi.oW(vxVar.rzq)) {
                                    com.tencent.mm.modelcdntran.g.NE();
                                    vxVar.UG(com.tencent.mm.modelcdntran.b.Nw());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[]{r10});
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", new Object[]{vxVar.rzF, vxVar.rzq});
                                b.a(vxVar, this.iWQ, 0);
                            }
                        } else {
                            vxVar = (vx) list2.get(bi.getInt(str2, 0));
                            if (bi.oW(vxVar.rzF)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", new Object[]{vxVar.rzF});
                            } else {
                                this.iWR = false;
                                if (bi.oW(vxVar.rzq)) {
                                    com.tencent.mm.modelcdntran.g.NE();
                                    vxVar.UG(com.tencent.mm.modelcdntran.b.Nw());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", new Object[]{r10});
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", new Object[]{vxVar.rzF, vxVar.rzq});
                                b.a(vxVar, this.iWQ, 0, false);
                            }
                        }
                    }
                    if (vwVar.hcd == 2) {
                        this.iWS = true;
                        if (str2.endsWith("t")) {
                            x.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", new Object[]{Integer.valueOf(vwVar.rzg), vwVar.rze, vwVar.rmy});
                            vxVar = (vx) list2.get(bi.getInt(str2, 0));
                            vxVar.CG(vwVar.rzg);
                            vxVar.UG(vwVar.rmy);
                            vxVar.UF(vwVar.rze);
                            if (!bi.oW(vwVar.rzf)) {
                                vxVar.UU(vwVar.rzf);
                            }
                            if (!(bi.oW(vwVar.rrp) || vwVar.rrp.equals(vxVar.rzF))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", new Object[]{vwVar.rrp, vxVar.rzF});
                                vxVar.UM(vwVar.rrp);
                            }
                            if (!(bi.oW(vwVar.rrq) || vwVar.rrq.equals(vxVar.rzH))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", new Object[]{vwVar.rrq, vxVar.rzH});
                                vxVar.UN(vwVar.rrq);
                            }
                            if (vwVar.rrr > 0 && ((long) vwVar.rrr) != vxVar.rzJ) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", new Object[]{Integer.valueOf(vwVar.rrr), Long.valueOf(vxVar.rzJ)});
                                vxVar.fO((long) vwVar.rrr);
                            }
                        }
                    }
                }
                i5 = i6 + 1;
            }
            i5 = 0;
            Iterator it = this.iWT.keySet().iterator();
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                if (((Boolean) this.iWT.get((vx) it.next())).booleanValue()) {
                    i5 = i4;
                } else {
                    i5 = i4 + 1;
                }
            }
            x.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(list2.size())});
            if (i4 > 0) {
                x.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i5 = a(this.dIX, this.diJ);
                if (!(i5 == -100 || i5 == -101)) {
                    return;
                }
            }
        }
        if (this.iWS) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.iWQ.field_itemStatus = 12;
            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWQ, new String[]{"localId"});
            ((ae) g.n(ae.class)).getSendService().run();
            this.diJ.a(i2, i3, str, this);
            return;
        }
        if (this.iWR) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.iWQ.field_id > 0) {
                this.iWQ.field_itemStatus = 17;
                ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWQ, new String[]{"localId"});
                ((ae) g.n(ae.class)).getModService().run();
            } else {
                if (this.iWQ.field_type == 18) {
                    this.iWQ.field_favProto.CN(1);
                }
                this.iWQ.field_itemStatus = 9;
                ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWQ, new String[]{"localId"});
                ((ae) g.n(ae.class)).getSendService().run();
            }
        } else {
            if (this.iWQ.field_id > 0) {
                this.iWQ.field_itemStatus = 15;
            } else {
                if (this.iWQ.field_type == 18) {
                    this.iWQ.field_favProto.CN(1);
                }
                this.iWQ.field_itemStatus = 4;
            }
            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(this.iWQ, new String[]{"localId"});
            ((ae) g.n(ae.class)).getFavCdnService().run();
        }
        this.diJ.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    public final int getType() {
        return 404;
    }
}
