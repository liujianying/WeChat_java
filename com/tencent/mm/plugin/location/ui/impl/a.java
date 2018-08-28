package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a$f;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.r.a {
    public Activity activity;
    protected int bNP = 0;
    protected ProgressDialog eHw = null;
    ag handler = new ag(Looper.getMainLooper());
    protected float hlo = 0.0f;
    protected float jUm = 0.0f;
    DisplayMetrics jZh = null;
    int kCy;
    protected String kDN = "";
    protected String kEA;
    protected String kFa = "";
    public String kHK = "";
    protected boolean kHL = false;
    public boolean kHM = false;
    protected Addr kHN = null;
    protected d kHO;
    protected LocationInfo kHP = new LocationInfo((byte) 0);
    protected LocationInfo kHQ = new LocationInfo((byte) 0);
    protected a kHR;
    protected boolean kHS = false;
    protected HashMap<String, c> kHT = new HashMap();
    protected b kHU;
    protected boolean kHV = false;
    protected ArrayList<String> kHW = new ArrayList();
    protected boolean kHX = false;
    protected boolean kHY = false;
    protected com.tencent.mm.plugin.location.model.c kHZ = null;
    protected com.tencent.mm.modelgeo.c kIa;
    public com.tencent.mm.modelgeo.b.a kIb = new 3(this);
    protected int type = 0;

    protected abstract String Wm();

    protected abstract void aZV();

    abstract void aZW();

    public a(Activity activity) {
        this.activity = activity;
        this.kHU = b.Oz();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.activity.finish();
    }

    public void onCreate(Bundle bundle) {
        this.kIa = com.tencent.mm.modelgeo.c.OB();
        LocationInfo locationInfo = this.kHQ;
        LocationInfo locationInfo2 = this.kHP;
        String d = w.d(ad.chZ());
        x.d("MicroMsg.BaseMapUI", " initLanguage " + d);
        if (d.equals("language_default")) {
            w.a(this.activity, Locale.ENGLISH);
            d = "en";
        } else {
            w.a(this.activity, w.Wl(d));
        }
        locationInfo2.kCA = d;
        locationInfo.kCA = d;
        x.d("MicroMsg.BaseMapUI", "sosomap " + this.kHP.kCA);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(a$f.gmap_ui);
        ((FrameLayout) findViewById(e.mapview_content)).addView(d.dL(this.activity));
        this.kHO = new d(this.activity);
        this.kHR = new a(this);
        this.kEA = this.activity.getIntent().getStringExtra("kRemark");
        this.kHW = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.kHM = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        x.i("MicroMsg.BaseMapUI", "isPickPoi " + this.kHM);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        aZV();
        this.activity.finish();
        return true;
    }

    public void onResume() {
        com.tencent.mm.ui.base.x.b(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        com.tencent.mm.ui.base.x.b(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.kHU.a(this.kIb);
        x.d("MicroMsg.BaseMapUI", "destroy");
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        this.kHR.kEZ.destroy();
        System.gc();
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    protected final void aZS() {
        if (this.kHR.kIj != null && this.kHR.kIk != null) {
            this.kHR.kIj.setText(j.a(this.kHR.kIj.getContext(), this.kEA, this.kHR.kIj.getTextSize()));
            if (this.kHW == null || this.kHW.isEmpty()) {
                this.kHR.kIk.setText("");
                return;
            }
            String str = (String) this.kHW.get(0);
            String string = this.activity.getResources().getString(h.favorite_tag_delimiter_1);
            CharSequence charSequence = str;
            for (int i = 1; i < this.kHW.size(); i++) {
                charSequence = charSequence + string + ((String) this.kHW.get(i));
            }
            this.kHR.kIk.setText(j.a(this.kHR.kIk.getContext(), charSequence, this.kHR.kIk.getTextSize()));
        }
    }

    protected final void aZT() {
        this.kHR.kIe.removeAllViews();
        View inflate = View.inflate(this.activity, a$f.location_favorite, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.kHR.kIe.addView(inflate, layoutParams);
        this.kHR.kIj = (TextView) inflate.findViewById(e.location_remark);
        this.kHR.kIj.setOnClickListener(new 1(this));
        this.kHR.kIk = (TextView) inflate.findViewById(e.location_tags);
        this.kHR.kIk.setOnClickListener(new 2(this));
        aZS();
    }

    protected final String aZU() {
        return bi.aG(this.kEA, "");
    }

    protected final boolean c(LocationInfo locationInfo) {
        if (this.kHR.kEZ.getIController() == null || !com.tencent.mm.plugin.location.model.e.k(locationInfo.kCw, locationInfo.kCx)) {
            return false;
        }
        this.kHR.kEZ.getIController().animateTo(locationInfo.kCw, locationInfo.kCx);
        return true;
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    protected final void initView() {
        x.d("MicroMsg.BaseMapUI", "initView");
        this.kHR.kIi = (LinearLayout) findViewById(e.header_bar);
        this.kHR.kEZ = (com.tencent.mm.plugin.r.d) findViewById(e.g_mapView);
        this.kHR.kId = (FrameLayout) findViewById(e.control_id);
        this.kHR.kIe = (RelativeLayout) findViewById(e.tips_area);
        this.kHR.jfx = (ImageView) findViewById(e.title_btn_home);
        this.kHR.kIf = (ImageButton) findViewById(e.title_btn_icon);
        this.kHR.kIg = findViewById(e.title_btn_text);
        this.kHR.kIh = (TextView) findViewById(e.action_option_text);
        this.kHR.titleView = (TextView) findViewById(e.mm_action_bar_mmtitle);
        this.kHR.kAp = (TextView) findViewById(e.more_info);
        this.kHR.titleView.setText(Wm());
        this.kHR.kEZ.getIController().setZoom(d.aZx());
        if (!(this.type == 0 || this.type == 3)) {
            this.kHR.kIf.setVisibility(0);
            this.kHR.kIg.setVisibility(8);
            this.kHR.kIf.setEnabled(false);
            this.kHR.kIf.setImageResource(com.tencent.mm.plugin.map.a.d.mm_title_btn_menu);
        }
        this.kHR.kEZ.setBuiltInZoomControls(false);
        this.kHR.jfx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.aZV();
                a.this.YC();
                a.this.activity.finish();
            }
        });
        this.kHR.kIh.setOnClickListener(new 5(this));
        aZW();
        if (Boolean.valueOf(ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false)).booleanValue()) {
            lF(ad.getResources().getColor(com.tencent.mm.plugin.map.a.b.dark_actionbar_color));
        } else {
            lF(ad.getResources().getColor(com.tencent.mm.plugin.map.a.b.normal_actionbar_color));
        }
    }

    private void lF(int i) {
        this.kHR.kIi.setBackgroundColor(i);
        Boolean valueOf = Boolean.valueOf(an.Ec(i));
        if (valueOf.booleanValue()) {
            this.kHR.jfx.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.kHR.kIf.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            this.kHR.titleView.setTextColor(ad.getResources().getColor(com.tencent.mm.plugin.map.a.b.white_text_color));
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

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            if (4096 == i) {
                if (this.kHR.kIj != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.kEA = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    aZS();
                }
            } else if (4100 == i && this.kHR.kIk != null) {
                this.kHW = intent.getStringArrayListExtra("key_fav_result_list");
                aZS();
            }
        }
    }

    protected final void YC() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public boolean aZX() {
        return true;
    }
}
