package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new 1();
    public String eRp = "";
    public String gEw = "";
    public String mFileName = "";
    public String oET = "";
    public int oFa = 0;
    public int oFi;
    public int oFj;
    public int oFk = 0;
    public boolean oFl = false;
    public boolean oFm = false;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.oFi);
        parcel.writeInt(this.oFj);
        parcel.writeInt(this.oFk);
        parcel.writeInt(this.oFa);
        parcel.writeString(bi.aG(this.gEw, ""));
        parcel.writeString(bi.aG(this.oET, ""));
        parcel.writeString(bi.aG(this.mFileName, ""));
        if (this.oFl) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.oFm) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
