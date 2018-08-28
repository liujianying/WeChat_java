package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RecoveryData implements Parcelable {
    public static final Creator<RecoveryData> CREATOR = new Creator<RecoveryData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryData recoveryData = new RecoveryData();
            recoveryData.processName = parcel.readString();
            recoveryData.fMk = parcel.readString();
            recoveryData.clientVersion = parcel.readString();
            recoveryData.vhv = parcel.readString();
            recoveryData.vhw = parcel.readArrayList(RecoveryData.class.getClassLoader());
            return recoveryData;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryData[i];
        }
    };
    public String clientVersion;
    public String fMk;
    public String processName;
    public String vhv;
    public List<RecoveryStatusItem> vhw;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.fMk);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.vhv);
        parcel.writeList(this.vhw);
    }
}
