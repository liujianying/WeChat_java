package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.s;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.r.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object kGR = new Object();
    private a cXs = new 4(this);
    private boolean fTW = false;
    protected float hlo = 0.0f;
    protected float jUm = 0.0f;
    public bxg kDI;
    private i.a kDU = new 5(this);
    d kEH;
    boolean kEI = false;
    public List<bxg> kGQ;
    public TrackPoint kGS;
    TrackPointAnimAvatar kGT;
    boolean kGU = false;
    public boolean kGV = false;
    public boolean kGW = true;
    public boolean kGX = false;
    public boolean kGY = false;
    public boolean kGZ = false;
    public btp kHa;
    public boolean kHb = true;
    public boolean kHc = true;
    private boolean kHd = false;
    private long kHe = 0;
    private OnTouchListener kHf = new 1(this);
    OnClickListener kHg = new OnClickListener() {
        public final void onClick(View view) {
        }
    };
    OnClickListener kHh = new 3(this);
    public a kHi = null;
    Context mContext;

    static /* synthetic */ boolean a(m mVar, int i, int i2) {
        if (mVar.kGQ != null) {
            ArrayList arrayList = new ArrayList();
            float b = (float) b.b(mVar.mContext, 85.0f);
            for (bxg bxg : mVar.kGQ) {
                Point pointByGeoPoint = mVar.kEH.getPointByGeoPoint(bxg.stK.rjj, bxg.stK.rji);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(bxg.stK.rjj), Double.valueOf(bxg.stK.rji), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y)});
                if (f.o(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) b)) {
                    arrayList.add(bxg.rdS);
                }
            }
            if (mVar.kDI != null) {
                Point pointByGeoPoint2 = mVar.kEH.getPointByGeoPoint(mVar.kDI.stK.rjj, mVar.kDI.stK.rji);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(mVar.kDI.stK.rjj), Double.valueOf(mVar.kDI.stK.rji), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y)});
                if (f.o(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) b)) {
                    arrayList.add(mVar.kDI.rdS);
                }
            }
            x.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", new Object[]{Integer.valueOf(arrayList.size())});
            if (arrayList.size() > 1) {
                h.mEJ.h(10997, new Object[]{"12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                b.b(mVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void c(m mVar) {
        boolean z = true;
        if (mVar.kGY) {
            mVar.gj(false);
        }
        Collection childs = mVar.kEH.getChilds();
        for (Object next : childs) {
            if (next instanceof TrackPoint) {
                if (((TrackPoint) next).kKl.getVisibility() == 0) {
                    break;
                }
            }
        }
        z = false;
        for (Object next2 : childs) {
            if (next2 instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) next2).ban();
                } else {
                    ((TrackPoint) next2).bao();
                }
            }
        }
    }

    public m(Context context, d dVar, boolean z) {
        this.mContext = context;
        this.kEI = z;
        this.kEH = dVar;
        this.kGQ = new ArrayList();
        dVar.setMapViewOnTouchListener(this.kHf);
    }

    public final void gj(boolean z) {
        if (z) {
            if ((this.kGS != null ? 1 : 0) != 0) {
                h.mEJ.h(10997, new Object[]{"20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else {
                return;
            }
        }
        this.kGY = z;
    }

    public final void destroy() {
        synchronized (kGR) {
            if (this.kGQ != null) {
                this.kGQ.clear();
            }
            this.kEH.clean();
        }
    }

    public final void gk(boolean z) {
        if (!(!z || this.kGX || this.kEH == null)) {
            for (Object next : this.kEH.getChilds()) {
                if (next instanceof TrackPoint) {
                    ((TrackPoint) next).bao();
                }
            }
        }
        this.kGX = z;
    }

    public final void bt(List<bxg> list) {
        int i;
        this.kGU = true;
        int size = this.kGQ.size() + 1;
        synchronized (kGR) {
            this.kGQ.clear();
            for (i = 0; i < list.size(); i++) {
                this.kGQ.add(list.get(i));
            }
        }
        int size2 = this.kGQ.size() + 1;
        synchronized (kGR) {
            Object viewByItag;
            TrackPoint trackPoint;
            Set<String> tags = this.kEH.getTags();
            HashSet hashSet = new HashSet();
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kGQ.size()) {
                    break;
                }
                hashSet.add(((bxg) this.kGQ.get(i2)).rdS);
                i = i2 + 1;
            }
            List<String> linkedList = new LinkedList();
            for (String str : tags) {
                if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                    if (this.kGS == null || !this.kGS.equals(this.kEH.getViewByItag(str))) {
                        linkedList.add(str);
                    }
                }
            }
            for (String str2 : linkedList) {
                viewByItag = this.kEH.getViewByItag(str2);
                if (viewByItag instanceof TrackPoint) {
                    trackPoint = (TrackPoint) viewByItag;
                    if (trackPoint.mViewManager != null) {
                        trackPoint.mViewManager.removeView(trackPoint.kKl);
                        trackPoint.mViewManager.removeView(trackPoint.kKm);
                    }
                }
                this.kEH.removeViewByTag(str2);
            }
            i = 0;
            while (true) {
                int i3 = i;
                if (i3 >= this.kGQ.size()) {
                    break;
                }
                bxg bxg = (bxg) this.kGQ.get(i3);
                Object viewByItag2 = this.kEH.getViewByItag(bxg.rdS);
                x.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[]{Integer.valueOf(i3), bxg.rdS, Double.valueOf(bxg.stK.rjj), Double.valueOf(bxg.stK.rji), Double.valueOf(bxg.stK.sds)});
                if (viewByItag2 == null) {
                    TrackPoint trackPoint2 = new TrackPoint(this.mContext, (ViewManager) this.kEH.getViewManager());
                    this.kEH.addView(trackPoint2, bxg.stK.rjj, bxg.stK.rji, bxg.rdS);
                    trackPoint2.o(bxg.stK.rjj, bxg.stK.rji);
                    trackPoint2.setOnAvatarOnClickListener(this.kHh);
                    trackPoint2.setOnLocationOnClickListener(this.kHg);
                    trackPoint = trackPoint2;
                } else if (viewByItag2 instanceof TrackPoint) {
                    ((TrackPoint) viewByItag2).n(bxg.stK.rjj, bxg.stK.rji);
                    viewByItag = viewByItag2;
                } else {
                    viewByItag = viewByItag2;
                }
                if (viewByItag instanceof TrackPoint) {
                    trackPoint = (TrackPoint) viewByItag;
                    trackPoint.setAvatar(bxg.rdS);
                    trackPoint.v(bxg.stK.sds);
                    if (!this.kGX) {
                        trackPoint.ban();
                    }
                }
                i = i3 + 1;
            }
            if (this.kEI && this.kGU) {
                if (s.fq(l.aZi().kDN)) {
                    aZQ();
                } else if (this.kGQ.size() > 0) {
                    aZQ();
                }
            }
            if (size < 10 && size2 >= 10) {
                for (Object viewByItag3 : this.kEH.getChilds()) {
                    if (viewByItag3 instanceof TrackPoint) {
                        ((TrackPoint) viewByItag3).ban();
                    }
                }
            } else if (size >= 10 && size2 < 10) {
                for (Object viewByItag32 : this.kEH.getChilds()) {
                    if (viewByItag32 instanceof TrackPoint) {
                        ((TrackPoint) viewByItag32).bao();
                    }
                }
            }
        }
    }

    final void aZQ() {
        if (!this.kGV && this.kDI != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            if (this.kDI != null) {
                LocationInfo locationInfo = l.aZi().kDJ;
                if (this.kDI != null && e.k(locationInfo.kCw, locationInfo.kCx)) {
                    d = 2.0d * Math.abs(this.kDI.stK.rjj - locationInfo.kCw);
                    d2 = Math.abs(this.kDI.stK.rji - locationInfo.kCx) * 2.0d;
                }
                double d3 = d2;
                double d4 = d;
                for (int i = 0; i < this.kGQ.size(); i++) {
                    bxg bxg = (bxg) this.kGQ.get(i);
                    if (bxg != null && e.k(bxg.stK.rjj, bxg.stK.rji)) {
                        double abs = 2.0d * Math.abs(bxg.stK.rjj - this.kDI.stK.rjj);
                        d = Math.abs(bxg.stK.rji - this.kDI.stK.rji) * 2.0d;
                        if (abs > d4) {
                            d4 = abs;
                        }
                        if (d > d3) {
                            d3 = d;
                        }
                        x.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[]{bxg.rdS, Double.valueOf(bxg.stK.rjj), Double.valueOf(bxg.stK.rji)});
                    }
                }
                if (Math.abs(d4 - -1000.0d) >= 0.5d && Math.abs(d3 - -1000.0d) >= 0.5d) {
                    x.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.kCw + " " + locationInfo.kCx);
                    if (this.kDI != null) {
                        x.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[]{Double.valueOf(this.kDI.stK.rjj), Double.valueOf(this.kDI.stK.rji)});
                        this.kEH.zoomToSpan(this.kDI.stK.rjj, this.kDI.stK.rji, d4, d3);
                    } else if (e.k(locationInfo.kCw, locationInfo.kCx)) {
                        this.kEH.zoomToSpan(locationInfo.kCw, locationInfo.kCx, d4, d3);
                    }
                }
            }
            this.kGV = true;
        }
    }

    public final void a(d dVar) {
        if (this.kDI != null) {
            if (dVar.getZoomLevel() < 16) {
                dVar.getIController().animateTo(this.kDI.stK.rjj, this.kDI.stK.rji, 16);
            } else {
                dVar.getIController().animateTo(this.kDI.stK.rjj, this.kDI.stK.rji);
            }
        }
    }

    public final void onResume() {
        c.OB().b(this.cXs, true);
        l.aZk().a(this.kDU);
    }

    public final void onPause() {
        c.OB().c(this.cXs);
        l.aZk().b(this.kDU);
    }
}
