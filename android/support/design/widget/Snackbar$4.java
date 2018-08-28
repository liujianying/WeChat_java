package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout.a;

class Snackbar$4 implements a {
    final /* synthetic */ Snackbar gF;

    Snackbar$4(Snackbar snackbar) {
        this.gF = snackbar;
    }

    public final void aC() {
        if (q.aE().c(this.gF.gE)) {
            Snackbar.aB().post(new Runnable() {
                public final void run() {
                    Snackbar.c(Snackbar$4.this.gF);
                }
            });
        }
    }
}
