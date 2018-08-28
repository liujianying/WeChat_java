package com.tencent.xweb.xwalk;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.xweb.f;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;

public final class e {

    public static class b implements Callback {
        XWalkGeolocationPermissionsCallback vEN;

        public b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.vEN = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            if (this.vEN != null) {
                this.vEN.invoke(str, z, z2);
            }
        }
    }

    public static class c extends f {
        public XWalkJavascriptResult vEO;

        public c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.vEO = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.vEO.confirmWithResult(str);
        }

        public final void confirm() {
            this.vEO.confirm();
        }

        public final void cancel() {
            this.vEO.cancel();
        }
    }

    public static class d extends com.tencent.xweb.e {
        public XWalkJavascriptResult vEO;

        public d(XWalkJavascriptResult xWalkJavascriptResult) {
            this.vEO = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.vEO.confirmWithResult(str);
        }

        public final void confirm() {
            this.vEO.confirm();
        }

        public final void cancel() {
            this.vEO.cancel();
        }
    }
}
