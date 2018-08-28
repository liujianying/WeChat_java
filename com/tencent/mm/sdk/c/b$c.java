package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.a;
import java.util.Map;

public class b$c {
    public String content;
    public Map<String, String> mcz;
    public a sFv;
    public int status;

    public b$c(String str) {
        this.status = 0;
        this.status = 0;
        this.mcz = null;
        this.content = str;
    }

    public String toString() {
        return "Response status:" + this.status + ", cookie:" + (this.mcz != null ? this.mcz : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
    }

    public void onComplete() {
    }
}
