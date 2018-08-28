package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Creator<SpliceScheduleCommand> CREATOR = new 1();
    public final List<b> arq;

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, byte b) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<b> list) {
        this.arq = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new b(parcel));
        }
        this.arq = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand c(j jVar) {
        int readUnsignedByte = jVar.readUnsignedByte();
        List arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(b.d(jVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.arq.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            b bVar = (b) this.arq.get(i2);
            parcel.writeLong(bVar.ara);
            parcel.writeByte((byte) (bVar.arb ? 1 : 0));
            parcel.writeByte((byte) (bVar.arc ? 1 : 0));
            parcel.writeByte((byte) (bVar.ard ? 1 : 0));
            int size2 = bVar.arh.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a aVar = (a) bVar.arh.get(i4);
                parcel.writeInt(aVar.arn);
                parcel.writeLong(aVar.arr);
            }
            parcel.writeLong(bVar.arr);
            if (bVar.ari) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeLong(bVar.arj);
            parcel.writeInt(bVar.ark);
            parcel.writeInt(bVar.arl);
            parcel.writeInt(bVar.arm);
        }
    }
}
