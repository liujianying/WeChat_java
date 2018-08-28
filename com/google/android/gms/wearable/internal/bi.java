package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.wearable.d;

public final class bi extends f implements d {
    private final int beK;

    public bi(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.beK = i2;
    }

    public final /* synthetic */ Object freeze() {
        return new bh(this);
    }

    public final int getType() {
        return getInteger("event_type");
    }

    public final com.google.android.gms.wearable.f rP() {
        return new f(this.aMb, this.aMx, this.beK);
    }

    public final String toString() {
        String str = getInteger("event_type") == 1 ? "changed" : getInteger("event_type") == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + rP() + " }";
    }
}
