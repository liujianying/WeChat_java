package com.tencent.mm.plugin.hp.c;

import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    String kmP;
    String kmQ;
    private LinkedList<bsw> kmR;
    private boolean kmS;
    com.tencent.mm.plugin.hp.d.b kmT;

    public a() {
        this("", "", null, false);
    }

    public a(String str, String str2, List<bsw> list) {
        this(str, str2, list, true);
    }

    private a(String str, String str2, List<bsw> list, boolean z) {
        String str3;
        Collection list2;
        this.kmR = new LinkedList();
        this.kmS = true;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new oo();
        aVar.dIH = new op();
        aVar.uri = "/cgi-bin/micromsg-bin/checktinkerupdate";
        aVar.dIF = 922;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        if (z) {
            str3 = str2;
        } else {
            str = "tinker_id_" + com.tencent.mm.loader.stub.a.baseRevision();
            str3 = com.tencent.mm.loader.stub.a.PATCH_REV == null ? "" : "tinker_id_" + com.tencent.mm.loader.stub.a.PATCH_REV;
            list2 = new LinkedList();
            long j = 0;
            try {
                j = ((long) com.tencent.mm.kernel.a.Dz()) & 4294967295L;
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "uin is %s", new Object[]{bi.Xf(String.valueOf(j))});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
            }
            list2.add(do("code-version", d.CLIENT_VERSION));
            list2.add(do("code-reversion", d.REV));
            list2.add(do("sdk", String.valueOf(VERSION.SDK_INT)));
            list2.add(do("os-name", com.tencent.mm.protocal.d.qVK));
            list2.add(do("device-brand", com.tencent.mm.protocal.d.qVH));
            list2.add(do("device-name", com.tencent.mm.protocal.d.DEVICE_NAME));
            list2.add(do("uin", String.valueOf(j)));
            list2.add(do("network", String.valueOf(ao.isWifi(ad.getContext()) ? 3 : 2)));
            List<com.tencent.mm.plugin.boots.a.a> aua = ((c) g.l(c.class)).aua();
            if (aua != null) {
                for (com.tencent.mm.plugin.boots.a.a aVar2 : aua) {
                    list2.add(do(Integer.toHexString(aVar2.field_key), String.valueOf(aVar2.field_dau)));
                }
            }
        }
        this.kmP = str;
        this.kmQ = str3;
        this.kmR.addAll(list2);
        this.kmS = z;
    }

    public final int getType() {
        return 922;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "doScene");
        this.diJ = eVar2;
        oo ooVar = (oo) this.diG.dID.dIL;
        ooVar.rsP = this.kmP;
        ooVar.rsQ = this.kmQ;
        ooVar.rsR = this.kmR;
        if (this.kmS) {
            1 1 = new 1(this, ooVar);
            String string = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
            if (!bi.oW(string)) {
                try {
                    op opVar = new op();
                    opVar.aG(Base64.decode(string.getBytes(), 0));
                    if (opVar.rsS != null) {
                        if (com.tencent.mm.loader.stub.a.PATCH_REV == null) {
                            string = "";
                        } else {
                            string = "tinker_id_" + com.tencent.mm.loader.stub.a.PATCH_REV;
                        }
                        String str = "tinker_id_" + com.tencent.mm.loader.stub.a.baseRevision();
                        String string2 = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                        com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(opVar.rsS);
                        x.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", new Object[]{bVar.knj, string, string2, str});
                        if (!(bi.oW(bVar.knj) || bVar.knj.equalsIgnoreCase(string) || bi.oW(str) || !str.equalsIgnoreCase(string2))) {
                            1.a(true, bVar);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("Tinker.TinkerUtils", e, "parse tinker update Response failed.", new Object[0]);
                    h.mEJ.a(614, 73, 1, false);
                }
            }
            1.a(false, null);
        }
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            op opVar = (op) ((b) qVar).dIE.dIL;
            bta bta = opVar.rsS;
            if (bta == null) {
                if (str.equalsIgnoreCase("no baseid matched")) {
                    com.tencent.mm.plugin.hp.b.a.cJ(1, 0);
                } else if (str.equalsIgnoreCase("no update for this patch")) {
                    com.tencent.mm.plugin.hp.b.a.cJ(2, 0);
                } else if (str.equalsIgnoreCase("no sutable patch available")) {
                    com.tencent.mm.plugin.hp.b.a.cJ(3, 0);
                } else {
                    com.tencent.mm.plugin.hp.b.a.cJ(5, 0);
                }
                if (this.kmT != null) {
                    String str2 = com.tencent.mm.loader.stub.a.PATCH_REV == null ? "" : "tinker_id_" + com.tencent.mm.loader.stub.a.PATCH_REV;
                    if (!(bi.oW(this.kmT.knj) || this.kmT.knj.equalsIgnoreCase(str2))) {
                        int i4 = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i4 >= 4) {
                            com.tencent.mm.plugin.hp.tinker.g.at(ad.getContext(), "");
                            com.tencent.mm.plugin.hp.tinker.g.G(ad.getContext(), 0);
                            x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", new Object[]{Integer.valueOf(i4)});
                            h.mEJ.a(614, 74, 1, false);
                        } else {
                            new com.tencent.mm.plugin.hp.b.e(this.kmT).fL(this.kmS);
                            h.mEJ.a(614, 70, 1, false);
                            com.tencent.mm.plugin.hp.tinker.g.G(ad.getContext(), i4 + 1);
                            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", new Object[]{Integer.valueOf(i4)});
                        }
                    }
                }
            } else if (this.kmS) {
                try {
                    com.tencent.mm.plugin.hp.tinker.g.at(ad.getContext(), new String(Base64.encode(opVar.toByteArray(), 0)));
                    com.tencent.mm.plugin.hp.tinker.g.G(ad.getContext(), 0);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "save node failed.", new Object[0]);
                    h.mEJ.a(614, 72, 1, false);
                }
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(bta);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new com.tencent.mm.plugin.hp.b.e(bVar).fL(this.kmS);
                x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                com.tencent.mm.plugin.hp.b.a.cJ(4, 0);
            } else {
                x.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
            }
        } else {
            x.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.cJ(5, i2);
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static bsw do(String str, String str2) {
        bsw bsw = new bsw();
        bsw.aAL = str;
        bsw.value = str2;
        return bsw;
    }
}
