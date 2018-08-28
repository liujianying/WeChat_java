package com.tencent.mm.plugin.gwallet.a;

import com.tencent.mm.plugin.game.f$k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

public final class c {
    public int kjf;
    String kjg;

    public c(int i, String str) {
        this.kjf = i;
        if (str == null || str.trim().length() == 0) {
            this.kjg = b.rg(i);
        } else {
            this.kjg = str + " (response: " + b.rg(i) + ")";
        }
    }

    public final int aVR() {
        switch (this.kjf) {
            case -2001:
            case -1004:
                return 3;
            case -1009:
            case -1002:
            case -1001:
            case DownloadResult.CODE_UNDEFINED /*-1000*/:
            case 2:
            case 3:
            case 4:
            case 6:
                return 5;
            case 0:
                return 0;
            case 1:
                return 1;
            case 5:
                return 6;
            case 7:
                return 100000002;
            case 8:
                return f$k.AppCompatTheme_ratingBarStyle;
            default:
                return this.kjf;
        }
    }

    public final boolean isSuccess() {
        return this.kjf == 0;
    }

    public final String toString() {
        return "IapResult: " + this.kjg;
    }
}
