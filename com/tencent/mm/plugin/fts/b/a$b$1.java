package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.b.a.b;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import java.util.Comparator;

class a$b$1 implements Comparator<String> {
    final /* synthetic */ b jtW;

    a$b$1(b bVar) {
        this.jtW = bVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
    }
}
