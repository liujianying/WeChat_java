package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b;

final class AppBrandOpReportLogic$ReportTask extends MainProcessTask {
    public static final Creator<AppBrandOpReportLogic$ReportTask> CREATOR = new 1();
    String appId;
    String bGH;
    int cbB;
    int cbu;
    int fKP;
    String fWF;
    int fmv;
    int scene;
    String username;

    public final void aai() {
        b.a(this);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeInt(this.fmv);
        parcel.writeInt(this.cbu);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.cbB);
        parcel.writeString(this.bGH);
        parcel.writeInt(this.fKP);
        parcel.writeString(this.fWF);
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.fmv = parcel.readInt();
        this.cbu = parcel.readInt();
        this.scene = parcel.readInt();
        this.cbB = parcel.readInt();
        this.bGH = parcel.readString();
        this.fKP = parcel.readInt();
        this.fWF = parcel.readString();
    }

    AppBrandOpReportLogic$ReportTask() {
    }

    AppBrandOpReportLogic$ReportTask(Parcel parcel) {
        g(parcel);
    }
}
