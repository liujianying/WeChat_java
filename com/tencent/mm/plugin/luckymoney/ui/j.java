package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.ui.MMActivity;

public class j {
    public MMActivity fcq;
    public int kXx;
    private int kXy;

    public static final class a {
        public int gND;
        public int kXA;
        public int kXB;
        public int kXC;
        public int kXD;
        public Drawable kXz;
    }

    public j(MMActivity mMActivity) {
        this.fcq = mMActivity;
        if (bbD()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.kXy = window.getStatusBarColor();
        }
    }

    public static boolean bbD() {
        return VERSION.SDK_INT >= 21;
    }

    public void p(Drawable drawable) {
        if (this.fcq.getSupportActionBar() != null) {
            this.fcq.getSupportActionBar().setBackgroundDrawable(drawable);
        }
    }
}
