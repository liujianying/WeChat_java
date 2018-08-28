package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import org.json.JSONObject;

class WalletOrderInfoOldUI$b {
    public String bSc;
    public String bWP;
    final /* synthetic */ WalletOrderInfoOldUI pwD;
    public String pwk;
    public String title;
    public String url;

    public WalletOrderInfoOldUI$b(WalletOrderInfoOldUI walletOrderInfoOldUI, JSONObject jSONObject) {
        this.pwD = walletOrderInfoOldUI;
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                this.bSc = optJSONObject.optString("wording");
                this.bWP = optJSONObject.optString("icon");
                this.pwk = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
            }
        }
    }

    public final String toString() {
        return this.url + " , " + this.bSc + " , " + this.bWP + " , " + this.pwk + " , " + this.title;
    }
}
