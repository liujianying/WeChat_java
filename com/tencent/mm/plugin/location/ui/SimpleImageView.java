package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;

public class SimpleImageView extends ImageView {
    public ag handler = new 1(this);
    public String imagePath;
    public int kGn;
    public int kGo;
    public String url = null;

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
