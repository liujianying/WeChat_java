package com.tencent.mm.plugin.soter_mp.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.R;

class b$7 implements AnimationListener {
    final /* synthetic */ CharSequence iL;
    final /* synthetic */ b oom;

    b$7(b bVar, CharSequence charSequence) {
        this.oom = bVar;
        this.iL = charSequence;
    }

    public final void onAnimationStart(Animation animation) {
        this.oom.oof.setImageResource(R.k.fingerprint_icon_error);
        this.oom.glY.setText(this.iL);
        this.oom.glY.setTextColor(this.oom.glY.getResources().getColor(R.e.warning_color));
        this.oom.glY.removeCallbacks(this.oom.ool);
    }

    public final void onAnimationEnd(Animation animation) {
        this.oom.glY.post(this.oom.ool);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
