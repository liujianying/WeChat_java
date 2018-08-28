package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView$e;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class BaseEmojiStoreUI extends EmojiBaseActivity implements OnScrollListener, OnItemClickListener, e, a, b, h.a, j.a, c, d, MMPullDownView$e {
    private static Map<String, Long> ikz;
    protected ListView CU;
    private ProgressDialog eEX;
    protected View gQd;
    private com.tencent.mm.plugin.emoji.h.b ihH;
    com.tencent.mm.plugin.emoji.a.a.a ihz;
    private com.tencent.mm.sdk.b.c ikA;
    protected g ikB;
    protected boolean ikC = false;
    private LinkedList<th> ikD = new LinkedList();
    private LinkedList<tj> ikE = new LinkedList();
    protected EmojiStoreVpHeader ikc;
    protected View ikd;
    protected StoreBannerEmojiView ike;
    protected MMPullDownView ikf;
    protected TextView ikg;
    protected boolean ikh = false;
    int iki = -1;
    private boolean ikj;
    private View ikk;
    byte[] ikl;
    private final int ikm = 65537;
    private final int ikn = 20001;
    private final int iko = TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN;
    protected final int ikp = 131074;
    private final int ikq = 131075;
    private final int ikr = 131076;
    private final String iks = "product_id";
    private final String ikt = "progress";
    private final String iku = "status";
    private n ikv;
    private int ikw;
    private f ikx;
    private com.tencent.mm.plugin.emoji.model.h iky;

    public abstract int aFd();

    public abstract int aFe();

    public abstract com.tencent.mm.plugin.emoji.a.a.a aFf();

    public abstract int aFm();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iky = new com.tencent.mm.plugin.emoji.model.h();
        initView();
        this.ikw = getIntent().getIntExtra("preceding_scence", 2);
        if (i.aEA().igy != null) {
            i.aEA().igy.c(this);
        }
        this.ikA = new a(this, (byte) 0);
        com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
        this.iky.gKE = this;
        this.iky.ihz = this.ihz;
        this.iky.ihC = aFd();
        this.iky.ihF = this;
        boolean aFt = aFt();
        if (aFt) {
            aFt = aFr();
        }
        w(false, aFt);
        if (ikz == null) {
            ikz = new HashMap();
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "refresh last net refresh time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        ikz.put(getClass().toString(), Long.valueOf(r0));
        this.ihH = new com.tencent.mm.plugin.emoji.h.b(TXLiveConstants.PUSH_EVT_CHANGE_RESOLUTION);
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(411, this);
        au.DF().a(423, this);
        au.DF().a(413, this);
        au.DF().a(717, this);
        if (aFj() && this.ikc != null) {
            this.ikc.aGc();
        }
        Boolean.valueOf(false);
        this.iky.ihA = false;
        if (this.ihz != null && this.ihz.ien != null) {
            this.ihz.ien.aDF();
            this.ihz.aoV();
        }
    }

    protected void onPause() {
        super.onPause();
        au.DF().b(411, this);
        au.DF().b(423, this);
        au.DF().b(413, this);
        au.DF().b(717, this);
        aFp();
        if (aFj() && this.ikc != null) {
            this.ikc.aGd();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.ihz != null) {
            this.ihz.clear();
            this.ihz = null;
        }
        if (aFj() && this.ikc != null) {
            this.ikc.clear();
        }
        i.aEA().igy.d(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.ikA);
        au.DF().c(this.ikB);
        if (this.iky != null) {
            com.tencent.mm.plugin.emoji.model.h hVar = this.iky;
            hVar.ihz = null;
            hVar.ihF = null;
            hVar.gKE = null;
        }
    }

    protected int getLayoutId() {
        return R.i.emoji_store_main;
    }

    public void a(int i, int i2, String str, l lVar) {
        int i3 = -1;
        String str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str3 = "jacks [onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        aFs();
        switch (lVar.getType()) {
            case 411:
                n nVar = (n) lVar;
                if (nVar == null || nVar.mType != aFm()) {
                    str2 = "MicroMsg.emoji.BaseEmojiStoreUI";
                    str3 = "no some scene type. this ui type:%d callbak type:%d";
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aFm());
                    if (nVar != null) {
                        i3 = nVar.mType;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    return;
                }
                this.ikj = false;
                this.ikk.setVisibility(8);
                f fVar = null;
                try {
                    fVar = n.a(nVar.aEQ());
                } catch (Exception e) {
                    x.l("MicroMsg.emoji.BaseEmojiStoreUI", "deal NetGetEmotionList error:%s", new Object[]{e.toString()});
                }
                if (fVar != null) {
                    boolean z = i == 0 || i == 4;
                    if (z) {
                        this.gQd.setVisibility(8);
                        this.ikh = false;
                        this.ikl = nVar.iiN;
                        adh aEQ;
                        if (i2 == 0) {
                            aEQ = nVar.aEQ();
                            a(fVar, false, true);
                            b(aEQ);
                            this.iki = 0;
                            return;
                        } else if (i2 == 2) {
                            aEQ = nVar.aEQ();
                            a(this.iki, fVar, false, false);
                            aFl();
                            b(aEQ);
                            this.iki = 2;
                            return;
                        } else if (i2 == 3) {
                            a(this.iki, fVar, false, false);
                            this.iki = 1;
                            return;
                        } else {
                            this.gQd.setVisibility(0);
                            this.ikh = true;
                            if (aFm() == 7) {
                                this.ikg.setText(R.l.emoji_store_topic_empty);
                                return;
                            } else {
                                this.ikg.setText(R.l.emoji_store_load_failed);
                                return;
                            }
                        }
                    }
                }
                if (!this.ikC) {
                    this.gQd.setVisibility(0);
                    this.ikh = true;
                    this.ikg.setText(R.l.emoji_store_load_failed_network);
                    return;
                }
                return;
            case 413:
                q qVar = (q) lVar;
                Message message;
                if (i == 0 && i2 == 0) {
                    i.aEA().igy.Zu(qVar.iiv);
                    message = new Message();
                    message.what = TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN;
                    message.obj = this.mController.tml.getString(R.l.app_unInstall_finish);
                    m(message);
                } else {
                    message = new Message();
                    message.what = TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN;
                    message.obj = this.mController.tml.getString(R.l.emoji_delete_failed);
                    m(message);
                }
                ct(20001, 800);
                return;
            case 423:
                g gVar = (g) lVar;
                if (i == 0 && i2 == 0) {
                    a(gVar);
                    return;
                }
                str2 = gVar.iiv;
                str3 = gVar.iix;
                final String str4 = gVar.iiw;
                com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_store_download_failed_msg, new Object[]{str4}), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        BaseEmojiStoreUI.this.N(str2, str3, str4);
                        BaseEmojiStoreUI.this.aFq();
                        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        BaseEmojiStoreUI.this.bf(str2, 0);
                    }
                }, new 2(this));
                be(gVar.iiv, -1);
                return;
            case 717:
                if (i == 0 && i2 == 0) {
                    this.ikl = null;
                    w(false, true);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.emoji.BaseEmojiStoreUI", "unknow scene type");
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (aFj() || aFk()) {
            if (i != 0) {
                i--;
            } else {
                return;
            }
        }
        if (i >= 0 && i < this.ihz.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.ihz.getItem(i);
            if (oG == null) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "item is null.");
            } else if (oG.iey == com.tencent.mm.plugin.emoji.a.a.f.a.ieH) {
                tj tjVar = oG.ieA;
                if (tjVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "banner set is null. do nothing");
                } else {
                    m.a(this.mController.tml, tjVar, false);
                }
            } else {
                ts tsVar = oG.iez;
                if (tsVar == null) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "summary is null. do nothing");
                    return;
                }
                m.a(this.mController.tml, tsVar, aFd(), oG.mStatus, oG.pF, getIntent().getStringExtra("to_talker_name"), aFe());
            }
        }
    }

    protected void aFc() {
        this.ihz = aFf();
        this.ihz.ieo = this;
    }

    protected void zJ(String str) {
    }

    protected void aFg() {
    }

    protected void aFh() {
        if (aFi()) {
            this.ikf = (MMPullDownView) findViewById(R.h.load_more_pull_view);
            if (this.ikf != null) {
                this.ikf.setTopViewVisible(false);
                this.ikf.setAtTopCallBack(this);
                this.ikf.setOnBottomLoadDataListener(this);
                this.ikf.setAtBottomCallBack(this);
                this.ikf.setBottomViewVisible(false);
                this.ikf.setIsBottomShowAll(false);
            }
        }
    }

    protected boolean aFi() {
        return true;
    }

    public void initView() {
        setBackBtn(new b(this, (byte) 0));
        aFc();
        this.gQd = findViewById(R.h.empty);
        this.ikg = (TextView) this.gQd.findViewById(R.h.empty_content);
        this.ikk = getLayoutInflater().inflate(R.i.emoji_store_load_more, null);
        this.ikk.setVisibility(8);
        if (aFj()) {
            this.ikc = new EmojiStoreVpHeader(this.mController.tml);
        }
        if (aFk()) {
            this.ikd = LayoutInflater.from(this).inflate(R.i.emoji_store_vp_header_item, null);
            int i = EmojiStoreVpHeader.db(this.mController.tml)[0];
            this.ikd.setLayoutParams(new LayoutParams(i, ((i * 3) / 8) + 1));
            this.ike = (StoreBannerEmojiView) this.ikd.findViewById(R.h.emoji_bar_view);
        }
        this.CU = (ListView) findViewById(16908298);
        this.CU.setOnItemClickListener(this);
        if (aFj()) {
            this.CU.addHeaderView(this.ikc);
        } else if (aFk()) {
            this.CU.addHeaderView(this.ikd);
        }
        if (aFu()) {
            this.CU.addFooterView(this.ikk);
        }
        aFg();
        this.CU.setAdapter(this.ihz);
        this.CU.setOnScrollListener(this);
        this.ihz.iem = this.CU;
        aFh();
    }

    protected final void w(boolean z, boolean z2) {
        n nVar;
        this.ikj = true;
        if (z) {
            this.ikk.setVisibility(0);
        }
        Object obj = this.ikl;
        int aFm = aFm();
        int aFo = aFo();
        int aFn = aFn();
        if (obj != null) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer %s", new Object[]{obj.toString()});
            nVar = new n(aFm, obj, aFo);
            if (aFm == 7) {
                nVar.iiP = aFn;
            }
        } else {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] request buffer is null.");
            nVar = new n(aFm, aFo);
            if (aFm == 7) {
                nVar.iiP = aFn;
            }
        }
        this.ikv = nVar;
        au.DF().a(this.ikv, 0);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z && !z2) {
            WI();
        }
    }

    public final boolean aCg() {
        w(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onBottomLoadData] startLoadRemoteEmoji.");
        return true;
    }

    public final void k(Message message) {
        switch (message.what) {
            case TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN /*2002*/:
                String str = (String) message.obj;
                if (isFinishing()) {
                    x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[updateLoadingDialog] acitivity is finished.");
                    return;
                } else if (this.eEX != null) {
                    this.eEX.setMessage(str);
                    return;
                } else {
                    return;
                }
            case 20001:
                aFs();
                return;
            case 65537:
                c((adh) message.obj);
                return;
            default:
                return;
        }
    }

    public void l(Message message) {
        String string;
        switch (message.what) {
            case 131074:
                if (this.ihz != null) {
                    this.ihz.notifyDataSetChanged();
                    aFv();
                    return;
                }
                return;
            case 131075:
                if (this.ihz != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.ihz.bf(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (this.ihz != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        this.ihz.be(string, message.getData().getInt("status"));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected boolean aFj() {
        return true;
    }

    protected boolean aFk() {
        return false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.iki == 0 || this.ikj) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "No More List.");
            return;
        }
        w(true, false);
        x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    private void aFl() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.ihz.ien, this);
    }

    protected void a(g gVar) {
        bf(gVar.iiv, 0);
    }

    private void bf(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        m(obtain);
    }

    private void be(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        m(obtain);
    }

    protected final g N(String str, String str2, String str3) {
        this.ikB = new g(str, str2, str3);
        return this.ikB;
    }

    public int aFn() {
        return 0;
    }

    protected int aFo() {
        if (this.ikw == 1) {
            return 1;
        }
        return 2;
    }

    protected final void aFp() {
        au.DF().c(this.ikv);
    }

    protected final void aFq() {
        au.DF().a(this.ikB, 0);
    }

    protected boolean aFr() {
        adh Dw = i.aEA().igA.Dw(aFm());
        f a = n.a(Dw);
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "load cache type: %d, size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aFm());
        objArr[1] = Integer.valueOf(Dw == null ? 0 : Dw.rHB);
        x.d(str, str2, objArr);
        if (a == null) {
            return false;
        }
        boolean z;
        if (a.ihq.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by Cache: list:%d", new Object[]{Integer.valueOf(a.ihq.size())});
            a(a, true, false);
            return z;
        }
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks init EmoijStoreUI  by NET");
        return z;
    }

    protected final void WI() {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.app_tip);
        this.eEX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 3(this));
    }

    protected final void aFs() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }

    protected void a(f fVar, boolean z, boolean z2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "jacks initData begin");
        if (fVar != null && fVar.ihq.size() > 0) {
            this.ikC = true;
            this.gQd.setVisibility(8);
            this.ikh = false;
        }
        a(this.iki, fVar, z, z2);
        aFl();
    }

    private void a(int i, f fVar, boolean z, boolean z2) {
        boolean z3 = false;
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "");
        switch (i) {
            case -1:
                this.ikx = fVar;
                break;
            case 1:
                this.ikx = fVar;
                break;
            case 2:
                if (this.ikx == null) {
                    this.ikx = new f();
                }
                if (fVar != null) {
                    this.ikx.oL(fVar.ihp);
                    this.ikx.aN(fVar.ihq);
                    break;
                }
                break;
            default:
                if (this.ikx != null) {
                    this.ikx.aEr();
                }
                a(z3, this.ikx, z, z2);
        }
        z3 = true;
        if (this.ikx != null) {
            this.ikx.aEr();
        }
        a(z3, this.ikx, z, z2);
    }

    protected void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (this.ikx != null && z) {
            if (aFj()) {
                if (this.ikx == null || this.ikx.ihr == null || this.ikx.ihr.rwE == null) {
                    x.d("MicroMsg.emoji.BaseEmojiStoreUI", "update store ui header failed. ");
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

    private void b(adh adh) {
        if (this.iki == -1) {
            Message obtain = Message.obtain();
            obtain.what = 65537;
            obtain.obj = adh;
            if (this.ilh != null) {
                this.ilh.sendMessage(obtain);
            }
        }
    }

    protected void c(adh adh) {
        int i = 0;
        if (adh != null) {
            String str = "MicroMsg.emoji.BaseEmojiStoreUI";
            String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(adh == null ? 0 : adh.rHB);
            if (!(adh == null || adh.rcT == null)) {
                i = adh.rcT.boi();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(aFm());
            x.d(str, str2, objArr);
            i.aEA().igA.a(aFm(), adh);
        }
    }

    public final boolean aCh() {
        return false;
    }

    public final boolean aCi() {
        return false;
    }

    public void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group")) {
            aFD();
            ct(131074, 50);
        }
    }

    public void h(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (this.ihz != null && this.ihz.ien != null) {
            if (i == 6) {
                bf(str, i2);
            } else {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                be(str, i);
            }
            com.tencent.mm.plugin.emoji.a.a.f za = this.ihz.ien.za(str);
            if (za != null) {
                za.ieC = str2;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.BaseEmojiStoreUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.aDq()) ? "" : aVar.aDq();
        objArr[2] = Integer.valueOf(aVar.aDp());
        x.i(str, str2, objArr);
        if (aVar.aDp() == 9) {
            String string = getString(R.l.app_uninstalling);
            if (isFinishing()) {
                x.i("MicroMsg.emoji.BaseEmojiStoreUI", "[showLoadingDialog] acitivity is finished.");
            } else {
                getString(R.l.app_tip);
                this.eEX = com.tencent.mm.ui.base.h.a(this, string, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        au.DF().cancel(413);
                    }
                });
            }
        }
        this.iky.a(aVar);
    }

    protected boolean aFt() {
        return false;
    }

    public final void u(ArrayList<com.tencent.mm.pluginsdk.model.n> arrayList) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "google [onQueryFinish]");
        if (this.ihz != null) {
            com.tencent.mm.plugin.emoji.a.a.b.a(arrayList, this.ihz.ien);
            if (this.ili != null) {
                this.ili.removeMessages(131074);
                this.ili.sendEmptyMessage(131074);
            }
        }
    }

    public final void M(String str, String str2, String str3) {
        N(str, str2, str3);
        aFq();
    }

    public final void aEs() {
        this.ikl = null;
        this.iki = -1;
        w(false, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.BaseEmojiStoreUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.iky.onActivityResult(i, i2, intent);
    }

    protected boolean aFu() {
        return true;
    }

    public void aFv() {
    }
}
