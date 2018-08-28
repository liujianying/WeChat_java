package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.api.h;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class FTSAddFriendUI extends FTSBaseUI {
    private long ghF;
    private bja iJw;
    private Dialog iwc;
    private String jbY = "";
    private View jvF;
    private View jvG;
    private View jvH;
    private View jvI;
    private View jvJ;
    private View jvK;
    private View jvL;
    private ImageView jvM;
    private TextView jvN;
    private TextView jvO;
    private TextView jvP;
    private TextView jvQ;
    private TextView jvR;
    private boolean jvS;
    protected boolean jvT;
    private int jvU = 1;
    private FTSLocalPageRelevantView jvV;
    private c jvW;
    private int jvX;
    private int jvY;
    int jvZ = -1;

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        final ag agVar = new ag();
        agVar.bHr.context = fTSAddFriendUI;
        agVar.bHr.fromScene = 16;
        agVar.bHr.bHt = fTSAddFriendUI.bWm;
        agVar.bHr.bHv = false;
        agVar.bHr.title = fTSAddFriendUI.getString(g.search_contact_result);
        agVar.bHr.bHu = 1;
        Runnable anonymousClass7 = new Runnable() {
            public final void run() {
                FTSAddFriendUI.this.aQA();
                if (agVar.bHs.bHx) {
                    FTSAddFriendUI.this.jvY = 1;
                } else {
                    FTSAddFriendUI.this.jvY = -1;
                }
                FTSAddFriendUI.h(FTSAddFriendUI.this);
            }
        };
        agVar.bHr.bHw = anonymousClass7;
        agVar.bHr.action = 1;
        if (!com.tencent.mm.sdk.b.a.sFg.m(agVar)) {
            agVar.bHs.bHx = false;
            anonymousClass7.run();
        }
    }

    static /* synthetic */ void h(FTSAddFriendUI fTSAddFriendUI) {
        if (fTSAddFriendUI.jvX != 0 && fTSAddFriendUI.jvY != 0) {
            fTSAddFriendUI.aQA();
            if (fTSAddFriendUI.jvX <= 0 || fTSAddFriendUI.jvY >= 0) {
                if (fTSAddFriendUI.jvX > 0) {
                    bja bja = fTSAddFriendUI.iJw;
                    String a = ab.a(bja.rvi);
                    CharSequence a2 = ab.a(bja.rQz);
                    CharSequence charSequence = bja.eJK;
                    fTSAddFriendUI.jwh.setVisibility(8);
                    fTSAddFriendUI.jvG.setVisibility(0);
                    fTSAddFriendUI.jvH.setVisibility(0);
                    fTSAddFriendUI.jvL.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (!bi.oW(FTSAddFriendUI.this.bWm)) {
                                FTSAddFriendUI.this.jvT = true;
                                ad.h(FTSAddFriendUI.this.bWm, FTSAddFriendUI.this.jvU, 1, 16);
                            }
                            FTSAddFriendUI.this.aQz();
                        }
                    });
                    fTSAddFriendUI.jvN.setText(a2);
                    fTSAddFriendUI.jvO.setText(charSequence);
                    b.a(fTSAddFriendUI.jvM, a);
                    fTSAddFriendUI.jvI.setVisibility(8);
                    fTSAddFriendUI.jvJ.setVisibility(8);
                    fTSAddFriendUI.jvK.setVisibility(8);
                    fTSAddFriendUI.jvV.setVisibility(8);
                } else {
                    fTSAddFriendUI.jwh.setVisibility(8);
                    fTSAddFriendUI.jvG.setVisibility(0);
                    fTSAddFriendUI.jvH.setVisibility(8);
                    fTSAddFriendUI.jvI.setVisibility(0);
                    fTSAddFriendUI.jvJ.setVisibility(8);
                    fTSAddFriendUI.jvK.setVisibility(8);
                    fTSAddFriendUI.jvV.setVisibility(8);
                }
                if (fTSAddFriendUI.jvY > 0) {
                    fTSAddFriendUI.jvJ.setVisibility(0);
                    fTSAddFriendUI.jvK.setVisibility(0);
                    fTSAddFriendUI.jvP.setText(f.a(fTSAddFriendUI.getString(g.fts_on_search_network), "", d.b(fTSAddFriendUI.bWm, fTSAddFriendUI.bWm)).jrO);
                    fTSAddFriendUI.jvU = 2;
                    fTSAddFriendUI.jvK.setOnClickListener(new 3(fTSAddFriendUI));
                    return;
                }
                fTSAddFriendUI.jvJ.setVisibility(8);
                fTSAddFriendUI.jvK.setVisibility(8);
                fTSAddFriendUI.jvV.setVisibility(8);
                return;
            }
            fTSAddFriendUI.jvT = true;
            fTSAddFriendUI.aQz();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.jqM = p.zK(16);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(n.d.action_bar_container), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        lF(this.mController.tml.getResources().getColor(n.a.normal_actionbar_color));
        cqh();
        this.jwm = this.mController.tml.getResources().getString(g.contact_search_account_hint);
        this.jwl.getFtsEditText().setHint(getHint());
        this.jvF = findViewById(n.d.bg_layout);
        this.jvG = findViewById(n.d.contact_biz_merge_layout);
        this.jvH = findViewById(n.d.has_contact_layout);
        this.jvL = findViewById(n.d.contact_click_layout);
        this.jvI = findViewById(n.d.no_contact_layout);
        this.jvJ = findViewById(n.d.merge_layout_divider);
        this.jvK = findViewById(n.d.search_content_layout);
        this.jvV = (FTSLocalPageRelevantView) findViewById(n.d.relevant_serach_query);
        this.jvM = (ImageView) findViewById(n.d.contact_avatar_iv);
        this.jvN = (TextView) findViewById(n.d.contact_title_tv);
        this.jvO = (TextView) findViewById(n.d.contact_desc_tv);
        this.jvP = (TextView) findViewById(n.d.search_title_tv);
        this.jvQ = (TextView) findViewById(n.d.contact_error_tv);
        this.jvR = (TextView) findViewById(n.d.search_desc_tv);
        try {
            x.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[]{r.PX("webSearchBar").optString("wording")});
            this.jvR.setText(r0);
        } catch (Exception e) {
        }
        this.mController.contentView.postDelayed(new 1(this), 128);
        this.jvF.setOnClickListener(new 2(this));
    }

    protected void onResume() {
        super.onResume();
        p.bSQ();
    }

    public void onBackPressed() {
        finish();
    }

    protected final d a(e eVar) {
        if (this.jvW == null) {
            this.jvW = new c(eVar);
        }
        return this.jvW;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.fts.ui.a.a) {
            this.jbY = aVar.jrx.jrV;
            CM(aVar.jrx.jrV);
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, FTSEditTextView.b bVar) {
        super.a(str, str2, list, bVar);
        this.jvS = false;
    }

    public final boolean anx() {
        CM(this.bWm);
        YC();
        return true;
    }

    protected final int getLayoutId() {
        return n.e.fts_add_friend_ui;
    }

    protected final void aQy() {
        super.aQy();
        this.jvG.setVisibility(8);
    }

    protected final void stopSearch() {
        super.stopSearch();
        this.jvG.setVisibility(8);
    }

    private void aQz() {
        if (bi.oV(ab.a(this.iJw.rvi)).length() > 0) {
            if (2 == this.iJw.sjj) {
                this.jvZ = 15;
            } else if (1 == this.iJw.sjj) {
                this.jvZ = 1;
            }
            Intent intent = new Intent();
            ((h) com.tencent.mm.kernel.g.l(h.class)).a(intent, this.iJw, this.jvZ);
            if (this.jvZ == 15 && 2 == this.iJw.sjj) {
                intent.putExtra("Contact_Search_Mobile", this.jbY.trim());
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.bg.d.b(this, "profile", ".ui.ContactInfoUI", intent);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jvS && !this.jvT) {
            ad.h(this.bWm, this.jvU, 3, 16);
        }
    }

    private void CM(String str) {
        this.jvS = true;
        this.jvT = false;
        this.jvU = 1;
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            this.jvZ = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final 5 5 = new 5(this);
            this.jvX = 0;
            this.jvY = 0;
            com.tencent.mm.kernel.g.DF().a(106, 5);
            final com.tencent.mm.plugin.messenger.a.f fVar = new com.tencent.mm.plugin.messenger.a.f(str, 3);
            com.tencent.mm.kernel.g.DF().a(fVar, 0);
            getString(g.app_tip);
            this.iwc = com.tencent.mm.ui.base.h.a(this, getString(g.search_contact_doing), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.kernel.g.DF().c(fVar);
                    com.tencent.mm.kernel.g.DF().b(106, 5);
                    FTSAddFriendUI.this.iwc = null;
                }
            });
        }
    }

    private void aQA() {
        ah.A(new Runnable() {
            public final void run() {
                if (FTSAddFriendUI.this.iwc != null) {
                    FTSAddFriendUI.this.iwc.dismiss();
                    FTSAddFriendUI.this.iwc = null;
                }
            }
        });
    }

    public void onClickClearTextBtn(View view) {
        super.onClickClearTextBtn(view);
        if (!this.jwl.getFtsEditText().jzo.hasFocus()) {
            this.jwl.getFtsEditText().aQU();
            showVKB();
        }
    }
}
