package com.tencent.matrix.c;

import org.json.JSONObject;

public final class b {
    public String aAL;
    public Integer brl;
    public JSONObject brm;
    public com.tencent.matrix.b.b brn;
    public String tag;

    public b(int i) {
        this.brl = Integer.valueOf(i);
    }

    public b(JSONObject jSONObject) {
        this.brm = jSONObject;
    }

    public final String toString() {
        return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[]{this.tag, this.brl, this.aAL, this.brm});
    }
}
