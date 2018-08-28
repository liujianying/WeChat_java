package com.google.android.exoplayer2.c.c;

import java.util.Collections;
import java.util.List;

public final class u$b {
    public final String aem;
    public final List<u$a> api;
    public final byte[] apj;
    public final int streamType;

    public u$b(int i, String str, List<u$a> list, byte[] bArr) {
        List emptyList;
        this.streamType = i;
        this.aem = str;
        if (list == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(list);
        }
        this.api = emptyList;
        this.apj = bArr;
    }
}
