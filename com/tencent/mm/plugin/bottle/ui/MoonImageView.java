package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;

public class MoonImageView extends ImageView {
    ImageView hkz;
    private final int[] hlM = new int[]{0, R.g.bottle_moon_1, R.g.bottle_moon_2, R.g.bottle_moon_3, R.g.bottle_moon_4, R.g.bottle_moon_5, R.g.bottle_moon_6, R.g.bottle_moon_7};
    private final double[] hlN = new double[]{0.0d, 20.0d, 35.0d, 50.0d, 60.0d, 50.0d, 35.0d, 20.0d};

    public MoonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MoonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(int i) {
        int i2 = 170;
        int dayIdx = getDayIdx();
        setBackgroundResource(this.hlM[dayIdx]);
        ImageView imageView = this.hkz;
        switch (dayIdx) {
            case 0:
                i2 = b.CTRL_BYTE;
                break;
            case 2:
                i2 = 127;
                break;
            case 3:
                i2 = 85;
                break;
            case 4:
                i2 = 0;
                break;
            case 5:
                i2 = 85;
                break;
            case 6:
                i2 = 127;
                break;
        }
        imageView.setAlpha(i2);
        if (dayIdx > 0) {
            i2 = getContext().getResources().getDisplayMetrics().heightPixels / 8;
            double d = (this.hlN[dayIdx] * 3.141592653589793d) / 180.0d;
            int cos = ((int) ((1.0d - Math.cos(d)) * ((double) i2))) + i2;
            int sin = ((int) ((1.0d - Math.sin(d)) * ((double) i2))) + i2;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(cos, sin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            setLayoutParams(marginLayoutParams);
        }
        this.hkz.setVisibility(i);
        super.setVisibility(i);
    }

    private int getDayIdx() {
        f fVar = new f();
        if (fVar.day <= 2) {
            return 0;
        }
        if (fVar.day <= 6) {
            return 1;
        }
        if (fVar.day <= 10) {
            return 2;
        }
        if (fVar.day <= 14) {
            return 3;
        }
        if (fVar.day <= 17) {
            return 4;
        }
        if (fVar.day <= 21) {
            return 5;
        }
        if (fVar.day <= 26) {
            return 6;
        }
        return 7;
    }
}
