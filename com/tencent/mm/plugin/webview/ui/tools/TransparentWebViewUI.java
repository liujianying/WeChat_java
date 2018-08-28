package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.fYl != null) {
                this.fYl.enable();
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.fYl != null) {
                this.fYl.enable();
            }
        }
    }

    protected final void initView() {
        boolean z = true;
        super.initView();
        this.pZr.pXt = true;
        this.pZr.fpo = false;
        this.pZr.jY(true);
        this.pZr.AH(0);
        if (!(getIntent() != null && getIntent().hasExtra("show_full_screen") && getIntent().getBooleanExtra("show_full_screen", false))) {
            z = false;
        }
        if (z && this.pXI != null) {
            this.pXI.setCanMove(false);
        }
    }

    protected final void bVP() {
        setBackGroundColorResource(0);
        this.mController.contentView.setBackgroundResource(0);
        this.mhH.setBackgroundResource(17170445);
        this.mhH.setBackgroundColor(0);
        findViewById(R.h.webview_keyboard_ll).setBackgroundResource(17170445);
        findViewById(R.h.root_container).setBackgroundResource(17170445);
    }

    protected final boolean bVQ() {
        return false;
    }
}
