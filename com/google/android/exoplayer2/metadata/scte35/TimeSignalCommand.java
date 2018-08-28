package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Creator<TimeSignalCommand> CREATOR = new Creator<TimeSignalCommand>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    };
    public final long ars;
    public final long art;

    /* synthetic */ TimeSignalCommand(long j, long j2, byte b) {
        this(j, j2);
    }

    private TimeSignalCommand(long j, long j2) {
        this.ars = j;
        this.art = j2;
    }

    static TimeSignalCommand b(j jVar, long j, q qVar) {
        long a = a(jVar, j);
        return new TimeSignalCommand(a, qVar.T(a));
    }

    static long a(j jVar, long j) {
        long readUnsignedByte = (long) jVar.readUnsignedByte();
        if ((128 & readUnsignedByte) != 0) {
            return ((((1 & readUnsignedByte) << 32) | jVar.ba()) + j) & 8589934591L;
        }
        return -9223372036854775807L;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.ars);
        parcel.writeLong(this.art);
    }
}
