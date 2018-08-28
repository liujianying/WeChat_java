package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mm.bw.a$f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.bw.a.k;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.picker.YADatePicker.SavedState;
import com.tencent.mm.ui.widget.picker.YADatePicker.a;
import com.tencent.mm.ui.widget.picker.YADatePicker.d;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class YADatePicker$c extends a {
    Calendar gMR;
    private String[] gMS;
    public final NumberPicker uLJ;
    public final NumberPicker uLK;
    public final NumberPicker uLL;
    private final LinearLayout uLM;
    private final EditText uLN;
    private final EditText uLO;
    private final EditText uLP;
    private final CalendarView uLQ;
    private final DateFormat uLR = new SimpleDateFormat("MM/dd/yyyy");
    private int uLS;
    private Calendar uLT;
    private Calendar uLU;
    Calendar uLV;
    private boolean uLW = true;

    public final /* bridge */ /* synthetic */ void setValidationCallback(YADatePicker$e yADatePicker$e) {
        super.setValidationCallback(yADatePicker$e);
    }

    static /* synthetic */ void a(YADatePicker$c yADatePicker$c) {
        InputMethodManager inputMethodManager = (InputMethodManager) yADatePicker$c.uLF.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        if (inputMethodManager.isActive(yADatePicker$c.uLP)) {
            yADatePicker$c.uLP.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.uLF.getWindowToken(), 0);
        } else if (inputMethodManager.isActive(yADatePicker$c.uLO)) {
            yADatePicker$c.uLO.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.uLF.getWindowToken(), 0);
        } else if (inputMethodManager.isActive(yADatePicker$c.uLN)) {
            yADatePicker$c.uLN.clearFocus();
            inputMethodManager.hideSoftInputFromWindow(yADatePicker$c.uLF.getWindowToken(), 0);
        }
    }

    static /* synthetic */ void b(YADatePicker$c yADatePicker$c) {
        yADatePicker$c.uLF.sendAccessibilityEvent(4);
        if (yADatePicker$c.uLH != null) {
            yADatePicker$c.getYear();
            yADatePicker$c.getMonth();
            yADatePicker$c.getDayOfMonth();
        }
    }

    YADatePicker$c(YADatePicker yADatePicker, Context context, AttributeSet attributeSet, int i) {
        super(yADatePicker, context);
        this.uLF = yADatePicker;
        this.mContext = context;
        e(Locale.getDefault());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.DatePicker, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(k.DatePicker_spinnersShown, true);
        boolean z2 = obtainStyledAttributes.getBoolean(k.DatePicker_calendarViewShown, true);
        int i2 = obtainStyledAttributes.getInt(k.DatePicker_startYear, 1900);
        int i3 = obtainStyledAttributes.getInt(k.DatePicker_endYear, 2100);
        String string = obtainStyledAttributes.getString(k.DatePicker_minDate);
        String string2 = obtainStyledAttributes.getString(k.DatePicker_maxDate);
        int resourceId = obtainStyledAttributes.getResourceId(k.DatePicker_legacyLayout, g.date_picker_legacy);
        obtainStyledAttributes.recycle();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(resourceId, this.uLF, true);
        1 1 = new 1(this);
        this.uLM = (LinearLayout) this.uLF.findViewById(a$f.pickers);
        this.uLQ = (CalendarView) this.uLF.findViewById(a$f.calendar_view);
        this.uLQ.setOnDateChangeListener(new OnDateChangeListener() {
            public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                YADatePicker$c.this.ar(i, i2, i3);
                YADatePicker$c.this.cAW();
                YADatePicker$c.b(YADatePicker$c.this);
            }
        });
        this.uLJ = (NumberPicker) this.uLF.findViewById(a$f.day);
        this.uLJ.setFormatter(new g());
        this.uLJ.setOnLongPressUpdateInterval(100);
        this.uLJ.setOnValueChangedListener(1);
        this.uLN = e.b(this.uLJ);
        this.uLK = (NumberPicker) this.uLF.findViewById(a$f.month);
        this.uLK.setMinValue(0);
        this.uLK.setMaxValue(this.uLS - 1);
        this.uLK.setDisplayedValues(this.gMS);
        this.uLK.setOnLongPressUpdateInterval(200);
        this.uLK.setOnValueChangedListener(1);
        this.uLO = e.b(this.uLK);
        this.uLL = (NumberPicker) this.uLF.findViewById(a$f.year);
        this.uLL.setOnLongPressUpdateInterval(100);
        this.uLL.setOnValueChangedListener(1);
        this.uLP = e.b(this.uLL);
        if (z || z2) {
            setSpinnersShown(z);
            setCalendarViewShown(z2);
        } else {
            setSpinnersShown(true);
        }
        this.gMR.clear();
        if (TextUtils.isEmpty(string) || !a(string, this.gMR)) {
            this.gMR.set(i2, 0, 1);
        }
        setMinDate(this.gMR.getTimeInMillis());
        this.gMR.clear();
        if (TextUtils.isEmpty(string2) || !a(string2, this.gMR)) {
            this.gMR.set(i3, 11, 31);
        }
        setMaxDate(this.gMR.getTimeInMillis());
        this.uLV.setTimeInMillis(System.currentTimeMillis());
        a(this.uLV.get(1), this.uLV.get(2), this.uLV.get(5), null);
        cAV();
        if (this.uLF.getImportantForAccessibility() == 0) {
            this.uLF.setImportantForAccessibility(1);
        }
    }

    public final void a(int i, int i2, int i3, d dVar) {
        ar(i, i2, i3);
        cAW();
        cAX();
        this.uLH = dVar;
    }

    public final int getYear() {
        return this.uLV.get(1);
    }

    public final int getMonth() {
        return this.uLV.get(2);
    }

    public final int getDayOfMonth() {
        return this.uLV.get(5);
    }

    public final int getFirstDayOfWeek() {
        return this.uLQ.getFirstDayOfWeek();
    }

    public final void setFirstDayOfWeek(int i) {
        this.uLQ.setFirstDayOfWeek(i);
    }

    public final Calendar cAS() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.uLQ.getMinDate());
        return instance;
    }

    public final void setMinDate(long j) {
        this.gMR.setTimeInMillis(j);
        if (this.gMR.get(1) != this.uLT.get(1) || this.gMR.get(6) == this.uLT.get(6)) {
            this.uLT.setTimeInMillis(j);
            this.uLQ.setMinDate(j);
            if (this.uLV.before(this.uLT)) {
                this.uLV.setTimeInMillis(this.uLT.getTimeInMillis());
                cAX();
            }
            cAW();
        }
    }

    public final Calendar cAT() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.uLQ.getMaxDate());
        return instance;
    }

    public final void setMaxDate(long j) {
        this.gMR.setTimeInMillis(j);
        if (this.gMR.get(1) != this.uLU.get(1) || this.gMR.get(6) == this.uLU.get(6)) {
            this.uLU.setTimeInMillis(j);
            this.uLQ.setMaxDate(j);
            if (this.uLV.after(this.uLU)) {
                this.uLV.setTimeInMillis(this.uLU.getTimeInMillis());
                cAX();
            }
            cAW();
        }
    }

    public final boolean isEnabled() {
        return this.uLW;
    }

    public final void setEnabled(boolean z) {
        this.uLJ.setEnabled(z);
        this.uLK.setEnabled(z);
        this.uLL.setEnabled(z);
        this.uLQ.setEnabled(z);
        this.uLW = z;
    }

    public final CalendarView getCalendarView() {
        return this.uLQ;
    }

    public final boolean getCalendarViewShown() {
        return this.uLQ.getVisibility() == 0;
    }

    public final void setCalendarViewShown(boolean z) {
        this.uLQ.setVisibility(z ? 0 : 8);
    }

    public final boolean getSpinnersShown() {
        return this.uLM.isShown();
    }

    public final void setSpinnersShown(boolean z) {
        this.uLM.setVisibility(z ? 0 : 8);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        e(configuration.locale);
    }

    public final Parcelable d(Parcelable parcelable) {
        return new SavedState(parcelable, getYear(), getMonth(), getDayOfMonth(), (byte) 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        ar(SavedState.a(savedState), SavedState.b(savedState), SavedState.c(savedState));
        cAW();
        cAX();
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.uLV.getTimeInMillis(), 20));
    }

    protected final void e(Locale locale) {
        super.e(locale);
        this.gMR = a(this.gMR, locale);
        this.uLT = a(this.uLT, locale);
        this.uLU = a(this.uLU, locale);
        this.uLV = a(this.uLV, locale);
        this.uLS = this.gMR.getActualMaximum(2) + 1;
        this.gMS = new DateFormatSymbols().getShortMonths();
        if (cAU()) {
            this.gMS = new String[this.uLS];
            for (int i = 0; i < this.uLS; i++) {
                this.gMS[i] = String.format("%d", new Object[]{Integer.valueOf(i + 1)});
            }
        }
    }

    private boolean cAU() {
        return Character.isDigit(this.gMS[0].charAt(0));
    }

    private static Calendar a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar instance = Calendar.getInstance(locale);
        instance.setTimeInMillis(timeInMillis);
        return instance;
    }

    private void cAV() {
        char[] cArr;
        this.uLM.removeAllViews();
        if (VERSION.SDK_INT < 17 || this.uLF.getLayoutDirection() == 0) {
            cArr = new char[]{'y', 'M', 'd'};
        } else {
            cArr = android.text.format.DateFormat.getDateFormatOrder(this.uLF.getContext());
        }
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            switch (cArr[i]) {
                case 'M':
                    this.uLM.addView(this.uLK);
                    a(this.uLK, length, i);
                    break;
                case 'd':
                    this.uLM.addView(this.uLJ);
                    a(this.uLJ, length, i);
                    break;
                case 'y':
                    this.uLM.addView(this.uLL);
                    a(this.uLL, length, i);
                    break;
                default:
                    throw new IllegalArgumentException(Arrays.toString(cArr));
            }
        }
    }

    private boolean a(String str, Calendar calendar) {
        try {
            calendar.setTime(this.uLR.parse(str));
            return true;
        } catch (ParseException e) {
            YADatePicker.uD();
            ao.u("Date: " + str + " not in format: MM/dd/yyyy", new Object[0]);
            return false;
        }
    }

    final void ar(int i, int i2, int i3) {
        this.uLV.set(i, i2, i3);
        if (this.uLV.before(this.uLT)) {
            this.uLV.setTimeInMillis(this.uLT.getTimeInMillis());
        } else if (this.uLV.after(this.uLU)) {
            this.uLV.setTimeInMillis(this.uLU.getTimeInMillis());
        }
    }

    final void cAW() {
        if (this.uLV.equals(this.uLT)) {
            this.uLJ.setMinValue(this.uLV.get(5));
            this.uLJ.setMaxValue(this.uLV.getActualMaximum(5));
            this.uLJ.setWrapSelectorWheel(false);
            this.uLK.setDisplayedValues(null);
            this.uLK.setMinValue(this.uLV.get(2));
            this.uLK.setMaxValue(this.uLV.getActualMaximum(2));
            this.uLK.setWrapSelectorWheel(false);
        } else if (this.uLV.equals(this.uLU)) {
            this.uLJ.setMinValue(this.uLV.getActualMinimum(5));
            this.uLJ.setMaxValue(this.uLV.get(5));
            this.uLJ.setWrapSelectorWheel(false);
            this.uLK.setDisplayedValues(null);
            this.uLK.setMinValue(this.uLV.getActualMinimum(2));
            this.uLK.setMaxValue(this.uLV.get(2));
            this.uLK.setWrapSelectorWheel(false);
        } else {
            this.uLJ.setMinValue(1);
            this.uLJ.setMaxValue(this.uLV.getActualMaximum(5));
            this.uLJ.setWrapSelectorWheel(true);
            this.uLK.setDisplayedValues(null);
            this.uLK.setMinValue(0);
            this.uLK.setMaxValue(11);
            this.uLK.setWrapSelectorWheel(true);
        }
        this.uLK.setDisplayedValues((String[]) Arrays.copyOfRange(this.gMS, this.uLK.getMinValue(), this.uLK.getMaxValue() + 1));
        this.uLL.setMinValue(this.uLT.get(1));
        this.uLL.setMaxValue(this.uLU.get(1));
        this.uLL.setWrapSelectorWheel(false);
        this.uLL.setValue(this.uLV.get(1));
        this.uLK.setValue(this.uLV.get(2));
        this.uLJ.setValue(this.uLV.get(5));
        if (cAU()) {
            this.uLO.setRawInputType(2);
        }
    }

    final void cAX() {
        this.uLQ.setDate(this.uLV.getTimeInMillis(), false, false);
    }

    private static void a(NumberPicker numberPicker, int i, int i2) {
        int i3;
        if (i2 < i - 1) {
            i3 = 5;
        } else {
            i3 = 6;
        }
        TextView b = e.b(numberPicker);
        if (b != null) {
            b.setImeOptions(i3);
        }
    }
}
