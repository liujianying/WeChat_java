package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.reflect.Field;

public class LightHouseImageView extends ImageView {
    private ag handler = new ag();
    private AnimationDrawable hlH;

    public LightHouseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LightHouseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(int i) {
        this.handler.postDelayed(new 1(this, i), 1000);
    }

    public void onDraw(Canvas canvas) {
        try {
            Field declaredField = AnimationDrawable.class.getDeclaredField("mCurFrame");
            declaredField.setAccessible(true);
            nn(declaredField.getInt(this.hlH));
            super.onDraw(canvas);
        } catch (Exception e) {
        }
    }

    private void nn(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) getParent();
        if ((i >= 6 && i <= 8) || (i >= 21 && i <= 23)) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 250) / 800, (frameLayout.getWidth() * 123) / 480, marginLayoutParams.bottomMargin);
        } else if ((i < 0 || i > 8) && (i < 21 || i > 29)) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 245) / 800, ((frameLayout.getWidth() * 125) / 480) - getWidth(), marginLayoutParams.bottomMargin);
        } else {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 245) / 800, (frameLayout.getWidth() * 130) / 480, marginLayoutParams.bottomMargin);
        }
        setLayoutParams(marginLayoutParams);
    }
}
