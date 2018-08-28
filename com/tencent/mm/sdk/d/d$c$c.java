package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.d.d.c;

class d$c$c {
    boolean ahg;
    final /* synthetic */ c sKs;
    c sKt;
    d$c$c sKu;

    private d$c$c(c cVar) {
        this.sKs = cVar;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("state=").append(this.sKt.getName()).append(",active=").append(this.ahg).append(",parent=");
        if (this.sKu == null) {
            str = "null";
        } else {
            str = this.sKu.sKt.getName();
        }
        return append.append(str).toString();
    }
}
