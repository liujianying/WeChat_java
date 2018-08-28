package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.2;
import android.support.design.widget.Snackbar.4;
import android.support.design.widget.Snackbar.5;
import android.support.v4.view.z;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class Snackbar$1 implements Callback {
    Snackbar$1() {
    }

    public final boolean handleMessage(Message message) {
        Snackbar snackbar;
        switch (message.what) {
            case 0:
                snackbar = (Snackbar) message.obj;
                if (snackbar.gC.getParent() == null) {
                    LayoutParams layoutParams = snackbar.gC.getLayoutParams();
                    if (layoutParams instanceof d) {
                        Snackbar$a snackbar$a = new Snackbar$a(snackbar);
                        snackbar$a.hc = s.o(0.1f);
                        snackbar$a.hd = s.o(0.6f);
                        snackbar$a.ha = 0;
                        snackbar$a.gX = new Snackbar$3(snackbar);
                        ((d) layoutParams).a(snackbar$a);
                    }
                    snackbar.gB.addView(snackbar.gC);
                }
                snackbar.gC.setOnAttachStateChangeListener(new 4(snackbar));
                if (!z.ai(snackbar.gC)) {
                    snackbar.gC.setOnLayoutChangeListener(new 5(snackbar));
                } else if (snackbar.aA()) {
                    snackbar.ax();
                } else {
                    snackbar.ay();
                }
                return true;
            case 1:
                snackbar = (Snackbar) message.obj;
                int i = message.arg1;
                if (!snackbar.aA() || snackbar.gC.getVisibility() != 0) {
                    snackbar.az();
                } else if (VERSION.SDK_INT >= 14) {
                    z.U(snackbar.gC).v((float) snackbar.gC.getHeight()).c(a.bM).h(250).a(new Snackbar$8(snackbar, i)).start();
                } else {
                    Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.gC.getContext(), a.design_snackbar_out);
                    loadAnimation.setInterpolator(a.bM);
                    loadAnimation.setDuration(250);
                    loadAnimation.setAnimationListener(new 2(snackbar, i));
                    snackbar.gC.startAnimation(loadAnimation);
                }
                return true;
            default:
                return false;
        }
    }
}
