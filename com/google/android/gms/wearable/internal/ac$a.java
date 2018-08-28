package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n.a;
import java.util.List;

public class ac$a implements a {
    private final Status bcQ;
    private final List<m> beR;

    public ac$a(Status status, List<m> list) {
        this.bcQ = status;
        this.beR = list;
    }

    public final Status oF() {
        return this.bcQ;
    }

    public final List<m> rS() {
        return this.beR;
    }
}
