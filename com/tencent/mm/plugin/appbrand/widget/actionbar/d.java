package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.e;

public final class d extends PopupWindow {
    private WindowManager gFC;
    private View gFD;
    public FrameLayout gFE;
    private Context mContext = null;

    public d(Context context) {
        super(context);
        this.mContext = context;
        this.gFC = (WindowManager) context.getSystemService("window");
        this.gFE = new FrameLayout(this.mContext);
    }

    public final void showAsDropDown(View view) {
        IBinder windowToken = view.getWindowToken();
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.token = windowToken;
        this.gFD = new View(this.mContext);
        this.gFD.setBackgroundColor(2130706432);
        this.gFD.setFitsSystemWindows(false);
        this.gFD.setOnTouchListener(new 1(this));
        this.gFD.setOnKeyListener(new 2(this));
        this.gFC.addView(this.gFD, layoutParams);
        super.showAsDropDown(view);
    }

    public final void dismiss() {
        if (this.gFD != null) {
            this.gFC.removeViewImmediate(this.gFD);
            this.gFD = null;
        }
        super.dismiss();
    }

    public final void setContentView(View view) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = a.ae(this.mContext, e.app_brand_app_brand_popwindow_with_mask_topmargin);
        layoutParams.rightMargin = a.ae(this.mContext, e.app_brand_app_brand_popwindow_with_mask_margin);
        layoutParams.leftMargin = a.ae(this.mContext, e.app_brand_app_brand_popwindow_with_mask_margin);
        this.gFE.addView(view, layoutParams);
        super.setContentView(this.gFE);
    }
}
