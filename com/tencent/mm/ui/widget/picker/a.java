package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.NumberPicker;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ap;
import java.util.Calendar;
import java.util.Locale;

public final class a implements OnGlobalLayoutListener {
    private Button eGn = ((Button) this.ilW.findViewById(f.ok_btn));
    private Button haQ;
    private View ilW = View.inflate(this.mContext, g.date_picker_panel, null);
    private Context mContext;
    private c tYZ = new c(this.mContext);
    private int tZa;
    private BottomSheetBehavior tZb;
    public CustomDatePicker uLd = ((CustomDatePicker) this.ilW.findViewById(f.date_picker));
    public a uLe;

    static /* synthetic */ void a(a aVar, boolean z, int i, int i2, int i3) {
        if (aVar.uLe != null) {
            aVar.uLe.a(z, i, i2, i3);
        }
    }

    public a(Context context) {
        this.mContext = context;
        this.eGn.setOnClickListener(new 1(this));
        this.haQ = (Button) this.ilW.findViewById(f.cancel_btn);
        this.haQ.setOnClickListener(new 2(this));
        this.tYZ.setContentView(this.ilW);
        this.tZa = ap.fromDPToPix(this.mContext, 288);
        this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
        if (this.tZb != null) {
            this.tZb.q(this.tZa);
            this.tZb.cv = false;
        }
        this.tYZ.setOnDismissListener(new 3(this));
    }

    public final void onGlobalLayout() {
    }

    public final void ao(int i, int i2, int i3) {
        if (i >= 0 && i2 >= 0 && i3 >= 0 && this.uLd != null) {
            this.uLd.an(i, i2, i3);
        }
    }

    public final void Z(boolean z, boolean z2) {
        int i = 0;
        if (this.uLd != null) {
            CustomDatePicker customDatePicker = this.uLd;
            customDatePicker.gMK = z;
            customDatePicker.gML = z2;
            if (customDatePicker.gMM != null) {
                customDatePicker.gMM.setEnabled(true);
                customDatePicker.gMM.setVisibility(0);
            }
            if (customDatePicker.gMN != null) {
                int i2;
                customDatePicker.gMN.setEnabled(z);
                NumberPicker numberPicker = customDatePicker.gMN;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                numberPicker.setVisibility(i2);
            }
            if (customDatePicker.gMO != null) {
                customDatePicker.gMO.setEnabled(z2);
                NumberPicker numberPicker2 = customDatePicker.gMO;
                if (!z2) {
                    i = 8;
                }
                numberPicker2.setVisibility(i);
            }
        }
    }

    public final void ap(int i, int i2, int i3) {
        if (i >= 0 && i2 >= 0 && i3 >= 0) {
            Calendar instance = Calendar.getInstance(Locale.US);
            instance.set(i, i2 - 1, i3);
            if (this.uLd != null) {
                this.uLd.setMinDate(instance.getTimeInMillis());
            }
        }
    }

    public final void aq(int i, int i2, int i3) {
        if (i >= 0 && i2 >= 0 && i3 >= 0) {
            Calendar instance = Calendar.getInstance(Locale.US);
            instance.set(i, i2 - 1, i3);
            if (this.uLd != null) {
                this.uLd.setMaxDate(instance.getTimeInMillis());
            }
        }
    }

    public final void show() {
        if (this.tYZ != null) {
            if (this.uLd != null) {
                this.uLd.aqn();
            }
            this.tYZ.show();
        }
    }

    public final void hide() {
        if (this.tYZ != null) {
            this.tYZ.dismiss();
        }
    }
}
