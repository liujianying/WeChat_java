package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new 1();
    public final String adT;
    public final Metadata adU;
    public final String adV;
    public final String adW;
    public final int adX;
    public final List<byte[]> adY;
    public final DrmInitData adZ;
    public final float aea;
    public final int aeb;
    public final float aec;
    public final int aed;
    public final byte[] aee;
    public final ColorInfo aef;
    public final int aeg;
    public final int aeh;
    public final int aei;
    public final int aej;
    public final long aek;
    public final int ael;
    public final String aem;
    public final int aen;
    private int aeo;
    public final int bitrate;
    public final int height;
    public final String id;
    public final int sampleRate;
    public final int width;

    public static Format a(String str, String str2, String str3, int i, int i2, int i3) {
        return new Format(str, str2, null, str3, i, -1, i2, i3, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format a(String str, String str2, int i, int i2, List<byte[]> list, float f) {
        return a(str, str2, i, i2, (List) list, -1, f, null, -1, null);
    }

    public static Format a(String str, String str2, int i, int i2, List<byte[]> list, int i3, float f, byte[] bArr, int i4, DrmInitData drmInitData) {
        return new Format(str, null, str2, null, -1, -1, i, i2, -1.0f, i3, f, bArr, i4, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format b(String str, String str2, int i, String str3) {
        return new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, String str3) {
        return a(str, str2, i, i2, i3, i4, -1, (List) list, drmInitData, str3);
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, String str3) {
        return a(str, str2, i, i2, i3, i4, i5, -1, -1, list, drmInitData, str3, null);
    }

    public static Format a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, String str3, Metadata metadata) {
        return new Format(str, null, str2, null, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, 0, str3, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format a(String str, String str2, String str3, int i, String str4) {
        return a(str, str2, str3, i, str4, -1);
    }

    public static Format a(String str, String str2, String str3, int i, String str4, int i2) {
        return new Format(str, str2, str3, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str4, i2, Long.MAX_VALUE, null, null, null);
    }

    public static Format af(String str) {
        return a(null, str, 0, null, -1, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, int i, String str3, int i2) {
        return a(str, str2, i, str3, i2, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format a(String str, String str2, long j) {
        return a(null, str, 0, str2, -1, j, Collections.emptyList());
    }

    public static Format a(String str, String str2, int i, String str3, int i2, long j, List<byte[]> list) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i, str3, i2, j, list, null, null);
    }

    public static Format a(String str, String str2, List<byte[]> list, String str3) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format g(String str, String str2) {
        return new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format b(String str, long j) {
        return new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    public static Format h(String str, String str2) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.id = str;
        this.adV = str2;
        this.adW = str3;
        this.adT = str4;
        this.bitrate = i;
        this.adX = i2;
        this.width = i3;
        this.height = i4;
        this.aea = f;
        this.aeb = i5;
        this.aec = f2;
        this.aee = bArr;
        this.aed = i6;
        this.aef = colorInfo;
        this.aeg = i7;
        this.sampleRate = i8;
        this.aeh = i9;
        this.aei = i10;
        this.aej = i11;
        this.ael = i12;
        this.aem = str5;
        this.aen = i13;
        this.aek = j;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.adY = list;
        this.adZ = drmInitData;
        this.adU = metadata;
    }

    Format(Parcel parcel) {
        this.id = parcel.readString();
        this.adV = parcel.readString();
        this.adW = parcel.readString();
        this.adT = parcel.readString();
        this.bitrate = parcel.readInt();
        this.adX = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.aea = parcel.readFloat();
        this.aeb = parcel.readInt();
        this.aec = parcel.readFloat();
        this.aee = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.aed = parcel.readInt();
        this.aef = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.aeg = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.aeh = parcel.readInt();
        this.aei = parcel.readInt();
        this.aej = parcel.readInt();
        this.ael = parcel.readInt();
        this.aem = parcel.readString();
        this.aen = parcel.readInt();
        this.aek = parcel.readLong();
        int readInt = parcel.readInt();
        this.adY = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.adY.add(parcel.createByteArray());
        }
        this.adZ = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.adU = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }

    public final Format u(long j) {
        return new Format(this.id, this.adV, this.adW, this.adT, this.bitrate, this.adX, this.width, this.height, this.aea, this.aeb, this.aec, this.aee, this.aed, this.aef, this.aeg, this.sampleRate, this.aeh, this.aei, this.aej, this.ael, this.aem, this.aen, j, this.adY, this.adZ, this.adU);
    }

    public final int iP() {
        return (this.width == -1 || this.height == -1) ? -1 : this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat iQ() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.adW);
        String str = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE;
        String str2 = this.aem;
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
        a(mediaFormat, "max-input-size", this.adX);
        a(mediaFormat, "width", this.width);
        a(mediaFormat, "height", this.height);
        str = "frame-rate";
        float f = this.aea;
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
        a(mediaFormat, "rotation-degrees", this.aeb);
        a(mediaFormat, "channel-count", this.aeg);
        a(mediaFormat, "sample-rate", this.sampleRate);
        a(mediaFormat, "encoder-delay", this.aei);
        a(mediaFormat, "encoder-padding", this.aej);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.adY.size()) {
                break;
            }
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap((byte[]) this.adY.get(i2)));
            i = i2 + 1;
        }
        ColorInfo colorInfo = this.aef;
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.aCP);
            a(mediaFormat, "color-standard", colorInfo.aCN);
            a(mediaFormat, "color-range", colorInfo.aCO);
            str2 = "hdr-static-info";
            byte[] bArr = colorInfo.aCQ;
            if (bArr != null) {
                mediaFormat.setByteBuffer(str2, ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        return "Format(" + this.id + ", " + this.adV + ", " + this.adW + ", " + this.bitrate + ", " + this.aem + ", [" + this.width + ", " + this.height + ", " + this.aea + "], [" + this.aeg + ", " + this.sampleRate + "])";
    }

    public final int hashCode() {
        int i = 0;
        if (this.aeo == 0) {
            int hashCode = ((this.adZ == null ? 0 : this.adZ.hashCode()) + (((((this.aem == null ? 0 : this.aem.hashCode()) + (((((((((((((this.adT == null ? 0 : this.adT.hashCode()) + (((this.adW == null ? 0 : this.adW.hashCode()) + (((this.adV == null ? 0 : this.adV.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.aeg) * 31) + this.sampleRate) * 31)) * 31) + this.aen) * 31)) * 31;
            if (this.adU != null) {
                i = this.adU.hashCode();
            }
            this.aeo = hashCode + i;
        }
        return this.aeo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.bitrate != format.bitrate || this.adX != format.adX || this.width != format.width || this.height != format.height || this.aea != format.aea || this.aeb != format.aeb || this.aec != format.aec || this.aed != format.aed || this.aeg != format.aeg || this.sampleRate != format.sampleRate || this.aeh != format.aeh || this.aei != format.aei || this.aej != format.aej || this.aek != format.aek || this.ael != format.ael || !t.i(this.id, format.id) || !t.i(this.aem, format.aem) || this.aen != format.aen || !t.i(this.adV, format.adV) || !t.i(this.adW, format.adW) || !t.i(this.adT, format.adT) || !t.i(this.adZ, format.adZ) || !t.i(this.adU, format.adU) || !t.i(this.aef, format.aef) || !Arrays.equals(this.aee, format.aee) || this.adY.size() != format.adY.size()) {
            return false;
        }
        for (int i = 0; i < this.adY.size(); i++) {
            if (!Arrays.equals((byte[]) this.adY.get(i), (byte[]) format.adY.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static String a(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append(format.id).append(", mimeType=").append(format.adW);
        if (format.bitrate != -1) {
            stringBuilder.append(", bitrate=").append(format.bitrate);
        }
        if (!(format.width == -1 || format.height == -1)) {
            stringBuilder.append(", res=").append(format.width).append("x").append(format.height);
        }
        if (format.aea != -1.0f) {
            stringBuilder.append(", fps=").append(format.aea);
        }
        if (format.aeg != -1) {
            stringBuilder.append(", channels=").append(format.aeg);
        }
        if (format.sampleRate != -1) {
            stringBuilder.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.aem != null) {
            stringBuilder.append(", language=").append(format.aem);
        }
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.adV);
        parcel.writeString(this.adW);
        parcel.writeString(this.adT);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.adX);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.aea);
        parcel.writeInt(this.aeb);
        parcel.writeFloat(this.aec);
        parcel.writeInt(this.aee != null ? 1 : 0);
        if (this.aee != null) {
            parcel.writeByteArray(this.aee);
        }
        parcel.writeInt(this.aed);
        parcel.writeParcelable(this.aef, i);
        parcel.writeInt(this.aeg);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.aeh);
        parcel.writeInt(this.aei);
        parcel.writeInt(this.aej);
        parcel.writeInt(this.ael);
        parcel.writeString(this.aem);
        parcel.writeInt(this.aen);
        parcel.writeLong(this.aek);
        int size = this.adY.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.adY.get(i2));
        }
        parcel.writeParcelable(this.adZ, 0);
        parcel.writeParcelable(this.adU, 0);
    }
}
