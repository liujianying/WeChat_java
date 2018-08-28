package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.h$a;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.y;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class a extends x implements OnScrollListener, OnItemClickListener, e, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.h.a, b, h$a, com.tencent.mm.sdk.e.j.a, c, d, MMPullDownView.e {
    ListView CU;
    private ProgressDialog eEX;
    private View gQd;
    com.tencent.mm.plugin.emoji.a.a.a ihz;
    private com.tencent.mm.sdk.b.c ikA = new 2(this);
    private g ikB;
    private boolean ikC = false;
    private LinkedList<th> ikD = new LinkedList();
    private LinkedList<tj> ikE = new LinkedList();
    EmojiStoreVpHeader ikc;
    private MMPullDownView ikf;
    private TextView ikg;
    private int iki = -1;
    private boolean ikj;
    private View ikk;
    private byte[] ikl;
    private final int ikp = 131074;
    private final int ikq = 131075;
    private final int ikr = 131076;
    private final String iks = "product_id";
    private final String ikt = "progress";
    private final String iku = "status";
    private n ikv;
    private int ikw;
    private f ikx;
    private h iky;
    private final int ioR = 131077;
    public EmojiStoreV2HotBarView ioS;
    private boolean ioT = false;
    private boolean ioU = false;
    private boolean ioV = false;
    private ag ioW = new 1(this);
    private OnMenuItemClickListener ioX = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            a.this.thisActivity().finish();
            return false;
        }
    };
    private ActionBar mActionBar;
    private com.tencent.mm.ui.b mActionBarHelper;

    public abstract com.tencent.mm.plugin.emoji.a.a.a aFf();

    public abstract int aFm();

    public abstract boolean aGk();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((ActionBarActivity) thisActivity()).getSupportActionBar();
        View inflate = y.gq(getContext()).inflate(R.i.actionbar_custom_area, null);
        this.mActionBarHelper = new com.tencent.mm.ui.b(inflate);
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.da();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.cZ();
        this.mActionBar.db();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        com.tencent.mm.ui.b bVar = this.mActionBarHelper;
        bVar.eCm.setText(R.l.emoji_store);
        if (com.tencent.mm.bp.a.fi(bVar.eCm.getContext())) {
            bVar.eCm.setTextSize(0, com.tencent.mm.bp.a.fg(bVar.eCm.getContext()) * ((float) com.tencent.mm.bp.a.ae(bVar.eCm.getContext(), com.tencent.mm.w.a.e.ActionBarTextSize)));
        }
        this.mActionBarHelper.b(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.isScreenEnable() && a.this.ioX != null) {
                    a.this.ioX.onMenuItemClick(null);
                }
            }
        });
        ActionBar actionBar = this.mActionBar;
        boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (actionBar.getCustomView() != null) {
            ImageView imageView = (ImageView) actionBar.getCustomView().findViewById(R.h.arrow_area_btn);
            if (imageView != null && z) {
                imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
            }
            TextView textView = (TextView) actionBar.getCustomView().findViewById(R.h.title_area);
            if (textView != null && z) {
                textView.setTextColor(getActivity().getResources().getColor(R.e.white_text_color));
            }
            textView = (TextView) actionBar.getCustomView().findViewById(R.h.sub_title_area);
            if (textView != null && z) {
                textView.setTextColor(getActivity().getResources().getColor(R.e.white_text_color));
            }
        }
        showOptionMenu(true);
        addIconOptionMenu(0, R.k.actionbar_setting_icon, new 5(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
        i.aEA().igy.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.ioV = true;
        this.ihz = aFf();
        this.ihz.ieo = this;
        this.gQd = findViewById(R.h.empty);
        this.ikg = (TextView) this.gQd.findViewById(R.h.empty_content);
        this.ikk = getLayoutInflater().inflate(R.i.emoji_store_load_more, null);
        this.ikk.setVisibility(8);
        this.ikc = new EmojiStoreVpHeader(getContext());
        this.CU = (ListView) findViewById(16908298);
        this.CU.addHeaderView(this.ikc);
        if (!aGk()) {
            this.ioS = new EmojiStoreV2HotBarView(getContext());
            this.ioS.setDesignerEmojiViewVisibility(8);
            this.ioS.setDesignerCatalogViewPadding(false);
            this.CU.addHeaderView(this.ioS);
        }
        this.CU.addFooterView(this.ikk);
        this.CU.setAdapter(this.ihz);
        if (aGk()) {
            this.CU.setOnItemClickListener(this);
        } else {
            ((com.tencent.mm.plugin.emoji.a.h) this.ihz).idX = this;
        }
        this.CU.setOnScrollListener(this);
        this.CU.setLongClickable(false);
        this.CU.setOnTouchListener(new 6(this));
        this.ihz.iem = this.CU;
        this.ikf = (MMPullDownView) findViewById(R.h.load_more_pull_view);
        if (this.ikf != null) {
            this.ikf.setTopViewVisible(false);
            this.ikf.setAtTopCallBack(this);
            this.ikf.setOnBottomLoadDataListener(this);
            this.ikf.setAtBottomCallBack(this);
            this.ikf.setBottomViewVisible(false);
            this.ikf.setIsBottomShowAll(false);
            this.ikf.setIsReturnSuperDispatchWhenCancel(true);
        }
        if (this.ioT) {
            aGh();
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        au.DF().a(411, this);
        au.DF().a(423, this);
        if (this.ioT) {
            if (this.ioW != null) {
                this.ioW.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.ihz == null || this.ihz.ien == null)) {
                this.ihz.ien.aDF();
                this.ihz.aoV();
            }
            au.HU();
            if (((Boolean) com.tencent.mm.model.c.DT().get(208900, Boolean.valueOf(false))).booleanValue()) {
                aEs();
                au.HU();
                com.tencent.mm.model.c.DT().set(208900, Boolean.valueOf(false));
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[]{Boolean.valueOf(z)});
        super.setUserVisibleHint(z);
        this.ioT = z;
        if (!this.ioU && this.ioV) {
            aGh();
        }
    }

    public void onPause() {
        super.onPause();
        au.DF().b(411, this);
        au.DF().b(423, this);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.ikc != null) {
            this.ikc.aGd();
        }
        if (this.ioW != null) {
            this.ioW.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.ihz != null) {
            this.ihz.clear();
            this.ihz = null;
        }
        if (this.ikc != null) {
            this.ikc.aGd();
            this.ikc.clear();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.ikA);
        i.aEA().igy.d(this);
    }

    public void onDetach() {
        super.onDetach();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void aGh() {
        int i = 0;
        this.ioU = true;
        this.iky = new h();
        this.iky.gKE = thisActivity();
        this.iky.ihB = this;
        this.iky.ihz = this.ihz;
        if (aGk()) {
            this.iky.ihC = 1;
        } else {
            this.iky.ihC = 2;
        }
        this.iky.ihF = this;
        this.ikw = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        adh Dw = i.aEA().igA.Dw(aFm());
        f a = n.a(Dw);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aFm());
        objArr[1] = Integer.valueOf(Dw == null ? 0 : Dw.rHB);
        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
        if (a != null && a.ihq.size() > 0) {
            int size;
            int i2;
            int i3;
            this.ikC = true;
            this.gQd.setVisibility(8);
            this.ikf.setVisibility(0);
            a(this.iki, a);
            if (Dw != null) {
                size = Dw.rHN == null ? 0 : Dw.rHN.size();
                i2 = Dw.rHK;
                i3 = Dw.rHL;
            } else {
                i3 = 0;
                i2 = 0;
                size = 0;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(aFm())});
            if (this.ihz != null && aGk()) {
                this.ihz.oD(size + i2);
                this.ihz.oE(i3);
            }
            aFl();
            i = 1;
        }
        if (i == 0 || this.ioW == null) {
            ep(true);
        } else {
            this.ioW.postDelayed(new Runnable() {
                public final void run() {
                    a.this.ep(false);
                }
            }, 3000);
        }
    }

    public final void ep(boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(aGj())});
        if (!z) {
            aGj();
        }
        al(this.ikl);
        aGi();
    }

    private void al(byte[] bArr) {
        int aFm = aFm();
        int i = this.ikw == 1 ? 1 : 2;
        if (bArr != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[]{bArr.toString()});
            this.ikv = new n(aFm, bArr, i);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.ikv = new n(aFm, i);
    }

    private void aGi() {
        au.DF().a(this.ikv, 0);
    }

    private static boolean aGj() {
        au.HU();
        ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sOV, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, f fVar) {
        Object obj;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        int i2;
        Object i22;
        switch (i) {
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                this.ikx = fVar;
                int obj2 = 1;
                i22 = 1;
                break;
            case 0:
                this.ikx = fVar;
                obj2 = null;
                i22 = null;
                break;
            case 1:
                this.ikx = fVar;
                obj2 = null;
                i22 = 1;
                break;
            case 2:
                if (this.ikx == null) {
                    this.ikx = new f();
                }
                this.ikx.oL(fVar.ihp);
                this.ikx.aN(fVar.ihq);
                obj2 = null;
                i22 = 1;
                break;
            default:
                obj2 = null;
                i22 = null;
                break;
        }
        if (this.ikx != null) {
            this.ikx.aEr();
        }
        if (this.ikx != null && i22 != null) {
            if (obj2 != null) {
                if (this.ikx == null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
                } else {
                    this.ikD = (LinkedList) this.ikx.ihs;
                    this.ikE = (LinkedList) this.ikx.iht;
                    if (this.ikD != null) {
                        this.ikc.c(this.ikD, this.ikE);
                    } else if (this.ikx.ihr != null) {
                        this.ikD = new LinkedList();
                        this.ikD.add(this.ikx.ihr);
                        this.ikc.c(this.ikD, this.ikE);
                    }
                }
            }
            if (this.ihz != null) {
                this.ihz.b(this.ikx);
            }
        }
    }

    private void aFl() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.ihz.ien, (h$a) this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
        switch (lVar.getType()) {
            case 411:
                n nVar = (n) lVar;
                if (nVar != null && nVar.mType == aFm()) {
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    if (!(nVar == null || nVar.aEQ() == null)) {
                        if (this.ihz.aDB() <= 0 && aGk()) {
                            if (nVar.aEQ().rHN == null) {
                                i3 = 0;
                            } else {
                                i3 = nVar.aEQ().rHN.size();
                            }
                            this.ihz.oF(i3);
                        }
                        i4 = nVar.aEQ().rHK;
                        i5 = nVar.aEQ().rHL;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(nVar.mType)});
                    if (this.ihz != null && this.ihz.aDA() <= 0 && aGk()) {
                        this.ihz.oD(i4 + this.ihz.aDB());
                        this.ihz.oE(i5);
                    }
                    this.ikj = false;
                    this.ikk.setVisibility(8);
                    Object obj = (i == 0 || i == 4) ? 1 : null;
                    if (obj != null) {
                        this.gQd.setVisibility(8);
                        this.ikf.setVisibility(0);
                        n nVar2 = (n) lVar;
                        f a = n.a(nVar2.aEQ());
                        this.ikl = nVar2.iiN;
                        adh aEQ;
                        if (i2 == 0) {
                            aEQ = nVar2.aEQ();
                            a(this.iki, a);
                            d(aEQ);
                            this.iki = 0;
                        } else if (i2 == 2) {
                            aEQ = nVar2.aEQ();
                            a(this.iki, a);
                            aFl();
                            d(aEQ);
                            this.iki = 2;
                        } else if (i2 == 3) {
                            a(this.iki, a);
                            this.iki = 1;
                        } else {
                            this.gQd.setVisibility(0);
                            this.ikf.setVisibility(8);
                            this.ikg.setText(R.l.emoji_store_load_failed);
                        }
                    } else if (!this.ikC) {
                        this.gQd.setVisibility(0);
                        this.ikf.setVisibility(8);
                        this.ikg.setText(R.l.emoji_store_load_failed_network);
                    }
                    if (aGk()) {
                        if (!(nVar.aEQ() == null || nVar.aEQ().rHN == null || nVar.aEQ().rHN.size() <= 0)) {
                            i3 = 0;
                            while (true) {
                                i5 = i3;
                                if (i5 < nVar.aEQ().rHN.size()) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(13223, new Object[]{Integer.valueOf(0), Integer.valueOf(((tj) nVar.aEQ().rHN.get(i5)).bzI), ((tj) nVar.aEQ().rHN.get(i5)).bHD, Integer.valueOf(0)});
                                    i3 = i5 + 1;
                                }
                            }
                        }
                        if (nVar.aEQ().rHL > 0 && nVar.aEQ().rHC != null && nVar.aEQ().rHC.size() > nVar.aEQ().rHK + nVar.aEQ().rHL) {
                            i3 = 0;
                            while (true) {
                                i5 = i3;
                                if (i5 < nVar.aEQ().rHL) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(13223, new Object[]{Integer.valueOf(0), ((ts) nVar.aEQ().rHC.get(nVar.aEQ().rHK + i5)).rem, ((ts) nVar.aEQ().rHC.get(nVar.aEQ().rHK + i5)).rwQ, Integer.valueOf(1)});
                                    i3 = i5 + 1;
                                } else {
                                    return;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
                break;
            default:
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean aCg() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        eq(true);
        return true;
    }

    public final boolean aCh() {
        return false;
    }

    public final boolean aCi() {
        return false;
    }

    private void d(final adh adh) {
        if (this.iki == -1) {
            au.Em().H(new Runnable() {
                public final void run() {
                    int i = 0;
                    if (adh != null) {
                        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
                        String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(adh == null ? 0 : adh.rHB);
                        if (!(adh == null || adh.rcT == null)) {
                            i = adh.rcT.boi();
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(a.this.aFm());
                        com.tencent.mm.sdk.platformtools.x.d(str, str2, objArr);
                        i.aEA().igA.a(a.this.aFm(), adh);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.aDp() == 9) {
            zM(getString(R.l.app_uninstalling));
        }
        if (!aGk()) {
            this.iky.ihC = 2;
        } else if (aVar.mPosition >= 0 && aVar.mPosition < this.ihz.aDz()) {
            this.iky.ihC = 3;
        } else if (aVar.mPosition < this.ihz.aDz() || aVar.mPosition >= this.ihz.aDA() + this.ihz.aDz()) {
            this.iky.ihC = 1;
        } else {
            this.iky.ihC = 19;
        }
        this.iky.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.CU.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.ihz.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.ihz.oG(headerViewsCount);
            a(oG, headerViewsCount);
            if (aGk() && this.ihz.aDA() > 0 && headerViewsCount >= this.ihz.aDz() && headerViewsCount < this.ihz.aDz() + this.ihz.aDA() && oG.iez != null) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13223, new Object[]{Integer.valueOf(1), oG.iez.rem, oG.iez.rwQ, Integer.valueOf(1), Integer.valueOf(0)});
            }
        }
    }

    public final void ms(int i) {
        if (i >= 0 && i < ((com.tencent.mm.plugin.emoji.a.h) this.ihz).aDD()) {
            a(this.ihz.oG(i), i);
        }
    }

    private void a(com.tencent.mm.plugin.emoji.a.a.f fVar, int i) {
        if (fVar == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.iey == com.tencent.mm.plugin.emoji.a.a.f.a.ieH) {
            tj tjVar = fVar.ieA;
            if (tjVar == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                m.a(getContext(), tjVar, false);
            }
        } else {
            ts tsVar = fVar.iez;
            if (tsVar == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!aGk()) {
                i2 = 2;
            } else if (i >= 0 && i < this.ihz.aDz()) {
                i2 = 3;
            } else if (i < this.ihz.aDz() || i >= this.ihz.aDA() + this.ihz.aDz()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            m.a(getContext(), tsVar, i2, fVar.mStatus, fVar.pF, thisActivity().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.iki == 0 || this.ikj) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        eq(true);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.iky != null) {
            this.iky.onActivityResult(i, i2, intent);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    public final void M(String str, String str2, String str3) {
        this.ikB = new g(str, str2, str3);
        au.DF().a(this.ikB, 0);
    }

    public final void aEs() {
        this.ikl = null;
        this.iki = -1;
        eq(false);
    }

    private void eq(boolean z) {
        if (this.ikj) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.ikj = true;
        if (z) {
            this.ikk.setVisibility(0);
        }
        al(this.ikl);
        aGi();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            zM(getString(R.l.app_waiting));
        }
    }

    public final void m(Message message) {
        if (this.ioW != null) {
            this.ioW.sendMessage(message);
        }
    }

    private void zM(String str) {
        if (isFinishing()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        FragmentActivity thisActivity = thisActivity();
        getString(R.l.app_tip);
        this.eEX = com.tencent.mm.ui.base.h.a(thisActivity, str, true, new 9(this));
    }

    protected static void aFp() {
    }

    public final void u(ArrayList<com.tencent.mm.pluginsdk.model.n> arrayList) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.ihz != null) {
            if (this.ioW != null) {
                this.ioW.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.ihz.ien);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.ioW != null) {
            this.ioW.sendEmptyMessageDelayed(131074, 50);
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ikc != null) {
            this.ikc.requestLayout();
        }
        setRequestedOrientation(1);
    }
}
