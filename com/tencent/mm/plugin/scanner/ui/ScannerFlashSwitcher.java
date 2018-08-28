package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

public class ScannerFlashSwitcher extends LinearLayout {
    ImageView mLJ;
    TextView mLK;
    boolean mLL = false;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        y.gq(getContext()).inflate(R.i.scanner_flash_switcher, this, true);
        this.mLJ = (ImageView) findViewById(R.h.flash_switcher);
        this.mLK = (TextView) findViewById(R.h.flash_open_hint);
        this.mLL = true;
    }

    public final void hide() {
        x.i("MicroMsg.ScannerFlashSwitcher", "hide");
        setEnabled(false);
        this.mLJ.animate().alpha(0.0f).setDuration(500);
        this.mLK.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ScannerFlashSwitcher.this.setVisibility(8);
            }
        });
    }

    public final void bsS() {
        x.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.mLJ.setImageResource(R.k.scanner_flash_open_normal);
    }
}
