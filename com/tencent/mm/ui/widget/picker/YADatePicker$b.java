package com.tencent.mm.ui.widget.picker;

import android.content.res.Configuration;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.util.Calendar;

public interface YADatePicker$b {
    void a(int i, int i2, int i3, d dVar);

    Calendar cAS();

    Calendar cAT();

    Parcelable d(Parcelable parcelable);

    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    CalendarView getCalendarView();

    boolean getCalendarViewShown();

    int getDayOfMonth();

    int getFirstDayOfWeek();

    int getMonth();

    boolean getSpinnersShown();

    int getYear();

    boolean isEnabled();

    void onConfigurationChanged(Configuration configuration);

    void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    void onRestoreInstanceState(Parcelable parcelable);

    void setCalendarViewShown(boolean z);

    void setEnabled(boolean z);

    void setFirstDayOfWeek(int i);

    void setMaxDate(long j);

    void setMinDate(long j);

    void setSpinnersShown(boolean z);

    void setValidationCallback(YADatePicker$e yADatePicker$e);
}
