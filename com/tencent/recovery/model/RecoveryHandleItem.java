package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryHandleItem> CREATOR = new Creator<RecoveryHandleItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.fMk = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.aAL = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.vhx = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryHandleItem[i];
        }
    };
    public String aAL;
    public String clientVersion;
    public String fMk;
    public String processName;
    public long timestamp;
    public String vhx;

    public final String cEY() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fMk);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.aAL);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.vhx);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    public final boolean ack(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.fMk = split[0];
            this.clientVersion = split[1];
            this.aAL = split[2];
            this.processName = split[3];
            this.vhx = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fMk);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.aAL);
        parcel.writeString(this.processName);
        parcel.writeString(this.vhx);
        parcel.writeLong(this.timestamp);
    }
}
