package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;

public final class b implements SurfaceTextureListener, OnClickListener, a, g {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] oQq = new int[]{-1, R.l.voip_cs_one_dot, R.l.voip_cs_two_dot, R.l.voip_cs_three_dot};
    public boolean bPd = false;
    private ag dvh;
    public TextView eTm;
    private Timer gei;
    private TextView hrs;
    private View lvR;
    private ImageButton lvy;
    public com.tencent.mm.plugin.voip.video.a lwc;
    public ObservableTextureView lwe;
    private OpenGlView oQP;
    private OpenGlView oQQ;
    public OpenGlRender oQR;
    public OpenGlRender oQS;
    private boolean oRE = false;
    private VoipBigIconButton oRm;
    private OnClickListener oSa = new 3(this);
    public VoipCSMainUI oXA;
    public RelativeLayout oXB;
    private TextView oXC;
    private TextView oXD;
    private TextView oXE;
    private TextView oXF;
    public ImageView oXG;
    private ag oXH;
    private boolean oXI = false;
    protected long oXJ = -1;
    private boolean oXK = false;
    private boolean oXL = false;
    public int oXM = 60000;
    public int oXN = 5000;
    private com.tencent.mm.plugin.voip_cs.c.a oXO = new com.tencent.mm.plugin.voip_cs.c.a();
    public String oXP = "";
    public String oXQ = "";
    public al oXR = new al(Looper.getMainLooper(), new 1(this), false);
    public al oXS = new al(Looper.getMainLooper(), new 2(this), false);
    a oXT = new a(this, (byte) 0);
    c oXU;
    b oXV;
    String oXW = "";
    Drawable oXX = null;

    public b(VoipCSMainUI voipCSMainUI) {
        this.oXA = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.h.rl_video_cs_controllers)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(voipCSMainUI.mController.tml, 40.0f));
        }
        this.oQQ = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.oQQ).dS(width, height);
        this.oQQ.setVisibility(8);
        this.oQR = new OpenGlRender(this.oQQ, OpenGlRender.oUL);
        this.oQQ.setRenderer(this.oQR);
        this.oQQ.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.oQQ.setZOrderOnTop(true);
        } else {
            this.oQQ.setZOrderMediaOverlay(true);
        }
        this.hrs = (TextView) voipCSMainUI.findViewById(R.h.time_tv);
        this.hrs.setVisibility(0);
        this.gei = new Timer("voip_cs_talking_time");
        this.oXC = (TextView) voipCSMainUI.findViewById(R.h.voip_cs_cancel);
        this.oXC.setVisibility(0);
        this.oXD = (TextView) voipCSMainUI.findViewById(R.h.voip_cs_video_calling_status);
        if (voipCSMainUI.buF.equals("1")) {
            if (voipCSMainUI.type.equals("video")) {
                this.oXD.setText(ad.getContext().getString(R.l.voip_cs_declare));
            } else {
                this.oXD.setText(ad.getContext().getString(R.l.voip_cs_declare_audio));
            }
        } else if (voipCSMainUI.type.equals("video")) {
            this.oXD.setText(ad.getContext().getString(R.l.voip_cs_declare_video));
        } else {
            this.oXD.setText(ad.getContext().getString(R.l.voip_cs_declare_audio));
        }
        this.oXD.setVisibility(0);
        this.eTm = (TextView) voipCSMainUI.findViewById(R.h.voip_cs_video_remote_talker_name);
        this.eTm.setVisibility(0);
        this.oXG = (ImageView) voipCSMainUI.findViewById(R.h.voip_cs_pic);
        this.oXG.setVisibility(0);
        this.oXF = (TextView) voipCSMainUI.findViewById(R.h.voip_cs_video_call_hint);
        this.oXE = (TextView) voipCSMainUI.findViewById(R.h.voip_cs_video_calling_status_dot);
        this.oRm = (VoipBigIconButton) voipCSMainUI.findViewById(R.h.voip_cs_switch_camera);
        if (voipCSMainUI.oYg == null || !voipCSMainUI.oYg.equals("1")) {
            this.oRm.setVisibility(8);
        } else {
            this.oRm.setVisibility(0);
            this.oRm.setOnClickListener(this.oSa);
        }
        this.dvh = new ag();
        this.oXH = new 4(this);
        this.lvR = voipCSMainUI.findViewById(R.h.voip_cs_activity_root);
        this.lvy = (ImageButton) voipCSMainUI.findViewById(R.h.voip_cs_talking_hangup_btn);
        this.oXB = (RelativeLayout) voipCSMainUI.findViewById(R.h.voip_cs_activity_root);
        mScreenWidth = com.tencent.mm.bp.a.fk(voipCSMainUI.mController.tml);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.b.er(voipCSMainUI.mController.tml);
        this.oQP = (OpenGlView) voipCSMainUI.findViewById(R.h.voip_cs_big_video);
        this.oQP.dT(mScreenWidth, mScreenHeight);
        this.oQS = new OpenGlRender(this.oQP, OpenGlRender.oUK);
        this.oQP.setRenderer(this.oQS);
        this.oQP.setRenderMode(0);
        this.oQP.setVisibility(0);
        x.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[]{Integer.valueOf(mScreenHeight)});
        this.lvy.setOnClickListener(this);
        this.oXB.addView(this.oQQ);
        this.oQQ.setOnClickListener(new 5(this));
        this.oQR.oUr = true;
        this.oQS.oUr = true;
        if (!d.em(ad.getContext())) {
            d.en(ad.getContext());
        }
        SharedPreferences chZ = ad.chZ();
        this.oXP = chZ.getString(bMF(), "");
        if (this.oXA.eTp != null && !this.oXA.eTp.equals("")) {
            ON(this.oXA.eTp);
        } else if (!com.tencent.pb.common.c.g.isNullOrEmpty(this.oXP)) {
            ON(this.oXP);
        }
        this.oXQ = chZ.getString(bMG(), "");
        if (!com.tencent.pb.common.c.g.isNullOrEmpty(this.oXQ)) {
            OM(this.oXQ);
        }
        com.tencent.mm.plugin.voip_cs.b.d bMw = com.tencent.mm.plugin.voip_cs.b.b.bMw();
        String str = this.oXA.oXt;
        x.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + str);
        au.DF().a(455, bMw);
        au.DF().a(new j(str), 0);
    }

    public final void OM(String str) {
        CharSequence charSequence;
        if (this.oXA.oYj) {
            charSequence = str + ad.getContext().getString(R.l.voip_cs_biz_user_appbrand);
        } else {
            charSequence = str + ad.getContext().getString(R.l.voip_cs_biz_user_mp);
        }
        this.eTm.setText(charSequence);
    }

    public final void ON(String str) {
        if (!com.tencent.pb.common.c.g.isNullOrEmpty(str)) {
            this.oXV = new b(this);
            if (this.oXA.eTp == null || this.oXA.eTp.equals("")) {
                this.oXW = str;
            } else {
                this.oXW = this.oXA.eTp;
            }
            e.b(this.oXV, "VOIPCS_netPic", 10);
        }
    }

    public final String bMF() {
        return "voip_cs_headImageUrl_" + this.oXA.oXt;
    }

    public final String bMG() {
        return "voip_cs_nickname_" + this.oXA.oXt;
    }

    private Point iU(boolean z) {
        int height = ((WindowManager) this.oXA.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        return new Point((int) (iS(!z) * ((float) height)), height);
    }

    private static float iS(boolean z) {
        byte[] bArr;
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.field_capInfo;
            } catch (Exception e) {
                x.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOn;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            x.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
        }
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getId() == R.h.voip_cs_talking_hangup_btn) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs < 2) {
                com.tencent.mm.plugin.voip_cs.b.b.bMx().bjS = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.b.bMx().bjS = 4;
            }
            c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
            bMx.oWv = 1;
            bMx.oWS = 1;
            bMx.oWw = (int) (System.currentTimeMillis() / 1000);
            bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
            x.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (bMx.oWP == 0) {
                bMx.oWK = 3;
                if (bMx.oWT == 0 && bMx.oXf != 0) {
                    bMx.oWT = (long) (((int) (System.currentTimeMillis() / 1000)) - bMx.oXf);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.b.bMx().bMy();
            x.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            zc(0);
            return;
        }
        int i = this.lvy.getVisibility() == 0 ? 8 : 0;
        this.lvy.setVisibility(i);
        this.hrs.setVisibility(i);
        this.oXC.setVisibility(i);
        zb(i);
        if (i == 0) {
            z = true;
        }
        iZ(z);
    }

    private void zb(int i) {
        if (this.oXA.oYg == null || !this.oXA.oYg.equals("1")) {
            this.oRm.setVisibility(8);
        } else {
            this.oRm.setVisibility(i);
        }
    }

    public final void bMH() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.lwe != null) {
            this.oXB.removeView(this.lwe);
            this.lwe = null;
        }
        if (this.lwc != null) {
            this.lwc.bLZ();
            com.tencent.mm.plugin.voip.video.a.bMa();
            this.lwc = null;
        }
    }

    private void bMI() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.dvh.postDelayed(new 6(this), 10000);
    }

    private void iZ(boolean z) {
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
        } else if (z) {
            this.oXA.getWindow().clearFlags(1024);
        } else {
            this.oXA.getWindow().setFlags(1024, 1024);
        }
    }

    public final void aWO() {
        this.oXR.SO();
        this.oXS.SO();
        this.oXO.bLJ();
        this.oXE.setVisibility(8);
        this.oXD.setText(R.l.voip_cs_serve_hint);
        this.oXC.setText(R.l.voip_cs_hungup);
        zb(0);
        this.lvR.setOnClickListener(this);
        if (this.oXA.oYh != null && this.oXA.oYh.equals("1")) {
            this.oQQ.setVisibility(0);
            this.oRE = true;
            Point iU = iU(this.oRE);
            ((MovableVideoView) this.oQQ).dS(iU.x, iU.y);
            bMJ();
        }
        bMI();
        this.oXK = true;
        if (this.gei == null) {
            this.gei = new Timer("voip_cs_talking_time");
        }
        if (!this.oXI) {
            if (this.oXJ == -1) {
                this.oXJ = bi.VE();
            }
            this.oXI = true;
            this.gei.schedule(new 7(this), 1000, 1000);
            p.bKK().bKL();
            p.bKK().oMP = this;
        }
    }

    public static Drawable OO(String str) {
        try {
            return Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
        } catch (Exception e) {
            x.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            return null;
        }
    }

    protected static String bx(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void zc(int i) {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:" + i);
        if (this.gei != null) {
            this.gei.cancel();
            this.gei = null;
        }
        if (!this.oXR.ciq()) {
            this.oXR.SO();
        }
        if (!this.oXS.ciq()) {
            this.oXS.SO();
        }
        this.oXO.bLJ();
        this.oXI = false;
        this.oXF.setVisibility(0);
        this.oXF.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.oXF.setBackgroundResource(R.g.voip_cs_toast_bg);
        this.oXF.setCompoundDrawables(null, null, null, null);
        this.oXF.setCompoundDrawablePadding(0);
        this.oXF.setText(zd(i));
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 2) {
            e.post(new 8(this), "VoipCS_play_end_sound");
        }
        this.dvh.postDelayed(new 9(this), 2000);
    }

    private static int zd(int i) {
        if (i == 1) {
            return R.l.voip_cs_callee_hang_up;
        }
        if (i == 0) {
            return R.l.voip_cs_end_wording;
        }
        if (i == -1 || i == 5) {
            return R.l.voip_cs_net_unavailable;
        }
        if (i == 403 || i == TencentLocation.ERROR_UNKNOWN) {
            return R.l.voip_cs_verify_fail;
        }
        if (i == 6) {
            return R.l.voip_cs_opposite_not_response;
        }
        if (i == 1001) {
            return R.l.voip_cs_net_status_warning_hint;
        }
        if (i == 10) {
            return R.l.voip_cs_disconnect_tip;
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs < 2) {
            return R.l.voip_cs_call_fail;
        }
        return R.l.voip_cs_end_wording;
    }

    public final void aWP() {
        this.oXF.setVisibility(0);
        this.oXF.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.oXF.setBackgroundResource(R.g.voip_cs_toast_bg);
        this.oXF.setCompoundDrawables(null, null, null, null);
        this.oXF.setCompoundDrawablePadding(0);
        this.oXF.setText(zd(1001));
    }

    public final void aWQ() {
        this.oXF.setVisibility(8);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        x.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.bPd);
        if (!this.bPd) {
            if (this.oXT.lul == null) {
                this.oXT.w = i;
                this.oXT.h = i2;
                this.oXT.lul = new int[(this.oXT.w * this.oXT.h)];
            }
            int i4 = this.lwc.bMb() ? OpenGlRender.oUJ : 0;
            int i5 = this.lwc.bMc() ? OpenGlRender.oUI : OpenGlRender.oUH;
            if (this.oXK) {
                x.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.videoEncodeToSend(bArr, bArr.length, i, i2, i3));
                v2protocal v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx;
                v2protocal.oPA++;
            }
            com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.videoEncodeToLocal(bArr, (int) j, i, i2, i3, 0, 75, this.oXT.lul);
            if (OpenGlRender.oUV == 1) {
                if (this.oRE) {
                    this.oQR.b(this.oXT.lul, i, i2, (OpenGlRender.oUC + i4) + i5);
                } else {
                    this.oQS.b(this.oXT.lul, i, i2, (OpenGlRender.oUC + i4) + i5);
                }
            } else if (OpenGlRender.oUV != 2) {
            } else {
                if (this.oRE) {
                    this.oQR.e(bArr, i, i2, (OpenGlRender.oUG + i4) + i5);
                } else {
                    this.oQS.e(bArr, i, i2, (OpenGlRender.oUG + i4) + i5);
                }
            }
        }
    }

    public final void bgV() {
        x.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    }

    public final void bMJ() {
        bMK();
        this.oXU = new c(this);
        e.b(this.oXU, "VOIPCS_VideoDecode", 10);
        x.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    }

    public final void bMK() {
        if (this.oXU != null) {
            x.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.oXU.oKP = true;
            e.remove(this.oXU);
            this.oXU = null;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
