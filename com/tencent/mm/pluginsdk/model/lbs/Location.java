package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new 1();
    public int accuracy;
    public int bUi;
    public String bUk;
    public float dRS;
    public float dRT;
    public String mac;

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.dRS = f;
        this.dRT = f2;
        this.accuracy = i;
        this.bUi = i2;
        this.mac = str;
        this.bUk = str2;
    }

    public final boolean ccc() {
        if (this.dRS != -85.0f && this.dRT != -1000.0f) {
            return false;
        }
        x.d("MicroMsg.Radar.Location", "mac and cellId is null");
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.dRS);
        parcel.writeFloat(this.dRT);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.bUi);
        parcel.writeString(this.mac);
        parcel.writeString(this.bUk);
    }
}
