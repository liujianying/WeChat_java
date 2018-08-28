package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView extends SmileySubGrid {
    private String iiv;
    private EmojiDetailScrollView ilZ;
    private volatile boolean ima = true;

    public EmojiDetailGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected void setScrollEnable(boolean z) {
        if (this.ilZ != null) {
            this.ilZ.setScrollEnable(z);
        }
    }

    public void setEmojiDetailScrollView(EmojiDetailScrollView emojiDetailScrollView) {
        this.ilZ = emojiDetailScrollView;
    }

    protected final int getSkewingY$3c7ec8d0() {
        return 0;
    }

    protected int getLongTouchTime() {
        return 200;
    }

    public String getProductId() {
        return this.iiv;
    }

    public void setProductId(String str) {
        this.iiv = str;
    }
}
