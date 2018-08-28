package com.tencent.mm.app;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

class k$3 implements FilenameFilter {
    String byT = this.val$context.getPackageName();
    final /* synthetic */ k byU;
    final /* synthetic */ Context val$context;

    k$3(k kVar, Context context) {
        this.byU = kVar;
        this.val$context = context;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.byT);
    }
}
