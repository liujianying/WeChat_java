package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import org.json.JSONObject;

public final class e extends m {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    public int hUm = -1;
    private String hUn = "";
    public String lJJ = "";
    public int lJK = -1;
    public String lJL = "";
    public int lJM = 1;
    public RealnameGuideHelper lJN;
    private String lJO;
    private String lJP;
    private String lJQ;
    private String lJR;
    private String lJS;

    public e(int i, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aws();
        aVar.dIH = new awt();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.dIF = 609;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aws aws = (aws) this.diG.dID.dIL;
        aws.rZT = i;
        aws.ksA = str;
        aws.eJn = str2;
        aws.rmQ = i.bOL();
        this.lJM = i;
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        awt awt = (awt) ((b) qVar).dIE.dIL;
        if (i == 0 && i2 == 0) {
            try {
                if (awt.rJv != null) {
                    JSONObject jSONObject = new JSONObject(awt.rJv);
                    this.lJJ = jSONObject.optString("transaction_id");
                    this.hUm = jSONObject.optInt("retcode");
                    this.hUn = jSONObject.optString("retmsg");
                    this.lJK = jSONObject.optInt("wx_error_type");
                    this.lJL = jSONObject.optString("wx_error_msg");
                    x.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[]{jSONObject.toString()});
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.lJO = optJSONObject.optString("guide_flag");
                        this.lJP = optJSONObject.optString("guide_wording");
                        this.lJQ = optJSONObject.optString("left_button_wording");
                        this.lJR = optJSONObject.optString("right_button_wording");
                        this.lJS = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.lJO) || "2".equals(this.lJO)) {
                            this.lJN = new RealnameGuideHelper();
                            this.lJN.a(this.lJO, this.lJP, this.lJQ, this.lJR, this.lJS, 0);
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ad.getContext().getString(a$i.wallet_data_err);
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }
}
