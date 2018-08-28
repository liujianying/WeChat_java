package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import b.b;
import b.c;
import b.c.a.a;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarStateView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] mkL = new d[]{j.a(new i(j.X(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), j.a(new i(j.X(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    private static final int mlL = mlL;
    public static final a mlM = new a((byte) 0);
    e mkq = e.mjz;
    private final b mlA = c.b((a) new c(this));
    private final b mlB = c.b((a) new b(this));
    boolean mlI = true;
    final d mlJ = new d(this);
    private ImageView mlK;
    boolean mlz;

    private final Animation getSlideInAnim() {
        return (Animation) this.mlB.getValue();
    }

    private final Animation getSlideOutAnim() {
        return (Animation) this.mlA.getValue();
    }

    public final e getState() {
        return this.mkq;
    }

    public final void setState(e eVar) {
        b.c.b.e.i(eVar, "<set-?>");
        this.mkq = eVar;
    }

    private final void setShowing(boolean z) {
        this.mlz = z;
    }

    public RadarStateView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    /* renamed from: bpE */
    final void a() {
        x.d(TAG, " state : " + this.mkq);
        if (this.mlI) {
            ImageView imageView;
            switch (f.mkC[this.mkq.ordinal()]) {
                case 1:
                    setVisibility(8);
                    return;
                case 2:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.radar_search_blue_bg);
                    imageView = this.mlK;
                    if (imageView == null) {
                        b.c.b.e.cJM();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.radar_search_waiting);
                    setVisibility(0);
                    return;
                case 3:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.radar_search_green_bg);
                    imageView = this.mlK;
                    if (imageView == null) {
                        b.c.b.e.cJM();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.radar_search_ok);
                    setVisibility(0);
                    return;
                case 4:
                    setBackgroundResource(com.tencent.mm.plugin.radar.a.e.radar_search_green_bg);
                    imageView = this.mlK;
                    if (imageView == null) {
                        b.c.b.e.cJM();
                    }
                    imageView.setImageResource(com.tencent.mm.plugin.radar.a.e.radar_search_hi);
                    setVisibility(0);
                    return;
                default:
                    return;
            }
        }
        setVisibility(8);
    }

    final void init() {
        if (this.mlK == null) {
            this.mlK = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.setMargins(0, 0, com.tencent.mm.bp.a.fromDPToPix(getContext(), 5), com.tencent.mm.bp.a.fromDPToPix(getContext(), 2));
            ImageView imageView = this.mlK;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.mlK);
        }
    }

    public final void bpF() {
        if (this.mlI) {
            init();
            a();
            this.mlz = true;
            startAnimation(getSlideOutAnim());
        }
    }

    public final void bpG() {
        if (this.mlI) {
            init();
            a();
            startAnimation(getSlideInAnim());
        }
    }
}
