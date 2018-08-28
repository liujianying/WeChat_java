package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a$h;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements c {
    public boolean bNu = false;
    private boolean isVisible = true;
    private String kCs;
    private double kCw = 1000000.0d;
    private double kCx = 1000000.0d;
    private boolean kEX = true;
    private View kEY;
    private d kEZ;
    private String kEx = "";
    public String kFa;
    private TextView kFb;
    private TextView kFc;
    public ImageButton kFd;

    public f(d dVar, Context context) {
        View findViewById = ((Activity) context).findViewById(e.location_info_frame);
        this.kFb = (TextView) findViewById.findViewById(e.location_info);
        this.kFc = (TextView) findViewById.findViewById(e.location_info_detail);
        this.kFd = (ImageButton) findViewById.findViewById(e.location_navigate_iv);
        this.kEZ = dVar;
        this.kEY = findViewById;
    }

    public final void setText(String str) {
        this.kCs = str;
        CharSequence charSequence = this.kCs;
        x.d("NewItemOverlay", "popView " + this.kEY.getWidth() + " " + this.kEY.getHeight());
        if (!(charSequence == null || charSequence.equals(""))) {
            this.kFc.setText(charSequence);
        }
        if (this.kFa == null || this.kFa.equals("")) {
            this.kFb.setText(a$h.location_conversation);
        } else {
            this.kFb.setText(this.kFa);
        }
        if (this.kEX) {
            this.kEY.setVisibility(0);
            this.kEY.invalidate();
        }
    }

    public final String getPreText() {
        return this.kEx;
    }
}
