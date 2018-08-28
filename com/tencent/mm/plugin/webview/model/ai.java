package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.x;

public final class ai {
    public static ai pRX = new ai();
    public boolean hasInit;
    public e pRY = null;

    private ai() {
    }

    public static ai bUm() {
        return pRX;
    }

    public final void setNetWorkState(int i) {
        String str = "MicroMsg.WebViewVideoProxy";
        String str2 = "set networkd state = %d, callbacker == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.pRY == null);
        x.i(str, str2, objArr);
        if (this.pRY != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_video_proxy_net_state", i);
            try {
                this.pRY.g(5005, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewVideoProxy", "set network state failed : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
