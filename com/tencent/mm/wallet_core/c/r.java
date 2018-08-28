package com.tencent.mm.wallet_core.c;

import org.json.JSONObject;

public final class r {
    public String spW = "";
    public String sxq = "";
    public String uXv = "";
    public String uXw = "";
    public int uXx = 0;

    public r(JSONObject jSONObject) {
        this.uXv = jSONObject.optString("device_id");
        this.sxq = jSONObject.optString("device_name");
        this.uXw = jSONObject.optString("device_os");
        this.uXx = jSONObject.optInt("Is_cur_device");
        this.spW = jSONObject.optString("crt_no");
    }
}
