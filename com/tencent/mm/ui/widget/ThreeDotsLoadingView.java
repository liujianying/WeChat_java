package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class ThreeDotsLoadingView extends FrameLayout {
    private int dotColor = -16777216;
    private boolean uIt = false;
    private ViewGroup uIu;
    private ImageView uIv;
    private ImageView uIw;
    private ImageView uIx;
    private final Runnable uIy = new Runnable() {
        public final void run() {
            ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
            ((AnimationDrawable) ThreeDotsLoadingView.this.uIv.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.uIw.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.uIx.getDrawable()).start();
        }
    };
    private boolean yq = false;

    static /* synthetic */ void a(ThreeDotsLoadingView threeDotsLoadingView) {
        threeDotsLoadingView.uIv.setImageDrawable(d(threeDotsLoadingView.dotColor, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.uIw.setImageDrawable(d(threeDotsLoadingView.dotColor, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.uIx.setImageDrawable(d(threeDotsLoadingView.dotColor, new float[]{0.3f, 0.5f, 0.4f}));
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.uIu = (ViewGroup) LayoutInflater.from(context).inflate(h.layout_three_dots_loading_view, this, true);
        this.uIv = (ImageView) this.uIu.findViewById(g.loading_dot0);
        this.uIw = (ImageView) this.uIu.findViewById(g.loading_dot1);
        this.uIx = (ImageView) this.uIu.findViewById(g.loading_dot2);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ThreeDotsLoadingView);
            this.dotColor = obtainStyledAttributes.getColor(m.ThreeDotsLoadingView_dotColor, -16777216);
            obtainStyledAttributes.recycle();
        }
        cAI();
    }

    public void setVisibility(int i) {
        if (8 == i || 4 == i) {
            cAH();
        }
        super.setVisibility(i);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.uIt) {
            this.uIt = false;
            cAG();
        }
    }

    public void setAlpha(float f) {
        this.uIv.setAlpha(f);
        this.uIw.setAlpha(f);
        this.uIx.setAlpha(f);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f));
        }
    }

    public final void cAG() {
        if (!z.ak(this)) {
            this.uIt = true;
        } else if (!this.yq) {
            this.yq = true;
            cAI();
            postDelayed(this.uIy, 300);
        }
    }

    public final void cAH() {
        this.uIt = false;
        if (this.yq) {
            this.yq = false;
            removeCallbacks(this.uIy);
            if (this.uIv.getDrawable() instanceof AnimationDrawable) {
                ((AnimationDrawable) this.uIv.getDrawable()).stop();
                ((AnimationDrawable) this.uIw.getDrawable()).stop();
                ((AnimationDrawable) this.uIx.getDrawable()).stop();
            }
        }
    }

    private void cAI() {
        this.uIv.setImageDrawable(g(this.dotColor, 0.5f));
        this.uIw.setImageDrawable(g(this.dotColor, 0.4f));
        this.uIx.setImageDrawable(g(this.dotColor, 0.3f));
    }

    private static AnimationDrawable d(int i, float[] fArr) {
        int i2 = 0;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        while (i2 < 3) {
            animationDrawable.addFrame(g(i, fArr[i2]), TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE);
            i2++;
        }
        return animationDrawable;
    }

    private static Drawable g(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
