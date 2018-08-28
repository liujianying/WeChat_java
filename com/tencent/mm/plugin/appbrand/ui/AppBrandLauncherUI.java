package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.appusage.i.b;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.j.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.ui.recents.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandLauncherUI extends DrawStatusBarActivity {
    static final int guy = p.feh;
    private static final int guz = g.app_brand_launcher_ui_page_container;
    private int eEZ;
    private String guA;
    private boolean guB = false;
    private int guC;
    private boolean guD = true;
    private final b guE = new 1(this);
    public d guF;

    public final void db(boolean z) {
        Class cls = z ? a.class : c.class;
        Fragment R = super.getSupportFragmentManager().R(guz);
        if ((R == null || !cls.isInstance(R)) && !isFinishing() && !this.tlP) {
            a aVar;
            q bk = super.getSupportFragmentManager().bk();
            if (z) {
                aVar = new a();
            } else {
                aVar = c.bM(getString(s$j.app_brand_entrance), getString(s$j.app_brand_launcher_recents_blank_tip));
            }
            aVar.setScene(this.eEZ);
            aVar.guK = this.guA;
            bk.b(guz, aVar);
            bk.commit();
            if (z && this.guF != null) {
                this.guF.flZ[4] = "1";
            }
        }
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -855310;
        }
        if (VERSION.SDK_INT >= 21) {
            return guy;
        }
        return super.getStatusBarColor();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        } else if (com.tencent.mm.plugin.appbrand.appusage.b.acE()) {
            overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
            this.guB = true;
            this.eEZ = getIntent().getIntExtra("extra_enter_scene", 1);
            this.guA = getIntent().getStringExtra("extra_enter_scene_note");
            lF(-855310);
            setTitleBarDoubleClickListener(new 2(this));
            setMMTitle(getResources().getString(s$j.app_brand_entrance));
            nS(-16777216);
            setBackBtn(new 3(this), i.actionbar_icon_dark_back);
            if (com.tencent.mm.plugin.appbrand.m.a.amT()) {
                int i = b.guL - 1;
                int i2 = s$j.top_item_desc_search;
                Drawable c = com.tencent.mm.svg.a.a.c(ad.getResources(), i.actionbar_icon_dark_search);
                if (c == null) {
                    c = null;
                } else {
                    c = c.mutate();
                    c.setColorFilter(-16777216, Mode.SRC_ATOP);
                }
                this.mController.a(i, getString(i2), c, new 4(this));
            }
            this.mController.contentView.setBackgroundColor(-855310);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(this);
            frameLayout.setId(guz);
            ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
            h.mEJ.a(465, 0, 1, false);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(e.i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            if (j.acZ()) {
                this.guF = new d();
            }
            j.adb();
            com.tencent.mm.plugin.appbrand.appusage.b.acF();
        } else {
            finish();
        }
    }

    protected final void onResume() {
        boolean z;
        super.onResume();
        getStatusBarColor();
        if (!this.guB) {
            if (this.guC == 1) {
                this.eEZ = 7;
            } else if (this.guC == 2) {
                this.eEZ = 6;
            } else if (this.guC == 3) {
                this.eEZ = 9;
            } else if (this.guC == 4) {
                this.eEZ = 12;
            } else {
                this.eEZ = 4;
            }
            this.guA = "";
            this.guC = 0;
            a aVar = (a) super.getSupportFragmentManager().R(guz);
            if (aVar != null) {
                aVar.setScene(this.eEZ);
            }
        }
        this.guB = false;
        if (com.tencent.mm.plugin.appbrand.appusage.b.acH() || com.tencent.mm.plugin.appbrand.appusage.b.acI()) {
            z = true;
        } else {
            z = false;
        }
        db(z);
        if (!z && this.guD) {
            com.tencent.mm.plugin.appbrand.appusage.i.a(this.guE);
            if (!com.tencent.mm.plugin.appbrand.appusage.i.refresh()) {
                com.tencent.mm.plugin.appbrand.appusage.i.b(this.guE);
            }
        }
        this.guD = false;
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void onDestroy() {
        a aVar = (a) super.getSupportFragmentManager().R(guz);
        if (aVar != null) {
            aVar.anq();
        }
        super.onDestroy();
        com.tencent.mm.plugin.appbrand.appusage.i.b(this.guE);
        com.tencent.mm.plugin.appbrand.appusage.i.acV();
        com.tencent.mm.plugin.appbrand.appusage.e.release();
        if (this.guF != null) {
            h.mEJ.h(14113, (Object[]) this.guF.flZ);
            this.guF = null;
        }
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.guC = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            x.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, com.tencent.mm.modelappbrand.b.dFx);
            h.mEJ.h(13929, stringExtra, com.tencent.mm.modelappbrand.b.dFx, Integer.valueOf(2), Integer.valueOf(intExtra));
        }
    }

    public final void setTitle(CharSequence charSequence) {
        M(charSequence);
    }

    public final void setTitle(int i) {
        setMMTitle(i);
    }

    public final void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
