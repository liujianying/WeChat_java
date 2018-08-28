package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    private boolean bKe = false;
    private List<MaskImageView> list = new LinkedList();
    private ag nLo = new ag();
    private Runnable nLp = new Runnable() {
        public final void run() {
            MaskLinearLayout.this.setPressed(false);
            MaskLinearLayout.a(MaskLinearLayout.this);
            MaskLinearLayout.this.invalidate();
        }
    };

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(e.sns_media_link_bg_pressed);
        } else {
            maskLinearLayout.setBackgroundResource(0);
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new 2(this));
    }

    public void settouchEnable(boolean z) {
        this.bKe = z;
    }

    public final void b(MaskImageView maskImageView) {
        this.list.add(maskImageView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
