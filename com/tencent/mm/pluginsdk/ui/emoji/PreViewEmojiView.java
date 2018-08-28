package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;

public class PreViewEmojiView extends MMEmojiView {
    private int fi = 0;

    public PreViewEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreViewEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSize(int i) {
        this.fi = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.fi > 0) {
            setMeasuredDimension(this.fi, this.fi);
        }
    }
}
