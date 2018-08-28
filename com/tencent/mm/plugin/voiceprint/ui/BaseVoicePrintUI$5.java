package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$5 implements a {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$5(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        x.d("MicroMsg.BaseVoicePrintUI", "start record");
        as.b(ad.getContext(), R.l.talkroom_press, new 1(this));
        BaseVoicePrintUI.a(this.oFR, "voice_pt_voice_print_record.rec");
        p a = BaseVoicePrintUI.a(this.oFR);
        String d = BaseVoicePrintUI.d(this.oFR);
        BaseVoicePrintUI baseVoicePrintUI = this.oFR;
        a.fileName = d;
        x.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[]{a.fileName});
        au.HV().a(a);
        int yB = au.HV().yB();
        a.orw = false;
        a.epT = new b(baseVoicePrintUI);
        if (yB != 0) {
            a.ew(100);
        } else {
            new p$1(a).sendEmptyMessageDelayed(0, 50);
        }
        BaseVoicePrintUI.e(this.oFR).J(100, 100);
        BaseVoicePrintUI baseVoicePrintUI2 = this.oFR;
        baseVoicePrintUI2.oFI.bJq();
        VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI2.oFI;
        x.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(voiceTipInfoView.gsY.getVisibility()), Boolean.valueOf(voiceTipInfoView.oGL)});
        if (voiceTipInfoView.gsY.getVisibility() != 0 || voiceTipInfoView.oGL) {
            x.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
            voiceTipInfoView.gsY.clearAnimation();
            voiceTipInfoView.gsY.setVisibility(4);
            voiceTipInfoView.gsY.invalidate();
        } else {
            voiceTipInfoView.gsY.clearAnimation();
            voiceTipInfoView.oGL = true;
            a.a(voiceTipInfoView.gsY, voiceTipInfoView.getContext(), new 3(voiceTipInfoView));
        }
        baseVoicePrintUI2.oFI.setTipText(baseVoicePrintUI2.oFo);
        baseVoicePrintUI2.oFP.SO();
        baseVoicePrintUI2.oFP.J(500, 500);
        baseVoicePrintUI2.oFG.setVisibility(0);
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI2.oFH;
        voicePrintVolumeMeter.reset();
        voicePrintVolumeMeter.mIsPlaying = true;
        long j = (long) VoicePrintVolumeMeter.kHx;
        voicePrintVolumeMeter.oGu.J(j, j);
        voicePrintVolumeMeter.bJj();
        return true;
    }
}
