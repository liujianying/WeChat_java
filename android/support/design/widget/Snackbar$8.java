package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class Snackbar$8 extends an {
    final /* synthetic */ Snackbar gF;
    final /* synthetic */ int val$event;

    Snackbar$8(Snackbar snackbar, int i) {
        this.gF = snackbar;
        this.val$event = i;
    }

    public final void p(View view) {
        SnackbarLayout d = Snackbar.d(this.gF);
        z.d(d.gH, 1.0f);
        z.U(d.gH).t(0.0f).h(180).i(0).start();
        if (d.gI.getVisibility() == 0) {
            z.d(d.gI, 1.0f);
            z.U(d.gI).t(0.0f).h(180).i(0).start();
        }
    }

    public final void q(View view) {
        Snackbar.c(this.gF);
    }
}
