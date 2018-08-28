package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;

class ILaunchWxaAppInfoNotify$1 implements ILaunchWxaAppInfoNotify {
    ILaunchWxaAppInfoNotify$1() {
    }

    public final void a(String str, int i, String str2, t tVar) {
        d ul = d.ul(str2);
        if (ul != null) {
            ul.a(str, i, str2, tVar);
            return;
        }
        LaunchInfoIpcWrapper launchInfoIpcWrapper = new LaunchInfoIpcWrapper();
        launchInfoIpcWrapper.appId = str;
        launchInfoIpcWrapper.fmv = i;
        launchInfoIpcWrapper.fqP = new AppRuntimeApiPermissionBundle(tVar.field_jsapiInfo);
        a aVar = AppBrandLaunchErrorAction.CREATOR;
        launchInfoIpcWrapper.gfJ = a.a(str, i, tVar);
        d.c(launchInfoIpcWrapper);
    }
}
