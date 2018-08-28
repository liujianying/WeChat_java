package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.j.a;

public class g$d extends a {
    public FileChooserParams vDC;

    public g$d(FileChooserParams fileChooserParams) {
        this.vDC = fileChooserParams;
    }

    public final int getMode() {
        if (this.vDC != null) {
            return this.vDC.getMode();
        }
        return 0;
    }

    public final String[] getAcceptTypes() {
        if (this.vDC != null) {
            return this.vDC.getAcceptTypes();
        }
        return new String[0];
    }

    public final boolean isCaptureEnabled() {
        if (this.vDC != null) {
            return this.vDC.isCaptureEnabled();
        }
        return false;
    }
}
