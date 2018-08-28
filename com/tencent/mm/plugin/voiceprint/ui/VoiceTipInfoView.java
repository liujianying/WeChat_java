package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.ui.a.4;
import com.tencent.mm.plugin.voiceprint.ui.a.5;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceTipInfoView extends LinearLayout {
    public ProgressBar eWx;
    TextView gsY;
    boolean oGL = false;
    private boolean oGM = false;
    private TextView oGN;
    private boolean oGO = false;
    private float oGP = 0.0f;
    TextView oGm;

    public VoiceTipInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.voice_tip_info_view, this, true);
        this.eWx = (ProgressBar) inflate.findViewById(R.h.load_progress);
        bJm();
        this.gsY = (TextView) inflate.findViewById(R.h.voice_print_title);
        this.oGm = (TextView) inflate.findViewById(R.h.voice_print_title_tip);
        this.oGN = (TextView) inflate.findViewById(R.h.voice_print_title_error);
        reset();
    }

    public final void reset() {
        this.oGm.setTextSize(0, getContext().getResources().getDimension(R.f.voice_print_tip_normal_size));
        this.oGP = this.oGm.getTextSize();
        this.oGm.clearAnimation();
        x.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[]{Float.valueOf(this.oGP)});
    }

    public final void bJl() {
        x.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
        this.eWx.setVisibility(0);
    }

    public final void bJm() {
        x.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
        this.eWx.setVisibility(8);
    }

    public void setTipText(String str) {
        this.oGm.setText(str);
        this.oGm.setVisibility(0);
    }

    public void setTipText(int i) {
        this.oGm.setText(i);
        this.oGm.setVisibility(0);
    }

    public void setTitleText(String str) {
        this.gsY.setText(str);
        this.gsY.setVisibility(0);
    }

    public void setTitleText(int i) {
        this.gsY.setText(i);
        this.gsY.setVisibility(0);
    }

    public final void bJn() {
        x.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(this.gsY.getVisibility()), Boolean.valueOf(this.oGL)});
        if ((this.gsY.getVisibility() == 4 || this.gsY.getVisibility() == 8) && !this.oGL) {
            this.gsY.clearAnimation();
            this.oGL = true;
            View view = this.gsY;
            Context context = getContext();
            2 2 = new 2(this);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.a.fast_faded_in);
            loadAnimation.setDuration(300);
            loadAnimation.setFillAfter(true);
            loadAnimation.setRepeatCount(0);
            loadAnimation.setAnimationListener(new 4(2));
            view.startAnimation(loadAnimation);
            return;
        }
        x.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
        this.gsY.clearAnimation();
        this.gsY.setVisibility(0);
        this.gsY.invalidate();
    }

    public final void bJo() {
        this.oGm.setVisibility(8);
    }

    public final void bJp() {
        if (this.oGN.getVisibility() != 4 || this.oGO) {
            this.oGN.clearAnimation();
            this.oGN.setVisibility(0);
            return;
        }
        this.oGN.clearAnimation();
        this.oGO = true;
        View view = this.oGN;
        getContext();
        4 4 = new 4(this);
        Animation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new 5(4));
        view.startAnimation(translateAnimation);
    }

    public final void bJq() {
        if (this.oGN.getVisibility() != 0 || this.oGO) {
            this.oGN.clearAnimation();
            this.oGN.setVisibility(4);
            return;
        }
        this.oGN.clearAnimation();
        this.oGO = true;
        a.a(this.oGN, getContext(), new a() {
            public final void bJd() {
            }

            public final void bJe() {
                VoiceTipInfoView.this.oGN.setVisibility(4);
                VoiceTipInfoView.this.oGO = false;
            }
        });
    }

    public void setErr(String str) {
        this.oGN.setText(str);
    }

    public void setErr(int i) {
        this.oGN.setText(i);
    }
}
