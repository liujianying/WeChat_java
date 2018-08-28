package com.tencent.mm.pluginsdk.model.app;

final class r {
    public String appId;
    public int efG;

    public r(String str, int i) {
        this.appId = str;
        this.efG = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (rVar.appId.equals(this.appId) && rVar.efG == this.efG) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.appId + this.efG;
    }
}
