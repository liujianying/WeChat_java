package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Creator<FaceCharacteristicsResult> CREATOR = new 1();
    public String Yy;
    public int errCode;
    public FaceStatus iNo;

    protected FaceCharacteristicsResult(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.Yy = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.iNo, i);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.Yy);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceCharacteristicsResult{mStatus=" + this.iNo + ", errCode=" + this.errCode + ", errMsg='" + this.Yy + '\'' + '}';
    }

    public static boolean ps(int i) {
        return i >= 10 && i < 100;
    }

    public static boolean pt(int i) {
        return i > 0 && i < 10;
    }

    public static boolean pu(int i) {
        return i <= 0;
    }

    public final void ad(int i, String str) {
        this.errCode = i;
        this.Yy = str;
    }
}
