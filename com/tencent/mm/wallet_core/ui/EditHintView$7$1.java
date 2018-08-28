package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.EditHintView.7;
import java.text.DecimalFormat;

class EditHintView$7$1 implements OnDateSetListener {
    final /* synthetic */ 7 uYG;

    EditHintView$7$1(7 7) {
        this.uYG = 7;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= this.uYG.uYF.uYB || i2 >= this.uYG.uYF.uYC) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            if (q.GS()) {
                this.uYG.uYF.uYz = decimalFormat.format((long) (i2 + 1)) + i;
            } else {
                this.uYG.uYF.uYz = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
            }
            this.uYG.uYF.uYu.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
        } else {
            h.b(this.uYG.uYF.getContext(), this.uYG.uYF.getContext().getString(i.wallet_err_expired_date), null, true);
        }
        this.uYG.uYF.eYL = this.uYG.uYF.ZF();
        if (this.uYG.uYF.uYs != null) {
            x.d("MicroMsg.EditHintView", "View:" + this.uYG.uYF.eYG + ", editType:" + this.uYG.uYF.eYH + " inputValid change to " + this.uYG.uYF.eYL);
        }
    }
}
