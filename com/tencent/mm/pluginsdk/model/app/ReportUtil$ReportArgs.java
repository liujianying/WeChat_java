package com.tencent.mm.pluginsdk.model.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ReportUtil$ReportArgs implements Parcelable {
    public static final Creator<ReportUtil$ReportArgs> CREATOR = new 1();
    public int errCode;
    public int nc;
    public String openId;
    public String rU;
    public String transaction;

    /* synthetic */ ReportUtil$ReportArgs(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.rU);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.transaction);
        parcel.writeString(this.openId);
    }

    private ReportUtil$ReportArgs(Parcel parcel) {
        this.rU = parcel.readString();
        this.errCode = parcel.readInt();
        this.transaction = parcel.readString();
        this.openId = parcel.readString();
    }
}
