package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class FavPostVoiceUI$5 implements OnTouchListener {
    final /* synthetic */ FavPostVoiceUI iZn;

    FavPostVoiceUI$5(FavPostVoiceUI favPostVoiceUI) {
        this.iZn = favPostVoiceUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == FavPostVoiceUI.g(this.iZn)) {
            int rawY = (int) motionEvent.getRawY();
            int[] iArr = new int[2];
            FavPostVoiceUI.a(this.iZn, this.iZn.getResources().getDisplayMetrics().heightPixels);
            FavPostVoiceUI.g(this.iZn).getLocationOnScreen(iArr);
            int i = iArr[1];
            switch (motionEvent.getAction()) {
                case 0:
                    if (!FavPostVoiceUI.h(this.iZn)) {
                        FavPostVoiceUI.i(this.iZn);
                        FavPostVoiceUI.j(this.iZn);
                        break;
                    }
                    break;
                case 1:
                    if (FavPostVoiceUI.h(this.iZn)) {
                        if (FavPostVoiceUI.m(this.iZn).getVisibility() != 0) {
                            if (!FavPostVoiceUI.o(this.iZn)) {
                                FavPostVoiceUI.p(this.iZn);
                                break;
                            }
                        }
                        x.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                        FavPostVoiceUI.n(this.iZn);
                        break;
                    }
                    break;
                case 2:
                    if (rawY <= FavPostVoiceUI.k(this.iZn) - b.b(this.iZn, 60.0f) && rawY < i) {
                        FavPostVoiceUI.l(this.iZn).setVisibility(8);
                        FavPostVoiceUI.m(this.iZn).setVisibility(0);
                        break;
                    }
                    FavPostVoiceUI.l(this.iZn).setVisibility(0);
                    FavPostVoiceUI.m(this.iZn).setVisibility(8);
                    break;
                case 3:
                    x.w("MicroMsg.FavPostVoiceUI", "action cancel");
                    FavPostVoiceUI.n(this.iZn);
                    break;
            }
        }
        return false;
    }
}
