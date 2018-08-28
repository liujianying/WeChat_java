package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public final class h extends i {
    MyLocationButton kJJ;
    m kJL;
    l kJN;
    private Button kJZ;
    private NewMyLocationButton kKa;
    private f kKb;
    View kKc;
    private boolean kKd = false;
    private d kKe;
    Map<String, String> kKf;
    int kKg;

    static /* synthetic */ void a(h hVar) {
        x.i("MicroMsg.TrackMapUI", "onShare");
        d.t(hVar.activity);
        Intent intent = hVar.activity.getIntent();
        intent.putExtra("intent_map_key", 5);
        intent.putExtra("kwebmap_scale", hVar.kHR.kEZ.getZoomLevel());
        a FM = com.tencent.mm.plugin.location.model.l.aZj().FM(hVar.kDN);
        if (FM != null && FM.bUb.size() > 0) {
            intent.putExtra("kwebmap_slat", FM.latitude);
            intent.putExtra("kwebmap_lng", FM.longitude);
            intent.putExtra("Kwebmap_locaion", FM.kCs);
            intent.putExtra("fromWhereShare", "fromTrackButton");
        }
        hVar.activity.startActivity(intent);
        hVar.activity.finish();
    }

    public h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kKg = ((Integer) g.Ei().DT().get(aa.a.sWX, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.TrackMapUI", "count: %s", new Object[]{Integer.valueOf(this.kKg)});
    }

    final void aZW() {
        if (this.activity.getIntent().getBooleanExtra("KFavLocSigleView", false) && this.activity.getIntent().getBooleanExtra("kFavCanRemark", false)) {
            this.kKd = true;
        }
        super.aZW();
        x.d("MicroMsg.TrackMapUI", "oldVer %s", new Object[]{Boolean.valueOf(this.kKd)});
        ((TextView) findViewById(e.mm_action_bar_mmtitle)).setText(com.tencent.mm.plugin.map.a.h.location_info);
        findViewById(e.title_search_icon).setVisibility(8);
        if (!this.kKd) {
            ViewStub viewStub = (ViewStub) findViewById(e.location_info_stub);
            viewStub.setOnInflateListener(new 1(this));
            this.kKc = viewStub.inflate();
            findViewById(e.locate_to_my_position).setVisibility(8);
            this.activity.getWindow().getDecorView().post(new 5(this));
        }
        this.kJL = new m(this.activity, this.kHR.kEZ, false);
        this.kJL.kHb = false;
        this.kJL.kHc = false;
        m mVar = this.kJL;
        mVar.kGZ = true;
        if (mVar.kGS != null) {
            mVar.kGS.setOnAvatarOnClickListener(null);
            mVar.kGS.setOnLocationOnClickListener(null);
            mVar.kGS.ban();
        }
        this.kJL.kGW = false;
        this.kJN = new l(this.activity, new 7(this));
        if (this.kKd) {
            boolean z;
            this.kJZ = (Button) findViewById(e.start_share);
            this.kJZ.setVisibility(0);
            this.kJZ.setOnClickListener(new 8(this));
            this.kJZ.setEnabled(true);
            if (this.type == 2) {
                z = false;
            } else if (this.type == 3) {
                z = false;
            } else if (this.type == 7) {
                z = false;
            } else if (this.type == 9) {
                z = false;
            } else if (this.bJC != -1) {
                bd dW = ((i) g.l(i.class)).bcY().dW(this.bJC);
                z = (s.hf(dW.field_talker) || s.hL(dW.field_talker) || ab.XO(dW.field_talker) || ab.XQ(dW.field_talker) || ab.gY(dW.field_talker)) ? false : true;
            } else {
                z = true;
            }
            if (!z) {
                this.kJZ.setVisibility(8);
            }
        } else {
            findViewById(e.start_share).setVisibility(8);
        }
        this.kHR.jfx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.this.aZV();
                h.this.YC();
                h.this.activity.finish();
            }
        });
        String stringExtra;
        if (this.kKd) {
            this.kJJ = (MyLocationButton) findViewById(e.locate_to_my_position);
            this.kJJ.setOnClickListener(new 12(this));
            if (this.type == 2 && this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                ((MarginLayoutParams) this.kJJ.getLayoutParams()).bottomMargin = com.tencent.mm.bp.a.fromDPToPix(this.activity, 80);
            }
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bi.oW(stringExtra)) {
                this.kHR.kAp.setVisibility(8);
            } else {
                this.kHR.kAp.setVisibility(0);
                this.kHR.kAp.setOnClickListener(new 2(this, stringExtra));
            }
        } else {
            this.kKa = (NewMyLocationButton) this.kKc.findViewById(e.new_locate_to_my_position);
            this.kKa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    h.this.kJL.a(h.this.kHR.kEZ);
                }
            });
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bi.oW(stringExtra)) {
                this.kHR.kAp.setVisibility(8);
            } else {
                this.kHR.kAp.setVisibility(0);
                this.kHR.kAp.setOnClickListener(new 11(this, stringExtra));
            }
        }
        if (!this.kKd) {
            this.kKt.kHF.setImageResource(com.tencent.mm.plugin.map.a.d.location_artboard1);
            this.kKb = new f(this.kHR.kEZ, this.activity);
            if (this.kHP.aYZ()) {
                if (!(this.kFa == null || this.kFa.equals(""))) {
                    this.kKb.kFa = this.kFa;
                }
                this.kKb.setText(this.kKt.getPreText() + this.kHP.kCz);
            }
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(View view) {
                    x.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                    h.this.bNP = 0;
                    h.this.baj();
                    h.this.bas();
                }
            };
            f fVar = this.kKb;
            fVar.kFd.setOnClickListener(anonymousClass6);
            fVar.kFd.setVisibility(0);
        }
    }

    protected final boolean bak() {
        return this.kKd;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void bai() {
        super.bai();
    }

    public final void bal() {
        super.bal();
        x.i("MicroMsg.TrackMapUI", "onDown");
    }

    protected final void bam() {
        this.kKe = new d(this.activity, 1, false);
        this.kKe.ofp = new 3(this);
        this.kKe.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        h.this.baq();
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(4)});
                        return;
                    case 2:
                        x.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[]{Boolean.valueOf(h.this.kKf.containsKey("com.tencent.map"))});
                        if (h.this.kKf.containsKey("com.tencent.map")) {
                            h.this.kHO.a(h.this.kHP, h.this.kHQ, "com.tencent.map", false);
                            com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(4), "com.tencent.map"});
                            return;
                        }
                        if (h.this.kKg < 4) {
                            h hVar = h.this;
                            hVar.kKg++;
                            g.Ei().DT().a(aa.a.sWX, Integer.valueOf(h.this.kKg));
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", " http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
                        com.tencent.mm.bg.d.b(h.this.activity, "webview", ".ui.tools.WebViewUI", intent);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(5)});
                        return;
                    default:
                        if (h.this.kKf != null) {
                            for (Entry entry : h.this.kKf.entrySet()) {
                                if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                                    h.this.kHO.a(h.this.kHP, h.this.kHQ, (String) entry.getKey(), false);
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(12809, new Object[]{Integer.valueOf(4), entry.getKey()});
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                }
            }
        };
        this.kKe.bXO();
    }

    public final boolean d(LocationInfo locationInfo) {
        a FM = com.tencent.mm.plugin.location.model.l.aZj().FM(this.kDN);
        x.i("MicroMsg.TrackMapUI", "resume try to enter trackRoom " + (FM != null));
        if (FM == null) {
            return true;
        }
        if (!bi.oW(FM.kCs) && !bi.oW(locationInfo.kCz) && !FM.kCs.equals(locationInfo.kCz)) {
            return false;
        }
        if (Math.abs(FM.latitude - locationInfo.kCw) >= 0.001d || Math.abs(FM.longitude - locationInfo.kCx) >= 0.001d) {
            return false;
        }
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.kJL != null) {
            this.kJL.destroy();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.kJL != null) {
            this.kJL.onResume();
        }
        if (this.type == 2) {
            fz fzVar = new fz();
            fzVar.bOL.bJA = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            fzVar.bOL.type = 4;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            if (fzVar.bOM.auX != null) {
                if (this.kHW == null) {
                    this.kHW = new ArrayList();
                } else {
                    this.kHW.clear();
                }
                this.kHW.addAll(fzVar.bOM.auX);
                aZS();
            }
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.kJL != null) {
            this.kJL.onPause();
        }
    }
}
