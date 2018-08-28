package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import com.tencent.mm.w.a.k;

public final class d extends DatePickerDialog {
    private boolean uGa;
    private long uGb;
    private int uGc;

    public d(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.uGa = true;
        this.uGa = true;
        this.uGb = j;
        this.uGc = 1;
    }

    public d(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, byte b) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.uGa = true;
        this.uGa = true;
        this.uGb = j;
        this.uGc = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        super.show();
        if (this.uGa) {
            View o;
            if (VERSION.SDK_INT >= 11) {
                o = new a(this).o((ViewGroup) getWindow().getDecorView());
                if (o != null && this.uGc > 1) {
                    o.setVisibility(8);
                }
            } else {
                Object string = System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i = 0;
                } else if (!("mm/dd/yyyy".equals(string) || "mm-dd-yyyy".equals(string))) {
                    i = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (i != -1) {
                    o = new b(this).f((ViewGroup) getWindow().getDecorView(), i);
                    if (o != null) {
                        o.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            fk(year, i);
        }
        this.uGa = false;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        super.onDateChanged(datePicker, i, i2, i3);
        fk(i, i2);
    }

    private void fk(int i, int i2) {
        if (this.uGc > 1) {
            setTitle(getContext().getString(k.fmt_year_month_str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
    }

    public final void gP(long j) {
        getDatePicker().setMaxDate(j);
    }

    public final void gQ(long j) {
        getDatePicker().setMinDate(j);
    }
}
