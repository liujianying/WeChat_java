package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.mm.bw.a$e;
import com.tencent.mm.bw.a.j;
import com.tencent.mm.ui.aj;

public class CustomTimePicker extends TimePicker {
    public int fXv = -1;
    public int fXw = -1;
    public int fXx = -1;
    public int fXy = -1;
    public NumberPicker gNn;
    private NumberPicker gNo;

    public CustomTimePicker(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, j.Widget_Picker), attributeSet);
        initView();
    }

    public CustomTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setIs24HourView(Boolean.valueOf(true));
        this.gNn = wm("mHourSpinner");
        this.gNo = wm("mMinuteSpinner");
        e.c(this.gNn);
        e.c(this.gNo);
        Drawable drawable = getResources().getDrawable(a$e.picker_divider);
        e.a(this.gNn, drawable);
        e.a(this.gNo, drawable);
        if (this.gNn != null) {
            this.gNn.setOnValueChangedListener(new 1(this));
        }
        if (this.gNo != null && VERSION.SDK_INT >= 21) {
            this.gNo.setOnValueChangedListener(new 2(this));
        }
        e.e(this.gNn);
        e.e(this.gNo);
    }

    /* renamed from: aqt */
    public final void a() {
        if (f.GF(this.fXv) && f.GE(this.fXw) && this.gNn != null && this.gNo != null) {
            if (this.gNn.getValue() == this.fXv) {
                this.gNo.setMinValue(this.fXw);
            } else {
                this.gNo.setMinValue(0);
            }
        }
        if (f.GF(this.fXx) && this.gNn != null && this.gNo != null) {
            if (this.gNn.getValue() == this.fXx) {
                this.gNo.setMaxValue(this.fXy);
            } else {
                this.gNo.setMaxValue(59);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.d(this.gNn);
        e.d(this.gNo);
    }

    private NumberPicker wm(String str) {
        if (VERSION.SDK_INT >= 21) {
            return wo(str);
        }
        return wn(str);
    }

    private NumberPicker wn(String str) {
        try {
            return (NumberPicker) new aj(this, str).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker wo(String str) {
        try {
            Object obj = new aj(this, "mDelegate").get();
            if (obj != null) {
                return (NumberPicker) new aj(obj, str).get();
            }
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return null;
    }
}
