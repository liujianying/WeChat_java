package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnLongClickListener aaq = new 1(this);
    private OnTouchListener lmH = new 2(this);
    private View qHE;
    private l qHF;
    private boolean qHG = false;
    private long qHH;

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
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
        x.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.qHc), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.qHc == 1) {
            if (z || z2) {
                if (z && !z2) {
                    af(4, this.qHG);
                    af(this.qHc, this.qHG);
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
                }
                af(5, this.qHG);
                return;
            }
            if (z) {
                af(4, this.qHG);
            }
            af(this.qHc, this.qHG);
            bs();
        } else if (!z && !z2) {
            af(this.qHc, this.qHG);
            Uh();
        } else if (z && !z2) {
            af(4, this.qHG);
            af(this.qHc, this.qHG);
            this.qHF.cdu();
        }
    }

    private void cdK() {
        runOnUiThread(new 3(this));
        cdD();
    }

    private static boolean cdL() {
        int Lg = au.DF().Lg();
        return Lg == 4 || Lg == 6;
    }

    protected final void cdB() {
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean qHJ = true;

            public final void run() {
                VoiceInputLayoutImpl.this.qHF.kE(this.qHJ);
            }
        });
    }

    protected final void cN(boolean z) {
        if (!z) {
            af(17, false);
        }
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

    private void af(int i, boolean z) {
        log_13905 log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.qHy) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.qHG || this.qHH == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = bi.bI(this.qHH);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.qHG || this.qHH == 0)) {
                voiceInputBehavior.longClickTime = bi.bI(this.qHH);
            }
        }
        log_13905.viOp_ = voiceInputBehavior;
        h.mEJ.c(13905, log_13905);
        x.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
    }
}
