package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.c;
import android.support.v7.view.menu.l.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

final class g implements OnClickListener, OnDismissListener, OnKeyListener, a {
    e IA;
    private a IB;
    c Iz;
    f bq;

    public g(f fVar) {
        this.bq = fVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.Iz.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.Iz.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.bq.J(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.bq.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.IA.a(this.bq, true);
    }

    public final void a(f fVar, boolean z) {
        if ((z || fVar == this.bq) && this.Iz != null) {
            this.Iz.dismiss();
        }
        if (this.IB != null) {
            this.IB.a(fVar, z);
        }
    }

    public final boolean d(f fVar) {
        if (this.IB != null) {
            return this.IB.d(fVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bq.a((h) this.IA.getAdapter().getItem(i), null, 0);
    }
}
