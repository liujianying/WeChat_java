package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectReporter implements Parcelable {
    public static final Creator<FaceDetectReporter> CREATOR = new Creator<FaceDetectReporter>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReporter(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReporter[i];
        }
    };
    public static FaceDetectReporter iOf = new FaceDetectReporter();
    String appId = "";
    public long iNJ = 0;
    public boolean iOd = false;
    private FaceDetectReportInfo iOe = null;
    long iOg = 0;
    long iOh = -1;
    public long iOi = -1;
    public int iOj = 0;
    public boolean iOk = false;

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        this.iNJ = parcel.readLong();
        this.iOd = parcel.readByte() != (byte) 0;
        this.iOe = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.iOg = parcel.readLong();
        this.iOh = parcel.readLong();
        this.iOi = parcel.readLong();
        this.iOj = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.iOk = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(this.iNJ);
        parcel.writeByte((byte) (this.iOd ? 1 : 0));
        parcel.writeParcelable(this.iOe, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.iOg);
        parcel.writeLong(this.iOh);
        parcel.writeLong(this.iOi);
        parcel.writeInt(this.iOj);
        if (!this.iOk) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter aJU() {
        if (iOf != null) {
            return iOf;
        }
        FaceDetectReporter faceDetectReporter;
        synchronized (FaceDetectReporter.class) {
            if (iOf == null) {
                iOf = new FaceDetectReporter();
            }
            faceDetectReporter = iOf;
        }
        return faceDetectReporter;
    }

    public static void e(long j, int i, int i2) {
        x.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
        h.mEJ.h(14121, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private FaceDetectReporter() {
    }

    public final long aJV() {
        x.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.iOe == null) {
            this.iOe = new FaceDetectReportInfo();
        }
        this.iOe.reset();
        this.iOd = false;
        this.iNJ = System.currentTimeMillis();
        this.iOe.iNJ = this.iNJ;
        return this.iNJ;
    }

    public final void a(FaceDetectReporter faceDetectReporter) {
        x.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[]{bi.cjd().toString()});
        this.iOe = faceDetectReporter.iOe;
        this.iOd = faceDetectReporter.iOd;
        this.iNJ = faceDetectReporter.iNJ;
        String str = "MicroMsg.FaceDetectReporter";
        String str2 = "alvinluo sessionId: %d, info: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.iNJ);
        objArr[1] = this.iOe != null ? this.iOe.toString() : "null";
        x.v(str, str2, objArr);
    }

    public final void I(int i, boolean z) {
        int i2 = 1;
        x.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(this.iNJ);
        if (!z) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        hVar.h(14005, objArr);
    }

    public static int pw(int i) {
        switch (i) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void a(int i, boolean z, int i2, int i3, int i4) {
        a(i, z, i2, i3, i4, 0);
    }

    public final void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        x.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[]{Long.valueOf(this.iNJ), Boolean.valueOf(this.iOd), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.iOe != null && !this.iOd) {
            int longValue;
            int longValue2;
            x.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[]{this.iOe.toString()});
            this.iOd = true;
            this.iOe.iMg = i5;
            if (this.iOe.bDv != 0) {
                this.iOe.iOa = this.iOe.iNZ / this.iOe.bDv;
            }
            if (this.iOe.iOb.containsKey(Integer.valueOf(0)) && this.iOe.iOc.containsKey(Integer.valueOf(0))) {
                longValue = (int) (((Long) this.iOe.iOc.get(Integer.valueOf(0))).longValue() - ((Long) this.iOe.iOb.get(Integer.valueOf(0))).longValue());
            } else {
                longValue = 0;
            }
            if (this.iOe.iOb.containsKey(Integer.valueOf(4)) && this.iOe.iOc.containsKey(Integer.valueOf(4))) {
                longValue2 = (int) (((Long) this.iOe.iOc.get(Integer.valueOf(4))).longValue() - ((Long) this.iOe.iOb.get(Integer.valueOf(4))).longValue());
            } else {
                longValue2 = 0;
            }
            x.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms", new Object[]{Integer.valueOf(longValue), Integer.valueOf(longValue2)});
            h hVar = h.mEJ;
            Object[] objArr = new Object[26];
            objArr[0] = Long.valueOf(this.iNJ);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = Integer.valueOf(this.iOe.iNL);
            objArr[7] = Integer.valueOf(this.iOe.iNM);
            objArr[8] = Integer.valueOf(this.iOe.iNN);
            objArr[9] = Integer.valueOf(this.iOe.iNK);
            objArr[10] = Integer.valueOf(this.iOe.iNO);
            objArr[11] = Integer.valueOf(this.iOe.iNP);
            objArr[12] = Integer.valueOf(this.iOe.iNQ);
            objArr[13] = Integer.valueOf(this.iOe.iNR);
            objArr[14] = Integer.valueOf(this.iOe.iNS);
            objArr[15] = Integer.valueOf(this.iOe.iNT);
            objArr[16] = Integer.valueOf(this.iOe.iNU);
            objArr[17] = Integer.valueOf(this.iOe.iNV);
            objArr[18] = Integer.valueOf(this.iOe.iNW);
            objArr[19] = Integer.valueOf(this.iOe.iMg);
            objArr[20] = Integer.valueOf(this.iOe.iNX);
            objArr[21] = Integer.valueOf(this.iOe.iNY);
            objArr[22] = Integer.valueOf(this.iOe.iOa);
            objArr[23] = Integer.valueOf(longValue);
            objArr[24] = Integer.valueOf(longValue2);
            objArr[25] = this.appId;
            hVar.h(14006, objArr);
        }
    }

    public final void bl(String str, int i) {
        long j = -1;
        int i2 = 1;
        if (this.iOh == -1 || this.iOi == -1 || this.iOi < this.iOh) {
            x.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[]{Long.valueOf(this.iOh), Long.valueOf(this.iOi)});
        } else {
            j = this.iOi - this.iOh;
        }
        x.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[]{Long.valueOf(this.iOg), str, Integer.valueOf(-1), Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(this.iOk), this.appId, Integer.valueOf(this.iOj)});
        h hVar = h.mEJ;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.iOg);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(-1);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.appId;
        if (!this.iOk) {
            i2 = 0;
        }
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Long.valueOf(j);
        objArr[7] = Integer.valueOf(this.iOj);
        hVar.h(14560, objArr);
    }

    public final void q(int i, long j) {
        if (this.iOe != null) {
            FaceDetectReportInfo faceDetectReportInfo = this.iOe;
            faceDetectReportInfo.bDv++;
            faceDetectReportInfo = this.iOe;
            faceDetectReportInfo.iNZ = (int) (((long) faceDetectReportInfo.iNZ) + j);
            this.iOe.pv(i);
        }
    }

    public final void r(int i, long j) {
        if (this.iOe != null) {
            this.iOe.iOb.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }

    public final void s(int i, long j) {
        if (this.iOe != null) {
            this.iOe.iOc.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }
}
