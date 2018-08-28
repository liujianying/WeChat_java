package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableTextureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.widget.VoIPVideoView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends d {
    private Timer bno;
    private TextView kzI;
    Bitmap luC = null;
    int[] lul = null;
    private CaptureView oLP;
    private OpenGlView oQP;
    private OpenGlView oQQ;
    private OpenGlRender oQR;
    private OpenGlRender oQS;
    private View oQT;
    private ImageView oQU;
    private TextView oQV;
    private TextView oQW;
    private TextView oQX;
    private View oQY;
    private TextView oQZ;
    private int oRA;
    private int oRB;
    private int oRC;
    private int oRD = 0;
    private boolean oRE = false;
    private boolean oRF = false;
    private boolean oRG = false;
    private boolean oRH;
    public long oRI = 0;
    private Bitmap oRJ = null;
    private a oRK;
    public MMTextureView oRL;
    public MMTextureView oRM;
    private boolean oRN = false;
    public int oRO = 0;
    private OnClickListener oRP = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (e.this.oQd != null && e.this.oQd.get() != null && ((c) e.this.oQd.get()).bKl()) {
                e.this.oRl.setEnabled(false);
                e.this.oRk.setEnabled(false);
                e.this.co(e.this.getString(R.l.voip_finish_call), -1);
            }
        }
    };
    private OnClickListener oRQ = new 12(this);
    private OnClickListener oRR = new 15(this);
    private OnClickListener oRS = new 16(this);
    private OnClickListener oRT = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (ao.isWifi(e.this.getActivity()) || (q.bKO() && !ao.is2G(e.this.getActivity()))) {
                e.e(e.this);
            } else {
                h.a(e.this.getActivity(), R.l.voip_not_wifi_warnning_message, R.l.voip_not_wifi_warnning_title, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!ao.is2G(e.this.getActivity())) {
                            q.bKN();
                        }
                        e.e(e.this);
                    }
                }, new 2(this));
            }
        }
    };
    private OnClickListener oRU = new 18(this);
    private OnClickListener oRV = new 19(this);
    private OnClickListener oRW = new 20(this);
    private OnClickListener oRX = new 21(this);
    private OnClickListener oRY = new 2(this);
    private OnClickListener oRZ = new 3(this);
    private TextView oRa;
    private TextView oRb;
    private RelativeLayout oRc;
    private Button oRd;
    private VoipSmallIconButton oRe;
    private VoipSmallIconButton oRf;
    private VoipSmallIconButton oRg;
    private VoipBigIconButton oRh;
    private VoipBigIconButton oRi;
    private VoipBigIconButton oRj;
    private VoipBigIconButton oRk;
    private VoipBigIconButton oRl;
    private VoipBigIconButton oRm;
    private TextView oRn;
    private TextView oRo;
    private TextView oRp;
    private TextView oRq;
    private TextView oRr;
    private TextView oRs;
    private VoIPVideoView oRt;
    private f oRu = null;
    private Button oRv = null;
    private Button oRw = null;
    private boolean oRx = false;
    private int oRy;
    private int oRz;
    private OnClickListener oSa = new 7(this);
    private Runnable oSb = new 8(this);
    private Runnable oSc = new 9(this);
    int oSd = 0;

    static /* synthetic */ void c(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(3)});
        if (eVar.oQd != null && eVar.oQd.get() != null && ((c) eVar.oQd.get()).bKm()) {
            eVar.oRg.setEnabled(false);
            eVar.oRj.setEnabled(false);
            eVar.oRi.setEnabled(false);
            eVar.oQW.setText(R.l.voip_waitting);
            eVar.oQx.a(eVar.oQX, oQq);
        }
    }

    static /* synthetic */ void d(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(4)});
        if (eVar.oQd != null && eVar.oQd.get() != null && ((c) eVar.oQd.get()).bKn()) {
            eVar.co(eVar.getString(R.l.voip_reject_call), -1);
            eVar.oRi.setEnabled(false);
            eVar.oRj.setEnabled(false);
            eVar.oRg.setEnabled(false);
        }
    }

    static /* synthetic */ void e(e eVar) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(1)});
        if (eVar.oQd != null && eVar.oQd.get() != null && ((c) eVar.oQd.get()).bKo()) {
            eVar.oRj.setEnabled(false);
            eVar.oRi.setEnabled(false);
            eVar.oRg.setEnabled(false);
            eVar.oRh.setVisibility(8);
        }
    }

    static /* synthetic */ void e(e eVar, boolean z) {
        if (z) {
            eVar.getActivity().getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            eVar.getActivity().getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    static /* synthetic */ void v(e eVar) {
        r bJI = i.bJI();
        int i = eVar.oRz;
        l lVar = bJI.oNa.oHa.oJZ;
        lVar.oHa.oJX.oPn = i;
        lVar.oHa.oJX.oPo = 0;
        if (af.exX) {
            long VE = bi.VE();
            int i2 = (int) (VE - eVar.oRI);
            if (i2 <= 1) {
                i2 = 1;
            }
            CharSequence format = String.format(Locale.US, "Cap Fps: %d", new Object[]{Integer.valueOf(eVar.oRz)});
            CharSequence format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(eVar.oRy)});
            CharSequence format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(eVar.oRA)});
            int i3 = i.bJI().oNa.oHa.oJZ.oHa.oJX.field_sendVideoLen;
            int i4 = i.bJI().oNa.oHa.oJZ.oHa.oJX.field_recvVideoLen;
            eVar.oRB = (int) ((((double) (i3 - eVar.oRB)) * 8.0d) / ((double) (i2 * 1000)));
            eVar.oRC = (int) ((((double) (i4 - eVar.oRC)) * 8.0d) / ((double) (i2 * 1000)));
            i2 = (eVar.oRO >> 8) != 0 ? 1 : 0;
            i = (eVar.oRO & WebView.NORMAL_MODE_ALPHA) != 0 ? 1 : 0;
            CharSequence format4 = String.format(Locale.US, "Tx:%d, HWEnc:%d", new Object[]{Integer.valueOf(eVar.oRB), Integer.valueOf(i2)});
            CharSequence format5 = String.format(Locale.US, "Rx:%d, HWDec:%d", new Object[]{Integer.valueOf(eVar.oRC), Integer.valueOf(i)});
            byte[] bArr = i.bJI().oNa.oHa.oJX.oPp;
            if (bArr != null) {
                try {
                    eVar.oRs.setText(new String(bArr, "UTF-8"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                }
            }
            eVar.oRn.setText(format);
            eVar.oRo.setText(format2);
            eVar.oRp.setText(format3);
            eVar.oRr.setText(format5);
            eVar.oRq.setText(format4);
            eVar.oRB = i3;
            eVar.oRC = i4;
            eVar.oRI = VE;
        }
        eVar.oRz = 0;
        eVar.oRy = 0;
        eVar.oRA = 0;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.oQr = (RelativeLayout) layoutInflater.inflate(R.i.voip_video_fragment, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.oQr.findViewById(R.h.rl_video_controllers)).setPadding(0, 0, 0, b.b(getActivity(), 40.0f));
        }
        this.oQs = (ImageView) this.oQr.findViewById(R.h.voip_blur_avatar);
        this.oQt = (ImageView) this.oQr.findViewById(R.h.voip_transparent_blur);
        this.oRc = (RelativeLayout) this.oQr.findViewById(R.h.ll_voip_mask);
        this.oQP = (OpenGlView) this.oQr.findViewById(R.h.big_video);
        this.oQP.dT(mScreenWidth, mScreenHeight);
        this.oRL = (MMTextureView) this.oQr.findViewById(R.h.hwView);
        this.oRL.setVisibility(0);
        x.i("MicroMsg.Voip.VoipVideoFragment", "steve: onCreateView!");
        if (this.oRL != null) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "hwView creat ok");
        }
        this.oRm = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_switch_camera);
        this.oRm.setOnClickListener(this.oSa);
        this.oRl = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_video_switch_to_voice);
        this.oRl.setOnClickListener(this.oRQ);
        this.oRh = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_cancel_video_invite);
        this.oRh.setOnClickListener(this.oRV);
        this.oRk = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_hangup_video_talking);
        this.oRk.setOnClickListener(this.oRP);
        this.oRj = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_accept_video_invite);
        this.oRj.setOnClickListener(this.oRT);
        this.oRg = (VoipSmallIconButton) this.oQr.findViewById(R.h.voip_accept_video_invite_use_voice);
        this.oRg.setOnClickListener(this.oRS);
        this.oRi = (VoipBigIconButton) this.oQr.findViewById(R.h.voip_reject_video_invite);
        this.oRi.setOnClickListener(this.oRU);
        this.oRf = (VoipSmallIconButton) this.oQr.findViewById(R.h.voip_switchto_audio_invite);
        this.oRf.setOnClickListener(this.oRR);
        this.oRH = d.oH("VOIPBlockIgnoreButton") == 0;
        this.oRe = (VoipSmallIconButton) this.oQr.findViewById(R.h.voip_ignore_video_invite);
        this.oRe.setOnClickListener(this.oRX);
        if (!this.oRH) {
            this.oRe.setVisibility(8);
        }
        this.oQZ = (TextView) this.oQr.findViewById(R.h.voip_video_time);
        this.oQT = this.oQr.findViewById(R.h.voip_video_remote_talker_container);
        this.oQU = (ImageView) this.oQr.findViewById(R.h.voip_video_remote_talker_avatar);
        a.b.a(this.oQU, this.cYO, 0.05882353f, true);
        this.oQV = (TextView) this.oQr.findViewById(R.h.voip_video_remote_talker_name);
        this.oQW = (TextView) this.oQr.findViewById(R.h.voip_video_calling_status);
        this.oQX = (TextView) this.oQr.findViewById(R.h.voip_video_calling_status_dot);
        this.oQY = this.oQr.findViewById(R.h.voip_video_calling_status_ctn);
        c(this.oQX, getResources().getString(R.l.voip_three_dot));
        this.oRa = (TextView) this.oQr.findViewById(R.h.voip_video_call_hint);
        this.oRb = (TextView) this.oQr.findViewById(R.h.voip_video_risk_call_hint);
        this.oRd = (Button) this.oQr.findViewById(R.h.btn_minimize_voip);
        this.kzI = (TextView) this.oQr.findViewById(R.h.voip_net_status_hint);
        if (af.exX) {
            this.oRn = (TextView) this.oQr.findViewById(R.h.voip_cap_fps);
            this.oRo = (TextView) this.oQr.findViewById(R.h.voip_send_fps);
            this.oRp = (TextView) this.oQr.findViewById(R.h.voip_recv_fps);
            this.oRq = (TextView) this.oQr.findViewById(R.h.voip_send_kbps);
            this.oRr = (TextView) this.oQr.findViewById(R.h.voip_recv_kbps);
            this.oRs = (TextView) this.oQr.findViewById(R.h.engineInfo);
        }
        this.oRv = (Button) this.oQr.findViewById(R.h.voip_face_debug);
        this.oRw = (Button) this.oQr.findViewById(R.h.voip_face_debug_switch);
        this.oRv.setVisibility(8);
        this.oRw.setVisibility(8);
        this.oRv.setOnClickListener(this.oRY);
        this.oRw.setOnClickListener(this.oRZ);
        this.oRu = new f(getActivity());
        this.oQr.addView(this.oRu);
        this.oRu.setVisibility(8);
        this.oRd.setOnClickListener(this.oRW);
        b(this.oLP);
        int gJ = s.gJ(getActivity());
        x.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + gJ);
        H(this.oRd, gJ);
        H(this.oQr.findViewById(R.h.voip_time_tv_container), gJ);
        H(this.oQT, gJ);
        this.oRz = 0;
        this.oRy = 0;
        this.oRA = 0;
        this.oRB = 0;
        this.oRC = 0;
        WindowManager windowManager = (WindowManager) getActivity().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.oQQ = new MovableVideoView(getActivity().getApplicationContext());
        ((MovableVideoView) this.oQQ).dS(width, height);
        this.oQQ.setVisibility(8);
        this.oQR = new OpenGlRender(this.oQQ, OpenGlRender.oUL);
        this.oQQ.setRenderer(this.oQR);
        this.oQQ.setRenderMode(0);
        this.oQS = new OpenGlRender(this.oQP, OpenGlRender.oUK);
        this.oQP.setRenderer(this.oQS);
        this.oQP.setRenderMode(0);
        this.oQP.setVisibility(0);
        x.i("MicroMsg.Voip.VoipVideoFragment", "steve: before AvcDecoder init");
        this.oRM = new MovableTextureView(getActivity().getApplicationContext());
        MovableTextureView movableTextureView = (MovableTextureView) this.oRM;
        movableTextureView.mWidth = width;
        movableTextureView.oTN = height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager2 = (WindowManager) movableTextureView.getContext().getSystemService("window");
        if (movableTextureView.mScreenWidth == 0) {
            movableTextureView.mScreenWidth = windowManager2.getDefaultDisplay().getWidth();
            movableTextureView.mScreenHeight = windowManager2.getDefaultDisplay().getHeight();
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.topMargin = com.tencent.mm.bp.a.fromDPToPix(movableTextureView.getContext(), 12) + s.gJ(movableTextureView.getContext());
        layoutParams.leftMargin = ((movableTextureView.mScreenWidth - movableTextureView.mWidth) - layoutParams.topMargin) + s.gJ(movableTextureView.getContext());
        movableTextureView.setLayoutParams(layoutParams);
        movableTextureView.oUe = movableTextureView.mScreenHeight - movableTextureView.oTN;
        movableTextureView.oUf = movableTextureView.mScreenWidth - movableTextureView.mWidth;
        windowManager2.getDefaultDisplay().getMetrics(displayMetrics);
        x.i("MicroMsg.MovableTextureView", "steve: Init MovableTextureView successfully! size=" + width + " x " + height);
        this.oRM.setVisibility(0);
        this.oRM.bringToFront();
        ((c) this.oQd.get()).a(this.oRL);
        if (Build.MODEL.equals("Nexus 6")) {
            this.oQQ.setZOrderOnTop(true);
        } else {
            this.oQQ.setZOrderMediaOverlay(true);
        }
        this.oQr.addView(this.oQQ);
        this.oQQ.setOnClickListener(new 4(this));
        this.oRM.setOnClickListener(new 5(this));
        this.oQV.setText(j.a(getActivity(), com.tencent.mm.model.r.gT(this.cYO), this.oQV.getTextSize()));
        if (this.oLU) {
            this.guJ.postDelayed(new 6(this), 2000);
        }
        this.oRt = (VoIPVideoView) this.oQr.findViewById(R.h.voip_talking_video_view);
        this.bno = new Timer("VoIP_video_talking_count");
        this.oRG = true;
        dQ(0, this.mStatus);
        return this.oQr;
    }

    public final void onDestroy() {
        this.oRF = false;
        super.onDestroy();
    }

    private void bLK() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.oRD++;
        this.guJ.postDelayed(this.oSb, 10000);
    }

    public final void dQ(int i, int i2) {
        super.dQ(i, i2);
        x.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.yR(i2));
        if (this.oQr == null) {
            x.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                this.oQY.setVisibility(0);
                this.oRc.setVisibility(0);
                this.oQP.setVisibility(0);
                this.oQW.setText(R.l.voip_invite_waiting_tip);
                this.oQs.setVisibility(8);
                this.oRa.setVisibility(8);
                this.oRb.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oRb.setVisibility(0);
                    this.oRb.setText(i.bJI().oMr);
                }
                this.oQx.a(this.oQX, oQq);
                this.oRm.setVisibility(8);
                this.oRl.setVisibility(8);
                this.oRh.setVisibility(0);
                this.oRk.setVisibility(8);
                this.oRj.setVisibility(8);
                this.oRg.setVisibility(8);
                this.oRi.setVisibility(8);
                this.oRf.setVisibility(0);
                this.oRe.setVisibility(8);
                return;
            case 4:
            case 258:
                this.oQW.setText(R.l.voip_waitting);
                this.oQx.a(this.oQX, oQq);
                return;
            case 6:
            case 260:
                this.oQr.setOnClickListener(new 14(this));
                if (this.oQt != null) {
                    this.oQt.setVisibility(8);
                }
                if (this.oQQ.getVisibility() != 0) {
                    if (this.oLU) {
                        this.oRE = !this.oRE;
                        Point iU = iU(!this.oRE);
                        this.oQQ.dU(iU.x, iU.y);
                    } else {
                        this.oRE = !this.oRE;
                        this.oRt.setVisibility(8);
                    }
                    if (af.exX) {
                        this.oRn.setVisibility(0);
                        this.oRo.setVisibility(0);
                        this.oRp.setVisibility(0);
                        this.oRq.setVisibility(0);
                        this.oRr.setVisibility(0);
                        this.oRs.setVisibility(0);
                    }
                    this.oQT.setVisibility(8);
                    this.oQP.setVisibility(0);
                    this.oQQ.setVisibility(0);
                    this.oRL.setVisibility(0);
                    this.oQZ.setVisibility(0);
                    this.oRd.setVisibility(0);
                    this.oRc.setVisibility(0);
                    this.oRm.setVisibility(0);
                    this.oRl.setVisibility(0);
                    this.oRh.setVisibility(8);
                    this.oRk.setVisibility(0);
                    this.oRj.setVisibility(8);
                    this.oRg.setVisibility(8);
                    this.oRi.setVisibility(8);
                    this.oRf.setVisibility(8);
                    this.oRe.setVisibility(8);
                    setHWDecMode(this.oRO);
                    x.d("MicroMsg.Voip.VoipVideoFragment", "steve: showVideoTalking decMode:%d", new Object[]{Integer.valueOf(this.oRO)});
                    Point iU2 = iU(!this.oRE);
                    ((MovableVideoView) this.oQQ).dS(iU2.x, iU2.y);
                    if (!(this.bno == null || this.oRF)) {
                        if (-1 == this.oQe) {
                            this.oQe = bi.VE();
                        }
                        this.oRI = this.oQe;
                        this.oRF = true;
                        this.bno.schedule(new TimerTask() {
                            public final void run() {
                                e.this.guJ.post(new Runnable() {
                                    public final void run() {
                                        e.this.oQZ.setText(e.bx(bi.bG(e.this.oQe)));
                                        e.v(e.this);
                                    }
                                });
                            }
                        }, 1000, 1000);
                    }
                    if (ad.chZ().getBoolean("voipfaceDebug", false)) {
                        this.oRv.setVisibility(0);
                        this.oRw.setVisibility(0);
                    }
                    bLK();
                    if (this.oQu == 4102) {
                        co(getString(R.l.voip_accept_invite_normal), 10000);
                        return;
                    }
                    return;
                }
                return;
            case 8:
            case 262:
                this.oQx.bLJ();
                this.oRh.setEnabled(false);
                this.oRl.setEnabled(false);
                this.oRk.setEnabled(false);
                this.oRj.setEnabled(false);
                this.oRi.setEnabled(false);
                this.oRg.setEnabled(false);
                this.oRm.setEnabled(false);
                this.oRf.setEnabled(false);
                this.oRe.setEnabled(false);
                switch (i) {
                    case 4105:
                        this.oRa.setVisibility(0);
                        this.oRa.setText(R.l.voip_no_resp);
                        break;
                }
                if (this.oQw != null) {
                    this.oQw.H(true, false);
                    return;
                }
                return;
            case ab.CTRL_BYTE /*256*/:
                this.oQP.setVisibility(0);
                this.oRc.setVisibility(0);
                if (this.oQt != null) {
                    bLI();
                }
                this.oQT.setVisibility(0);
                this.oQV.setVisibility(0);
                this.oQW.setText(R.l.voip_invited_video_tip);
                this.oQY.setVisibility(0);
                this.oQU.setVisibility(0);
                this.oQx.a(this.oQX, oQq);
                this.oRm.setVisibility(8);
                this.oRl.setVisibility(8);
                this.oRh.setVisibility(8);
                this.oRk.setVisibility(8);
                this.oRj.setVisibility(0);
                this.oRg.setVisibility(0);
                this.oRi.setVisibility(0);
                this.oRf.setVisibility(8);
                if (this.oRH) {
                    this.oRe.setVisibility(0);
                }
                this.oRb.setVisibility(8);
                if (i.bJI().oMr != null) {
                    this.oRb.setVisibility(0);
                    this.oRb.setText(i.bJI().oMr);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(CaptureView captureView) {
        this.oLP = captureView;
        b(this.oLP);
    }

    public final void uninit() {
        this.oQQ.setVisibility(4);
        if (this.oLP != null) {
            this.oQr.removeView(this.oLP);
            this.oLP = null;
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.oRK != null) {
            com.tencent.mm.sdk.f.e.remove(this.oRK);
            this.oRK = null;
        }
        super.uninit();
    }

    public final void setMute(boolean z) {
    }

    public final void onStop() {
        this.oQS.bMh();
        this.oQR.bMh();
        super.onStop();
    }

    public final void onStart() {
        this.oQS.oUr = true;
        this.oQR.oUr = true;
        super.onStart();
    }

    protected final void OH(String str) {
        if (this.oRb != null) {
            this.oRb.setVisibility(0);
            this.oRb.setText(str);
        }
    }

    protected final void co(String str, int i) {
        if (this.oRa != null) {
            this.oRa.setText(bi.oV(str));
            this.oRa.setVisibility(0);
            this.oRa.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.oRa.setBackgroundResource(R.g.voip_toast_bg);
            this.oRa.setCompoundDrawables(null, null, null, null);
            this.oRa.setCompoundDrawablePadding(0);
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

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.oRG) {
            if (OpenGlRender.oUV == 1) {
                if (this.oSd < i * i2) {
                    this.lul = null;
                }
                if (this.lul == null) {
                    this.oSd = i * i2;
                    this.lul = new int[this.oSd];
                }
                if (i.bJI().a(bArr, (int) j, i3 & 31, i, i2, this.lul, true) >= 0 && this.lul != null) {
                    if (this.oRE) {
                        this.oQR.b(this.lul, i, i2, (OpenGlRender.oUC + i4) + i5);
                    } else {
                        this.oQS.b(this.lul, i, i2, (OpenGlRender.oUC + i4) + i5);
                    }
                } else {
                    return;
                }
            } else if (OpenGlRender.oUV == 2) {
                if (this.oRE) {
                    this.oQR.e(bArr, i, i2, (OpenGlRender.oUG + i4) + i5);
                } else {
                    this.oQS.e(bArr, i, i2, (OpenGlRender.oUG + i4) + i5);
                }
            }
            this.oRz++;
            if (i6 > 0) {
                this.oRy++;
            }
            f fVar = this.oRu;
            fVar.oTP = i;
            fVar.oTQ = i2;
            fVar = this.oRu;
            int width = this.oQr.getWidth();
            int height = this.oQr.getHeight();
            fVar.oTO = width;
            fVar.cA = height;
        }
    }

    public final void setHWDecMode(int i) {
        int i2 = i & 1;
        if (this.guJ != null) {
            if ((i2 != 0 ? 1 : null) == null) {
                this.guJ.post(new Runnable() {
                    public final void run() {
                        e.this.oRL.setVisibility(4);
                        e.this.oRM.setVisibility(4);
                        e.this.oQQ.setVisibility(0);
                        e.this.oQQ.bringToFront();
                        e.this.oQP.setVisibility(0);
                    }
                });
            } else {
                this.guJ.post(new 11(this));
            }
        }
        this.oRO = i;
    }

    public final void c(int i, int i2, int[] iArr) {
        if (this.oRG) {
            this.oRA++;
            if (OpenGlRender.oUV == 1) {
                if (this.oRE) {
                    this.oQS.b(iArr, i, i2, OpenGlRender.oUC + OpenGlRender.oUH);
                } else {
                    this.oQR.b(iArr, i, i2, OpenGlRender.oUC + OpenGlRender.oUH);
                }
            } else if (this.oRE) {
                this.oQS.b(iArr, i, i2, OpenGlRender.oUE + OpenGlRender.oUH);
            } else {
                this.oQR.b(iArr, i, i2, OpenGlRender.oUE + OpenGlRender.oUH);
            }
        }
    }

    public final void bKB() {
        if (this.oRG) {
            this.oQS.bMi();
            this.oQR.bMi();
        }
    }

    private void b(CaptureView captureView) {
        if (this.oQr != null && captureView != null) {
            this.oQr.removeView(this.oLP);
            this.oLP = null;
            this.oLP = captureView;
            this.oQr.addView(captureView, new RelativeLayout.LayoutParams(1, 1));
            this.oLP.setVisibility(0);
            x.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        }
    }

    public final void onDetach() {
        x.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.bno != null) {
            this.bno.cancel();
            this.bno = null;
        }
        super.onDetach();
    }

    public final void yN(int i) {
    }

    private Point iU(boolean z) {
        int height = (int) (((double) getActivity().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        i.bJI();
        return new Point((int) (f * r.iS(z)), height);
    }
}
