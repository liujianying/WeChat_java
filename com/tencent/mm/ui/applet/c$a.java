package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;

public final class c$a {
    private ImageView bRk;
    private View mView;
    FrameLayout trF;
    WindowManager trG;
    LayoutParams trH;
    private ViewGroup.LayoutParams trI;

    public c$a(Context context, View view) {
        if (this.trF == null || this.trG == null) {
            view.findViewById(R.h.myLoadingProgress).setVisibility(8);
            this.bRk = (ImageView) view.findViewById(R.h.button);
            ((ImageView) view.findViewById(R.h.deletebutton)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    c$a.this.crb();
                }
            });
            this.trH = new LayoutParams();
            this.trH.height = -2;
            this.trH.width = -2;
            this.trG = (WindowManager) context.getSystemService("window");
            this.trH.x = 0;
            this.trH.y = 0;
            this.trH.flags = 40;
            this.trH.type = 2002;
            this.mView = view;
            this.trH.gravity = 51;
            this.trH.format = 1;
            this.trF = new FrameLayout(context);
            this.trF.setPadding(4, 4, 4, 4);
            this.trI = new ViewGroup.LayoutParams(-2, -2);
            this.trF.addView(this.mView, this.trI);
            this.trF.setOnTouchListener(new 2(this, context.getResources().getDisplayMetrics()));
        }
    }

    public final void crb() {
        try {
            if (this.trG != null) {
                if (this.trF != null) {
                    this.trG.removeView(this.trF);
                }
                this.trG = null;
            }
            if (this.trF != null) {
                this.trF.removeAllViews();
                this.trF = null;
            }
            this.mView = null;
        } catch (Exception e) {
        }
    }
}
