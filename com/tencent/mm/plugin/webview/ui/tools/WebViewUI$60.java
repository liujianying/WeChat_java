package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.z.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class WebViewUI$60 implements b {
    final /* synthetic */ WebViewUI pZJ;
    private Map<Integer, Integer> qaC = new HashMap();

    WebViewUI$60(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void add(int i) {
        WebViewUI.e(this.pZJ, i);
        if (this.qaC.containsKey(Integer.valueOf(i))) {
            this.qaC.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.qaC.get(Integer.valueOf(i))).intValue() + 1));
            return;
        }
        this.qaC.put(Integer.valueOf(i), Integer.valueOf(1));
    }

    public final void remove(int i) {
        WebViewUI.f(this.pZJ, i);
        if (this.qaC.containsKey(Integer.valueOf(i))) {
            this.qaC.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.qaC.get(Integer.valueOf(i))).intValue() - 1));
            return;
        }
        this.qaC.put(Integer.valueOf(i), Integer.valueOf(0));
    }

    public final boolean bUg() {
        for (Entry value : this.qaC.entrySet()) {
            if (((Integer) value.getValue()).intValue() > 0) {
                return true;
            }
        }
        return false;
    }
}
