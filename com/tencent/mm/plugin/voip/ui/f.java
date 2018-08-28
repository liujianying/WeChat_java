package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.util.Timer;

public final class f extends d {
    private Timer bno;
    private TextView kzI;
    private boolean mIsMute = false;
    private int oLZ = 1;
    private boolean oRF = false;
    private boolean oRH = false;
    private OnClickListener oRW = new 1(this);
    private OnClickListener oRX = new 3(this);
    private Button oRd;
    private VoipBigIconButton oSA;
    private VoipBigIconButton oSB;
    private VoipSmallIconButton oSC;
    private boolean oSD = false;
    private OnClickListener oSE = new 4(this);
    private OnClickListener oSF = new 5(this);
    private OnClickListener oSG = new 6(this);
    private OnClickListener oSH = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(5)});
            if (f.this.oQd != null && f.this.oQd.get() != null && ((c) f.this.oQd.get()).bKp()) {
                f.this.oSz.setEnabled(false);
                f.this.oSy.setEnabled(false);
                f.this.co(f.this.getString(R.l.voip_reject_call), -1);
                if (f.this.oQw != null) {
                    f.this.oQw.H(true, false);
                }
            }
        }
    };
    private OnClickListener oSI = new 8(this);
    private OnClickListener oSJ = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (f.this.oQd != null && f.this.oQd.get() != null && ((c) f.this.oQd.get()).bKs()) {
                f.this.co(f.this.getString(R.l.voip_cancel_call), -1);
                f.this.oSB.setEnabled(false);
            }
        }
    };
    private Runnable oSc = new 10(this);
    private View oSj;
    private ImageView oSk;
    private TextView oSl;
    private TextView oSm;
    private TextView oSn;
    private TextView oSo;
    private View oSp;
    private RelativeLayout oSq;
    private MMCheckBox oSr;
    private TextView oSs;
    private RelativeLayout oSt;
    private MMCheckBox oSu;
    private TextView oSv;
    private TextView oSw;
    private TextView oSx;
    private VoipBigIconButton oSy;
    private VoipBigIconButton oSz;

    public final void onDestroy() {
        this.oRF = false;
        super.onDestroy();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        x.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.oQr = (RelativeLayout) layoutInflater.inflate(R.i.voip_voice_fragment_for_small_screen, viewGroup, false);
        } else {
            this.oQr = (RelativeLayout) layoutInflater.inflate(R.i.voip_voice_fragment, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.oQr.findViewById(R.h.rl_voice_controllers)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
            }
        }
        this.oQs = (ImageView) this.oQr.findViewById(R.h.voip_blur_avatar);
        this.oSj = this.oQr.findViewById(R.h.voip_voice_avatar_and_status_ctn);
        this.oSk = (ImageView) this.oQr.findViewById(R.h.voip_voice_remote_talker_avatar);
        a.b.a(this.oSk, this.cYO, 0.0375f, true);
        this.oSl = (TextView) this.oQr.findViewById(R.h.voip_voice_remote_talker_name);
        this.oSl.setText(j.a(getActivity(), r.gT(this.cYO), this.oSl.getTextSize()));
        this.oSm = (TextView) this.oQr.findViewById(R.h.voip_voice_time);
        this.oSn = (TextView) this.oQr.findViewById(R.h.voip_voice_invite_tips);
        this.oSo = (TextView) this.oQr.findViewById(R.h.voip_voice_invite_tips_dot);
        this.oSp = this.oQr.findViewById(R.h.voip_voice_invite_tips_ctn);
        this.oSw = (TextView) this.oQr.findViewById(R.h.voip_voice_call_hint);
        this.oSx = (TextView) this.oQr.findViewById(R.h.voip_voice_risk_call_hint);
        this.kzI = (TextView) this.oQr.findViewById(R.h.voip_net_status_hint);
        c(this.oSo, getResources().getString(R.l.voip_three_dot));
        this.oSt = (RelativeLayout) this.oQr.findViewById(R.h.voip_voice_mic_switcher_container);
        this.oSu = (MMCheckBox) this.oQr.findViewById(R.h.voip_voice_mic_switcher);
        this.oSu.setChecked(this.mIsMute);
        this.oSv = (TextView) this.oQr.findViewById(R.h.voip_voice_mic_switcher_text);
        this.oSv.setText(R.l.voip_mute_on);
        this.oSq = (RelativeLayout) this.oQr.findViewById(R.h.voip_voice_speaker_switcher_container);
        this.oSr = (MMCheckBox) this.oQr.findViewById(R.h.voip_voice_speaker_switcher);
        this.oSs = (TextView) this.oQr.findViewById(R.h.voip_voice_speaker_switcher_text);
        this.oSs.setText(R.l.voip_speaker_on);
        bLL();
        this.oSy = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_voice_accept_invite);
        this.oSy.setOnClickListener(this.oSG);
        this.oSz = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_voice_reject_invite);
        this.oSz.setOnClickListener(this.oSH);
        this.oSA = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_voice_hangup_talking);
        this.oSA.setOnClickListener(this.oSI);
        this.oSB = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_voice_cancel_inviting);
        this.oSB.setOnClickListener(this.oSJ);
        this.oRH = d.oH("VOIPBlockIgnoreButton") == 0;
        this.oSC = (VoipSmallIconButton) this.oQr.findViewById(R.h.voip_ignore_voice_invite);
        this.oSC.setOnClickListener(this.oRX);
        if (!this.oRH) {
            this.oSC.setVisibility(8);
        }
        this.oSr.setOnClickListener(this.oSE);
        this.oSu.setOnClickListener(this.oSF);
        this.oRd = (Button) this.oQr.findViewById(R.h.btn_minimize_voip);
        this.oRd.setOnClickListener(this.oRW);
        int gJ = s.gJ(getActivity());
        x.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + gJ);
        H(this.oRd, gJ);
        if (this.oLU && 2 == this.oLZ) {
            co(getString(R.l.voip_audio_talking_hint), 10000);
        }
        this.bno = new Timer();
        dQ(this.oQu, this.mStatus);
        return this.oQr;
    }

    public final void dQ(int i, int i2) {
        super.dQ(i, i2);
        x.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.yR(i2) + ", action: " + com.tencent.mm.plugin.voip.b.b.yR(i) + ", lastStatus: " + com.tencent.mm.plugin.voip.b.b.yR(oQv) + ", isSwitchFromVideo: " + this.oSD);
        if (this.oQr == null) {
            x.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 1:
                this.oSj.setVisibility(0);
                this.oSm.setVisibility(8);
                this.oSn.setText(R.l.voip_outcalling);
                this.oQx.a(this.oSo, oQq);
                this.oSp.setVisibility(0);
                this.oSy.setVisibility(8);
                this.oSz.setVisibility(8);
                this.oSA.setVisibility(8);
                this.oSB.setVisibility(0);
                this.oSC.setVisibility(8);
                this.oSt.setVisibility(0);
                this.oSu.setEnabled(false);
                this.oSu.setBackgroundResource(R.g.voip_voiceoff_disable);
                this.oSv.setTextColor(1728053247);
                this.oSx.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oSx.setVisibility(0);
                    this.oSx.setText(i.bJI().oMr);
                }
                bLL();
                this.oSu.setChecked(this.mIsMute);
                this.oSq.setVisibility(0);
                if (2 == this.oLZ) {
                    co(getString(R.l.voip_audio_talking_hint), 10000);
                }
                bLH();
                return;
            case 3:
                this.oSj.setVisibility(0);
                this.oSm.setVisibility(8);
                this.oSn.setText(R.l.voip_invite_waiting_tip);
                this.oQx.a(this.oSo, oQq);
                this.oSp.setVisibility(0);
                this.oSy.setVisibility(8);
                this.oSz.setVisibility(8);
                this.oSA.setVisibility(8);
                this.oSB.setVisibility(0);
                this.oSC.setVisibility(8);
                this.oSt.setVisibility(0);
                this.oSu.setEnabled(false);
                this.oSu.setBackgroundResource(R.g.voip_voiceoff_disable);
                this.oSv.setTextColor(1728053247);
                bLL();
                this.oSu.setChecked(this.mIsMute);
                this.oSq.setVisibility(0);
                if (i != 4097 && 2 == this.oLZ) {
                    co(getString(R.l.voip_audio_talking_hint), 10000);
                }
                bLH();
                this.oSx.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oSx.setVisibility(0);
                    this.oSx.setText(i.bJI().oMr);
                }
                if (oQv == 2) {
                    this.oSD = true;
                    return;
                }
                return;
            case 5:
                this.oSn.setText(R.l.voip_waitting);
                this.oQx.a(this.oSo, oQq);
                this.oSy.setVisibility(8);
                this.oSz.setVisibility(8);
                this.oSA.setVisibility(0);
                this.oSB.setVisibility(8);
                this.oSC.setVisibility(8);
                return;
            case 7:
            case 261:
                this.oSB.setVisibility(8);
                this.oSy.setVisibility(8);
                this.oSz.setVisibility(8);
                this.oSC.setVisibility(8);
                this.oSp.setVisibility(8);
                this.oQx.bLJ();
                this.oSA.setVisibility(0);
                this.oSm.setVisibility(0);
                this.oSt.setVisibility(0);
                this.oSq.setVisibility(0);
                this.oSj.setVisibility(0);
                this.oRd.setVisibility(0);
                this.oSu.setEnabled(true);
                this.oSu.setBackgroundResource(R.g.voip_switch_audio_btn);
                this.oSv.setTextColor(-1);
                bLL();
                this.oSu.setChecked(this.mIsMute);
                if (!this.oSD) {
                    co(getString(R.l.voip_accept_invite_normal), 10000);
                } else if (2 == this.oLZ) {
                    co(getString(R.l.voip_accept_invite_video_to_audio_without_headset), 10000);
                } else if (3 == this.oLZ) {
                    co(getString(R.l.voip_accept_invite_video_to_audio_with_headset), 10000);
                }
                bLH();
                if (!(this.bno == null || this.oRF)) {
                    if (-1 == this.oQe) {
                        this.oQe = bi.VE();
                    }
                    this.oRF = true;
                    this.bno.schedule(new 2(this), 50, 1000);
                }
                this.oSx.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oSx.setVisibility(0);
                    this.oSx.setText(i.bJI().oMr);
                    return;
                }
                return;
            case 8:
            case 262:
                this.oQx.bLJ();
                this.oSA.setEnabled(false);
                this.oSB.setEnabled(false);
                this.oSy.setEnabled(false);
                this.oSz.setEnabled(false);
                this.oSC.setEnabled(false);
                return;
            case 257:
                this.oSj.setVisibility(0);
                this.oSp.setVisibility(0);
                this.oSn.setText(R.l.voip_invited_audio_tip);
                this.oQx.a(this.oSo, oQq);
                bLL();
                this.oSy.setVisibility(0);
                this.oSz.setVisibility(0);
                this.oSA.setVisibility(8);
                this.oSB.setVisibility(8);
                if (this.oRH) {
                    this.oSC.setVisibility(0);
                }
                if (oQv == 256) {
                    this.oSD = true;
                    co(getString(R.l.voip_audio_talking_hint_from), 10000);
                }
                bLH();
                this.oSx.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oSx.setVisibility(0);
                    this.oSx.setText(i.bJI().oMr);
                    return;
                }
                return;
            case 259:
                this.oSj.setVisibility(0);
                this.oSp.setVisibility(0);
                this.oSn.setText(R.l.voip_waitting);
                this.oQx.a(this.oSo, oQq);
                this.oSy.setVisibility(8);
                this.oSz.setVisibility(8);
                this.oSA.setVisibility(0);
                this.oSB.setVisibility(8);
                this.oSC.setVisibility(8);
                co(getString(R.l.voip_audio_talking_hint), 10000);
                bLH();
                return;
            default:
                return;
        }
    }

    public final void a(CaptureView captureView) {
    }

    public final void uninit() {
        if (this.bno != null) {
            this.bno.cancel();
            this.bno = null;
        }
        super.uninit();
    }

    protected final void OH(String str) {
        if (this.oSx != null) {
            this.oSx.setVisibility(0);
            this.oSx.setText(str);
        }
    }

    protected final void co(String str, int i) {
        if (this.oSw != null) {
            this.oSw.setText(bi.oV(str));
            this.oSw.setVisibility(0);
            this.oSw.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.oSw.setBackgroundResource(R.g.voip_toast_bg);
            this.oSw.setCompoundDrawables(null, null, null, null);
            this.oSw.setCompoundDrawablePadding(0);
            this.guJ.removeCallbacks(this.oSc);
            if (-1 != i) {
                this.guJ.postDelayed(this.oSc, (long) i);
            }
        }
    }

    protected final void bLF() {
        if (this.kzI != null) {
            this.kzI.clearAnimation();
            this.kzI.setVisibility(0);
        }
    }

    protected final void bLG() {
        if (this.kzI != null) {
            this.kzI.clearAnimation();
            this.kzI.setVisibility(8);
        }
    }

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.oSu != null && this.oSv != null) {
            this.oSu.setChecked(z);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void c(int i, int i2, int[] iArr) {
    }

    public final void bKB() {
    }

    public final void setHWDecMode(int i) {
    }

    public final void yN(int i) {
        this.oLZ = i;
        bLL();
    }

    private void bLL() {
        boolean z = false;
        if (this.oSr == null || this.oSs == null) {
            x.e("MicroMsg.VoipVoiceFragment", "speaker is null");
        } else if (4 == this.oLZ || 3 == this.oLZ) {
            this.oSr.setEnabled(false);
            this.oSs.setTextColor(1728053247);
            this.oSr.setBackgroundResource(R.g.voip_speaker_disable);
        } else {
            if (this.oLZ == 1) {
                z = true;
            }
            this.oSr.setBackgroundResource(R.g.voip_switch_speaker_btn);
            this.oSr.setEnabled(true);
            this.oSs.setTextColor(-1);
            this.oSr.setChecked(z);
        }
    }
}
