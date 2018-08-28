package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.a.b.b;

class f$a extends b {
    public String appId;
    public String bhd;
    public int iconRes;
    public String imagePath;
    final /* synthetic */ f tYA;

    public f$a(f fVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.tYA = fVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean aak(String str) {
        if (str == null) {
            return false;
        }
        Object toLowerCase = str.toLowerCase();
        if (aal(toLowerCase)) {
            if (!bi.oW(this.bhd) && this.bhd.toLowerCase().contains(toLowerCase)) {
                return true;
            }
        } else if (!bi.oW(this.bhd) && isContains(toLowerCase, this.bhd.toLowerCase())) {
            return true;
        }
        return super.aak(toLowerCase);
    }

    public final int getType() {
        return 3;
    }
}
