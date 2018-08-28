package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.a.d;
import java.io.Serializable;
import java.util.HashMap;

public final class AppBrandProfileUI extends DrawStatusBarActivity implements OnClickListener, a {
    private d eSg;
    private String gtX;
    private t gtZ;
    private long guY = 0;
    private LinearLayout guZ;
    private TableLayout gva;
    private ImageView gvb;
    private TextView gvc;
    private TextView gvd;
    private TextView gve;
    private View gvf;
    private View gvg;
    private TextView gvh;
    private a gvi;
    private WxaExposedParams gvj;
    private boolean gvk = false;
    private volatile boolean gvl = false;

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        if (appBrandProfileUI.eSg == null || !appBrandProfileUI.eSg.isShowing()) {
            appBrandProfileUI.eSg = new d(appBrandProfileUI, 1, false);
            appBrandProfileUI.eSg.ofp = new 3(appBrandProfileUI);
            appBrandProfileUI.eSg.ofq = new 4(appBrandProfileUI);
        }
        appBrandProfileUI.eSg.bXO();
    }

    public static void a(Context context, String str, String str2, WxaExposedParams wxaExposedParams) {
        if (!bi.oW(str)) {
            if (context == null) {
                context = ad.getContext();
            }
            Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", 3).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", wxaExposedParams);
            if (wxaExposedParams != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 6);
                bundle.putString("stat_app_id", wxaExposedParams.appId);
                bundle.putString("stat_url", wxaExposedParams.bVs);
                putExtra.putExtra("_stat_obj", bundle);
            }
            if (!(context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            context.startActivity(putExtra);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!bi.oW(this.gtX)) {
            q.aei().d(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.gtX = stringExtra;
        if (bi.oW(stringExtra)) {
            finish();
        } else {
            dd(true);
        }
    }

    public final boolean Xf() {
        return true;
    }

    public final void onBackPressed() {
        if (VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        bQ(6, 1);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.gtX = stringExtra;
        if (bi.oW(stringExtra)) {
            finish();
            return;
        }
        View childAt;
        View childAt2;
        getIntent().setExtrasClassLoader(getClassLoader());
        this.gvj = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new 1(this));
        addIconOptionMenu(0, j.app_more, f.mm_title_btn_menu, new 2(this));
        setMMTitle("");
        cqh();
        lF(-1);
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(h.app_brand_profile_ui_header, this.guZ, true);
        View inflate2 = from.inflate(h.app_brand_profile_ui_footer, this.guZ, true);
        this.gva = (TableLayout) inflate.findViewById(g.profile_tl);
        TableLayout tableLayout = this.gva;
        if (tableLayout != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int childCount = tableLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                childAt = tableLayout.getChildAt(i2);
                if (childAt instanceof TableRow) {
                    TableRow tableRow = (TableRow) childAt;
                    if (tableRow.getChildCount() > 1) {
                        childAt2 = tableRow.getChildAt(0);
                        if (childAt2 != null && (childAt2 instanceof TextView)) {
                            ((TextView) childAt2).setMaxWidth((i / 2) - tableRow.getPaddingLeft());
                        }
                    }
                }
            }
        }
        this.gvb = (ImageView) inflate.findViewById(g.profile_icon);
        this.gvc = (TextView) inflate.findViewById(g.profile_name);
        this.gvd = (TextView) inflate.findViewById(g.profile_description);
        this.gve = (TextView) inflate.findViewById(g.profile_service_scope_content);
        this.gvf = inflate.findViewById(g.profile_service_scope_container);
        this.gvi = new a(this, inflate.findViewById(g.profile_biz_item));
        this.gvg = inflate.findViewById(g.profile_enter_wxa_entity);
        this.gvh = (TextView) this.gvg.findViewById(g.profile_enter_wxa_entity_content);
        dc(true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        inflate2.setClickable(false);
        inflate2.setLongClickable(false);
        childAt = inflate2.findViewById(g.profile_enter_app);
        childAt2 = inflate2.findViewById(g.profile_share_app);
        childAt.setOnClickListener(this);
        childAt2.setOnClickListener(this);
        dd(true);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        View scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(s$d.app_brand_profile_background);
        this.guZ = new LinearLayout(this);
        this.guZ.setOrientation(1);
        scrollView.addView(this.guZ, new LayoutParams(-1, -2));
        ((FrameLayout) view).addView(scrollView);
    }

    protected final void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
        }
    }

    protected final void initActivityCloseAnimation() {
        if (!this.gvk) {
            super.initActivityCloseAnimation();
        }
    }

    private void dc(boolean z) {
        if (this.gvg != null) {
            if (z) {
                this.gvg.setVisibility(8);
                return;
            }
            this.gvg.setVisibility(0);
            this.gvg.setOnClickListener(this);
        }
    }

    private void bQ(int i, int i2) {
        c(i, i2, bi.VE());
    }

    private void c(int i, int i2, long j) {
        String str = this.gtZ == null ? null : this.gtZ.appId;
        if (!bi.oW(str)) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 3);
            String oV = bi.oV(getIntent().getStringExtra("key_scene_note"));
            int i3 = 0;
            WxaAttributes f = e.aba().f(str, new String[]{"appInfo", "brandIconURL", "nickname"});
            if (f != null) {
                i3 = f.aej().dCn;
            }
            i3 += 1000;
            x.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", new Object[]{Integer.valueOf(13919), str, Integer.valueOf(intExtra), oV, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13919, new Object[]{str, Integer.valueOf(intExtra), oV, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)});
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        q.aei().d(this);
    }

    public final void onClick(View view) {
        if (view.getId() == g.profile_enter_wxa_entity) {
            if (this.gtZ != null && !bi.oW(this.gtZ.appId)) {
                com.tencent.mm.bg.d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", n.qy(this.gtZ.appId)).putExtra("forceHideShare", true));
                bQ(2, 1);
            }
        } else if (view.getId() == g.profile_enter_app) {
            if (this.gtZ != null) {
                Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1024;
                appBrandStatObject.cbB = c.h(appBrandStatObject.scene, bundleExtra);
                appBrandStatObject.cbC = c.i(appBrandStatObject.scene, bundleExtra);
                com.tencent.mm.plugin.appbrand.launching.precondition.g.ghE.a(this, this.gtZ.username, null, null, 0, -1, appBrandStatObject, null, null);
                bQ(4, 1);
                if (appBrandStatObject.cbB == 6) {
                    this.gvk = true;
                    finish();
                }
            }
        } else if (view.getId() == g.profile_share_app) {
            t rT = q.rT(this.gtX);
            if (rT == null) {
                x.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
                return;
            }
            Serializable hashMap = new HashMap();
            hashMap.put("desc", "");
            hashMap.put("type", Integer.valueOf(1));
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, rT.nickname);
            hashMap.put("img_url", rT.fsq);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            com.tencent.mm.bg.d.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new 5(this, rT, view));
        }
    }

    private void dd(boolean z) {
        com.tencent.mm.sdk.f.e.post(new 6(this, z), "AppBrandProfile");
    }

    public final void a(String str, l lVar) {
        if (lVar.fBN == 3 && (lVar.obj instanceof String) && !bi.oW(this.gtX) && this.gtX.equals((String) lVar.obj)) {
            dd(false);
        }
    }
}
