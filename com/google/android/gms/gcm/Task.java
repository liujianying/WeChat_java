package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final String aQM;
    private final boolean aQN;
    private final boolean aQO;
    private final int aQP;
    private final boolean aQQ;
    private final Bundle mExtras;
    private final String mTag;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        this.aQM = parcel.readString();
        this.mTag = parcel.readString();
        this.aQN = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.aQO = z;
        this.aQP = 2;
        this.aQQ = false;
        this.mExtras = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.aQM);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.aQN ? 1 : 0);
        if (!this.aQO) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
