package com.tencent.mm.storage.emotion;

import org.json.JSONException;
import org.json.JSONObject;

public final class u {
    public String aAL;
    public long dDj;
    public int position;
    public int tdg;

    public final JSONObject bpY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.aAL);
            jSONObject.put("position", this.position);
            jSONObject.put("use_count", this.tdg);
            jSONObject.put("last_time", this.dDj);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
