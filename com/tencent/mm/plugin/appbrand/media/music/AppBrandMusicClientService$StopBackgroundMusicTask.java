package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.an.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMusicClientService$StopBackgroundMusicTask extends MainProcessTask {
    public static final Creator<AppBrandMusicClientService$StopBackgroundMusicTask> CREATOR = new 1();
    public String appId;

    public AppBrandMusicClientService$StopBackgroundMusicTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
        String str = a.ala().ghU;
        if (!bi.oW(str) && !str.equals(this.appId)) {
            x.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            ahH();
        } else if (a.ala().uu(this.appId)) {
            if (c.Qe()) {
                x.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
            } else {
                x.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
            }
            ahH();
        } else {
            x.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            ahH();
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }
}
