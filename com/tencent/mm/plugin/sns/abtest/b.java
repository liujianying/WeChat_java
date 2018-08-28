package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    int JP = 0;
    int gwO = 0;
    int mScreenHeight = 0;
    NotInterestMenu nhD;
    ViewGroup nhE;
    NotInterestMenu$b nhF = new 1(this);
    Animation nhG = null;
    Animation nhH = null;
    private Animation nhI = null;
    private Animation nhJ = null;
    int nhK = 0;
    int nhL = 0;
    int nhM = 0;
    int nhN = 0;
    int nhO = 0;
    boolean nhP = false;
    AbsoluteLayout nhQ = null;
    boolean nhR = false;
    boolean nhS = false;
    c nhy;

    public b(ViewGroup viewGroup) {
        this.nhE = viewGroup;
        this.nhG = AnimationUtils.loadAnimation(ad.getContext(), a.dropdown_down);
        this.nhG.setFillAfter(true);
        this.nhG.setDuration(100);
        this.nhG.setAnimationListener(new 2(this));
        this.nhH = AnimationUtils.loadAnimation(ad.getContext(), a.dropup_up);
        this.nhH.setFillAfter(true);
        this.nhH.setDuration(100);
        this.nhH.setAnimationListener(new 3(this));
        this.nhI = AnimationUtils.loadAnimation(ad.getContext(), a.dropdown_up);
        this.nhI.setFillAfter(true);
        this.nhI.setDuration(100);
        this.nhI.setAnimationListener(new 4(this));
        this.nhJ = AnimationUtils.loadAnimation(ad.getContext(), a.dropup_down);
        this.nhJ.setFillAfter(true);
        this.nhJ.setDuration(100);
        this.nhJ.setAnimationListener(new 5(this));
    }

    public final void bwH() {
        if (this.nhQ != null && this.nhE != null && this.nhD != null) {
            this.nhQ.removeView(this.nhD);
            this.nhE.removeView(this.nhQ);
            this.nhQ = null;
            this.nhD = null;
            this.nhP = false;
        }
    }
}
