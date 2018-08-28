package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;

final class Snackbar$a extends s<SnackbarLayout> {
    final /* synthetic */ Snackbar gF;

    Snackbar$a(Snackbar snackbar) {
        this.gF = snackbar;
    }

    public final boolean r(View view) {
        return view instanceof SnackbarLayout;
    }

    private boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.b(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    q.aE().a(Snackbar.b(this.gF));
                    break;
                case 1:
                case 3:
                    q.aE().b(Snackbar.b(this.gF));
                    break;
            }
        }
        return super.a(coordinatorLayout, snackbarLayout, motionEvent);
    }
}
