package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.co;
import com.tencent.mm.plugin.game.d.cs;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.model.ah$a;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.be;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.ui.GameIndexSearchView.1;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public class GameCenterUI5 extends GameCenterBaseUI implements e {
    private Dialog iwc;
    private GameRecomBlockView jVA;
    private GameNewClassifyView jVB;
    private GameIndexListView jVC;
    private boolean jVD = true;
    private GameNewTopBannerView jVv;
    private GameIndexSearchView jVw;
    private GameIndexWxagView jVx;
    private GameMessageBubbleView jVy;
    private GameBlockView jVz;

    static /* synthetic */ void a(GameCenterUI5 gameCenterUI5, ah ahVar, int i) {
        if (gameCenterUI5.isFinishing()) {
            x.w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
        } else if (ahVar == null) {
            x.e("MicroMsg.GameCenterUI5", "Null data");
        } else {
            ImageView imageView;
            TextView textView;
            View childAt;
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.jVv;
            bx bxVar = ahVar.jNN;
            int i2 = gameCenterUI5.jNv;
            boolean z = gameCenterUI5.jVi;
            if (bxVar == null || bxVar.jSy == null || bi.oW(bxVar.jSy.jQe)) {
                GameNewTopBannerView.aVc();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.jNv = i2;
                gameNewTopBannerView.fHA = bxVar.jSx != null ? an.Dx(bxVar.jSx.jPA) : null;
                if (!gameNewTopBannerView.kbg.equals(bxVar.jSy.jQe)) {
                    gameNewTopBannerView.kbg = bxVar.jSy.jQe;
                    com.tencent.mm.plugin.game.e.e.aVj().g(gameNewTopBannerView.jVt, bxVar.jSy.jQe);
                    gameNewTopBannerView.kbe = gameNewTopBannerView.b(gameNewTopBannerView.jVt, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(c.GameThemeSmallPicHeight), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(c.GameThemePicWidth));
                    if (gameNewTopBannerView.kbe > 0) {
                        if (i == 2) {
                            an.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.jNv, 0, null, null, gameNewTopBannerView.fHA);
                        }
                        if (gameNewTopBannerView.kbe <= 0 || bxVar.jSx == null || bi.oW(bxVar.jSx.jOT)) {
                            gameNewTopBannerView.jVs.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.e.e.aVj().g(gameNewTopBannerView.jVs, bxVar.jSx.jOT);
                            gameNewTopBannerView.kbf = gameNewTopBannerView.b(gameNewTopBannerView.jVs, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(c.GameThemeBigPicHeight), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(c.GameThemePicWidth));
                            if (gameNewTopBannerView.kbf > 0) {
                                gameNewTopBannerView.jVs.setVisibility(0);
                                gameNewTopBannerView.jVs.setTag(bxVar.jSx.jOU);
                                gameNewTopBannerView.jVs.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.jVs.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.jVs.getVisibility() == 0) {
                            if (bxVar.jSx.jTt == f.dy(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.setInitPadding(gameNewTopBannerView.kbe - gameNewTopBannerView.kbf);
                            } else {
                                gameNewTopBannerView.jVt.setImageAlpha(0);
                                f.F(gameNewTopBannerView.mContext, bxVar.jSx.jTt);
                                GameIndexListView.setInitPadding(0);
                            }
                            GameIndexListView.setDefaultPadding(gameNewTopBannerView.kbe - gameNewTopBannerView.kbf);
                            GameIndexListView.setCanPulldown(true);
                        } else {
                            GameNewTopBannerView.aVc();
                        }
                        gameNewTopBannerView.setVisibility(0);
                    } else {
                        GameNewTopBannerView.aVc();
                        gameNewTopBannerView.setVisibility(8);
                    }
                } else if (i == 2) {
                    an.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.jNv, 0, null, null, gameNewTopBannerView.fHA);
                }
            }
            GameIndexSearchView gameIndexSearchView = gameCenterUI5.jVw;
            bx bxVar2 = ahVar.jNN;
            int i3 = gameCenterUI5.jNv;
            if (bxVar2 == null || bxVar2.jSy == null || bxVar2.jSy.jSX == null) {
                gameIndexSearchView.setVisibility(8);
            } else {
                gameIndexSearchView.removeAllViews();
                co coVar = bxVar2.jSy.jSX;
                gameIndexSearchView.setVisibility(0);
                gameIndexSearchView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_index_search_view, gameIndexSearchView, true);
                imageView = (ImageView) gameIndexSearchView.findViewById(com.tencent.mm.plugin.game.f.e.search_icon);
                textView = (TextView) gameIndexSearchView.findViewById(com.tencent.mm.plugin.game.f.e.search_text);
                a aVar = new a();
                if (bi.oW(coVar.jPG)) {
                    imageView.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.e.e.aVj().a(imageView, coVar.jPG, aVar.aVk());
                }
                if (bi.oW(coVar.bHD)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(coVar.bHD);
                }
                gameIndexSearchView.setTag(coVar.jOU);
                gameIndexSearchView.setOnClickListener(new 1(gameIndexSearchView, i3));
            }
            GameIndexWxagView gameIndexWxagView = gameCenterUI5.jVx;
            al alVar = ahVar.jNR;
            int i4 = gameCenterUI5.jNv;
            if (alVar == null) {
                gameIndexWxagView.setVisibility(8);
            } else {
                gameIndexWxagView.jNv = i4;
                gameIndexWxagView.setVisibility(0);
                gameIndexWxagView.mContainer.removeAllViews();
                if (bi.cX(alVar.jQT) && alVar.jQU == null) {
                    gameIndexWxagView.setVisibility(8);
                } else {
                    int i5;
                    int i6;
                    if (i == 2) {
                        an.a(gameIndexWxagView.getContext(), 10, 1025, 0, null, i4, an.Dx(alVar.jPA));
                    }
                    gameIndexWxagView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_center_4_wxag_view, gameIndexWxagView, true);
                    TextView textView2 = (TextView) gameIndexWxagView.findViewById(com.tencent.mm.plugin.game.f.e.wxag_module_title);
                    LinearLayout linearLayout = (LinearLayout) gameIndexWxagView.findViewById(com.tencent.mm.plugin.game.f.e.wxag_item_layout);
                    if (bi.oW(alVar.bHD)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(alVar.bHD);
                    }
                    i2 = 0;
                    while (true) {
                        i5 = i2;
                        if (i5 >= 4) {
                            break;
                        }
                        linearLayout.addView((LinearLayout) gameIndexWxagView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_center_4_wxag_item, gameIndexWxagView, false), new LayoutParams(-1, -2, 1.0f));
                        i2 = i5 + 1;
                    }
                    i5 = 0;
                    if (!bi.cX(alVar.jQT)) {
                        i2 = 0;
                        while (true) {
                            int i7 = i2;
                            i6 = i5;
                            if (i7 >= alVar.jQT.size()) {
                                break;
                            }
                            cs csVar = (cs) alVar.jQT.get(i7);
                            if (!(csVar == null || csVar.jTb == null || csVar.jTb.jQi == null)) {
                                View childAt2 = linearLayout.getChildAt(i6);
                                textView = (TextView) childAt2.findViewById(com.tencent.mm.plugin.game.f.e.wxag_item_name);
                                com.tencent.mm.plugin.game.e.e.aVj().g((ImageView) childAt2.findViewById(com.tencent.mm.plugin.game.f.e.wxag_item_img), csVar.jTb.jQi.jPG);
                                textView.setText(csVar.jTb.jQi.jSv);
                                if (i == 2) {
                                    an.a(gameIndexWxagView.getContext(), 10, 1025, i6 + 1, csVar.jTb.jQi.jQb, i4, null);
                                }
                                childAt2.setTag(new GameIndexWxagView.a(i6 + 1, csVar.jTb.jQi));
                                childAt2.setOnClickListener(gameIndexWxagView);
                                i6++;
                                if (i6 >= 3) {
                                    break;
                                }
                            }
                            i5 = i6;
                            i2 = i7 + 1;
                        }
                    } else {
                        i6 = 0;
                    }
                    if (alVar.jQU != null) {
                        childAt = linearLayout.getChildAt(i6);
                        textView = (TextView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.wxag_item_name);
                        com.tencent.mm.plugin.game.e.e.aVj().g((ImageView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.wxag_item_img), alVar.jQU.jPG);
                        textView.setText(alVar.jQU.jSv);
                        childAt.setTag(alVar.jQU);
                        childAt.setOnClickListener(new GameIndexWxagView.1(gameIndexWxagView, i4));
                    }
                    View view = new View(gameIndexWxagView.getContext());
                    view.setBackgroundColor(gameIndexWxagView.getContext().getResources().getColor(b.game_divided_line_color));
                    gameIndexWxagView.addView(view, new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(gameIndexWxagView.getContext(), 5)));
                }
            }
            if (gameCenterUI5.jVe) {
                gameCenterUI5.jVy.aVb();
            }
            GameBlockView gameBlockView = gameCenterUI5.jVz;
            ah$a ah_a = ahVar.jNO;
            i4 = gameCenterUI5.jNv;
            if (ah_a == null) {
                gameBlockView.setVisibility(8);
            } else {
                gameBlockView.jUE.setSourceScene(i4);
                gameBlockView.setVisibility(0);
                gameBlockView.jeZ.removeAllViews();
                if (ah_a.jNS == null || bi.oW(ah_a.jNS.field_appId) || bi.oW(ah_a.jNS.field_appName)) {
                    gameBlockView.setVisibility(8);
                } else {
                    View findViewById;
                    if (i == 2) {
                        an.a(gameBlockView.getContext(), 10, 1002, 0, ah_a.jNS.field_appId, i4, null);
                    }
                    d dVar = ah_a.jNS;
                    gameBlockView.jUF = new GameBlockView.a((byte) 0);
                    childAt = gameBlockView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_center_4_block_item, gameBlockView.jeZ, false);
                    gameBlockView.jUF.jUI = (ViewGroup) childAt.findViewById(com.tencent.mm.plugin.game.f.e.main_view);
                    gameBlockView.jUF.jUt = (ImageView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.game_icon);
                    gameBlockView.jUF.jUu = (TextView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.game_name);
                    gameBlockView.jUF.jUJ = (TextView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.game_desc);
                    gameBlockView.jUF.jUK = (GameDownloadView) childAt.findViewById(com.tencent.mm.plugin.game.f.e.game_download_container);
                    com.tencent.mm.plugin.game.e.e.aVj().a(gameBlockView.jUF.jUt, dVar.field_appId, com.tencent.mm.bp.a.getDensity(gameBlockView.getContext()));
                    CharSequence charSequence = dVar.field_appName;
                    if (!bi.oW(dVar.field_appName) && dVar.field_appName.length() > 8) {
                        charSequence = dVar.field_appName.substring(0, 7) + "...";
                    }
                    gameBlockView.jUF.jUu.setText(charSequence);
                    if (bi.oW(dVar.jLc)) {
                        gameBlockView.jUF.jUJ.setVisibility(8);
                    } else {
                        gameBlockView.jUF.jUJ.setText(dVar.jLc);
                        gameBlockView.jUF.jUJ.setVisibility(0);
                    }
                    gameBlockView.jUF.jUK.setDownloadInfo(new n(dVar));
                    gameBlockView.jUF.jUI.setOnClickListener(gameBlockView.jUE);
                    gameBlockView.jUF.jUI.setTag(dVar);
                    gameBlockView.jeZ.addView(childAt);
                    f fVar = new f(gameBlockView.getContext());
                    fVar.a(ah_a.jNU, ah_a.jNS.field_appId, i, i4);
                    gameBlockView.jeZ.addView(fVar, gameBlockView.jUD);
                    e eVar = new e(gameBlockView.getContext());
                    eVar.a(ah_a.jNT, ah_a.jNS.field_appId, i, i4);
                    gameBlockView.jeZ.addView(eVar, gameBlockView.jUD);
                    if (ah_a.jNV != null) {
                        imageView = (ImageView) gameBlockView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_divide_line, gameBlockView, false);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(gameBlockView.getContext(), 20);
                        imageView.setLayoutParams(marginLayoutParams);
                        gameBlockView.addView(imageView);
                        gameBlockView.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_center_4_block_more, gameBlockView, true);
                        findViewById = gameBlockView.findViewById(com.tencent.mm.plugin.game.f.e.more_layout);
                        ((TextView) gameBlockView.findViewById(com.tencent.mm.plugin.game.f.e.more_text)).setText(ah_a.jNV.jOS);
                        findViewById.setTag(ah_a.jNV.jOU);
                        findViewById.setOnClickListener(new GameBlockView$1(gameBlockView, i4));
                    }
                    ViewGroup viewGroup = gameBlockView.jeZ;
                    findViewById = new View(gameBlockView.getContext());
                    findViewById.setBackgroundColor(gameBlockView.getContext().getResources().getColor(b.game_divided_line_color));
                    viewGroup.addView(findViewById, new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(gameBlockView.getContext(), 5)));
                }
            }
            GameRecomBlockView gameRecomBlockView = gameCenterUI5.jVA;
            ag agVar = ahVar.jNP;
            int i8 = gameCenterUI5.jNv;
            if (agVar == null) {
                gameRecomBlockView.setVisibility(8);
            } else {
                gameRecomBlockView.jNv = i8;
                gameRecomBlockView.setVisibility(0);
                gameRecomBlockView.a(agVar, i, i8);
            }
            gameCenterUI5.jVB.a(ahVar.jNQ, i, gameCenterUI5.jNv);
            gameCenterUI5.jVC.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            GameIndexListView.setSourceScene(this.jNv);
            g.DF().a(2994, this);
            initView();
            com.tencent.mm.plugin.game.e.c.Em().H(new Runnable() {
                public final void run() {
                    byte[] Dw = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSk().Dw("pb_index_4");
                    if (Dw == null) {
                        com.tencent.mm.sdk.platformtools.ah.A(new 1(this));
                    } else {
                        com.tencent.mm.sdk.platformtools.ah.A(new 2(this, new ah(Dw)));
                    }
                    ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSf().init(GameCenterUI5.this);
                    com.tencent.mm.plugin.game.e.c.R(f.aTz());
                    g.DF().a(new av(w.chP(), f.aTz(), GameCenterUI5.this.jVf, GameCenterUI5.this.jVg, GameCenterUI5.this.jVh, GameCenterUI5.this.jVe), 0);
                    f.ds(GameCenterUI5.this.mController.tml);
                    f.aTE();
                    com.tencent.mm.plugin.game.e.a.a.aVh().aVf();
                }
            });
            x.i("MicroMsg.GameCenterUI5", "fromScene = %d", new Object[]{Integer.valueOf(this.jNv)});
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (g.Eg().Dx()) {
            if (!this.jVD) {
                ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSf().init(this);
                GameMessageBubbleView gameMessageBubbleView = this.jVy;
                gameMessageBubbleView.kaM.setOnClickListener(null);
                gameMessageBubbleView.setVisibility(8);
                if (this.jVe) {
                    this.jVy.aVb();
                }
                GameBlockView gameBlockView = this.jVz;
                if (gameBlockView.jUF != null) {
                    gameBlockView.jUF.jUK.refresh();
                }
                GameIndexListView gameIndexListView = this.jVC;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) gameIndexListView.getLayoutManager();
                int fi = linearLayoutManager.fi();
                gameIndexListView.jYO.X(fi, (linearLayoutManager.fj() - fi) + 1);
            }
            this.jVD = false;
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    public void onDestroy() {
        x.i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (g.Eg().Dx()) {
            com.tencent.mm.plugin.game.e.a.a.aVh().clearCache();
            g.DF().b(2994, this);
            ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSf().clearCache();
            be.aUD();
            be.aUF();
            return;
        }
        x.e("MicroMsg.GameCenterUI5", "account not ready");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(i.game_wechat_game);
        this.jVC = (GameIndexListView) findViewById(com.tencent.mm.plugin.game.f.e.game_fees_list);
        this.jVC.setVisibility(8);
        View inflate = getLayoutInflater().inflate(com.tencent.mm.plugin.game.f.f.game_index_header_view, this.jVC, false);
        this.jVC.addHeaderView(inflate);
        this.jVv = (GameNewTopBannerView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_top_banner_view);
        this.jVw = (GameIndexSearchView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_index_search);
        this.jVx = (GameIndexWxagView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_index_wxag);
        this.jVy = (GameMessageBubbleView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_msg_bubble_view);
        this.jVz = (GameBlockView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_block_view);
        this.jVA = (GameRecomBlockView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_recom_block_view);
        this.jVB = (GameNewClassifyView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_new_classify_view);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 2994:
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.plugin.game.e.c.Em().H(new 2(this, ((av) lVar).ivx.dIE.dIL, currentTimeMillis));
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

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.game.f.f.game_center_4_index;
    }
}
