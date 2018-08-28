package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class Snackbar$6 extends an {
    final /* synthetic */ Snackbar gF;

    Snackbar$6(Snackbar snackbar) {
        this.gF = snackbar;
    }

    public final void p(View view) {
        SnackbarLayout d = Snackbar.d(this.gF);
        z.d(d.gH, 0.0f);
        z.U(d.gH).t(1.0f).h(180).i(70).start();
        if (d.gI.getVisibility() == 0) {
            z.d(d.gI, 0.0f);
            z.U(d.gI).t(1.0f).h(180).i(70).start();
        }
    }

    public final void q(View view) {
        Snackbar.g(this.gF);
    }
}
