package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public interface WxaWidgetContext extends Parcelable {
    WxaPkgWrappingInfo aeW();

    WxaPkgWrappingInfo aeX();

    int aeY();

    int aeZ();

    byte[] afa();

    int afb();

    DebuggerInfo afc();

    WidgetSysConfig afd();

    WidgetRuntimeConfig afe();

    String getAppId();

    String getId();
}
