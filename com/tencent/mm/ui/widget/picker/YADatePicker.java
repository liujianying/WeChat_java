package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import com.tencent.mm.bw.a.b;
import com.tencent.mm.bw.a.k;

public class YADatePicker extends FrameLayout {
    private static final String BD = YADatePicker.class.getSimpleName();
    public final b uLE;

    public YADatePicker(Context context) {
        this(context, null);
    }

    public YADatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.datePickerStyle);
    }

    public YADatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uLE = new c(this, context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.DatePicker, i, 0);
        int i2 = obtainStyledAttributes.getInt(k.DatePicker_firstDayOfWeek, 0);
        obtainStyledAttributes.recycle();
        if (i2 != 0) {
            setFirstDayOfWeek(i2);
        }
    }

    @Keep
    public b getUIDelegate() {
        return this.uLE;
    }

    public void a(int i, int i2, int i3, d dVar) {
        this.uLE.a(i, i2, i3, dVar);
    }

    public int getYear() {
        return this.uLE.getYear();
    }

    public int getMonth() {
        return this.uLE.getMonth();
    }

    public int getDayOfMonth() {
        return this.uLE.getDayOfMonth();
    }

    public long getMinDate() {
        return this.uLE.cAS().getTimeInMillis();
    }

    public void setMinDate(long j) {
        this.uLE.setMinDate(j);
    }

    public long getMaxDate() {
        return this.uLE.cAT().getTimeInMillis();
    }

    public void setMaxDate(long j) {
        this.uLE.setMaxDate(j);
    }

    public void setValidationCallback(e eVar) {
        this.uLE.setValidationCallback(eVar);
    }

    public boolean isEnabled() {
        return this.uLE.isEnabled();
    }

    public void setEnabled(boolean z) {
        if (this.uLE.isEnabled() != z) {
            super.setEnabled(z);
            this.uLE.setEnabled(z);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.uLE.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        this.uLE.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public CharSequence getAccessibilityClassName() {
        return YADatePicker.class.getName();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.uLE.onConfigurationChanged(configuration);
    }

    public int getFirstDayOfWeek() {
        return this.uLE.getFirstDayOfWeek();
    }

    public void setFirstDayOfWeek(int i) {
        if (i <= 0 || i > 7) {
            throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
        }
        this.uLE.setFirstDayOfWeek(i);
    }

    public boolean getCalendarViewShown() {
        return this.uLE.getCalendarViewShown();
    }

    public void setCalendarViewShown(boolean z) {
        this.uLE.setCalendarViewShown(z);
    }

    public CalendarView getCalendarView() {
        return this.uLE.getCalendarView();
    }

    public boolean getSpinnersShown() {
        return this.uLE.getSpinnersShown();
    }

    public void setSpinnersShown(boolean z) {
        this.uLE.setSpinnersShown(z);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected Parcelable onSaveInstanceState() {
        return this.uLE.d(super.onSaveInstanceState());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        BaseSavedState baseSavedState = (BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.uLE.onRestoreInstanceState(baseSavedState);
    }
}
