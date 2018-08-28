package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.f;

public final class h extends com.google.android.gms.common.data.h<f> implements g {
    private final Status bcQ;

    public h(DataHolder dataHolder) {
        super(dataHolder);
        this.bcQ = new Status(dataHolder.aJC);
    }

    protected final /* synthetic */ Object ay(int i, int i2) {
        return new f(this.aMb, i, i2);
    }

    public final Status oF() {
        return this.bcQ;
    }

    protected final String oX() {
        return "path";
    }
}
