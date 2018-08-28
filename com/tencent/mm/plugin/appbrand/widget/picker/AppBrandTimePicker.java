package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.ui.widget.picker.e;
import java.util.Locale;

public final class AppBrandTimePicker extends TimePicker implements e<String> {
    public int fXv = -1;
    public int fXw = -1;
    public int fXx = -1;
    public int fXy = -1;
    public NumberPicker gNn;
    private NumberPicker gNo;

    public final /* synthetic */ Object aqq() {
        return String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, k.Widget_AppBrand_Picker));
        setIs24HourView(Boolean.valueOf(true));
        this.gNn = wm("mHourSpinner");
        this.gNo = wm("mMinuteSpinner");
        e.c(this.gNn);
        e.c(this.gNo);
        f.a(this.gNn);
        f.a(this.gNo);
        Drawable drawable = getResources().getDrawable(f.appbrand_picker_divider);
        e.a(this.gNn, drawable);
        e.a(this.gNo, drawable);
        if (this.gNn != null) {
            this.gNn.setOnValueChangedListener(new 1(this));
        }
        if (this.gNo != null && VERSION.SDK_INT >= 21) {
            this.gNo.setOnValueChangedListener(new 2(this));
        }
        e.e(this.gNn);
        e.e(this.gNo);
    }

    /* renamed from: aqt */
    public final void a() {
        if (com.tencent.mm.ui.widget.picker.f.GF(this.fXv) && com.tencent.mm.ui.widget.picker.f.GE(this.fXw) && this.gNn != null && this.gNo != null) {
            if (this.gNn.getValue() == this.fXv) {
                this.gNo.setMinValue(this.fXw);
            } else {
                this.gNo.setMinValue(0);
            }
        }
        if (com.tencent.mm.ui.widget.picker.f.GF(this.fXx) && this.gNn != null && this.gNo != null) {
            if (this.gNn.getValue() == this.fXx) {
                this.gNo.setMaxValue(this.fXy);
            } else {
                this.gNo.setMaxValue(59);
            }
        }
    }

    public final void setCurrentMinute(Integer num) {
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        a();
    }

    public final void setCurrentHour(Integer num) {
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        a();
    }

    private NumberPicker wm(String str) {
        if (VERSION.SDK_INT >= 21) {
            return wo(str);
        }
        return wn(str);
    }

    private NumberPicker wn(String str) {
        try {
            return (NumberPicker) new c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker wo(String str) {
        try {
            Object obj = new c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.d(this.gNn);
        e.d(this.gNo);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aqo() {
    }

    public final void b(d dVar) {
    }

    public final void aqp() {
    }
}
