package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.d;
import com.tencent.mm.bv.d.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

public final class d$a {
    ImageView bRk;
    ProgressBar bRm;
    Context context;
    TextView jWm;
    View mView;
    FrameLayout trF;
    WindowManager trG;
    LayoutParams trH;
    private ViewGroup.LayoutParams trI;
    boolean trZ = false;
    b tsa = new 1(this);
    com.tencent.mm.bv.d$a tsb;
    int tsc = 0;
    ag tsd = new 4(this);

    public d$a(Context context, View view) {
        if (this.trF == null || this.trG == null) {
            d.cov().tfI = new WeakReference(this.tsa);
            this.jWm = (TextView) view.findViewById(R.h.time);
            this.bRk = (ImageView) view.findViewById(R.h.button);
            ((ImageView) view.findViewById(R.h.deletebutton)).setOnClickListener(new 2(this));
            this.bRm = (ProgressBar) view.findViewById(R.h.myLoadingProgress);
            this.bRm.setVisibility(8);
            this.context = context;
            this.trH = new LayoutParams();
            this.trH.height = -2;
            this.trH.width = -2;
            this.trG = (WindowManager) context.getSystemService("window");
            this.trH.x = 0;
            this.trH.y = 0;
            this.trH.flags = 40;
            this.trH.type = 2002;
            this.mView = view;
            this.jWm.setVisibility(8);
            this.trH.gravity = 51;
            this.trH.format = 1;
            this.trF = new FrameLayout(context);
            this.trF.setPadding(4, 4, 4, 4);
            this.trI = new ViewGroup.LayoutParams(-2, -2);
            this.trF.addView(this.mView, this.trI);
            this.trF.setOnTouchListener(new 3(this, context.getResources().getDisplayMetrics()));
        }
    }

    final void gC(Context context) {
        boolean z = false;
        this.bRk.setVisibility(0);
        this.bRm.setVisibility(4);
        if (!this.trZ) {
            z = true;
        }
        this.trZ = z;
        this.bRk.setBackgroundDrawable(context.getResources().getDrawable(R.g.trace_start_nor));
        this.jWm.setVisibility(8);
    }

    final void crd() {
        this.jWm.setText(this.tsc);
        this.tsd.sendEmptyMessageDelayed(0, 1000);
    }
}
