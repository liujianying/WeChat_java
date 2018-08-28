package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.e;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.c.f;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.4;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.5;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b$a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SnsAdNativeLandingPagesUI extends MMActivity {
    public static boolean nSm = false;
    String bSZ;
    private long cYb = 0;
    int egL;
    public String fxE;
    private boolean gUi = false;
    private long grJ = 0;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private int hmV;
    private int hmW;
    private ImageView hml;
    private d iMQ = new d(ad.getContext());
    String ixy;
    String ixz;
    protected b jKu = new 6(this);
    private ImageView jdG;
    private int nBk;
    int nBm;
    private int nEs = 1000;
    private int nEt = TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING;
    private int nEu = 250;
    private View nHH;
    z nHm;
    public LinkedList<c> nRW = new LinkedList();
    private ImageView nRX;
    private ImageView nRY;
    private TextView nRZ;
    private View nSA;
    private LinkedList<View> nSB;
    private boolean nSC = true;
    private View nSD;
    n nSE;
    private volatile int nSF = 2;
    private BroadcastReceiver nSG = new 1(this);
    private BroadcastReceiver nSH = new 9(this);
    private b$a nSI = new 12(this);
    private e nSJ = new 13(this);
    private com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a nSK = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a() {
        public final void at(Object obj) {
            SnsAdNativeLandingPagesUI.this.nSz.removeCallbacksAndMessages(null);
            SnsAdNativeLandingPagesUI.this.nSz.post(new 1(this, obj));
        }

        public final void e(int i, int i2, Object obj) {
        }
    };
    private Map<Integer, Fragment> nSL = new HashMap();
    private boolean nSM = true;
    private boolean nSN = true;
    private BroadcastReceiver nSO = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                x.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                SnsAdNativeLandingPagesUI.this.bCI();
            }
        }
    };
    private j nSP = null;
    private p nSQ = null;
    Bundle nSa;
    b nSb;
    private boolean nSc = false;
    String nSd;
    String nSe;
    private String nSf;
    String nSg;
    String nSh;
    String nSi;
    private ImageView nSj;
    String nSk;
    String nSl;
    public Map<String, String> nSn = new HashMap();
    g nSo = new g();
    boolean nSp = false;
    private int nSq = 0;
    private boolean nSr = false;
    String nSs;
    String nSt;
    String nSu;
    String nSv;
    private AdlandingDummyViewPager nSw;
    int nSx;
    int nSy;
    private ag nSz = new ag();
    String ntU;
    private int nyY;
    public String nyk;
    String nyl;
    String nzH;
    int source;
    private long startTime;
    String uin;
    Map<String, String> values;

    private class a {
        public String ixz;
        public String nzH;
        public String nzI;

        private a() {
            this.ixz = "";
            this.nzH = "";
            this.nzI = "";
        }

        /* synthetic */ a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void A(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        g gVar = snsAdNativeLandingPagesUI.nSo;
        gVar.jzg++;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!bi.oW(snsAdNativeLandingPagesUI.bSZ)) {
            str = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.bSZ).bBe();
        }
        String oV = bi.oV(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        a bCP = snsAdNativeLandingPagesUI.bCP();
        String bCQ = snsAdNativeLandingPagesUI.bCQ();
        String bCR = snsAdNativeLandingPagesUI.bCR();
        if (bCP != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.source, snsAdNativeLandingPagesUI.ixy, oV, bCP.ixz, bCP.nzH, bCR, 34, snsAdNativeLandingPagesUI.NV(bCP.nzI), bCQ);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.source, snsAdNativeLandingPagesUI.ixy, oV, snsAdNativeLandingPagesUI.ixz, snsAdNativeLandingPagesUI.nzH, bCR, 34, snsAdNativeLandingPagesUI.NV(snsAdNativeLandingPagesUI.nSk), bCQ);
        }
        ((v) com.tencent.mm.kernel.g.l(v.class)).a(0, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.jKu);
    }

    static /* synthetic */ void M(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.nRW != null) {
            Iterator it = snsAdNativeLandingPagesUI.nRW.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.nSL.get(Integer.valueOf(((c) it.next()).id));
                if (bVar != null) {
                    bVar.nHp = true;
                }
            }
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.nSL.get(Integer.valueOf(((c) snsAdNativeLandingPagesUI.nRW.getFirst()).id))).bAw();
        }
    }

    static /* synthetic */ void O(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        for (i iVar : snsAdNativeLandingPagesUI.bCH()) {
            if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bzy();
            }
        }
    }

    static /* synthetic */ void bCS() {
    }

    static /* synthetic */ void f(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.nSF == 0) {
            try {
                Map hashMap = new HashMap();
                hashMap.put("startIndex", Integer.valueOf(snsAdNativeLandingPagesUI.nSq));
                ((i) snsAdNativeLandingPagesUI.bCH().get(0)).N(hashMap);
            } catch (Exception e) {
            }
            snsAdNativeLandingPagesUI.bCO();
            if (snsAdNativeLandingPagesUI.nSC && snsAdNativeLandingPagesUI.nSD != null && snsAdNativeLandingPagesUI.nSc) {
                snsAdNativeLandingPagesUI.nSC = false;
                snsAdNativeLandingPagesUI.hDj = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_top", 0);
                snsAdNativeLandingPagesUI.hDk = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_left", 0);
                snsAdNativeLandingPagesUI.hDl = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_width", 0);
                snsAdNativeLandingPagesUI.hDm = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_height", 0);
                snsAdNativeLandingPagesUI.nSb.u(snsAdNativeLandingPagesUI.hDk, snsAdNativeLandingPagesUI.hDj, snsAdNativeLandingPagesUI.hDl, snsAdNativeLandingPagesUI.hDm);
                snsAdNativeLandingPagesUI.hml.setVisibility(8);
                snsAdNativeLandingPagesUI.nRX.setVisibility(8);
                b bVar = snsAdNativeLandingPagesUI.nSb;
                View view = snsAdNativeLandingPagesUI.nSD;
                LinkedList linkedList = snsAdNativeLandingPagesUI.nSB;
                View view2 = snsAdNativeLandingPagesUI.jdG;
                snsAdNativeLandingPagesUI.isFullScreen();
                bVar.a(view, linkedList, view2, new 3(snsAdNativeLandingPagesUI));
                return;
            }
            snsAdNativeLandingPagesUI.nHH.post(new 4(snsAdNativeLandingPagesUI));
        }
    }

    static /* synthetic */ void n(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        snsAdNativeLandingPagesUI.bCF();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) snsAdNativeLandingPagesUI.nSw.getAdapter();
        if (cVar2 == null) {
            cVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(snsAdNativeLandingPagesUI.getSupportFragmentManager(), new ArrayList());
            snsAdNativeLandingPagesUI.nSw.setAdapter(cVar2);
            cVar = cVar2;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < snsAdNativeLandingPagesUI.nRW.size()) {
            c cVar3 = (c) snsAdNativeLandingPagesUI.nRW.get(i);
            if (cVar3.nBi) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load %d", new Object[]{Integer.valueOf(i)});
                Fragment fragment = (Fragment) snsAdNativeLandingPagesUI.nSL.get(Integer.valueOf(cVar3.id));
                if (fragment == null) {
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar3, snsAdNativeLandingPagesUI.nSw, snsAdNativeLandingPagesUI.nHm, i == snsAdNativeLandingPagesUI.nRW.size() + -1, i == 0 ? snsAdNativeLandingPagesUI.nSI : null, snsAdNativeLandingPagesUI.nSc, snsAdNativeLandingPagesUI.bCK());
                    snsAdNativeLandingPagesUI.nSL.put(Integer.valueOf(cVar3.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar3);
                }
                if (fragment != null) {
                    cVar.a(fragment, i);
                }
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        snsAdNativeLandingPagesUI.nSw.setOffscreenPageLimit(snsAdNativeLandingPagesUI.nRW.size());
    }

    static /* synthetic */ void o(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.nyY != 2) {
            h hVar = h.mEJ;
            Object[] objArr = new Object[7];
            objArr[0] = com.tencent.mm.plugin.sns.data.i.eF(com.tencent.mm.plugin.sns.data.i.LP(snsAdNativeLandingPagesUI.nSo.bSZ));
            objArr[1] = snsAdNativeLandingPagesUI.ntU == null ? "" : snsAdNativeLandingPagesUI.ntU;
            objArr[2] = Integer.valueOf(snsAdNativeLandingPagesUI.nSo.nIF);
            objArr[3] = Integer.valueOf(snsAdNativeLandingPagesUI.nSo.nIG);
            objArr[4] = Long.valueOf(snsAdNativeLandingPagesUI.cYb);
            objArr[5] = Integer.valueOf(snsAdNativeLandingPagesUI.nBk);
            objArr[6] = snsAdNativeLandingPagesUI.nSo.nIP;
            hVar.h(14655, objArr);
        }
    }

    static /* synthetic */ void y(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.nSo;
        gVar.iVN++;
        String bCQ = snsAdNativeLandingPagesUI.bCQ();
        String bCR = snsAdNativeLandingPagesUI.bCR();
        a bCP = snsAdNativeLandingPagesUI.bCP();
        if (bCP != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bCR, bCP.ixz, snsAdNativeLandingPagesUI.NV(bCP.nzI), bCP.nzH, snsAdNativeLandingPagesUI.ixy, bCQ);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, bCR, snsAdNativeLandingPagesUI.ixz, snsAdNativeLandingPagesUI.NV(snsAdNativeLandingPagesUI.nSk), snsAdNativeLandingPagesUI.nzH, snsAdNativeLandingPagesUI.ixy, bCQ);
    }

    static /* synthetic */ void z(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.nSo;
        gVar.iVO++;
        String str = snsAdNativeLandingPagesUI.ixy;
        a bCP = snsAdNativeLandingPagesUI.bCP();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            return;
        }
        int i = snsAdNativeLandingPagesUI.hDl;
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.ixy);
        if (bCP != null) {
            intent.putExtra("Ksnsupload_title", bCP.ixz);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.NV(bCP.nzI));
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.ixz);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.NV(snsAdNativeLandingPagesUI.nSk));
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.bCR());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        str = snsAdNativeLandingPagesUI.bCQ();
        if (!bi.oW(str)) {
            intent.putExtra("key_snsad_statextstr", str);
        }
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.source == 1 || snsAdNativeLandingPagesUI.source == 2 || snsAdNativeLandingPagesUI.source == 3 || snsAdNativeLandingPagesUI.source == 4 || snsAdNativeLandingPagesUI.source == 9 || snsAdNativeLandingPagesUI.source == 10 || snsAdNativeLandingPagesUI.source == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.bSZ;
        } else if (snsAdNativeLandingPagesUI.source == 5 || snsAdNativeLandingPagesUI.source == 6) {
            str = "msg_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        } else if (snsAdNativeLandingPagesUI.source == 7) {
            str = "fav_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid");
        }
        String ic = u.ic(str);
        u.Hx().v(ic, true).p("prePublishId", str);
        intent.putExtra("reportSessionId", ic);
        com.tencent.mm.bg.d.a(snsAdNativeLandingPagesUI.mController.tml, "sns", ".ui.SnsUploadUI", intent, 1, false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.startTime = System.currentTimeMillis();
        this.cYb = System.currentTimeMillis();
        this.nSo.cYb = this.cYb;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
        bCI();
        int[] ee = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.ee(this);
        this.hmV = ee[0];
        this.hmW = ee[1];
        this.nSa = bundle;
        this.mController.hideTitleView();
        getWindow().addFlags(128);
        AdLandingPagesProxy.create(this.iMQ);
        this.iMQ.K(new 15(this));
        this.source = getIntent().getIntExtra("sns_landig_pages_from_source", 1);
        this.nBk = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
        this.nSd = getIntent().getStringExtra("sns_landing_pages_xml");
        String stringExtra = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
        if (bi.oW(this.nSd) && !bi.oW(stringExtra)) {
            this.nSd = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.Nd(stringExtra);
        }
        if (bi.oW(this.nSd)) {
            finish();
            return;
        }
        this.nSd = this.nSd.replaceAll("</*RecXml[\\s|\\S]*?>", "");
        this.nSo.ntX = getIntent().getStringExtra("sns_landing_pages_expid");
        this.nSe = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
        this.bSZ = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
        this.nSl = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
        this.ntU = getIntent().getStringExtra("sns_landing_pages_ux_info");
        this.nyk = getIntent().getStringExtra("sns_landing_pages_aid");
        this.fxE = getIntent().getStringExtra("sns_landing_pages_traceid");
        Object stringExtra2 = getIntent().getStringExtra("sns_landing_pages_search_extra");
        g gVar = this.nSo;
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (gVar.extra.length() > 0) {
                gVar.extra += "&";
            }
            gVar.extra += "searchextra=" + URLEncoder.encode(stringExtra2);
        }
        stringExtra2 = getIntent().getStringExtra("sns_landing_pages_extra");
        gVar = this.nSo;
        if (!TextUtils.isEmpty(stringExtra2)) {
            gVar.extra += "&extra1=" + URLEncoder.encode(stringExtra2);
        }
        nSm = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
        this.nyY = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
        this.nSq = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
        this.nSf = getIntent().getStringExtra("sns_landing_pages_ad_info");
        this.nSc = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        if (this.nSc) {
            this.nSo.nIF = 0;
            this.nSo.cXB = 0;
        } else {
            this.nSo.nIF = 1;
            this.nSo.cXB = 1;
        }
        this.nSo.nIG = this.source;
        this.nSo.nIH = 0;
        this.nSo.nII = 0;
        this.nSo.nIJ = 1;
        this.nSo.nIK = 0;
        this.nSo.nBk = this.nBk;
        if (this.nSe == null || "".equals(this.nSd)) {
            this.nSe = "adxml";
        }
        if (bi.oW(this.nSd) || bi.oW(this.nSe)) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.nSd + ",landingPagesXmlPrex is " + this.nSe);
            return;
        }
        this.values = f.z(this.nSd, this.nSe);
        this.nSo.nIP = bi.aG((String) this.values.get("." + this.nSe + ".adCanvasInfo.canvasId"), "");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        getWindow().clearFlags(128);
        if (this.gUi) {
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.nSp) {
                bCD();
                xP();
            }
        }
        unregisterReceiver(this.nSO);
        super.onDestroy();
    }

    private void bCD() {
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.nSw.getAdapter()).nB) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
            if (bVar.nHl != null && bVar.getUserVisibleHint()) {
                bVar.nHl.bAo();
            }
        }
    }

    private void xP() {
        int i;
        Iterator it;
        List<i> bCG = bCG();
        this.grJ += System.currentTimeMillis() - this.startTime;
        this.nSo.nIM = (int) this.grJ;
        g gVar = this.nSo;
        if (this.nRW == null) {
            i = 0;
        } else {
            it = this.nRW.iterator();
            i = 0;
            while (it.hasNext()) {
                i = ((c) it.next()).nIi.size() + i;
            }
        }
        gVar.nIL = i;
        g gVar2 = this.nSo;
        JSONArray jSONArray = new JSONArray();
        for (i iVar : bCG) {
            if (!iVar.bzT().nBj) {
                JSONObject jSONObject = new JSONObject();
                if (!iVar.r(jSONArray)) {
                    if (iVar.aa(jSONObject)) {
                        jSONArray.put(jSONObject);
                    }
                    if (iVar instanceof o) {
                        it = ((o) iVar).bAe().iterator();
                        while (it.hasNext()) {
                            jSONArray.put((JSONObject) it.next());
                        }
                    }
                }
            }
        }
        gVar2.nIN = jSONArray.toString();
        x.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[]{gVar2.nIN});
        if (!bi.oW(gVar2.nIN)) {
            try {
                gVar2.nIN = URLEncoder.encode(gVar2.nIN, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        String bAC = this.nSo.bAC();
        if (this.nBm == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, bAC);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: " + bAC);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.nSo.bSZ)) {
            h.mEJ.k(14650, bAC);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: " + bAC);
        } else {
            h.mEJ.k(13387, bAC);
            x.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + bAC);
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        bCI();
        android.support.v4.content.d.O(this).a(this.nSG, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.O(this).a(this.nSH, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.gUi) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.nSO, new IntentFilter("android.intent.action.SCREEN_ON"));
        if (this.nSr) {
            io(false);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.gUi) {
            this.grJ += System.currentTimeMillis() - this.startTime;
        }
        android.support.v4.content.d.O(this).unregisterReceiver(this.nSG);
        android.support.v4.content.d.O(this).unregisterReceiver(this.nSH);
        if (this.nSP != null) {
            this.nSP.bzW();
        }
    }

    public void onSwipeBack() {
        this.nSo.cXB = 2;
        g gVar = this.nSo;
        gVar.nIK++;
        super.onSwipeBack();
    }

    final void bCE() {
        if (bi.oW(this.nSf) && !bi.oW(this.nyl)) {
            this.nSf = String.format("<ADInfo><adCanvasExt>%s</adCanvasExt></ADInfo>", new Object[]{this.nyl});
        }
        if (!bi.oW(this.nSf)) {
            String aG;
            String str = "ADInfo";
            Map z = f.z(this.nSf, str);
            this.ntU = bi.aG((String) z.get("." + str + ".uxInfo"), "");
            this.nSo.ntU = this.ntU;
            this.nyk = bi.aG((String) z.get("." + str + ".session_data.aid"), "");
            this.fxE = bi.aG((String) z.get("." + str + ".session_data.trace_id"), "");
            Map hashMap = new HashMap();
            str = "." + str + ".adCanvasExt.adCardItemList.cardItem";
            int i = 0;
            while (true) {
                String str2;
                if (i > 0) {
                    str2 = str + i;
                } else {
                    str2 = str;
                }
                if (!z.containsKey(str2 + ".cardTpId")) {
                    break;
                }
                String aG2 = bi.aG((String) z.get(str2 + ".cardTpId"), "");
                aG = bi.aG((String) z.get(str2 + ".cardExt"), "");
                if (!(bi.oW(aG2) || bi.oW(aG))) {
                    hashMap.put(aG2, aG);
                }
                i++;
            }
            this.nSn = hashMap;
            aG = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.o(this.nSd, hashMap);
            if (!bi.oW(aG)) {
                this.nSd = aG;
            }
            if (!bi.oW(this.nyk)) {
                if (this.nSd.contains("<originAid>")) {
                    this.nSd = this.nSd.replaceFirst("<originAid>[\\s\\S]*</originAid>", "<originAid>" + this.nyk + "</originAid>");
                } else {
                    this.nSd = this.nSd.replace("<" + this.nSe + ">", "<" + this.nSe + "><originAid>" + this.nyk + "</originAid>");
                }
            }
            if (!bi.oW(this.fxE)) {
                if (this.nSd.contains("<originTraceId>")) {
                    this.nSd = this.nSd.replaceFirst("<originTraceId>[\\s\\S]*</originTraceId>", "<originTraceId>" + this.fxE + "</originTraceId>");
                } else {
                    this.nSd = this.nSd.replace("<" + this.nSe + ">", "<" + this.nSe + "><originTraceId>" + this.fxE + "</originTraceId>");
                }
            }
            if (!bi.oW(this.ntU)) {
                if (this.nSd.contains("<originUxInfo>")) {
                    this.nSd = this.nSd.replaceFirst("<originUxInfo>[\\s\\S]*</originUxInfo>", "<originUxInfo>" + this.ntU + "</originUxInfo>");
                } else {
                    this.nSd = this.nSd.replace("<" + this.nSe + ">", "<" + this.nSe + "><originUxInfo>" + this.ntU + "</originUxInfo>");
                }
            }
        }
    }

    private void bCF() {
        if (this.nRW != null) {
            Iterator it = this.nRW.iterator();
            while (it.hasNext()) {
                List<s> list = ((c) it.next()).nIi;
                if (list != null) {
                    for (s sVar : list) {
                        sVar.wL(this.nBk == 0 ? this.source : this.nBk);
                        sVar.ii(nSm);
                        sVar.MV(this.ntU);
                        sVar.MW(this.uin);
                        sVar.wM(this.nBm);
                    }
                }
            }
        }
    }

    private List<i> bCG() {
        List<i> arrayList = new ArrayList();
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.nSw.getAdapter()).nB) {
            arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bAu());
        }
        return arrayList;
    }

    private List<i> bCH() {
        List<i> arrayList = new ArrayList();
        arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.nSL.get(Integer.valueOf(((c) this.nRW.getFirst()).id))).bAu());
        return arrayList;
    }

    @TargetApi(16)
    protected final void initView() {
        LayoutParams layoutParams;
        boolean z = false;
        super.initView();
        this.nHH = findViewById(com.tencent.mm.plugin.sns.i.f.root);
        this.nSw = (AdlandingDummyViewPager) findViewById(com.tencent.mm.plugin.sns.i.f.vertical_viewpager);
        this.nSA = findViewById(com.tencent.mm.plugin.sns.i.f.menu_container);
        this.nSw.nHa.add(this.nSJ);
        if (this.nBm == 2 && !bCL()) {
            layoutParams = (LayoutParams) this.nSw.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, aq.gs(this));
            this.nSw.setLayoutParams(layoutParams);
        }
        if (ak.gw(this.mController.tml)) {
            layoutParams = (LayoutParams) this.nSA.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + ak.gv(this.mController.tml), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.nSA.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.nSw.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + ak.gv(this.mController.tml), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.nSw.setLayoutParams(layoutParams);
        }
        this.jdG = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.gallery_bg);
        this.nRY = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.sns_ad_native_landing_pages_close_mask_img);
        this.hml = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.sns_ad_native_landing_pages_close_img);
        this.hml.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SnsAdNativeLandingPagesUI.this.mController.tmG == 1) {
                    SnsAdNativeLandingPagesUI.this.YC();
                }
                SnsAdNativeLandingPagesUI.this.ayH();
            }
        });
        this.nRX = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.sns_ad_native_landing_pages_more_img);
        int i = com.tencent.mm.plugin.sns.i.c.white;
        if (!bCL()) {
            int color = getResources().getColor(com.tencent.mm.plugin.sns.i.c.black);
            if (this.nRW == null || this.nRW.size() <= 0 || bi.oW(((c) this.nRW.getFirst()).fpc)) {
                i = color;
            } else {
                i = Color.parseColor(((c) this.nRW.getFirst()).fpc);
            }
            this.nRY.setBackgroundColor(i);
            i = com.tencent.mm.plugin.sns.i.c.black;
        }
        Drawable drawable = this.hml.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.g(this, i));
            this.hml.setImageDrawable(drawable);
        }
        drawable = this.nRX.getDrawable();
        if (drawable != null) {
            android.support.v4.b.a.a.a(drawable, android.support.v4.content.a.g(this, i));
            this.nRX.setImageDrawable(drawable);
        }
        this.nRZ = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.sns_ad_native_landing_pages_right_bar_title);
        if (bCM() && !bCN() && this.nBm == 2) {
            this.nRX.setVisibility(8);
            this.nRZ.setVisibility(0);
            this.nRZ.setText(this.nSg);
            this.nRZ.setOnClickListener(new 17(this));
        } else if (bCJ()) {
            this.nRX.setOnClickListener(new 18(this));
        } else {
            this.nRX.setVisibility(8);
        }
        this.nSj = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.sns_native_landing_first_screen_next_img);
        if (this.nRW == null || this.nRW.size() == 0) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPages is null");
            return;
        }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        bCF();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.nSw.getAdapter();
        if (cVar2 == null) {
            cVar2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(getSupportFragmentManager(), new ArrayList());
            this.nSw.setAdapter(cVar2);
            cVar = cVar2;
        } else {
            cVar = cVar2;
        }
        int i2 = 0;
        while (i2 < this.nRW.size()) {
            c cVar3 = (c) this.nRW.get(i2);
            if (cVar3.nBi) {
                x.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load %d", new Object[]{Integer.valueOf(i2)});
                Fragment fragment = (Fragment) this.nSL.get(Integer.valueOf(cVar3.id));
                if (fragment == null) {
                    AdlandingDummyViewPager adlandingDummyViewPager = this.nSw;
                    z zVar = this.nHm;
                    if (i2 == this.nRW.size() - 1) {
                        z = true;
                    }
                    fragment = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar3, adlandingDummyViewPager, zVar, z, i2 == 0 ? this.nSI : null, this.nSc, bCK());
                    this.nSL.put(Integer.valueOf(cVar3.id), fragment);
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).a(cVar3);
                }
                if (fragment != null) {
                    cVar.a(fragment, i2);
                }
                cVar.notifyDataSetChanged();
                this.nSw.setOffscreenPageLimit(this.nRW.size());
                this.nSb = new b(this.mController.tml);
                this.nHH.addOnLayoutChangeListener(new 2(this));
            }
            i2++;
        }
        cVar.notifyDataSetChanged();
        this.nSw.setOffscreenPageLimit(this.nRW.size());
        this.nSb = new b(this.mController.tml);
        this.nHH.addOnLayoutChangeListener(new 2(this));
    }

    private boolean isFullScreen() {
        boolean z;
        if (this.nRW != null) {
            Iterator it = this.nRW.iterator();
            z = false;
            while (it.hasNext()) {
                Iterator it2 = ((c) it.next()).nIi.iterator();
                while (it2.hasNext()) {
                    if (((s) it2.next()).type == 82) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    private void bCI() {
        if (bCL()) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.I(this);
            return;
        }
        int i;
        if (VERSION.SDK_INT >= 21) {
            int color = getResources().getColor(com.tencent.mm.plugin.sns.i.c.white);
            if (this.nRW == null || this.nRW.size() <= 0 || bi.oW(((c) this.nRW.getFirst()).fpc)) {
                i = color;
            } else {
                i = Color.parseColor(((c) this.nRW.getFirst()).fpc);
            }
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(i);
        }
        i = getWindow().getDecorView().getSystemUiVisibility();
        if (VERSION.SDK_INT >= 16) {
            i &= -1543;
        }
        if (VERSION.SDK_INT >= 23) {
            i |= 8192;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.sns_ad_native_landing_pages_ui;
    }

    private boolean bCJ() {
        if (this.nSx == 0 || (this.nSx & 4) == 0 || (this.nSx & 2) == 0) {
            return true;
        }
        if ((bCN() && this.nBm == 2) || (this.nSx & 1) == 0) {
            return true;
        }
        return false;
    }

    private boolean bCK() {
        return (this.nSx & 8) == 0;
    }

    private boolean bCL() {
        return this.nSy == 0;
    }

    private boolean bCM() {
        return (bi.oW(this.nSg) || bi.oW(this.nSh)) ? false : true;
    }

    private boolean bCN() {
        return (this.nSx & 16) == 0;
    }

    private void bCO() {
        Iterator it;
        List<i> bCH = bCH();
        LinkedList linkedList = new LinkedList();
        for (i view : bCH) {
            linkedList.add((View) view.getView().getParent());
        }
        this.nSD = null;
        if (this.nSB != null) {
            this.nSB.clear();
        }
        if (!linkedList.isEmpty()) {
            this.nSD = (View) linkedList.removeFirst();
            if (this.nSB == null) {
                this.nSB = new LinkedList();
            }
            this.nSB.clear();
            int height = this.nSD.getHeight();
            it = linkedList.iterator();
            int i = height;
            while (it.hasNext()) {
                View view2 = (View) it.next();
                i += view2.getHeight();
                this.nSB.add(view2);
                if (i >= this.hmW) {
                    return;
                }
            }
        }
    }

    public final void ayH() {
        bCD();
        xP();
        this.nSp = true;
        if (this.nSc) {
            try {
                ((i) bCH().get(0)).bzV();
            } catch (Exception e) {
            }
            this.nSw.k(0, false);
            RecyclerView bAt = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.nSL.get(Integer.valueOf(((c) this.nRW.getFirst()).id))).bAt();
            if (bAt != null) {
                ((LinearLayoutManager) bAt.getLayoutManager()).Q(0, 0);
            }
            bCD();
            if (this.nSD != null) {
                this.nSD.postDelayed(new 5(this), 10);
                return;
            }
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        ayH();
    }

    private a bCP() {
        com.tencent.mm.plugin.sns.storage.b bVar = new com.tencent.mm.plugin.sns.storage.b(this.nSd);
        if (bVar.bzt()) {
            int adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(bVar.nzy.nzF, this.ntU, this.uin);
            if (adVoteIndex > 0 && adVoteIndex <= bVar.nzy.nzG.size()) {
                com.tencent.mm.plugin.sns.storage.b.f fVar = (com.tencent.mm.plugin.sns.storage.b.f) bVar.nzy.nzG.get(adVoteIndex - 1);
                a aVar = new a(this, (byte) 0);
                if (bi.oW(fVar.ixz)) {
                    aVar.ixz = this.ixz;
                } else {
                    aVar.ixz = fVar.ixz;
                }
                if (bi.oW(fVar.nzH)) {
                    aVar.nzH = this.nzH;
                } else {
                    aVar.nzH = fVar.nzH;
                }
                if (bi.oW(fVar.nzI)) {
                    aVar.nzI = this.nSk;
                } else {
                    aVar.nzI = fVar.nzI;
                }
                return aVar;
            }
        }
        return null;
    }

    private String NV(String str) {
        String aG = bi.aG((String) this.values.get("." + this.nSe + ".adCanvasInfo.shareThumbUrl"), "");
        if (bi.oW(aG)) {
            return str;
        }
        return aG;
    }

    private String bCQ() {
        bqw bqw = new bqw();
        bqw.soW = new bqx();
        bqw.soW.spa = this.nSo.ntU;
        bqw.soW.soZ = this.nSo.bSZ;
        bqw.soW.egL = this.egL;
        try {
            return Base64.encodeToString(bqw.toByteArray(), 2);
        } catch (Exception e) {
            return "";
        }
    }

    private String bCR() {
        return this.nSd.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, this.mController.tml.getString(com.tencent.mm.plugin.sns.i.j.app_shared));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((v) com.tencent.mm.kernel.g.l(v.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), this, this.jKu);
            }
        } else if (i == com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.nFJ) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (i iVar : bCG()) {
                    if (iVar.bzU().equals(stringExtra)) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x xVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x) iVar;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        xVar.njo = intExtra + xVar.njo;
                        xVar.njp += intExtra2;
                        xVar.njq += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.nSw != null) {
            this.nSw.postDelayed(new Runnable() {
                public final void run() {
                    if (SnsAdNativeLandingPagesUI.this.mController.tmG != 1) {
                        SnsAdNativeLandingPagesUI.this.bCI();
                    } else {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.J(SnsAdNativeLandingPagesUI.this);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) SnsAdNativeLandingPagesUI.this.nSw.getAdapter()).nB) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
                        int i = SnsAdNativeLandingPagesUI.this.mController.tmG;
                        bVar.bAq();
                    }
                }
            }, 500);
        }
    }

    public final void io(boolean z) {
        if (z && this.nBm == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.nSs, this.nSt, this.nSu, this.nSK);
        }
        if (this.nBm == 2 && !bi.oW(this.nSv)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.nSv, this.nSK);
        }
        this.nSr = true;
    }

    public final void a(s sVar, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (this.nSP == null || z3) {
            final boolean z4 = z3;
            AnonymousClass10 anonymousClass10 = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a() {
                public final void at(Object obj) {
                }

                public final void e(int i, int i2, Object obj) {
                    SnsAdNativeLandingPagesUI.this.io(false);
                    if (z4) {
                        if (SnsAdNativeLandingPagesUI.this.nSP != null) {
                            SnsAdNativeLandingPagesUI.this.nSP.bzW();
                        }
                        if (SnsAdNativeLandingPagesUI.this.nSQ != null) {
                            SnsAdNativeLandingPagesUI.this.nSQ.dismiss();
                            SnsAdNativeLandingPagesUI.this.nSQ = null;
                        }
                    }
                }
            };
            if (!z3) {
                int i;
                ActionBarActivity actionBarActivity = this.mController.tml;
                ViewGroup linearLayout = new LinearLayout(this.mController.tml);
                y.gq(this.mController.tml);
                if (bi.oW(sVar.nBf)) {
                    i = -1;
                } else {
                    i = Color.parseColor(sVar.nBf);
                }
                i a = am.a(actionBarActivity, sVar, linearLayout, i);
                this.nSP = new j(this.mController.tml, a, str, str2, str3, z, z2);
                View view = a.getView();
                this.nSP.nDD = new 11(this, view);
                j jVar = this.nSP;
                if (!(jVar.hyK == null || jVar.nDy == null)) {
                    jVar.nDy.getWindow().setFlags(8, 8);
                    jVar.nDy.getWindow().addFlags(131200);
                    if (jVar.nDD != null) {
                        jVar.nDy.setOnDismissListener(new 4(jVar));
                        jVar.nDy.setOnCancelListener(new 5(jVar));
                    }
                    jVar.nDy.setContentView(jVar.hyK);
                    BottomSheetBehavior.h((View) jVar.hyK.getParent()).q(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.ee(jVar.mContext)[1]);
                    jVar.nDy.show();
                }
            }
            if (!bi.oW(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, anonymousClass10);
                if (z3) {
                    this.nSQ = com.tencent.mm.ui.base.h.a(this, getString(com.tencent.mm.plugin.sns.i.j.sns_loading), false, null);
                    return;
                }
                return;
            }
            return;
        }
        x.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.nSP.bzW();
        if (this.nSQ != null) {
            this.nSQ.dismiss();
            this.nSQ = null;
        }
    }

    public final void u(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.nBk == 0 ? this.source : this.nBk);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bi.oW(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !bi.oW(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
    }
}
