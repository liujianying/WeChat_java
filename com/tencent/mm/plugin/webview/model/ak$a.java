package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public class ak$a {
    public Bundle jfZ = null;
    final /* synthetic */ ak pSn;

    public ak$a(ak akVar, Bundle bundle) {
        this.pSn = akVar;
        this.jfZ = bundle;
    }

    public final void putValue(String str, Object obj) {
        if (this.jfZ == null) {
            return;
        }
        if (obj instanceof String) {
            this.jfZ.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            this.jfZ.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            this.jfZ.putInt(str, ((Integer) obj).intValue());
        } else {
            x.w("MicroMsg.WebviewReporter", "put unknow type value.");
        }
    }
}
