package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.util.Iterator;

public final class h extends l implements k {
    private final b diG;
    private e diJ;

    public h() {
        a aVar = new a();
        aVar.dIG = new aya();
        aVar.dIH = new ayb();
        aVar.uri = "/cgi-bin/micromsg-bin/openimsync";
        this.diG = aVar.KT();
        ((aya) this.diG.dID.dIL).selector = 2097152;
        x.i("MicroMsg.NetsceneOpenIMSync", "opim sync init:%d", Integer.valueOf(hashCode()));
    }

    protected final int Cc() {
        return 20;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    public final boolean KX() {
        return true;
    }

    public final int getType() {
        return 810;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Ek();
        byte[] WP = bi.WP(bi.oV((String) g.Ei().DT().get(8195, null)));
        bhy bhy = new bhy();
        bhy.bq(WP);
        ((aya) this.diG.dID.dIL).saW = bhy;
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        if (i2 == 0 && i3 == 0) {
            aya aya = (aya) this.diG.dID.dIL;
            ayb ayb = (ayb) this.diG.dIE.dIL;
            if (ayb.saX != null && ayb.saX.hbG.size() > 0) {
                x.i("MicroMsg.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", Integer.valueOf(ayb.saX.hbG.size()));
                Iterator it = ayb.saX.hbG.iterator();
                while (it.hasNext()) {
                    pm pmVar = (pm) it.next();
                    if (pmVar.rtM == 400) {
                        axq axq = new axq();
                        try {
                            axq.aG(pmVar.rtN.siK.lR);
                            x.i("MicroMsg.NetsceneOpenIMSync", "processModContact %s", axq.eup);
                            ai a = i.a(axq);
                            x.i("MicroMsg.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a.field_username, a.field_nickname, a.field_conRemark, Integer.valueOf(a.getSource()), Integer.valueOf(a.sex), a.field_openImAppid, a.cte, Integer.valueOf(a.ctd), Integer.valueOf(a.field_type), a.field_descWordingId);
                            ((i) g.l(i.class)).FR().S(a);
                            if (a.BG()) {
                                ((i) g.l(i.class)).FW().Yv(a.field_username);
                            }
                            ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).aD(axq.hva, axq.saS);
                            i.b(axq);
                            g.Ek();
                            bq Hh = ((i) g.l(i.class)).FS().Hh(a.field_username);
                            if (!(Hh == null || bi.oW(Hh.field_encryptUsername))) {
                                ((com.tencent.mm.openim.a.a) g.l(com.tencent.mm.openim.a.a.class)).Q(a.field_username, Hh.field_conRemark);
                                g.Ek();
                                ((i) g.l(i.class)).FS().Hi(a.field_username);
                                a.dv(Hh.field_conRemark);
                                ((i) g.l(i.class)).FR().S(a);
                            }
                        } catch (IOException e) {
                            x.e("MicroMsg.NetsceneOpenIMSync", "processModContact error:%s", e);
                        }
                    } else if (pmVar.rtM == 402) {
                        rk rkVar = new rk();
                        try {
                            rkVar.aG(pmVar.rtN.siK.lR);
                            x.i("MicroMsg.NetsceneOpenIMSync", "processDelContact user:%s", rkVar.eup);
                            ((i) g.l(i.class)).FW().Yp(rkVar.eup);
                            s.hh(rkVar.eup);
                        } catch (IOException e2) {
                            x.e("MicroMsg.NetsceneOpenIMSync", "processDelContact error:%s", e2);
                        }
                    }
                }
            }
            byte[] toByteArray = ayb.saW.siK.toByteArray();
            g.Ek();
            byte[] g = z.g(bi.WP(bi.oV((String) g.Ei().DT().get(8195, null))), toByteArray);
            if (g != null && g.length > 0) {
                g.Ek();
                g.Ei().DT().set(8195, bi.bE(g));
            }
            if ((aya.selector & ayb.saY) == 0) {
                x.i("MicroMsg.NetsceneOpenIMSync", "onGYNetEnd end");
                this.diJ.a(0, 0, "", this);
                return;
            }
            a(this.dIX, this.diJ);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
