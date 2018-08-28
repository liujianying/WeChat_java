package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class FaceDetectReportInfo implements Parcelable {
    public static final Creator<FaceDetectReportInfo> CREATOR = new 1();
    protected int bDv = 0;
    protected int iMg = 0;
    protected long iNJ = 0;
    protected int iNK = 0;
    protected int iNL = 0;
    protected int iNM = 0;
    protected int iNN = 0;
    protected int iNO = 0;
    protected int iNP = 0;
    protected int iNQ = 0;
    protected int iNR = 0;
    protected int iNS = 0;
    protected int iNT = 0;
    protected int iNU = 0;
    protected int iNV = 0;
    protected int iNW = 0;
    protected int iNX = 0;
    protected int iNY = 0;
    protected int iNZ = 0;
    protected int iOa = 0;
    protected HashMap<Integer, Long> iOb = new HashMap();
    protected HashMap<Integer, Long> iOc = new HashMap();

    protected FaceDetectReportInfo(Parcel parcel) {
        this.iNJ = parcel.readLong();
        this.iNK = parcel.readInt();
        this.iNL = parcel.readInt();
        this.iNM = parcel.readInt();
        this.iNN = parcel.readInt();
        this.iNO = parcel.readInt();
        this.iNP = parcel.readInt();
        this.iNQ = parcel.readInt();
        this.iNR = parcel.readInt();
        this.iNS = parcel.readInt();
        this.iNT = parcel.readInt();
        this.iNU = parcel.readInt();
        this.iNV = parcel.readInt();
        this.iNW = parcel.readInt();
        this.iNX = parcel.readInt();
        this.iNY = parcel.readInt();
        this.bDv = parcel.readInt();
        this.iMg = parcel.readInt();
        this.iNZ = parcel.readInt();
        this.iOa = parcel.readInt();
        try {
            this.iOb = parcel.readHashMap(HashMap.class.getClassLoader());
            this.iOc = parcel.readHashMap(HashMap.class.getClassLoader());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.iNJ);
        parcel.writeInt(this.iNK);
        parcel.writeInt(this.iNL);
        parcel.writeInt(this.iNM);
        parcel.writeInt(this.iNN);
        parcel.writeInt(this.iNO);
        parcel.writeInt(this.iNP);
        parcel.writeInt(this.iNQ);
        parcel.writeInt(this.iNR);
        parcel.writeInt(this.iNS);
        parcel.writeInt(this.iNT);
        parcel.writeInt(this.iNU);
        parcel.writeInt(this.iNV);
        parcel.writeInt(this.iNW);
        parcel.writeInt(this.iNX);
        parcel.writeInt(this.iNY);
        parcel.writeInt(this.bDv);
        parcel.writeInt(this.iMg);
        parcel.writeInt(this.iNZ);
        parcel.writeInt(this.iOa);
        parcel.writeMap(this.iOb);
        parcel.writeMap(this.iOc);
    }

    public int describeContents() {
        return 0;
    }

    public final void pv(int i) {
        if (i > 0) {
            if (i == 1) {
                this.iNL++;
            } else if (i == 2) {
                this.iNM++;
            } else {
                this.iNL++;
            }
        } else if (i == 0) {
            this.iNN++;
        } else if (i == -11) {
            this.iNP++;
        } else if (i == -12) {
            this.iNQ++;
        } else if (i == -13) {
            this.iNR++;
        } else if (i == -101) {
            this.iNV++;
        } else if (i == -102) {
            this.iNS++;
        } else if (i == -103) {
            this.iNT++;
        } else if (i == -105) {
            this.iNU++;
        } else if (i == -106) {
            this.iNO++;
        } else if (i == -107) {
            this.iNW++;
        } else if (i == -108) {
            this.iNX++;
        } else if (i == -109) {
            this.iNY++;
        } else {
            this.iNK++;
        }
    }

    public final void reset() {
        this.iNJ = 0;
        this.iNL = 0;
        this.iNM = 0;
        this.iNN = 0;
        this.iNK = 0;
        this.iNO = 0;
        this.iNP = 0;
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = 0;
        this.iNU = 0;
        this.iNV = 0;
        this.iNW = 0;
        this.bDv = 0;
        this.iMg = 0;
        this.iNZ = 0;
        this.iOa = 0;
        this.iOb.clear();
        this.iOc.clear();
    }

    public String toString() {
        return "detectOk: " + this.iNL + ", motionOk: " + this.iNM + ", noFace: " + this.iNN + ", systemErr: " + this.iNK + ", noLiveFace: " + this.iNO + ", tooDark: " + this.iNP + ", tooLight: " + this.iNQ + ", backLight: " + this.iNR + ", tooSmall: " + this.iNS + ", tooBig: " + this.iNT + ", tooActive: " + this.iNU + ", poseNotValid: " + this.iNV + ", timeOut: " + this.iNW + ", totalFrame: " + this.bDv + ", verifyTime: " + this.iMg + ", processTimePerFrame: " + this.iOa;
    }
}
