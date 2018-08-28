package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import b.b;
import b.c;
import b.c.a.a;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.a$e;
import com.tencent.mm.plugin.radar.b.e;

public final class RadarStateChooseView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] mkL = new d[]{(d) j.a(new i(j.X(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (d) j.a(new i(j.X(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;"))};
    public static final a mlE = new a((byte) 0);
    private final b mlA = c.b((a) new c(this));
    private final b mlB = c.b((a) new b(this));
    boolean mlC = true;
    e.a mlD = e.a.mkn;
    boolean mlz;

    final Animation getSlideInAnim() {
        return (Animation) this.mlB.getValue();
    }

    final Animation getSlideOutAnim() {
        return (Animation) this.mlA.getValue();
    }

    public final e.a getMStatus() {
        return this.mlD;
    }

    public final void setMStatus(e.a aVar) {
        b.c.b.e.i((Object) aVar, "<set-?>");
        this.mlD = aVar;
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i((Object) context, "context");
        b.c.b.e.i((Object) attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarStateChooseView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i((Object) context, "context");
        b.c.b.e.i((Object) attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    final void bpE() {
        switch (e.mkC[this.mlD.ordinal()]) {
            case 1:
                setVisibility(4);
                return;
            case 2:
                setBackgroundResource(a$e.radar_select);
                setVisibility(0);
                return;
            default:
                setVisibility(4);
                return;
        }
    }
}
