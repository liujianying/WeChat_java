package android.support.design.widget;

import android.support.design.widget.s.a;
import android.view.View;

class Snackbar$3 implements a {
    final /* synthetic */ Snackbar gF;

    Snackbar$3(Snackbar snackbar) {
        this.gF = snackbar;
    }

    public final void onDismiss(View view) {
        view.setVisibility(8);
        Snackbar.a(this.gF);
    }

    public final void H(int i) {
        switch (i) {
            case 0:
                q.aE().b(Snackbar.b(this.gF));
                return;
            case 1:
            case 2:
                q.aE().a(Snackbar.b(this.gF));
                return;
            default:
                return;
        }
    }
}
