package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import com.tencent.mm.e.b.h;

class b$a extends h {
    String fileName;
    final /* synthetic */ b laG;

    public b$a(b bVar, Context context) {
        this.laG = bVar;
        super(context, false);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean wk() {
        this.fileName = super.getFileName();
        boolean wk = super.wk();
        super.reset();
        return wk;
    }
}
