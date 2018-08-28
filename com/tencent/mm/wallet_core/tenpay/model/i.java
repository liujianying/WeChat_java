package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.model.q;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.t;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class i extends com.tencent.mm.wallet_core.c.i {
    public static Vector<String> uYa = new Vector();
    protected boolean uXZ = false;

    public abstract int aBO();

    public int bNX() {
        return aBO();
    }

    public void J(boolean z, boolean z2) {
        b KT;
        b bVar = this.diG;
        if (bVar == null) {
            a aVar = new a();
            aVar.dIG = new bsq();
            aVar.dIH = new bsr();
            String uri = getUri();
            int If = If();
            aVar.uri = uri;
            aVar.dIF = If;
            aVar.dII = 185;
            aVar.dIJ = 1000000185;
            KT = aVar.KT();
            KT.dIU = !cDq();
        } else {
            KT = bVar;
        }
        bsq bsq = (bsq) KT.dID.dIL;
        if (z) {
            bsq.rPs = aBO();
        }
        if (z2) {
            bsq.rPt = 1;
        }
        this.diG = KT;
    }

    public boolean cDq() {
        return true;
    }

    public int getType() {
        return 385;
    }

    public final String OT(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bhy bhy) {
        ((bsq) bVar.dID.dIL).rPu = bhy;
    }

    public final void b(b bVar, bhy bhy) {
        ((bsq) bVar.dID.dIL).scR = bhy;
    }

    static {
        for (Object add : d.qUT) {
            uYa.add(add);
        }
    }

    public final n d(b bVar) {
        bsr bsr = (bsr) bVar.dIE.dIL;
        n nVar = new n();
        nVar.rPy = bsr.rPy;
        nVar.rPx = bsr.rPx;
        nVar.rPw = bsr.rPw;
        nVar.rPv = bsr.rPv;
        nVar.iwT = bsr.scT;
        nVar.uXp = bsr.scS;
        return nVar;
    }

    private int e(b bVar) {
        String str;
        bsq bsq = (bsq) bVar.dID.dIL;
        if (bsq.rPu != null) {
            str = new String(bsq.rPu.siK.lR);
        }
        if (bsq.scR != null) {
            str = new String(bsq.scR.siK.lR);
        }
        t.cDk();
        if (!this.uXZ) {
            return -1;
        }
        bsr bsr = (bsr) bVar.dIE.dIL;
        if (bsr == null) {
            bsr = new bsr();
        }
        bsr.rPv = new bhy().bq("".getBytes());
        bsr.rPy = bNX();
        bsr.rPw = 0;
        try {
            JSONObject jSONObject = new JSONObject(null);
            bsr.scS = jSONObject.optInt("TenpayErrType");
            bsr.scT = jSONObject.optString("TenpayErrMsg");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        a(1, 0, 0, "", bVar, null);
        return 1;
    }

    public final void cDz() {
        this.uXZ = true;
    }

    public int a(e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        if (uYa.contains(this.diG.uri)) {
            x.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[]{this.diG.uri});
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.c.a.cCW();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
            x.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.c.a.cCW();
            com.tencent.mm.wallet_core.c.a.init(ad.getContext());
            bsq bsq = (bsq) this.diG.dID.dIL;
            String str = "";
            String str2 = "";
            if (bsq.rPu != null) {
                str = new String(bsq.rPu.siK.lR);
            }
            if (bsq.scR != null) {
                str2 = new String(bsq.scR.siK.lR);
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            s.cDi();
            String cDh = s.cDh();
            com.tencent.mm.wallet_core.c.a.cCW();
            if (com.tencent.mm.wallet_core.c.a.isCertExist(cDh)) {
                h.mEJ.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.c.a.cCW();
                String genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(cDh, str3);
                h.mEJ.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                x.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[]{str3, genUserSig});
                bsq.sign = genUserSig;
                bsq.spW = cDh;
            } else {
                objArr = new Object[2];
                objArr[0] = cDh;
                com.tencent.mm.wallet_core.c.a.cCW();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
                x.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            x.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cDh});
        }
        if (this.uXZ) {
            int e = e(this.diG);
            if (e != -1) {
                return e;
            }
        }
        if (q.GS()) {
            x.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            eVar2.a(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.diG, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int If() {
        return 385;
    }
}
