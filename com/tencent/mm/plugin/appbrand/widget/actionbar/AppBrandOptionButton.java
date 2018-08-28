package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.svg.a.b;

public class AppBrandOptionButton extends FrameLayout {
    ImageButton gFA;
    private int gFv = i.app_brand_actionbar_option_light;
    private ObjectAnimator gFw;
    public boolean gFx = true;
    private View gFy;
    private TextView gFz;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private int getActionBarHeight() {
        return getResources().getDimensionPixelSize(e.wechat_abc_action_bar_default_height);
    }

    private void init(Context context) {
        this.gFy = LayoutInflater.from(context).inflate(h.action_option_view, this, false);
        this.gFz = (TextView) this.gFy.findViewById(g.action_option_text);
        this.gFz.setMaxLines(1);
        this.gFz.setClickable(false);
        this.gFz.setBackground(null);
        addView(this.gFy, new LayoutParams(-2, -1, 17));
        this.gFy.setVisibility(8);
        this.gFA = new ImageButton(context);
        this.gFA.setClickable(false);
        this.gFA.setBackground(null);
        addView(this.gFA, new LayoutParams(getActionBarHeight(), -1, 17));
        this.gFw = ObjectAnimator.ofFloat(this.gFA, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        this.gFw.setDuration(2000);
        this.gFw.setInterpolator(new AccelerateInterpolator());
        this.gFw.setRepeatCount(-1);
        this.gFw.setRepeatMode(1);
    }

    public void setIcon(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.gFx = false;
            this.gFA.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
            this.gFA.setVisibility(0);
            this.gFy.setVisibility(8);
        }
    }

    public void setText(String str) {
        this.gFx = false;
        this.gFz.setText(str);
        this.gFy.setVisibility(0);
        this.gFA.setVisibility(8);
    }

    public void setColor(int i) {
        this.gFz.setTextColor(i);
        if (this.gFA.getDrawable() == null || (this.gFA.getDrawable() instanceof b)) {
            this.gFA.setImageResource(getImageButtonResource());
            this.gFA.setColorFilter(i, Mode.SRC_ATOP);
        }
    }

    public final void reset() {
        this.gFx = true;
        this.gFy.setVisibility(8);
        this.gFA.setVisibility(0);
        if (!(this.gFA.getDrawable() instanceof b)) {
            this.gFA.setImageResource(getImageButtonResource());
        }
    }

    protected int getImageButtonResource() {
        return this.gFv;
    }

    protected final void a(a aVar, int i) {
        x.i("MicroMsg.AppBrandOptionButton", "setImageButtonStatus status %s", new Object[]{aVar});
        switch (3.glK[aVar.ordinal()]) {
            case 1:
                this.gFv = i.app_brand_actionbar_capsule_lbs_dark;
                break;
            case 2:
                this.gFv = i.app_brand_actionbar_capsule_video_dark;
                break;
            case 3:
                this.gFv = i.app_brand_actionbar_capsule_voice_dark;
                break;
            case 5:
                this.gFv = i.app_brand_actionbar_option_dark;
                break;
        }
        this.gFx = true;
        this.gFy.setVisibility(8);
        this.gFA.setVisibility(0);
        this.gFA.setImageResource(getImageButtonResource());
        this.gFA.setColorFilter(i, Mode.SRC_ATOP);
        if (this.gFv == i.app_brand_actionbar_option_dark) {
            post(new Runnable() {
                public final void run() {
                    AppBrandOptionButton.this.gFw.end();
                }
            });
        } else {
            post(new 1(this));
        }
    }
}
