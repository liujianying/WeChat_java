package com.tencent.mm.plugin.wallet_core.model;

import org.json.JSONObject;

public class n$a {
    public String lRX;
    public String name;
    public String poG;
    public String poH;
    public String title;
    public int type;
    public String url;

    public final void ag(JSONObject jSONObject) {
        this.url = jSONObject.optString("url");
        this.name = jSONObject.optString("wording");
        this.lRX = jSONObject.optString("icon");
        this.poG = jSONObject.optString("btn_text");
        this.type = jSONObject.optInt("type");
        this.title = jSONObject.optString("title");
        this.poH = jSONObject.optString("small_title");
    }
}
