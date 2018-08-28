package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

final class AppBrandStickyBannerLogic$Watcher extends MainProcessTask {
    public static final Creator<AppBrandStickyBannerLogic$Watcher> CREATOR = new 2();
    private static final transient Map<String, f> gym = new HashMap();
    String gyj;
    String gyk;
    int gyl;

    public final void aai() {
        if (!bi.oW(this.gyj)) {
            synchronized (gym) {
                if (gym.containsKey(this.gyj)) {
                    b.c((f) gym.get(this.gyj));
                }
                1 1 = new 1(this);
                b.d(1);
                gym.put(this.gyj, 1);
            }
        }
    }

    public final void aaj() {
        a.aP(this.gyk, this.gyl);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gyj);
        parcel.writeString(this.gyk);
        parcel.writeInt(this.gyl);
    }

    public final void g(Parcel parcel) {
        this.gyj = parcel.readString();
        this.gyk = parcel.readString();
        this.gyl = parcel.readInt();
    }

    AppBrandStickyBannerLogic$Watcher() {
    }
}
