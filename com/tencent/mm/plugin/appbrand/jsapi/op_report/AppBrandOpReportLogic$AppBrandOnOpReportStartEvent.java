package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class AppBrandOpReportLogic$AppBrandOnOpReportStartEvent implements Parcelable {
    public static final Creator<AppBrandOpReportLogic$AppBrandOnOpReportStartEvent> CREATOR = new 1();
    String appId;

    public static void tV(String str) {
        Parcelable appBrandOpReportLogic$AppBrandOnOpReportStartEvent = new AppBrandOpReportLogic$AppBrandOnOpReportStartEvent();
        appBrandOpReportLogic$AppBrandOnOpReportStartEvent.appId = str;
        d.c(appBrandOpReportLogic$AppBrandOnOpReportStartEvent);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }

    AppBrandOpReportLogic$AppBrandOnOpReportStartEvent() {
    }

    AppBrandOpReportLogic$AppBrandOnOpReportStartEvent(Parcel parcel) {
        this.appId = parcel.readString();
    }
}
