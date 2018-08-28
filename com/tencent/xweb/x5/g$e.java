package com.tencent.xweb.x5;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

public class g$e implements Callback {
    GeolocationPermissionsCallback vDD;

    public g$e(GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.vDD = geolocationPermissionsCallback;
    }

    public final void invoke(String str, boolean z, boolean z2) {
        if (this.vDD != null) {
            this.vDD.invoke(str, z, z2);
        }
    }
}
