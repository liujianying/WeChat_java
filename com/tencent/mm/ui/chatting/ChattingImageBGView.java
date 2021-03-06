package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingImageBGView extends ImageView {
    private int gJE = 0;
    private Bitmap jDx;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ScaleType.CENTER_CROP);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.CENTER_CROP);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.gJE != i3 - i) {
            this.gJE = i3 - i;
            x.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            ctu();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.jDx = bitmap;
        super.setImageBitmap(bitmap);
        ctu();
    }

    private void ctu() {
        post(new 1(this));
    }
}
