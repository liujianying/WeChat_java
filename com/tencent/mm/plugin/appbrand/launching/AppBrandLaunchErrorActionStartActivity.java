package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.bg.d;

final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String geE;
    final String geF;
    final Intent geG;

    AppBrandLaunchErrorActionStartActivity(String str, int i, String str2, String str3, Intent intent) {
        super(str, i);
        this.geE = str2;
        this.geF = str3;
        this.geG = intent;
    }

    @Keep
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        this.geE = parcel.readString();
        this.geF = parcel.readString();
        this.geG = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.geE);
        parcel.writeString(this.geF);
        parcel.writeParcelable(this.geG, 0);
    }

    final void cE(Context context) {
        Intent intent = this.geG;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(268435456);
        }
        d.b(context, this.geE, this.geF, intent);
    }
}
