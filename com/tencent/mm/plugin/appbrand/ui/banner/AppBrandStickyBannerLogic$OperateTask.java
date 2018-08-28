package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;

final class AppBrandStickyBannerLogic$OperateTask extends MainProcessTask {
    public static final Creator<AppBrandStickyBannerLogic$OperateTask> CREATOR = new 1();
    String fVF;
    boolean gyg;
    int gyh;
    String gyi;
    int op = 0;

    AppBrandStickyBannerLogic$OperateTask() {
    }

    public final void aai() {
        switch (this.op) {
            case 1:
                this.gyg = b.anT();
                ahH();
                return;
            case 2:
                b.b(this);
                return;
            case 3:
                b.anX();
                return;
            default:
                return;
        }
    }

    static AppBrandStickyBannerLogic$OperateTask q(String str, int i, String str2) {
        AppBrandStickyBannerLogic$OperateTask appBrandStickyBannerLogic$OperateTask = new AppBrandStickyBannerLogic$OperateTask();
        appBrandStickyBannerLogic$OperateTask.op = 2;
        appBrandStickyBannerLogic$OperateTask.fVF = str;
        appBrandStickyBannerLogic$OperateTask.gyh = i;
        appBrandStickyBannerLogic$OperateTask.gyi = str2;
        return appBrandStickyBannerLogic$OperateTask;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.op);
        parcel.writeByte(this.gyg ? (byte) 1 : (byte) 0);
        parcel.writeString(this.fVF);
        parcel.writeInt(this.gyh);
        parcel.writeString(this.gyi);
    }

    public final void g(Parcel parcel) {
        this.op = parcel.readInt();
        this.gyg = parcel.readByte() != (byte) 0;
        this.fVF = parcel.readString();
        this.gyh = parcel.readInt();
        this.gyi = parcel.readString();
    }
}
