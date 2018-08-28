package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class LaunchAAUI$5 implements TextWatcher {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$5(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 6) {
            editable.delete(6, indexOf);
        } else if (indexOf == -1 && length > 6) {
            editable.delete(6, length);
        }
        double d = bi.getDouble(editable.toString(), 0.0d);
        if (LaunchAAUI.f(this.eDS) != null && LaunchAAUI.f(this.eDS).size() > 0) {
            d = (d * 100.0d) / ((double) LaunchAAUI.f(this.eDS).size());
            LaunchAAUI.d(this.eDS);
            if (d > ((double) d.VW())) {
                LaunchAAUI.a(this.eDS, true);
                h.mEJ.h(13722, new Object[]{Integer.valueOf(2)});
                LaunchAAUI.c(this.eDS);
                LaunchAAUI.g(this.eDS);
                LaunchAAUI.h(this.eDS);
            }
        }
        LaunchAAUI.a(this.eDS, false);
        LaunchAAUI.c(this.eDS);
        LaunchAAUI.g(this.eDS);
        LaunchAAUI.h(this.eDS);
    }
}
