package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String eHA;
    final String eHz;

    AppBrandLaunchErrorActionAlert(String str, int i, String str2, String str3) {
        super(str, i);
        this.eHz = str2;
        this.eHA = str3;
    }

    @Keep
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        this.eHz = parcel.readString();
        this.eHA = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.eHz);
        parcel.writeString(this.eHA);
    }

    final void cE(Context context) {
        String str = this.eHA;
        String str2 = this.eHz;
        if (context instanceof Activity) {
            h.a(context, str, str2, false, null);
        } else {
            a.a(null, str, str2, ad.getResources().getString(j.app_ok), "", null, null, null);
        }
    }
}
