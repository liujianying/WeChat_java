package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b.b;
import b.c.b.e;
import b.c.b.i;
import b.c.b.j;
import b.c.b.l;
import b.e.d;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.e$e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.y;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Arrays;

@a(19)
public final class RadarSearchUI extends MMBaseActivity {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] mkL = new d[]{(d) j.a(new i(j.X(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;"))};
    public static final a mlm = new a((byte) 0);
    private boolean eLU = true;
    private final b mll;

    private final RadarViewController bpC() {
        return (RadarViewController) this.mll.getValue();
    }

    public RadarSearchUI() {
        int i = c.radar_play_container;
        e.i(this, "$receiver");
        this.mll = i.a((b.c.a.a) new i.a(this, i));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView(com.tencent.mm.plugin.radar.a.d.radar_view);
        RadarViewController bpC = bpC();
        View findViewById = bpC.findViewById(c.radar_main_layer);
        e.h(findViewById, "findViewById(R.id.radar_main_layer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new b.i("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = bpC.getContext();
        if (context == null) {
            throw new b.i("null cannot be cast to non-null type android.app.Activity");
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        e.h(windowManager, "(context as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams2);
        RadarTipsView radarTips = bpC.getRadarTips();
        radarTips.getNoviceEducationTips().setOnClickListener((OnClickListener) new RadarTipsView.c(radarTips));
        RadarTipsView radarTips2 = bpC.getRadarTips();
        RadarTipsView.a aVar = RadarTipsView.mmo;
        radarTips2.mmi = RadarTipsView.bpL();
        d dVar = d.mlk;
        int bpB = d.bpB();
        radarTips2.mma.sendEmptyMessageDelayed(radarTips2.mlX, (long) bpB);
        radarTips2.mma.sendEmptyMessageDelayed(radarTips2.mlW, (long) (bpB + 8000));
        bpC.getRadarTips().setPressingDown(true);
        bpC.getQuitBtn().setOnClickListener(bpC.mmF);
        LayoutParams layoutParams3 = bpC.getQuitBtn().getLayoutParams();
        if (layoutParams3 == null) {
            throw new b.i("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        bpB = layoutParams4.topMargin;
        if (ak.gw(bpC.getContext())) {
            bpB += ak.gv(bpC.getContext());
        }
        layoutParams4.setMargins(layoutParams4.leftMargin, bpB, layoutParams4.rightMargin, layoutParams4.bottomMargin);
        bpC.getQuitBtn().setLayoutParams(layoutParams4);
        RadarWaveView waveView = bpC.getWaveView();
        waveView.mnh = waveView.findViewById(c.radar_rotate_wave_iv);
        waveView.mni = AnimationUtils.loadAnimation(waveView.getContext(), com.tencent.mm.plugin.radar.a.a.radar_wave_rotate);
        Animation animation = waveView.mni;
        if (animation == null) {
            e.cJM();
        }
        animation.setInterpolator(new LinearInterpolator());
        b.a aVar2 = b.a.mkK;
        findViewById = bpC.findViewById(c.self_round_avatar);
        e.h(findViewById, "findViewById(R.id.self_round_avatar)");
        ImageView imageView = (ImageView) findViewById;
        String GF = q.GF();
        e.h(GF, "ConfigStorageLogic.getUsernameFromUserInfo()");
        b.a.a(imageView, GF);
        bpC.getMemberDetailView().setListener((RadarMemberView.b) new RadarViewController.e(bpC));
        RadarSpecialGridView grid = bpC.getGrid();
        context = bpC.getContext();
        e.h(context, "context");
        bpC.mmC = new RadarViewController.c(bpC, grid, context);
        bpC.getGrid().setOnItemClickListener((RadarSpecialGridView$a) new g(bpC));
        RadarViewController bpC2 = bpC();
        com.tencent.mm.plugin.radar.b.c cVar = bpC2.mmB;
        com.tencent.mm.kernel.c.a l = com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class);
        e.h(l, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.i) l).FR().a((m.b) cVar);
        com.tencent.mm.sdk.b.a.sFg.b((com.tencent.mm.sdk.b.c) cVar.mjr);
        com.tencent.mm.kernel.b.a n = com.tencent.mm.kernel.g.n(o.class);
        e.h(n, "plugin(IPluginMessengerFoundation::class.java)");
        ((o) n).getSysCmdMsgExtension().a("addcontact", (bv.a) cVar.mjs, true);
        com.tencent.mm.plugin.radar.b.e eVar = bpC2.mmA;
        if (eVar == null) {
            e.adK("radarManager");
        }
        com.tencent.mm.kernel.g.DF().a(425, (com.tencent.mm.ab.e) eVar);
        com.tencent.mm.kernel.g.DF().a(Downloads.DOWNLOAD_ERR_SOCKET_TIMEOUT, (com.tencent.mm.ab.e) eVar);
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(229377, Integer.valueOf(0));
        if (obj == null) {
            throw new b.i("null cannot be cast to non-null type kotlin.Int");
        }
        com.tencent.mm.kernel.g.Ei().DT().set(229377, Integer.valueOf(((Integer) obj).intValue() + 1));
    }

    public final void onResume() {
        super.onResume();
        if (this.eLU) {
            x.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.permission.a.a((Activity) this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                bpD();
            }
        }
    }

    private final void bpD() {
        hl(true);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.mjV;
        com.tencent.mm.plugin.radar.b.d.bSU = 0;
        com.tencent.mm.plugin.radar.b.d.mjR = 0;
        com.tencent.mm.plugin.radar.b.d.mjR = com.tencent.mm.plugin.radar.b.d.bpr();
        dVar = com.tencent.mm.plugin.radar.b.d.mjV;
        com.tencent.mm.plugin.radar.b.d.mjS = 0;
        com.tencent.mm.plugin.radar.b.d.mjQ = 0;
        com.tencent.mm.plugin.radar.b.d.mjO = 0;
        com.tencent.mm.plugin.radar.b.d.mjP = 0;
        com.tencent.mm.plugin.radar.b.d.mjQ = com.tencent.mm.plugin.radar.b.d.bpr();
        h.mEJ.a(com.tencent.mm.plugin.radar.b.d.mjT, com.tencent.mm.plugin.radar.b.d.mjU, 1, false);
        if (bpC().getRadarStatus() == e$e.SEARCHING || bpC().getRadarStatus() == e$e.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.b.e eVar = bpC().mmA;
            if (eVar == null) {
                e.adK("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.dMm;
            if (cVar != null) {
                cVar.b(eVar.cXs);
            }
            eVar = bpC().mmA;
            if (eVar == null) {
                e.adK("radarManager");
            }
            eVar.bps();
            bpC().getWaveView().bpO();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        e.i(strArr, "permissions");
        e.i(iArr, "grantResults");
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        Thread currentThread = Thread.currentThread();
        e.h(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        x.i(TAG, "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bpD();
                    return;
                }
                this.eLU = false;
                com.tencent.mm.ui.base.h.a((Context) this, getString(f.permission_location_request_again_msg), getString(f.permission_tips_title), getString(f.jump_to_settings), getString(f.permission_cancel), false, (DialogInterface.OnClickListener) new b(this), (DialogInterface.OnClickListener) new c(this));
                return;
            default:
                return;
        }
    }

    public final void onPause() {
        long bpr;
        int i;
        String format;
        super.onPause();
        hl(false);
        com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.mjV;
        if (com.tencent.mm.plugin.radar.b.d.mjR != 0) {
            bpr = com.tencent.mm.plugin.radar.b.d.bpr() - com.tencent.mm.plugin.radar.b.d.mjR;
            d dVar2 = d.mlk;
            if (d.em(bpr)) {
                boolean i2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = com.tencent.mm.plugin.radar.b.d.bSU;
                x.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[]{Integer.valueOf(i2)});
                h hVar = h.mEJ;
                l lVar = l.vGJ;
                format = String.format("%d", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                e.h(format, "java.lang.String.format(format, *args)");
                hVar.k(10679, format);
                com.tencent.mm.plugin.radar.b.d.mjO++;
                com.tencent.mm.plugin.radar.b.d.mjP = bpr + com.tencent.mm.plugin.radar.b.d.mjP;
                com.tencent.mm.plugin.radar.b.d.mjR = 0;
            }
        }
        dVar = com.tencent.mm.plugin.radar.b.d.mjV;
        if (com.tencent.mm.plugin.radar.b.d.mjQ != 0) {
            bpr = System.currentTimeMillis() - com.tencent.mm.plugin.radar.b.d.mjQ;
            i2 = com.tencent.mm.plugin.radar.b.d.mjO;
            float f = (((float) com.tencent.mm.plugin.radar.b.d.mjP) * 1.0f) / 1000.0f;
            int i3 = com.tencent.mm.plugin.radar.b.d.mjS;
            float f2 = (((float) bpr) * 1.0f) / 1000.0f;
            x.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2)});
            h hVar2 = h.mEJ;
            l lVar2 = l.vGJ;
            format = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Float.valueOf(f2)}, 5));
            e.h(format, "java.lang.String.format(format, *args)");
            hVar2.k(10676, format);
        }
        if (bpC().getRadarStatus() == e$e.SEARCHING || bpC().getRadarStatus() == e$e.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.b.e eVar = bpC().mmA;
            if (eVar == null) {
                e.adK("radarManager");
            }
            eVar.bpt();
            eVar = bpC().mmA;
            if (eVar == null) {
                e.adK("radarManager");
            }
            com.tencent.mm.modelgeo.c cVar = eVar.dMm;
            if (cVar != null) {
                cVar.c(eVar.cXs);
            }
            bpC().getWaveView().bpP();
        }
    }

    public final void onDestroy() {
        RadarViewController bpC = bpC();
        com.tencent.mm.plugin.radar.b.c cVar = bpC.mmB;
        com.tencent.mm.kernel.c.a l = com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class);
        e.h(l, "service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.i) l).FR().b((m.b) cVar);
        com.tencent.mm.sdk.b.a.sFg.c((com.tencent.mm.sdk.b.c) cVar.mjr);
        com.tencent.mm.kernel.b.a n = com.tencent.mm.kernel.g.n(o.class);
        e.h(n, "plugin(IPluginMessengerFoundation::class.java)");
        ((o) n).getSysCmdMsgExtension().b("addcontact", (bv.a) cVar.mjs, true);
        com.tencent.mm.plugin.radar.b.e eVar = bpC.mmA;
        if (eVar == null) {
            e.adK("radarManager");
        }
        com.tencent.mm.kernel.g.DF().b(425, (com.tencent.mm.ab.e) eVar);
        com.tencent.mm.kernel.g.DF().b(Downloads.DOWNLOAD_ERR_SOCKET_TIMEOUT, (com.tencent.mm.ab.e) eVar);
        eVar.stop();
        com.tencent.mm.modelgeo.c cVar2 = eVar.dMm;
        if (cVar2 != null) {
            cVar2.c(eVar.cXs);
        }
        RadarWaveView waveView = bpC.getWaveView();
        try {
            MediaPlayer mediaPlayer = waveView.mng;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            waveView.mng = null;
        } catch (Exception e) {
            x.printErrStackTrace(RadarWaveView.TAG, e, "", new Object[0]);
            x.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
            waveView.mng = null;
        }
        super.onDestroy();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        e.i(keyEvent, "event");
        boolean onKeyDown = bpC().onKeyDown(i, keyEvent);
        if (onKeyDown) {
            return onKeyDown;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void hl(boolean z) {
        rp rpVar = new rp();
        rpVar.ccv.ccw = z;
        com.tencent.mm.sdk.b.a.sFg.m((com.tencent.mm.sdk.b.b) rpVar);
    }

    public final Object getSystemService(String str) {
        e.i(str, "name");
        Object systemService = super.getSystemService(str);
        if (e.i("layout_inflater", str)) {
            if (systemService == null) {
                throw new b.i("null cannot be cast to non-null type android.view.LayoutInflater");
            }
            systemService = y.b((LayoutInflater) systemService);
        }
        e.h(systemService, "if (Context.LAYOUT_INFLA…r)\n        } else service");
        return systemService;
    }
}
