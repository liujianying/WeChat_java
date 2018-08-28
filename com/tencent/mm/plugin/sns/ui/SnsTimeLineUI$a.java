package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.QImageView.a;

class SnsTimeLineUI$a extends Animation {
    ListView kww;
    float odJ;
    float odK;
    float odL = -1.0f;
    float odM;
    float odN = 0.0f;
    private float odO;
    boolean odP;
    int odQ;
    boolean odR = false;
    int odS = 0;
    float odT = 0.0f;
    float odU = 0.0f;
    final /* synthetic */ SnsTimeLineUI odw;

    public SnsTimeLineUI$a(SnsTimeLineUI snsTimeLineUI, ListView listView) {
        this.odw = snsTimeLineUI;
        this.kww = listView;
    }

    public final void bEj() {
        x.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
        if (SnsTimeLineUI.m(this.odw).getVisibility() == 0) {
            init();
            this.odN = this.odL + 20.0f;
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.m(this.odw).getLayoutParams();
            layoutParams.y = (int) this.odL;
            SnsTimeLineUI.m(this.odw).setLayoutParams(layoutParams);
            bEk();
        }
    }

    public final void bEk() {
        if (SnsTimeLineUI.m(this.odw).getVisibility() == 0) {
            init();
            SnsTimeLineUI.m(this.odw).clearAnimation();
            SnsTimeLineUI.m(this.odw).startAnimation(this);
            if (this.odN >= this.odL) {
                setDuration(20000);
                this.odP = false;
                return;
            }
            setDuration(600);
            this.odP = true;
        }
    }

    final void init() {
        if (this.odL == -1.0f || ((double) this.odK) < 0.1d) {
            this.odL = (float) b.b(this.odw, 31.0f);
            this.odJ = (float) (SnsTimeLineUI.m(this.odw).getWidth() / 2);
            this.odK = (float) (SnsTimeLineUI.m(this.odw).getHeight() / 2);
            this.odM = (this.odK * -2.0f) - 3.0f;
            x.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.odM);
            this.odN = this.odM;
            if (!this.odR) {
                x.i("MicroMsg.SnsTimeLineUI", "initState");
                this.odS = ((LayoutParams) SnsTimeLineUI.m(this.odw).getLayoutParams()).y;
                this.odT = this.odL;
                this.odU = this.odN;
            }
            this.odR = true;
        }
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (SnsTimeLineUI.m(this.odw).getVisibility() == 0) {
            float duration = ((float) getDuration()) * (f - this.odO);
            if (duration >= 2.0f) {
                this.odO = f;
                SnsTimeLineUI.m(this.odw).setImageResource(i.friendactivity_refresh);
                SnsTimeLineUI.m(this.odw).setScaleType(a.uHL);
                if (((float) getDuration()) * f >= ((float) (getDuration() - 600)) || this.odP) {
                    LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.m(this.odw).getLayoutParams();
                    this.odN = (((float) layoutParams.y) - (duration / 3.0f)) - 1.0f;
                    layoutParams.y = (int) this.odN;
                    SnsTimeLineUI.m(this.odw).setLayoutParams(layoutParams);
                } else {
                    SnsTimeLineUI.m(this.odw).getImageMatrix().postRotate(duration / 2.5f, this.odJ, this.odK);
                }
                SnsTimeLineUI.m(this.odw).invalidate();
            }
        }
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.odO = 0.0f;
        this.odN = this.odL;
    }
}
