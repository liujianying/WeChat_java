package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem implements Parcelable {
    public abstract boolean ack(String str);

    public abstract String cEY();

    public String toString() {
        return cEY();
    }
}
