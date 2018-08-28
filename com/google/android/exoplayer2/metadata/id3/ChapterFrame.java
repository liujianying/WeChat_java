package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Creator<ChapterFrame> CREATOR = new 1();
    public final String aqG;
    public final int aqH;
    public final int aqI;
    public final long aqJ;
    public final long aqK;
    private final Id3Frame[] aqL;

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.aqG = str;
        this.aqH = i;
        this.aqI = i2;
        this.aqJ = j;
        this.aqK = j2;
        this.aqL = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.aqG = parcel.readString();
        this.aqH = parcel.readInt();
        this.aqI = parcel.readInt();
        this.aqJ = parcel.readLong();
        this.aqK = parcel.readLong();
        int readInt = parcel.readInt();
        this.aqL = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.aqL[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.aqH == chapterFrame.aqH && this.aqI == chapterFrame.aqI && this.aqJ == chapterFrame.aqJ && this.aqK == chapterFrame.aqK && t.i(this.aqG, chapterFrame.aqG) && Arrays.equals(this.aqL, chapterFrame.aqL)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.aqG != null ? this.aqG.hashCode() : 0) + ((((((((this.aqH + 527) * 31) + this.aqI) * 31) + ((int) this.aqJ)) * 31) + ((int) this.aqK)) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqG);
        parcel.writeInt(this.aqH);
        parcel.writeInt(this.aqI);
        parcel.writeLong(this.aqJ);
        parcel.writeLong(this.aqK);
        parcel.writeInt(this.aqL.length);
        for (Parcelable writeParcelable : this.aqL) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int describeContents() {
        return 0;
    }
}
