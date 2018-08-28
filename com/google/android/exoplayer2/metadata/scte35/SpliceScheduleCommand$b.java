package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$b {
    public final long ara;
    public final boolean arb;
    public final boolean arc;
    public final boolean ard;
    public final List<a> arh;
    public final boolean ari;
    public final long arj;
    public final int ark;
    public final int arl;
    public final int arm;
    public final long arr;

    private SpliceScheduleCommand$b(long j, boolean z, boolean z2, boolean z3, List<a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
        this.ara = j;
        this.arb = z;
        this.arc = z2;
        this.ard = z3;
        this.arh = Collections.unmodifiableList(list);
        this.arr = j2;
        this.ari = z4;
        this.arj = j3;
        this.ark = i;
        this.arl = i2;
        this.arm = i3;
    }

    SpliceScheduleCommand$b(Parcel parcel) {
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
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new a(parcel.readInt(), parcel.readLong()));
        }
        this.arh = Collections.unmodifiableList(arrayList);
        this.arr = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.ari = z2;
        this.arj = parcel.readLong();
        this.ark = parcel.readInt();
        this.arl = parcel.readInt();
        this.arm = parcel.readInt();
    }

    static SpliceScheduleCommand$b d(j jVar) {
        long j;
        long ba = jVar.ba();
        boolean z = (jVar.readUnsignedByte() & 128) != 0;
        boolean z2 = false;
        boolean z3 = false;
        long j2 = -9223372036854775807L;
        List arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z4 = false;
        if (z) {
            j = -9223372036854775807L;
        } else {
            Object obj;
            ArrayList arrayList2;
            long ba2;
            int readUnsignedByte = jVar.readUnsignedByte();
            z2 = (readUnsignedByte & 128) != 0;
            boolean z5 = (readUnsignedByte & 64) != 0;
            if ((readUnsignedByte & 32) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (z5) {
                j2 = jVar.ba();
            }
            if (z5) {
                arrayList2 = arrayList;
            } else {
                int readUnsignedByte2 = jVar.readUnsignedByte();
                ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                for (readUnsignedByte = 0; readUnsignedByte < readUnsignedByte2; readUnsignedByte++) {
                    arrayList3.add(new a(jVar.readUnsignedByte(), jVar.ba(), (byte) 0));
                }
            }
            if (obj != null) {
                long readUnsignedByte3 = (long) jVar.readUnsignedByte();
                ba2 = ((readUnsignedByte3 & 1) << 32) | jVar.ba();
                z4 = (128 & readUnsignedByte3) != 0;
            } else {
                ba2 = -9223372036854775807L;
            }
            i = jVar.readUnsignedShort();
            i2 = jVar.readUnsignedByte();
            i3 = jVar.readUnsignedByte();
            j = ba2;
            arrayList = arrayList2;
            z3 = z5;
        }
        return new SpliceScheduleCommand$b(ba, z, z2, z3, arrayList, j2, z4, j, i, i2, i3);
    }
}
