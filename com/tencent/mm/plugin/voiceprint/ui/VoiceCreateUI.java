package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.plugin.voiceprint.ui.a.6;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private View hZE = null;
    private int oFn = 1;
    private l oGb;
    private o oGc = null;
    private View oGd;
    private NoiseDetectMaskView oGe;
    private Button oGf = null;
    private int oGg = 0;
    private c oGh = new 1(this);

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        h.mEJ.h(11390, Integer.valueOf(4));
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.oGe;
        if (noiseDetectMaskView.eWx != null) {
            noiseDetectMaskView.eWx.setVisibility(8);
        }
        noiseDetectMaskView.oFU.setText(R.l.voice_print_too_much_noise);
        noiseDetectMaskView.oFV.setVisibility(0);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.hZE.setVisibility(0);
        voiceCreateUI.oGd.setVisibility(0);
        voiceCreateUI.oFG.setVisibility(0);
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.oGe;
        6 6 = new 6(voiceCreateUI);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new 6(6));
        noiseDetectMaskView.startAnimation(translateAnimation);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        voiceCreateUI.oFI.bJl();
        voiceCreateUI.oFn = 1;
        voiceCreateUI.oGb.oFn = 71;
        au.DF().a(new d(71, ""), 0);
    }

    protected final void bJc() {
        x.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.oFK);
        if (!bi.oW(this.oFK)) {
            this.oFF.setEnabled(false);
            this.oFI.bJl();
            l lVar;
            com.tencent.mm.ab.l fVar;
            if (this.oFn == 1) {
                lVar = this.oGb;
                fVar = new f(this.oFK, 71, lVar.oFp, 0);
                fVar.oEW = true;
                au.DF().a(fVar, 0);
                lVar.oFn = 71;
            } else if (this.oFn == 2) {
                lVar = this.oGb;
                fVar = new f(this.oFK, 72, lVar.oFp, lVar.oEZ);
                fVar.oEW = true;
                au.DF().a(fVar, 0);
                lVar.oFn = 72;
            }
        }
    }

    protected final void aZW() {
        this.oGb = new l(this);
        findViewById(R.h.right_btn).setVisibility(8);
        this.oFI.setTitleText(R.l.voice_read_title);
        this.oFI.bJo();
        this.oFF.setEnabled(false);
        this.oGc = new o();
        this.oGd = findViewById(R.h.voice_bottom);
        this.oGe = (NoiseDetectMaskView) findViewById(R.h.mask);
        this.hZE = findViewById(R.h.left_btn);
        this.oGf = (Button) findViewById(R.h.right_btn);
        this.oGf.setVisibility(8);
        this.oGf.setOnClickListener(new 2(this));
        this.oGe.setOnClickRetryCallback(new 3(this));
        this.oGe.setOnCancelDetectCallback(new 4(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.oGh);
        this.hZE.setOnClickListener(new 5(this));
        start();
    }

    private void start() {
        x.d("MicroMsg.VoiceCreateUI", "start create");
        this.oGc.reset();
        NoiseDetectMaskView noiseDetectMaskView = this.oGe;
        if (noiseDetectMaskView.eWx != null) {
            noiseDetectMaskView.eWx.setVisibility(0);
        }
        noiseDetectMaskView.oFU.setText(R.l.voice_print_noise_detecting);
        noiseDetectMaskView.oFV.setVisibility(8);
        x.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.hZE.setVisibility(4);
        this.oGd.setVisibility(4);
        this.oFG.setVisibility(4);
        this.oGe.setVisibility(0);
        o oVar = this.oGc;
        x.d("MicroMsg.VoicePrintNoiseDetector", "start detect noise");
        oVar.reset();
        if (oVar.oFs.dc(m.aY("voice_pt_voice_print_noise_detect.rec", true))) {
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record");
        } else {
            oVar.oFs.we();
            oVar.reset();
            x.d("MicroMsg.VoicePrintNoiseDetector", "start record fail");
        }
        oVar.oFt.J(100, 100);
    }

    public final void OD(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        bIZ();
        this.oFo = str;
        this.oFI.bJm();
        this.oFI.bJn();
        this.oFI.setTipText(str);
        this.oFF.setEnabled(true);
    }

    public final void OE(String str) {
        x.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.oFo = str;
        this.oFI.bJm();
        this.oFI.bJn();
        this.oFI.setTipText(str);
        this.oFF.setEnabled(true);
    }

    public final void u(boolean z, int i) {
        x.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            switch (i) {
                case 71:
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.oFF.setEnabled(false);
                    this.oFn = 2;
                    bJa();
                    a.a(this.oFI, new 7(this));
                    return;
                case 72:
                    this.oGg = 0;
                    x.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 72:
                bJi();
                this.oGg++;
                if (this.oGg >= 2) {
                    x.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.oGg = 0;
                    startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                    overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                    finish();
                    return;
                }
                this.oFF.setEnabled(true);
                this.oFI.bJm();
                this.oFI.setErr(R.l.voice_regeist_error);
                this.oFI.bJp();
                return;
            default:
                return;
        }
    }

    public final void bIV() {
        bJb();
        bJi();
    }

    private void bJi() {
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.oGb;
        au.DF().b(611, eVar);
        au.DF().b(612, eVar);
        eVar.oFq = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.oGh);
    }

    public void onBackPressed() {
        super.onBackPressed();
        bJi();
    }
}
