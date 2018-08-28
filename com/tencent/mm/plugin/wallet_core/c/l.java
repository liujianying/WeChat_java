package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends i {
    public l() {
        F(new HashMap());
    }

    public final int aBO() {
        return 1631;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : " + i);
        if (i == 0) {
            o.bOZ().diF.fV("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                x.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        com.tencent.mm.plugin.wallet_core.model.x ak = com.tencent.mm.plugin.wallet_core.model.x.ak(optJSONArray.optJSONObject(i2));
                        if (ak != null) {
                            o.bOZ().b(ak);
                        }
                    }
                    return;
                }
                x.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                return;
            }
            x.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    public final int If() {
        return 1631;
    }
}
