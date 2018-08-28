package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.n;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i {
    public String token;

    public d(String str, String str2, int i) {
        Map hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        x.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", new Object[]{Integer.valueOf(i)});
        F(hashMap);
    }

    public final int bNX() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
    }

    public final void J(boolean z, boolean z2) {
        b bVar = this.diG;
        if (bVar == null) {
            a aVar = new a();
            aVar.dIG = new bsq();
            aVar.dIH = new bsr();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.dIF = 1616;
            aVar.dII = 185;
            aVar.dIJ = 1000000185;
            bVar = aVar.KT();
            bVar.dIU = true;
        }
        b bVar2 = bVar;
        bsq bsq = (bsq) bVar2.dID.dIL;
        if (z2) {
            bsq.rPt = 1;
        }
        this.diG = bVar2;
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

    public final int getType() {
        return 1616;
    }

    public final int a(e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
