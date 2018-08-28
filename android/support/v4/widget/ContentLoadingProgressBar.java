package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private long mStartTime = -1;
    private boolean nv = false;
    private boolean yO = false;
    private boolean yP = false;
    private final Runnable yQ = new Runnable() {
        public final void run() {
            ContentLoadingProgressBar.this.yO = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable yR = new 2(this);

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cA();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cA();
    }

    private void cA() {
        removeCallbacks(this.yQ);
        removeCallbacks(this.yR);
    }
}
