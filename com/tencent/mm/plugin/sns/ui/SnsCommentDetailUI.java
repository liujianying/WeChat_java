package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.am;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsCommentDetailUI extends MMActivity implements e, a, b {
    public static int nUo = 34;
    private String bSZ;
    private String cXR;
    private k contextMenuHelper;
    private c fIu = new 6(this);
    private boolean fUh = false;
    private int hER;
    private int hcA = 0;
    private OnClickListener hqU = new 41(this);
    private OnClickListener jXR = new OnClickListener() {
        public final void onClick(View view) {
            x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, view);
        }
    };
    private ClipboardManager jdw;
    private String lxx = "";
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean nLL;
    private boolean nLM = false;
    private SnsCommentFooter nLN;
    private ao nLP;
    private c nLV;
    private com.tencent.mm.plugin.sns.f.b nLW;
    private p nLY = null;
    private OnTouchListener nNj = bi.cjb();
    private long nTM = 0;
    private long nTN = 0;
    private View nTO;
    private TextView nTP;
    private LinearLayout nTQ;
    private SnsDetailLuckyHeader nTR;
    private ListView nTS;
    private View nTT;
    private b nTU;
    private ScaleAnimation nTV;
    private ScaleAnimation nTW;
    LinearLayout nTX;
    LinearLayout nTY;
    private LinkedList<bon> nTZ;
    private c nUA = new 12(this);
    private c nUB = new 23(this);
    private c nUC = new 34(this);
    private c nUD = new c(this);
    private OnClickListener nUE = new 42(this);
    private c nUF = new 5(this);
    private c nUG = new 7(this);
    boolean nUH = false;
    private LinearLayout nUI = null;
    private boolean nUJ = false;
    PhotosContent nUK = null;
    int nUL = 0;
    public am.b.a nUM = new 19(this);
    private bf nUN = null;
    private int nUa = -1;
    private boolean nUb = false;
    private ar nUc;
    private String nUd;
    private ay nUe;
    private int nUf = 0;
    private ImageView nUg;
    private k nUh;
    private boolean nUi = false;
    private long nUj = 0;
    private bg nUk;
    private boolean nUl = false;
    private int nUm;
    private int nUn = 103;
    public int nUp = 210;
    private g nUq;
    private com.tencent.mm.plugin.sns.ui.b.b nUr;
    private SnsTranslateResultView nUs;
    private boolean nUt = false;
    private Dialog nUu = null;
    private boolean nUv = false;
    private boolean nUw = false;
    private String nUx = "";
    private ag nUy = new ag();
    private c nUz = new 1(this);
    private LinearLayout nmk;

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ap.cb(str, 4);
        if (snsCommentDetailUI.nTU != null) {
            snsCommentDetailUI.nTU.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        n iq = snsCommentDetailUI.iq(false);
        if (iq.bAK().equals(str)) {
            ap.cc(str, 4);
            snsCommentDetailUI.nUs.setVisibility(8);
            snsCommentDetailUI.nTP.setTag(new as(snsCommentDetailUI.bSZ, iq.bBe(), true, false, 2));
        }
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ap.cc(str, 4);
        if (snsCommentDetailUI.nTU != null) {
            snsCommentDetailUI.nTU.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        if (snsCommentDetailUI.nLN != null) {
            snsCommentDetailUI.nLN.ir(false);
            if (snsCommentDetailUI.nLN.bDj()) {
                snsCommentDetailUI.nLN.bDm();
            } else {
                snsCommentDetailUI.nLN.state = 0;
            }
        }
    }

    static /* synthetic */ void u(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        int count = snsCommentDetailUI.nTU.getCount() - 1;
        bon commentInfo = snsCommentDetailUI.nLN.getCommentInfo();
        long j = commentInfo.smh != 0 ? (long) commentInfo.smh : commentInfo.smk;
        if (commentInfo != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= snsCommentDetailUI.nTU.nVs.size()) {
                    break;
                }
                bon bon = (bon) snsCommentDetailUI.nTU.nVs.get(i);
                if ((bon.smh != 0 ? (long) bon.smh : bon.smk) == j) {
                    break;
                }
                i2 = i + 1;
            }
            snsCommentDetailUI.nUD.hGJ = snsCommentDetailUI.bDb();
            if (aj.m(h.Nk(snsCommentDetailUI.bSZ)).smL.size() > 0) {
                i++;
                if (i > snsCommentDetailUI.nTU.getCount()) {
                    i = snsCommentDetailUI.nTU.getCount() - 1;
                }
            }
            snsCommentDetailUI.nUD.AV = i;
            snsCommentDetailUI.bBR();
        }
        i = count;
        snsCommentDetailUI.nUD.hGJ = snsCommentDetailUI.bDb();
        if (aj.m(h.Nk(snsCommentDetailUI.bSZ)).smL.size() > 0) {
            i++;
            if (i > snsCommentDetailUI.nTU.getCount()) {
                i = snsCommentDetailUI.nTU.getCount() - 1;
            }
        }
        snsCommentDetailUI.nUD.AV = i;
        snsCommentDetailUI.bBR();
    }

    static /* synthetic */ void v(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        if (v.NG(snsCommentDetailUI.bSZ)) {
            n Nk = h.Nk(snsCommentDetailUI.bSZ);
            if (Nk.field_likeFlag == 0) {
                Nk.field_likeFlag = 1;
                h.a(Nk.bAK(), Nk);
                if (Nk.xb(32)) {
                    i = 7;
                }
                com.tencent.mm.plugin.sns.model.am.a.a(Nk, i, "");
                snsCommentDetailUI.nTU.notifyDataSetChanged();
            } else {
                Nk.field_likeFlag = 0;
                h.a(Nk.bAK(), Nk);
                com.tencent.mm.plugin.sns.model.am.a.Mp(Nk.bAK());
            }
            boy m = aj.m(h.Nk(snsCommentDetailUI.bSZ));
            if (m != null) {
                snsCommentDetailUI.nTZ = m.smL;
                snsCommentDetailUI.g(m.smL, m.smO.isEmpty());
                b bVar = snsCommentDetailUI.nTU;
                bVar.nVt = m.smL;
                bVar.notifyDataSetChanged();
            }
        }
    }

    private static boolean f(LinkedList<bon> linkedList, LinkedList<bon> linkedList2) {
        if (linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.size() != linkedList2.size()) {
            return false;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (!((bon) linkedList.get(i)).rdS.equals(((bon) linkedList2.get(i)).rdS)) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }

    private void ip(boolean z) {
        this.nUb = false;
        if (this.nLN.bDj()) {
            this.nLN.bDm();
            this.nLN.setHint(getString(j.sns_ui_comment));
        }
        this.nLN.ir(false);
        if (z) {
            BackwardSupportUtil.c.a(this.nTS);
        }
    }

    private n iq(boolean z) {
        n Nk;
        if (bi.oW(this.nUd)) {
            Nk = h.Nk(this.bSZ);
            if (Nk == null) {
                a();
                return null;
            }
            this.nUd = Nk.bBe();
            return Nk;
        }
        Nk = h.Nl(this.nUd);
        if (Nk == null) {
            if (z) {
                Toast.makeText(this, j.sns_msg_not_found, 0).show();
            }
            a();
            return null;
        }
        this.bSZ = Nk.bAK();
        return Nk;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        com.tencent.mm.pluginsdk.e.k(this);
        super.onCreate(bundle);
        af.bye().a(5, "@__weixintimtline", this);
        this.jdw = (ClipboardManager) getSystemService("clipboard");
        this.nTM = System.currentTimeMillis();
        this.contextMenuHelper = new k(this);
        this.nUk = new bg(this, new 2(this), 1, this.nUy);
        this.nUr = new 3(this, this, this.nUy);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.timeline_root);
        this.nLW = new com.tencent.mm.plugin.sns.f.b(this, this.nUr, frameLayout);
        this.nLV = new c(this, this.nUr, frameLayout, this.nLW);
        this.nUr.aYt();
        this.bSZ = bi.aG(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (bi.oW(this.bSZ)) {
            this.bSZ = v.ah("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.nUd = bi.aG(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (bi.oW(this.nUd)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.nUd = v.ah("sns_table_", (long) intExtra);
            }
        }
        this.nUw = getIntent().getBooleanExtra("intent_show_collapse_info", false);
        this.nUx = getIntent().getStringExtra("intent_content_collapse_hint");
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            bsu bsu = new bsu();
            try {
                bsu.aG(byteArrayExtra);
                if (af.byo().fi(new BigInteger(bsu.ksA).longValue()) == null) {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    n nVar = new n();
                    nVar.field_snsId = new BigInteger(bsu.ksA).longValue();
                    try {
                        nVar.field_content = bsu.toByteArray();
                    } catch (Exception e) {
                    }
                    nVar.field_createTime = bsu.lOH;
                    nVar.field_userName = bsu.hbL;
                    nVar.field_type = bsu.sqc.ruz;
                    nVar.bBb();
                    boy boy = new boy();
                    boy.smH = new bhy();
                    try {
                        nVar.field_attrBuf = boy.toByteArray();
                    } catch (IOException e2) {
                    }
                    af.byo().b(nVar);
                    x.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        n iq = iq(true);
        x.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.bSZ + " localSnsId: " + this.nUd);
        if (iq != null) {
            x.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", bi.aG(iq.field_userName, ""));
        }
        if (v.NG(this.bSZ)) {
            if (!v.Lr(this.bSZ)) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(new m(v.NE(this.bSZ), 0, iq.bAH().nyt), 0);
            } else if (iq == null) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(new q(v.NE(this.bSZ)), 0);
            } else if (!s.hd(iq.field_userName)) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(new q(v.NE(this.bSZ)), 0);
            }
        }
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(210, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(218, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(213, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(682, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(214, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(683, (e) this);
        this.nUe = af.byc();
        this.nLP = new ao(this);
        this.nUc = new ar(this.mController.tml);
        this.nUh = new k(this, 1, this.nUy);
        if (iq != null) {
            this.hER = av.a(iq.bAJ(), false);
        }
        if (iq != null && iq.xb(32)) {
            this.nUq = new g(2);
            av.a(iq.bAJ(), false);
        }
        initView();
        if (iq != null && iq.xb(32)) {
            this.nUq.a(0, iq.bBe(), iq.bBn(), iq.bBa(), this.nTO, iq.field_snsId, this.nUN, aj.m(iq), this.hER, 2);
        }
        if (this.nTO != null) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.nTO.findViewById(f.image);
            if (iq.bAJ().sqc != null && iq.bAJ().sqc.ruz == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).ndx.bvH();
            }
            com.tencent.mm.plugin.sns.a.b.j.a(iq, true, z);
        }
        if (this.nTS != null) {
            this.nTS.setOnTouchListener(new 4(this));
            com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUz);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUA);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUB);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUC);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUF);
            com.tencent.mm.sdk.b.a.sFg.b(this.nUG);
            com.tencent.mm.pluginsdk.e.l(this);
        }
    }

    public void onDestroy() {
        af.bye().a(this, 5);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(210, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(218, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(213, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(214, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(683, (e) this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(682, (e) this);
        af.byl().H(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        if (this.nUh != null) {
            this.nUh.activity = null;
        }
        ab.bCj();
        if (this.nLN != null) {
            this.nLN.bbE();
        }
        n iq = iq(false);
        if (!(this.nUq == null || iq == null || !iq.xb(32))) {
            this.nUq.t(0, iq.bBe(), iq.bBn());
            com.tencent.mm.plugin.sns.storage.a bAH = iq.bAH();
            String str = bAH == null ? "" : bAH.ntU;
            i byi;
            Object[] objArr;
            if (iq.bzx()) {
                byi = af.byi();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iq.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eF(iq.field_snsId), str, Long.valueOf(this.nTM), Long.valueOf(System.currentTimeMillis())});
                byi.h(14652, objArr);
            } else {
                byi = af.byi();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iq.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eF(iq.field_snsId), str, Long.valueOf(this.nTM), Long.valueOf(System.currentTimeMillis())});
                byi.h(12012, objArr);
            }
            com.tencent.mm.modelsns.b ip = com.tencent.mm.modelsns.b.ip(732);
            ip.nb(com.tencent.mm.plugin.sns.data.i.eF(iq.field_snsId)).nb(str).nb(this.nTM).nb(System.currentTimeMillis());
            ip.RD();
        }
        this.nUr.aEI();
        com.tencent.mm.sdk.b.a.sFg.c(this.nUz);
        com.tencent.mm.sdk.b.a.sFg.c(this.nUA);
        com.tencent.mm.sdk.b.a.sFg.c(this.nUB);
        com.tencent.mm.sdk.b.a.sFg.c(this.nUC);
        com.tencent.mm.sdk.b.a.sFg.c(this.nUF);
        com.tencent.mm.sdk.b.a.sFg.c(this.nUG);
        super.onDestroy();
    }

    public void onResume() {
        af.byj().a(this);
        if (this.nLN != null) {
            this.nLN.setState(this.bSZ);
        }
        rz rzVar = new rz();
        rzVar.ccO.ccP = 0;
        rzVar.ccO.ccQ = 1;
        rzVar.ccO.ccR = 0;
        rzVar.ccO.type = 0;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        if (this.nUq != null) {
            this.nUq.onResume();
        }
        n iq = iq(false);
        if (iq != null && iq.xb(32) && iq.bzr()) {
            B(iq);
        }
        super.onResume();
    }

    public void onPause() {
        af.byj().b(this);
        super.onPause();
        this.nLN.kXH.onPause();
        new rz().ccO.type = 1;
        if (this.nUq != null) {
            this.nUq.onPause();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.sns_comment_detail;
    }

    protected final void initView() {
        setMMTitle(j.sns_comment_detial_ui_title);
        17 17 = new 17(this);
        setBackBtn(new 18(this));
        this.cXR = com.tencent.mm.model.q.GF();
        if (af.bxX()) {
            a();
        }
        n iq = iq(true);
        if (iq == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.bSZ);
            a();
            return;
        }
        boolean z;
        x.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.bSZ + "localId " + this.nUd + "  username:" + iq.field_userName);
        TextView textView = (TextView) findViewById(f.content_collapse_hint);
        if (this.nUw) {
            textView.setVisibility(0);
            textView.setText(this.nUx);
        } else {
            textView.setVisibility(8);
        }
        if (!v.NG(this.bSZ) && iq.bBg()) {
            atf bAW = iq.bAW();
            findViewById(f.sns_post_again_ll).setVisibility(0);
            textView = (TextView) findViewById(f.post_error_tv);
            switch (bAW.rWj) {
                case HardCoderJNI.SCENE_RECEIVE_MSG /*201*/:
                    if (bi.oW(bAW.rWr)) {
                        textView.setText(j.sns_post_error_ban_again);
                    } else {
                        textView.setText(bAW.rWr);
                    }
                    findViewById(f.sns_post_btn).setVisibility(8);
                    z = false;
                    break;
                case 210:
                    if (bi.oW(bAW.rWr)) {
                        textView.setText(j.sns_post_error_to_long_again);
                    } else {
                        textView.setText(bAW.rWr);
                    }
                    findViewById(f.sns_post_btn).setVisibility(8);
                    z = false;
                    break;
                case 211:
                    if (bi.oW(bAW.rWr)) {
                        textView.setText(j.sns_post_error_ten_min_again);
                    } else {
                        textView.setText(bAW.rWr);
                    }
                    findViewById(f.sns_post_btn).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (bi.oW(bAW.rWr)) {
                        textView.setText(j.sns_post_error_touch_again);
                    } else {
                        textView.setText(bAW.rWr);
                    }
                    findViewById(f.sns_post_btn).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(f.sns_post_again_ll).setVisibility(8);
        z = false;
        if (z) {
            findViewById(f.sns_post_again_ll).setOnClickListener(new 8(this, iq));
        }
        this.nTS = (ListView) findViewById(f.album_comment_list);
        this.nTS.post(new 9(this));
        this.nTS.setOnScrollListener(new 10(this));
        this.nTO = y.gq(this.mController.tml).inflate(com.tencent.mm.plugin.sns.i.g.sns_comment_detail_header, null);
        this.nTO.setOnClickListener(this.nUE);
        this.nTS.addHeaderView(this.nTO);
        z = bDd();
        if (z) {
            n iq2 = iq(false);
            if (iq2 != null) {
                this.hER = av.a(iq2.bAJ(), false);
            }
            if (this.hER == 11 && com.tencent.mm.model.q.GF().equals(iq.field_userName)) {
                this.nTR = new SnsDetailLuckyHeader(this);
                this.nTR.setLayoutParams(new LayoutParams(-1, -2));
                this.nTR.setOnClickListener(this.nUE);
            }
            this.nTQ = new LinearLayout(this.mController.tml);
            this.nTQ.setLayoutParams(new LayoutParams(-1, -2));
            this.nTQ.setOnClickListener(this.nUE);
            BackwardSupportUtil.b.b(this, 2.0f);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.mController.tml);
            linearLayout.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.sns_divider_line);
            linearLayout.setLayoutParams(layoutParams);
            this.nmk = linearLayout;
            if ((iq.field_localPrivate & 1) != 0) {
                findViewById(f.comment_footer).setVisibility(8);
                View textView2 = new TextView(this);
                textView2.setLayoutParams(new LayoutParams(-1, -2));
                textView2.setText(getString(j.sns_detail_private_tip));
                textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                textView2.setGravity(17);
                textView2.setPadding(0, BackwardSupportUtil.b.b(this, 7.0f), 0, 0);
                this.nTS.addFooterView(textView2);
            }
            if (this.nTR != null) {
                this.nUt = true;
                this.nTS.addHeaderView(this.nTR);
            }
            boy m = aj.m(iq);
            if (m == null) {
                this.nTQ.setVisibility(8);
                this.nTU = new b(this, new LinkedList(), new LinkedList(), this, iq.bBe());
            } else {
                this.nTZ = m.smL;
                g(m.smL, m.smO.isEmpty());
                if (this.nTR != null) {
                    this.nTR.a(iq, this.nUr);
                }
                this.nTU = new b(this, m.smO, m.smL, this, iq.bBe());
            }
            this.nTS.addHeaderView(this.nTQ);
            this.nTS.setAdapter(this.nTU);
            this.nLN = (SnsCommentFooter) findViewById(f.comment_footer);
            this.nLN.setOnEditTouchListener(new 11(this, iq));
            this.nLN.setOnSmileyShowListener(new 13(this));
            iq2 = iq(true);
            if (!(iq2 == null || iq2.bBd())) {
                this.nLN.setVisibility(8);
            }
            this.nLN.setAfterEditAction(this.nUD);
            this.nLN.bDl();
            this.nLN.setOnCommentSendImp(new 14(this, iq));
            SnsCommentFooter snsCommentFooter = this.nLN;
            15 15 = new 15(this);
            int i = iq.field_likeFlag;
            snsCommentFooter.nVz.setVisibility(0);
            snsCommentFooter.nVz.setOnClickListener(new 7(snsCommentFooter, 15));
            this.nLN.setHeartBtnVisibility(8);
            this.nUi = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.nUi) {
                this.nUj = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.nUj == 0 || this.nTU.nVs == null)) {
                    int i2 = 0;
                    while (i2 < this.nTU.nVs.size()) {
                        bon bon = (bon) this.nTU.nVs.get(i2);
                        if ((bon.smh != 0 ? (long) bon.smh : bon.smk) == this.nUj) {
                            int i3;
                            this.nTS.setSelection(i2);
                            com.tencent.mm.l.a Yg = this.nUe.Yg(bon.rdS);
                            String BL = Yg != null ? Yg.BL() : bon.rTW != null ? bon.rTW : bon.rdS;
                            this.nLN.a(getString(j.sns_reply) + BL, bon);
                            if (m.smL.size() > 0) {
                                i3 = i2 + 1;
                                if (i3 > this.nTU.getCount()) {
                                    i3 = this.nTU.getCount() - 1;
                                }
                            } else {
                                i3 = i2;
                            }
                            this.nUD.AV = i3;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (this.nUi) {
                new com.tencent.mm.sdk.platformtools.ag().postDelayed(new 16(this), 100);
            }
            this.nUs = (SnsTranslateResultView) this.nTO.findViewById(f.sns_translate_result_view);
            this.nUs.setResultTextSize(((TextView) this.nTO.findViewById(f.desc_tv)).getTextSize());
            this.nUs.getResultTextView().setBackgroundResource(com.tencent.mm.plugin.sns.i.e.sns_clickable_bg);
            this.nUs.getResultTextView().setTag(new as(this.bSZ, iq.bBe(), false, true, 2));
            this.contextMenuHelper.a(this.nUs.getResultTextView(), this.nUr.oky, this.nUr.okv);
            if (ap.cd(this.bSZ, 4)) {
                ap.b Mq = ap.Mq(this.bSZ);
                if (Mq == null || !Mq.dDR) {
                    this.nUs.setVisibility(8);
                    return;
                }
                this.nUs.setVisibility(0);
                this.nUs.a(null, 1, Mq.result, Mq.dMB, false);
                return;
            }
            this.nUs.setVisibility(8);
            return;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + z);
        a();
    }

    private int bDb() {
        if (this.nTS == null || this.nTS.getChildCount() <= 1) {
            return 0;
        }
        View childAt = this.nTS.getChildAt(0);
        if (childAt != null) {
            return childAt.getHeight();
        }
        return 0;
    }

    private LinearLayout xo(int i) {
        if (this.nUI == null) {
            this.nUI = (LinearLayout) y.gq(this).inflate(i, null);
            return this.nUI;
        }
        this.nUH = true;
        return this.nUI;
    }

    private static boolean bDc() {
        return (com.tencent.mm.plugin.sns.model.am.a.byN() & 1) <= 0;
    }

    private void B(n nVar) {
        int i = 0;
        if (nVar != null && nVar.bzr()) {
            int i2 = com.tencent.mm.plugin.sns.i.e.sns_card_select_btn_solid_white;
            int parseColor = Color.parseColor("#cdcdcd");
            int parseColor2 = Color.parseColor("#ffffff");
            Button button = (Button) this.nTO.findViewById(f.card_btn_left);
            Button button2 = (Button) this.nTO.findViewById(f.card_btn_right);
            if (button != null && button2 != null) {
                button.setOnClickListener(this.nUr.okZ);
                button2.setOnClickListener(this.nUr.ola);
                if (nVar.bAF().bzt()) {
                    int eN = v.eN(nVar.bAF().nzy.nzF, nVar.bBo());
                    if (eN > 0 && eN <= 2) {
                        if (eN == 1) {
                            button2.setBackgroundColor(parseColor2);
                            button2.setTextColor(parseColor);
                            button2.setText(nVar.bAF().nzy.wK(1));
                            button.setBackgroundResource(i2);
                            button.setTextColor(-16777216);
                            button.setText(nVar.bAF().nzy.wJ(0));
                        } else if (eN == 2) {
                            button.setBackgroundColor(parseColor2);
                            button.setTextColor(parseColor);
                            button.setText(nVar.bAF().nzy.wK(0));
                            button2.setBackgroundResource(i2);
                            button2.setTextColor(-16777216);
                            button2.setText(nVar.bAF().nzy.wJ(1));
                        }
                        if (i != 0) {
                            button.setTextColor(-16777216);
                            button.setBackgroundResource(i2);
                            button2.setTextColor(-16777216);
                            button2.setBackgroundResource(i2);
                            button.setText(nVar.bAF().bzn());
                            button2.setText(nVar.bAF().bzo());
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                    button.setTextColor(-16777216);
                    button.setBackgroundResource(i2);
                    button2.setTextColor(-16777216);
                    button2.setBackgroundResource(i2);
                    button.setText(nVar.bAF().bzn());
                    button2.setText(nVar.bAF().bzo());
                }
            }
        }
    }

    private void C(n nVar) {
        View findViewById = this.nTO.findViewById(f.sns_ad_card_header_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this, 10);
        layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(this, 10);
        findViewById.setLayoutParams(layoutParams);
        SnsCardAdTagListView snsCardAdTagListView = (SnsCardAdTagListView) this.nTO.findViewById(f.card_ad_tag_list);
        snsCardAdTagListView.setActivityContext(this);
        snsCardAdTagListView.removeAllViews();
        if (nVar.bAF().nzu.size() > 0) {
            snsCardAdTagListView.setVisibility(0);
            snsCardAdTagListView.setTagSpace(com.tencent.mm.bp.a.fromDPToPix(this, 6));
            snsCardAdTagListView.cw(nVar.bAF().nzu);
        }
        if (!bi.oW(nVar.bAF().nzs)) {
            findViewById.setVisibility(0);
            findViewById.findViewById(f.sns_ad_card_header_title).setVisibility(0);
            ((TextView) findViewById.findViewById(f.sns_ad_card_header_title)).setText(nVar.bAF().nzs);
        }
        if (!bi.oW(nVar.bAF().nzt)) {
            d.a(nVar.bAF().nzt, new 20(this, findViewById));
        }
    }

    final boolean bDd() {
        n iq = iq(true);
        if (iq == null) {
            return false;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.nTO.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        cqa().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = this.mScreenHeight < this.mScreenWidth ? this.mScreenHeight : this.mScreenWidth;
        this.nUm = af.byw();
        bsu bAJ = iq.bAJ();
        this.hER = av.a(bAJ, false);
        ImageView imageView = (ImageView) this.nTO.findViewById(f.album_avatar_iv);
        if (imageView == null || iq == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (imageView == null) + " " + (iq == null));
            return false;
        }
        ((MaskImageButton) imageView).uAL = iq.bBe();
        com.tencent.mm.pluginsdk.ui.a.b.p(imageView, iq.getUserName());
        imageView.setTag(iq.getUserName());
        imageView.setOnClickListener(this.nUr.okw);
        TextView textView = (TextView) this.nTO.findViewById(f.nickname_tv);
        com.tencent.mm.kernel.g.Ek();
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(iq.getUserName());
        x.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + iq.getUserName() + " " + iq.bAK() + " " + iq.bAX());
        if (Yg == null) {
            return false;
        }
        String str;
        int i;
        com.tencent.mm.pluginsdk.ui.d.k kVar;
        String str2;
        View findViewById;
        ViewStub viewStub;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        boy m;
        ImageButton imageButton;
        n iq2;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        TextView textView3;
        if (Yg.BJ() == 0) {
            x.i("MicroMsg.SnsCommentDetailUI", "getContact %s", iq.getUserName());
            am.a.HD().a(iq.getUserName(), "", this.nUM);
        }
        String aG = bi.aG(Yg == null ? iq.getUserName() : Yg.BL(), "");
        if (iq.kF() && bi.oW(aG)) {
            com.tencent.mm.plugin.sns.storage.b bAF = iq.bAF();
            if (!(bAF == null || bi.oW(bAF.nickname))) {
                com.tencent.mm.plugin.sns.storage.a bAH;
                LinearLayout linearLayout;
                ViewGroup.LayoutParams layoutParams;
                String bBe;
                int i2;
                CharSequence charSequence;
                Object obj;
                CharSequence string;
                Object string2;
                str = bAF.nickname;
                str.length();
                i = this.hER != 11 ? 3 : 2;
                kVar = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, (CharSequence) str));
                kVar.f(new o(new com.tencent.mm.plugin.sns.data.a(iq.kF(), Yg.getUsername(), iq.bBe(), 2), this.nUh, i), str);
                textView.setOnTouchListener(new ab());
                textView.setText(kVar, BufferType.SPANNABLE);
                ((TextView) this.nTO.findViewById(f.type_desc_tv)).setText("");
                this.nUN = new bf(this.nTO);
                if (iq.kF()) {
                    this.nUN.setVisibility(8);
                } else {
                    this.nUN.r(Long.valueOf(iq.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.nUN, 0, this.nUd, iq.field_snsId, iq.bBn()));
                    this.nUN.a(iq.bAF(), iq.bAH());
                    this.nUN.a(this.nUr.okG, this.nUr.okU);
                    this.nUN.setVisibility(0);
                }
                str2 = bAJ.spZ;
                this.nTP = (TextView) this.nTO.findViewById(f.desc_tv);
                this.nTP.setTag(new as(this.bSZ, iq.bBe(), true, false, 2));
                this.contextMenuHelper.a(this.nTP, this.nUr.oky, this.nUr.okv);
                this.nTO.findViewById(f.card_btn_container).setVisibility(8);
                findViewById = this.nTO.findViewById(f.card_weapp_tag);
                findViewById.setVisibility(8);
                if (iq.kF() || iq.bAF() == null || iq.bAF().nzp != 1 || this.hER == 12) {
                    aG = str2;
                } else {
                    bAH = iq.bAH();
                    if (!(bAH == null || !bAH.bzk() || iq.bBs())) {
                        findViewById.setVisibility(0);
                    }
                    this.nTP.setVisibility(8);
                    this.nTP = (TextView) this.nTO.findViewById(f.desc_collapse_pic_style_tv);
                    this.nTP.setClickable(false);
                    this.nTP.setLongClickable(false);
                    linearLayout = (LinearLayout) this.nTO.findViewById(f.images_keeper_lieaner_layout);
                    linearLayout.setBackground(cqa().getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.sns_ad_pic_style_bg));
                    layoutParams = new LinearLayout.LayoutParams(((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12), -2);
                    layoutParams.setMargins(0, com.tencent.mm.bp.a.fromDPToPix(cqa(), 5), 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                    TextView textView4 = (TextView) this.nTO.findViewById(f.desc_collapse_pic_style_title_tv);
                    textView4.setClickable(false);
                    textView4.setLongClickable(false);
                    if (bi.oW(iq.bAF().nzq)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(iq.bAF().nzq + " ");
                        com.tencent.mm.pluginsdk.ui.d.j.g(textView4, 2);
                        textView4.setVisibility(0);
                    }
                    if (bi.oW(iq.bAF().nzr)) {
                        aG = bAJ.spZ;
                    } else {
                        aG = iq.bAF().nzr;
                    }
                    this.contextMenuHelper.a(linearLayout, this.nUr.okN, this.nUr.okv);
                    if (iq.bAF().bzs() || iq.bAF().bzt()) {
                        this.nTO.findViewById(f.card_btn_container).setVisibility(0);
                        B(iq);
                    }
                }
                if (aG != null || aG.equals("")) {
                    this.nTP.setVisibility(8);
                } else {
                    this.nTP.setText(aG + " ");
                    com.tencent.mm.pluginsdk.ui.d.j.g(this.nTP, 2);
                    this.nTP.setVisibility(0);
                }
                av.e(bAJ);
                viewStub = (ViewStub) this.nTO.findViewById(f.images_keeper_li);
                if (!this.nUJ) {
                    if (this.hER == 2) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline_one);
                    } else if (this.hER == 3) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline1);
                    } else if (this.hER == 4) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline2);
                    } else if (this.hER == 5) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline3);
                    } else if (this.hER != 6) {
                        if (this.hER == 1 || this.hER == 0) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_media_sub_item2);
                        } else if (this.hER == 9) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_media_sight_item);
                        } else if (this.hER == 11) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_hb_reward_item);
                        } else if (this.hER == 12) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_turn_media);
                        }
                    }
                    if (this.hER == 2 || this.hER == 3 || this.hER == 4 || this.hER == 5) {
                        this.nUK = (PhotosContent) viewStub.inflate();
                    } else if (this.hER == 9) {
                        viewStub.inflate();
                    } else if (this.hER == 11) {
                        this.nUK = (PhotosContent) viewStub.inflate();
                    } else if (this.hER == 12) {
                        viewStub.inflate();
                    } else {
                        viewStub.setVisibility(8);
                    }
                    this.nUJ = true;
                }
                if (this.hER != 6) {
                    int i3;
                    TagImageView tagImageView;
                    RelativeLayout.LayoutParams layoutParams2;
                    float a;
                    float a2;
                    float fromDPToPix;
                    int i4;
                    ar arVar;
                    PhotosContent photosContent;
                    View findViewById2;
                    boolean z;
                    ViewGroup.LayoutParams layoutParams3;
                    ate ate;
                    MMImageView mMImageView;
                    if (this.hER == 2 || this.hER == 3 || this.hER == 4 || this.hER == 5) {
                        if (this.nUK != null) {
                            this.nUK.bCz();
                            i3 = 0;
                            while (true) {
                                i = i3;
                                if (i >= ar.nYx[this.hER]) {
                                    break;
                                }
                                tagImageView = (TagImageView) this.nUK.findViewById(ar.nYB[i]);
                                this.nUK.a(tagImageView);
                                tagImageView.setOnClickListener(this.nUr.nNR);
                                this.contextMenuHelper.a(tagImageView, this.nUr.okJ, this.nUr.okv);
                                i3 = i + 1;
                            }
                            this.nUK.setImageViewWidth(this.nUm);
                            List linkedList = new LinkedList();
                            if (iq.kF() && this.hER == 2) {
                                com.tencent.mm.plugin.sns.storage.b bAF2 = iq.bAF();
                                if (bAF2 != null && bAF2.nzp == 1) {
                                    ate ate2;
                                    i = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                                        ate2 = null;
                                    } else {
                                        ate2 = (ate) bAJ.sqc.ruA.get(0);
                                    }
                                    i = (((i - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 20);
                                    i3 = (int) ((ate2.rVH.rWv * ((float) i)) / ate2.rVH.rWu);
                                    atg atg = new atg();
                                    atg.rWu = (float) i;
                                    atg.rWv = (float) i3;
                                    atg.rWw = atg.rWu * atg.rWv;
                                    linkedList.add(atg);
                                    layoutParams2 = (RelativeLayout.LayoutParams) this.nUK.getLayoutParams();
                                    layoutParams2.leftMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                                    layoutParams2.rightMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                                    this.nUK.setLayoutParams(layoutParams2);
                                    C(iq);
                                    this.nTO.findViewById(f.images_keeper_lieaner_layout).setTag(this.nUK.xm(0));
                                    this.nTO.findViewById(f.images_keeper_lieaner_layout).setOnClickListener(this.nUr.olb);
                                    i3 = 0;
                                    while (true) {
                                        i = i3;
                                        if (i >= ar.nYx[this.hER]) {
                                            break;
                                        }
                                        this.contextMenuHelper.a((TagImageView) this.nUK.findViewById(ar.nYB[i]), this.nUr.okN, this.nUr.okv);
                                        i3 = i + 1;
                                    }
                                    this.nTO.findViewById(f.card_btn_left).setTag(this.nUK.xm(0));
                                    this.nTO.findViewById(f.card_btn_right).setTag(this.nUK.xm(0));
                                } else if (bAF2 != null && bAF2.nzf > 0.0f && bAF2.nzg > 0.0f) {
                                    a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF2.nzf, 1, bAF2.nzh, bAF2.nzi);
                                    a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF2.nzg, 1, bAF2.nzh, bAF2.nzi);
                                    atg atg2;
                                    if (bAF2.nze == 0) {
                                        i3 = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                                        if (a >= ((float) (((i3 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)))) {
                                            fromDPToPix = (float) (((i3 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12));
                                            a2 = (float) ((int) ((bAF2.nzg * fromDPToPix) / bAF2.nzf));
                                        } else {
                                            fromDPToPix = a;
                                        }
                                        atg atg3 = new atg();
                                        atg3.rWu = fromDPToPix;
                                        atg3.rWv = a2;
                                        atg3.rWw = atg3.rWu * atg3.rWv;
                                        linkedList.add(atg3);
                                    } else if (bAF2.nze == 1) {
                                        i3 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                        i4 = (int) ((((float) i3) * bAF2.nzg) / bAF2.nzf);
                                        atg2 = new atg();
                                        if (i3 > 0) {
                                            a = (float) i3;
                                        }
                                        atg2.rWu = a;
                                        if (i4 > 0) {
                                            a2 = (float) i4;
                                        }
                                        atg2.rWv = a2;
                                        atg2.rWw = atg2.rWu * atg2.rWv;
                                        linkedList.add(atg2);
                                    } else if (bAF2.nze == 2) {
                                        i3 = ((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                        i4 = (int) ((((float) i3) * bAF2.nzg) / bAF2.nzf);
                                        atg2 = new atg();
                                        if (i3 > 0) {
                                            a = (float) i3;
                                        }
                                        atg2.rWu = a;
                                        if (i4 > 0) {
                                            a2 = (float) i4;
                                        }
                                        atg2.rWv = a2;
                                        atg2.rWw = atg2.rWu * atg2.rWv;
                                        linkedList.add(atg2);
                                    }
                                }
                                if (!bi.oW(bAF2.nzk)) {
                                    d.b("adId", bAF2.nzk, false, 41, new 21(this, this.nUK, bAF2, this.nUK.xm(0)));
                                }
                            }
                            this.nTO.addOnAttachStateChangeListener(new 22(this, bAJ, iq, linkedList));
                            arVar = this.nUc;
                            photosContent = this.nUK;
                            bBe = iq.bBe();
                            i4 = hashCode();
                            i2 = this.hER;
                            iq.xb(32);
                            arVar.a(photosContent, bAJ, bBe, i4, i2, -1, false, av.tbt, linkedList);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.hER + ",stub is " + viewStub.toString());
                        }
                    } else if (this.hER == 11) {
                        this.nUK.bCz();
                        tagImageView = (TagImageView) this.nUK.findViewById(f.album_img_0);
                        this.nUK.a(tagImageView);
                        tagImageView.setOnClickListener(this.nUr.nNR);
                        aG = iq.bBe();
                        List arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        ap apVar = new ap();
                        apVar.bNH = aG;
                        apVar.index = 0;
                        apVar.nWx = arrayList;
                        apVar.nTx = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(apVar);
                        }
                        textView = (TextView) this.nTO.findViewById(f.hb_tip);
                        if (com.tencent.mm.model.q.GF().equals(bAJ.hbL)) {
                            textView.setVisibility(8);
                        } else {
                            boy n = aj.n(iq);
                            if (n.smZ == null || n.smZ.snB == 0) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(getString(j.lucky_sns_reward_numbers, new Object[]{Integer.valueOf(n.smZ.snB)}));
                                textView.setVisibility(0);
                            }
                        }
                        atf bAW = iq.bAW();
                        if (bAW == null) {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + iq.bBe());
                        } else if (com.tencent.mm.model.q.GF().equals(bAJ.hbL)) {
                            arVar = this.nUc;
                            photosContent = this.nUK;
                            bBe = iq.bBe();
                            i4 = hashCode();
                            i2 = this.hER;
                            iq.xb(32);
                            arVar.a(photosContent, bAJ, bBe, i4, i2, -1, false, av.tbt, true);
                        } else if (com.tencent.mm.plugin.sns.lucky.a.m.h(iq)) {
                            arVar = this.nUc;
                            photosContent = this.nUK;
                            bBe = iq.bBe();
                            i4 = hashCode();
                            i2 = this.hER;
                            iq.xb(32);
                            arVar.a(photosContent, bAJ, bBe, i4, i2, -1, false, av.tbt, false);
                        } else if (bAW.ceS == 0) {
                            arVar = this.nUc;
                            photosContent = this.nUK;
                            bBe = iq.bBe();
                            i4 = hashCode();
                            i2 = this.hER;
                            iq.xb(32);
                            arVar.a(photosContent, bAJ, bBe, i4, i2, -1, false, av.tbt, true);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + bAW.ceS);
                        }
                    } else if (this.hER == 9) {
                        ate ate3;
                        this.nUv = true;
                        ak akVar = new ak();
                        View view = this.nTO;
                        findViewById2 = view.findViewById(f.chatting_click_area);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(f.image);
                        akVar.nRC = findViewById2;
                        akVar.nEI = (ImageView) view.findViewById(f.status_btn);
                        akVar.nRD = (MMPinProgressBtn) view.findViewById(f.progress);
                        akVar.nEJ = (TextView) view.findViewById(f.errorTv);
                        akVar.nRE = (TextView) view.findViewById(f.endtv);
                        akVar.neL = aVar;
                        akVar.a(bAJ, 0, iq.bBe(), iq.kF());
                        akVar.nEJ.setVisibility(8);
                        akVar.neL.setTagObject(akVar);
                        findViewById2.setTag(akVar);
                        akVar.nRC.setOnClickListener(this.nUr.okS);
                        if (iq.bzr()) {
                            this.contextMenuHelper.a(findViewById2, this.nUr.okN, this.nUr.okv);
                        } else {
                            this.contextMenuHelper.a(findViewById2, this.nUr.okL, this.nUr.okv);
                        }
                        Pair a3 = com.tencent.mm.modelsns.e.a(bAJ, akVar.neL.getUIContext(), iq.kF());
                        if (iq.kF()) {
                            com.tencent.mm.plugin.sns.storage.b bAF3 = iq.bAF();
                            if (bAF3 != null && bAF3.nzp == 1) {
                                if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                                    ate3 = null;
                                } else {
                                    ate3 = (ate) bAJ.sqc.ruA.get(0);
                                }
                                if (ate3 != null) {
                                    i3 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 20);
                                    a3 = Pair.create(Integer.valueOf(i3), Integer.valueOf((int) ((((float) i3) * ate3.rVH.rWv) / ate3.rVH.rWu)));
                                }
                                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) akVar.nRC.getLayoutParams();
                                layoutParams4.leftMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                                layoutParams4.rightMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                                akVar.nRC.setLayoutParams(layoutParams4);
                                C(iq);
                                this.nTO.findViewById(f.images_keeper_lieaner_layout).setTag(akVar);
                                this.nTO.findViewById(f.images_keeper_lieaner_layout).setOnClickListener(this.nUr.olb);
                                this.nTO.findViewById(f.card_btn_left).setTag(akVar);
                                this.nTO.findViewById(f.card_btn_right).setTag(akVar);
                            } else if (bAF3 != null && bAF3.nzf > 0.0f && bAF3.nzg > 0.0f) {
                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF3.nzf, 1, bAF3.nzh, bAF3.nzi);
                                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF3.nzg, 1, bAF3.nzh, bAF3.nzi);
                                if (bAF3.nze == 0) {
                                    i3 = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (a4 >= ((float) (((i3 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)))) {
                                        a = (float) (((i3 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12));
                                        fromDPToPix = (float) ((int) ((bAF3.nzg * a) / bAF3.nzf));
                                    } else {
                                        fromDPToPix = a2;
                                        a = a4;
                                    }
                                    a3 = Pair.create(Integer.valueOf((int) a), Integer.valueOf((int) fromDPToPix));
                                } else if (bAF3.nze == 1) {
                                    i3 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                    a3 = Pair.create(Integer.valueOf(i3), Integer.valueOf((int) ((((float) i3) * bAF3.nzg) / bAF3.nzf)));
                                } else if (bAF3.nze == 2) {
                                    i3 = ((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                    a3 = Pair.create(Integer.valueOf(i3), Integer.valueOf((int) ((((float) i3) * bAF3.nzg) / bAF3.nzf)));
                                }
                            }
                        }
                        if (a3 != null) {
                            aVar.dt(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue());
                            layoutParams = akVar.nRE.getLayoutParams();
                            layoutParams.width = ((Integer) a3.first).intValue();
                            layoutParams.height = ((Integer) a3.second).intValue();
                            akVar.nRE.setLayoutParams(layoutParams);
                        }
                        if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                            ate3 = null;
                        } else {
                            ate3 = (ate) bAJ.sqc.ruA.get(0);
                        }
                        if (iq.kF()) {
                            akVar.neL.setOnCompletionListener(new 24(this, iq));
                            if (!this.nUq.ey(iq.field_snsId)) {
                                akVar.neL.setOnDecodeDurationListener(new 25(this, iq, akVar));
                            }
                        }
                        if (bAJ.sqc != null && bAJ.sqc.ruA.size() > 0) {
                            af.byl();
                            if (com.tencent.mm.plugin.sns.model.g.t(ate3)) {
                                if (af.byl().u(ate3)) {
                                    akVar.nEI.setVisibility(0);
                                    akVar.nRD.setVisibility(8);
                                    akVar.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                } else if (af.byl().v(ate3)) {
                                    akVar.nEI.setVisibility(8);
                                    akVar.nRD.setVisibility(8);
                                } else if (!iq.kF() || af.byl().l(iq) > 5) {
                                    af.byl().y(ate3);
                                    akVar.nEI.setVisibility(0);
                                    akVar.nRD.setVisibility(8);
                                    akVar.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                } else {
                                    akVar.nEI.setVisibility(8);
                                    akVar.nRD.setVisibility(8);
                                }
                                if (akVar.neL.bvF()) {
                                    x.d("MicroMsg.SnsCommentDetailUI", "play video error " + ate3.ksA + " " + ate3.jPK + " " + ate3.rVE);
                                    af.byl().y(ate3);
                                    akVar.nEI.setVisibility(0);
                                    akVar.nRD.setVisibility(8);
                                    akVar.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                }
                            } else if (af.byl().w(ate3)) {
                                akVar.nEI.setVisibility(8);
                                akVar.nRD.setVisibility(0);
                                akVar.nRD.cAt();
                            } else if (iq.kF() && af.byl().l(iq) == 5) {
                                af.byl().A(ate3);
                                akVar.nEI.setVisibility(8);
                                akVar.nRD.setVisibility(0);
                                akVar.nRD.cAt();
                            } else {
                                af.byl().y(ate3);
                                akVar.nEI.setVisibility(0);
                                akVar.nRD.setVisibility(8);
                                akVar.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                            }
                            aVar.setTagObject(akVar);
                            af.byl().a(iq, ate3, aVar, hashCode(), 0, av.tbt, iq.kF());
                            findViewById2.setTag(akVar);
                            if (this.nUq != null) {
                                z = iq.kF() ? af.byl().l(iq) == 5 : af.byl().k(iq) == 5;
                                this.nUq.q(iq.field_snsId, z);
                            }
                        }
                    } else if (this.hER == 0) {
                        linearLayout = (LinearLayout) this.nTO.findViewById(f.sns_meida_frame);
                        View xo = xo(com.tencent.mm.plugin.sns.i.g.sns_media_sub_item);
                        if (!this.nUH) {
                            linearLayout.removeView(this.nUK);
                            linearLayout.addView(xo, 3);
                            if (xo.getLayoutParams() != null) {
                                layoutParams3 = new LinearLayout.LayoutParams(xo.getLayoutParams());
                            } else {
                                layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams3.setMargins(layoutParams3.leftMargin, com.tencent.mm.bp.a.fromDPToPix(this, 12), layoutParams3.rightMargin, layoutParams3.bottomMargin);
                            xo.setLayoutParams(layoutParams3);
                        }
                        if (bAJ.sqc.ruA.isEmpty()) {
                            xo.setVisibility(8);
                        } else {
                            ate = (ate) bAJ.sqc.ruA.get(0);
                            mMImageView = (MMImageView) xo.findViewById(f.image_left);
                            af.byl().b(ate, mMImageView, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_music, hashCode(), av.tbt);
                            this.nUg = (ImageView) xo.findViewById(f.state);
                            this.nUg.setOnTouchListener(this.nNj);
                            this.lxx = bAJ.ksA;
                            bDf();
                            mMImageView.setTag(new r(bAJ, this.nUd, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            mMImageView.setOnClickListener(this.nUk.ohD);
                            CharSequence charSequence2 = ate.jOS;
                            if (!bi.oW(charSequence2)) {
                                ((TextView) xo.findViewById(f.righttext)).setText(charSequence2);
                            }
                            charSequence = ate.bHD;
                            if (!bi.oW(charSequence)) {
                                ((TextView) xo.findViewById(f.titletext)).setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                            }
                            xo.setTag(new r(bAJ, this.nUd));
                            this.contextMenuHelper.a(xo, this.nUr.okK, this.nUr.okv);
                            xo.setOnClickListener(this.nUk.nZN);
                            com.tencent.mm.plugin.sns.data.i.b(mMImageView, this);
                        }
                    } else if (this.hER == 12) {
                        int width = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 82);
                        View findViewById3 = this.nTO.findViewById(f.turn_media_container);
                        layoutParams2 = (RelativeLayout.LayoutParams) findViewById3.getLayoutParams();
                        layoutParams2.topMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                        layoutParams2.bottomMargin = 0;
                        layoutParams2.width = width;
                        layoutParams2.height = width;
                        if (findViewById3.getParent() instanceof ViewGroup) {
                            ((ViewGroup) findViewById3.getParent()).setClipChildren(false);
                            ((ViewGroup) findViewById3.getParent()).setClipToPadding(false);
                        }
                        int[] iArr = new int[]{f.turn_media_type_img_0, f.turn_media_type_img_1};
                        int i5 = f.turn_media_type_sight_0;
                        i3 = 0;
                        while (true) {
                            i = i3;
                            if (i >= 2) {
                                break;
                            }
                            MaskImageView maskImageView = (MaskImageView) findViewById3.findViewById(iArr[i]);
                            maskImageView.setVisibility(8);
                            maskImageView.setOnTouchListener(new 26(this));
                            i3 = i + 1;
                        }
                        View findViewById4 = findViewById3.findViewById(i5);
                        findViewById4.setBackground(null);
                        findViewById4.setVisibility(8);
                        ((ViewGroup) findViewById4).setClipChildren(false);
                        ak akVar2 = new ak();
                        akVar2.nRC = findViewById4;
                        akVar2.nRB = akVar2.nRC;
                        akVar2.neL = (com.tencent.mm.plugin.sight.decode.a.a) akVar2.nRC.findViewById(f.image);
                        akVar2.nEI = (ImageView) akVar2.nRC.findViewById(f.status_btn);
                        akVar2.nRD = (MMPinProgressBtn) akVar2.nRC.findViewById(f.progress);
                        akVar2.nRE = (TextView) akVar2.nRC.findViewById(f.endtv);
                        akVar2.nEJ = (TextView) akVar2.nRC.findViewById(f.errorTv);
                        akVar2.nRC.setTag(akVar2);
                        akVar2.nRC.setOnClickListener(null);
                        ((SightPlayImageView) akVar2.neL).bvU();
                        ((SightPlayImageView) akVar2.neL).setScaleType(QImageView.a.uHR);
                        akVar2.neL.dt(width, width);
                        findViewById3.setLayerType(2, null);
                        if (iq.bAJ().sqc.ruA.size() >= 2) {
                            int i6;
                            if (iq.field_likeFlag == 1) {
                                i6 = 1;
                            } else {
                                i6 = 0;
                            }
                            i3 = 0;
                            while (true) {
                                int i7 = i3;
                                if (i7 >= 2) {
                                    break;
                                }
                                ate = (ate) iq.bAJ().sqc.ruA.get(i7);
                                MaskImageView maskImageView2 = (MaskImageView) findViewById3.findViewById(iArr[i7]);
                                ViewGroup.LayoutParams layoutParams5 = maskImageView2.getLayoutParams();
                                ap apVar2 = new ap();
                                apVar2.bNH = this.nUd;
                                apVar2.index = i7;
                                apVar2.nTx = false;
                                apVar2.nRF = true;
                                apVar2.position = 0;
                                maskImageView2.setTag(apVar2);
                                if (ate.hcE == 2) {
                                    af.byl().a(ate, maskImageView2, -1, hashCode(), av.clX().Dm(bAJ.lOH), 3);
                                } else {
                                    af.byl().a(ate, maskImageView2, hashCode(), av.clX().Dm(bAJ.lOH));
                                }
                                maskImageView2.setScaleType(QImageView.a.uHR);
                                layoutParams5.width = width;
                                layoutParams5.height = width;
                                if (i6 == i7 && ate.hcE == 2) {
                                    maskImageView2.setVisibility(0);
                                    maskImageView2.setOnClickListener(new 27(this, i6, iq));
                                } else {
                                    maskImageView2.setOnClickListener(null);
                                }
                                if (ate.hcE == 6 && i6 == i7) {
                                    z = i6 > 0;
                                    long j = iq.field_snsId;
                                    this.nUv = true;
                                    layoutParams = findViewById4.getLayoutParams();
                                    layoutParams.width = width;
                                    layoutParams.height = width;
                                    findViewById4.setVisibility(0);
                                    af.byl().a(iq, ate, akVar2.neL, hashCode(), 0, av.tbt, iq.kF(), true);
                                    akVar2.nRF = true;
                                    akVar2.nRG = i7;
                                    akVar2.nRA = bAJ;
                                    akVar2.position = 0;
                                    akVar2.bKW = this.nUd;
                                    akVar2.nRC.setOnClickListener(new 28(this, z, iq));
                                    akVar2.neL.setOnCompletionListener(new 29(this, j, z));
                                    if (this.nUq.ey(((long) i7) + j)) {
                                        this.nUq.b(j, bi.VG(), z);
                                    } else {
                                        akVar2.neL.setOnDecodeDurationListener(new 30(this, j, z, i7, akVar2));
                                    }
                                    akVar2.a(bAJ, 0, this.nUd, iq.kF());
                                    akVar2.nEJ.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g byl = af.byl();
                                    long nanoTime = System.nanoTime() - System.nanoTime();
                                    x.i("MicroMsg.SnsCommentDetailUI", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(ate)), Long.valueOf(nanoTime));
                                    if (com.tencent.mm.plugin.sns.model.g.t(ate)) {
                                        if (byl.u(ate)) {
                                            akVar2.nEI.setVisibility(0);
                                            akVar2.nRD.setVisibility(8);
                                            akVar2.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                            akVar2.nEI.setContentDescription(getString(j.play_sight_desc));
                                        } else if (byl.v(ate)) {
                                            akVar2.nEI.setVisibility(8);
                                            akVar2.nRD.setVisibility(8);
                                        } else if (!iq.kF() || byl.l(iq) > 5) {
                                            byl.y(ate);
                                            akVar2.nEI.setVisibility(0);
                                            akVar2.nRD.setVisibility(8);
                                            akVar2.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                            akVar2.nEI.setContentDescription(getString(j.play_sight_desc));
                                        } else {
                                            akVar2.nEI.setVisibility(8);
                                            akVar2.nRD.setVisibility(8);
                                        }
                                        if (akVar2.neL.bvF()) {
                                            x.d("MicroMsg.SnsCommentDetailUI", "play video error " + ate.ksA + " " + ate.jPK + " " + ate.rVE + " 0");
                                            byl.y(ate);
                                            akVar2.nEI.setVisibility(0);
                                            akVar2.nRD.setVisibility(8);
                                            akVar2.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                            akVar2.nEI.setContentDescription(getString(j.play_sight_desc));
                                        }
                                    } else if (byl.w(ate)) {
                                        akVar2.nEI.setVisibility(8);
                                        akVar2.nRD.setVisibility(0);
                                        akVar2.nRD.cAt();
                                    } else if (iq.kF() && byl.l(iq) == 5) {
                                        byl.A(ate);
                                        akVar2.nEI.setVisibility(8);
                                        akVar2.nRD.setVisibility(0);
                                        akVar2.nRD.cAt();
                                    } else if (byl.x(ate)) {
                                        akVar2.nRD.setVisibility(8);
                                        akVar2.nEI.setImageResource(com.tencent.mm.plugin.sns.i.e.sight_chat_error);
                                        akVar2.nEI.setVisibility(0);
                                    } else {
                                        byl.y(ate);
                                        akVar2.nEI.setVisibility(0);
                                        akVar2.nRD.setVisibility(8);
                                        akVar2.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                        akVar2.nEI.setContentDescription(getString(j.play_sight_desc));
                                        if (!iq.kF() && byl.k(iq) == 4) {
                                            akVar2.nEJ.setVisibility(0);
                                        } else if (iq.kF() && byl.l(iq) == 4) {
                                            akVar2.nEJ.setVisibility(0);
                                        }
                                    }
                                    boolean z2 = iq.kF() ? af.byl().l(iq) == 5 : af.byl().k(iq) == 5;
                                    this.nUq.a(j, z2, z);
                                }
                                i3 = i7 + 1;
                            }
                            xp(i6);
                        }
                    } else {
                        Object obj2;
                        linearLayout = (LinearLayout) this.nTO.findViewById(f.sns_meida_frame);
                        findViewById2 = xo(com.tencent.mm.plugin.sns.i.g.sns_media_link_item);
                        mMImageView = (MMImageView) findViewById2.findViewById(f.image_left);
                        if (!this.nUH) {
                            linearLayout.removeView(this.nUK);
                            linearLayout.addView(findViewById2, 3);
                            if (findViewById2.getLayoutParams() != null) {
                                layoutParams3 = new LinearLayout.LayoutParams(findViewById2.getLayoutParams());
                            } else {
                                layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams3.setMargins(layoutParams3.leftMargin, com.tencent.mm.bp.a.fromDPToPix(this, 12), layoutParams3.rightMargin, layoutParams3.bottomMargin);
                            findViewById2.setLayoutParams(layoutParams3);
                        }
                        Object obj3 = null;
                        if (iq.kF()) {
                            if (iq.bAF().nzp == 2) {
                                obj3 = 1;
                                findViewById2.setTag(iq);
                                findViewById2.setTag(f.link_ad_left_iv, mMImageView);
                                findViewById2.setOnClickListener(this.nUr.ole);
                            }
                            obj2 = null;
                            obj = obj3;
                        } else {
                            if (bAJ.sqc.ruz == 9) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohx);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 10) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohz);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 17) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohA);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 22) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohB);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 23) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohC);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 14) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohy);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 12) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohG);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 13) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUk.ohH);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 15) {
                                if (bAJ.sqc.ruA.size() > 0) {
                                    findViewById2.setTag(new r(bAJ, this.nUd));
                                    findViewById2.setOnClickListener(this.nUr.okT);
                                    obj2 = null;
                                    obj = null;
                                }
                            } else if (bAJ.sqc.ruz == 26) {
                                findViewById2.setTag(new r(bAJ, this.nUd));
                                findViewById2.setOnClickListener(this.nUk.ohI);
                                obj2 = null;
                                obj = null;
                            } else {
                                findViewById2.setTag(new r(bAJ, this.nUd));
                                findViewById2.setOnClickListener(this.nUk.nZN);
                                if ((bAJ.dwt & 1) > 0) {
                                    int obj22 = 1;
                                    obj = null;
                                }
                            }
                            obj22 = null;
                            obj = null;
                        }
                        if (obj != null) {
                            this.contextMenuHelper.a(findViewById2, this.nUr.okO, this.nUr.okv);
                        } else {
                            this.contextMenuHelper.a(findViewById2, this.nUr.okK, this.nUr.okv);
                        }
                        String Oa = bDc() ? av.Oa(bAJ.sqc.jPK) : "";
                        String str3 = bAJ.sqc.bHD;
                        if (obj != null) {
                            str2 = bAJ.sqc.jOS;
                        } else {
                            str2 = Oa;
                        }
                        findViewById2.findViewById(f.state).setVisibility(8);
                        Object obj4;
                        if (!bAJ.sqc.ruA.isEmpty()) {
                            mMImageView.setVisibility(0);
                            ate = (ate) bAJ.sqc.ruA.get(0);
                            if (bAJ.sqc.ruz == 15) {
                                ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.music_playicon);
                                ((ImageView) findViewById2.findViewById(f.state)).setVisibility(0);
                                af.byl().b(ate, mMImageView, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.clT().Dm(bAJ.lOH));
                                Oa = str3;
                                charSequence = str2;
                            } else if (bAJ.sqc.ruz == 5) {
                                str3 = av.Oa(ate.jPK);
                                str2 = ate.bHD;
                                findViewById2.findViewById(f.state).setVisibility(0);
                                af.byl().b(ate, mMImageView, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.tbt);
                                Oa = str2;
                                obj4 = str3;
                            } else if (bAJ.sqc.ruz == 18) {
                                findViewById2.findViewById(f.state).setVisibility(0);
                                ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                                mMImageView.setVisibility(0);
                                af.byl().b(ate, mMImageView, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.tbt);
                                Oa = str3;
                                obj4 = str2;
                            } else {
                                af.byl().b(ate, mMImageView, hashCode(), av.tbt);
                                Oa = str3;
                                obj4 = str2;
                            }
                        } else if (bAJ.sqc.ruz == 18) {
                            ((ImageView) findViewById2.findViewById(f.state)).setVisibility(0);
                            ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                            mMImageView.setVisibility(0);
                            af.byl().a(mMImageView, -1, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode());
                            Oa = str3;
                            obj4 = str2;
                        } else if (bAJ.sqc.ruz == 26) {
                            mMImageView.setVisibility(0);
                            af.byl().a(mMImageView, -1, com.tencent.mm.plugin.sns.i.i.note_sns_link_default, hashCode());
                            Oa = str3;
                            obj4 = str2;
                        } else {
                            mMImageView.setVisibility(0);
                            af.byl().a(mMImageView, -1, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_webpage, hashCode());
                            Oa = str3;
                            obj4 = str2;
                        }
                        com.tencent.mm.plugin.sns.data.i.b(mMImageView, this);
                        if (bAJ.sqc.ruz == 15) {
                            charSequence = "";
                            string2 = getString(j.sns_folder_sight_title);
                        } else {
                            string2 = Oa;
                        }
                        if (bi.oW(charSequence)) {
                            findViewById2.findViewById(f.righttext).setVisibility(8);
                        } else {
                            findViewById2.findViewById(f.righttext).setVisibility(0);
                            ((TextView) findViewById2.findViewById(f.righttext)).setText(charSequence);
                        }
                        textView = (TextView) findViewById2.findViewById(f.titletext);
                        if (bi.oW(string2)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            if (obj22 != null) {
                                textView.setText(com.tencent.mm.plugin.sns.data.i.a(string2, cqa(), textView));
                            } else {
                                textView.setText(string2);
                            }
                        }
                    }
                }
                textView = (TextView) this.nTO.findViewById(f.album_address);
                if (iq.kF()) {
                    charSequence = bAJ.sqa == null ? null : bAJ.sqa.eJJ;
                    string2 = bAJ.sqa == null ? null : bAJ.sqa.kFa;
                    textView.setTag(iq.bBe());
                    if (bi.oW(charSequence) && bi.oW(string2)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        if (bi.oW(string2)) {
                            textView.setText(charSequence);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        } else {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            if (iq.field_snsId != 0 || bi.oW(charSequence)) {
                                textView.setText(string2);
                            } else {
                                textView.setText(charSequence + "·" + string2);
                            }
                        }
                    }
                } else {
                    bAH = iq.bAH();
                    if (bAH != null) {
                        string2 = bAH.nyc;
                        aG = bAH.nyd;
                        textView.setTag(iq.bBe());
                        if (!bi.oW(string2)) {
                            if (bi.oW(aG)) {
                                textView.setVisibility(0);
                            } else {
                                textView.setVisibility(0);
                                if (!bi.oW(string2)) {
                                    textView.setTextColor(-11048043);
                                    textView.setClickable(true);
                                    textView.setText(string2);
                                }
                            }
                            textView.setText(string2);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    }
                    textView.setVisibility(8);
                }
                textView.setOnClickListener(this.nUr.okR);
                ((TextView) this.nTO.findViewById(f.album_publish_time)).setText(az.l(cqa(), ((long) iq.bAX()) * 1000));
                asyncTextView = (AsyncTextView) this.nTO.findViewById(f.album_ad_tail_desc);
                asyncTextView.setOnClickListener(this.nUr.okV);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.nTO.findViewById(f.album_ad_at_tail);
                asyncTextView2.setOnClickListener(new 31(this, iq, Yg));
                asyncTextView2.setVisibility(8);
                if (iq.kF()) {
                    com.tencent.mm.plugin.sns.storage.a bAH2 = iq.bAH();
                    asyncTextView.setTag(iq.bBe());
                    if (bAH2.nye == com.tencent.mm.plugin.sns.storage.a.nxQ) {
                        if (bi.oW(bAH2.nyf)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            asyncTextView.setText(bAH2.nyf);
                            asyncTextView.setVisibility(0);
                        }
                    } else if (bAH2.nye == com.tencent.mm.plugin.sns.storage.a.nxR) {
                        if (bi.oW(bAH2.nyf)) {
                            asyncTextView.setVisibility(8);
                        } else {
                            bBe = "";
                            Iterator it = bAH2.nyh.iterator();
                            while (it.hasNext()) {
                                String str4 = (String) it.next();
                                com.tencent.mm.l.a Yf = this.nUe.Yf(str4);
                                if (Yf != null) {
                                    str2 = Yf.BL();
                                    if (bi.oW(str2)) {
                                        bBe = bBe + str4;
                                    } else {
                                        bBe = bBe + str2;
                                    }
                                } else {
                                    bBe = bBe + str4;
                                }
                                if (bAH2.nyh.getLast() != str4) {
                                    bBe = bBe + ",";
                                }
                            }
                            string2 = String.format(bAH2.nyf, new Object[]{bBe});
                            asyncTextView.getTextSize();
                            com.tencent.mm.pluginsdk.ui.d.k kVar2 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b((Context) this, string2, 1));
                            kVar2.f(null, string2);
                            TextPaint paint = asyncTextView.getPaint();
                            if (com.tencent.mm.bp.a.ag(this, (int) Layout.getDesiredWidth(kVar2, 0, kVar2.length(), paint)) > this.nUp) {
                                while (bBe.length() > 1) {
                                    bBe = bBe.substring(0, bBe.length() - 2);
                                    CharSequence format = String.format(bAH2.nyf, new Object[]{bBe + "..."});
                                    asyncTextView.getTextSize();
                                    com.tencent.mm.pluginsdk.ui.d.k kVar3 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b((Context) this, format, 1));
                                    kVar3.f(null, format);
                                    i2 = com.tencent.mm.bp.a.ag(this, (int) Layout.getDesiredWidth(kVar3, 0, kVar3.length(), paint));
                                    asyncTextView.setText(kVar3, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (i2 <= this.nUp) {
                                        break;
                                    }
                                }
                            }
                            asyncTextView.setText(kVar2, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && bi.oW(bAH2.nyg)) {
                        asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                        asyncTextView.setOnClickListener(null);
                    }
                    if (iq.bAJ().sqc.ruB == 4) {
                        asyncTextView2.setTag(iq.bBe());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{cqa().getResources().getString(j.sns_ad_at_tips1), str, cqa().getResources().getString(j.sns_ad_at_tips2)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView = (TextView) this.nTO.findViewById(f.album_from);
                textView.setOnTouchListener(new ab());
                aG = com.tencent.mm.plugin.sns.c.a.ezo.q(this, bAJ.sqb.ksA);
                if (bAJ.sqc.ruz == 26) {
                    aG = getString(j.favorite);
                }
                av.a(bAJ, this);
                if (com.tencent.mm.plugin.sns.c.a.ezo.cT(aG)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    string2 = new SpannableString(getString(j.sns_comefrome) + aG);
                    string2.setSpan(new a(this), 0, string2.length(), 33);
                    textView.setText(string2, BufferType.SPANNABLE);
                    if (bAJ.sqb == null || !com.tencent.mm.pluginsdk.model.app.g.SS(bAJ.sqb.ksA)) {
                        textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                        textView.setOnTouchListener(null);
                    }
                    textView.setTag(bAJ);
                }
                textView = (TextView) this.nTO.findViewById(f.album_del);
                if (iq.getUserName().equals(this.cXR)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setTag(iq.bBe() + ";" + iq.bAK());
                    textView.setOnClickListener(new 32(this));
                }
                textView = (TextView) this.nTO.findViewById(f.with_info_tv);
                m = aj.m(iq);
                if (m != null) {
                    textView.setVisibility(8);
                } else {
                    if (m.smR.size() <= 0) {
                        textView.setVisibility(8);
                    } else if (!this.cXR.equals(m.rdS)) {
                        textView.setVisibility(8);
                        Iterator it2 = m.smR.iterator();
                        while (it2.hasNext()) {
                            if (this.cXR.equals(((bon) it2.next()).rdS)) {
                                textView.setVisibility(0);
                                charSequence = getString(j.sns_timeline_ui_with_you);
                                textView.setVisibility(0);
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, charSequence, textView.getTextSize()));
                                break;
                            }
                        }
                    } else {
                        textView.setVisibility(0);
                        Iterator it3 = m.smR.iterator();
                        string2 = null;
                        String str5 = "";
                        while (it3.hasNext()) {
                            StringBuilder append;
                            bon bon = (bon) it3.next();
                            if (string2 == null) {
                                obj = 1;
                                str5 = str5 + "  ";
                            } else {
                                str5 = str5 + ",  ";
                                obj = string2;
                            }
                            if (bon.rTW != null) {
                                append = new StringBuilder().append(str5);
                                aG = bon.rTW;
                            } else {
                                com.tencent.mm.l.a Yg2 = this.nUe.Yg(bon.rdS);
                                append = new StringBuilder().append(str5);
                                aG = Yg2 == null ? bon.rdS : Yg2.BL();
                            }
                            string2 = obj;
                            str5 = append.append(aG).toString();
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, getString(j.sns_timeline_ui_with_to, new Object[]{str5}), textView.getTextSize()));
                    }
                    if (m == null || this.cXR == null || !this.cXR.equals(m.rdS) || ((m.rXx != 3 || m.smW == null) && (m.rXx != 5 || m.rWm == null))) {
                        this.nTO.findViewById(f.album_groupid).setVisibility(8);
                    } else {
                        this.nTO.findViewById(f.album_groupid).setVisibility(0);
                        this.nTO.findViewById(f.album_groupid).setTag(Integer.valueOf(iq.nJc));
                        this.nTO.findViewById(f.album_groupid).setOnClickListener(new 33(this));
                    }
                }
                this.nTV = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.nTV.setDuration(150);
                this.nTW = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.nTW.setDuration(150);
                if (this.nTT == null) {
                    this.nTT = this.nTO.findViewById(f.album_comment_container);
                    this.nTT.setVisibility(8);
                }
                this.nTX = (LinearLayout) this.nTO.findViewById(f.album_comment_li);
                this.nTX.setOnClickListener(new 35(this, iq));
                this.nTX.setOnTouchListener(this.nNj);
                this.nTY = (LinearLayout) this.nTO.findViewById(f.album_like_img);
                this.nTY.setOnClickListener(new 36(this, iq, bAJ));
                this.nTY.setOnTouchListener(this.nNj);
                imageButton = (ImageButton) this.nTO.findViewById(f.album_show_comment_tv);
                iq2 = iq(true);
                if (!(iq2 == null || (iq2.bAZ() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(iq2 == null || iq2.bBd())) {
                    imageButton.setVisibility(8);
                }
                imageView2 = (ImageView) this.nTY.findViewById(f.album_like_icon);
                imageView3 = (ImageView) this.nTX.findViewById(f.album_comment_icon);
                textView2 = (TextView) this.nTY.findViewById(f.album_like_tv);
                textView3 = (TextView) this.nTX.findViewById(f.album_comment_tv);
                if (this.hER == 11) {
                    this.nTO.findViewById(f.album_comment_container).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_frame_bg_golden);
                    imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_icon);
                    imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_likeicon);
                    imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_writeicon);
                    textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
                    textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
                    this.nTY.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.lucky_sns_comment_btn_left);
                    this.nTX.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.lucky_sns_comment_btn_right);
                }
                imageButton.setOnClickListener(new 37(this, iq, textView2, textView3, imageView2, imageView3));
                return true;
            }
        }
        str = aG;
        str.length();
        if (this.hER != 11) {
        }
        kVar = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, (CharSequence) str));
        kVar.f(new o(new com.tencent.mm.plugin.sns.data.a(iq.kF(), Yg.getUsername(), iq.bBe(), 2), this.nUh, i), str);
        textView.setOnTouchListener(new ab());
        textView.setText(kVar, BufferType.SPANNABLE);
        ((TextView) this.nTO.findViewById(f.type_desc_tv)).setText("");
        this.nUN = new bf(this.nTO);
        if (iq.kF()) {
            this.nUN.setVisibility(8);
        } else {
            this.nUN.r(Long.valueOf(iq.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.nUN, 0, this.nUd, iq.field_snsId, iq.bBn()));
            this.nUN.a(iq.bAF(), iq.bAH());
            this.nUN.a(this.nUr.okG, this.nUr.okU);
            this.nUN.setVisibility(0);
        }
        str2 = bAJ.spZ;
        this.nTP = (TextView) this.nTO.findViewById(f.desc_tv);
        this.nTP.setTag(new as(this.bSZ, iq.bBe(), true, false, 2));
        this.contextMenuHelper.a(this.nTP, this.nUr.oky, this.nUr.okv);
        this.nTO.findViewById(f.card_btn_container).setVisibility(8);
        findViewById = this.nTO.findViewById(f.card_weapp_tag);
        findViewById.setVisibility(8);
        if (iq.kF()) {
        }
        aG = str2;
        if (aG != null) {
        }
        this.nTP.setVisibility(8);
        av.e(bAJ);
        viewStub = (ViewStub) this.nTO.findViewById(f.images_keeper_li);
        if (this.nUJ) {
            if (this.hER == 2) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline_one);
            } else if (this.hER == 3) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline1);
            } else if (this.hER == 4) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline2);
            } else if (this.hER == 5) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_imagesline3);
            } else if (this.hER != 6) {
                if (this.hER == 1 || this.hER == 0) {
                    viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_media_sub_item2);
                } else if (this.hER == 9) {
                    viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_media_sight_item);
                } else if (this.hER == 11) {
                    viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_hb_reward_item);
                } else if (this.hER == 12) {
                    viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.sns_timeline_turn_media);
                }
            }
            if (this.hER == 2 || this.hER == 3 || this.hER == 4 || this.hER == 5) {
                this.nUK = (PhotosContent) viewStub.inflate();
            } else if (this.hER == 9) {
                viewStub.inflate();
            } else if (this.hER == 11) {
                this.nUK = (PhotosContent) viewStub.inflate();
            } else if (this.hER == 12) {
                viewStub.inflate();
            } else {
                viewStub.setVisibility(8);
            }
            this.nUJ = true;
        }
        if (this.hER != 6) {
            int i32;
            TagImageView tagImageView2;
            RelativeLayout.LayoutParams layoutParams22;
            float a5;
            float a22;
            float fromDPToPix2;
            int i42;
            ar arVar2;
            PhotosContent photosContent2;
            View findViewById22;
            boolean z3;
            ViewGroup.LayoutParams layoutParams32;
            ate ate4;
            MMImageView mMImageView2;
            if (this.hER == 2 || this.hER == 3 || this.hER == 4 || this.hER == 5) {
                if (this.nUK != null) {
                    this.nUK.bCz();
                    i32 = 0;
                    while (true) {
                        i = i32;
                        if (i >= ar.nYx[this.hER]) {
                            break;
                        }
                        tagImageView2 = (TagImageView) this.nUK.findViewById(ar.nYB[i]);
                        this.nUK.a(tagImageView2);
                        tagImageView2.setOnClickListener(this.nUr.nNR);
                        this.contextMenuHelper.a(tagImageView2, this.nUr.okJ, this.nUr.okv);
                        i32 = i + 1;
                    }
                    this.nUK.setImageViewWidth(this.nUm);
                    List linkedList2 = new LinkedList();
                    if (iq.kF() && this.hER == 2) {
                        com.tencent.mm.plugin.sns.storage.b bAF22 = iq.bAF();
                        if (bAF22 != null && bAF22.nzp == 1) {
                            ate ate22;
                            i = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                            if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                                ate22 = null;
                            } else {
                                ate22 = (ate) bAJ.sqc.ruA.get(0);
                            }
                            i = (((i - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 20);
                            i32 = (int) ((ate22.rVH.rWv * ((float) i)) / ate22.rVH.rWu);
                            atg atg4 = new atg();
                            atg4.rWu = (float) i;
                            atg4.rWv = (float) i32;
                            atg4.rWw = atg4.rWu * atg4.rWv;
                            linkedList2.add(atg4);
                            layoutParams22 = (RelativeLayout.LayoutParams) this.nUK.getLayoutParams();
                            layoutParams22.leftMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                            layoutParams22.rightMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                            this.nUK.setLayoutParams(layoutParams22);
                            C(iq);
                            this.nTO.findViewById(f.images_keeper_lieaner_layout).setTag(this.nUK.xm(0));
                            this.nTO.findViewById(f.images_keeper_lieaner_layout).setOnClickListener(this.nUr.olb);
                            i32 = 0;
                            while (true) {
                                i = i32;
                                if (i >= ar.nYx[this.hER]) {
                                    break;
                                }
                                this.contextMenuHelper.a((TagImageView) this.nUK.findViewById(ar.nYB[i]), this.nUr.okN, this.nUr.okv);
                                i32 = i + 1;
                            }
                            this.nTO.findViewById(f.card_btn_left).setTag(this.nUK.xm(0));
                            this.nTO.findViewById(f.card_btn_right).setTag(this.nUK.xm(0));
                        } else if (bAF22 != null && bAF22.nzf > 0.0f && bAF22.nzg > 0.0f) {
                            a5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF22.nzf, 1, bAF22.nzh, bAF22.nzi);
                            a22 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF22.nzg, 1, bAF22.nzh, bAF22.nzi);
                            atg atg22;
                            if (bAF22.nze == 0) {
                                i32 = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                                if (a5 >= ((float) (((i32 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)))) {
                                    fromDPToPix2 = (float) (((i32 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12));
                                    a22 = (float) ((int) ((bAF22.nzg * fromDPToPix2) / bAF22.nzf));
                                } else {
                                    fromDPToPix2 = a5;
                                }
                                atg atg32 = new atg();
                                atg32.rWu = fromDPToPix2;
                                atg32.rWv = a22;
                                atg32.rWw = atg32.rWu * atg32.rWv;
                                linkedList2.add(atg32);
                            } else if (bAF22.nze == 1) {
                                i32 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                i42 = (int) ((((float) i32) * bAF22.nzg) / bAF22.nzf);
                                atg22 = new atg();
                                if (i32 > 0) {
                                    a5 = (float) i32;
                                }
                                atg22.rWu = a5;
                                if (i42 > 0) {
                                    a22 = (float) i42;
                                }
                                atg22.rWv = a22;
                                atg22.rWw = atg22.rWu * atg22.rWv;
                                linkedList2.add(atg22);
                            } else if (bAF22.nze == 2) {
                                i32 = ((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                                i42 = (int) ((((float) i32) * bAF22.nzg) / bAF22.nzf);
                                atg22 = new atg();
                                if (i32 > 0) {
                                    a5 = (float) i32;
                                }
                                atg22.rWu = a5;
                                if (i42 > 0) {
                                    a22 = (float) i42;
                                }
                                atg22.rWv = a22;
                                atg22.rWw = atg22.rWu * atg22.rWv;
                                linkedList2.add(atg22);
                            }
                        }
                        if (!bi.oW(bAF22.nzk)) {
                            d.b("adId", bAF22.nzk, false, 41, new 21(this, this.nUK, bAF22, this.nUK.xm(0)));
                        }
                    }
                    this.nTO.addOnAttachStateChangeListener(new 22(this, bAJ, iq, linkedList2));
                    arVar2 = this.nUc;
                    photosContent2 = this.nUK;
                    bBe = iq.bBe();
                    i42 = hashCode();
                    i2 = this.hER;
                    iq.xb(32);
                    arVar2.a(photosContent2, bAJ, bBe, i42, i2, -1, false, av.tbt, linkedList2);
                } else {
                    x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.hER + ",stub is " + viewStub.toString());
                }
            } else if (this.hER == 11) {
                this.nUK.bCz();
                tagImageView2 = (TagImageView) this.nUK.findViewById(f.album_img_0);
                this.nUK.a(tagImageView2);
                tagImageView2.setOnClickListener(this.nUr.nNR);
                aG = iq.bBe();
                List arrayList2 = new ArrayList();
                arrayList2.add(tagImageView2);
                ap apVar3 = new ap();
                apVar3.bNH = aG;
                apVar3.index = 0;
                apVar3.nWx = arrayList2;
                apVar3.nTx = true;
                if (tagImageView2 != null) {
                    tagImageView2.setTag(apVar3);
                }
                textView = (TextView) this.nTO.findViewById(f.hb_tip);
                if (com.tencent.mm.model.q.GF().equals(bAJ.hbL)) {
                    textView.setVisibility(8);
                } else {
                    boy n2 = aj.n(iq);
                    if (n2.smZ == null || n2.smZ.snB == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(getString(j.lucky_sns_reward_numbers, new Object[]{Integer.valueOf(n2.smZ.snB)}));
                        textView.setVisibility(0);
                    }
                }
                atf bAW2 = iq.bAW();
                if (bAW2 == null) {
                    x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + iq.bBe());
                } else if (com.tencent.mm.model.q.GF().equals(bAJ.hbL)) {
                    arVar2 = this.nUc;
                    photosContent2 = this.nUK;
                    bBe = iq.bBe();
                    i42 = hashCode();
                    i2 = this.hER;
                    iq.xb(32);
                    arVar2.a(photosContent2, bAJ, bBe, i42, i2, -1, false, av.tbt, true);
                } else if (com.tencent.mm.plugin.sns.lucky.a.m.h(iq)) {
                    arVar2 = this.nUc;
                    photosContent2 = this.nUK;
                    bBe = iq.bBe();
                    i42 = hashCode();
                    i2 = this.hER;
                    iq.xb(32);
                    arVar2.a(photosContent2, bAJ, bBe, i42, i2, -1, false, av.tbt, false);
                } else if (bAW2.ceS == 0) {
                    arVar2 = this.nUc;
                    photosContent2 = this.nUK;
                    bBe = iq.bBe();
                    i42 = hashCode();
                    i2 = this.hER;
                    iq.xb(32);
                    arVar2.a(photosContent2, bAJ, bBe, i42, i2, -1, false, av.tbt, true);
                } else {
                    x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + bAW2.ceS);
                }
            } else if (this.hER == 9) {
                ate ate32;
                this.nUv = true;
                ak akVar3 = new ak();
                View view2 = this.nTO;
                findViewById22 = view2.findViewById(f.chatting_click_area);
                com.tencent.mm.plugin.sight.decode.a.a aVar2 = (com.tencent.mm.plugin.sight.decode.a.a) view2.findViewById(f.image);
                akVar3.nRC = findViewById22;
                akVar3.nEI = (ImageView) view2.findViewById(f.status_btn);
                akVar3.nRD = (MMPinProgressBtn) view2.findViewById(f.progress);
                akVar3.nEJ = (TextView) view2.findViewById(f.errorTv);
                akVar3.nRE = (TextView) view2.findViewById(f.endtv);
                akVar3.neL = aVar2;
                akVar3.a(bAJ, 0, iq.bBe(), iq.kF());
                akVar3.nEJ.setVisibility(8);
                akVar3.neL.setTagObject(akVar3);
                findViewById22.setTag(akVar3);
                akVar3.nRC.setOnClickListener(this.nUr.okS);
                if (iq.bzr()) {
                    this.contextMenuHelper.a(findViewById22, this.nUr.okN, this.nUr.okv);
                } else {
                    this.contextMenuHelper.a(findViewById22, this.nUr.okL, this.nUr.okv);
                }
                Pair a32 = com.tencent.mm.modelsns.e.a(bAJ, akVar3.neL.getUIContext(), iq.kF());
                if (iq.kF()) {
                    com.tencent.mm.plugin.sns.storage.b bAF32 = iq.bAF();
                    if (bAF32 != null && bAF32.nzp == 1) {
                        if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                            ate32 = null;
                        } else {
                            ate32 = (ate) bAJ.sqc.ruA.get(0);
                        }
                        if (ate32 != null) {
                            i32 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 20);
                            a32 = Pair.create(Integer.valueOf(i32), Integer.valueOf((int) ((((float) i32) * ate32.rVH.rWv) / ate32.rVH.rWu)));
                        }
                        LinearLayout.LayoutParams layoutParams42 = (LinearLayout.LayoutParams) akVar3.nRC.getLayoutParams();
                        layoutParams42.leftMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                        layoutParams42.rightMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                        akVar3.nRC.setLayoutParams(layoutParams42);
                        C(iq);
                        this.nTO.findViewById(f.images_keeper_lieaner_layout).setTag(akVar3);
                        this.nTO.findViewById(f.images_keeper_lieaner_layout).setOnClickListener(this.nUr.olb);
                        this.nTO.findViewById(f.card_btn_left).setTag(akVar3);
                        this.nTO.findViewById(f.card_btn_right).setTag(akVar3);
                    } else if (bAF32 != null && bAF32.nzf > 0.0f && bAF32.nzg > 0.0f) {
                        float a42 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF32.nzf, 1, bAF32.nzh, bAF32.nzi);
                        a22 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bAF32.nzg, 1, bAF32.nzh, bAF32.nzi);
                        if (bAF32.nze == 0) {
                            i32 = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth();
                            if (a42 >= ((float) (((i32 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)))) {
                                a5 = (float) (((i32 - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12));
                                fromDPToPix2 = (float) ((int) ((bAF32.nzg * a5) / bAF32.nzf));
                            } else {
                                fromDPToPix2 = a22;
                                a5 = a42;
                            }
                            a32 = Pair.create(Integer.valueOf((int) a5), Integer.valueOf((int) fromDPToPix2));
                        } else if (bAF32.nze == 1) {
                            i32 = (((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                            a32 = Pair.create(Integer.valueOf(i32), Integer.valueOf((int) ((((float) i32) * bAF32.nzg) / bAF32.nzf)));
                        } else if (bAF32.nze == 2) {
                            i32 = ((((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 50)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12)) - com.tencent.mm.bp.a.fromDPToPix(cqa(), 12);
                            a32 = Pair.create(Integer.valueOf(i32), Integer.valueOf((int) ((((float) i32) * bAF32.nzg) / bAF32.nzf)));
                        }
                    }
                }
                if (a32 != null) {
                    aVar2.dt(((Integer) a32.first).intValue(), ((Integer) a32.second).intValue());
                    layoutParams = akVar3.nRE.getLayoutParams();
                    layoutParams.width = ((Integer) a32.first).intValue();
                    layoutParams.height = ((Integer) a32.second).intValue();
                    akVar3.nRE.setLayoutParams(layoutParams);
                }
                if (bAJ.sqc == null || bAJ.sqc.ruA.size() <= 0) {
                    ate32 = null;
                } else {
                    ate32 = (ate) bAJ.sqc.ruA.get(0);
                }
                if (iq.kF()) {
                    akVar3.neL.setOnCompletionListener(new 24(this, iq));
                    if (!this.nUq.ey(iq.field_snsId)) {
                        akVar3.neL.setOnDecodeDurationListener(new 25(this, iq, akVar3));
                    }
                }
                if (bAJ.sqc != null && bAJ.sqc.ruA.size() > 0) {
                    af.byl();
                    if (com.tencent.mm.plugin.sns.model.g.t(ate32)) {
                        if (af.byl().u(ate32)) {
                            akVar3.nEI.setVisibility(0);
                            akVar3.nRD.setVisibility(8);
                            akVar3.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                        } else if (af.byl().v(ate32)) {
                            akVar3.nEI.setVisibility(8);
                            akVar3.nRD.setVisibility(8);
                        } else if (!iq.kF() || af.byl().l(iq) > 5) {
                            af.byl().y(ate32);
                            akVar3.nEI.setVisibility(0);
                            akVar3.nRD.setVisibility(8);
                            akVar3.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                        } else {
                            akVar3.nEI.setVisibility(8);
                            akVar3.nRD.setVisibility(8);
                        }
                        if (akVar3.neL.bvF()) {
                            x.d("MicroMsg.SnsCommentDetailUI", "play video error " + ate32.ksA + " " + ate32.jPK + " " + ate32.rVE);
                            af.byl().y(ate32);
                            akVar3.nEI.setVisibility(0);
                            akVar3.nRD.setVisibility(8);
                            akVar3.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                        }
                    } else if (af.byl().w(ate32)) {
                        akVar3.nEI.setVisibility(8);
                        akVar3.nRD.setVisibility(0);
                        akVar3.nRD.cAt();
                    } else if (iq.kF() && af.byl().l(iq) == 5) {
                        af.byl().A(ate32);
                        akVar3.nEI.setVisibility(8);
                        akVar3.nRD.setVisibility(0);
                        akVar3.nRD.cAt();
                    } else {
                        af.byl().y(ate32);
                        akVar3.nEI.setVisibility(0);
                        akVar3.nRD.setVisibility(8);
                        akVar3.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                    }
                    aVar2.setTagObject(akVar3);
                    af.byl().a(iq, ate32, aVar2, hashCode(), 0, av.tbt, iq.kF());
                    findViewById22.setTag(akVar3);
                    if (this.nUq != null) {
                        z3 = iq.kF() ? af.byl().l(iq) == 5 : af.byl().k(iq) == 5;
                        this.nUq.q(iq.field_snsId, z3);
                    }
                }
            } else if (this.hER == 0) {
                linearLayout = (LinearLayout) this.nTO.findViewById(f.sns_meida_frame);
                View xo2 = xo(com.tencent.mm.plugin.sns.i.g.sns_media_sub_item);
                if (!this.nUH) {
                    linearLayout.removeView(this.nUK);
                    linearLayout.addView(xo2, 3);
                    if (xo2.getLayoutParams() != null) {
                        layoutParams32 = new LinearLayout.LayoutParams(xo2.getLayoutParams());
                    } else {
                        layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                    }
                    layoutParams32.setMargins(layoutParams32.leftMargin, com.tencent.mm.bp.a.fromDPToPix(this, 12), layoutParams32.rightMargin, layoutParams32.bottomMargin);
                    xo2.setLayoutParams(layoutParams32);
                }
                if (bAJ.sqc.ruA.isEmpty()) {
                    xo2.setVisibility(8);
                } else {
                    ate4 = (ate) bAJ.sqc.ruA.get(0);
                    mMImageView2 = (MMImageView) xo2.findViewById(f.image_left);
                    af.byl().b(ate4, mMImageView2, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_music, hashCode(), av.tbt);
                    this.nUg = (ImageView) xo2.findViewById(f.state);
                    this.nUg.setOnTouchListener(this.nNj);
                    this.lxx = bAJ.ksA;
                    bDf();
                    mMImageView2.setTag(new r(bAJ, this.nUd, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                    mMImageView2.setOnClickListener(this.nUk.ohD);
                    CharSequence charSequence22 = ate4.jOS;
                    if (!bi.oW(charSequence22)) {
                        ((TextView) xo2.findViewById(f.righttext)).setText(charSequence22);
                    }
                    charSequence = ate4.bHD;
                    if (!bi.oW(charSequence)) {
                        ((TextView) xo2.findViewById(f.titletext)).setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                    }
                    xo2.setTag(new r(bAJ, this.nUd));
                    this.contextMenuHelper.a(xo2, this.nUr.okK, this.nUr.okv);
                    xo2.setOnClickListener(this.nUk.nZN);
                    com.tencent.mm.plugin.sns.data.i.b(mMImageView2, this);
                }
            } else if (this.hER == 12) {
                int width2 = ((WindowManager) cqa().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(cqa(), 82);
                View findViewById32 = this.nTO.findViewById(f.turn_media_container);
                layoutParams22 = (RelativeLayout.LayoutParams) findViewById32.getLayoutParams();
                layoutParams22.topMargin = com.tencent.mm.bp.a.fromDPToPix(cqa(), 10);
                layoutParams22.bottomMargin = 0;
                layoutParams22.width = width2;
                layoutParams22.height = width2;
                if (findViewById32.getParent() instanceof ViewGroup) {
                    ((ViewGroup) findViewById32.getParent()).setClipChildren(false);
                    ((ViewGroup) findViewById32.getParent()).setClipToPadding(false);
                }
                int[] iArr2 = new int[]{f.turn_media_type_img_0, f.turn_media_type_img_1};
                int i52 = f.turn_media_type_sight_0;
                i32 = 0;
                while (true) {
                    i = i32;
                    if (i >= 2) {
                        break;
                    }
                    MaskImageView maskImageView3 = (MaskImageView) findViewById32.findViewById(iArr2[i]);
                    maskImageView3.setVisibility(8);
                    maskImageView3.setOnTouchListener(new 26(this));
                    i32 = i + 1;
                }
                View findViewById42 = findViewById32.findViewById(i52);
                findViewById42.setBackground(null);
                findViewById42.setVisibility(8);
                ((ViewGroup) findViewById42).setClipChildren(false);
                ak akVar22 = new ak();
                akVar22.nRC = findViewById42;
                akVar22.nRB = akVar22.nRC;
                akVar22.neL = (com.tencent.mm.plugin.sight.decode.a.a) akVar22.nRC.findViewById(f.image);
                akVar22.nEI = (ImageView) akVar22.nRC.findViewById(f.status_btn);
                akVar22.nRD = (MMPinProgressBtn) akVar22.nRC.findViewById(f.progress);
                akVar22.nRE = (TextView) akVar22.nRC.findViewById(f.endtv);
                akVar22.nEJ = (TextView) akVar22.nRC.findViewById(f.errorTv);
                akVar22.nRC.setTag(akVar22);
                akVar22.nRC.setOnClickListener(null);
                ((SightPlayImageView) akVar22.neL).bvU();
                ((SightPlayImageView) akVar22.neL).setScaleType(QImageView.a.uHR);
                akVar22.neL.dt(width2, width2);
                findViewById32.setLayerType(2, null);
                if (iq.bAJ().sqc.ruA.size() >= 2) {
                    int i62;
                    if (iq.field_likeFlag == 1) {
                        i62 = 1;
                    } else {
                        i62 = 0;
                    }
                    i32 = 0;
                    while (true) {
                        int i72 = i32;
                        if (i72 >= 2) {
                            break;
                        }
                        ate4 = (ate) iq.bAJ().sqc.ruA.get(i72);
                        MaskImageView maskImageView22 = (MaskImageView) findViewById32.findViewById(iArr2[i72]);
                        ViewGroup.LayoutParams layoutParams52 = maskImageView22.getLayoutParams();
                        ap apVar22 = new ap();
                        apVar22.bNH = this.nUd;
                        apVar22.index = i72;
                        apVar22.nTx = false;
                        apVar22.nRF = true;
                        apVar22.position = 0;
                        maskImageView22.setTag(apVar22);
                        if (ate4.hcE == 2) {
                            af.byl().a(ate4, maskImageView22, -1, hashCode(), av.clX().Dm(bAJ.lOH), 3);
                        } else {
                            af.byl().a(ate4, maskImageView22, hashCode(), av.clX().Dm(bAJ.lOH));
                        }
                        maskImageView22.setScaleType(QImageView.a.uHR);
                        layoutParams52.width = width2;
                        layoutParams52.height = width2;
                        if (i62 == i72 && ate4.hcE == 2) {
                            maskImageView22.setVisibility(0);
                            maskImageView22.setOnClickListener(new 27(this, i62, iq));
                        } else {
                            maskImageView22.setOnClickListener(null);
                        }
                        if (ate4.hcE == 6 && i62 == i72) {
                            z3 = i62 > 0;
                            long j2 = iq.field_snsId;
                            this.nUv = true;
                            layoutParams = findViewById42.getLayoutParams();
                            layoutParams.width = width2;
                            layoutParams.height = width2;
                            findViewById42.setVisibility(0);
                            af.byl().a(iq, ate4, akVar22.neL, hashCode(), 0, av.tbt, iq.kF(), true);
                            akVar22.nRF = true;
                            akVar22.nRG = i72;
                            akVar22.nRA = bAJ;
                            akVar22.position = 0;
                            akVar22.bKW = this.nUd;
                            akVar22.nRC.setOnClickListener(new 28(this, z3, iq));
                            akVar22.neL.setOnCompletionListener(new 29(this, j2, z3));
                            if (this.nUq.ey(((long) i72) + j2)) {
                                this.nUq.b(j2, bi.VG(), z3);
                            } else {
                                akVar22.neL.setOnDecodeDurationListener(new 30(this, j2, z3, i72, akVar22));
                            }
                            akVar22.a(bAJ, 0, this.nUd, iq.kF());
                            akVar22.nEJ.setVisibility(8);
                            com.tencent.mm.plugin.sns.model.g byl2 = af.byl();
                            long nanoTime2 = System.nanoTime() - System.nanoTime();
                            x.i("MicroMsg.SnsCommentDetailUI", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(ate4)), Long.valueOf(nanoTime2));
                            if (com.tencent.mm.plugin.sns.model.g.t(ate4)) {
                                if (byl2.u(ate4)) {
                                    akVar22.nEI.setVisibility(0);
                                    akVar22.nRD.setVisibility(8);
                                    akVar22.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                    akVar22.nEI.setContentDescription(getString(j.play_sight_desc));
                                } else if (byl2.v(ate4)) {
                                    akVar22.nEI.setVisibility(8);
                                    akVar22.nRD.setVisibility(8);
                                } else if (!iq.kF() || byl2.l(iq) > 5) {
                                    byl2.y(ate4);
                                    akVar22.nEI.setVisibility(0);
                                    akVar22.nRD.setVisibility(8);
                                    akVar22.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                    akVar22.nEI.setContentDescription(getString(j.play_sight_desc));
                                } else {
                                    akVar22.nEI.setVisibility(8);
                                    akVar22.nRD.setVisibility(8);
                                }
                                if (akVar22.neL.bvF()) {
                                    x.d("MicroMsg.SnsCommentDetailUI", "play video error " + ate4.ksA + " " + ate4.jPK + " " + ate4.rVE + " 0");
                                    byl2.y(ate4);
                                    akVar22.nEI.setVisibility(0);
                                    akVar22.nRD.setVisibility(8);
                                    akVar22.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                    akVar22.nEI.setContentDescription(getString(j.play_sight_desc));
                                }
                            } else if (byl2.w(ate4)) {
                                akVar22.nEI.setVisibility(8);
                                akVar22.nRD.setVisibility(0);
                                akVar22.nRD.cAt();
                            } else if (iq.kF() && byl2.l(iq) == 5) {
                                byl2.A(ate4);
                                akVar22.nEI.setVisibility(8);
                                akVar22.nRD.setVisibility(0);
                                akVar22.nRD.cAt();
                            } else if (byl2.x(ate4)) {
                                akVar22.nRD.setVisibility(8);
                                akVar22.nEI.setImageResource(com.tencent.mm.plugin.sns.i.e.sight_chat_error);
                                akVar22.nEI.setVisibility(0);
                            } else {
                                byl2.y(ate4);
                                akVar22.nEI.setVisibility(0);
                                akVar22.nRD.setVisibility(8);
                                akVar22.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.sns.i.i.shortvideo_play_btn));
                                akVar22.nEI.setContentDescription(getString(j.play_sight_desc));
                                if (!iq.kF() && byl2.k(iq) == 4) {
                                    akVar22.nEJ.setVisibility(0);
                                } else if (iq.kF() && byl2.l(iq) == 4) {
                                    akVar22.nEJ.setVisibility(0);
                                }
                            }
                            boolean z22 = iq.kF() ? af.byl().l(iq) == 5 : af.byl().k(iq) == 5;
                            this.nUq.a(j2, z22, z3);
                        }
                        i32 = i72 + 1;
                    }
                    xp(i62);
                }
            } else {
                Object obj222;
                linearLayout = (LinearLayout) this.nTO.findViewById(f.sns_meida_frame);
                findViewById22 = xo(com.tencent.mm.plugin.sns.i.g.sns_media_link_item);
                mMImageView2 = (MMImageView) findViewById22.findViewById(f.image_left);
                if (!this.nUH) {
                    linearLayout.removeView(this.nUK);
                    linearLayout.addView(findViewById22, 3);
                    if (findViewById22.getLayoutParams() != null) {
                        layoutParams32 = new LinearLayout.LayoutParams(findViewById22.getLayoutParams());
                    } else {
                        layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
                    }
                    layoutParams32.setMargins(layoutParams32.leftMargin, com.tencent.mm.bp.a.fromDPToPix(this, 12), layoutParams32.rightMargin, layoutParams32.bottomMargin);
                    findViewById22.setLayoutParams(layoutParams32);
                }
                Object obj32 = null;
                if (iq.kF()) {
                    if (iq.bAF().nzp == 2) {
                        obj32 = 1;
                        findViewById22.setTag(iq);
                        findViewById22.setTag(f.link_ad_left_iv, mMImageView2);
                        findViewById22.setOnClickListener(this.nUr.ole);
                    }
                    obj222 = null;
                    obj = obj32;
                } else {
                    if (bAJ.sqc.ruz == 9) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohx);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 10) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohz);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 17) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohA);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 22) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohB);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 23) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohC);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 14) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohy);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 12) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohG);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 13) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUk.ohH);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 15) {
                        if (bAJ.sqc.ruA.size() > 0) {
                            findViewById22.setTag(new r(bAJ, this.nUd));
                            findViewById22.setOnClickListener(this.nUr.okT);
                            obj222 = null;
                            obj = null;
                        }
                    } else if (bAJ.sqc.ruz == 26) {
                        findViewById22.setTag(new r(bAJ, this.nUd));
                        findViewById22.setOnClickListener(this.nUk.ohI);
                        obj222 = null;
                        obj = null;
                    } else {
                        findViewById22.setTag(new r(bAJ, this.nUd));
                        findViewById22.setOnClickListener(this.nUk.nZN);
                        if ((bAJ.dwt & 1) > 0) {
                            int obj2222 = 1;
                            obj = null;
                        }
                    }
                    obj2222 = null;
                    obj = null;
                }
                if (obj != null) {
                    this.contextMenuHelper.a(findViewById22, this.nUr.okO, this.nUr.okv);
                } else {
                    this.contextMenuHelper.a(findViewById22, this.nUr.okK, this.nUr.okv);
                }
                String Oa2 = bDc() ? av.Oa(bAJ.sqc.jPK) : "";
                String str32 = bAJ.sqc.bHD;
                if (obj != null) {
                    str2 = bAJ.sqc.jOS;
                } else {
                    str2 = Oa2;
                }
                findViewById22.findViewById(f.state).setVisibility(8);
                Object obj42;
                if (!bAJ.sqc.ruA.isEmpty()) {
                    mMImageView2.setVisibility(0);
                    ate4 = (ate) bAJ.sqc.ruA.get(0);
                    if (bAJ.sqc.ruz == 15) {
                        ((ImageView) findViewById22.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.music_playicon);
                        ((ImageView) findViewById22.findViewById(f.state)).setVisibility(0);
                        af.byl().b(ate4, mMImageView2, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.clT().Dm(bAJ.lOH));
                        Oa2 = str32;
                        charSequence = str2;
                    } else if (bAJ.sqc.ruz == 5) {
                        str32 = av.Oa(ate4.jPK);
                        str2 = ate4.bHD;
                        findViewById22.findViewById(f.state).setVisibility(0);
                        af.byl().b(ate4, mMImageView2, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.tbt);
                        Oa2 = str2;
                        obj42 = str32;
                    } else if (bAJ.sqc.ruz == 18) {
                        findViewById22.findViewById(f.state).setVisibility(0);
                        ((ImageView) findViewById22.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                        mMImageView2.setVisibility(0);
                        af.byl().b(ate4, mMImageView2, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode(), av.tbt);
                        Oa2 = str32;
                        obj42 = str2;
                    } else {
                        af.byl().b(ate4, mMImageView2, hashCode(), av.tbt);
                        Oa2 = str32;
                        obj42 = str2;
                    }
                } else if (bAJ.sqc.ruz == 18) {
                    ((ImageView) findViewById22.findViewById(f.state)).setVisibility(0);
                    ((ImageView) findViewById22.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.video_playicon_normal);
                    mMImageView2.setVisibility(0);
                    af.byl().a(mMImageView2, -1, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, hashCode());
                    Oa2 = str32;
                    obj42 = str2;
                } else if (bAJ.sqc.ruz == 26) {
                    mMImageView2.setVisibility(0);
                    af.byl().a(mMImageView2, -1, com.tencent.mm.plugin.sns.i.i.note_sns_link_default, hashCode());
                    Oa2 = str32;
                    obj42 = str2;
                } else {
                    mMImageView2.setVisibility(0);
                    af.byl().a(mMImageView2, -1, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_webpage, hashCode());
                    Oa2 = str32;
                    obj42 = str2;
                }
                com.tencent.mm.plugin.sns.data.i.b(mMImageView2, this);
                if (bAJ.sqc.ruz == 15) {
                    charSequence = "";
                    string2 = getString(j.sns_folder_sight_title);
                } else {
                    string2 = Oa2;
                }
                if (bi.oW(charSequence)) {
                    findViewById22.findViewById(f.righttext).setVisibility(8);
                } else {
                    findViewById22.findViewById(f.righttext).setVisibility(0);
                    ((TextView) findViewById22.findViewById(f.righttext)).setText(charSequence);
                }
                textView = (TextView) findViewById22.findViewById(f.titletext);
                if (bi.oW(string2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    if (obj2222 != null) {
                        textView.setText(com.tencent.mm.plugin.sns.data.i.a(string2, cqa(), textView));
                    } else {
                        textView.setText(string2);
                    }
                }
            }
        }
        textView = (TextView) this.nTO.findViewById(f.album_address);
        if (iq.kF()) {
            charSequence = bAJ.sqa == null ? null : bAJ.sqa.eJJ;
            string2 = bAJ.sqa == null ? null : bAJ.sqa.kFa;
            textView.setTag(iq.bBe());
            if (bi.oW(charSequence) && bi.oW(string2)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                if (bi.oW(string2)) {
                    textView.setText(charSequence);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                } else {
                    textView.setTextColor(-11048043);
                    textView.setClickable(true);
                    if (iq.field_snsId != 0 || bi.oW(charSequence)) {
                        textView.setText(string2);
                    } else {
                        textView.setText(charSequence + "·" + string2);
                    }
                }
            }
        } else {
            bAH = iq.bAH();
            if (bAH != null) {
                string2 = bAH.nyc;
                aG = bAH.nyd;
                textView.setTag(iq.bBe());
                if (!bi.oW(string2)) {
                    if (bi.oW(aG)) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(0);
                        if (!bi.oW(string2)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            textView.setText(string2);
                        }
                    }
                    textView.setText(string2);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                }
            }
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.nUr.okR);
        ((TextView) this.nTO.findViewById(f.album_publish_time)).setText(az.l(cqa(), ((long) iq.bAX()) * 1000));
        asyncTextView = (AsyncTextView) this.nTO.findViewById(f.album_ad_tail_desc);
        asyncTextView.setOnClickListener(this.nUr.okV);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.nTO.findViewById(f.album_ad_at_tail);
        asyncTextView2.setOnClickListener(new 31(this, iq, Yg));
        asyncTextView2.setVisibility(8);
        if (iq.kF()) {
            com.tencent.mm.plugin.sns.storage.a bAH22 = iq.bAH();
            asyncTextView.setTag(iq.bBe());
            if (bAH22.nye == com.tencent.mm.plugin.sns.storage.a.nxQ) {
                if (bi.oW(bAH22.nyf)) {
                    asyncTextView.setVisibility(8);
                } else {
                    asyncTextView.setText(bAH22.nyf);
                    asyncTextView.setVisibility(0);
                }
            } else if (bAH22.nye == com.tencent.mm.plugin.sns.storage.a.nxR) {
                if (bi.oW(bAH22.nyf)) {
                    asyncTextView.setVisibility(8);
                } else {
                    bBe = "";
                    Iterator it4 = bAH22.nyh.iterator();
                    while (it4.hasNext()) {
                        String str42 = (String) it4.next();
                        com.tencent.mm.l.a Yf2 = this.nUe.Yf(str42);
                        if (Yf2 != null) {
                            str2 = Yf2.BL();
                            if (bi.oW(str2)) {
                                bBe = bBe + str42;
                            } else {
                                bBe = bBe + str2;
                            }
                        } else {
                            bBe = bBe + str42;
                        }
                        if (bAH22.nyh.getLast() != str42) {
                            bBe = bBe + ",";
                        }
                    }
                    string2 = String.format(bAH22.nyf, new Object[]{bBe});
                    asyncTextView.getTextSize();
                    com.tencent.mm.pluginsdk.ui.d.k kVar22 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b((Context) this, string2, 1));
                    kVar22.f(null, string2);
                    TextPaint paint2 = asyncTextView.getPaint();
                    if (com.tencent.mm.bp.a.ag(this, (int) Layout.getDesiredWidth(kVar22, 0, kVar22.length(), paint2)) > this.nUp) {
                        while (bBe.length() > 1) {
                            bBe = bBe.substring(0, bBe.length() - 2);
                            CharSequence format2 = String.format(bAH22.nyf, new Object[]{bBe + "..."});
                            asyncTextView.getTextSize();
                            com.tencent.mm.pluginsdk.ui.d.k kVar32 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b((Context) this, format2, 1));
                            kVar32.f(null, format2);
                            i2 = com.tencent.mm.bp.a.ag(this, (int) Layout.getDesiredWidth(kVar32, 0, kVar32.length(), paint2));
                            asyncTextView.setText(kVar32, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                            if (i2 <= this.nUp) {
                                break;
                            }
                        }
                    }
                    asyncTextView.setText(kVar22, BufferType.SPANNABLE);
                    asyncTextView.setVisibility(0);
                }
            }
            if (asyncTextView.getVisibility() != 8 && bi.oW(bAH22.nyg)) {
                asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                asyncTextView.setOnClickListener(null);
            }
            if (iq.bAJ().sqc.ruB == 4) {
                asyncTextView2.setTag(iq.bBe());
                asyncTextView2.setVisibility(0);
                asyncTextView2.setText(String.format("%s%s%s", new Object[]{cqa().getResources().getString(j.sns_ad_at_tips1), str, cqa().getResources().getString(j.sns_ad_at_tips2)}));
            } else {
                asyncTextView2.setVisibility(8);
            }
        }
        textView = (TextView) this.nTO.findViewById(f.album_from);
        textView.setOnTouchListener(new ab());
        aG = com.tencent.mm.plugin.sns.c.a.ezo.q(this, bAJ.sqb.ksA);
        if (bAJ.sqc.ruz == 26) {
            aG = getString(j.favorite);
        }
        av.a(bAJ, this);
        if (com.tencent.mm.plugin.sns.c.a.ezo.cT(aG)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            string2 = new SpannableString(getString(j.sns_comefrome) + aG);
            string2.setSpan(new a(this), 0, string2.length(), 33);
            textView.setText(string2, BufferType.SPANNABLE);
            if (bAJ.sqb == null || !com.tencent.mm.pluginsdk.model.app.g.SS(bAJ.sqb.ksA)) {
                textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                textView.setOnTouchListener(null);
            }
            textView.setTag(bAJ);
        }
        textView = (TextView) this.nTO.findViewById(f.album_del);
        if (iq.getUserName().equals(this.cXR)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setTag(iq.bBe() + ";" + iq.bAK());
            textView.setOnClickListener(new 32(this));
        }
        textView = (TextView) this.nTO.findViewById(f.with_info_tv);
        m = aj.m(iq);
        if (m != null) {
            if (m.smR.size() <= 0) {
                textView.setVisibility(8);
            } else if (!this.cXR.equals(m.rdS)) {
                textView.setVisibility(8);
                Iterator it22 = m.smR.iterator();
                while (it22.hasNext()) {
                    if (this.cXR.equals(((bon) it22.next()).rdS)) {
                        textView.setVisibility(0);
                        charSequence = getString(j.sns_timeline_ui_with_you);
                        textView.setVisibility(0);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, charSequence, textView.getTextSize()));
                        break;
                    }
                }
            } else {
                textView.setVisibility(0);
                Iterator it32 = m.smR.iterator();
                string2 = null;
                String str52 = "";
                while (it32.hasNext()) {
                    StringBuilder append2;
                    bon bon2 = (bon) it32.next();
                    if (string2 == null) {
                        obj = 1;
                        str52 = str52 + "  ";
                    } else {
                        str52 = str52 + ",  ";
                        obj = string2;
                    }
                    if (bon2.rTW != null) {
                        append2 = new StringBuilder().append(str52);
                        aG = bon2.rTW;
                    } else {
                        com.tencent.mm.l.a Yg22 = this.nUe.Yg(bon2.rdS);
                        append2 = new StringBuilder().append(str52);
                        aG = Yg22 == null ? bon2.rdS : Yg22.BL();
                    }
                    string2 = obj;
                    str52 = append2.append(aG).toString();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a((Context) this, getString(j.sns_timeline_ui_with_to, new Object[]{str52}), textView.getTextSize()));
            }
            if (m == null || this.cXR == null || !this.cXR.equals(m.rdS) || ((m.rXx != 3 || m.smW == null) && (m.rXx != 5 || m.rWm == null))) {
                this.nTO.findViewById(f.album_groupid).setVisibility(8);
            } else {
                this.nTO.findViewById(f.album_groupid).setVisibility(0);
                this.nTO.findViewById(f.album_groupid).setTag(Integer.valueOf(iq.nJc));
                this.nTO.findViewById(f.album_groupid).setOnClickListener(new 33(this));
            }
        } else {
            textView.setVisibility(8);
        }
        this.nTV = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.nTV.setDuration(150);
        this.nTW = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.nTW.setDuration(150);
        if (this.nTT == null) {
            this.nTT = this.nTO.findViewById(f.album_comment_container);
            this.nTT.setVisibility(8);
        }
        this.nTX = (LinearLayout) this.nTO.findViewById(f.album_comment_li);
        this.nTX.setOnClickListener(new 35(this, iq));
        this.nTX.setOnTouchListener(this.nNj);
        this.nTY = (LinearLayout) this.nTO.findViewById(f.album_like_img);
        this.nTY.setOnClickListener(new 36(this, iq, bAJ));
        this.nTY.setOnTouchListener(this.nNj);
        imageButton = (ImageButton) this.nTO.findViewById(f.album_show_comment_tv);
        iq2 = iq(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView2 = (ImageView) this.nTY.findViewById(f.album_like_icon);
        imageView3 = (ImageView) this.nTX.findViewById(f.album_comment_icon);
        textView2 = (TextView) this.nTY.findViewById(f.album_like_tv);
        textView3 = (TextView) this.nTX.findViewById(f.album_comment_tv);
        if (this.hER == 11) {
            this.nTO.findViewById(f.album_comment_container).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_frame_bg_golden);
            imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_icon);
            imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_likeicon);
            imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.lucky_friendactivity_comment_writeicon);
            textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
            textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
            this.nTY.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.lucky_sns_comment_btn_left);
            this.nTX.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.lucky_sns_comment_btn_right);
        }
        imageButton.setOnClickListener(new 37(this, iq, textView2, textView3, imageView2, imageView3));
        return true;
    }

    private void bDe() {
        if (this.nTT != null && this.nTT.getVisibility() != 8) {
            this.nTT.startAnimation(this.nTW);
            this.nTW.setAnimationListener(new 38(this));
        }
    }

    private void bBR() {
        if (this.mController.tmG == 1 || this.nLN.bDk()) {
            this.nUD.run();
        } else {
            this.nLL = true;
        }
    }

    private void bDf() {
        if (this.nUg != null) {
            this.nUg.setPressed(false);
            if (bg.KK(this.lxx)) {
                this.nUg.setImageResource(com.tencent.mm.plugin.sns.i.e.music_pauseicon);
            } else {
                this.nUg.setImageResource(com.tencent.mm.plugin.sns.i.e.music_playicon);
            }
        }
    }

    private View a(ate ate, int i, boolean z) {
        int[] iArr = new int[]{f.turn_media_type_img_0, f.turn_media_type_img_1};
        int i2 = f.turn_media_type_sight_0;
        if (z) {
            return this.nTO.findViewById(iArr[i]);
        }
        if (ate.hcE == 6) {
            return this.nTO.findViewById(i2);
        }
        if (ate.hcE == 2) {
            return this.nTO.findViewById(iArr[i]);
        }
        return null;
    }

    private void xp(int i) {
        View findViewById = this.nTO.findViewById(f.text_area_top);
        View findViewById2 = this.nTO.findViewById(f.text_area_bottom);
        if (findViewById != null && findViewById2 != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            ((TextView) this.nTO.findViewById(f.turn_media_type_title_0)).setText(null);
            ((TextView) this.nTO.findViewById(f.turn_media_type_title_1)).setText(null);
            ((TextView) this.nTO.findViewById(f.turn_media_type_subtitle_0)).setText(null);
            ((TextView) this.nTO.findViewById(f.turn_media_type_subtitle_1)).setText(null);
            r1 = new int[3][];
            r1[0] = new int[]{f.turn_media_type_title_1, f.turn_media_type_subtitle_1};
            r1[1] = new int[]{f.turn_media_type_title_0, f.turn_media_type_subtitle_0};
            r1[2] = new int[]{f.turn_media_type_title_0, f.turn_media_type_subtitle_1};
            com.tencent.mm.plugin.sns.storage.b bAF = h.Nk(this.bSZ).bAF();
            if (bAF.nzv != null && bAF.nzv.nzE != null && bAF.nzv.nzE.size() >= 2) {
                com.tencent.mm.plugin.sns.storage.b.g gVar = (com.tencent.mm.plugin.sns.storage.b.g) bAF.nzv.nzE.get(i);
                if (gVar.nzK >= 0 && gVar.nzK < 3) {
                    int[] iArr = r1[gVar.nzK];
                    TextView textView = (TextView) this.nTO.findViewById(iArr[0]);
                    TextView textView2 = (TextView) this.nTO.findViewById(iArr[1]);
                    if (bi.oW(gVar.title)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(gVar.title);
                    }
                    if (bi.oW(gVar.desc)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(gVar.desc);
                    }
                    ((View) textView.getParent()).setVisibility(0);
                    ((View) textView2.getParent()).setVisibility(0);
                }
            }
        }
    }

    private boolean g(List<bon> list, boolean z) {
        int b = BackwardSupportUtil.b.b(this, 32.0f);
        int b2 = BackwardSupportUtil.b.b(this, 6.0f);
        int b3 = BackwardSupportUtil.b.b(this, 10.0f);
        int b4 = BackwardSupportUtil.b.b(this, 17.0f);
        if (this.nTQ == null) {
            return false;
        }
        int i;
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(((WindowManager) this.mController.tml.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(com.tencent.mm.plugin.sns.i.d.NormalPadding)));
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.nTQ.getParent() != null) {
                this.nTQ.setVisibility(8);
            }
            this.nTQ.removeAllViews();
            this.nTQ.setVisibility(8);
            this.nmk.setVisibility(8);
            return false;
        }
        this.nTQ.getParent();
        this.nTQ.removeAllViews();
        this.nTQ.setVisibility(0);
        if (this.hER != 11) {
            this.nTQ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list_);
        } else if (this.nUt) {
            n iq = iq(false);
            if (iq == null) {
                this.nTQ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list_golden_arror);
            } else if (this.cXR.equals(iq.field_userName)) {
                this.nTQ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list_golden_myself);
            } else {
                this.nTQ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list_golden_arror);
            }
        } else {
            this.nTQ.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.friendactivity_comment_detail_list_golden_arror);
        }
        this.nTQ.setPadding(0, b2, 0, b2);
        View imageView = new ImageView(this.mController.tml);
        if (this.hER == 11) {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_likeicon_golden);
        } else {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_likeicon);
        }
        imageView.setPadding(b3, b4, b3, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.nTQ.addView(imageView);
        b3 = com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, nUo);
        i = ((int) (f - ((float) b3))) / (b2 + b);
        if (((int) (f - ((float) b3))) % (b2 + b) > b) {
            i++;
        }
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i));
        i iVar = new i(this.mController.tml);
        iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        iVar.setLineMaxCounte(i);
        i = 0;
        while (true) {
            b3 = i;
            if (b3 >= list.size()) {
                break;
            }
            bon bon = (bon) list.get(b3);
            TouchImageView touchImageView = new TouchImageView(this.mController.tml);
            touchImageView.setScaleType(ScaleType.FIT_XY);
            touchImageView.setImageResource(com.tencent.mm.plugin.sns.i.e.friendactivity_personalportrait);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b);
            layoutParams2.setMargins(0, b2, b2, 0);
            touchImageView.setLayoutParams(layoutParams2);
            touchImageView.setTag(bon.rdS);
            com.tencent.mm.pluginsdk.ui.a.b.p(touchImageView, bon.rdS);
            touchImageView.setOnClickListener(this.hqU);
            iVar.addView(touchImageView);
            i = b3 + 1;
        }
        this.nTQ.addView(iVar);
        this.nmk.setVisibility(z ? 8 : 0);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n Nk = h.Nk(this.bSZ);
        boy m = aj.m(Nk);
        g(m.smL, m.smO.isEmpty());
        if (this.nTR != null) {
            this.nTR.a(Nk, this.nUr);
        }
        if (this.nUK != null) {
            this.nUm = af.byw();
            this.nUK.setImageViewWidth(this.nUm);
        }
    }

    public final void LR(String str) {
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i == 15) {
            if (this.nUr != null && this.nUr.okv != null) {
                this.nUr.okv.onActivityResult(i, i2, intent);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            gh ghVar = new gh();
            ghVar.bPv.scene = 1;
            com.tencent.mm.sdk.b.a.sFg.m(ghVar);
        } else if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 218 && this.nLY != null) {
            this.nLY.dismiss();
        }
        if (i == 0 && i2 == 0) {
            n Nk = h.Nk(this.bSZ);
            if (Nk == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.bSZ);
                a();
                return;
            }
            x.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.bSZ + "  username:" + Nk.field_userName);
            if (this.nTO == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                a();
                return;
            }
            bDd();
            boy m = aj.m(Nk);
            x.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + m.smL.size() + " " + m.smO.size());
            if (m != null) {
                if (!f(this.nTZ, m.smL)) {
                    g(m.smL, m.smO.isEmpty());
                    this.nTZ = m.smL;
                }
                if (this.nTR != null) {
                    this.nTR.a(Nk, this.nUr);
                }
                b bVar = this.nTU;
                LinkedList linkedList = m.smO;
                LinkedList linkedList2 = m.smL;
                bVar.nVs = linkedList;
                bVar.nVt = linkedList2;
                this.nTU.notifyDataSetChanged();
            }
        }
    }

    public final void aT(String str, boolean z) {
    }

    public final void onKeyboardStateChanged() {
        if (this.mController.tmG == 2) {
            x.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.nUb = false;
            if (this.nLN.kXI) {
                this.nLN.setModeClick(false);
            } else if (this.nLN.bDj()) {
                this.nLN.bDm();
                this.nLN.setHint(getString(j.sns_ui_comment));
            }
            if (this.nUv) {
                bDd();
            }
        } else if (this.mController.tmG == 1) {
            bDe();
            this.nLL = false;
            this.nUD.run();
        }
    }
}
