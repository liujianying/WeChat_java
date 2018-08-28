package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.model.h;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.plugin.map.a$f;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.ActionBarSearchView;

public final class c extends b implements e {
    private static int kIX = 11;
    private static int kIY = 12;
    private static int kIZ = 13;
    private static int kJa = 14;
    private a cXs = new 9(this);
    private String ecI = "";
    private ImageView jfx;
    private String kCK = "";
    private int kCL = 1;
    private TextView kIA;
    private LinearLayout kIB;
    private com.tencent.mm.plugin.location.ui.e kIC;
    private g kID;
    private double kIE = -85.0d;
    private double kIF = -1000.0d;
    private boolean kIG = false;
    private int kIH = 0;
    private RelativeLayout kII;
    private int kIJ;
    private int kIK;
    private int kIL;
    private boolean kIM = true;
    private boolean kIN = false;
    private boolean kIO = false;
    private FrameLayout kIP;
    private float kIQ;
    private float kIR;
    private int kIS = 0;
    private long kIT = -1;
    private long kIU = -1;
    private long kIV = -1;
    private int kIW = -1;
    FrameLayout kId;
    protected PoiHeaderView kIm;
    private PickPoi kIn;
    private MMLoadMoreListView kIo;
    private MMLoadMoreListView kIp;
    private View kIq;
    private e kIr;
    private e kIs;
    private View kIt;
    private ImageButton kIu;
    private h kIv = null;
    private f kIw = null;
    private View kIx;
    private ImageButton kIy;
    ActionBarSearchView kIz;
    private boolean kJb = false;
    private boolean kJc;
    private double lat = -85.0d;
    private double lng = -1000.0d;
    private TextView titleView;

    static /* synthetic */ void f(c cVar) {
        int i = 1;
        x.i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (cVar.kIv != null) {
            x.i("MicroMsg.MMPoiMapUI", "scene is doing");
            return;
        }
        byte[] bArr;
        if (cVar.kIG) {
            if (cVar.kIs.buffer == null) {
                x.i("MicroMsg.MMPoiMapUI", "buffer is null");
                return;
            }
            bArr = cVar.kIs.buffer;
        } else if (cVar.kIr.buffer == null) {
            x.i("MicroMsg.MMPoiMapUI", "buffer is null");
            return;
        } else {
            bArr = cVar.kIr.buffer;
        }
        int i2 = cVar.kIH == 0 ? 0 : 1;
        double d = cVar.lat;
        double d2 = cVar.lng;
        if (cVar.kIG) {
            i = 0;
        }
        cVar.kIv = new h(bArr, d, d2, i2, i, (double) cVar.kIR, (double) cVar.kIQ, cVar.kCK, cVar.ecI);
        com.tencent.mm.kernel.g.DF().a(cVar.kIv, 0);
        cVar.kIS++;
    }

