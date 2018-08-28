package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.wallet_core.ui.formview.b.1;
import java.text.DecimalFormat;
import java.util.Locale;

class b$1$1 implements a {
    final /* synthetic */ com.tencent.mm.ui.widget.picker.a pPJ;
    final /* synthetic */ 1 uZx;

    b$1$1(1 1, com.tencent.mm.ui.widget.picker.a aVar) {
        this.uZx = 1;
        this.pPJ = aVar;
    }

    public final void a(boolean z, int i, int i2, int i3) {
        this.pPJ.hide();
        if (z) {
            String format;
            com.tencent.mm.ui.widget.picker.a aVar = this.pPJ;
            if (aVar.uLd != null) {
                CustomDatePicker customDatePicker = aVar.uLd;
                if (customDatePicker.gML) {
                    format = String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(customDatePicker.getYear()), Integer.valueOf(customDatePicker.getMonth()), Integer.valueOf(customDatePicker.getDayOfMonth())});
                } else if (customDatePicker.gMK) {
                    format = String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(customDatePicker.getYear()), Integer.valueOf(customDatePicker.getMonth())});
                } else {
                    format = String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(customDatePicker.getYear())});
                }
            } else {
                format = null;
            }
            if (!bi.oW(format)) {
                String[] split = format.split("-");
                if (split.length >= 2) {
                    x.d("MicroMsg.FormatViewUtil", "result: %s", new Object[]{format});
                    int WU = bi.WU(split[0]);
                    this.uZx.uZw = bi.WU(split[1]) - 1;
                    x.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", new Object[]{Integer.valueOf(WU), Integer.valueOf(this.uZx.uZw)});
                    if (WU >= b.uYB || this.uZx.uZw >= b.uYC) {
                        DecimalFormat decimalFormat = new DecimalFormat("00");
                        if (q.GS()) {
                            this.uZx.uZj.setTag(decimalFormat.format((long) (this.uZx.uZw + 1)) + WU);
                        } else {
                            this.uZx.uZj.setTag(decimalFormat.format((long) WU).substring(2) + decimalFormat.format((long) (this.uZx.uZw + 1)));
                        }
                        this.uZx.uZj.setText(decimalFormat.format((long) (this.uZx.uZw + 1)) + decimalFormat.format((long) WU).substring(2));
                    } else {
                        h.b(this.uZx.ixt, this.uZx.ixt.getString(i.wallet_err_expired_date), null, true);
                    }
                    if (this.uZx.uZj.getInputValidChangeListener() != null) {
                        this.uZx.uZj.getInputValidChangeListener().fE(this.uZx.uZj.ZF());
                    }
                }
            }
        }
    }
}
