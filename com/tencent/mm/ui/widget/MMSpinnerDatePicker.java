package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker extends DatePicker implements OnDateChangedListener {
    private NumberPicker uGA;
    private NumberPicker uGB;
    private NumberPicker uGC;
    private a uGD;
    private int uGE = 0;

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setCalendarViewShown(false);
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("year", "id", "android");
        int identifier2 = system.getIdentifier("month", "id", "android");
        int identifier3 = system.getIdentifier("day", "id", "android");
        this.uGA = (NumberPicker) findViewById(identifier);
        this.uGB = (NumberPicker) findViewById(identifier2);
        this.uGC = (NumberPicker) findViewById(identifier3);
        View childAt = getChildAt(0);
        LayoutParams layoutParams = childAt.getLayoutParams();
        layoutParams.width = -1;
        childAt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.uGA.getLayoutParams();
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        layoutParams2.weight = 1.0f;
        this.uGA.setLayoutParams(layoutParams2);
        this.uGB.setLayoutParams(layoutParams2);
        this.uGC.setLayoutParams(layoutParams2);
        setDescendantFocusability(393216);
        setPickerMode(2);
    }

    public void setPickerMode(int i) {
        this.uGE = i;
        if (this.uGE == 0) {
            this.uGA.setVisibility(0);
            this.uGB.setVisibility(0);
            this.uGC.setVisibility(0);
        } else if (this.uGE == 1) {
            this.uGA.setVisibility(0);
            this.uGB.setVisibility(0);
            this.uGC.setVisibility(8);
        } else {
            this.uGA.setVisibility(0);
            this.uGB.setVisibility(8);
            this.uGC.setVisibility(8);
        }
    }

    public int getPickerMode() {
        return this.uGE;
    }

    public void setOnDateChangeListener(a aVar) {
        this.uGD = aVar;
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    public final boolean Gm(int i) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(getResources().getColor(i));
            declaredField.set(this.uGA, colorDrawable);
            declaredField.set(this.uGB, colorDrawable);
            declaredField.set(this.uGC, colorDrawable);
            invalidate();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
        }
        return false;
    }

    public void setTextSize(int i) {
        a(this.uGA, i);
        a(this.uGB, i);
        a(this.uGC, i);
    }

    private void a(NumberPicker numberPicker, int i) {
        if (numberPicker != null) {
            EditText editText = (EditText) numberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"));
            editText.setTextSize(0, getResources().getDimension(i));
            int textSize = (int) editText.getTextSize();
            try {
                Field declaredField = NumberPicker.class.getDeclaredField("mTextSize");
                declaredField.setAccessible(true);
                declaredField.set(numberPicker, Integer.valueOf(textSize));
                Field declaredField2 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
                declaredField2.setAccessible(true);
                Paint paint = (Paint) declaredField2.get(numberPicker);
                paint.setTextSize((float) textSize);
                declaredField2.set(numberPicker, paint);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            }
        }
    }
}
