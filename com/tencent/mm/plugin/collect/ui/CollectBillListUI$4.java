package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;

class CollectBillListUI$4 implements OnClickListener {
    final /* synthetic */ CollectBillListUI hXk;
    final /* synthetic */ DatePickerDialogView hXl;

    CollectBillListUI$4(CollectBillListUI collectBillListUI, DatePickerDialogView datePickerDialogView) {
        this.hXk = collectBillListUI;
        this.hXl = datePickerDialogView;
    }

    public final void onClick(View view) {
        long timeInMillis;
        if (CollectBillListUI.b(this.hXk) == null) {
            CollectBillListUI.a(this.hXk, Calendar.getInstance());
        }
        CollectBillListUI.b(this.hXk).clear();
        int year = this.hXl.getYear();
        int month = this.hXl.getMonth();
        int dayOfMonth = this.hXl.getDayOfMonth();
        CollectBillListUI.a(this.hXk, this.hXl.getDatePickerMode());
        if (CollectBillListUI.c(this.hXk) == 2) {
            CollectBillListUI.b(this.hXk).set(1, year);
            timeInMillis = CollectBillListUI.b(this.hXk).getTimeInMillis() / 1000;
        } else if (CollectBillListUI.c(this.hXk) == 1) {
            CollectBillListUI.b(this.hXk).set(1, year);
            CollectBillListUI.b(this.hXk).set(2, month);
            timeInMillis = CollectBillListUI.b(this.hXk).getTimeInMillis() / 1000;
        } else {
            CollectBillListUI.b(this.hXk).set(year, month, dayOfMonth);
            timeInMillis = CollectBillListUI.b(this.hXk).getTimeInMillis() / 1000;
        }
        x.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(CollectBillListUI.c(this.hXk)), Long.valueOf(timeInMillis)});
        CollectBillListUI.a(this.hXk, timeInMillis);
        CollectBillListUI.d(this.hXk).dismiss();
    }
}
