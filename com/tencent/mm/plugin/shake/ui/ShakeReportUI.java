package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.k.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.h$a;
import com.tencent.mm.plugin.shake.d.a.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements aq, com.tencent.mm.platformtools.y.a, com.tencent.mm.plugin.shake.b.l.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.e.j.a, b {
    private static List<h$a> cXq = new CopyOnWriteArrayList();
    private c cXl;
    private boolean cXo = false;
    private Map<String, h$a> cXp = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.a.a cXs = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                x.d("MicroMsg.ShakeReportUI", "on location get ok");
                au.HU();
                com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPK, String.valueOf(f2));
                au.HU();
                com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPL, String.valueOf(f));
                au.HU();
                com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sSf, String.valueOf(d2));
                ShakeReportUI.this.cXo = true;
                if (ShakeReportUI.this.cXl != null) {
                    ShakeReportUI.this.cXl.c(ShakeReportUI.this.cXs);
                }
            } else {
                x.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            return false;
        }
    };
    private com.tencent.mm.ak.a.a dWD = null;
    private ImageView eBM;
    private boolean eLU = true;
    private com.tencent.mm.pluginsdk.i.c lAY;
    private boolean mZS = false;
    private boolean mZT = false;
    private boolean mZU;
    private boolean mZV = false;
    private boolean mZW = false;
    private boolean mZX = false;
    private boolean mZY = false;
    private int mZZ = 22;
    private ImageView naA;
    private ImageView naB;
    private ImageView naC;
    private ImageView naD;
    private ImageView naE;
    private ImageView naF;
    private TextView naG;
    private int naH = 1;
    private int naI = 0;
    private View naJ;
    private ImageView naK;
    private ImageView naL;
    private ImageView naM;
    private ImageView naN;
    private View naO;
    private View naP;
    private View naQ;
    private View naR;
    private View naS = null;
    private int naT = 0;
    private com.tencent.mm.plugin.shake.c.b.a naU;
    private boolean naV = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> naW = new HashMap();
    private boolean naX = false;
    private boolean naY = false;
    private boolean naZ = false;
    private c naa;
    private l nab = new l();
    private f nac;
    private View nad;
    private View nae;
    private TextView naf;
    private TextView nag;
    private TextView nah;
    private View nai;
    private View naj;
    private View nak;
    private View nal;
    private Animation nam;
    private Animation nan;
    private Animation nao;
    private Animation nap;
    private View naq = null;
    private View nar = null;
    private MMImageView nas = null;
    private TextView nat = null;
    private ImageView nau = null;
    private String nav = "";
    private Bitmap naw = null;
    private Dialog nax;
    private ImageView nay = null;
    private d naz = null;
    private boolean nba = false;
    private int nbb = 1;
    private long nbc = 0;
    private boolean nbd = false;
    private com.tencent.mm.sdk.b.c nbe = new com.tencent.mm.sdk.b.c<dm>() {
        {
            this.sFo = dm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dm dmVar = (dm) bVar;
            String str = dmVar.bLn.bLl;
            int i = dmVar.bLn.bLo;
            int i2 = dmVar.bLn.bLp;
            String str2 = dmVar.bLn.bLs;
            double d = dmVar.bLn.bLr;
            int i3 = dmVar.bLn.bLt;
            if (!ShakeReportUI.this.cXp.containsKey(str + "," + i + "," + i2)) {
                h$a h_a = new h$a();
                h_a.fMk = str;
                h_a.ees = dmVar.bLn.bLq;
                h_a.major = i;
                h_a.minor = i2;
                h_a.mYO = str2;
                h_a.mYP = d;
                h_a.mYQ = i3;
                ShakeReportUI.this.cXp.put(str + "," + i + "," + i2, h_a);
                if (dmVar.bLn.bLq >= 0.0d && ShakeReportUI.cXq.size() > 0) {
                    i3 = 0;
                    while (i3 < ShakeReportUI.cXq.size()) {
                        h$a h_a2 = (h$a) ShakeReportUI.cXq.get(i3);
                        if (dmVar.bLn.bLq >= h_a2.ees) {
                            if (i3 == ShakeReportUI.cXq.size() - 1 && dmVar.bLn.bLq > h_a2.ees) {
                                ShakeReportUI.cXq.add(h_a);
                                break;
                            }
                            i3++;
                        } else {
                            ShakeReportUI.cXq.add(i3, h_a);
                            break;
                        }
                    }
                }
                ShakeReportUI.cXq.add(h_a);
                if (ShakeReportUI.this.cXp.size() == 1 && !ShakeReportUI.this.nbd) {
                    ShakeReportUI.this.nbc = System.currentTimeMillis() - ShakeReportUI.this.nbc;
                    h.mEJ.h(11497, new Object[]{String.valueOf((int) (((double) (ShakeReportUI.this.nbc / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) ShakeReportUI.this.nbc)});
                    ShakeReportUI.this.nbc = 0;
                    ShakeReportUI.this.runOnUiThread(new 1(this));
                }
            }
            x.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", new Object[]{str + "," + i + "," + i2, Integer.valueOf(ShakeReportUI.this.cXp.size())});
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nbf = new com.tencent.mm.sdk.b.c<ds>() {
        {
            this.sFo = ds.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ds dsVar = (ds) bVar;
            x.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(dsVar.bLC.bLD)});
            boolean hasSystemFeature = ShakeReportUI.this.mController.tml.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (dsVar.bLC.bLD == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                ShakeReportUI.this.bvm();
            } else if (dsVar.bLC.bLD == 12) {
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    ShakeReportUI.this.nbb = 1;
                } else {
                    ShakeReportUI.this.bvl();
                    ShakeReportUI.this.nbb = 0;
                }
                bl IC = bl.IC();
                String oV = bi.oV(IC.dDf);
                String oV2 = bi.oV(IC.dDe);
                int i = hasSystemFeature ? 1 : 0;
                if (ShakeReportUI.this.naY) {
                    h.mEJ.h(13139, new Object[]{oV, oV2, Integer.valueOf(1), Integer.valueOf(ShakeReportUI.this.nbb), Integer.valueOf(1), Integer.valueOf(i)});
                } else {
                    h.mEJ.h(13139, new Object[]{oV, oV2, Integer.valueOf(0), Integer.valueOf(ShakeReportUI.this.nbb), Integer.valueOf(1), Integer.valueOf(i)});
                }
                if (ShakeReportUI.this.naZ && ShakeReportUI.this.naY && !ShakeReportUI.this.nbd && ShakeReportUI.this.naI < 4) {
                    ShakeReportUI.this.runOnUiThread(new 1(this));
                }
            }
            return false;
        }
    };
    private OnClickListener nbg = new 18(this);

    static class a extends com.tencent.mm.pluginsdk.i.c.a {
        private final long[] eyq = new long[]{300, 200, 300, 200};
        private long hmb = bi.VG();
        private Vibrator hni;
        WeakReference<ShakeReportUI> nbn;

        public a(ShakeReportUI shakeReportUI) {
            this.nbn = new WeakReference(shakeReportUI);
        }

        public final void biM() {
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.nbn.get();
            if (shakeReportUI != null) {
                if (shakeReportUI.isFinishing()) {
                    x.e("MicroMsg.ShakeReportUI", "ui finished");
                } else if (shakeReportUI.mZX) {
                    shakeReportUI.bvs();
                    long bI = bi.bI(this.hmb);
                    if (bI < 1200) {
                        x.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + bI);
                        return;
                    }
                    x.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + bI);
                    this.hmb = bi.VG();
                    if (shakeReportUI.naa != null) {
                        c w = shakeReportUI.naa;
                        if (w.view != null) {
                            w.view.setKeepScreenOn(true);
                        }
                        w.bAZ.J(30000, 30000);
                    }
                    if (shakeReportUI.nac != null) {
                        f q = shakeReportUI.nac;
                        if (q.kXg != null) {
                            q.kXg.dismiss();
                        }
                    }
                    ShakeReportUI shakeReportUI2;
                    if (shakeReportUI.mZU) {
                        shakeReportUI2 = (ShakeReportUI) this.nbn.get();
                        if (shakeReportUI2 != null) {
                            as.I(shakeReportUI2, R.l.shake_sound_male);
                        }
                    } else {
                        shakeReportUI2 = (ShakeReportUI) this.nbn.get();
                        if (shakeReportUI2 != null) {
                            if (this.hni == null) {
                                this.hni = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                            }
                            if (this.hni != null) {
                                this.hni.vibrate(this.eyq, -1);
                            }
                        }
                    }
                    reset();
                    ShakeReportUI.y(shakeReportUI);
                } else {
                    x.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                }
            }
        }

        public final void onRelease() {
        }
    }

    static /* synthetic */ void h(ShakeReportUI shakeReportUI) {
        if (bvx()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(R.h.shake_report_bottom_tabs_ll);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                List arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                Animation animationSet;
                Animation alphaAnimation;
                Animation translateAnimation;
                View view;
                if (!shakeReportUI.naX && (shakeReportUI.naY || shakeReportUI.nba)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    animationSet = new AnimationSet(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(R.h.shake_report_tab_ibeacon_ll).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.naX || shakeReportUI.naY || shakeReportUI.nba)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    Animation animationSet2 = new AnimationSet(false);
                    animationSet = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.setDuration(1200);
                    alphaAnimation = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(animationSet);
                    alphaAnimation.setDuration(600);
                    animationSet2.addAnimation(alphaAnimation);
                    shakeReportUI.findViewById(R.h.shake_report_tab_ibeacon_first_ll).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.naX = true;
                shakeReportUI.naH = 5;
                shakeReportUI.nbd = true;
                shakeReportUI.bvv();
                shakeReportUI.bvo();
                shakeReportUI.hG(false);
            }
        }
    }

    static /* synthetic */ void y(ShakeReportUI shakeReportUI) {
        if (shakeReportUI.nai == null) {
            shakeReportUI.nai = shakeReportUI.findViewById(R.h.shake_up_ll);
        }
        if (shakeReportUI.naj == null) {
            shakeReportUI.naj = shakeReportUI.findViewById(R.h.shake_down_ll);
        }
        if (shakeReportUI.nak == null) {
            shakeReportUI.nak = shakeReportUI.findViewById(R.h.shake_line_down);
        }
        if (shakeReportUI.nal == null) {
            shakeReportUI.nal = shakeReportUI.findViewById(R.h.shake_line_up);
        }
        if (shakeReportUI.nam == null) {
            shakeReportUI.nam = AnimationUtils.loadAnimation(shakeReportUI.mController.tml, R.a.translate_up);
            shakeReportUI.nam.setAnimationListener(new 10(shakeReportUI));
        }
        if (shakeReportUI.nan == null) {
            shakeReportUI.nan = AnimationUtils.loadAnimation(shakeReportUI.mController.tml, R.a.translate_down);
        }
        if (shakeReportUI.nao == null) {
            shakeReportUI.nao = AnimationUtils.loadAnimation(shakeReportUI.mController.tml, R.a.shake_line_fade_in_out);
        }
        if (!(shakeReportUI.nap == null || shakeReportUI.nag == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(shakeReportUI.nag, shakeReportUI.nap);
        }
        shakeReportUI.wc(3);
        shakeReportUI.nak.startAnimation(shakeReportUI.nao);
        shakeReportUI.nal.startAnimation(shakeReportUI.nao);
        shakeReportUI.nak.setVisibility(0);
        shakeReportUI.nal.setVisibility(0);
        shakeReportUI.naf.setVisibility(4);
        shakeReportUI.nai.startAnimation(shakeReportUI.nam);
        shakeReportUI.naj.startAnimation(shakeReportUI.nan);
        if (shakeReportUI.nad != null && shakeReportUI.nad.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.mController.tml, R.a.shake_report_dlg_translate_out);
            loadAnimation.setFillAfter(true);
            shakeReportUI.nad.startAnimation(loadAnimation);
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    if (ShakeReportUI.this.nad != null) {
                        ShakeReportUI.this.nad.setVisibility(8);
                    }
                }
            }, loadAnimation.getDuration());
        }
        shakeReportUI.mZY = false;
        new ag().postDelayed(new Runnable() {
            public final void run() {
                if (ShakeReportUI.this.nak != null) {
                    ShakeReportUI.this.nak.setVisibility(8);
                }
                if (ShakeReportUI.this.nal != null) {
                    ShakeReportUI.this.nal.setVisibility(8);
                }
                if (ShakeReportUI.this.naf != null) {
                    ShakeReportUI.this.naf.setVisibility(0);
                }
                if (!ShakeReportUI.this.mZY && !ShakeReportUI.this.mZS) {
                    ShakeReportUI.this.wc(1);
                }
            }
        }, 1200);
    }

    protected final int getLayoutId() {
        return R.i.shake_report;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        setMMTitle(R.l.shake_report_title);
        lF(getResources().getColor(R.e.dark_actionbar_color));
        cqh();
        this.cXl = c.OB();
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPK, "");
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sPL, "");
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sSf, "");
        this.naS = findViewById(R.h.shake_report_tab_ibeacon_first_ll);
        bl IC = bl.IC();
        String oV = bi.oV(IC.dDf);
        String oV2 = bi.oV(IC.dDe);
        String G = g.AU().G("IBeacon", "GatedLaunch");
        if (bi.oW(G)) {
            G = null;
        }
        this.naY = false;
        this.naZ = false;
        if (G != null) {
            try {
                JSONObject jSONObject = new JSONObject(G);
                i = jSONObject.getInt("gatedlaunch");
                au.HX();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(oV) && i3 == 1) {
                                this.naY = true;
                            } else if (string.equals(oV) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(oV2)) {
                                        this.naY = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(oV) && i3 == 1) {
                                this.naZ = true;
                                this.naY = true;
                            } else if (string.equals(oV) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(oV2)) {
                                        this.naZ = true;
                                        this.naY = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.naY = true;
                        this.naZ = false;
                    } else if (i == 4) {
                        this.naY = true;
                        this.naZ = true;
                    }
                }
            } catch (JSONException e) {
                x.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.naY = false;
                this.naZ = false;
            }
        }
        if (au.HX()) {
            au.HU();
            if (((Integer) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRX, Integer.valueOf(0))).intValue() == 1) {
                this.nba = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.nbb = 1;
        } else {
            this.nbb = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.naY) {
            h.mEJ.h(13139, new Object[]{oV, oV2, Integer.valueOf(1), Integer.valueOf(this.nbb), Integer.valueOf(i2), Integer.valueOf(i)});
        } else {
            h.mEJ.h(13139, new Object[]{oV, oV2, Integer.valueOf(0), Integer.valueOf(this.nbb), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        if (this.nba || this.naY) {
            this.naX = true;
            this.naS = findViewById(R.h.shake_report_tab_ibeacon_ll);
            if (this.naZ) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.naX = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f buH = m.buH();
        if (buH.htB == null) {
            buH.htB = new ArrayList();
        }
        if (this != null) {
            buH.htB.add(new WeakReference(this));
        }
        Boolean valueOf = Boolean.valueOf(false);
        long VE = bi.VE();
        long j = 0;
        long j2 = 0;
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sRU, Boolean.valueOf(true));
            au.HU();
            Boolean valueOf2 = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRS, null), false));
            au.HU();
            j = bi.a((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRT, null), 0);
            au.HU();
            j2 = bi.a((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRN, null), 0);
            valueOf = valueOf2;
        }
        if (!valueOf.booleanValue() || VE - j >= j2) {
            initView();
        } else {
            this.naH = 5;
            this.naX = true;
            this.mZV = true;
            initView();
            bvo();
            au.HU();
            String aG = bi.aG((String) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRR, null), "");
            au.HU();
            G = bi.aG((String) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRQ, null), "");
            if (!(G == null || G.equals(""))) {
                String[] split = G.split(",");
                d dVar = new d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes("utf-8");
                } catch (UnsupportedEncodingException e2) {
                    x.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e buC = m.buC();
                buC.buu();
                buC.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                d(linkedList, 1);
                au.HU();
                com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sRQ, "");
                G = aG + "," + split[4] + split[5] + split[6];
                au.HU();
                com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sRR, G);
            }
        }
        this.naa = new c(this.mController.tlX);
        this.lAY = new com.tencent.mm.pluginsdk.i.c(this);
        if (!this.lAY.ccS()) {
            com.tencent.mm.ui.base.h.a(this, R.l.shake_not_support, R.l.app_tip, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ShakeReportUI.this.finish();
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.ezo != null) {
            com.tencent.mm.plugin.shake.a.ezo.vl();
        }
        y.b(this);
        x.i("MicroMsg.ShakeReportUI", "%s", new Object[]{getResources().getDisplayMetrics().toString()});
        i = m.buD().axd();
        h.mEJ.h(11317, new Object[]{Integer.valueOf(i), e.bvA()});
        h.mEJ.h(11710, new Object[]{Integer.valueOf(1)});
        h.mEJ.e(834, 0, 1);
    }

    protected void onResume() {
        super.onResume();
        if (this.eLU) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                bpD();
            }
        }
    }

    private void bpD() {
        bvn();
        au.HU();
        com.tencent.mm.model.c.a(this);
        au.HU();
        com.tencent.mm.model.c.DT().a(this);
        m.buC().c(this);
        if (this.nab.mWP != null) {
            this.nab.mWP.resume();
        }
        this.mZX = true;
        if (!(this.naU == null || !this.naU.isShowing() || this.naU.mXW)) {
            this.mZX = false;
        }
        x.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.lAY == null || this.lAY.ccQ())) {
            this.lAY.a(new a(this));
            if (!this.lAY.ccS() || this.naf == null) {
                this.naf.setText(getString(R.l.shake_not_support));
            } else {
                this.naf.setText(getString(R.l.shake_a_friend));
            }
        }
        new ag().postDelayed(new 22(this), 1000);
        if (this.lAY != null) {
            this.lAY.ccR();
        }
        hH(false);
        hI(false);
        bvp();
        au.HU();
        String str = (String) com.tencent.mm.model.c.DT().get(327696, "1");
        if (k.buA()) {
            if (this.naH == 4) {
                hE(true);
            }
            if (str.equals("4")) {
                cw(findViewById(R.h.shake_report_tab_tv_ll));
            }
        }
        if (str.equals("3")) {
            cw(findViewById(R.h.shake_report_tab_music_ll));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            cw(findViewById(R.h.shake_report_tab_card_ll));
        }
        boolean aU = com.tencent.mm.s.c.Cp().aU(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.an.c.Qf() && this.nab.mWO != 3) {
            getIntent().putExtra("shake_music", false);
            this.naH = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.nab.mWO != 4 && k.buA()) {
            getIntent().putExtra("shake_tv", false);
            this.naH = 4;
        } else if (this.nab.mWO != 6 && com.tencent.mm.plugin.shake.c.c.a.bvb() && (aU || getIntent().getBooleanExtra("shake_card", false))) {
            this.naT = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            x.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.naH = 6;
        }
        bvo();
        hF(true);
        x.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[]{Boolean.valueOf(af.exc)});
        if (af.exc) {
            au.DF().a(new com.tencent.mm.ar.k(7), 0);
        }
        bvy();
        bvv();
        bvl();
    }

    protected void onPause() {
        au.HU();
        com.tencent.mm.model.c.b(this);
        au.HU();
        com.tencent.mm.model.c.DT().b(this);
        m.buC().d(this);
        if (this.nab.mWP != null) {
            this.nab.mWP.pause();
        }
        this.mZX = false;
        if (this.lAY != null) {
            this.lAY.aDc();
        }
        this.naa.bvj();
        if (this.naH != 5) {
            au.HU();
            com.tencent.mm.model.c.DT().set(327696, this.naH);
        }
        if (this.naH == 4) {
            hE(false);
        }
        bvm();
        super.onPause();
    }

    protected void onDestroy() {
        boolean z = false;
        if (!(this.naw == null || this.naw.isRecycled())) {
            this.naw.recycle();
        }
        if (this.nax != null && this.nax.isShowing()) {
            this.nax.dismiss();
            this.nax = null;
        }
        if (this.nab.mWP != null) {
            this.nab.mWP.bup();
        }
        if (this.lAY != null) {
            this.lAY.aDc();
            this.lAY = null;
        }
        j a = j.a(null);
        if (j.lkO) {
            j.lkO = false;
            if (!a.mYR.bvd()) {
                x.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        j.mYS = null;
        y.c(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.nbe);
        com.tencent.mm.sdk.b.a.sFg.c(this.nbf);
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sRU, Boolean.valueOf(false));
        bvm();
        if (com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            com.tencent.mm.s.c.Cp().v(262154, false);
        }
        bvs();
        com.tencent.mm.plugin.shake.c.a.f buH = m.buH();
        if (buH.htB != null && this != null) {
            while (true) {
                boolean z2 = z;
                if (z2 >= buH.htB.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) buH.htB.get(z2);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        buH.htB.remove(weakReference);
                        break;
                    }
                }
                z = z2 + 1;
            }
        }
        com.tencent.mm.plugin.shake.c.a.d buI = m.buI();
        buI.cXm = -85.0f;
        buI.cXn = -1000.0f;
        if (this.cXl != null) {
            this.cXl.c(this.cXs);
        }
        super.onDestroy();
    }

    private void bvl() {
        if (bvx() && BluetoothAdapter.getDefaultAdapter() != null) {
            List<String> AJ = g.AU().AJ();
            if (AJ != null) {
                this.nbc = System.currentTimeMillis();
                for (String str : AJ) {
                    x.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[]{str});
                    dl dlVar = new dl();
                    dlVar.bLj.bLl = str;
                    dlVar.bLj.bLi = true;
                    com.tencent.mm.sdk.b.a.sFg.m(dlVar);
                }
            }
        }
    }

    private void bvm() {
        au.HU();
        if (!Boolean.valueOf(bi.a((Boolean) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sRU, null), false)).booleanValue()) {
            this.cXp.clear();
            cXq = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> AJ = g.AU().AJ();
            if (AJ != null) {
                for (String str : AJ) {
                    dl dlVar = new dl();
                    x.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[]{str});
                    dlVar.bLj.bLl = str;
                    dlVar.bLj.bLi = false;
                    com.tencent.mm.sdk.b.a.sFg.m(dlVar);
                }
            }
        }
    }

    protected final void initView() {
        com.tencent.mm.plugin.shake.c.c.a.buw();
        this.naW.put(Integer.valueOf(1), Boolean.valueOf(true));
        this.naW.put(Integer.valueOf(3), Boolean.valueOf(false));
        this.naW.put(Integer.valueOf(4), Boolean.valueOf(false));
        this.naW.put(Integer.valueOf(5), Boolean.valueOf(false));
        this.naW.put(Integer.valueOf(6), Boolean.valueOf(false));
        this.dWD = new com.tencent.mm.ak.a.a(this);
        this.naf = (TextView) findViewById(R.h.shake_report_static);
        this.nae = findViewById(R.h.shake_report_waiting);
        this.nag = (TextView) findViewById(R.h.shake_report_anim);
        this.nah = (TextView) findViewById(R.h.shake_report_shaking_tips);
        this.naJ = findViewById(R.h.shake_tv_history_ll);
        this.naK = (ImageView) findViewById(R.h.shake_tv_history_icon1);
        this.naL = (ImageView) findViewById(R.h.shake_tv_history_icon2);
        this.naM = (ImageView) findViewById(R.h.shake_tv_history_icon3);
        this.naN = (ImageView) findViewById(R.h.shake_tv_history_icon_more);
        this.naO = findViewById(R.h.shake_tv_history_icon1_ll);
        this.naP = findViewById(R.h.shake_tv_history_icon2_ll);
        this.naQ = findViewById(R.h.shake_tv_history_icon3_ll);
        this.naR = findViewById(R.h.shake_tv_history_icon_more_ll);
        this.nad = findViewById(R.h.shake_report_card);
        this.nad.setOnClickListener(this.nbg);
        this.eBM = (ImageView) this.nad.findViewById(R.h.shake_match_dlg_img);
        this.eBM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ShakeReportUI.this.naH != 5) {
                    ShakeReportUI.this.nac = new f(ShakeReportUI.this, (String) ShakeReportUI.this.nad.getTag(), null, com.tencent.mm.pluginsdk.ui.f.a.qFv);
                    ShakeReportUI.this.nac.cde();
                }
            }
        });
        bvn();
        View inflate = View.inflate(this.mController.tml, R.i.shake_info_dialog_view, null);
        this.nax = new i(this.mController.tml, R.m.mmalertdialog);
        this.nax.setContentView(inflate);
        this.nax.setOnCancelListener(new 4(this));
        ((Button) inflate.findViewById(R.h.shake_info_close)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ShakeReportUI.this.nax.cancel();
            }
        });
        au.HU();
        boolean d = bi.d((Boolean) com.tencent.mm.model.c.DT().get(4108, null));
        au.HU();
        boolean d2 = bi.d((Boolean) com.tencent.mm.model.c.DT().get(4117, null));
        if (!d) {
            inflate.setVisibility(0);
            this.nax.show();
            au.HU();
            com.tencent.mm.model.c.DT().set(4108, Boolean.valueOf(true));
        } else if (!d2) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    s.a(ShakeReportUI.this, 0, ShakeReportUI.this.getString(R.l.shake_set_mute_tips));
                    au.HU();
                    com.tencent.mm.model.c.DT().set(4117, Boolean.valueOf(true));
                    return false;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeReportUI.this.mZV = false;
                ShakeReportUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeReportUI.this.mZV = false;
                Intent intent = new Intent();
                intent.setClass(ShakeReportUI.this, ShakePersonalInfoUI.class);
                ShakeReportUI.this.startActivityForResult(intent, 3);
                return true;
            }
        });
        29 29 = new 29(this);
        if (this.nba || this.naY) {
            this.nay = (ImageView) findViewById(R.h.shake_report_tab_ibeacon_image_view);
        } else {
            this.nay = (ImageView) findViewById(R.h.shake_report_tab_ibeacon_image_first_view);
        }
        this.naA = (ImageView) findViewById(R.h.shake_report_tab_friend);
        this.naB = (ImageView) findViewById(R.h.shake_report_tab_music);
        this.naC = (ImageView) findViewById(R.h.shake_report_tab_tv);
        this.naD = (ImageView) findViewById(R.h.shake_report_tab_card);
        this.naG = (TextView) findViewById(R.h.shake_report_tab_card_tv);
        this.naF = (ImageView) findViewById(R.h.shake_report_tab_card_red_dot);
        this.naE = (ImageView) findViewById(R.h.shake_report_tab_music_red_dot);
        bvu();
        this.naS.setOnClickListener(29);
        findViewById(R.h.shake_report_tab_ibeacon_ll).setOnClickListener(29);
        findViewById(R.h.shake_report_tab_friend_ll).setOnClickListener(29);
        findViewById(R.h.shake_report_tab_music_ll).setOnClickListener(29);
        findViewById(R.h.shake_report_tab_tv_ll).setOnClickListener(29);
        findViewById(R.h.shake_report_tab_card_ll).setOnClickListener(29);
        com.tencent.mm.sdk.b.a.sFg.b(this.nbe);
        com.tencent.mm.sdk.b.a.sFg.b(this.nbf);
        bvq();
        bvt();
        bvy();
    }

    private void bvn() {
        au.HU();
        int a = bi.a((Integer) com.tencent.mm.model.c.DT().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(R.h.shake_report_bg_img);
        if (!(this.naw == null || this.naw.isRecycled())) {
            this.naw.recycle();
        }
        au.HU();
        if (bi.c((Boolean) com.tencent.mm.model.c.DT().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Gb()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.a.e.cn(stringBuilder2)) {
                this.naw = y.oQ(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.naw));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.decodeStream(this.mController.tml.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    x.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            au.HU();
            this.naw = y.oQ((String) com.tencent.mm.model.c.DT().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.naw));
        }
        imageView = (ImageView) findViewById(R.h.shake_logo_up);
        ImageView imageView2 = (ImageView) findViewById(R.h.shake_logo_down);
        imageView.setImageResource(a == 2 ? R.g.shake_logo_female_up : R.g.shake_logo_up);
        imageView2.setImageResource(a == 2 ? R.g.shake_logo_female_down : R.g.shake_logo_down);
        7 7 = new 7(this);
        imageView.setOnClickListener(7);
        imageView2.setOnClickListener(7);
        if (this.nak == null) {
            this.nak = findViewById(R.h.shake_line_down);
        }
        this.nak.setOnClickListener(7);
        if (this.nal == null) {
            this.nal = findViewById(R.h.shake_line_up);
        }
        this.nal.setOnClickListener(7);
    }

    private void hE(boolean z) {
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        x.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        com.tencent.mm.ui.base.x.b(z, new Intent().putExtra("classname", format));
    }

    private void bvo() {
        l.b bVar;
        if (this.naH == 3 && com.tencent.mm.an.c.Qf()) {
            this.naH = 3;
            this.nah.setText(R.l.shake_searching_music_tips);
            this.nay.setBackgroundResource(R.g.shake_icon_ibeacon);
            this.naA.setBackgroundResource(R.g.shake_icon_people);
            this.naB.setBackgroundResource(R.g.shake_icon_music_hl);
            this.naC.setBackgroundResource(R.g.shake_icon_tv);
            this.naD.setBackgroundResource(R.g.shake_cardpack_icon);
            findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
            setMMTitle(R.l.shake_report_title_music);
            h.mEJ.h(11720, new Object[]{Integer.valueOf(2)});
            h.mEJ.e(834, 2, 1);
        } else if (this.naH == 4 && k.buA()) {
            this.naH = 4;
            this.nah.setText(R.l.shake_searching_tv_tips);
            this.nay.setBackgroundResource(R.g.shake_icon_ibeacon);
            this.naA.setBackgroundResource(R.g.shake_icon_people);
            this.naB.setBackgroundResource(R.g.shake_icon_music);
            this.naC.setBackgroundResource(R.g.shake_icon_tv_hl);
            this.naD.setBackgroundResource(R.g.shake_cardpack_icon);
            findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
            setMMTitle(R.l.shake_report_title_tv);
            h.mEJ.h(11720, new Object[]{Integer.valueOf(3)});
            h.mEJ.e(834, 3, 1);
        } else if (this.naH == 5 && bvw()) {
            this.naH = 5;
            this.nah.setText(R.l.shake_searching_ibeacon_tips);
            this.nay.setBackgroundResource(R.g.shake_icon_ibeacon_hl);
            this.naA.setBackgroundResource(R.g.shake_icon_people);
            this.naB.setBackgroundResource(R.g.shake_icon_music);
            this.naC.setBackgroundResource(R.g.shake_icon_tv);
            this.naD.setBackgroundResource(R.g.shake_cardpack_icon);
            findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
            setMMTitle(R.l.shake_report_title_ibeacon);
            h.mEJ.h(11720, new Object[]{Integer.valueOf(4)});
            h.mEJ.e(834, 4, 1);
        } else if (this.naH == 6 && com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            this.naH = 6;
            this.nah.setText(R.l.shake_searching_card_tips);
            this.nay.setBackgroundResource(R.g.shake_icon_ibeacon);
            this.naA.setBackgroundResource(R.g.shake_icon_people);
            this.naB.setBackgroundResource(R.g.shake_icon_music);
            this.naC.setBackgroundResource(R.g.shake_icon_tv);
            this.naD.setBackgroundResource(R.g.shake_cardpack_iconhl);
            findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
            setMMTitle(R.l.shake_report_title_card);
            bvr();
            bvu();
            h.mEJ.h(11720, new Object[]{Integer.valueOf(5)});
            h.mEJ.e(834, 5, 1);
        } else {
            this.naH = 1;
            this.nah.setText(R.l.shake_finding);
            this.nay.setBackgroundResource(R.g.shake_icon_ibeacon);
            this.naA.setBackgroundResource(R.g.shake_icon_people_hl);
            this.naB.setBackgroundResource(R.g.shake_icon_music);
            this.naC.setBackgroundResource(R.g.shake_icon_tv);
            this.naD.setBackgroundResource(R.g.shake_cardpack_icon);
            if (com.tencent.mm.an.c.Qf()) {
                findViewById(R.h.shake_report_bottom_tabs_ll).setVisibility(0);
            }
            setMMTitle(R.l.shake_report_title);
            h.mEJ.h(11720, new Object[]{Integer.valueOf(1)});
            h.mEJ.e(834, 1, 1);
        }
        l lVar = this.nab;
        int i = this.naH;
        if (i == lVar.mWO) {
            bVar = lVar.mWP;
        } else {
            if (lVar.mWP != null) {
                lVar.mWP.bup();
            }
            switch (i) {
                case 1:
                    lVar.mWP = new com.tencent.mm.plugin.shake.b.c(this, this);
                    break;
                case 3:
                    lVar.mWP = j.a((com.tencent.mm.plugin.shake.b.l.a) this);
                    break;
                case 4:
                    lVar.mWP = new com.tencent.mm.plugin.shake.d.a.l(this, this);
                    break;
                case 5:
                    lVar.mWP = new com.tencent.mm.plugin.shake.d.a.h(this);
                    break;
                case 6:
                    lVar.mWP = new com.tencent.mm.plugin.shake.c.a.g(this);
                    break;
            }
            lVar.mWO = i;
            lVar.mWP.init();
            bVar = lVar.mWP;
        }
        if (!this.mZV) {
            hI(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bvb() && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
            int i2 = this.naT;
            gVar.hop = i2;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i2);
            if (this.naT == 3) {
                x.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                com.tencent.mm.plugin.shake.c.a.g gVar2 = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                String stringExtra = getIntent().getStringExtra("key_shake_card_ext_info");
                if (stringExtra == null || stringExtra.length() > 256) {
                    x.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + stringExtra);
                    return;
                }
                x.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + gVar2.fHA);
                gVar2.fHA = stringExtra;
            }
        }
    }

    private void bvp() {
        au.HU();
        this.mZU = bi.c((Boolean) com.tencent.mm.model.c.DT().get(4112, null));
        if (this.mZU) {
            setTitleMuteIconVisibility(8);
        } else {
            setTitleMuteIconVisibility(0);
        }
    }

    private void hF(boolean z) {
        com.tencent.mm.plugin.shake.b.f fVar = null;
        hG(z);
        if (this.nar == null) {
            this.nar = findViewById(R.h.goto_shake_msg_btn);
        }
        if (z) {
            if (m.buD().axd() <= 0) {
                this.nar.setVisibility(8);
                return;
            }
            if (this.nat == null) {
                this.nat = (TextView) this.nar.findViewById(R.h.shake_msg_count);
            }
            this.nat.setText(getString(R.l.shake_msg_count_text, new Object[]{Integer.valueOf(r2)}));
            this.nar.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(ShakeReportUI.this, ShakeMsgListUI.class);
                    intent.putExtra("shake_msg_from", 1);
                    intent.putExtra("shake_msg_list_title", ShakeReportUI.this.getString(R.l.shake_tv_msg_center_title));
                    ShakeReportUI.this.startActivity(intent);
                }
            });
            if (this.nas == null) {
                this.nas = (MMImageView) findViewById(R.h.shake_msg_thumb);
            }
            com.tencent.mm.plugin.shake.b.g buD = m.buD();
            Cursor b = buD.diF.b("SELECT * FROM " + buD.getTableName() + " where status != 1 ORDER BY rowid DESC LIMIT 1", null, 2);
            if (b != null) {
                com.tencent.mm.plugin.shake.b.f fVar2;
                if (b.moveToFirst()) {
                    fVar2 = new com.tencent.mm.plugin.shake.b.f();
                    fVar2.d(b);
                } else {
                    fVar2 = null;
                }
                b.close();
                fVar = fVar2;
            }
            if (fVar != null) {
                String str = fVar.field_thumburl;
                if (bi.oW(str)) {
                    this.nas.setImageResource(R.k.app_attach_file_icon_webpage);
                } else {
                    com.tencent.mm.plugin.shake.e.b bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a = y.a(bVar);
                    this.nas.setTag(bVar.Vx());
                    if (a == null || a.isRecycled()) {
                        this.nas.setImageResource(R.k.app_attach_file_icon_webpage);
                    } else {
                        this.nas.setImageBitmap(a);
                    }
                }
            }
            this.nar.setVisibility(0);
            return;
        }
        this.nar.setVisibility(8);
    }

    private void hG(boolean z) {
        if (this.naq == null) {
            this.naq = findViewById(R.h.goto_sayhi_btn);
        }
        if (this.nab.mWO == 3 || this.nab.mWO == 4 || this.nab.mWO == 5 || this.nab.mWO == 6 || !z) {
            this.naq.setVisibility(8);
            return;
        }
        int axd = com.tencent.mm.az.d.SH().axd();
        if (axd <= 0) {
            this.naq.setVisibility(8);
            return;
        }
        this.naq.setVisibility(0);
        ((TextView) this.naq.findViewById(R.h.say_hi_count)).setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, axd, new Object[]{Integer.valueOf(axd)}));
        this.naq.setOnClickListener(new 8(this));
        if (this.nau == null) {
            this.nau = (ImageView) findViewById(R.h.match_dlg_img);
        }
        bo cna = com.tencent.mm.az.d.SH().cna();
        if (cna != null) {
            this.nav = cna.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.a(this.nau, this.nav);
        }
    }

    private void hH(boolean z) {
        if (this.nag == null) {
            return;
        }
        if (z) {
            this.nag.setVisibility(0);
            return;
        }
        this.nag.setVisibility(8);
        this.nag.cancelLongPress();
    }

    private void hI(boolean z) {
        if (this.nae == null) {
            return;
        }
        if (z) {
            this.nae.setVisibility(0);
        } else {
            this.nae.setVisibility(4);
        }
    }

    private void wc(int i) {
        hI(i == 1);
        if (i == 2) {
            hH(true);
        } else {
            hH(false);
        }
    }

    public final void HK() {
        bvo();
    }

    private void Lj(String str) {
        this.mZV = false;
        if (this.mZU) {
            as.I(this.mController.tml, R.l.shake_nomatch);
        }
        if (this.nap == null) {
            this.nap = AnimationUtils.loadAnimation(this.mController.tml, R.a.faded_out);
        }
        wc(2);
        if (str == null || str.length() <= 1) {
            this.nag.setText(R.l.shake_getfial);
        } else {
            this.nag.setText(str);
        }
        this.nag.startAnimation(this.nap);
        this.mZY = true;
        ah.i(new 14(this), this.nap.getDuration());
    }

    public final void d(List<d> list, long j) {
        bvy();
        if (list == null || !this.mZV || j == 6) {
            this.naz = null;
            if (j == 6) {
                Lj(getString(R.l.shake_ibeacon_over_frequency_tips));
                return;
            } else if (j == 7) {
                Lj(getString(R.l.shake_ibeacon_no_activity));
                return;
            } else if (j == 8) {
                Lj(getString(R.l.shake_ibeacon_gps_off));
                return;
            } else if (j == 9) {
                Lj(getString(R.l.shake_ibeacon_bluetooth_off));
                return;
            } else if (j == 10) {
                Lj(getString(R.l.shake_ibeacon_not_support));
                return;
            } else {
                Lj(null);
                return;
            }
        }
        this.mZV = false;
        if (list.size() > 0) {
            this.naz = (d) list.get(0);
        }
        int size;
        d dVar;
        Intent intent;
        if (this.nab.mWO == 1) {
            if (list.size() <= 0 || ((d) list.get(0)).field_type == 0) {
                this.mZZ = ((d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    Lj(null);
                    return;
                } else if (size == 1) {
                    x.i("MicroMsg.ShakeReportUI", "1 u:" + ((d) list.get(0)).field_username + " n:" + ((d) list.get(0)).field_nickname + " d:" + ((d) list.get(0)).field_distance);
                    if (this.mZU) {
                        as.I(this.mController.tml, R.l.shake_match);
                    }
                    wc(3);
                    dVar = (d) list.get(0);
                    if (!bi.oW(dVar.field_username)) {
                        this.nad.setTag(dVar.field_username);
                        this.nad.setVisibility(0);
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(dVar.field_username);
                        String str = dVar.field_nickname + (com.tencent.mm.l.a.gd(Yg.field_type) ? getString(R.l.shake_match_isfriend) : "");
                        if (dVar.field_sex == 1) {
                            this.nad.setContentDescription(str + dVar.field_distance + this.mController.tml.getString(R.l.shake_sex_male));
                        } else if (dVar.field_sex == 2) {
                            this.nad.setContentDescription(str + dVar.field_distance + this.mController.tml.getString(R.l.shake_sex_female));
                        } else {
                            this.nad.setContentDescription(str + dVar.field_distance);
                        }
                        TextView textView = (TextView) this.nad.findViewById(R.h.shake_match_dlg_nickname);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mController.tml, dVar.field_nickname + (com.tencent.mm.l.a.gd(Yg.field_type) ? getString(R.l.shake_match_isfriend) : ""), textView.getTextSize()));
                        if (this.eBM != null) {
                            if (bi.oW(str)) {
                                this.eBM.setContentDescription(getString(R.l.shake_avatar_unknow));
                            } else {
                                this.eBM.setContentDescription(String.format(getString(R.l.shake_avatar), new Object[]{str}));
                            }
                        }
                        ((TextView) this.nad.findViewById(R.h.shake_match_dlg_distance)).setText(dVar.field_distance);
                        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) this.nad.findViewById(R.h.shake_match_dlg_img), dVar.field_username);
                        ImageView imageView = (ImageView) this.nad.findViewById(R.h.shake_match_dlg_vinfo_iv);
                        if (dVar.field_reserved1 != 0) {
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(BackwardSupportUtil.b.e(com.tencent.mm.model.am.a.dBt.gX(dVar.field_reserved1), 2.0f));
                        } else {
                            imageView.setVisibility(8);
                        }
                        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                            this.nad.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(8);
                        } else {
                            Drawable f = com.tencent.mm.bp.a.f(this, dVar.field_sex == 1 ? R.k.ic_sex_male : R.k.ic_sex_female);
                            this.nad.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(0);
                            ((ImageView) this.nad.findViewById(R.h.shake_match_dlg_sex_iv)).setImageDrawable(f);
                        }
                        if (dVar.getProvince() == null) {
                            x.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                            dVar.field_province = "";
                        }
                        if (dVar.getCity() == null) {
                            x.e("MicroMsg.ShakeReportUI", "CITY NULL");
                            dVar.field_city = "";
                        }
                        this.nad.startAnimation(AnimationUtils.loadAnimation(this.mController.tml, R.a.shake_report_dlg_translate_in));
                        return;
                    }
                    return;
                } else {
                    if (this.mZU) {
                        as.I(this.mController.tml, R.l.shake_match);
                    }
                    wc(3);
                    hG(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(R.l.shake_item_shake_person_list));
                    startActivity(intent);
                    return;
                }
            }
            Lj(null);
        } else if (this.nab.mWO == 3) {
            size = list.size();
            if (size == 0) {
                Lj(getString(R.l.shake_music_no_match));
            } else if (size == 1) {
                if (this.mZU) {
                    as.I(this.mController.tml, R.l.shake_match);
                }
                wc(3);
                if (((d) list.get(0)).field_type == 4) {
                    avq c = com.tencent.mm.plugin.shake.d.a.i.c(((d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.an.b.c(c);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", c.rYk);
                    intent2.putExtra("music_player_beg_time", c.nlo);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.an.c.Qg()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.bg.d.b(this, "music", ".ui.MusicMainUI", intent2);
                    return;
                }
                x.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
        } else if (this.nab.mWO == 4) {
            bvy();
            size = list.size();
            if (size == 0) {
                Lj(getString(R.l.shake_tv_no_match));
            } else if (size == 1) {
                if (this.mZU) {
                    as.I(this.mController.tml, R.l.shake_match);
                }
                wc(3);
                new ag().postDelayed(new 1((d) list.get(0), this), 100);
            }
        } else if (this.nab.mWO == 5) {
            switch ((int) j) {
                case 1:
                    if (list.isEmpty() || ((d) list.get(0)).field_type != 11) {
                        Lj(null);
                        return;
                    } else if (list.size() == 1) {
                        if (this.mZU) {
                            as.I(this.mController.tml, R.l.shake_match);
                        }
                        wc(3);
                        dVar = (d) list.get(0);
                        if (!bi.oW(dVar.field_username)) {
                            this.nad.setTag(dVar.field_username);
                            ((TextView) this.nad.findViewById(R.h.shake_match_dlg_nickname)).setText(dVar.field_username);
                            this.nad.setContentDescription(bi.oV(dVar.field_nickname));
                            ((TextView) this.nad.findViewById(R.h.shake_match_dlg_distance)).setText(dVar.field_signature);
                            this.dWD.a(dVar.getProvince(), (ImageView) this.nad.findViewById(R.h.shake_match_dlg_img));
                            this.nad.findViewById(R.h.shake_match_dlg_sex_iv).setVisibility(8);
                            this.nad.startAnimation(AnimationUtils.loadAnimation(this.mController.tml, R.a.shake_report_dlg_translate_in));
                            this.nad.setVisibility(0);
                            return;
                        }
                        return;
                    } else {
                        if (this.mZU) {
                            as.I(this.mController.tml, R.l.shake_match);
                        }
                        wc(3);
                        hG(false);
                        intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -12);
                        intent.putExtra("_key_title_", getString(R.l.shake_item_shake_ibeacon));
                        intent.putExtra("_key_show_from_shake_", true);
                        intent.putExtra("_ibeacon_new_insert_size", list.size());
                        startActivity(intent);
                        return;
                    }
                case 6:
                    Lj(getString(R.l.shake_ibeacon_over_frequency_tips));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        this.naV = true;
        if (i == 1251) {
            if (eVar != null) {
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                com.tencent.mm.plugin.shake.c.c.a.buw();
                bvv();
                bvq();
                bvt();
                this.naT = 4;
                m.buI().putValue("key_shake_card_item", eVar);
            }
        } else if (i != 1250) {
        } else {
            if (eVar == null) {
                this.naz = null;
                Lj(null);
            } else if ((eVar == null || this.mZV) && !this.mZV) {
                this.naz = null;
                Lj(null);
            } else {
                this.mZV = false;
                x.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                if (this.nab.mWO == 6) {
                    l.b bVar = this.nab.mWP;
                    if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                        switch ((int) j) {
                            case 1:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                if (gVar.hwF == 3) {
                                    x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                    if (eVar == null || TextUtils.isEmpty(eVar.mXr)) {
                                        Lj(getString(R.l.shake_card_fail_tip));
                                        return;
                                    } else {
                                        Lj(eVar.mXr);
                                        return;
                                    }
                                }
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.hwF);
                                wc(3);
                                if (eVar.hwF == 1) {
                                    this.mZX = false;
                                }
                                if (this.naU != null && this.naU.isShowing()) {
                                    return;
                                }
                                if (eVar.mXt) {
                                    ViewStub viewStub = (ViewStub) findViewById(R.h.viewstub_egg_animframe);
                                    if (viewStub != null) {
                                        viewStub.inflate();
                                    }
                                    ((ShakeEggAnimFrame) findViewById(R.h.chatting_anim_iv)).G(this);
                                    new ag().postDelayed(new Runnable() {
                                        public final void run() {
                                            ShakeReportUI.this.a(eVar);
                                        }
                                    }, 1000);
                                    return;
                                }
                                a(eVar);
                                return;
                            case 2:
                                x.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                Lj(getString(R.l.shake_card_fail_tip));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        this.naU = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new 16(this), new 17(this));
    }

    private void cw(View view) {
        if (view != null) {
            x.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                aN("", false);
                if (view.getId() == R.h.shake_report_tab_friend_ll) {
                    h.mEJ.h(11722, new Object[]{Integer.valueOf(1)});
                    if (this.naH != 1) {
                        if (this.naH == 4) {
                            hE(false);
                        }
                        this.naH = 1;
                        bvo();
                        hG(false);
                        if (this.nad != null) {
                            this.nad.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.shake_report_tab_music_ll) {
                    h.mEJ.h(11722, new Object[]{Integer.valueOf(2)});
                    if (!(this.cXo || this.cXl == null)) {
                        this.cXl.a(this.cXs, true);
                    }
                    if (!(com.tencent.mm.p.a.by(this) || com.tencent.mm.p.a.bw(this) || this.naH == 3)) {
                        if (this.naH == 4) {
                            hE(false);
                        }
                        this.naH = 3;
                        bvo();
                        hG(false);
                        if (this.nad != null) {
                            this.nad.setVisibility(8);
                        }
                    }
                    if (com.tencent.mm.an.c.Qg()) {
                        au.HU();
                        if (com.tencent.mm.model.c.DT().getInt(4118, 0) == 0) {
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.mController.tml);
                            aVar.Gq(R.l.app_tip);
                            aVar.Gr(R.l.shake_info_music);
                            aVar.Gt(R.l.shake_info_known).a(new 2(this));
                            aVar.mF(true);
                            aVar.e(new 3(this));
                            this.nax = aVar.anj();
                            this.nax.show();
                        }
                    }
                } else if (view.getId() == R.h.shake_report_tab_tv_ll) {
                    h.mEJ.h(11722, new Object[]{Integer.valueOf(3)});
                    if (!(this.cXo || this.cXl == null)) {
                        this.cXl.a(this.cXs, true);
                    }
                    if (!(com.tencent.mm.p.a.by(this) || com.tencent.mm.p.a.bw(this) || this.naH == 4)) {
                        hE(true);
                        this.naH = 4;
                        bvo();
                        hG(false);
                        if (this.nad != null) {
                            this.nad.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.shake_report_tab_ibeacon_ll || view.getId() == R.h.shake_report_tab_ibeacon_first_ll) {
                    h.mEJ.h(11722, new Object[]{Integer.valueOf(4)});
                    if (this.naH != 5) {
                        this.naH = 5;
                        bvo();
                        hG(false);
                        if (this.nad != null) {
                            this.nad.setVisibility(8);
                        }
                        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                            boolean isProviderEnabled;
                            LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
                            if (locationManager != null) {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                            } else {
                                isProviderEnabled = true;
                            }
                            if (!isProviderEnabled) {
                                Lj(getString(R.l.shake_ibeacon_gps_off));
                            }
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                            Lj(getString(R.l.shake_ibeacon_bluetooth_off));
                        } else if (defaultAdapter == null) {
                            Lj(getString(R.l.shake_ibeacon_not_support));
                        }
                    }
                } else if (view.getId() == R.h.shake_report_tab_card_ll) {
                    h.mEJ.h(11722, new Object[]{Integer.valueOf(5)});
                    if (this.naH != 6) {
                        if (this.naH == 4) {
                            hE(false);
                        }
                        this.naH = 6;
                        bvo();
                        hG(false);
                        if (this.nad != null) {
                            this.nad.setVisibility(8);
                        }
                        com.tencent.mm.s.c.Cp().v(262155, false);
                        this.naF.setVisibility(8);
                    }
                }
                hF(true);
                hI(false);
                bvy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(com.tencent.mm.model.c.Gb()).append("custom_shake_img_filename.jpg").toString());
                    com.tencent.mm.plugin.shake.a.ezn.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    au.HU();
                    com.tencent.mm.model.c.DT().set(4110, Boolean.valueOf(false));
                    au.HU();
                    com.tencent.mm.model.c.DT().set(4111, stringExtra);
                    bvn();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        bvp();
        if (!this.mZW) {
            hF(true);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        a("", null);
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled() && this.nas != null && this.nas.getTag() != null && str.equals((String) this.nas.getTag())) {
            this.nas.setImageBitmap(bitmap);
        }
    }

    public final void buL() {
        com.tencent.mm.plugin.shake.c.c.a.buw();
        bvq();
        bvr();
        bvu();
        bvv();
        bvt();
    }

    private void bvq() {
        if (!com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            return;
        }
        if (com.tencent.mm.s.c.Cp().aU(262155, 266259)) {
            this.naF.setVisibility(0);
        } else {
            this.naF.setVisibility(8);
        }
    }

    private void bvr() {
        if (this.naH == 6 && com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            boolean aU = com.tencent.mm.s.c.Cp().aU(262154, 266258);
            boolean aU2 = com.tencent.mm.s.c.Cp().aU(262155, 266259);
            if (aU) {
                aN(com.tencent.mm.plugin.shake.c.c.a.buW(), true);
            } else if (aU2) {
                aN(com.tencent.mm.plugin.shake.c.c.a.buY(), true);
            } else if (!this.naV) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.buU())) {
                    aN(getString(R.l.shake_card_init_tips), true);
                } else {
                    aN(com.tencent.mm.plugin.shake.c.c.a.buU(), true);
                }
            }
        }
    }

    private void aN(String str, boolean z) {
        this.mZV = false;
        if (this.nap == null) {
            this.nap = AnimationUtils.loadAnimation(this.mController.tml, R.a.faded_out);
        }
        wc(2);
        hH(true);
        if (str != null && str.length() > 1) {
            this.nag.setText(str);
        } else if (z) {
            this.nag.setText(R.l.shake_card_init_tips);
        } else {
            this.nag.setText("");
            hH(false);
        }
        this.mZY = true;
    }

    private void bvs() {
        if (this.naU != null && this.naU.isShowing()) {
            this.naU.dismiss();
        }
        this.naU = null;
    }

    private void bvt() {
        int intExtra;
        int i;
        int i2 = 1;
        boolean bux = com.tencent.mm.plugin.shake.c.c.a.bux();
        boolean aU = com.tencent.mm.s.c.Cp().aU(262154, 266258);
        boolean aU2 = com.tencent.mm.s.c.Cp().aU(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        h hVar = h.mEJ;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (aU) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(bux ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.buX();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.buT());
        hVar.h(11668, objArr);
        h hVar2 = h.mEJ;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (aU2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!bux) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.buX();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.buT());
        hVar2.h(11668, objArr2);
    }

    private void bvu() {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.buV())) {
            this.naG.setText(com.tencent.mm.plugin.shake.c.c.a.buV());
        }
    }

    private void bvv() {
        if (com.tencent.mm.an.c.Qf()) {
            x.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.naW.put(Integer.valueOf(3), Boolean.valueOf(true));
            findViewById(R.h.shake_report_tab_music_ll).setVisibility(0);
            if (com.tencent.mm.an.c.Qg()) {
                au.HU();
                if (com.tencent.mm.model.c.DT().getInt(4118, 0) == 0) {
                    this.naE.setVisibility(0);
                } else {
                    this.naE.setVisibility(8);
                }
            }
        } else {
            this.naW.put(Integer.valueOf(3), Boolean.valueOf(false));
            findViewById(R.h.shake_report_tab_music_ll).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (k.buA()) {
            this.naW.put(Integer.valueOf(4), Boolean.valueOf(true));
            findViewById(R.h.shake_report_tab_tv_ll).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.naW.put(Integer.valueOf(4), Boolean.valueOf(false));
            findViewById(R.h.shake_report_tab_tv_ll).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bvb()) {
            this.naW.put(Integer.valueOf(6), Boolean.valueOf(true));
            findViewById(R.h.shake_report_tab_card_ll).setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(R.h.shake_report_tab_card_ll).setVisibility(8);
            this.naW.put(Integer.valueOf(6), Boolean.valueOf(false));
            x.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (bvw()) {
            this.naW.put(Integer.valueOf(5), Boolean.valueOf(true));
            this.naS.setVisibility(0);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.naW.put(Integer.valueOf(5), Boolean.valueOf(false));
            this.naS.setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.naW.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.naI = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.shake_report_bottom_tabs_ll);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i > 4 && this.nbd) {
            findViewById(R.h.shake_report_tab_tv_ll).setVisibility(8);
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
            this.naI--;
        } else if (i > 4 && !this.nbd) {
            this.naS.setVisibility(8);
            this.naX = false;
            this.naI--;
            x.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
        }
    }

    private boolean bvw() {
        x.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + w.chL() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + w.chP());
        return this.naX && bvx();
    }

    private static boolean bvx() {
        return w.chL() || w.chP().equals("en") || w.chP().equals("ja");
    }

    private void bvy() {
        this.naJ.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ShakeReportUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr[0] == 0) {
                    bpD();
                    return;
                }
                this.eLU = false;
                com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 21(this), new 23(this));
                return;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 19(this), new 20(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
