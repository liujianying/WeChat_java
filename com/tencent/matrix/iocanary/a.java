package com.tencent.matrix.iocanary;

import android.app.Application;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import com.tencent.matrix.iocanary.core.IOCanaryJniBridge;

public final class a extends b {
    public final com.tencent.matrix.iocanary.a.a bqJ = com.tencent.matrix.iocanary.a.a.bqL;
    private com.tencent.matrix.iocanary.core.a bqK;

    public final void a(Application application, c cVar) {
        super.a(application, cVar);
        com.tencent.matrix.iocanary.c.a.ay(application);
        this.bqK = new com.tencent.matrix.iocanary.core.a(this);
    }

    public final void start() {
        super.start();
        com.tencent.matrix.iocanary.core.a aVar = this.bqK;
        com.tencent.matrix.iocanary.a.a aVar2 = aVar.bqJ;
        if (com.tencent.matrix.iocanary.core.a.$assertionsDisabled || aVar2 != null) {
            if (aVar2.el(1) || aVar2.el(4) || aVar2.el(2)) {
                IOCanaryJniBridge.a(aVar2, aVar);
            }
            if (aVar2.el(8)) {
                aVar.bqV = new com.tencent.matrix.iocanary.b.a(aVar);
                com.tencent.matrix.iocanary.b.a aVar3 = aVar.bqV;
                com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "hook sIsTryHook=%b", Boolean.valueOf(aVar3.bqZ));
                if (!aVar3.bqZ) {
                    com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "hook hookRet=%b", Boolean.valueOf(aVar3.tu()));
                    aVar3.bqZ = true;
                }
            }
            synchronized (aVar) {
                aVar.bpL = true;
            }
            return;
        }
        throw new AssertionError();
    }

    public final void stop() {
        super.stop();
        com.tencent.matrix.iocanary.core.a aVar = this.bqK;
        synchronized (aVar) {
            aVar.bpL = false;
        }
        if (aVar.bqV != null) {
            com.tencent.matrix.iocanary.b.a aVar2 = aVar.bqV;
            com.tencent.matrix.d.b.i("Matrix.CloseGuardHooker", "unHook unHookRet=%b", Boolean.valueOf(com.tencent.matrix.iocanary.b.a.tv()));
            aVar2.bqZ = false;
        }
        IOCanaryJniBridge.ts();
    }

    public final String getTag() {
        return "io";
    }
}
