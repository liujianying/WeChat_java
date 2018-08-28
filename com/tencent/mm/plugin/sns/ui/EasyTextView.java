package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class EasyTextView extends View {
    private static final Paint dvs = new Paint();
    private static int textSize = -1;
    private Context context;
    private String text = "";

    static {
        dvs.setAntiAlias(true);
        dvs.setFilterBitmap(true);
        dvs.setColor(737373);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        if (textSize == -1) {
            textSize = b.b(this.context, 12.0f);
            dvs.setTextSize((float) textSize);
        }
        dvs.setColor(this.context.getResources().getColor(c.black));
    }

    public void setTextSize(int i) {
        dvs.setTextSize((float) i);
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.text = str;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(this.text, 0.0f, (float) (getHeight() / 2), dvs);
    }
}
