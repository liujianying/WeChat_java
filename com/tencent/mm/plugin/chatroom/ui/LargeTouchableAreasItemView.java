package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int hMG = Color.argb(0, 0, 0, 0);
    private final Paint cN = new Paint();
    private boolean dnN;
    private final ArrayList<b> hMH = new ArrayList();
    private c hMI;
    private a hMJ;
    private int hMK;
    private int hML = -1;
    private int hMM = -1;
    private ImageButton hMN;

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.hMI = new c(this);
        this.cN.setStyle(Style.FILL);
        this.hMK = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.i.checkbox_large_touch_view, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.hMN = (ImageButton) findViewById(R.h.btn_select);
        this.hMN.setOnClickListener(new 1(this));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != this.hML || i6 != this.hMM) {
            this.hML = i5;
            this.hMM = i6;
            c cVar = this.hMI;
            if (cVar.hQy != null) {
                cVar.hQy.clear();
            }
            cVar.hQz = null;
            Rect rect = new Rect((i5 - this.hMN.getWidth()) - this.hMK, 0, i5, i6);
            i5 = hMG;
            View view = this.hMN;
            c cVar2 = this.hMI;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (cVar2.hQy == null) {
                cVar2.hQy = new ArrayList();
            }
            cVar2.hQy.add(touchDelegate);
            this.hMH.add(new b(rect, i5));
            setTouchDelegate(this.hMI);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Iterator it = this.hMH.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.cN.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.cN);
        }
        super.dispatchDraw(canvas);
    }

    public void setItemViewSelected(boolean z) {
        if (this.dnN != z) {
            this.dnN = z;
            this.hMN.setImageResource(this.dnN ? R.k.checkbox_selected : R.k.checkbox_unselected);
        }
    }

    public boolean getSelected() {
        return this.dnN;
    }

    public void setOnLargeTouchableAreasListener(a aVar) {
        this.hMJ = aVar;
    }
}
