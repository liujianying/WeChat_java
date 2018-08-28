package android.support.design.widget;

import android.graphics.drawable.Drawable;

class FloatingActionButton$b implements p {
    final /* synthetic */ FloatingActionButton fu;

    private FloatingActionButton$b(FloatingActionButton floatingActionButton) {
        this.fu = floatingActionButton;
    }

    /* synthetic */ FloatingActionButton$b(FloatingActionButton floatingActionButton, byte b) {
        this(floatingActionButton);
    }

    public final float getRadius() {
        return ((float) this.fu.getSizeDimension()) / 2.0f;
    }

    public final void d(int i, int i2, int i3, int i4) {
        FloatingActionButton.c(this.fu).set(i, i2, i3, i4);
        this.fu.setPadding(FloatingActionButton.d(this.fu) + i, FloatingActionButton.d(this.fu) + i2, FloatingActionButton.d(this.fu) + i3, FloatingActionButton.d(this.fu) + i4);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        FloatingActionButton.a(this.fu, drawable);
    }

    public final boolean ak() {
        return FloatingActionButton.e(this.fu);
    }
}
