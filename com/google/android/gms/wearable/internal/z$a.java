package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.k.b;

public class z$a implements b {
    private final Status bcQ;
    private final int beF;

    public z$a(Status status, int i) {
        this.bcQ = status;
        this.beF = i;
    }

    public final Status oF() {
        return this.bcQ;
    }
}
