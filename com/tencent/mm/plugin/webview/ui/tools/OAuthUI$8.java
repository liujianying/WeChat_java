package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

class OAuthUI$8 implements a {
    final /* synthetic */ String jJR;
    final /* synthetic */ OAuthUI pVZ;
    final /* synthetic */ View pWa;
    final /* synthetic */ ThreeDotsLoadingView pWb;

    OAuthUI$8(OAuthUI oAuthUI, String str, View view, ThreeDotsLoadingView threeDotsLoadingView) {
        this.pVZ = oAuthUI;
        this.jJR = str;
        this.pWa = view;
        this.pWb = threeDotsLoadingView;
    }

    public final boolean vD() {
        OAuthUI.a(this.pVZ, this.jJR);
        this.pWa.setVisibility(8);
        this.pWb.cAH();
        return false;
    }
}
