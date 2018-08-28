package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class i extends l implements k {
    private static final List<Object> dZx = new ArrayList();
    public long bJC;
    private boolean dZA = false;
    private final List<bd> dZB = new ArrayList();
    private bd dZC = null;
    public com.tencent.mm.plugin.messenger.foundation.a.l dZD = null;
    private final List<bd> dZy = new LinkedList();
    private int dZz = 3;
    private b diG;
    private e diJ;

    static /* synthetic */ void M(List list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                u((bd) list.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    static /* synthetic */ void N(List list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                t((bd) list.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public i(String str, String str2, int i, int i2, Object obj) {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bi.cjd()});
        if (!bi.oW(str)) {
            bd bdVar = new bd();
            bdVar.setStatus(1);
            bdVar.ep(str);
            bdVar.ay(com.tencent.mm.model.bd.iD(str));
            bdVar.eX(1);
            bdVar.setContent(str2);
            bdVar.setType(i);
            String a = a(((p) g.l(p.class)).v(bdVar), obj, i2);
            if (!bi.oW(a)) {
                bdVar.dt(a);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar.cqb});
            }
            try {
                this.bJC = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(bdVar, true);
                if (this.bJC == -1) {
                    f.mDy.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.bJC != -1);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bJC);
            } catch (SQLiteException e) {
                f.mDy.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public i(String str, String str2, int i) {
        boolean z = false;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bi.cjd()});
        if (!bi.oW(str)) {
            bd bdVar = new bd();
            bdVar.setStatus(1);
            bdVar.ep(str);
            bdVar.ay(com.tencent.mm.model.bd.iD(str));
            bdVar.eX(1);
            bdVar.setContent(str2);
            bdVar.setType(i);
            String v = ((p) g.l(p.class)).v(bdVar);
            if (!bi.oW(v)) {
                bdVar.dt(v);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[]{bdVar.cqb});
            }
            try {
                this.bJC = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().b(bdVar, true);
                if (this.bJC == -1) {
                    f.mDy.a(111, 255, 1, false);
                }
                if (this.bJC != -1) {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.bJC);
            } catch (SQLiteException e) {
                f.mDy.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public i(long j) {
        x.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + j);
        this.bJC = j;
        this.dZC = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(j);
        if (this.dZC == null) {
            x.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[]{Long.valueOf(j)});
        }
    }

    public i() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bi.cjd()});
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    public final boolean KX() {
        return true;
    }

    protected final int Cc() {
        return 10;
    }

    public final boolean KY() {
        boolean KY = super.KY();
        if (KY) {
            f.mDy.a(111, 254, 1, false);
        }
        return KY;
    }

    protected final int a(q qVar) {
        return this.dZy.size() > 0 ? l.b.dJm : l.b.dJn;
    }

    private static String a(String str, Object obj, int i) {
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        if (!bi.oW(str) && !str.startsWith("<msgsource>")) {
            x.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[]{str});
            return str;
        } else if (i != 291 || !(obj instanceof HashMap)) {
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (bi.oW(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (bi.oW(str2) || bi.oW(str4)) {
                    x.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[]{str4, str2});
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (!bi.oW(str)) {
                return str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            }
            stringBuffer.append("</msgsource>");
            return stringBuffer.toString();
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        List bdh;
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
        if (this.dZC == null) {
            bdh = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().bdh();
        } else {
            if (this.dZC.field_status != 5) {
                x.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[]{Long.valueOf(this.dZC.field_msgId), Integer.valueOf(this.dZC.field_status)});
            }
            this.dZC.setStatus(1);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(this.bJC, this.dZC);
            List arrayList = new ArrayList();
            arrayList.add(this.dZC);
            this.dZC = null;
            bdh = arrayList;
        }
        if (bdh.size() == 0) {
            x.w("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.dZy.clear();
        for (int i = 0; i < bdh.size(); i++) {
            bd bdVar = (bd) bdh.get(i);
            if (bdVar.field_isSend == 1) {
                ato ato = new ato();
                ato.rck = new bhz().VO(bdVar.field_talker);
                ato.lOH = (int) (bdVar.field_createTime / 1000);
                ato.hcE = bdVar.getType();
                ato.jSA = bdVar.field_content;
                ato.rWU = o.l(com.tencent.mm.model.q.GF(), bdVar.field_createTime).hashCode();
                if (this.dZD == null) {
                    this.dZD = ((p) g.l(p.class)).PK();
                }
                x.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[]{this.dZD});
                this.dZD.a(ato, bdVar);
                x.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[]{ato.rco});
                bko.hbG.add(ato);
                bko.hbF = bko.hbG.size();
                this.dZy.add(bdVar);
            }
        }
        int a = a(eVar, this.diG, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[]{Integer.valueOf(a)});
        PG();
        return a;
    }

    public final int getType() {
        return 522;
    }

    private void ib(int i) {
        if (this.dZy == null) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
        } else if (i >= this.dZy.size() || i < 0) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.dZy.size())});
        } else {
            t((bd) this.dZy.get(i));
        }
    }

    private static void t(bd bdVar) {
        ox oxVar = new ox();
        oxVar.bZS.bGS = bdVar;
        com.tencent.mm.sdk.b.a.sFg.m(oxVar);
        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        if (i2 == 0 && i3 == 0) {
            List list = ((bkp) this.diG.dIE.dIL).hbG;
            ArrayList arrayList = new ArrayList();
            if (this.dZy.size() == list.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        x.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[]{Integer.valueOf(i5 - this.dZB.size()), Integer.valueOf(this.dZB.size())});
                        break;
                    }
                    atp atp = (atp) list.get(i5);
                    if (atp.rfn != 0 || af.exT) {
                        f.mDy.a(111, 252, 1, false);
                        if (atp.rfn == -49 || af.exT) {
                            x.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[]{Integer.valueOf(atp.rfn), Integer.valueOf(i5), Boolean.valueOf(af.exT), Integer.valueOf(this.dZz)});
                            if (this.dZA) {
                                this.dZB.add((bd) this.dZy.get(i5));
                            } else if (this.dZz < 0) {
                                ic(i5);
                                this.diJ.a(4, atp.rfn, str, this);
                                ib(i5);
                                return;
                            } else {
                                this.dZA = true;
                                this.dZz--;
                                this.dZB.add((bd) this.dZy.get(i5));
                                g.Em().H(new 1(this, str));
                            }
                        } else {
                            ic(i5);
                            this.diJ.a(4, atp.rfn, str, this);
                            ib(i5);
                            return;
                        }
                    }
                    long j = ((bd) this.dZy.get(i5)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + atp.rcq + " sent successfully!");
                    bd dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(j);
                    dW.ax(atp.rcq);
                    x.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(atp.rcq), Integer.valueOf(af.exn)});
                    if (10007 == af.exm && af.exn != 0) {
                        dW.ax((long) af.exn);
                        af.exn = 0;
                    }
                    dW.setStatus(2);
                    ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(j, dW);
                    if (this.dZy == null) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i5 >= this.dZy.size() || i5 < 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[]{Integer.valueOf(i5), Integer.valueOf(this.dZy.size())});
                    } else {
                        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[]{Long.valueOf(((bd) this.dZy.get(i5)).field_msgId)});
                        bd dW2 = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(j);
                        oz ozVar = new oz();
                        ozVar.bZU.bGS = dW2;
                        com.tencent.mm.sdk.b.a.sFg.m(ozVar);
                    }
                    arrayList.add(Integer.valueOf(i5));
                    if (1 == atp.hcE) {
                        f.mDy.a(11942, true, false, new Object[]{Long.valueOf(atp.rcq)});
                        f.mDy.a(11945, false, true, new Object[]{Long.valueOf(atp.rcq)});
                        f.mDy.a(11946, false, false, new Object[]{Long.valueOf(atp.rcq)});
                        f.mDy.a(90, 0, 1, false);
                        f.mDy.a(90, 1, 1, true);
                    }
                    i4 = i5 + 1;
                }
            }
            x.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[]{Boolean.valueOf(this.dZA)});
            if (this.dZA) {
                this.diJ.a(i2, i3, str, this);
                return;
            } else {
                mn(str);
                return;
            }
        }
        f.mDy.a(111, (long) (i2 + 40), 1, true);
        f.mDy.a(111, 253, 1, false);
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        PG();
        this.diJ.a(i2, i3, str, this);
        for (i4 = 0; i4 < this.dZy.size(); i4++) {
            ib(i4);
        }
        x.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        mn(str);
    }

    private void mn(String str) {
        x.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.dIX, this.diJ);
        if (a == -2) {
            this.diJ.a(0, 0, str, this);
        } else if (a < 0) {
            this.diJ.a(3, -1, str, this);
        }
    }

    private void PG() {
        for (int i = 0; i < this.dZy.size(); i++) {
            ic(i);
        }
    }

    private void ic(int i) {
        x.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[]{Long.valueOf(((bd) this.dZy.get(i)).field_msgId)});
        u(r0);
    }

    private static void u(bd bdVar) {
        bdVar.setStatus(5);
        f.mDy.a(111, 30, 1, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a(bdVar.field_msgId, bdVar);
        Iterator it = dZx.iterator();
        while (it.hasNext()) {
            it.next();
            String str = bdVar.field_talker;
            str = bdVar.field_content;
        }
    }
}
