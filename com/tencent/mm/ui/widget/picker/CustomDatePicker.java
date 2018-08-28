package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker extends YADatePicker {
    public boolean gMK = true;
    public boolean gML = true;
    NumberPicker gMM;
    NumberPicker gMN;
    NumberPicker gMO;
    private Date gMP;
    private Date gMQ;
    private Calendar gMR;
    private String[] gMS;

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.gMS = new String[12];
        for (int i = 0; i < this.gMS.length; i++) {
            this.gMS[i] = (i + 1);
        }
        this.gMR = Calendar.getInstance(Locale.US);
        setCalendarViewShown(false);
        setSpinnersShown(true);
        this.gMM = ((YADatePicker$c) getUIDelegate()).uLL;
        this.gMN = ((YADatePicker$c) getUIDelegate()).uLK;
        this.gMO = ((YADatePicker$c) getUIDelegate()).uLJ;
        Drawable drawable = getResources().getDrawable(e.picker_divider);
        e.a(this.gMM, drawable);
        e.a(this.gMN, drawable);
        e.a(this.gMO, drawable);
        e.c(this.gMM);
        e.c(this.gMN);
        e.c(this.gMO);
        1 1 = new 1(this);
        if (this.gMM != null) {
            this.gMM.setOnValueChangedListener(1);
            this.gMM.setMinValue(1900);
        }
        if (this.gMN != null) {
            this.gMN.setOnValueChangedListener(1);
        }
        if (this.gMO != null) {
            this.gMO.setOnValueChangedListener(1);
        }
        a();
        e.e(this.gMM);
        e.e(this.gMN);
        e.e(this.gMO);
    }

    /* renamed from: aqn */
    final void a() {
        int i = 0;
        if (this.gMM != null && this.gMN != null && this.gMO != null) {
            boolean z;
            this.gMN.setDisplayedValues(null);
            if (this.gMM.getValue() != this.gMM.getMaxValue() || this.gMQ == null) {
                this.gMN.setMaxValue(11);
                z = false;
            } else {
                this.gMN.setMaxValue(this.gMQ.getMonth());
                if (this.gMN.getValue() == this.gMN.getMaxValue() && this.gMQ != null) {
                    this.gMO.setMaxValue(this.gMQ.getDate());
                    z = true;
                }
                z = false;
            }
            if (!z) {
                this.gMR.set(this.gMM.getValue(), this.gMN.getValue(), 1);
                this.gMO.setMaxValue(this.gMR.getActualMaximum(5));
            }
            if (this.gMM.getValue() != this.gMM.getMinValue() || this.gMP == null) {
                this.gMN.setMinValue(0);
            } else {
                this.gMN.setMinValue(this.gMP.getMonth());
                if (this.gMN.getValue() == this.gMN.getMinValue() && this.gMP != null) {
                    this.gMO.setMinValue(this.gMP.getDate());
                    i = 1;
                }
            }
            if (i == 0) {
                this.gMO.setMinValue(1);
            }
            this.gMN.setDisplayedValues((String[]) Arrays.copyOfRange(this.gMS, this.gMN.getMinValue(), this.gMN.getMaxValue() + 1));
            this.gMM.setWrapSelectorWheel(true);
            this.gMN.setWrapSelectorWheel(true);
            this.gMO.setWrapSelectorWheel(true);
        }
    }

    public void setMaxDate(long j) {
        super.setMaxDate(j);
        this.gMQ = new Date(j);
        if (this.gMM != null) {
            this.gMM.setMaxValue(this.gMQ.getYear() + 1900);
        }
        a();
    }

    public void setMinDate(long j) {
        super.setMinDate(j);
        this.gMP = new Date(j);
        if (this.gMM != null) {
            this.gMM.setMinValue(this.gMP.getYear() + 1900);
        }
    }

    public final void an(int i, int i2, int i3) {
        a(i, i2, i3, null);
    }

    public final void a(int i, int i2, int i3, d dVar) {
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        a();
    }

    public int getYear() {
        if (this.gMM != null) {
            return this.gMM.getValue();
        }
        return super.getYear();
    }

    public int getMonth() {
        int value;
        if (this.gMN != null) {
            value = this.gMN.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        return Math.max(Math.min(value, 12), 0);
    }

    public int getDayOfMonth() {
        if (this.gMO != null) {
            return this.gMO.getValue();
        }
        return super.getDayOfMonth();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.d(this.gMM);
        e.d(this.gMN);
        e.d(this.gMO);
    }
}
