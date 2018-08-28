package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class VoiceInputScrollView extends ScrollView {
    private a qHL;

    public VoiceInputScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnScrollListener(a aVar) {
        this.qHL = aVar;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
