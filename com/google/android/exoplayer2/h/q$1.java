package com.google.android.exoplayer2.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.t;

class q$1 implements l<String> {
    q$1() {
    }

    public final /* synthetic */ boolean Y(Object obj) {
        String aC = t.aC((String) obj);
        return (TextUtils.isEmpty(aC) || ((aC.contains("text") && !aC.contains("text/vtt")) || aC.contains("html") || aC.contains("xml"))) ? false : true;
    }
}
