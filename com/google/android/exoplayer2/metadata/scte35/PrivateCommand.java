package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;

public final class PrivateCommand extends SpliceCommand {
    public static final Creator<PrivateCommand> CREATOR = new 1();
    public final long aqW;
    public final long aqX;
    public final byte[] aqY;

    /* synthetic */ PrivateCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.aqW = j2;
        this.aqX = j;
        this.aqY = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.aqW = parcel.readLong();
        this.aqX = parcel.readLong();
        this.aqY = new byte[parcel.readInt()];
        parcel.readByteArray(this.aqY);
    }

    static PrivateCommand a(j jVar, int i, long j) {
        long ba = jVar.ba();
        byte[] bArr = new byte[(i - 4)];
        jVar.readBytes(bArr, 0, bArr.length);
        return new PrivateCommand(ba, bArr, j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.aqW);
        parcel.writeLong(this.aqX);
        parcel.writeInt(this.aqY.length);
        parcel.writeByteArray(this.aqY);
    }
}
