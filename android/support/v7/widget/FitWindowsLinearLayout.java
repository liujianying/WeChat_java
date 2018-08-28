package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.x.a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements x {
    private a Ot;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
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
