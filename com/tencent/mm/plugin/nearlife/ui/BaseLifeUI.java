package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseLifeUI extends MMActivity implements e {
    boolean cXo = false;
    boolean dJO = false;
    protected boolean dSc = true;
    private o eMS;
    boolean eMT = false;
    protected String fuu = "";
    private int kCL = 1;
    public int kIW = -1;
    MMLoadMoreListView kIo;
    protected String kJG = "";
    private String lCU = "";
    private boolean lCb = false;
    protected int lDA = 0;
    protected boolean lDB = false;
    protected int lDC = -1;
    protected boolean lDD = false;
    private OnClickListener lDE = new 1(this);
    private OnClickListener lDF = new 2(this);
    private a lDG = new 7(this);
    private View lDh;
    private NearLifeErrorContent lDi;
    private a lDj;
    private a lDk;
    private View lDl;
    private TextView lDm;
    private TextView lDn;
    private c lDo = c.OB();
    private com.tencent.mm.plugin.nearlife.b.c lDp;
    private int lDq;
    private List<aqr> lDr;
    protected aqr lDs = null;
    protected float lDt = 0.0f;
    protected float lDu = 0.0f;
    protected int lDv = 0;
    protected float lDw = 0.0f;
    protected long lDx = -1;
    protected long lDy = -1;
    protected long lDz = -1;
    int sceneType = 0;

    public abstract a bjb();

    public abstract a bjc();

    public abstract void p(double d, double d2);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.lDq != -1 || baseLifeUI.lDp != null) {
            x.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.gR(true)) {
            baseLifeUI.kIo.crE();
        }
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (!bi.oW(str)) {
            if (baseLifeUI.lDp == null || !str.equals(baseLifeUI.lDp.lCT)) {
                baseLifeUI.tV(8);
                if (baseLifeUI.lDp != null) {
                    au.DF().c(baseLifeUI.lDp);
                }
                if (baseLifeUI.lDs != null) {
                    baseLifeUI.lDk.biY();
                    baseLifeUI.lDk.II(str);
                    baseLifeUI.gR(false);
                    baseLifeUI.kIo.crE();
                }
            }
        }
    }

    static /* synthetic */ boolean f(float f, float f2, float f3, float f4) {
        return q.c((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }

    public void bjd() {
        x.d("MicroMsg.BaseLifeUI", "init header");
        this.lDl = View.inflate(this, R.i.create_poi_tips_footer, null);
        this.lDm = (TextView) this.lDl.findViewById(R.h.tv_create_poi_tips);
        this.lDn = (TextView) this.lDl.findViewById(R.h.tv_create_not_found_poi_tips);
        this.lDl.setOnClickListener(this.lDF);
        this.lDh = View.inflate(this, R.i.power_by_footer, null);
        this.kIo.addFooterView(this.lDh);
        this.lDh.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kIW = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.nearlife.b.c.clear();
        au.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_UNKNOWN_HOST, this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.kJG = getIntent().getStringExtra("request_id");
        this.lDr = new ArrayList();
        initView();
        this.kIo.crE();
        if (this.lDo != null) {
            this.lDo.b(this.lDG);
        }
        this.dJO = false;
    }

    public final void initView() {
        this.kIo = (MMLoadMoreListView) findViewById(R.h.near_life_list);
        this.kIo.setFooterTips(getString(R.l.near_life_searching));
        this.lDi = (NearLifeErrorContent) findViewById(R.h.near_life_errcontent);
        bjd();
        this.lDj = bjb();
        this.lDk = bjc();
        this.kIo.setAdapter(this.lDj);
        this.lDi.setListView(this.kIo);
        this.lDj.notifyDataSetChanged();
        setBackBtn(new 3(this));
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(BaseLifeUI.this.kIo);
            }
        };
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new b() {
            public final void WY() {
                x.d("MicroMsg.BaseLifeUI", "click clear");
                if (BaseLifeUI.this.lDp != null) {
                    au.DF().c(BaseLifeUI.this.lDp);
                    BaseLifeUI.this.lDp = null;
                }
                BaseLifeUI.this.lDk.biY();
                BaseLifeUI.this.tV(8);
            }

            public final void WZ() {
            }

            public final void pk(String str) {
                x.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[]{str});
                if (bi.oW(str)) {
                    WY();
                } else {
                    BaseLifeUI.a(BaseLifeUI.this, str);
                }
            }

            public final void WW() {
                x.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                BaseLifeUI.this.eMT = false;
                BaseLifeUI.this.kIo.setAdapter(BaseLifeUI.this.lDj);
                BaseLifeUI.this.lDj.notifyDataSetChanged();
                BaseLifeUI.this.lDi.tW(BaseLifeUI.this.lDj.lDg);
                if (!(BaseLifeUI.this.lDj.bja() || BaseLifeUI.this.lDh == null)) {
                    BaseLifeUI.this.lDh.setVisibility(0);
                }
                BaseLifeUI.this.kIo.setOnTouchListener(null);
                BaseLifeUI.this.tV(8);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.lDj);
            }

            public final void WX() {
                x.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                BaseLifeUI.this.lDB = true;
                BaseLifeUI.this.eMS.setHint(BaseLifeUI.this.getString(R.l.near_life_search_hint));
                BaseLifeUI.this.eMT = true;
                BaseLifeUI.this.lDk.biY();
                BaseLifeUI.this.kIo.setAdapter(BaseLifeUI.this.lDk);
                BaseLifeUI.this.lDk.notifyDataSetChanged();
                BaseLifeUI.this.kIo.crD();
                BaseLifeUI.this.lDi.tW(BaseLifeUI.this.lDk.lDg);
                if (BaseLifeUI.this.lDh != null) {
                    BaseLifeUI.this.lDh.setVisibility(8);
                }
                BaseLifeUI.this.kIo.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        BaseLifeUI.this.YC();
                        return false;
                    }
                });
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.lDk);
            }

            public final boolean pj(String str) {
                x.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(BaseLifeUI.this, str);
                return false;
            }
        };
        this.kIo.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            public final void aAU() {
                BaseLifeUI.a(BaseLifeUI.this);
            }
        });
        this.kIo.crC();
    }

    protected void onResume() {
        super.onResume();
        this.lDj.notifyDataSetChanged();
        this.lDo.a(this.lDG, true);
    }

    protected void onDestroy() {
        au.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_UNKNOWN_HOST, this);
        super.onDestroy();
        if (this.lDo != null) {
            this.lDo.c(this.lDG);
        }
    }

    protected void onPause() {
        super.onPause();
        this.lDo.c(this.lDG);
    }

    protected int getLayoutId() {
        return R.i.near_life_ui;
    }

    private boolean gR(boolean z) {
        while (this.lDp == null) {
            if (this.lDr.size() - 1 <= this.lDq) {
                this.lDq = -1;
                x.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.lDq++;
            aqr aqr = (aqr) this.lDr.get(this.lDq);
            if (this.lDq == 0) {
                this.lDA++;
            }
            if (this.eMT) {
                b = this.lDk.b(new LatLongData(aqr.rms, aqr.rmr));
                continue;
            } else {
                b = this.lDj.b(new LatLongData(aqr.rms, aqr.rmr));
                continue;
            }
            if (b > 0) {
                bhy a;
                if (this.eMT) {
                    a = this.lDk.a(new LatLongData(aqr.rms, aqr.rmr));
                } else {
                    a = this.lDj.a(new LatLongData(aqr.rms, aqr.rmr));
                }
                int i = this.eMT ? 1 : 0;
                if (com.tencent.mm.plugin.nearlife.b.c.tS(i)) {
                    if (-1 == this.lDx) {
                        this.lDx = System.currentTimeMillis();
                    }
                    this.lDp = new com.tencent.mm.plugin.nearlife.b.c(i, this.sceneType, aqr.rmr, aqr.rms, aqr.ryV, aqr.ryY, aqr.ryW, aqr.ryX, a, this.eMT ? this.lDk.biZ() : "", this.kIW, z);
                    au.DF().a(this.lDp, 0);
                    x.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", new Object[]{Integer.valueOf(this.lDq), Float.valueOf(aqr.rms), Float.valueOf(aqr.rmr)});
                    return true;
                }
                this.lDq = -1;
                return false;
            }
        }
        x.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_UNKNOWN_HOST) {
            this.kIo.crD();
            com.tencent.mm.plugin.nearlife.b.c cVar = (com.tencent.mm.plugin.nearlife.b.c) lVar;
            if (!bi.oW(cVar.lCU)) {
                this.lCU = cVar.lCU;
                LogoImageView logoImageView = (LogoImageView) this.lDh.findViewById(R.h.pwoer_by_logo_iv);
                String str2 = this.lCU;
                au.HU();
                logoImageView.imagePath = com.tencent.mm.model.c.Gc();
                logoImageView.url = str2;
                logoImageView.kGn = 0;
                logoImageView.kGo = 0;
                Bitmap decodeFile;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    decodeFile = BitmapFactory.decodeFile(logoImageView.imagePath + g.u(str2.getBytes()));
                    if (decodeFile != null) {
                        if (logoImageView.kGn > 0 && logoImageView.kGo > 0) {
                            decodeFile = com.tencent.mm.sdk.platformtools.c.a(decodeFile, logoImageView.kGn, logoImageView.kGo, true, false);
                        }
                        logoImageView.setImageBitmap(decodeFile);
                    } else {
                        com.tencent.mm.sdk.f.e.post(new LogoImageView.a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (com.tencent.mm.a.e.cn(str2)) {
                    decodeFile = (logoImageView.kGn <= 0 || logoImageView.kGo <= 0) ? com.tencent.mm.sdk.platformtools.c.Wb(str2) : com.tencent.mm.sdk.platformtools.c.e(str2, logoImageView.kGn, logoImageView.kGo, true);
                    if (decodeFile == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(decodeFile);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.fuu = cVar.fuu;
            this.kCL = cVar.kCL;
            com.tencent.mm.plugin.nearlife.b.c.tT(((com.tencent.mm.plugin.nearlife.b.c) lVar).bNI);
            if (this.lDp == null) {
                x.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            x.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", new Object[]{Integer.valueOf(this.lDq), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1)});
            boolean z = i2 == 0 || i2 == 101;
            a aVar;
            if (i == 0 || z) {
                if (-1 == this.lDy) {
                    this.lDy = System.currentTimeMillis();
                }
                this.lDz = System.currentTimeMillis();
                List list = cVar.lCV;
                aqr aqr = (aqr) this.lDr.get(this.lDq);
                LatLongData latLongData = new LatLongData(aqr.rms, aqr.rmr);
                if (this.eMT && !this.lDp.lCW) {
                    this.lDk.biY();
                }
                if (this.eMT) {
                    this.lDk.a(latLongData, cVar.biX(), cVar.biW());
                } else {
                    this.lDj.a(latLongData, cVar.biX(), cVar.biW());
                }
                if (list == null || list.size() == 0) {
                    aVar = this.eMT ? this.lDk : this.lDj;
                    if (this.lDr.size() - 1 == this.lDq) {
                        if (aVar.getCount() == 0) {
                            this.lDi.tW(aVar.lDg);
                        }
                        this.kIo.crD();
                        if (!(aVar.bja() || i2 == 101)) {
                            bje();
                        }
                    }
                } else {
                    aVar = this.eMT ? this.lDk : this.lDj;
                    z = this.lDp.lCW;
                    this.kIo.setVisibility(0);
                    aVar.lDg = 0;
                    this.lDi.tW(this.lDk.lDg);
                    aVar.a(latLongData, list);
                    aVar.notifyDataSetChanged();
                    if (this.lDr.size() - 1 == this.lDq && !aVar.bja()) {
                        this.kIo.crD();
                        bje();
                    }
                }
                if (!(this.lDj.bja() || this.lDh == null || this.eMT)) {
                    this.lDh.setVisibility(0);
                }
                if (this.lDh != null && !this.eMT) {
                    this.lDh.setVisibility(0);
                } else if (this.lDh != null) {
                    this.lDh.setVisibility(8);
                }
            } else {
                x.d("MicroMsg.BaseLifeUI", "error");
                if (this.eMT) {
                    aVar = this.lDk;
                } else {
                    aVar = this.lDj;
                }
                if (this.lDr.size() - 1 == this.lDq && aVar.getCount() == 0) {
                    aVar.lDg = 1;
                    this.lDi.tW(aVar.lDg);
                }
            }
            this.lDp = null;
            gR(false);
        }
    }

    private void bje() {
        if (this.eMT) {
            int i;
            try {
                x.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", new Object[]{Integer.valueOf(Integer.valueOf(com.tencent.mm.k.g.AT().getValue("POICreateForbiden")).intValue())});
                if (Integer.valueOf(com.tencent.mm.k.g.AT().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            a aVar = this.lDk;
            String trim = this.lDk.biZ().trim();
            Iterator it = aVar.lCY.iterator();
            while (it.hasNext()) {
                if (trim.equals(((com.tencent.mm.plugin.nearlife.b.a) it.next()).bHD.trim())) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                this.lDm.setText(String.format(getResources().getString(R.l.nl_create_poi_tips), new Object[]{this.lDk.biZ()}));
                tV(0);
                return;
            }
            tV(8);
            return;
        }
        x.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void a(int i, boolean z, String str) {
        int i2;
        String str2;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        String str4 = "";
        if (i >= 0) {
            i2 = z ? 3 : 1;
            if (this.lDD) {
                h hVar = h.mEJ;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                hVar.h(11139, objArr);
            }
            if (z) {
                str3 = this.lDk.tU(i).kJF;
                if (this.lDk.getCount() > 0) {
                    str2 = this.lDk.tU(1).kJG;
                }
                str2 = str4;
            } else {
                str3 = this.lDj.tU(i).kJF;
                if (this.lDj.getCount() > 0) {
                    str2 = this.lDj.tU(1).kJG;
                }
                str2 = str4;
            }
            if (bi.oW(str2)) {
                str2 = this.kJG;
            }
        } else {
            i2 = this.lDB ? 4 : 2;
            str2 = str4;
        }
        if (this.lDs == null) {
            str4 = "null/null";
        } else {
            str4 = String.format("%f/%f", new Object[]{Float.valueOf(this.lDs.rms), Float.valueOf(this.lDs.rmr)});
        }
        x.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", new Object[]{Integer.valueOf(i + 1), str, Integer.valueOf(i), str3, str2});
        h.mEJ.h(11135, new Object[]{Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.lDx), Long.valueOf(this.lDz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.lDy), Integer.valueOf(this.lDA), str4, str, Integer.valueOf(this.kIW), str3, com.tencent.mm.compatible.e.q.zy(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str2});
    }

    private void tV(int i) {
        this.kIo.removeFooterView(this.lDh);
        this.kIo.removeFooterView(this.lDl);
        MMLoadMoreListView mMLoadMoreListView = this.kIo;
        mMLoadMoreListView.removeFooterView(mMLoadMoreListView.iln);
        this.lDl.setVisibility(i);
        this.lDm.setVisibility(i);
        this.lDn.setVisibility(i);
        if (i == 0) {
            this.kIo.addFooterView(this.lDl);
            return;
        }
        mMLoadMoreListView = this.kIo;
        if (mMLoadMoreListView.iln == null) {
            mMLoadMoreListView.crB();
        }
        try {
            mMLoadMoreListView.removeFooterView(mMLoadMoreListView.iln);
            mMLoadMoreListView.addFooterView(mMLoadMoreListView.iln);
        } catch (Exception e) {
        }
        this.kIo.addFooterView(this.lDh);
    }
}
