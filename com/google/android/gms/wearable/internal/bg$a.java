package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.c$a;
import com.google.android.gms.wearable.f;

public class bg$a implements c$a {
    private final Status bcQ;
    private final f bfw;

    public bg$a(Status status, f fVar) {
        this.bcQ = status;
        this.bfw = fVar;
    }

    public final Status oF() {
        return this.bcQ;
    }
}
