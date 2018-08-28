package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

public final class bh implements d {
    private int aMd;
    private f bfw;

    public bh(d dVar) {
        this.aMd = dVar.getType();
        this.bfw = (f) dVar.rP().freeze();
    }

    public final /* synthetic */ Object freeze() {
        return this;
    }

    public final int getType() {
        return this.aMd;
    }

    public final f rP() {
        return this.bfw;
    }

    public final String toString() {
        String str = this.aMd == 1 ? "changed" : this.aMd == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + this.bfw + " }";
    }
}
