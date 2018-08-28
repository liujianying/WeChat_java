package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Iterator;
import org.json.JSONObject;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public boolean pjc = false;
    private long pkG = 10;

    public b() {
        x.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call");
        a aVar = new a();
        ahc ahc = new ahc();
        ahc.rmQ = i.bOL();
        if (!f.cfE()) {
            ahc.rqE = f.cfF();
        }
        aVar.dIG = ahc;
        aVar.dIH = new ahd();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.dIF = 1666;
        this.diG = aVar.KT();
        this.diG.dIU = true;
    }

    public final int getType() {
        return 1666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            long j;
            ahd ahd = (ahd) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            if (ahd.rKy <= 0) {
                j = this.pkG;
            } else {
                j = ahd.rKy;
            }
            this.pjc = ahd.pjc;
            x.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", new Object[]{Boolean.valueOf(this.pjc)});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", ahd.rKr);
                jSONObject.put("bindcardSubTitle", ahd.rKs);
                jSONObject.put("bindIdTitle", ahd.rKt);
                jSONObject.put("bindIdSubTitle", ahd.rKu);
                jSONObject.put("extral_wording", ahd.rKv);
                jSONObject.put("question_answer_switch", ahd.rKw);
                jSONObject.put("question_answer_url", ahd.rKx);
                jSONObject.put("cache_time", j);
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", ahd.rKz);
                jSONObject.put("isShowBindCardVerify", ahd.rKB);
                jSONObject.put("isShowBindId", ahd.rKA);
                jSONObject.put("bindCardVerifyTitle", ahd.rKC);
                jSONObject.put("bindCardVerifySubtitle", ahd.rKD);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", ahd.rKE);
                jSONObject.put("bindCardVerifyAlertViewContent", ahd.rKF);
                jSONObject.put("isShowBindCardVerifyAlertView", ahd.rKG);
                if (ahd.rKH != null && ahd.rKH.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Object obj = null;
                    Iterator it = ahd.rKH.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (obj != null) {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(str2);
                        int obj2 = 1;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                g.Ek();
                g.Ei().DT().a(aa.a.sTc, jSONObject.toString());
                g.Ek();
                g.Ei().DT().lm(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e, "", new Object[0]);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
