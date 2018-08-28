package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.b;

abstract class a implements g {
    protected abstract boolean a(Context context, LaunchParcel launchParcel);

    a() {
    }

    public final boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        if (bi.oW(str) && bi.oW(str2)) {
            return false;
        }
        LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = str;
        launchParcel.appId = str2;
        launchParcel.fqx = str3 == null ? null : str3.trim();
        launchParcel.fmv = i;
        launchParcel.version = i2;
        launchParcel.ghm = appBrandStatObject;
        launchParcel.fqA = appBrandLaunchReferrer;
        launchParcel.ghn = launchParamsOptional;
        if (context == null) {
            context = ad.getContext();
        } else if (context instanceof Activity) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(new int[]{16842840});
                if (!typedArray.getBoolean(0, false)) {
                    b.Y((Activity) context);
                }
                if (typedArray != null) {
                    typedArray.recycle();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", e, "convertActivityFromTranslucent %s", new Object[]{context.getClass().getSimpleName()});
                if (typedArray != null) {
                    typedArray.recycle();
                }
            } catch (Throwable th) {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
        return a(context, launchParcel);
    }
}
