package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Creator<SpliceInsertCommand> CREATOR = new 1();
    public final long ara;
    public final boolean arb;
    public final boolean arc;
    public final boolean ard;
    public final boolean are;
    public final long arf;
    public final long arg;
    public final List<a> arh;
    public final boolean ari;
    public final long arj;
    public final int ark;
    public final int arl;
    public final int arm;

    /* synthetic */ SpliceInsertCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.ara = j;
        this.arb = z;
        this.arc = z2;
        this.ard = z3;
        this.are = z4;
        this.arf = j2;
        this.arg = j3;
        this.arh = Collections.unmodifiableList(list);
        this.ari = z5;
        this.arj = j4;
        this.ark = i;
        this.arl = i2;
        this.arm = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.ara = parcel.readLong();
        this.arb = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.arc = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ard = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.are = z;
        this.arf = parcel.readLong();
        this.arg = parcel.readLong();
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new a(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.arh = Collections.unmodifiableList(arrayList);
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.ari = z2;
        this.arj = parcel.readLong();
        this.ark = parcel.readInt();
        this.arl = parcel.readInt();
        this.arm = parcel.readInt();
    }

    static SpliceInsertCommand a(j jVar, long j, q qVar) {
        boolean z;
        long j2;
        long ba = jVar.ba();
        if ((jVar.readUnsignedByte() & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        long j3 = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z5 = false;
        if (z) {
            j2 = -9223372036854775807L;
        } else {
            long j4;
            boolean z6;
            int readUnsignedByte = jVar.readUnsignedByte();
            boolean z7 = (readUnsignedByte & 128) != 0;
            boolean z8 = (readUnsignedByte & 64) != 0;
            Object obj = (readUnsignedByte & 32) != 0 ? 1 : null;
            z4 = (readUnsignedByte & 16) != 0;
            if (z8 && !z4) {
                j3 = TimeSignalCommand.a(jVar, j);
            }
            if (!z8) {
                i = jVar.readUnsignedByte();
                emptyList = new ArrayList(i);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= i) {
                        break;
                    }
                    readUnsignedByte = jVar.readUnsignedByte();
                    j4 = -9223372036854775807L;
                    if (!z4) {
                        j4 = TimeSignalCommand.a(jVar, j);
                    }
                    emptyList.add(new a(readUnsignedByte, j4, qVar.T(j4), (byte) 0));
                    i4 = i5 + 1;
                }
            }
            if (obj != null) {
                j4 = (long) jVar.readUnsignedByte();
                z6 = (128 & j4) != 0;
                j4 = ((j4 & 1) << 32) | jVar.ba();
            } else {
                j4 = -9223372036854775807L;
                z6 = false;
            }
            i = jVar.readUnsignedShort();
            i2 = jVar.readUnsignedByte();
            i3 = jVar.readUnsignedByte();
            j2 = j4;
            z5 = z6;
            z3 = z8;
            z2 = z7;
        }
        return new SpliceInsertCommand(ba, z, z2, z3, z4, j3, qVar.T(j3), emptyList, z5, j2, i, i2, i3);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.ara);
        parcel.writeByte((byte) (this.arb ? 1 : 0));
        if (this.arc) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.ard) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.are) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.arf);
        parcel.writeLong(this.arg);
        int size = this.arh.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = (a) this.arh.get(i4);
            parcel.writeInt(aVar.arn);
            parcel.writeLong(aVar.aro);
            parcel.writeLong(aVar.arp);
        }
        if (!this.ari) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.arj);
        parcel.writeInt(this.ark);
        parcel.writeInt(this.arl);
        parcel.writeInt(this.arm);
    }
}
