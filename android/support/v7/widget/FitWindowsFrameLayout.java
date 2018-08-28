package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.x.a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements x {
    private a Ot;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(a aVar) {
        this.Ot = aVar;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.Ot != null) {
            this.Ot.f(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
