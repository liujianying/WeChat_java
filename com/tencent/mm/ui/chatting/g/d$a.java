package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.ui.chatting.a.b.b;

class d$a extends b {
    public String desc;
    public int iconRes;
    final /* synthetic */ d tYl;

    public d$a(d dVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.tYl = dVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean aak(String str) {
        if (str != null) {
            return super.aak(str.toLowerCase());
        }
        return false;
    }

    public final int getType() {
        return 6;
    }
}
