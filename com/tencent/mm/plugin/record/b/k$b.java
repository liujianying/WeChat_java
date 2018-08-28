package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class k$b implements e, a, Runnable {
    private boolean bwt = false;
    private int i = 0;
    private g mrL;
    HashMap<Long, Boolean> msh = new HashMap();
    final /* synthetic */ k msk;
    HashMap<Long, String> msl = new HashMap();

    public k$b(k kVar, g gVar) {
        this.msk = kVar;
        this.mrL = gVar;
        o.Ta().a(this, Looper.getMainLooper());
        au.DF().a(221, this);
    }

    public final void run() {
        this.i = 0;
        this.bwt = false;
        Iterator it = this.mrL.field_dataProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            long j = vxVar.rAu;
            if (j > 0) {
                au.HU();
                bd dW = c.FT().dW(j);
                String str = vxVar.rzM;
                Object obj = (System.currentTimeMillis() - dW.field_createTime <= 259200000 || (!bi.oW(str) && com.tencent.mm.a.e.cn(str))) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[]{Integer.valueOf(dW.getType())});
                } else if (vxVar.bjS == 2) {
                    if (dW.ckA()) {
                        int i;
                        com.tencent.mm.ak.e bq = com.tencent.mm.ak.o.Pf().bq(dW.field_msgSvrId);
                        if (dW.field_isSend == 1) {
                            int i2;
                            if (bq.ON()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            i = i2;
                        } else if (bq.ON()) {
                            if (com.tencent.mm.a.e.cn(com.tencent.mm.ak.o.Pf().o(f.a(bq).dTL, "", ""))) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (bq.offset < bq.dHI || bq.dHI == 0) {
                            this.msh.put(Long.valueOf(j), Boolean.valueOf(false));
                            this.i = this.mrL.field_dataProto.rBI.indexOf(vxVar);
                            com.tencent.mm.ak.o.Pg().a(bq.dTK, dW.field_msgId, i, vxVar, R.g.chat_img_template, new 1(this, bq, dW, j));
                        }
                    } else if (dW.cmo()) {
                        Y(dW);
                    }
                } else if (vxVar.bjS == 4 || vxVar.bjS == 15) {
                    r nW = t.nW(dW.field_imgPath);
                    if (!(nW == null || nW.status == 199)) {
                        this.msh.put(Long.valueOf(j), Boolean.valueOf(false));
                        if (nW.To()) {
                            x.i("MicroMsg.RecordMsgSendService", "start complete online video");
                            t.oa(dW.field_imgPath);
                        } else {
                            x.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                            t.nS(dW.field_imgPath);
                        }
                    }
                } else if (vxVar.bjS == 8 && !bi.oW(vxVar.rAG)) {
                    Y(dW);
                }
            }
        }
        this.bwt = true;
        this.msk.mrO = false;
        a(this.msh, this.bwt, this.mrL);
    }

    public final void a(a.a aVar) {
        r nW = t.nW(aVar.fileName);
        if (nW != null) {
            au.HU();
            bd dW = c.FT().dW((long) nW.enN);
            if (nW.Tp()) {
                this.msh.put(Long.valueOf(dW.field_msgId), Boolean.valueOf(true));
                a(this.msh, this.bwt, this.mrL);
                return;
            }
            return;
        }
        a(null, this.bwt, this.mrL);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof ac) {
            au.DF().b(221, this);
            if (this.msl != null) {
                for (Entry entry : this.msl.entrySet()) {
                    long longValue = ((Long) entry.getKey()).longValue();
                    String str2 = (String) entry.getValue();
                    if (longValue > 0 && !((Boolean) this.msh.get(Long.valueOf(longValue))).booleanValue()) {
                        au.HU();
                        c.FT().dW(longValue);
                        b am = com.tencent.mm.pluginsdk.model.app.l.am(str2, longValue);
                        if (am != null) {
                            str2 = am.field_fileFullPath;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null && str2.length() > 0) {
                            this.msh.put(Long.valueOf(longValue), Boolean.valueOf(true));
                            Iterator it = this.mrL.field_dataProto.rBI.iterator();
                            while (it.hasNext()) {
                                vx vxVar = (vx) it.next();
                                if (vxVar.rAu == longValue) {
                                    vxVar.UP(am.field_fileFullPath);
                                }
                            }
                        }
                    }
                }
            }
            a(this.msh, this.bwt, this.mrL);
            return;
        }
        a(null, this.bwt, this.mrL);
    }

    private void Y(bd bdVar) {
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bdVar.field_content);
        if (gp == null) {
            x.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[]{bdVar.field_content});
            return;
        }
        if (bi.oW(gp.bGP) && !bi.oW(gp.dwD)) {
            x.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[]{bdVar.field_content});
            gp.bGP = gp.dwD.hashCode();
        }
        String str = gp.bGP;
        if (!com.tencent.mm.pluginsdk.model.app.l.a(bdVar, com.tencent.mm.pluginsdk.model.app.l.am(str, bdVar.field_msgId))) {
            this.msh.put(Long.valueOf(bdVar.field_msgId), Boolean.valueOf(false));
            this.msl.put(Long.valueOf(bdVar.field_msgId), str);
            com.tencent.mm.pluginsdk.model.app.l.a(bdVar, null);
        }
    }

    private void a(HashMap<Long, Boolean> hashMap, boolean z, g gVar) {
        int i;
        if (hashMap != null) {
            for (Entry value : hashMap.entrySet()) {
                if (!Boolean.valueOf(((Boolean) value.getValue()).booleanValue()).booleanValue()) {
                    i = 0;
                    break;
                }
            }
        }
        i = 1;
        if (i != 0 && z) {
            o.Ta().a(this);
            gVar.field_type = 2;
            n.bqv().c(gVar, new String[]{"localId"});
            n.bqw().a(gVar);
        }
    }
}
