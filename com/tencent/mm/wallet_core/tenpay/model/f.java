package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public class f extends l {
    protected JSONObject uXV;
    public boolean uXW = false;
    public int uXX = 0;
    public boolean uXY = false;

    public f(Map<String, String> map) {
        x.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        F(map);
    }

    public final int aBO() {
        return 1525;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    public int If() {
        return 1525;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (af.eyh) {
            try {
                jSONObject = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
            } catch (Exception e) {
            }
        }
        x.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i + "errMsg=" + str);
        this.uXV = jSONObject;
        if (jSONObject != null) {
            boolean z;
            x.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", new Object[]{jSONObject.toString()});
            if (jSONObject.optInt("can_pay_retry") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.uXW = z;
            this.uXX = jSONObject.optInt("show_retmsg_type");
        }
    }

    public final JSONObject cDy() {
        return this.uXV;
    }
}
