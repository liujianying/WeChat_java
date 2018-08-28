package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

public class GameBlockView extends LinearLayout {
    LayoutInflater Bc;
    LayoutParams jUD;
    k jUE;
    a jUF;
    LinearLayout jeZ;

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOrientation(1);
        this.Bc = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.jUD = new LayoutParams(-1, -2);
        this.jeZ = this;
        this.jUE = new k();
        x.i("MicroMsg.GameBlockView", "initView finished");
    }
}
