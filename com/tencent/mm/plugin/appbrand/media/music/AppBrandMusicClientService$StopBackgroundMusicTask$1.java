package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;

class AppBrandMusicClientService$StopBackgroundMusicTask$1 implements Creator<StopBackgroundMusicTask> {
    AppBrandMusicClientService$StopBackgroundMusicTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new StopBackgroundMusicTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new StopBackgroundMusicTask[i];
    }
}
