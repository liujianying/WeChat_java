package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new 1();
    public String bGG;
    public int cbA;
    public int cbB;
    public String cbC;
    public int gqK;
    public int scene;

    public final String toString() {
        return "AppBrandStatObject{preScene=" + this.cbB + ", preSceneNote='" + this.cbC + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.bGG + '\'' + ", usedState=" + this.gqK + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.cbB);
        parcel.writeString(this.cbC);
        parcel.writeInt(this.scene);
        parcel.writeString(this.bGG);
        parcel.writeInt(this.gqK);
        parcel.writeInt(this.cbA);
    }

    protected AppBrandStatObject(Parcel parcel) {
        this.cbB = parcel.readInt();
        this.cbC = parcel.readString();
        this.scene = parcel.readInt();
        this.bGG = parcel.readString();
        this.gqK = parcel.readInt();
        this.cbA = parcel.readInt();
    }
}
