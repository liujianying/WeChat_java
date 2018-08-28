package com.tencent.mm.pluginsdk.ui.websearch;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aaq = new 1(this);
    private OnTouchListener lmH = new 2(this);
    private View qHE;
    private l qHF;
    private boolean qHG = false;
    private long qHH;

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.qHE = inflate(context, R.i.voice_input_layout, this).findViewById(R.h.voice_search_start_btn);
        this.qHE.setLayerType(1, null);
        this.qHF = new l(context);
        this.qHE.setBackground(this.qHF);
        this.qHE.setEnabled(true);
        this.qHE.setOnTouchListener(this.lmH);
        this.qHE.setOnLongClickListener(this.aaq);
        reset(true);
        if (!isInEditMode() && !cdL()) {
            cdK();
        }
    }

    public final void R(boolean z, boolean z2) {
        x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.qHc), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.qHc == 1) {
            if (z || z2) {
                if (z && !z2) {
                    this.qHF.cdu();
                }
            } else if (cdL()) {
                cdC();
            } else {
                cdK();
            }
        } else if (this.qHc == 2) {
            if (z2) {
                this.qHF.cdu();
                Uh();
                if (this.qHB != null) {
                    this.qHB.cdE();
                    return;
                }
                return;
            }
            bs();
        } else if (!z && !z2) {
            Uh();
        } else if (z && !z2) {
            this.qHF.cdu();
        }
    }

    private void cdK() {
        runOnUiThread(new Runnable() {
            public final void run() {
                WebSearchVoiceInputLayoutImpl.this.qHF.cdx();
            }
        });
        cdD();
    }

    private static boolean cdL() {
        int Lg = au.DF().Lg();
        return Lg == 4 || Lg == 6;
    }

    protected final void cdB() {
        runOnUiThread(new 4(this));
    }

    protected final void cN(boolean z) {
        runOnUiThread(new 5(this));
    }

    protected final void onReset() {
        runOnUiThread(new 6(this));
    }

    protected final void BV(int i) {
        runOnUiThread(new 7(this, i));
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ah.A(runnable);
        } else {
            runnable.run();
        }
    }
}
