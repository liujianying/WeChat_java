package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.location.ui.n.a;
import com.tencent.mm.plugin.map.a$e;
import com.tencent.mm.plugin.map.a.b;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class i extends a implements e {
    protected long bJC = -1;
    private boolean bUY = true;
    private boolean fTW = false;
    public d iMQ = new d(this.activity);
    private long kHe = 0;
    private String kKs = "";
    n kKt;
    com.tencent.mm.ui.widget.a.d kKu;
    boolean kKv = false;
    private Runnable kKw;
    private a$a kKx = new 5(this);

    public i(Activity activity) {
        super(activity);
        g.DF().a(424, this);
    }

    public boolean aZX() {
        if (this.kKu == null || !this.kKu.isShowing()) {
            bap();
            this.kKu.bXO();
        } else {
            this.kKu.bzW();
        }
        return true;
    }

    final void bap() {
        this.kKu = new com.tencent.mm.ui.widget.a.d(this.activity, 1, false);
        this.kKu.ofp = new 1(this);
        this.kKu.ofq = new 2(this);
    }

    void aZW() {
        n nVar;
        this.kHR.kIh.setEnabled(true);
        this.kHR.kId.setVisibility(8);
        c(this.kHP);
        this.kHR.kEZ.getIController().setZoom(this.kCy);
        this.kHR.kIf.setEnabled(true);
        this.bUY = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.bUY) {
            this.kHR.kIf.setVisibility(0);
        } else {
            this.kHR.kIf.setVisibility(8);
        }
        this.kKs = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!bi.oW(this.kKs) && (w.chN() || w.chM())) {
            this.kKv = true;
        } else if (w.chN() || w.chM()) {
            this.kKv = false;
            try {
                bim bim = (bim) new v((float) this.kHP.kCx, (float) this.kHP.kCw, this.bJC).diG.dID.dIL;
                v vVar = new v(bim);
                g.DF().a(new v(bim), 0);
            } catch (Exception e) {
                x.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.kHR.kIf.setOnClickListener(new 3(this));
        this.kKt = new n(this.kHR.kEZ, this.activity, bak());
        n nVar2 = this.kKt;
        if (nVar2.mViewManager != null) {
            nVar2.mViewManager.addView(nVar2.kHF, 0.0d, 0.0d);
            nVar2.mViewManager.setMarkerTag(nVar2.kHF, "info_window_tag");
            if (nVar2.kHI) {
                nVar2.mViewManager.setInfoWindowAdapter(new a(nVar2, (byte) 0));
                nVar2.mViewManager.showInfoWindowByView(nVar2.kHF);
            }
        }
        this.kKt.b(this.kHP);
        if (!com.tencent.mm.plugin.location.model.e.k(this.kHP.kCw, this.kHP.kCx)) {
            x.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[]{Double.valueOf(this.kHP.kCw), Double.valueOf(this.kHP.kCx)});
            nVar = this.kKt;
            nVar.kEX = false;
            nVar.kHG.setVisibility(8);
        }
        if (2 == this.type) {
            x.i("MicroMsg.ViewMapUI", "location id %s", new Object[]{this.kHP.kCv});
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                aZT();
            }
            if (!bi.oW(this.kHP.kCz)) {
                this.kHR.kIe.setVisibility(0);
            }
        }
        this.kHT.put(this.kHP.kCv, this.kKt);
        if (this.kHP.aYZ()) {
            if (!(this.kFa == null || this.kFa.equals(""))) {
                this.kKt.kFa = this.kFa;
            }
            this.kKt.setText(this.kKt.getPreText() + this.kHP.kCz);
        } else if (com.tencent.mm.plugin.location.model.e.k(this.kHP.kCw, this.kHP.kCx)) {
            this.kHU.a(this.kHP.kCw, this.kHP.kCx, this.kIb, this.kHP.kCv);
        }
        nVar = this.kKt;
        4 4 = new 4(this);
        if (nVar.kHI && nVar.mViewManager != null) {
            nVar.mViewManager.setMarkerClick(nVar.kHF, 4);
        }
    }

    protected void bam() {
    }

    protected void baj() {
    }

    protected final void baq() {
        if (this.kKv) {
            r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.kKs);
            intent.putExtra("title", h.scan_entry_street);
            intent.putExtra("webview_bg_color_rsID", b.black);
            com.tencent.mm.bg.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.kIa != null) {
            this.kIa.b(this.kKx, true);
        }
    }

    public void onPause() {
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.kIa != null) {
            this.kIa.c(this.kKx);
        }
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        x.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.kCy = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.kCy <= 0) {
            this.kCy = 15;
        }
        this.kFa = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        x.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.kHP;
        locationInfo.kCw = doubleExtra;
        locationInfo.kCx = doubleExtra2;
        locationInfo.kCz = stringExtra;
        locationInfo.kCy = this.kCy;
        locationInfo.bWB = this.kFa;
        this.bJC = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.kDN = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
    }

    protected void aZV() {
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.kHO.kEC);
        intent.putExtra("kopenOthersNums", this.kHO.kED);
        intent.putExtra("kopenreportType", this.kHO.ecA);
        intent.putExtra("kRemark", aZU());
        intent.putExtra("soso_street_view_url", this.kKs);
        this.activity.setResult(-1, intent);
    }

    protected final void bar() {
        x.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[]{Double.valueOf(this.kHP.kCw), Double.valueOf(this.kHP.kCx)});
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.kHO.kEC);
        intent.putExtra("kopenOthersNums", this.kHO.kED);
        intent.putExtra("kopenreportType", this.kHO.ecA);
        intent.putExtra("kRemark", aZU());
        intent.putExtra("kwebmap_slat", this.kHP.kCw);
        intent.putExtra("kwebmap_lng", this.kHP.kCx);
        intent.putExtra("Kwebmap_locaion", this.kHP.kCz);
        intent.putExtra("kPoiName", this.kFa);
        this.activity.setResult(-1, intent);
        this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        this.activity.finish();
    }

    protected final void bas() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(3), ""});
        x.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[]{Double.valueOf(this.kHP.kCw), Double.valueOf(this.kHP.kCx), Double.valueOf(this.kHQ.kCw), Double.valueOf(this.kHQ.kCx)});
        if (this.kHQ.aYY()) {
            bam();
            return;
        }
        this.kHV = true;
        if (this.handler != null) {
            if (this.kKw != null) {
                this.handler.removeCallbacks(this.kKw);
            }
            this.kKw = new 6(this);
            this.handler.postDelayed(this.kKw, 10000);
            Context context = this.activity;
            getString(h.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(context, getString(h.get_location), true, new 7(this));
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.kHO;
                Intent intent2;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
                            } else {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Parcelable intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bi.oW(locationInfo.kCA) ? "zh-cn" : locationInfo.kCA), new Object[]{Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo2.kCx), Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(dVar.context, AppChooserUI.class);
                            intent2.putExtra("type", 1);
                            intent2.putExtra("title", dVar.context.getResources().getString(h.location_info_send_tip));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent2, 4099);
                            return;
                        } else {
                            return;
                        }
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(524288);
                            dVar.context.startActivity(intent2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onDestroy() {
        this.iMQ.release();
        this.handler.removeCallbacks(this.kKw);
        this.handler = null;
        g.DF().b(424, this);
        super.onDestroy();
    }

    protected final String Wm() {
        return getString(h.location_see_info);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jUm = motionEvent.getX();
                this.hlo = motionEvent.getY();
                this.kHe = System.currentTimeMillis();
                this.fTW = false;
                bal();
                break;
            case 1:
                if (!this.fTW) {
                    System.currentTimeMillis();
                    break;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.jUm) > 10.0f || Math.abs(motionEvent.getY() - this.hlo) > 10.0f) {
                    this.fTW = true;
                    bai();
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void bai() {
    }

    public void bal() {
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (lVar.getType() != 424) {
            x.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i2 == 0 && i == 0) {
            String mY = v.mY(((v) lVar).Ru().rjF);
            x.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[]{mY});
            this.kKs = mY;
            if (!bi.oW(mY)) {
                this.kKv = true;
            }
            if (this.type == 9 && !bi.oW(mY)) {
                TextView textView = (TextView) findViewById(a$e.street_tv);
                textView.setVisibility(0);
                textView.setOnClickListener(new 8(this));
            }
        }
    }

    protected boolean bak() {
        return true;
    }
}
