package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.plugin.voiceprint.ui.a.7;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private final al kGG = new al(new 3(this), true);
    private boolean kGx = false;
    Button oFF;
    View oFG;
    VoicePrintVolumeMeter oFH;
    VoiceTipInfoView oFI;
    p oFJ = null;
    String oFK = null;
    private boolean oFL = false;
    private View oFM;
    private boolean oFN = false;
    private final a oFO = new 1(this);
    al oFP = new al(new 4(this), true);
    private ag oFQ = new ag(Looper.getMainLooper(), new 5(this));
    String oFo = null;

    protected abstract void aZW();

    protected abstract void bJc();

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.oFM.setVisibility(0);
        if (baseVoicePrintUI.oFN) {
            baseVoicePrintUI.oFM.setVisibility(0);
            return;
        }
        baseVoicePrintUI.oFN = true;
        View view = baseVoicePrintUI.oFM;
        View view2 = baseVoicePrintUI.oFF;
        8 8 = new 8(baseVoicePrintUI);
        view.clearAnimation();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", new Object[]{Arrays.toString(iArr)});
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        x.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", new Object[]{Integer.valueOf(iArr[1] - iArr2[1])});
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new 7(8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.oFI = (VoiceTipInfoView) findViewById(R.h.tip_info_view);
        this.oFF = (Button) findViewById(R.h.recoder_btn);
        this.oFG = findViewById(R.h.volume_layout);
        this.oFH = (VoicePrintVolumeMeter) findViewById(R.h.volume_meter);
        this.oFM = findViewById(R.h.button_press_tips);
        this.oFI.bJq();
        this.oFH.setArchView(this.oFF);
        this.oFJ = new p();
        this.oFJ.oFA = this.oFO;
        this.oFF.setOnTouchListener(new 10(this));
        findViewById(R.h.left_btn).setOnClickListener(new 2(this));
        aZW();
    }

    protected final void bIZ() {
        ah.i(new 7(this), 1300);
    }

    protected final void bJa() {
        if (this.oFM.getVisibility() != 4 && this.oFM.getVisibility() != 8) {
            if (this.oFN) {
                this.oFM.setVisibility(4);
                return;
            }
            this.oFN = true;
            a.a(this.oFM, this, new 9(this));
        }
    }

    protected final int getLayoutId() {
        return R.i.voice_print_layout;
    }

    protected void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.oFH;
        voicePrintVolumeMeter.oGu.SO();
        voicePrintVolumeMeter.oGt.lnJ.getLooper().quit();
        x.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        x.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(m.aY("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(m.aY("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    protected final void bJb() {
        ym(R.l.voice_print_network_error);
    }

    protected final void ym(int i) {
        this.oFI.bJm();
        this.oFI.setErr(i);
        this.oFI.bJp();
    }
}
