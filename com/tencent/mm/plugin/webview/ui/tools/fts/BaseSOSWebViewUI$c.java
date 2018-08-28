package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.fts.ui.widget.a$b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

protected class BaseSOSWebViewUI$c {
    List<a$b> jzp;
    final /* synthetic */ BaseSOSWebViewUI qdp;
    String qdw = "";
    String qdx = "";
    Map<String, Object> qdy = new HashMap();
    int type;

    protected BaseSOSWebViewUI$c(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseSOSWebViewUI$c)) {
            return false;
        }
        BaseSOSWebViewUI$c baseSOSWebViewUI$c = (BaseSOSWebViewUI$c) obj;
        if (baseSOSWebViewUI$c.type == this.type && baseSOSWebViewUI$c.qdx.equals(this.qdx)) {
            return true;
        }
        return false;
    }
}
