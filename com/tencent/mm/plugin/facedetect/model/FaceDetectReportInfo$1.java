package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FaceDetectReportInfo$1 implements Creator<FaceDetectReportInfo> {
    FaceDetectReportInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FaceDetectReportInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FaceDetectReportInfo[i];
    }
}
