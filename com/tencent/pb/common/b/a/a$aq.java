package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$aq extends e {
    public int sceneType;

    public a$aq() {
        this.sceneType = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.sceneType != 0) {
            bVar.aE(1, this.sceneType);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.sceneType != 0) {
            return sl + b.aG(1, this.sceneType);
        }
        return sl;
    }
}
