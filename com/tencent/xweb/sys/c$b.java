package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.xweb.j.a;

public class c$b extends a {
    public FileChooserParams vCM;

    public c$b(FileChooserParams fileChooserParams) {
        this.vCM = fileChooserParams;
    }

    @TargetApi(21)
    public final int getMode() {
        if (this.vCM != null) {
            return this.vCM.getMode();
        }
        return 0;
    }

    @TargetApi(21)
    public final String[] getAcceptTypes() {
        if (this.vCM != null) {
            return this.vCM.getAcceptTypes();
        }
        return new String[0];
    }

    @TargetApi(21)
    public final boolean isCaptureEnabled() {
        if (this.vCM != null) {
            return this.vCM.isCaptureEnabled();
        }
        return false;
    }
}
