package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.PointF;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    static final int qaZ = (a.bB() * a.bB());
    boolean mIsShowing;
    int mScreenHeight;
    int mScreenWidth;
    a qba;
    final b qbb;
    boolean qbc;
    PointF qbd = new PointF();
    boolean qbe;
    boolean qbf;

    public a(b bVar) {
        this.qbb = bVar;
        WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 85;
        layoutParams.width = a.KD();
        layoutParams.height = a.KD();
        layoutParams.x = 0;
        layoutParams.y = 0;
        this.qba = new a(ad.getContext());
        try {
            this.qba.setVisibility(8);
            windowManager.addView(this.qba, layoutParams);
        } catch (Exception e) {
            x.e("MicroMsg.BagCancelController", "showCanceller add failed %s", new Object[]{e});
        }
    }
}
