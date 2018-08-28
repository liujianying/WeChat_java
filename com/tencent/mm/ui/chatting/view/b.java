package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b {
    private Button eGn;
    private Button haQ;
    private View ilW;
    Context mContext;
    OptionPicker tYX;
    OptionPicker tYY;
    c tYZ;
    private int tZa;
    private BottomSheetBehavior tZb;
    public a tZc;
    ArrayList<Long> tZd = new ArrayList(42);

    public b(Context context) {
        this.mContext = context;
        this.ilW = View.inflate(this.mContext, R.i.remind_date_picker_panel, null);
        this.tYZ = new c(this.mContext);
        this.tYZ.setContentView(this.ilW);
        this.tYZ.setOnDismissListener(new 1(this));
        this.tYX = (OptionPicker) this.ilW.findViewById(R.h.option_first_picker);
        this.tYY = (OptionPicker) this.ilW.findViewById(R.h.option_second_picker);
        this.tYX.setValue(0);
        this.tYX.setMinWidth(a.fromDPToPix(this.mContext, 60));
        this.tYY.setMinWidth(a.fromDPToPix(this.mContext, 60));
        this.tYX.setOptionsArray(cxL());
        this.tYY.setOptionsArray(FK(0));
        this.tYX.setOnValueChangedListener(new 2(this));
        LayoutParams layoutParams = (LayoutParams) this.ilW.getLayoutParams();
        layoutParams.height = a.fromDPToPix(this.mContext, 288);
        this.ilW.setLayoutParams(layoutParams);
        this.tZa = a.fromDPToPix(this.mContext, 350);
        this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
        if (this.tZb != null) {
            this.tZb.q(this.tZa);
            this.tZb.cv = false;
        }
        this.eGn = (Button) this.ilW.findViewById(f.ok_btn);
        this.eGn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.tZc != null) {
                    a aVar = b.this.tZc;
                    b bVar = b.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    int value = bVar.tYX.getValue();
                    int value2 = bVar.tYY.getValue();
                    currentTimeMillis = value == 0 ? com.tencent.mm.sdk.a.b.chp() ? currentTimeMillis + 360000 : currentTimeMillis + (((long) (value2 + 1)) * 3600000) : ((Long) bVar.tZd.get(value)).longValue() + (((long) (value2 + 1)) * 3600000);
                    String h = h.h(bVar.mContext.getString(R.l.fmt_longdate_with_full) + "HH:mm", currentTimeMillis / 1000);
                    x.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[]{h});
                    aVar.gx(currentTimeMillis);
                }
            }
        });
        this.haQ = (Button) this.ilW.findViewById(f.cancel_btn);
        this.haQ.setOnClickListener(new 4(this));
    }

    public final void show() {
        if (this.tYZ != null) {
            this.tYZ.show();
        }
    }

    public final void hide() {
        if (this.tYZ != null) {
            this.tYZ.dismiss();
        }
    }

    final String[] FK(int i) {
        int i2;
        int i3 = 1;
        Object arrayList = new ArrayList();
        if (com.tencent.mm.sdk.a.b.chp()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        switch (i - i2) {
            case -1:
                arrayList.add("after 6 min");
                break;
            case 0:
                int i4 = Calendar.getInstance().get(11);
                for (i2 = 1; i2 <= 24 - i4; i2++) {
                    arrayList.add(this.mContext.getResources().getString(R.l.after_time_remind, new Object[]{Integer.valueOf(i2)}));
                }
                break;
            default:
                while (true) {
                    i2 = i3;
                    if (i2 > 24) {
                        break;
                    }
                    arrayList.add((i2 < 10 ? "0" + i2 : Integer.valueOf(i2)) + ":00");
                    i3 = i2 + 1;
                }
        }
        return bi.cW(arrayList);
    }

    private String[] cxL() {
        int i = 0;
        this.tZd.clear();
        List arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        int i2 = 0;
        while (i2 < instance.getActualMaximum(5)) {
            if (com.tencent.mm.sdk.a.b.chp() && i2 == 0) {
                arrayList.add("test");
                this.tZd.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                this.tZd.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.tZd.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String h = h.h(this.mContext.getString(R.l.fmt_date), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(R.l.fmt_pre_nowday));
            } else if (i2 == 1) {
                arrayList.add(h + " " + this.mContext.getResources().getString(R.l.fmt_pre_tomorrow));
            } else if (i2 == 2) {
                arrayList.add(h + " " + this.mContext.getResources().getString(R.l.fmt_pre_dayaftertomorrow));
            } else {
                arrayList.add(h + " " + h.W(this.mContext, instance.get(7)));
            }
            i2++;
        }
        i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        while (i < 12) {
            if (i3 + i > 12) {
                instance.set(1, i2 + 1);
                instance.set(2, (i3 + i) - 12);
            } else {
                instance.set(2, i3 + i);
            }
            instance.set(5, 1);
            this.tZd.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(h.h(this.mContext.getString(R.l.fmt_longdate_with_full), instance.getTimeInMillis() / 1000)));
            i++;
        }
        return bi.cW(arrayList);
    }
}
