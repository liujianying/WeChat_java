package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView extends PLTextView {
    private static a omZ = null;
    private static int ona = 0;

    public SnsCommentPreloadTextView(Context context) {
        super(context);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a Fc() {
        if (omZ == null) {
            omZ = b.bEX().getTextViewConfig();
        }
        return omZ;
    }

    public static a getTextViewConfig() {
        if (omZ == null) {
            omZ = b.bEX().getTextViewConfig();
        }
        return omZ;
    }

    protected final void o(CharSequence charSequence) {
        super.o(charSequence);
    }

    protected final void n(CharSequence charSequence) {
        super.n(charSequence);
    }

    public static int getViewWidth() {
        if (ona == 0) {
            ona = b.bEX().getViewWidth();
        }
        return ona;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
