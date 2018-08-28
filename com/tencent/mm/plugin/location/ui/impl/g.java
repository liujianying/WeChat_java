package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.m$a;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.map.a$h;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c$a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends i implements a {
    private com.tencent.mm.modelgeo.a.a cXs = new 4(this);
    private View kFL;
    private m$a kHi = new m$a() {
    };
    private Button kJI;
    MyLocationButton kJJ;
    private TipSayingWidget kJK;
    m kJL;
    o kJM = l.aZi();
    com.tencent.mm.plugin.location.ui.l kJN;
    k kJO;
    private i kJP;
    private c kJQ = c.OB();
    private ShareHeader kJR;
    private String kJS;
    private long kJT = 0;
    private long kJU = 0;
    private b kJV = new 2(this);
    private o.a kJW = new o.a() {
        public final void aZt() {
            g gVar = g.this;
            c$a c_a = new c$a(gVar.activity);
            c_a.Gr(a$h.track_timeout);
            c_a.Gt(a$h.app_ok).a(new 9(gVar));
            c_a.anj().show();
        }
    };
    private HashMap<String, bxg> kJX = new HashMap();
    private WakeLock wakeLock;

    static /* synthetic */ void a(g gVar, bfv bfv) {
        com.tencent.mm.plugin.location.a.a aVar;
        bxg bxg;
        x.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", new Object[]{Boolean.valueOf(gVar.kJM.bBc)});
        List<bxg> list = bfv.sgY;
        List<bxg> linkedList = new LinkedList();
        com.tencent.mm.plugin.location.a.a FM = l.aZj().FM(gVar.kDN);
        if (FM == null) {
            FM = new com.tencent.mm.plugin.location.a.a();
            FM.latitude = -1000.0d;
            FM.longitude = -1000.0d;
            aVar = FM;
        } else {
            aVar = FM;
        }
        LinkedList linkedList2 = new LinkedList();
        for (bxg bxg2 : list) {
            linkedList2.add(bxg2.rdS);
        }
        if (!linkedList2.contains(q.GF())) {
            linkedList2.add(q.GF());
        }
        l.aZj().a(gVar.kDN, linkedList2, aVar.latitude, aVar.longitude, aVar.kCs, "", "");
        for (bxg bxg22 : list) {
            if (Math.abs(bxg22.stK.rji) > 180.0d || Math.abs(bxg22.stK.rjj) > 90.0d) {
                bxg bxg3 = (bxg) gVar.kJX.get(bxg22.rdS);
                if (bxg3 != null) {
                    linkedList.add(bxg3);
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", new Object[]{bxg22.rdS, Double.valueOf(bxg22.stK.rjj), Double.valueOf(bxg22.stK.rji), Double.valueOf(bxg3.stK.rjj), Double.valueOf(bxg3.stK.rji)});
                } else {
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", new Object[]{bxg22.rdS, Double.valueOf(bxg22.stK.rjj), Double.valueOf(bxg22.stK.rji)});
                }
            } else {
                linkedList.add(bxg22);
            }
        }
        gVar.kJX.clear();
        for (bxg bxg222 : linkedList) {
            gVar.kJX.put(bxg222.rdS, bxg222);
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(q.GF());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  " + size);
            size = 0;
            while (true) {
                int i = size;
                if (i >= linkedList.size()) {
                    break;
                }
                bxg222 = (bxg) linkedList.get(i);
                stringBuilder.append("[" + bxg222.rdS + " ] ");
                stringBuilder.append(bxg222.stK.sds + " ");
                stringBuilder.append(bxg222.stK.rjj + " ");
                stringBuilder.append(bxg222.stK.rji + " ");
                arrayList.add(bxg222.rdS);
                size = i + 1;
            }
            x.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (gVar.kJL != null) {
                gVar.kJL.bt(linkedList);
            }
        }
        if (gVar.kJL.kGX) {
            m mVar = gVar.kJL;
            btp btp = bfv.sgZ;
            if (mVar.kHa == null) {
                mVar.kHa = new btp();
            }
            if (btp != null) {
                x.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + btp.rjj + " " + btp.rji);
                mVar.kHa.sbw = btp.sbw;
                mVar.kHa.rjj = btp.rjj;
                mVar.kHa.rji = btp.rji;
            }
        }
        gVar.kJP.D(arrayList);
    }

    public final boolean aZX() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ShareMapUI", "onCreate");
        this.kJT = System.currentTimeMillis();
    }

    final void aZW() {
        super.aZW();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.kKt != null) {
            n nVar = this.kKt;
            nVar.kHG.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(e.header_bar).setVisibility(8);
        this.kJJ = (MyLocationButton) findViewById(e.locate_to_my_position);
        this.kJJ.setProgressBar(this.kHR.kEZ);
        this.kJJ.aZy();
        this.kJJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.kJJ.aZy();
                g.this.kJL.kHb = true;
                g.this.kJL.a(g.this.kHR.kEZ);
                g.this.kJL.gj(false);
                h.mEJ.h(10997, new Object[]{"6", "", Integer.valueOf(0), Integer.valueOf(0)});
            }
        });
        this.kFL = findViewById(e.header_avatar_area);
        this.kJR = (ShareHeader) findViewById(e.share_header);
        this.kJR.setVisibility(0);
        this.kJP = new i(this.activity, this.kJR.getHeaderBar(), this.kFL, this.kDN, this.kHR.kEZ);
        this.kJP.kFR = new 6(this);
        this.kJM.kDP = this.kJW;
        if (this.kJL == null) {
            this.kJL = new m(this.activity, this.kHR.kEZ, true);
        }
        this.kJL.kHi = this.kHi;
        this.kJL.kGW = false;
        this.kJN = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
        this.kJK = (TipSayingWidget) findViewById(e.saying_tips);
        this.kJI = (Button) findViewById(e.share_speak);
        this.kJI.setVisibility(0);
        this.kJO = new k(this.activity, this.kJI);
        this.kJO.kGF = this.kJP;
        this.kJR.setOnLeftClickListener(new 7(this));
        this.kJR.setOnRightClickListener(new 8(this));
        ((LocationManager) this.activity.getSystemService("location")).isProviderEnabled("gps");
        o oVar = this.kJM;
        LocationInfo locationInfo = this.kHP;
        oVar.kDS = System.currentTimeMillis();
        oVar.dMm = c.OB();
        oVar.dMm.b(oVar.cXs, true);
        if (oVar.kDF == null) {
            oVar.kDF = l.aZk();
        }
        oVar.kDF.a(oVar.kDU);
        if (locationInfo != null) {
            oVar.kDJ = locationInfo;
        }
        if (oVar.bTv) {
            x.i("MicorMsg.TrackRefreshManager", "start location " + oVar.kDJ.kCw + " " + oVar.kDJ.kCx);
        } else {
            oVar.kDH = 1;
            oVar.kDI = new bxg();
            oVar.kDI.stK = new bbe();
            oVar.kDI.stK.rjj = -1000.0d;
            oVar.kDI.stK.rji = -1000.0d;
            x.i("MicorMsg.TrackRefreshManager", "start location imp " + oVar.kDJ.kCw + " " + oVar.kDJ.kCx);
            com.tencent.mm.kernel.g.DF().a(492, oVar);
            com.tencent.mm.kernel.g.DF().a(490, oVar);
            com.tencent.mm.kernel.g.DF().a(491, oVar);
            oVar.bBc = false;
            oVar.bTv = true;
        }
        o oVar2 = this.kJM;
        b bVar = this.kJV;
        Iterator it = oVar2.kDG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar2.kDG.add(new WeakReference(bVar));
        this.kJS = this.activity.getIntent().getStringExtra("fromWhereShare");
        x.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[]{this.kJS});
        if (this.kJM.aZn()) {
            x.i("MicroMsg.ShareMapUI", "has join");
            this.kJL.gk(true);
            this.kJO.aZI();
            return;
        }
        int i;
        String GF;
        com.tencent.mm.plugin.location.model.a.b bVar2;
        o oVar3 = this.kJM;
        String str = this.kDN;
        if (!bi.oW(this.kJS)) {
            if (this.kJS.equals("fromBanner")) {
                i = 0;
            } else if (!this.kJS.equals("fromPluginLocation")) {
                if (this.kJS.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.kJS.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.kJS.equals("fromMessage")) {
                    i = 4;
                }
            }
            x.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
            oVar3.kDN = str;
            GF = q.GF();
            GF = str.contains("@chatroom") ? str : GF.compareTo(str) > 0 ? str + GF : GF + str;
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(GF);
            ((apj) bVar2.diG.dID.dIL).otY = i;
            com.tencent.mm.kernel.g.DF().a(bVar2, 0);
        }
        i = 1;
        x.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
        oVar3.kDN = str;
        GF = q.GF();
        if (str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(GF);
        ((apj) bVar2.diG.dID.dIL).otY = i;
        com.tencent.mm.kernel.g.DF().a(bVar2, 0);
    }

    public final void onResume() {
        boolean z;
        x.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.kJM;
        x.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.kDL);
        if (oVar.kDL) {
            oVar.kDS = System.currentTimeMillis();
            oVar.dMm.a(oVar.cXs);
            oVar.kDF.a(oVar.kDU);
        }
        oVar.kDL = false;
        oVar.aZo();
        oVar = this.kJM;
        d dVar = this.kHR.kEZ;
        oVar.kDH = oVar.kDM;
        x.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.kDH + " %f %f %d ", new Object[]{Double.valueOf(oVar.kCw), Double.valueOf(oVar.kCx), Integer.valueOf(oVar.kCy)});
        if (oVar.kCw == -1000.0d || oVar.kCx == -1000.0d || oVar.kCy == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(oVar.kCw, oVar.kCx);
            dVar.getIController().setZoom(oVar.kCy);
            z = true;
        }
        if (z) {
            this.kJJ.setAnimToSelf(false);
            this.kJJ.aZz();
            this.kJL.kHb = false;
            this.kJL.kGV = true;
        }
        oVar = this.kJM;
        d dVar2 = this.kHR.kEZ;
        if (oVar.kDQ != -1) {
            dVar2.getIController().setZoom(oVar.kDQ);
        }
        if (this.kJQ != null) {
            this.kJQ.a(this.cXs);
        }
        if (this.kJL != null) {
            this.kJL.onResume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.kJM;
        x.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.kDK);
        if (!oVar.kDK) {
            oVar.dMm.c(oVar.cXs);
            oVar.kDF.b(oVar.kDU);
            oVar.kDL = true;
            oVar.kDR = true;
        }
        oVar = this.kJM;
        d dVar = this.kHR.kEZ;
        oVar.kDM = oVar.kDH;
        oVar.kDH = 0;
        x.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.kDM);
        if (oVar.aZs()) {
            oVar.kCw = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.kCx = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.kCy = dVar.getZoom();
        }
        h.mEJ.h(10997, new Object[]{"17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.kJT)});
        this.kJT = System.currentTimeMillis();
        if (this.kJQ != null) {
            this.kJQ.c(this.cXs);
        }
        if (this.kJL != null) {
            this.kJL.onPause();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        o oVar = this.kJM;
        b bVar = this.kJV;
        Iterator it = oVar.kDG.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                oVar.kDG.remove(weakReference);
                break;
            }
        }
        this.kJM.kDP = null;
        if (this.kJO != null) {
            k kVar = this.kJO;
            kVar.kGE.b(kVar);
            VolumeMeter volumeMeter = kVar.kGr;
            volumeMeter.kHk = true;
            volumeMeter.dRn = false;
            if (volumeMeter.kHo != null) {
                volumeMeter.kHo.getLooper().quit();
                volumeMeter.kHo = null;
            }
        }
        if (this.kJL != null) {
            this.kJL.destroy();
        }
        if (this.kJJ != null) {
            c.OB().c(this.kJJ.cXs);
        }
        x.i("MicroMsg.ShareMapUI", "onDestory");
    }

    public final void gi(boolean z) {
    }

    protected final void aZV() {
        super.aZV();
    }

    public final void aZN() {
        this.kJM.kDQ = this.kHR.kEZ.getZoom();
        this.activity.finish();
    }

    private void bah() {
        YC();
        this.kJL.gk(false);
        this.kJM.stop();
        this.kJM.rP(3);
        k.aZL();
        this.kJM.kDQ = this.kHR.kEZ.getZoom();
        this.activity.finish();
    }

    public final void aZO() {
        this.kJL.gk(false);
        this.kJM.stop();
        this.kJM.rP(0);
        k.aZL();
        this.activity.finish();
    }

    public final void rS(int i) {
        if (i == 0) {
            h.mEJ.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            bah();
        } else if (i == 1) {
            h.mEJ.h(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            bah();
        } else if (i == 2) {
            bah();
        }
    }

    public final void aZP() {
        btp btp = this.kJL.kHa;
        if (btp != null) {
            LocationInfo locationInfo = this.kHP;
            locationInfo.kCz = btp.sbw;
            locationInfo.kCx = btp.rji;
            locationInfo.kCw = btp.rjj;
            if (TextUtils.isEmpty(btp.sbw)) {
                this.kKt.setText("");
            } else {
                this.kKt.setText(btp.sbw);
            }
            this.kKt.b(this.kHP);
            n nVar = this.kKt;
            nVar.mViewManager.updateViewLayout(nVar.kHF, nVar.kCw, nVar.kCx, false);
            if (nVar.kHI) {
                nVar.mViewManager.showInfoWindowByView(nVar.kHF);
            }
            this.kHR.kEZ.getIController().animateTo(this.kHP.kCw, this.kHP.kCx);
        }
    }

    public final void onBackPressed() {
        h.mEJ.h(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.kJN.aZM();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void bai() {
        super.bai();
        if (this.kJL != null) {
            this.kJL.kHb = false;
            this.kJL.gj(false);
            this.kJJ.aZz();
        }
    }

    protected final void baj() {
        super.baj();
        h.mEJ.h(10997, new Object[]{"1", "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
