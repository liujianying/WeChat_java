package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

class ac$1 extends a {
    final /* synthetic */ ac Tk;

    ac$1(ac acVar) {
        this.Tk = acVar;
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        if (!this.Tk.gk() && this.Tk.Sa.getLayoutManager() != null) {
            this.Tk.Sa.getLayoutManager().b(view, bVar);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (this.Tk.gk() || this.Tk.Sa.getLayoutManager() == null) {
            return false;
        }
        h layoutManager = this.Tk.Sa.getLayoutManager();
        m mVar = layoutManager.Sa.QN;
        q qVar = layoutManager.Sa.RB;
        return false;
    }
}
