package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper implements OnPrimaryClipChangedListener {
    private long lastReportTime = 0;
    private WebViewUI pUu;
    public ClipboardManager pUv;

    public WebViewClipBoardHelper(WebViewUI webViewUI) {
        this.pUu = webViewUI;
        this.pUv = (ClipboardManager) this.pUu.getSystemService("clipboard");
        try {
            this.pUv.addPrimaryClipChangedListener(this);
        } catch (Exception e) {
        }
    }

    public final void onPrimaryClipChanged() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime >= 200) {
            this.lastReportTime = currentTimeMillis;
            ClipData primaryClip = this.pUv.getPrimaryClip();
            if (primaryClip != null) {
                Item itemAt = primaryClip.getItemAt(0);
                if (itemAt != null) {
                    ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper();
                    clipBoardDataWrapper.url = this.pUu.getCurrentURL();
                    if (bi.K(itemAt.getText())) {
                        x.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
                        return;
                    }
                    clipBoardDataWrapper.length = itemAt.getText().toString().getBytes(Charset.forName("UTF-8")).length;
                    XIPCInvoker.a("com.tencent.mm", clipBoardDataWrapper, a.class, null);
                }
            }
        }
    }
}
