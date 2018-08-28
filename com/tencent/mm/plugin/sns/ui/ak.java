package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class ak {
    public String bKW;
    public ImageView nEI;
    public TextView nEJ;
    public bsu nRA;
    public View nRB;
    public View nRC;
    public MMPinProgressBtn nRD;
    public TextView nRE;
    public boolean nRF = false;
    public int nRG = 0;
    public a neL;
    public boolean nkG = false;
    public int position;

    public final void a(bsu bsu, int i, String str, boolean z) {
        this.nRA = bsu;
        this.position = i;
        this.bKW = str;
        this.nkG = z;
    }
}
