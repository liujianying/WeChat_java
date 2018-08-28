package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.memory.ui.QPictureView;

public class QFadeImageView extends QPictureView {
    public String aAL;
    public long jEK;

    public QFadeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFadeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public String getImageKey() {
        return this.aAL;
    }

    public long getStartTimeMillis() {
        return this.jEK;
    }
}
