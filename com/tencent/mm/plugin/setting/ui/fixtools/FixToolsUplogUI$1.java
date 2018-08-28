package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.sdk.platformtools.x;

class FixToolsUplogUI$1 implements OnDateSetListener {
    final /* synthetic */ long mPx;
    final /* synthetic */ FixToolsUplogUI mPy;
    final /* synthetic */ int val$id;

    FixToolsUplogUI$1(FixToolsUplogUI fixToolsUplogUI, int i, long j) {
        this.mPy = fixToolsUplogUI;
        this.val$id = i;
        this.mPx = j;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        switch (this.val$id) {
            case 1:
                FixToolsUplogUI.a(this.mPy).setText(new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i3)})));
                FixToolsUplogUI.KV(new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)})).toString());
                x.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", new Object[]{Long.valueOf(this.mPx), FixToolsUplogUI.bP()});
                return;
            default:
                return;
        }
    }
}
