package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.g;

public final class bj implements g {
    private final String aEN;
    private final String aXv;

    public bj(g gVar) {
        this.aEN = gVar.getId();
        this.aXv = gVar.rR();
    }

    public final /* synthetic */ Object freeze() {
        return this;
    }

    public final String getId() {
        return this.aEN;
    }

    public final String rR() {
        return this.aXv;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.aEN == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.aEN);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.aXv);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
