package com.tencent.mm.ui.chatting.view;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;

class b$2 implements OnValueChangeListener {
    final /* synthetic */ b tZe;

    b$2(b bVar) {
        this.tZe = bVar;
    }

    public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
        x.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.tZe.tYY.setOptionsArray(this.tZe.FK(i2));
        int i3 = Calendar.getInstance().get(11);
        if (i2 == 0) {
            this.tZe.tYY.setValue(0);
        } else {
            this.tZe.tYY.setValue(i3);
        }
    }
}
