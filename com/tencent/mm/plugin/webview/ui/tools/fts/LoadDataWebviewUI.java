package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI extends PreLoadWebViewUI {
    private CountDownLatch qeI = new CountDownLatch(1);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void ant() {
        super.ant();
        this.qeI.countDown();
    }
}
