package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.fts.ui.widget.a.b;

public class FTSBaseWebViewUI$a implements b {
    final /* synthetic */ FTSBaseWebViewUI qdI;
    String qdu;
    int qdv;
    String userName;

    public FTSBaseWebViewUI$a(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final String getTagName() {
        return this.qdu;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof FTSBaseWebViewUI$a)) {
            return -1;
        }
        return this.qdu.compareTo(((FTSBaseWebViewUI$a) obj).qdu);
    }
}
