package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.pb.common.c.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements com.tencent.mm.plugin.voip.ui.b {
    private static final String byN;
    private static final String byO;
    private int mStatus = -1;
    private CaptureView oLP;
    private ab oLT;
    private boolean oLU;
    private boolean oLV;
    private int oLZ = 1;
    private long oMa = -1;
    private boolean oNm = false;
    private int oRO;
    private al oSP;
    private c oVZ;
    private BaseSmallView oWa;
    private al oWb;
    private WakeLock oWc;
    private long oWd = -1;
    private boolean oWe = false;
    private OnClickListener oWf = new OnClickListener() {
        public final void onClick(View view) {
            if (b.this.oWa != null) {
                b.this.oWa.setOnClickListener(null);
            }
            b.this.oSP = new al(new 1(this), false);
            b.this.oSP.J(2000, 2000);
            Intent intent = new Intent(ad.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            ad.getContext().startActivity(intent);
        }
    };
    private al oWg;

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
    }

    public b(c cVar, int i, ab abVar, boolean z, boolean z2, boolean z3) {
        x.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(i), abVar.field_username, Boolean.valueOf(z)});
        this.oLT = abVar;
        this.oVZ = cVar;
        this.oLV = z;
        this.oLU = z2;
        this.oNm = z3;
        dQ(0, i);
        this.oWc = ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.oWc.acquire();
    }

    public final void yN(int i) {
    }

    public final void setMute(boolean z) {
    }

    public final void dQ(int i, int i2) {
        Integer num = null;
        x.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(i2)});
        if (i2 == this.mStatus) {
            x.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            return;
        }
        this.mStatus = i2;
        String string;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
                if (this.oWa != null) {
                    num = (Integer) this.oWa.getTag();
                }
                if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
                    string = ad.getContext().getString(R.l.voip_video_is_talking_tip);
                    g(string, string, "", true);
                    if (this.oVZ != null) {
                        this.oVZ.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 3:
            case 5:
            case 257:
            case 259:
                if (2 == this.oLZ) {
                    yY(R.l.voip_audio_talking_hint);
                }
                bMt();
                string = ad.getContext().getString(R.l.voip_voice_is_talking_tip);
                g(string, r.gT(this.oLT.field_username), string, true);
                bMr();
                if (this.oVZ != null) {
                    this.oVZ.a(this, 2);
                    return;
                }
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
                this.oWe = true;
                if (-1 == this.oWd) {
                    this.oWd = System.currentTimeMillis();
                }
                if (this.oVZ != null) {
                    this.oVZ.a(this, 2);
                }
                if (com.tencent.mm.compatible.f.b.bv(ad.getContext())) {
                    bMp();
                } else {
                    x.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
                    RequestFloatWindowPermissionDialog.a(ad.getContext(), ad.getContext().getString(R.l.voip_float_permission_alert_content), new a() {
                        public final void a(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            requestFloatWindowPermissionDialog.finish();
                            String string = ad.getContext().getString(R.l.voip_video_is_talking_tip);
                            b.this.g(string, r.gT(b.this.oLT.field_username), string, false);
                            if (com.tencent.mm.plugin.voip.b.b.yW(b.this.mStatus) || com.tencent.mm.plugin.voip.b.b.yU(b.this.mStatus)) {
                                b.this.bMp();
                            }
                        }

                        public final void b(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
                            requestFloatWindowPermissionDialog.finish();
                        }
                    });
                    if (!i.bJI().oNk) {
                        i.bJI().oNk = true;
                        au.HU();
                        if (System.currentTimeMillis() - com.tencent.mm.model.c.DT().Dj(327950) > 86400000) {
                            String str = "have not permission to showing floating window\n";
                            au.HU();
                            com.tencent.mm.model.c.DT().setLong(327950, System.currentTimeMillis());
                            x.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n#client.version=").append(d.qVN).append("\n");
                            stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.d.REV).append("\n");
                            stringBuilder.append("#accinfo.uin=").append(at.dBv.I("last_login_uin", byO)).append("\n");
                            stringBuilder.append("#accinfo.dev=").append(byN).append("\n");
                            stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.d.TIME).append(":").append(com.tencent.mm.sdk.platformtools.d.HOSTNAME).append(":").append(e.bxk).append("\n");
                            Date date = new Date();
                            stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
                            stringBuilder.append("#accinfo.content:\n");
                            Intent intent = new Intent();
                            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionWriteSdcard", false);
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str2 = "userName";
                            string = at.dBv.I("login_weixin_username", "");
                            if (bi.oW(string)) {
                                string = at.dBv.I("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str2, string);
                            intent.putExtra("tag", "float_window_permission");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                            ad.getContext().startService(intent);
                        }
                    }
                }
                string = ad.getContext().getString(R.l.voip_video_is_talking_tip);
                g(string, r.gT(this.oLT.field_username), string, false);
                return;
            case 7:
            case 261:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
                if (-1 == this.oWd) {
                    this.oWd = System.currentTimeMillis();
                }
                if (2 == this.oLZ) {
                    yY(R.l.voip_audio_talking_hint);
                }
                bMt();
                if (this.oVZ != null) {
                    this.oVZ.a(this, 2);
                }
                this.oWb = new al(new 3(this), true);
                this.oWb.J(5000, 5000);
                string = bMs();
                g(string, r.gT(this.oLT.field_username), string, false);
                bMr();
                if (4101 == i) {
                    yY(R.l.voip_switch_to_voice_hint);
                    return;
                }
                return;
            case 8:
            case 262:
                int i3;
                switch (i) {
                    case 4099:
                        if (!this.oLV) {
                            i3 = R.l.voip_audio_call_rejected;
                            break;
                        } else {
                            i3 = R.l.voip_video_call_rejected;
                            break;
                        }
                    case 4105:
                        i3 = R.l.voip_no_resp;
                        break;
                    case 4106:
                        i3 = R.l.voip_shutdown_tip;
                        break;
                    default:
                        bMt();
                        return;
                }
                yY(i3);
                bMt();
                return;
            case 256:
            case 258:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
                if (this.oWa != null) {
                    num = (Integer) this.oWa.getTag();
                }
                if (num == null || !(256 == num.intValue() || 258 == num.intValue())) {
                    string = ad.getContext().getString(R.l.voip_video_is_talking_tip);
                    g(string, string, "", true);
                    if (this.oVZ != null) {
                        this.oVZ.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void yY(int i) {
        Context context = ad.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
    }

    private void bMp() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        bMt();
        Context context = ad.getContext();
        i.bJI();
        this.oWa = new a(context, com.tencent.mm.plugin.voip.model.r.iS(false));
        this.oWa.setConnectSec(this.oMa);
        this.oWa.setVoipUIListener(this.oVZ);
        context = ad.getContext();
        i.bJI();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f);
        int b = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f)) + (com.tencent.mm.plugin.voip.model.r.iS(true) * ((float) height)));
        this.oWa.dV(b, height);
        this.oWa.setOnClickListener(this.oWf);
        x.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        Point point = new Point(b, height);
        x.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (com.tencent.mm.plugin.voip.b.b.yW(this.mStatus) || com.tencent.mm.plugin.voip.b.b.yU(this.mStatus)) {
            if (this.oWb != null) {
                this.oWb.SO();
            }
            if (this.oWg != null) {
                this.oWg.SO();
            }
            if (this.oSP != null) {
                this.oSP.SO();
            }
            au.getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            context = ad.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            point = i.bJI().oNj;
            if (point == null) {
                au.HU();
                int i = com.tencent.mm.model.c.DT().getInt(327947, 0);
                b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 5.0f);
                layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - b;
                layoutParams.y = b + i;
            } else {
                layoutParams.x = point.x;
                layoutParams.y = point.y;
            }
            if (this.oLP != null) {
                if (this.oLP.getParent() != null && (this.oLP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.oLP.getParent()).removeView(this.oLP);
                }
                this.oWa.setCaptureView(this.oLP);
            }
            this.oWa.setTag(Integer.valueOf(this.mStatus));
            try {
                windowManager.addView(this.oWa, layoutParams);
            } catch (Exception e) {
                x.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[]{e.getMessage()});
            }
        } else {
            x.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
        }
        setHWDecMode(this.oRO);
    }

    public final String bMq() {
        String format;
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.oMa);
        if (this.oMa == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (g.isEmpty(format)) {
            return "00:00";
        }
        return format;
    }

    private void bMr() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == 261 || this.mStatus == 7) {
            this.oWg = new al(new 4(this), true);
            this.oWg.J(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(ad.getContext(), VideoActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("Voip_User", this.oLT.field_username);
        intent.putExtra("Voip_Outcall", this.oLU);
        intent.putExtra("Voip_VideoCall", this.oLV);
        intent.putExtra("Voip_Is_Talking", z);
        i.bJJ().a(intent, new 5(this));
    }

    private String bMs() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.oMa);
        if (this.oMa == -1) {
            currentTimeMillis = 0;
        }
        String string = ad.getContext().getString(R.l.voip_voice_is_talking_tip);
        if (currentTimeMillis >= 3600) {
            return string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    public final void g(String str, String str2, String str3, boolean z) {
        x.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        x.k("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + z, new Object[0]);
        if (z) {
            this.oWb = new al(new 6(this, str, str2, str3), true);
            this.oWb.J(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(ad.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.oLT.field_username);
        intent.putExtra("Voip_Outcall", this.oLU);
        intent.putExtra("Voip_VideoCall", this.oLV);
        Notification a = com.tencent.mm.plugin.voip.b.d.a(new Builder(ad.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentText(str3).setContentIntent(PendingIntent.getActivity(ad.getContext(), 40, intent, 134217728)).setOngoing(true));
        a.icon = VERSION.SDK_INT < 19 ? R.g.notification_icon : R.g.notification_icon_gray;
        au.getNotification().a(40, a, false);
    }

    private void bMt() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.oWb != null) {
            this.oWb.SO();
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        au.getNotification().cancel(40);
        if (this.oWa != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.oWa.getLayoutParams();
            i.bJI().oNj = new Point(layoutParams.x, layoutParams.y);
            this.oWa.uninit();
            try {
                ((WindowManager) ad.getContext().getSystemService("window")).removeView(this.oWa);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[]{e});
            }
            this.oWa = null;
        }
        i.bJJ().OI(ad.getContext().getString(R.l.multitalk_end_wording));
        if (this.oWg != null) {
            this.oWg.SO();
        }
        i.bJJ().dismiss();
    }

    public final void aL(int i, String str) {
        int i2;
        if (i == 241) {
            Toast.makeText(ad.getContext(), str, 1).show();
        }
        x.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.voip_errorhint_notsupport;
        } else if (i == 233) {
            i.bJI().bKX();
            i2 = R.l.voip_errorhint_notcontact;
        } else {
            i2 = i == 237 ? (!com.tencent.mm.al.b.PD() || this.oLV) ? R.l.voip_errorhint_plugclose : R.l.voip_errorhint_voice_plugclose_for_oversea : i == JsApiGetSetting.CTRL_INDEX ? R.l.voip_inblacklist : i == 211 ? R.l.voip_errorhint_userbusy : 0;
        }
        if (i2 == 0) {
            yY(R.l.voip_disconnect_tip);
        } else {
            yY(i2);
        }
    }

    public final void OH(String str) {
    }

    public final void c(int i, int i2, int[] iArr) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.oWa != null) {
            this.oWa.c(i, i2, iArr);
        }
    }

    public final void bKB() {
        if (this.oWa != null) {
            this.oWa.bKB();
        }
    }

    public final void setHWDecMode(int i) {
        if (this.oWa != null) {
            this.oWa.setHWDecMode(i);
        }
        this.oRO = i;
    }

    public final void setScreenEnable(boolean z) {
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.oWa != null) {
            this.oWa.a(bArr, j, i, i2, i3, i4, i5);
        }
    }

    public final Context bLD() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        x.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.oWd) {
            h hVar = h.mEJ;
            Object[] objArr = new Object[3];
            if (this.oWe) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.oWd) / 1000);
            objArr[2] = Integer.valueOf(this.oNm ? 1 : 2);
            hVar.h(11620, objArr);
        }
        if (this.oWc != null && this.oWc.isHeld()) {
            this.oWc.release();
        }
        bMt();
        if (this.oWb != null) {
            this.oWb.SO();
        }
        if (this.oWg != null) {
            this.oWg.SO();
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        au.getNotification().cancel(40);
        this.oLP = null;
    }

    public final void setConnectSec(long j) {
        this.oMa = j;
        if (this.oWa != null) {
            this.oWa.setConnectSec(j);
        } else if (261 == this.mStatus || 7 == this.mStatus) {
            String bMs = bMs();
            g(bMs, r.gT(this.oLT.field_username), bMs, false);
        }
    }

    public final void bLE() {
        Toast.makeText(ad.getContext(), R.l.voip_net_status_warning_hint, 1).show();
    }

    public final void aYv() {
    }

    public final void setCaptureView(CaptureView captureView) {
        this.oLP = captureView;
        if (this.oWa != null && this.oLP != null) {
            if (this.oLP.getParent() != null && (this.oLP.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.oLP.getParent()).removeView(this.oLP);
            }
            this.oWa.setCaptureView(captureView);
        }
    }
}
