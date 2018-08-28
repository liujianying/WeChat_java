package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements e {
    private View gPU;
    private Dialog iwc;
    private int jNB = 0;
    private int jNv = 0;
    private k jUE = new k();
    private ListView jUL;
    private l jUM;
    private boolean jUN = false;
    private boolean jUO = true;
    private a jUR = new 3(this);
    private OnScrollListener jUS = new 8(this);
    private boolean jVD = true;
    private TextView jZA;
    private View jZB;
    private GameDropdownView jZC;
    private HashMap<Integer, String> jZD;
    private int jZE = 0;
    private View jZF;
    private Button jZG;
    private boolean jZH = false;
    private int jZI = 990;
    private int jZJ = 0;
    private OnClickListener jZK = new 5(this);
    private OnClickListener jZL = new 6(this);
    private GameDropdownView$a jZM = new 7(this);
    private GameBannerView jZx;
    private GameLibraryCategoriesView jZy;
    private View jZz;
    private boolean jud = false;

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, aj ajVar, boolean z) {
        Pair pair = null;
        gameLibraryUI.jUO = ajVar.jNW.jSg;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.jUM.O(ajVar.jNY);
            x.i("MicroMsg.GameLibraryUI", "Appending list size: %d", new Object[]{Integer.valueOf(linkedList.size())});
        } else {
            LinkedList linkedList2;
            GameBannerView gameBannerView = gameLibraryUI.jZx;
            if (ajVar.jNW.jSe == null || ajVar.jNW.jSe.jSI == null) {
                x.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < ajVar.jNW.jSe.jSI.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    b bVar = (b) ajVar.jNW.jSe.jSI.get(i);
                    d a = aj.a(bVar.jOV);
                    if (a != null) {
                        com.tencent.mm.plugin.game.e.d.a(a);
                        aVar.index = i;
                        aVar.jUo = a;
                        aVar.dGg = bVar.jOW;
                        aVar.jLe = bVar.jOX;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.setBannerList(linkedList);
            gameLibraryUI.jZy.setData(ajVar.aUw());
            gameLibraryUI.jZy.setSourceScene(gameLibraryUI.jNv);
            linkedList = new LinkedList();
            linkedList2 = ajVar.jNX;
            Object obj = ajVar.jNY;
            linkedList.addAll(linkedList2);
            linkedList.addAll(obj);
            gameLibraryUI.jUM.P(linkedList);
            x.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(obj.size())});
            gameLibraryUI.jZD = ajVar.aUv();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.jZD.values());
            GameDropdownView gameDropdownView = gameLibraryUI.jZC;
            LinkedList linkedList3 = new LinkedList();
            linkedList3.addAll(gameLibraryUI.jZD.keySet());
            gameDropdownView.d(linkedList, linkedList3.indexOf(Integer.valueOf(gameLibraryUI.jZE)));
            Pair pair2 = (ajVar.jNW.jSe == null || ajVar.jNW.jSe.jSJ == null) ? null : new Pair(ajVar.jNW.jSe.jSJ.jSZ, ajVar.jNW.jSe.jSJ.jSo);
            if (pair2 == null || bi.oW((String) pair2.first) || bi.oW((String) pair2.second)) {
                gameLibraryUI.jZz.setTag(null);
                gameLibraryUI.jZA.setVisibility(8);
            } else {
                gameLibraryUI.jZz.setTag(pair2.second);
                gameLibraryUI.jZA.setVisibility(0);
                gameLibraryUI.jZA.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.jZz);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.jZB);
            gameLibraryUI.jUM.d(sparseArray);
            if (!(ajVar.jNW.jSe == null || ajVar.jNW.jSe.jSL == null)) {
                pair = new Pair(ajVar.jNW.jSe.jSL.jSS, ajVar.jNW.jSe.jSL.jOX);
            }
            if (pair != null) {
                gameLibraryUI.jZG.setText((CharSequence) pair.first);
                gameLibraryUI.jZG.setTag(pair.second);
                gameLibraryUI.jZH = true;
            }
        }
        if (!gameLibraryUI.jUO && gameLibraryUI.jZH) {
            gameLibraryUI.jZF.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            int i;
            this.jNv = getIntent().getIntExtra("game_report_from_scene", 0);
            g.DF().a(1218, this);
            initView();
            byte[] Dw = ((c) g.l(c.class)).aSk().Dw("pb_library");
            if (Dw == null) {
                x.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                g.Em().H(new 4(this, Dw));
                i = 1;
            }
            if (i == 0) {
                this.iwc = com.tencent.mm.plugin.game.e.c.dD(this);
                this.iwc.show();
            }
            aUY();
            an.a(this, 11, 1100, 0, 1, this.jNv, null);
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (g.Eg().Dx()) {
            this.jUM.refresh();
            if (!(this.jVD || this.jZx == null)) {
                GameBannerView gameBannerView = this.jZx;
                if (gameBannerView.jUl != null && gameBannerView.jUl.ciq() && gameBannerView.jUk.size() > 1) {
                    gameBannerView.jUl.J(5000, 5000);
                    x.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.jVD) {
                this.jVD = false;
                return;
            }
            return;
        }
        x.e("MicroMsg.GameLibraryUI", "account not ready");
    }

    protected void onPause() {
        super.onPause();
        if (this.jZx != null) {
            GameBannerView gameBannerView = this.jZx;
            if (gameBannerView.jUl != null) {
                gameBannerView.jUl.SO();
                x.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        g.DF().b(1218, this);
        this.jUM.clear();
        if (this.jZx != null) {
            this.jZx.jUl.SO();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected final int getLayoutId() {
        return f.game_library;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(i.game_library);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameLibraryUI.this.goBack();
                return true;
            }
        });
        if (!bi.oW(com.tencent.mm.plugin.game.model.f.aTK())) {
            addIconOptionMenu(0, i.top_item_desc_search, h.actionbar_icon_dark_search, new 2(this));
        }
        this.jUL = (ListView) findViewById(com.tencent.mm.plugin.game.f.e.game_library_list);
        this.jUL.setOnItemClickListener(this.jUE);
        this.jUE.setSourceScene(this.jNv);
        this.jUL.setOnScrollListener(this.jUS);
        this.jUM = new l(this);
        this.jUM.setSourceScene(this.jNv);
        this.jUM.a(this.jUR);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.tml.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(f.game_library_top_banner, this.jUL, false);
        this.jZx = (GameBannerView) inflate.findViewById(com.tencent.mm.plugin.game.f.e.game_library_top_banner);
        this.jZx.setSourceScene(this.jNv);
        this.jUL.addHeaderView(inflate);
        this.jZJ++;
        this.jZy = (GameLibraryCategoriesView) layoutInflater.inflate(f.game_library_categories_head, this.jUL, false);
        View linearLayout = new LinearLayout(this);
        linearLayout.addView(this.jZy);
        this.jUL.addHeaderView(linearLayout);
        this.jZJ++;
        this.jZz = layoutInflater.inflate(f.game_library_new_head, this.jUL, false);
        this.jZz.setOnClickListener(this.jZK);
        this.jZA = (TextView) this.jZz.findViewById(com.tencent.mm.plugin.game.f.e.game_library_new_game_more);
        this.jZB = layoutInflater.inflate(f.game_library_all_head, this.jUL, false);
        this.jZB.setOnClickListener(null);
        this.jZC = (GameDropdownView) this.jZB.findViewById(com.tencent.mm.plugin.game.f.e.game_library_all_sort);
        this.jZC.setAnchorView(this.jZB);
        this.jZC.setOnSelectionChangedListener(this.jZM);
        this.gPU = layoutInflater.inflate(f.game_list_footer_loading, this.jUL, false);
        this.gPU.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.gPU);
        this.jUL.addFooterView(linearLayout);
        this.jZF = layoutInflater.inflate(f.game_library_footer_more, this.jUL, false);
        this.jZF.setVisibility(8);
        this.jZG = (Button) this.jZF.findViewById(com.tencent.mm.plugin.game.f.e.game_library_more_btn);
        this.jZG.setOnClickListener(this.jZL);
        this.jUL.addFooterView(this.jZF);
        this.jUL.setAdapter(this.jUM);
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

    private void aUY() {
        g.DF().a(new ay(this.jNB, com.tencent.mm.plugin.game.model.f.aTz(), this.jZE, this.jNB == 0), 0);
        this.jUN = true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 1218:
                    g.Em().H(new 9(this, ((ay) lVar).ivx.dIE.dIL));
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
        x.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            x.e("MicroMsg.GameLibraryUI", "error request code");
        }
    }
}
