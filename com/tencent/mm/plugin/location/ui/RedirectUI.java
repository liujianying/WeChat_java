package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.ar.c;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(23)
public class RedirectUI extends Activity {
    private static long cXx = 86400000;
    private long bJC;
    private boolean bTv = false;
    private int hER;
    private final ag handler = new ag();
    private String info = "";
    private double kCw = 0.0d;
    private double kCx = 0.0d;
    private int kCy = 0;
    private boolean kEE = true;
    private String kFm = "";
    private String kFn = "";
    private int kFo;
    private final int kFp = 1;
    private boolean kFq = false;
    private final int kFr = 0;
    private final int kFs = 1;
    private final int kFt = 0;
    private final int kFu = 1;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        if ((bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(81938, null))).longValue()) * 1000 > cXx ? 1 : 0) != 0) {
            c.Qj().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.bJC = getIntent().getLongExtra("kMsgId", -1);
        this.kFn = getIntent().getStringExtra("map_talker_name");
        x.d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.kFm = getIntent().getStringExtra("map_sender_name");
                this.hER = getIntent().getIntExtra("view_type_key", 1);
                this.kFo = getIntent().getIntExtra("key_get_location_type", 0);
                l(-85.0d, -1000.0d);
                return;
            case 1:
            case 2:
            case 7:
            case 9:
                this.kCw = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.kCx = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.kCy = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                l(this.kCw, this.kCx);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a FM = l.aZj().FM(this.kFn);
                x.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (FM != null));
                if (FM != null) {
                    this.kCw = FM.latitude;
                    this.kCx = FM.longitude;
                    this.info = FM.kCs;
                    x.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.kCw), Double.valueOf(this.kCx), this.info, Integer.valueOf(FM.bUb.size()));
                    this.kCy = 0;
                    l(this.kCw, this.kCx);
                    return;
                }
                l(-1000.0d, -1000.0d);
                return;
            default:
                return;
        }
    }

    private void l(double d, double d2) {
        this.bTv = true;
        Intent t = d.t(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                String str = "MicroMsg.RedirectUI";
                StringBuilder stringBuilder = new StringBuilder("view poi      isHidePoiOversea : ");
                boolean z = bi.getInt(com.tencent.mm.k.g.AU().G("ShowConfig", "hidePoiOversea"), 1) == 1;
                x.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + z);
                x.d(str, stringBuilder.append(z).toString());
                t.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                x.d("MicroMsg.RedirectUI", "view normal");
                t.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                x.d("MicroMsg.RedirectUI", "location resume");
                t.putExtra("intent_map_key", 5);
                if (!bi.oW(stringExtra)) {
                    t.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                t.putExtra("intent_map_key", 4);
                break;
            default:
                x.d("MicroMsg.RedirectUI", "view type error");
                t = null;
                break;
        }
        switch (this.type) {
            case 0:
                t.putExtra("location_scene", 1);
                break;
        }
        if (af.ewK) {
            this.handler.postDelayed(new 1(this, t, d, d2), 2000);
        } else {
            a(t, d, d2);
        }
    }

    private void a(Intent intent, double d, double d2) {
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            intent.putExtra("kimg_path", com.tencent.mm.plugin.p.c.Gb());
            intent.putExtra("kPoi_url", bi.aG(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", bi.aG(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.kFn);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            ro roVar = new ro();
            roVar.ccs.cct = true;
            com.tencent.mm.sdk.b.a.sFg.m(roVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.kCy > 0) {
                    intent.putExtra("kwebmap_scale", this.kCy);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.kCy > 0) {
                    intent.putExtra("kwebmap_scale", this.kCy);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                return;
            } else if (this.type == 8) {
                startActivityForResult(intent, 6);
                return;
            } else {
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + i);
        if (i2 != -1) {
            finish();
        } else if (intent == null) {
            finish();
        } else {
            LocationIntent locationIntent;
            switch (i) {
                case 2:
                    String str = this.kFn;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bGa());
                    ma maVar = new ma();
                    maVar.bWy.bWA = this.kFo;
                    maVar.bWy.lat = locationIntent.lat;
                    maVar.bWy.lng = locationIntent.lng;
                    maVar.bWy.bSz = locationIntent.bSz;
                    maVar.bWy.label = locationIntent.label;
                    maVar.bWy.bWB = locationIntent.kFa;
                    com.tencent.mm.sdk.b.a.sFg.m(maVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.bSz;
                    String str2 = locationIntent.label;
                    String str3 = locationIntent.kFa;
                    String str4 = locationIntent.qyA;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str3 = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + bi.WS(str2) + "\" poiname=\"" + bi.WS(str3) + "\" infourl=\"" + bi.WS(str4) + "\" maptype=\"0\" /></msg>";
                    x.d("MicroMsg.RedirectUI", "xml " + str3);
                    ow owVar = new ow();
                    owVar.bZQ.bZR = str;
                    owVar.bZQ.content = str3;
                    owVar.bZQ.type = 48;
                    owVar.bZQ.flags = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(owVar);
                    o.a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bGa());
                    if (locationIntent.qyB == 3) {
                        h.mEJ.h(10822, Integer.valueOf(1), locationIntent.kCB, Integer.valueOf(1));
                    } else {
                        h.mEJ.h(10822, Integer.valueOf(1), locationIntent.kCB, Integer.valueOf(0));
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.bSz);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    intent.putExtra("kPoiName", locationIntent.kFa.equals("") ? "" : locationIntent.kFa);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bGa());
                    if (locationIntent.dSa != null) {
                        x.d("MicroMsg.RedirectUI", "addr: " + locationIntent.dSa.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.dSa);
                    break;
            }
            setResult(i2, intent);
            finish();
        }
    }

    protected void onDestroy() {
        this.kEE = false;
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }
}
