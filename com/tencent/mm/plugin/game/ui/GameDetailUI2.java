package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.ae$a;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.at;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.applet.t$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.n.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements e {
    private String appId = null;
    private Dialog iwc;
    private d jMa = null;
    private int jNv = 0;
    private d jWA = null;
    private n jWB = null;
    private ViewGroup jWC;
    private ImageView jWD;
    private ImageView jWE;
    private TextView jWF;
    private Button jWG;
    private TextProgressBar jWH;
    private TextView jWI;
    private LinearLayout jWJ;
    private GameDetailAutoScrollView jWK;
    private LinearLayout jWL;
    private TextView jWM;
    private LinearLayout jWN;
    private TextView jWO;
    private LinearLayout jWP;
    private ImageView jWQ;
    private View jWR;
    private TextView jWS;
    private TextView jWT;
    private View jWU;
    private TextView jWV;
    private ImageView jWW;
    private TextView jWX;
    private TextView jWY;
    private LinearLayout jWZ;
    private String jWs = null;
    private String jWt = null;
    private int jWv = 18;
    private boolean jWw;
    private boolean jWx;
    private String jWy = null;
    private b jWz = null;
    private GameMediaList jXa;
    private TextView jXb;
    private TextView jXc;
    private TextView jXd;
    private boolean jXe = false;
    private LinearLayout jXf;
    private TextView jXg;
    private LinearLayout jXh;
    private TextView jXi;
    private cy jXj;
    private OnClickListener jXk = new 15(this);
    private View.OnClickListener jXl = new 16(this);
    private View.OnClickListener jXm = new 17(this);
    private View.OnClickListener jXn = new 2(this);
    private View.OnClickListener jXo = new 3(this);
    private View.OnClickListener jXp = new 4(this);
    private View.OnClickListener jXq = new 5(this);

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        g$a g_a = new g$a();
        g_a.title = gameDetailUI2.jXj.jTm;
        g_a.description = gameDetailUI2.jXj.jTn;
        g_a.type = 5;
        if (bi.oW(gameDetailUI2.jXj.jPd)) {
            g_a.thumburl = gameDetailUI2.jMa.field_appIconUrl;
        } else {
            g_a.thumburl = gameDetailUI2.jXj.jPd;
        }
        g_a.url = gameDetailUI2.jXj.jOX;
        if (a.FH() != null) {
            a.FH().a(g_a, gameDetailUI2.appId, gameDetailUI2.jMa.field_appName, str, null, null);
        }
        if (!bi.oW(str2)) {
            ow owVar = new ow();
            owVar.bZQ.bZR = str;
            owVar.bZQ.content = str2;
            owVar.bZQ.type = s.hQ(str);
            owVar.bZQ.flags = 0;
            com.tencent.mm.sdk.b.a.sFg.m(owVar);
        }
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", f.a.fast_faded_in);
        intent.putExtra("MMActivity.OverrideExitAnimation", f.a.push_down_out);
        com.tencent.mm.bg.d.b(gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.mController.tml.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.jXj.jTo);
        String str = gameDetailUI2.jXj.jPd;
        if (bi.oW(str)) {
            str = gameDetailUI2.jMa.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.jXj.jOX);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = u.ic("game_center");
        u.Hx().v(str, true).p("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        com.tencent.mm.bg.d.b(gameDetailUI2.mController.tml, "sns", ".ui.SnsUploadUI", intent, 3);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            boolean z;
            this.jWw = true;
            this.jWx = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (bi.oW(this.appId)) {
                x.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.jNv = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            initView();
            g.DF().a(1217, this);
            byte[] Dw = ((c) g.l(c.class)).aSk().Dw(this.appId);
            if (Dw == null || Dw.length == 0) {
                x.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                g.Em().H(new 12(this, Dw));
                z = true;
            }
            if (!z) {
                this.iwc = com.tencent.mm.plugin.game.e.c.dD(this);
                this.iwc.show();
            }
            g.DF().a(new at(w.chP(), this.appId, com.tencent.mm.pluginsdk.model.app.g.r(this, this.appId)), 0);
            return;
        }
        x.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
    }

    protected final int getLayoutId() {
        return f.f.game_detail2;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!(this.jMa == null || this.jWB == null)) {
            this.jWB.aTT();
            this.jWA.a(this.jWH, this.jWG, this.jMa, this.jWB);
        }
        if (this.jWw) {
            this.jWw = false;
        } else {
            b(new af(this.appId));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        g.DF().b(1217, this);
        if (this.jWz != null) {
            m.b(this.jWz);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bi.oW(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    protected final void initView() {
        setMMTitle(i.game_detail_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameDetailUI2.this.goBack();
                return true;
            }
        });
        this.jWC = (ViewGroup) findViewById(f.e.game_detail);
        this.jWD = (ImageView) findViewById(f.e.game_detail_bg);
        this.jWE = (ImageView) findViewById(f.e.game_icon);
        this.jWF = (TextView) findViewById(f.e.game_name);
        this.jWI = (TextView) findViewById(f.e.game_info);
        this.jWG = (Button) findViewById(f.e.game_action_btn);
        this.jWH = (TextProgressBar) findViewById(f.e.game_progress);
        this.jWH.setTextSize(this.jWv);
        this.jWJ = (LinearLayout) findViewById(f.e.game_detail_trend_container);
        this.jWK = (GameDetailAutoScrollView) findViewById(f.e.game_detail_trend_brief);
        this.jWL = (LinearLayout) findViewById(f.e.game_detail_rank_container);
        this.jWM = (TextView) findViewById(f.e.game_detail_rank_entrance);
        this.jWN = (LinearLayout) findViewById(f.e.game_detail_gift);
        this.jWO = (TextView) findViewById(f.e.game_detail_gift_title);
        this.jWP = (LinearLayout) findViewById(f.e.game_detail_gift_container);
        this.jWQ = (ImageView) findViewById(f.e.game_detail_gift_divider);
        this.jWR = findViewById(f.e.game_detail_gift_entrance);
        this.jWS = (TextView) findViewById(f.e.game_detail_gift_entrance_title);
        this.jWT = (TextView) findViewById(f.e.game_detail_gift_entrance_desc);
        this.jWU = findViewById(f.e.game_detail_group);
        this.jWV = (TextView) findViewById(f.e.game_detail_group_title);
        this.jWW = (ImageView) findViewById(f.e.game_detail_group_icon);
        this.jWX = (TextView) findViewById(f.e.game_detail_group_desc);
        this.jWY = (TextView) findViewById(f.e.game_detail_group_detail);
        this.jWZ = (LinearLayout) findViewById(f.e.game_detail_desc);
        this.jXa = (GameMediaList) findViewById(f.e.game_detail_intro_media);
        GameMediaList gameMediaList = this.jXa;
        String str = this.appId;
        int i = this.jNv;
        gameMediaList.appId = str;
        gameMediaList.iMP = 12;
        gameMediaList.jYI = i;
        gameMediaList.mContext = this;
        this.jXa.setItemLayout(f.f.game_media_item_big);
        this.jXb = (TextView) findViewById(f.e.game_detail_desc_title);
        this.jXc = (TextView) findViewById(f.e.game_detail_desc_content);
        this.jXc.getViewTreeObserver().addOnGlobalLayoutListener(new 10(this));
        this.jXd = (TextView) findViewById(f.e.game_detail_desc_toggle);
        this.jXd.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (GameDetailUI2.this.jXe) {
                    GameDetailUI2.this.jXc.setMaxLines(3);
                    GameDetailUI2.this.jXd.setText(GameDetailUI2.this.getResources().getText(i.game_desc_toggle_all));
                    GameDetailUI2.this.jXe = false;
                    return;
                }
                GameDetailUI2.this.jXc.setMaxLines(100);
                GameDetailUI2.this.jXd.setText(GameDetailUI2.this.getResources().getText(i.game_desc_toggle_less));
                GameDetailUI2.this.jXe = true;
            }
        });
        this.jXf = (LinearLayout) findViewById(f.e.game_detail_guide);
        this.jXg = (TextView) findViewById(f.e.game_detail_guide_title);
        this.jXh = (LinearLayout) findViewById(f.e.game_detail_guide_container);
        this.jXi = (TextView) findViewById(f.e.game_detail_guide_entrance);
    }

    private void b(af afVar) {
        int i = 0;
        List list = afVar.jNG;
        if (list == null || list.size() == 0) {
            this.jWL.setVisibility(8);
            this.jWM.setVisibility(8);
            return;
        }
        this.jWL.setVisibility(0);
        if (list.size() > 3) {
            this.jWM.setVisibility(0);
        } else {
            this.jWM.setVisibility(8);
        }
        this.jWL.removeAllViews();
        i iVar = new i(this.mController.tml);
        iVar.Ba = f.f.game_detail2_rank_item_small;
        iVar.a(afVar);
        iVar.jNv = this.jNv;
        while (i < list.size() && i < 3) {
            this.jWL.addView(iVar.getView(i, null, this.jWJ));
            i++;
        }
    }

    private void a(ae aeVar) {
        LinkedList linkedList = null;
        if (aeVar.jNF.jNG == null || aeVar.jNF.jNG.size() == 0) {
            linkedList = aeVar.jNC.jRx;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.jWJ.setVisibility(8);
            return;
        }
        this.jWJ.setVisibility(0);
        this.jWJ.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            View inflate = LayoutInflater.from(this.mController.tml).inflate(f.f.game_detail2_trend_item, this.jWJ, false);
            ImageView imageView = (ImageView) inflate.findViewById(f.e.game_detail_trend_item_icon);
            TextView textView = (TextView) inflate.findViewById(f.e.game_detail_trend_item_title);
            TextView textView2 = (TextView) inflate.findViewById(f.e.game_detail_trend_item_detail);
            if (bi.oW(tVar.hbL)) {
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXW = true;
                o.Pj().a(tVar.jPd, imageView, aVar.Pt());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, tVar.hbL, 0.5f, false);
            }
            textView.setText(tVar.bHD);
            textView2.setText(tVar.jQf);
            this.jWJ.addView(inflate);
        }
    }

    private void b(ae aeVar) {
        if (aeVar.aUi() == null || aeVar.aUi().isEmpty()) {
            this.jWN.setVisibility(8);
            return;
        }
        int i;
        ae$a ae_a;
        this.jWN.setVisibility(0);
        if (bi.oW(aeVar.aUh())) {
            this.jWO.setVisibility(8);
        } else {
            this.jWO.setVisibility(0);
            this.jWO.setText(aeVar.aUh());
        }
        this.jWP.removeAllViews();
        int i2;
        if (aeVar.aUj() == 1) {
            this.jWP.setOrientation(1);
            i2 = f.f.game_detail2_gift_item;
            this.jWQ.setVisibility(8);
            i = i2;
        } else {
            this.jWP.setOrientation(0);
            i2 = f.f.game_detail2_gift2_item;
            this.jWQ.setVisibility(0);
            i = i2;
        }
        LinkedList aUi = aeVar.aUi();
        if (aUi != null) {
            Iterator it = aUi.iterator();
            while (it.hasNext()) {
                ae.b bVar = (ae.b) it.next();
                View inflate = LayoutInflater.from(this.mController.tml).inflate(i, this.jWP, false);
                o.Pj().a(bVar.bWP, (ImageView) inflate.findViewById(f.e.game_detail_gift_item_icon));
                if (aeVar.aUj() == 1) {
                    ((TextView) inflate.findViewById(f.e.game_detail_gift_item_title)).setText(bVar.title);
                }
                ((TextView) inflate.findViewById(f.e.game_detail_gift_item_detail)).setText(bVar.desc);
                if (aeVar.aUj() == 1) {
                    inflate.setTag(bVar.url);
                    inflate.setOnClickListener(this.jXn);
                }
                this.jWP.addView(inflate);
            }
        }
        if (aeVar.jNC.jRF != null) {
            ae_a = new ae$a();
            ae_a.title = aeVar.jNC.jRF.summary;
            ae_a.desc = aeVar.jNC.jRF.desc;
            ae_a.url = aeVar.jNC.jRF.url;
        } else if (aeVar.jNC.jRA == null || bi.oW(aeVar.jNC.jRA.jSn) || bi.oW(aeVar.jNC.jRA.jSo)) {
            ae_a = null;
        } else {
            ae_a = new ae$a();
            ae_a.title = aeVar.jNC.jRA.jSn;
            ae_a.url = aeVar.jNC.jRA.jSo;
        }
        if (ae_a != null) {
            this.jWR.setVisibility(0);
            this.jWS.setText(ae_a.title);
            if (bi.oW(ae_a.desc)) {
                this.jWT.setVisibility(8);
            } else {
                this.jWT.setVisibility(0);
                this.jWT.setText(ae_a.desc);
            }
            this.jWR.setTag(ae_a.url);
            this.jWR.setOnClickListener(this.jXn);
            return;
        }
        this.jWR.setVisibility(8);
    }

    private void c(ae aeVar) {
        if (aeVar.aUo() == null || aeVar.aUo().isEmpty()) {
            this.jXf.setVisibility(8);
            return;
        }
        this.jXf.setVisibility(0);
        if (bi.oW(aeVar.aUn())) {
            this.jXg.setVisibility(8);
        } else {
            this.jXg.setVisibility(0);
            this.jXg.setText(aeVar.aUn());
        }
        this.jXh.removeAllViews();
        this.jXh.setOnClickListener(null);
        Iterator it = aeVar.aUo().iterator();
        while (it.hasNext()) {
            bv bvVar = (bv) it.next();
            View inflate = LayoutInflater.from(this.mController.tml).inflate(f.f.game_detail2_guide_item, this.jXh, false);
            TextView textView = (TextView) inflate.findViewById(f.e.game_detail_guide_item_title);
            TextView textView2 = (TextView) inflate.findViewById(f.e.game_detail_guide_item_detail);
            ImageView imageView = (ImageView) inflate.findViewById(f.e.game_detail_guide_item_icon);
            ((TextView) inflate.findViewById(f.e.game_detail_guide_item_tag)).setText(bvVar.jSt);
            textView.setText(bvVar.bHD);
            textView2.setText(bvVar.jQf);
            o.Pj().a(bvVar.jSp, imageView);
            inflate.setTag(bvVar.jOX);
            inflate.setOnClickListener(this.jXo);
            this.jXh.addView(inflate);
        }
        Pair pair = aeVar.jNC.jRA == null ? null : (bi.oW(aeVar.jNC.jRz.bHD) || bi.oW(aeVar.jNC.jRz.jSo)) ? null : new Pair(aeVar.jNC.jRz.jSn, aeVar.jNC.jRz.jSo);
        if (pair != null) {
            this.jXi.setVisibility(0);
            this.jXi.setText((CharSequence) pair.first);
            this.jXi.setTag(pair.second);
            this.jXi.setOnClickListener(this.jXp);
            return;
        }
        this.jXi.setVisibility(8);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 1217:
                    g.Em().H(new 14(this, ((at) lVar).ivx.dIE.dIL));
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.b.a.ezo.a(this, i, i2, str)) {
            Toast.makeText(this, getString(i.game_list_get_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.iwc != null) {
            this.iwc.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                switch (i2) {
                    case 2:
                        if (this.jMa != null && this.jWB != null) {
                            this.jWB.aTU();
                            this.jWA.a(this.jMa, this.jWB);
                            return;
                        }
                        return;
                    case 3:
                        if (this.jWB != null) {
                            this.jWB.aTT();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 2:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oW(stringExtra)) {
                        String str = this.jXj.jPd;
                        if (bi.oW(str)) {
                            str = this.jMa.field_appIconUrl;
                        }
                        t$a.qJO.a(this.mController, this.jXj.jTm, str, this.jXj.jTn, true, getResources().getString(i.app_send), new 9(this, stringExtra));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 == -1) {
                    an.a(this.mController.tml, 12, 1207, 2, 15, this.appId, this.jNv, null);
                    return;
                }
                return;
            default:
                x.e("MicroMsg.GameDetailUI2", "error request code");
                return;
        }
    }
}
