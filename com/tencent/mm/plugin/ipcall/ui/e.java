package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;

public final class e {
    ListView ktV;
    h ktW;
    View ktX;
    IPCallAddressUI ktY;
    boolean ktZ = false;
    TextView kua = null;
    TextView kub = null;
    LinearLayout kuc = null;
    TextView kud = null;
    ImageView kue = null;

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.ktV = listView;
        this.ktY = iPCallAddressUI;
        this.ktX = view;
    }

    public final void aYd() {
        ah.A(new 6(this));
    }

    public final void aYe() {
        ah.A(new 7(this));
    }
}
