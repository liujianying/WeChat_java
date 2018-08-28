package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.al;

public final class c extends AppCompatTextView {
    StringBuilder azu = new StringBuilder(100);
    private al eOf = new al(Looper.getMainLooper(), new 1(this), true);
    private long fBi = -1;
    private long fBj = -1;
    private int fBk = 0;
    private float fBl = 60.0f;
    private int fBm = 0;

    public c(Context context) {
        super(context);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c.this.fBl = 60.0f;
            }
        });
        this.eOf.J(500, 500);
    }
}
