package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class GameBaseActivity extends MMActivity {
    private int jUp = 1;
    private long jUq = 0;
    private long jUr = 0;
    private long mStartTime = 0;

    public abstract int aUM();

    public abstract int aUN();

    public abstract int aUO();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
        }
        this.jUr = System.currentTimeMillis();
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.jUq += System.currentTimeMillis() - this.jUr;
    }

    public void onDestroy() {
        if (this.mStartTime != 0) {
            x.i("MicroMsg.GameBaseActivity", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[]{getClass().getSimpleName(), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Long.valueOf(this.jUq)});
            if (aUL()) {
                an.a(this.jUp, aUM(), aUN(), (long) aUO(), "", "", r8 / 1000, this.jUq / 1000);
            }
        }
        super.onDestroy();
    }

    public boolean aUL() {
        return true;
    }
}
