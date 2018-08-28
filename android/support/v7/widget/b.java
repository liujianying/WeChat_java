package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer Jx;

    public b(ActionBarContainer actionBarContainer) {
        this.Jx = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.Jx.JE) {
            if (this.Jx.HS != null) {
                this.Jx.HS.draw(canvas);
            }
            if (this.Jx.JC != null && this.Jx.JF) {
                this.Jx.JC.draw(canvas);
            }
        } else if (this.Jx.JD != null) {
            this.Jx.JD.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
