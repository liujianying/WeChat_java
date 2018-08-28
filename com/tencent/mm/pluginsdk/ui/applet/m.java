package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.sdk.platformtools.bi;

public final class m {
    public int backgroundColor;
    public Object data;
    public int end;
    public String fmS;
    public int linkColor;
    public int start;
    public int type;
    public String url;
    public String username;

    @Deprecated
    public m(int i, int i2) {
        this.start = i;
        this.end = i2;
        this.url = null;
        this.type = 0;
        this.data = null;
    }

    public m(String str, int i, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i;
    }

    public final <T> T F(Class<T> cls) {
        if (cls.isInstance(this.data)) {
            return cls.cast(this.data);
        }
        return null;
    }

    public final int hashCode() {
        int hashCode = super.hashCode();
        if (!bi.oW(this.url)) {
            hashCode += this.url.hashCode();
        }
        hashCode = ((hashCode + this.type) + this.end) + this.start;
        if (this.data != null) {
            return hashCode + this.data.hashCode();
        }
        return hashCode;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return hashCode() == ((m) obj).hashCode();
        } else {
            return super.equals(obj);
        }
    }
}
