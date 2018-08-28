package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;
import com.tencent.mm.ui.y;

public class DatePickerDialogView extends LinearLayout implements OnClickListener {
    private CollectRadioBtnView hZe;
    private CollectRadioBtnView hZf;
    private CollectRadioBtnView hZg;
    private MMSpinnerDatePicker hZh;
    private TextView hZi;
    private TextView hZj;
    private int hZk = 0;

    public DatePickerDialogView(Context context) {
        super(context);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = y.gq(context).inflate(g.collect_bill_datepicker_dialog_view, this);
        this.hZe = (CollectRadioBtnView) inflate.findViewById(f.year_btn);
        this.hZf = (CollectRadioBtnView) inflate.findViewById(f.month_btn);
        this.hZg = (CollectRadioBtnView) inflate.findViewById(f.day_btn);
        this.hZi = (TextView) inflate.findViewById(f.confirm_btn);
        this.hZj = (TextView) inflate.findViewById(f.cancel_btn);
        this.hZe.setOnClickListener(this);
        this.hZf.setOnClickListener(this);
        this.hZg.setOnClickListener(this);
        this.hZe.setTitleText("年");
        this.hZf.setTitleText("月");
        this.hZg.setTitleText("日");
        this.hZh = (MMSpinnerDatePicker) inflate.findViewById(f.datepicker);
        this.hZh.Gm(c.transparent);
        this.hZh.setTextSize(d.NormalTextSize);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.year_btn) {
            this.hZk = 2;
        } else if (id == f.month_btn) {
            this.hZk = 1;
        } else if (id == f.day_btn) {
            this.hZk = 0;
        } else {
            x.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[]{view.getClass().toString()});
        }
        aCA();
    }

    private void aCA() {
        if (this.hZk == 2) {
            this.hZe.setRadioSrc(h.radio_on);
            this.hZf.setRadioSrc(h.radio_off);
            this.hZg.setRadioSrc(h.radio_off);
        } else if (this.hZk == 1) {
            this.hZe.setRadioSrc(h.radio_off);
            this.hZf.setRadioSrc(h.radio_on);
            this.hZg.setRadioSrc(h.radio_off);
        } else {
            this.hZe.setRadioSrc(h.radio_off);
            this.hZf.setRadioSrc(h.radio_off);
            this.hZg.setRadioSrc(h.radio_on);
        }
        this.hZh.setPickerMode(this.hZk);
    }

    public void setDatePickerMode(int i) {
        this.hZk = i;
        aCA();
    }

    public void setOnOkBtnClickListener(OnClickListener onClickListener) {
        this.hZi.setOnClickListener(onClickListener);
    }

    public void setOnCancelBtnClickListener(OnClickListener onClickListener) {
        this.hZj.setOnClickListener(onClickListener);
    }

    public int getYear() {
        return this.hZh.getYear();
    }

    public int getMonth() {
        return this.hZh.getMonth();
    }

    public int getDayOfMonth() {
        return this.hZh.getDayOfMonth();
    }

    public int getDatePickerMode() {
        return this.hZh.getPickerMode();
    }
}
