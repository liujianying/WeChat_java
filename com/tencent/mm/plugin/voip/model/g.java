package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class g extends l implements k {
    private static final List<Object> dZx = new ArrayList();
    private static final Set<Long> oJf = new HashSet();
    private long bJC;
    private final List<bd> dZy = new LinkedList();
    private b diG;
    private e diJ;

    public g(String str, String str2, int i) {
        boolean z = true;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bi.cjd());
        if (!bi.oW(str)) {
            bd bdVar = new bd();
            bdVar.setStatus(1);
            bdVar.ep(str);
            bdVar.ay(com.tencent.mm.model.bd.iD(str));
            bdVar.eX(1);
            bdVar.setContent(str2);
            bdVar.setType(i);
            au.HU();
            this.bJC = c.FT().T(bdVar);
            if (this.bJC == -1) {
                z = false;
            }
            Assert.assertTrue(z);
            x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bJC);
        }
    }

    public g() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bi.cjd());
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    protected final int Cc() {
        return 10;
    }

    protected final int a(q qVar) {
        return this.dZy.size() > 0 ? l.b.dJm : l.b.dJn;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new bko();
        aVar.dIH = new bkp();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.dIF = 522;
        aVar.dII = 237;
        aVar.dIJ = 1000000237;
        this.diG = aVar.KT();
        bko bko = (bko) this.diG.dID.dIL;
        au.HU();
        List bdh = c.FT().bdh();
        if (bdh.size() == 0) {
            x.i("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.dZy.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bdh.size()) {
                break;
            }
            bd bdVar = (bd) bdh.get(i2);
            if (bdVar.field_isSend == 1) {
                ato ato = new ato();
                ato.rck = new bhz().VO(bdVar.field_talker);
                ato.lOH = (int) (bdVar.field_createTime / 1000);
                ato.hcE = bdVar.getType();
                ato.jSA = bdVar.field_content;
                ato.rWU = o.l(com.tencent.mm.model.q.GF(), bdVar.field_createTime).hashCode();
                ato.rco = bf.Is();
                bko.hbG.add(ato);
                bko.hbF = bko.hbG.size();
                this.dZy.add(bdVar);
            }
            i = i2 + 1;
        }
        int a = a(eVar, this.diG, this);
        if (a >= 0) {
            return a;
        }
        PG();
        return a;
    }

    public final int getType() {
        return 522;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            int i4;
            List list = ((bkp) this.diG.dIE.dIL).hbG;
            if (this.dZy.size() == list.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        x.i("MicroMsg.NetSceneSendMsg", "total " + i5 + " msgs sent successfully");
                        break;
                    }
                    atp atp = (atp) list.get(i5);
                    if (atp.rfn != 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + atp.rfn);
                        ic(i5);
                        this.diJ.a(4, atp.rfn, str, this);
                        return;
                    }
                    long j = ((bd) this.dZy.get(i5)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + atp.rcq + " sent successfully!");
                    au.HU();
                    bd dW = c.FT().dW(j);
                    dW.ax(atp.rcq);
                    dW.setStatus(2);
                    au.HU();
                    c.FT().a(j, dW);
                    i4 = i5 + 1;
                }
            }
            i4 = a(this.dIX, this.diJ);
            if (i4 == -2) {
                this.diJ.a(0, 0, str, this);
                return;
            } else if (i4 < 0) {
                this.diJ.a(3, -1, str, this);
                return;
            } else {
                return;
            }
        }
        PG();
        this.diJ.a(i2, i3, str, this);
    }

    private void PG() {
        for (int i = 0; i < this.dZy.size(); i++) {
            ic(i);
        }
    }

    private void ic(int i) {
        bd bdVar = (bd) this.dZy.get(i);
        bdVar.setStatus(5);
        au.HU();
        c.FT().a(bdVar.field_msgId, bdVar);
        Iterator it = dZx.iterator();
        while (it.hasNext()) {
            it.next();
            String str = bdVar.field_talker;
            str = bdVar.field_content;
        }
    }
}
