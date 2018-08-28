package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

public class MMFalseProgressBar extends ProgressBar {
    private boolean bpL;
    private ag mHandler;
    private float tua;
    private float tub;
    private float tuc;
    private float tud;
    private float tue;
    public boolean tuf;

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        if (mMFalseProgressBar.tua < 600.0f) {
            mMFalseProgressBar.tua += mMFalseProgressBar.tub;
        } else if (mMFalseProgressBar.tua >= 600.0f && mMFalseProgressBar.tua < 800.0f) {
            mMFalseProgressBar.tua += mMFalseProgressBar.tuc;
        } else if (mMFalseProgressBar.tua >= 800.0f && mMFalseProgressBar.tua < 920.0f) {
            mMFalseProgressBar.tua += mMFalseProgressBar.tud;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.tua < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.tua);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        if (mMFalseProgressBar.bpL) {
            Float valueOf;
            if (mMFalseProgressBar.tua < 950.0f) {
                mMFalseProgressBar.tua += mMFalseProgressBar.tue;
                if (mMFalseProgressBar.tua <= 950.0f) {
                    f = mMFalseProgressBar.tua;
                }
                mMFalseProgressBar.tua = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.tua += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.tua) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.tua < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.tua = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.tua);
        }
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.tua = 0.0f;
        mMFalseProgressBar.bpL = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
    }

    public MMFalseProgressBar(Context context) {
        this(context, null);
        crt();
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpL = false;
        this.tua = 0.0f;
        this.tuf = true;
        this.mHandler = new 1(this, Looper.getMainLooper());
        setMax(1000);
        crt();
    }

    public final void start() {
        x.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (this.tuf && !this.bpL) {
            this.bpL = true;
            crt();
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1000);
                this.mHandler.sendEmptyMessage(1001);
            }
        }
    }

    public final void finish() {
        x.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }

    private void crt() {
        if (ao.fK(ad.getContext())) {
            this.tub = 4.0f;
            this.tuc = 1.0f;
            this.tud = 0.3f;
            this.tue = 50.0f;
            return;
        }
        this.tub = 2.0f;
        this.tuc = 0.5f;
        this.tud = 0.15f;
        this.tue = 50.0f;
    }
}
