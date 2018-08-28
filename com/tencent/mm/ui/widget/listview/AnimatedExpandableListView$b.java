package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class AnimatedExpandableListView$b extends View {
    private int dividerHeight;
    private Drawable ePn;
    List<View> uKG;
    private int uKH;

    /* synthetic */ AnimatedExpandableListView$b(Context context, byte b) {
        this(context);
    }

    static /* synthetic */ void a(AnimatedExpandableListView$b animatedExpandableListView$b, Drawable drawable, int i, int i2) {
        if (drawable != null) {
            animatedExpandableListView$b.ePn = drawable;
            animatedExpandableListView$b.uKH = i;
            animatedExpandableListView$b.dividerHeight = i2;
            drawable.setBounds(0, 0, i, i2);
        }
    }

    private AnimatedExpandableListView$b(Context context) {
        super(context);
        this.uKG = new ArrayList();
    }

    public final void dT(View view) {
        view.layout(0, 0, getWidth(), getHeight());
        this.uKG.add(view);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int size = this.uKG.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((View) this.uKG.get(i5)).layout(i, i2, i3, i4);
        }
    }

    public final void dispatchDraw(Canvas canvas) {
        canvas.save();
        if (this.ePn != null) {
            this.ePn.setBounds(0, 0, this.uKH, this.dividerHeight);
        }
        int size = this.uKG.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.uKG.get(i);
            view.draw(canvas);
            canvas.translate(0.0f, (float) view.getMeasuredHeight());
            if (this.ePn != null) {
                this.ePn.draw(canvas);
                canvas.translate(0.0f, (float) this.dividerHeight);
            }
        }
        canvas.restore();
    }
}
