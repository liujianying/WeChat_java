package com.tencent.mm.plugin.appbrand.widget.f;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ag;

public final class a extends FrameLayout implements OnClickListener, c {
    private TextView gFz;
    private final Runnable gOM = new 1(this);
    private ViewPropertyAnimator gON;
    ViewPropertyAnimator gOO;
    private final ag mHandler = new ag(Looper.getMainLooper());

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.app_brand_show_no_icon_toast, this, true);
        this.gFz = (TextView) findViewById(g.title);
        setOnClickListener(this);
    }

    public final void wp(String str) {
        this.gFz.setText(str);
        this.mHandler.removeCallbacks(this.gOM);
        this.mHandler.postDelayed(this.gOM, gOS);
        if (getAlpha() != 1.0f && this.gON == null) {
            setVisibility(0);
            animate().cancel();
            ViewPropertyAnimator animate = animate();
            this.gON = animate;
            animate.alpha(1.0f).setListener(new 2(this)).start();
            setVisibility(0);
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(FrameLayout frameLayout) {
        frameLayout.addView(this, new LayoutParams(-2, -2, 17));
    }

    public final void onClick(View view) {
    }
}
