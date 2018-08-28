package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter {
    public int hou;
    public int jZk;
    public Context mContext;
    public int uSC;
    public int uSE;
    public com.tencent.mm.view.f.a uSM;
    public int uTG;
    public int uTH;
    public String uTI;
    public int uTJ;

    public a(Context context, com.tencent.mm.view.f.a aVar) {
        this.mContext = context;
        this.uSM = aVar;
    }

    public final void c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.uSC = i;
        this.hou = i2;
        this.uTG = i3;
        this.uSE = i4;
        this.uTH = i5;
        this.uTJ = i6;
        this.jZk = i7;
    }
}
