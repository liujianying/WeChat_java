package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.b.b$f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.i.b;
import com.tencent.mm.plugin.appbrand.appusage.j.d;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class e extends h implements OnClickListener, b {
    View SU;
    private Activity bOb;
    private TextView gAa;
    private AppBrandNearbyShowcaseView gAb;
    private View gAc;
    private ImageView gAd;
    private boolean gAe = false;
    private final int gzI;
    private final int gzJ;
    private final int gzK;
    private final int gzL = -1;
    private View gzT;
    private int gzX = a.gAi;
    private b$f gzY;
    private final int gzZ;
    private ThreeDotsLoadingView gzp;

    e(Activity activity, ViewGroup viewGroup) {
        this.bOb = activity;
        this.gzI = a.fromDPToPix(activity, 25);
        this.gzJ = a.fromDPToPix(activity, 19);
        this.gzK = a.fromDPToPix(activity, 2);
        this.SU = LayoutInflater.from(activity).inflate(h.app_brand_recents_list_header_v2, viewGroup, false);
        View findViewById = this.SU.findViewById(g.content_root);
        this.gAc = findViewById;
        findViewById.setOnClickListener(this);
        this.gzT = this.SU.findViewById(g.nearby_showcase_container);
        this.gAa = (TextView) this.SU.findViewById(g.notice_text);
        this.gAb = (AppBrandNearbyShowcaseView) this.SU.findViewById(g.nearby_icon_showcase);
        this.gAb.setIconLayerCount(4);
        this.gAb.setIconSize(this.gzI + (this.gzK * 2));
        this.gAb.setIconGap(this.gzJ);
        this.gzp = (ThreeDotsLoadingView) this.SU.findViewById(g.nearby_loading_view);
        this.gAd = (ImageView) this.SU.findViewById(g.nearby_refresh_view);
        this.gzZ = a.g(activity, s$d.grey_text_color);
        if (!com.tencent.mm.pluginsdk.permission.a.bj(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.gzX = a.gAk;
        }
    }

    final View aoh() {
        return this.SU;
    }

    final void onResume() {
        if (a.gAk == this.gzX && com.tencent.mm.pluginsdk.permission.a.bj(this.bOb, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.gzX = a.gAi;
            aog();
        }
    }

    final void aog() {
        df(i.acP());
        if (a.gAk == this.gzX) {
            aoj();
            return;
        }
        i.a(this);
        if (!i.acU()) {
            this.SU.post(new 1(this));
        } else if (i.refresh()) {
            aoi();
        } else {
            df(false);
        }
    }

    final void onDetached() {
        i.b(this);
        this.bOb = null;
        this.SU = null;
        this.gAb = null;
        this.gzT = null;
    }

    private void aoi() {
        this.gzX = a.gAj;
        bN(this.gzT);
        bN(this.gAd);
        bO(this.gzp);
        this.gzp.cAG();
    }

    private void aoj() {
        boolean z = true;
        int i = 0;
        if (this.SU != null) {
            d dVar;
            if (i.acP()) {
                df(true);
                dVar = ((AppBrandLauncherUI) this.bOb).guF;
                if (dVar != null) {
                    dVar.flZ[5] = "1";
                }
            } else {
                df(false);
            }
            this.gzp.cAH();
            bN(this.gzp);
            if (a.gAk == this.gzX) {
                bN(this.gzT);
                bN(this.gAd);
                return;
            }
            ako acT = i.acT();
            if (acT == null) {
                this.gzX = a.gAg;
                bN(this.gzT);
                bO(this.gAd);
            } else if (acT.gTo <= 0 || bi.cX(acT.rNk)) {
                this.gzX = a.gAi;
                bN(this.gzT);
            } else {
                this.gzX = a.gAh;
                dVar = ((AppBrandLauncherUI) this.bOb).guF;
                if (dVar != null) {
                    dVar.flZ[3] = "1";
                }
                if (this.gAa != null) {
                    this.gAa.setText(acT.rNq);
                    this.gAa.setTextColor(aO(acT.rNr, this.gzZ));
                }
                this.gAb.setIconLayerCount(Math.min(acT.rNk.size(), 4));
                if (this.gzT.getVisibility() == 0) {
                    z = false;
                }
                if (z) {
                    this.gAb.aoT();
                }
                if (this.gzY == null) {
                    this.gzY = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.gzI, this.gzK);
                }
                while (i < this.gAb.getChildCount()) {
                    com.tencent.mm.modelappbrand.b.b.Ka().a(this.gAb.lT(i), ((avr) acT.rNk.get(i)).rYG, com.tencent.mm.modelappbrand.b.a.JZ(), this.gzY);
                    i++;
                }
                bO(this.gzT);
                if (z) {
                    if (this.gAb != null) {
                        this.gAb.aoU();
                    }
                    if (this.gAa != null) {
                        this.gAa.setAlpha(0.0f);
                        this.gAa.animate().alpha(1.0f).setDuration(500).start();
                    }
                }
            }
        }
    }

    private static int aO(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            return i;
        }
    }

    private void bN(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 2(this, view)).start();
        }
    }

    private static void bO(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }

    public final void acW() {
        if (this.SU != null) {
            this.SU.post(new 3(this));
        }
    }

    public final void onClick(View view) {
        int i = 0;
        if (view.getId() == g.content_root && this.bOb != null && a.gAj != this.gzX) {
            if (a.gAi == this.gzX) {
                aok();
                this.bOb.startActivityForResult(new Intent(this.bOb, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
            } else if (a.gAk == this.gzX) {
                aok();
                this.bOb.startActivityForResult(new Intent(this.bOb, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
            } else {
                boolean z = i.acT() != null && i.acU();
                this.gAe = z;
                if (a.gAg == this.gzX || this.gAe) {
                    i = 1;
                }
                4 4 = new 4(this);
                if (i != 0) {
                    aoi();
                    i.refresh();
                    return;
                }
                4.run();
                if (i.acT() != null && i.acT().rNs == 1 && this.gAa != null) {
                    this.gAa.animate().alpha(0.0f).setDuration(200);
                }
            }
        }
    }

    private void aok() {
        if (this.bOb != null) {
            d dVar = ((AppBrandLauncherUI) this.bOb).guF;
            if (dVar != null) {
                dVar.flZ[8] = "1";
            }
        }
    }
}
