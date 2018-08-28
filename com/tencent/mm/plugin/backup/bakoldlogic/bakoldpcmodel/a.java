package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b;

public final class a extends d {
    private static a gZf;
    private e gZg;
    private c gZh;
    private b gZi;

    public static a asN() {
        if (gZf == null) {
            a aVar = new a();
            gZf = aVar;
            a(aVar);
        }
        return gZf;
    }

    public final void aqK() {
        gZf = null;
    }

    public final void l(Object... objArr) {
        Context context = (Context) objArr[0];
        asN().asQ().asR();
        b.clear();
        context.stopService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
    }

    public final e asO() {
        if (this.gZg == null) {
            this.gZg = new e();
        }
        return this.gZg;
    }

    public final c asP() {
        if (this.gZh == null) {
            this.gZh = new c();
        }
        return this.gZh;
    }

    public final b asQ() {
        if (this.gZi == null) {
            this.gZi = new b();
        }
        return this.gZi;
    }

    public final void aqQ() {
    }

    public final void aqR() {
    }
}
