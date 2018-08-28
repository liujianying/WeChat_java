package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Creator<ChapterTocFrame> CREATOR = new Creator<ChapterTocFrame>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    };
    private final Id3Frame[] aqL;
    public final String aqM;
    public final boolean aqN;
    public final boolean aqO;
    public final String[] aqP;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.aqM = str;
        this.aqN = z;
        this.aqO = z2;
        this.aqP = strArr;
        this.aqL = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        boolean z = true;
        int i = 0;
        super("CTOC");
        this.aqM = parcel.readString();
        this.aqN = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.aqO = z;
        this.aqP = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.aqL = new Id3Frame[readInt];
        while (i < readInt) {
            this.aqL[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.aqN == chapterTocFrame.aqN && this.aqO == chapterTocFrame.aqO && t.i(this.aqM, chapterTocFrame.aqM) && Arrays.equals(this.aqP, chapterTocFrame.aqP) && Arrays.equals(this.aqL, chapterTocFrame.aqL)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.aqN) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + 527) * 31;
        if (!this.aqO) {
            i2 = 0;
        }
        i = (i + i2) * 31;
        if (this.aqM != null) {
            i3 = this.aqM.hashCode();
        }
        return i + i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.aqM);
        if (this.aqN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.aqO) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeStringArray(this.aqP);
        parcel.writeInt(this.aqL.length);
        for (Parcelable writeParcelable : this.aqL) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
