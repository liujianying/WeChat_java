package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b;
import b.c;
import b.c.a.a;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.e.d;
import com.tencent.mm.plugin.radar.a$c;
import com.tencent.mm.plugin.radar.a$f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarTipsView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] mkL = new d[]{(d) j.a(new i(j.X(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), (d) j.a(new i(j.X(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), (d) j.a(new i(j.X(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), (d) j.a(new i(j.X(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), (d) j.a(new i(j.X(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;"))};
    private static final int mmj = 3;
    private static final int mmk = 0;
    static final int mml = 1;
    static final int mmm = 2;
    private static final int mmn = 3;
    public static final a mmo = new a((byte) 0);
    private final b mlP = new b(this);
    private final b mlQ = c.b((a) new d(this));
    private final b mlR = c.b((a) new e(this));
    private final b mlS = i.D(this, a$c.radar_tips_tv);
    private final b mlT = i.D(this, a$c.radar_text_tips);
    private final b mlU = i.D(this, a$c.radar_user_education_tips);
    private final int mlV;
    final int mlW = 1;
    final int mlX = 2;
    private final int mlY = 3;
    private final int mlZ = 3;
    final f mma = new f(this, Looper.getMainLooper());
    boolean mmb;
    private boolean mmc = true;
    boolean mmd;
    boolean mme;
    private int mmf;
    private long mmg;
    private boolean mmh;
    int mmi = mmk;

    public static final class f extends ag {
        final /* synthetic */ RadarTipsView mmp;

        f(RadarTipsView radarTipsView, Looper looper) {
            this.mmp = radarTipsView;
            super(looper);
        }

        public final void handleMessage(Message message) {
            e.i(message, "msg");
            int i = message.what;
            if (i == this.mmp.mlV) {
                this.mmp.bpJ();
            } else if (i == this.mmp.mlW) {
                if (this.mmp.mmc && this.mmp.mme) {
                    RadarTipsView.a(this.mmp, a$f.radar_tips_nomember);
                }
            } else if (i == this.mmp.mlY) {
                RadarTipsView radarTipsView = this.mmp;
                radarTipsView.mmb = true;
                a aVar = RadarTipsView.mmo;
                radarTipsView.mmi = RadarTipsView.mmm;
                aVar = RadarTipsView.mmo;
                x.d(RadarTipsView.TAG, "showNoviceEducation");
                radarTipsView.mmd = true;
                radarTipsView.getTextTipsContainer().setVisibility(8);
                radarTipsView.getTextTipsContainer().clearAnimation();
                radarTipsView.setVisibility(0);
                radarTipsView.getNoviceEducationTips().setVisibility(0);
                radarTipsView.getNoviceEducationTips().startAnimation(radarTipsView.getTipsFadeIn());
                radarTipsView.getNoviceEducationTips().requestFocus();
            } else if (i == this.mmp.mlZ) {
                this.mmp.bpI();
            }
        }
    }

    private final Animation getTipsFadeOut() {
        return (Animation) this.mlR.getValue();
    }

    private final TextView getTvTextTips() {
        return (TextView) this.mlS.getValue();
    }

    final LinearLayout getNoviceEducationTips() {
        return (LinearLayout) this.mlU.getValue();
    }

    final View getTextTipsContainer() {
        return (View) this.mlT.getValue();
    }

    final Animation getTipsFadeIn() {
        return (Animation) this.mlQ.getValue();
    }

    private final void setPressing(boolean z) {
        this.mme = z;
    }

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public static /* synthetic */ void a(RadarTipsView radarTipsView, int i) {
        String string = radarTipsView.getContext().getString(i);
        e.h(string, "context.getString(res)");
        radarTipsView.bX(string, -1);
    }

    private void bX(String str, int i) {
        e.i(str, "msg");
        this.mmb = true;
        getNoviceEducationTips().setVisibility(8);
        getNoviceEducationTips().clearAnimation();
        getTvTextTips().setText(str);
        setVisibility(0);
        getTextTipsContainer().setVisibility(0);
        getTextTipsContainer().startAnimation(getTipsFadeIn());
        this.mma.removeMessages(this.mlV);
        this.mma.removeMessages(this.mlX);
        if (i > 0) {
            this.mma.sendEmptyMessageDelayed(this.mlV, (long) i);
        }
    }

    public final void Kk(String str) {
        e.i(str, "msg");
        this.mmi = mmn;
        bX(str, 5000);
    }

    public final void bpI() {
        this.mmb = false;
        this.mmi = mmk;
        x.d(TAG, "hidNoviceEducation");
        this.mma.removeMessages(this.mlY);
        if (getVisibility() == 0 && getNoviceEducationTips().getVisibility() == 0) {
            getNoviceEducationTips().clearAnimation();
            if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
                getTextTipsContainer().clearAnimation();
            }
            x.d(TAG, "hideNoviceEducation real");
            getNoviceEducationTips().startAnimation(getTipsFadeOut());
        }
    }

    public final void setNoMember(boolean z) {
        this.mmc = z;
        if (!this.mmc) {
            bpJ();
            bpK();
            bpI();
        }
    }

    public final void setPressingDown(boolean z) {
        if (this.mmg != 0) {
            this.mmi = mmk;
            bpK();
            bpJ();
            getTextTipsContainer().setVisibility(8);
            getNoviceEducationTips().setVisibility(8);
            setVisibility(8);
        }
        this.mme = true;
        this.mmg = bi.VG();
        this.mmh = z;
        this.mmf++;
    }

    public final void bpJ() {
        x.d(TAG, "hideRadarTips");
        if (getVisibility() == 0 && getTextTipsContainer().getVisibility() == 0) {
            if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
                getNoviceEducationTips().clearAnimation();
            }
            getTextTipsContainer().clearAnimation();
            x.d(TAG, "hideRadarTips real");
            this.mmi = mmk;
            this.mmb = false;
            getTextTipsContainer().startAnimation(getTipsFadeOut());
        }
    }

    private void bpK() {
        this.mmb = false;
        f fVar = this.mma;
        fVar.removeMessages(this.mlW);
        fVar.removeMessages(this.mlX);
        fVar.removeMessages(this.mlY);
    }
}
