package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.c.gb;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah extends l implements k {
    private static AtomicInteger iWO = new AtomicInteger(0);
    private final b diG;
    private e diJ = null;
    private LinkedList<Integer> iWK;
    private int iWL = 0;
    private boolean iWM = false;
    private boolean iWN = false;

    public ah(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.dIG = new ga();
        aVar.dIH = new gb();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.dIF = 402;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iWK = linkedList;
        iWO.incrementAndGet();
    }

    public static void aLL() {
        iWO.set(0);
    }

    public static void aLM() {
        iWO.decrementAndGet();
    }

    public static int aLN() {
        return iWO.get();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[]{Integer.valueOf(iWO.get())});
        if (this.iWK == null || this.iWK.isEmpty() || this.iWL >= this.iWK.size()) {
            x.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[]{Integer.valueOf(this.iWL)});
            return -1;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.iWK.size()), Integer.valueOf(this.iWL), this.iWK});
        if (bi.f((Integer) g.Ei().DT().get(8217, null)) == 0) {
            x.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            return -1;
        }
        ga gaVar = (ga) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.iWK.subList(this.iWL, Math.min(this.iWL + 15, this.iWK.size())));
        gaVar.rgy = linkedList;
        gaVar.hbF = linkedList.size();
        this.iWL += 15;
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList});
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    private boolean aLK() {
        boolean z;
        boolean z2;
        if (bi.f((Integer) g.Ei().DT().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.iWK == null || this.iWL >= this.iWK.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z || !z2) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.iWL), Integer.valueOf(this.iWK.size()), str});
        if (i2 == 0 && i3 == 0) {
            gb gbVar = (gb) ((b) qVar).dIE.dIL;
            int i4 = gbVar.hbF;
            int size = gbVar.rgH.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.iWL > this.iWK.size() ? this.iWK.size() % 15 : 15);
                x.e(str2, str3, objArr);
                if (aLK()) {
                    a(this.dIX, this.diJ);
                    return;
                }
                iWO.decrementAndGet();
                this.diJ.a(i2, -1, str, this);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                wg wgVar = (wg) gbVar.rgH.get(i5);
                x.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[]{Integer.valueOf(wgVar.rbY), Integer.valueOf(wgVar.hcd)});
                if (wgVar.hcd == 0) {
                    g dz = ((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) wgVar.rbY);
                    if (dz == null) {
                        x.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[]{Integer.valueOf(wgVar.rbY)});
                    } else {
                        dz.field_xml = wgVar.rcf;
                        dz.Bh(wgVar.rcf);
                        dz.field_flag = wgVar.rbZ;
                        dz.field_localSeq = wgVar.rcb;
                        dz.field_updateTime = (((long) wgVar.rca) * 1000) + ((long) i5);
                        x.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[]{dz.field_xml});
                        int size2 = dz.field_favProto.rBI.size();
                        if (size2 == 0) {
                            x.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[]{Integer.valueOf(dz.field_id)});
                        } else {
                            List list = dz.field_favProto.rBI;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                vx vxVar = (vx) list.get(i6);
                                if (!bi.oW(vxVar.rzF)) {
                                    x.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[]{new com.tencent.mm.vfs.b(b.b(vxVar)).getName()});
                                    if (new com.tencent.mm.vfs.b(b.b(vxVar)).exists()) {
                                        if (vxVar.rAe != 0) {
                                            x.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[]{vxVar.rzF});
                                            this.iWN = true;
                                            b.a(vxVar, dz, 0, false);
                                        }
                                        x.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dz.field_id), Integer.valueOf(i6)});
                                    } else if (bi.oW(vxVar.rzq) || bi.oW(vxVar.rzo)) {
                                        x.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[]{Integer.valueOf(dz.field_id)});
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dz.field_id), Integer.valueOf(i6)});
                                        b.a(vxVar, dz, 1, false);
                                        this.iWM = true;
                                    }
                                }
                                if (!bi.oW(vxVar.rzQ)) {
                                    if (new com.tencent.mm.vfs.b(b.c(vxVar)).exists()) {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dz.field_id), Integer.valueOf(i6)});
                                    } else if (bi.oW(vxVar.rzk) || bi.oW(vxVar.dwE)) {
                                        x.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[]{Integer.valueOf(dz.field_id)});
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(dz.field_id), Integer.valueOf(i6)});
                                        b.a(vxVar, dz, 1);
                                        this.iWM = true;
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[]{Boolean.valueOf(this.iWN), Boolean.valueOf(this.iWM)});
                        if (this.iWN) {
                            dz.field_itemStatus = 15;
                            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(dz, "localId");
                            ((ae) g.n(ae.class)).getFavCdnService().run();
                        } else if (this.iWM) {
                            dz.field_itemStatus = 10;
                            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(dz, "localId");
                        } else {
                            dz.field_itemStatus = 10;
                            ((ae) g.n(ae.class)).getFavItemInfoStorage().a(dz, "localId");
                        }
                        b.j(dz);
                        dz.Bi("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((wgVar.rbZ & 1) != 0) {
                    x.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[]{Integer.valueOf(wgVar.rbY)});
                    b.i(((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) wgVar.rbY));
                }
            }
            ((ae) g.n(ae.class)).getFavCdnService().run();
            if (aLK()) {
                a(this.dIX, this.diJ);
                return;
            }
            iWO.decrementAndGet();
            this.diJ.a(i2, i3, str, this);
        } else if (aLK()) {
            a(this.dIX, this.diJ);
        } else {
            iWO.decrementAndGet();
            this.diJ.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }

    public final int getType() {
        return 402;
    }
}
