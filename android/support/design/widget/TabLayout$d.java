package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class TabLayout$d {
    Object hX;
    CharSequence hY;
    View hZ;
    Drawable hh;
    TabLayout ia;
    TabLayout$f ib;
    int mPosition;
    CharSequence mText;

    /* synthetic */ TabLayout$d(byte b) {
        this();
    }

    private TabLayout$d() {
        this.mPosition = -1;
    }

    public final TabLayout$d a(CharSequence charSequence) {
        this.mText = charSequence;
        aL();
        return this;
    }

    public final void select() {
        if (this.ia == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        this.ia.b(this, true);
    }

    final void aL() {
        if (this.ib != null) {
            this.ib.update();
        }
    }
}
