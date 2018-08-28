package com.tencent.mm.plugin.collect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.b;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$b$1 implements AnimationListener {
    final /* synthetic */ a hYZ;
    final /* synthetic */ b hZa;

    CollectMainUI$b$1(b bVar, a aVar) {
        this.hZa = bVar;
        this.hYZ = aVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.hZa.hYN.hXY.setVisibility(8);
        x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animation end. TransId=" + this.hYZ.bOe);
        for (int i = 0; i < this.hZa.hYN.hYk.size(); i++) {
            if (((a) this.hZa.hYN.hYk.get(i)).bOe.equals(this.hYZ.bOe)) {
                ((a) this.hZa.hYN.hYk.get(i)).hDh = true;
                x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Update msg animation status. TransId=" + this.hYZ.bOe);
                break;
            }
        }
        this.hZa.hYN.aCq();
        this.hZa.hYX = false;
        this.hZa.aCy();
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
