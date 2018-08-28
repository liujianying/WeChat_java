package android.support.v7.widget;

import android.graphics.Outline;

final class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(Outline outline) {
        if (this.Jx.JE) {
            if (this.Jx.JD != null) {
                this.Jx.JD.getOutline(outline);
            }
        } else if (this.Jx.HS != null) {
            this.Jx.HS.getOutline(outline);
        }
    }
}
