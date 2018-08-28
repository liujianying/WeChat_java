package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.TbsListener;

class e$a implements TbsListener {
    h vEa;

    public e$a(h hVar) {
        this.vEa = hVar;
    }

    public final void onDownloadFinish(int i) {
        if (this.vEa != null) {
            this.vEa.onDownloadFinish(i);
        }
    }

    public final void onInstallFinish(int i) {
        if (this.vEa != null) {
            this.vEa.onInstallFinish(i);
        }
    }

    public final void onDownloadProgress(int i) {
        if (this.vEa != null) {
            this.vEa.onDownloadProgress(i);
        }
    }
}
