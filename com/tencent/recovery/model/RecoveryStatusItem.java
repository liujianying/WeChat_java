package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Creator<RecoveryStatusItem> CREATOR = new Creator<RecoveryStatusItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.fMk = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.vhi = parcel.readInt();
            recoveryStatusItem.vhl = parcel.readInt();
            recoveryStatusItem.vhk = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RecoveryStatusItem[i];
        }
    };
    public String clientVersion;
    public String fMk;
    public String processName;
    public long timestamp;
    public int vhi;
    public int vhk;
    public int vhl;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.processName);
        parcel.writeString(this.fMk);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.vhi);
        parcel.writeInt(this.vhl);
        parcel.writeInt(this.vhk);
        parcel.writeLong(this.timestamp);
    }

    public final boolean ack(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.fMk = split[1];
            this.clientVersion = split[2];
            this.vhi = Integer.valueOf(split[3]).intValue();
            this.vhl = Integer.valueOf(split[4]).intValue();
            this.vhk = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final String cEY() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.fMk);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.vhi);
        stringBuffer.append(",");
        stringBuffer.append(this.vhl);
        stringBuffer.append(",");
        stringBuffer.append(this.vhk);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }
}