    static /* synthetic */ void p(c cVar) {
        int i = cVar.kIr.kJp;
        Intent intent = new Intent();
        LocationIntent locationIntent = new LocationIntent();
        if (i >= 0 && i < cVar.kIr.getCount()) {
            f rU = cVar.kIr.getItem(i);
            locationIntent.lat = rU.bhC;
            locationIntent.lng = rU.bhD;
            locationIntent.dSa = rU.kJE;
            locationIntent.kFa = rU.mName;
            locationIntent.label = rU.kJu;
            locationIntent.kCB = rU.kJv;
            locationIntent.qyB = rU.type;
            locationIntent.bSz = cVar.kFl.getZoomLevel();
            switch (cVar.type) {
                case 0:
                    i = kIX;
                    int i2 = cVar.kIr.kJp;
                    if (cVar.kJb) {
                        i = kIZ;
                    }
                    cVar.j(i, i2, false);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            cVar.activity.setResult(-1, intent);
            cVar.activity.finish();
        }
    }

    static /* synthetic */ void u(c cVar) {
        cVar.lF(ad.getResources().getColor(b.normal_actionbar_color));
        cVar.kIG = true;
        cVar.kIp.crD();
        cVar.kIp.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            public final void aAU() {
                c.f(c.this);
            }
        });
        cVar.kIp.setOnItemClickListener(new 5(cVar));
        cVar.kIp.setOnTouchListener(new 6(cVar));
        cVar.kIo.setVisibility(8);
        cVar.kIp.setVisibility(0);
        cVar.kIp.setAdapter(cVar.kIs);
        cVar.kIp.crD();
        cVar.kIB.setVisibility(8);
        cVar.kIz.setVisibility(0);
        cVar.kIz.setFocusChangeListener(new 7(cVar));
        new ag().post(new 8(cVar));
    }

    public c(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.DF().a(457, this);
        this.kIW = (int) (System.currentTimeMillis() / 1000);
        this.kIB = (LinearLayout) findViewById(com.tencent.mm.plugin.map.a.e.header_bar);
        this.titleView = (TextView) findViewById(com.tencent.mm.plugin.map.a.e.mm_action_bar_mmtitle);
        this.titleView.setText(getString(com.tencent.mm.plugin.map.a.h.location_send_location));
        this.kII = (RelativeLayout) findViewById(com.tencent.mm.plugin.map.a.e.location_list_rl);
        this.kIo = (MMLoadMoreListView) this.activity.findViewById(com.tencent.mm.plugin.map.a.e.poi_list);
        this.kIp = (MMLoadMoreListView) this.activity.findViewById(com.tencent.mm.plugin.map.a.e.search_list);
        this.kIq = this.activity.findViewById(com.tencent.mm.plugin.map.a.e.search_prg);
        this.kIA = (TextView) findViewById(com.tencent.mm.plugin.map.a.e.search_empty);
        this.kIu = (ImageButton) findViewById(com.tencent.mm.plugin.map.a.e.locate_to_my_position);
        this.kIu.setContentDescription(getString(com.tencent.mm.plugin.map.a.h.locate_to_my_pos));
        this.kIm = (PoiHeaderView) findViewById(com.tencent.mm.plugin.map.a.e.poi_header);
        this.kFl.setBuiltInZoomControls(false);
        this.kId = (FrameLayout) findViewById(com.tencent.mm.plugin.map.a.e.control_id);
        this.kIC = new com.tencent.mm.plugin.location.ui.e(this.activity, d.poi_mylocation_icon, this.kFl);
        this.kID = new g(this.activity, this.kFl);
        this.kIn = new PickPoi(this.activity);
        this.kIn.setLocationArrow(d.location_artboard1);
        this.kId.addView(this.kIn);
        this.kIt = findViewById(com.tencent.mm.plugin.map.a.e.load);
        this.jfx = (ImageView) this.activity.findViewById(com.tencent.mm.plugin.map.a.e.title_btn_home);
        this.kIx = (LinearLayout) this.activity.findViewById(com.tencent.mm.plugin.map.a.e.title_btn_text);
        this.kIx.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(com.tencent.mm.plugin.map.a.e.action_option_text)).setText(com.tencent.mm.plugin.map.a.h.location_send);
                break;
            case 3:
                ((TextView) findViewById(com.tencent.mm.plugin.map.a.e.action_option_text)).setText(com.tencent.mm.plugin.map.a.h.app_nextstep);
                break;
            case 8:
                ((TextView) findViewById(com.tencent.mm.plugin.map.a.e.action_option_text)).setText(com.tencent.mm.plugin.map.a.h.app_finish);
                break;
        }
        this.kIy = (ImageButton) findViewById(com.tencent.mm.plugin.map.a.e.title_search_icon);
        this.kIy.setContentDescription(getString(com.tencent.mm.plugin.map.a.h.search_position));
        this.kIz = (ActionBarSearchView) findViewById(com.tencent.mm.plugin.map.a.e.search_view_helper);
        gm(false);
        this.kIr = new e(this.activity);
        this.kIs = new e(this.activity);
        this.kIs.eMT = true;
        this.kIn.setAdapter(this.kIr);
        this.kIo.setAdapter(this.kIr);
        this.kIo.setOnTouchListener(new 1(this));
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSa, "");
        if (!bi.oW(str) && (this.kIE == -85.0d || this.kIF == -1000.0d)) {
            String[] split = str.split(",");
            x.i("MicroMsg.MMPoiMapUI", "lastlocationinfo " + str);
            if (split.length == 2) {
                this.kFl.getIController().setCenter((double) ((float) ((((double) bi.WU(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) bi.WU(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.kIo.setOnLoadMoreListener(new 10(this));
        this.kIu.setOnClickListener(new 11(this));
        this.jfx.setOnClickListener(new 12(this));
        this.kIx.setOnClickListener(new 13(this));
        this.kIo.setOnItemClickListener(new 14(this));
        this.kIy.setOnClickListener(new 16(this));
        this.kIz.setHint(getString(com.tencent.mm.plugin.map.a.h.location_search_hint));
        this.kIz.ms(false);
        this.kIz.setBackClickCallback(new 17(this));
        this.kIz.setOnEditorActionListener(new 2(this));
        this.kIz.setCallBack(new 3(this));
        this.kIP = (FrameLayout) findViewById(com.tencent.mm.plugin.map.a.e.mapview_fl);
        this.kJc = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (this.kJc) {
            lF(ad.getResources().getColor(b.dark_actionbar_color));
        } else {
            lF(ad.getResources().getColor(b.normal_actionbar_color));
        }
        this.kIJ = BackwardSupportUtil.b.b(this.activity, 280.0f);
        this.kIK = BackwardSupportUtil.b.b(this.activity, 150.0f);
        int fl = com.tencent.mm.bp.a.fl(this.activity);
        int identifier = ad.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = ad.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        fl = ((fl - this.kIK) - identifier) - com.tencent.mm.bp.a.ad(this.activity, com.tencent.mm.plugin.map.a.c.DefaultActionbarHeightPort);
        if (fl > com.tencent.mm.bp.a.ad(this.activity, com.tencent.mm.plugin.map.a.c.send_poi_listview_height)) {
            x.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[]{Integer.valueOf(fl), Integer.valueOf(identifier), Integer.valueOf(r3)});
            LayoutParams layoutParams = this.kII.getLayoutParams();
            layoutParams.height = fl;
            this.kII.setLayoutParams(layoutParams);
        }
    }

    public final com.tencent.mm.plugin.r.d aZY() {
        return (com.tencent.mm.plugin.r.d) this.activity.findViewById(com.tencent.mm.plugin.map.a.e.g_mapView);
    }

    private void lF(int i) {
        this.kIB.setBackgroundColor(i);
        this.kIz.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(an.Ec(i));
        if (valueOf.booleanValue()) {
            this.jfx.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.kIy.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.titleView.setTextColor(ad.getResources().getColor(b.white_text_color));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            if (VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Af()) {
                i = VERSION.SDK_INT >= 21 ? an.n(this.activity.getResources().getColor(com.tencent.mm.w.a.d.statusbar_fg_drak_color), i) : 0;
            }
            this.activity.getWindow().setStatusBarColor(i);
            if (VERSION.SDK_INT >= 23) {
                View decorView = this.activity.getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (valueOf.booleanValue()) {
                    systemUiVisibility &= -8193;
                } else {
                    systemUiVisibility |= 8192;
                }
                decorView.setSystemUiVisibility(systemUiVisibility);
            }
        }
    }

    private void gl(boolean z) {
        a aVar;
        a aVar2;
        this.kIM = false;
        if (z) {
            aVar = new a(this, (float) (-(baa() - this.kIK)));
            aVar2 = new a(this, (float) ((-(baa() - this.kIK)) / 2));
        } else {
            aVar = new a(this, (float) (this.kIJ - baa()));
            aVar2 = new a(this, (float) ((this.kIJ - baa()) / 2));
        }
        15 15 = new 15(this, z);
        aVar.setDuration(200);
        aVar = aVar.baf();
        aVar.setAnimationListener(15);
        aVar.cr(this.kII).cr(this.kIu).bag();
        aVar2.setDuration(200);
        aVar2.baf().cr(this.kIP).bag();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
        if (this.kIG) {
            a(null);
            j(kJa, this.kIs.kJp, true);
            return false;
        }
        j(kIY, this.kIr.kJp, false);
        this.activity.finish();
        return true;
    }

    private void a(f fVar) {
        if (this.kJc) {
            lF(ad.getResources().getColor(b.dark_actionbar_color));
        } else {
            lF(ad.getResources().getColor(b.normal_actionbar_color));
        }
        this.ecI = "";
        this.kIG = false;
        this.kIq.setVisibility(8);
        this.kIp.setVisibility(8);
        this.kIz.setVisibility(8);
        this.kIz.setSearchContent("");
        this.kIA.setVisibility(8);
        this.kIo.setVisibility(0);
        this.kIo.setAdapter(this.kIr);
        this.kIr.notifyDataSetChanged();
        this.kIB.setVisibility(0);
        YC();
        if (fVar != null) {
            this.kFl.getIController().setCenter(fVar.bhC, fVar.bhD);
            this.lat = fVar.bhC;
            this.lng = fVar.bhD;
            PickPoi pickPoi = this.kIn;
            pickPoi.m(this.lat, this.lng);
            pickPoi.kJl = false;
            fu(false);
        }
    }

    public final void aZZ() {
        PickPoi pickPoi = this.kIn;
        pickPoi.kEv.clearAnimation();
        pickPoi.kEv.startAnimation(pickPoi.kEu);
        this.lat = ((double) this.kFl.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.kFl.getMapCenterY()) / 1000000.0d;
        this.kIn.m(this.lat, this.lng);
        this.kIu.setBackgroundResource(d.location_my);
        if (this.kIO) {
            gl(false);
        }
        fu(false);
        this.kJb = false;
        this.kIr.kJb = false;
    }

    private void fu(boolean z) {
        if (this.kID != null) {
            this.kID.remove();
        }
        this.kCK = ((int) (this.lat * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + this.ecI;
        if (this.kCK.equals(this.kIr.aAL)) {
            x.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[]{this.kCK});
            return;
        }
        byte[] bArr = null;
        Object obj = 1;
        if (!this.kIG) {
            this.kIo.crD();
            this.kIr.clean();
            this.kIr.FX(this.kCK);
            this.kIr.notifyDataSetChanged();
            bArr = this.kIr.buffer;
            this.kIt.setVisibility(0);
            gm(false);
            if (this.kIn.kJl) {
                this.kIr.b(this.kIn.getPoi());
            }
        } else if (this.kCL > 0 && z) {
            this.kIp.crD();
            e eVar = this.kIs;
            eVar.buffer = null;
            eVar.hxu = false;
            eVar.aAL = "";
            this.kIs.FX(this.kCK);
            this.kIs.jbY = this.ecI;
            bArr = this.kIs.buffer;
        } else if (z) {
            obj = null;
        } else {
            this.kIp.crD();
            this.kIs.clean();
            this.kIs.FX(this.kCK);
            this.kIs.jbY = this.ecI;
            bArr = this.kIs.buffer;
            this.kIs.notifyDataSetChanged();
        }
        if (obj != null) {
            this.kIv = new h(bArr, this.lat, this.lng, this.kIH == 0 ? 0 : 1, this.kIG ? 0 : 1, (double) this.kIR, (double) this.kIQ, this.kCK, this.ecI);
            com.tencent.mm.kernel.g.DF().a(this.kIv, 0);
            this.kIS++;
            if (this.kIV == -1) {
                this.kIV = System.currentTimeMillis();
                return;
            }
            return;
        }
        x.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[]{Integer.valueOf(this.kCL)});
    }

    private void j(int i, int i2, boolean z) {
        String str;
        Object obj;
        Object obj2;
        if (this.kIE == -85.0d || this.kIF == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", new Object[]{Double.valueOf(this.kIE), Double.valueOf(this.kIF)});
        }
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String obj3;
        if (z) {
            if (this.kIs.kJp < this.kIs.getCount()) {
                str2 = this.kIs.getItem(this.kIs.kJp).kJF;
                obj3 = this.kIs.getItem(this.kIs.kJp).kJv;
            }
            obj3 = str3;
        } else {
            if (this.kIr.kJp < this.kIr.getCount()) {
                str2 = this.kIr.getItem(this.kIr.kJp).kJF;
                obj3 = this.kIr.getItem(this.kIr.kJp).kJv;
            }
            obj3 = str3;
        }
        if (i2 == 0 && bi.oW(r1) && this.kIr.getCount() > 1) {
            x.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str2 = this.kIr.getItem(1).kJF;
        }
        if (this.kIr.getCount() <= 0 || z) {
            str3 = str4;
        } else {
            x.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[]{Integer.valueOf(i2)});
            obj2 = this.kIr.getItem(0).kJG;
        }
        if (i2 == 0 && !z && this.kIr.getCount() > 0) {
            int i3 = this.kIr.getItem(0).kJH;
            if (i3 >= 0) {
                x.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[]{Integer.valueOf(i3)});
                i2 = i3;
            }
        }
        x.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.kIV), Long.valueOf(this.kIU), Long.valueOf(this.kIT), Integer.valueOf(this.kIS), str, Integer.valueOf(this.kIW), str2, obj2});
        com.tencent.mm.plugin.report.service.h.mEJ.h(11135, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.kIV), Long.valueOf(this.kIU), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.kIT), Integer.valueOf(this.kIS), str, obj3, Integer.valueOf(this.kIW), str2, q.zy(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), obj2});
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.modelgeo.c.OB().b(this.cXs, true);
        com.tencent.mm.plugin.location.ui.e eVar = this.kIC;
        eVar.kEQ.b(eVar.cXs, true);
    }

    public final int getLayoutId() {
        return a$f.poi_gmap_ui;
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.modelgeo.c.OB().c(this.cXs);
        com.tencent.mm.plugin.location.ui.e eVar = this.kIC;
        eVar.kEQ.c(eVar.cXs);
    }

    private void gm(boolean z) {
        x.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[]{Boolean.valueOf(z)});
        this.kIx.setEnabled(z);
        findViewById(com.tencent.mm.plugin.map.a.e.action_option_text).setEnabled(z);
        this.kIy.setEnabled(z);
    }

    public final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.kernel.g.DF().b(457, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 457 && i == 0 && i2 == 0) {
            this.kIv = null;
            h hVar = (h) lVar;
            if (hVar.kCK.equals(this.kCK)) {
                x.i("MicroMsg.MMPoiMapUI", "isend " + hVar.hxu + "searchId: " + hVar.fuu);
                if (this.kIT == -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.kIU = currentTimeMillis;
                    this.kIT = currentTimeMillis;
                } else {
                    this.kIU = System.currentTimeMillis();
                }
                this.kCL = hVar.kCL;
                if (this.kIG) {
                    this.kIq.setVisibility(8);
                    if (this.kIs.getCount() == 0 && hVar.list != null && hVar.list.size() == 0) {
                        this.kIA.setVisibility(0);
                        this.kIp.crD();
                        return;
                    }
                    x.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[]{Boolean.valueOf(hVar.isFirst())});
                    if (hVar.isFirst()) {
                        this.kIs.kJo.clear();
                    }
                    this.kIs.a(hVar.list, hVar.kCJ, hVar.hxu, hVar.kCK);
                    if (this.kIs.hxu) {
                        this.kIp.crD();
                        return;
                    }
                    this.kIp.crC();
                    this.kIp.crE();
                    return;
                }
                if (this.kIm != null) {
                    afv afv = (afv) hVar.diG.dIE.dIL;
                    PoiHeaderView poiHeaderView = this.kIm;
                    CharSequence charSequence = afv.rBM;
                    String str2 = afv.rJf;
                    String str3 = afv.jPK;
                    String Gb = com.tencent.mm.plugin.p.c.Gb();
                    x.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[]{str2, str3});
                    poiHeaderView.kFg = str3;
                    poiHeaderView.kFh = "";
                    if (bi.oW(charSequence) || bi.oW(str2)) {
                        poiHeaderView.setVisibility(8);
                        poiHeaderView.hND.setVisibility(8);
                        poiHeaderView.kFi.setVisibility(8);
                    } else {
                        poiHeaderView.setVisibility(0);
                        poiHeaderView.hND.setVisibility(0);
                        poiHeaderView.kFi.setVisibility(0);
                        poiHeaderView.hND.setText(charSequence);
                        SimpleImageView simpleImageView = poiHeaderView.kFi;
                        simpleImageView.imagePath = Gb;
                        simpleImageView.url = str2;
                        simpleImageView.kGn = 0;
                        simpleImageView.kGo = 0;
                        Bitmap decodeFile;
                        if (str2 == null || str2.length() == 0) {
                            simpleImageView.setVisibility(8);
                        } else if (str2.startsWith("http")) {
                            decodeFile = BitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.a.g.u(str2.getBytes()));
                            if (decodeFile != null) {
                                if (simpleImageView.kGn > 0 && simpleImageView.kGo > 0) {
                                    decodeFile = com.tencent.mm.sdk.platformtools.c.a(decodeFile, simpleImageView.kGn, simpleImageView.kGo, true, false);
                                }
                                simpleImageView.setImageBitmap(decodeFile);
                            } else {
                                com.tencent.mm.sdk.f.e.post(new SimpleImageView.a(str2, simpleImageView.handler), "SimpleImageView_download");
                            }
                        } else if (com.tencent.mm.a.e.cn(str2)) {
                            decodeFile = (simpleImageView.kGn <= 0 || simpleImageView.kGo <= 0) ? com.tencent.mm.sdk.platformtools.c.Wb(str2) : com.tencent.mm.sdk.platformtools.c.e(str2, simpleImageView.kGn, simpleImageView.kGo, true);
                            if (decodeFile == null) {
                                simpleImageView.setVisibility(8);
                            } else {
                                simpleImageView.setImageBitmap(decodeFile);
                            }
                        } else {
                            simpleImageView.setVisibility(8);
                        }
                    }
                }
                this.kIt.setVisibility(8);
                gm(true);
                if (this.kIw != null) {
                    for (f fVar : hVar.list) {
                        if (fVar.kJu != null && fVar.mName != null && fVar.kJu.equals(this.kIw.kJu) && fVar.mName.equals(this.kIw.mName)) {
                            hVar.list.remove(fVar);
                            break;
                        }
                    }
                    this.kIr.b(this.kIw);
                    this.kIw = null;
                    this.kJb = true;
                    this.kIr.kJb = true;
                }
                this.kIr.a(hVar.list, hVar.kCJ, hVar.hxu, hVar.kCK);
                this.kIr.kJp = 0;
                this.kIr.notifyDataSetChanged();
                if (this.kIr.hxu) {
                    this.kIo.crD();
                    return;
                }
                this.kIo.crC();
                this.kIo.crE();
                return;
            }
            x.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.kCK + " " + hVar.kCK);
        }
    }

    public final void rT(int i) {
        ((FrameLayout.LayoutParams) this.kII.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.kIu.getLayoutParams()).topMargin = i - BackwardSupportUtil.b.b(this.activity, 65.0f);
        int i2 = (i - this.kIL) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kIP.getLayoutParams();
        if (i == this.kIK) {
            layoutParams.topMargin = BackwardSupportUtil.b.b(this.activity, -65.0f);
        } else if (i == this.kIJ) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.kIP.requestLayout();
        this.kIL = i;
        this.kII.requestLayout();
        this.kIu.requestLayout();
    }

    public final int baa() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.kII.getLayoutParams();
        this.kIL = marginLayoutParams.topMargin;
        return marginLayoutParams.topMargin;
    }
}
