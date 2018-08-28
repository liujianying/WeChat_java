package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper;

public class SearchOrRecommendBizUI extends MMActivity implements b {
    private int hnT = 0;
    private BizSearchResultItemContainer hom;
    private int hop = 0;
    private ProgressDialog hpV = null;
    private SearchViewNotRealTimeHelper hpW;

    protected final int getLayoutId() {
        return e.contact_search_recommend_biz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hnT = getIntent().getIntExtra("intent_extra_entry_flag", 0);
        this.hop = getIntent().getIntExtra("fromScene", 0);
        initView();
        if (f.auN()) {
            g.DF().a(456, new 1(this));
            g.DF().a(new f(), 0);
        }
        String stringExtra = getIntent().getStringExtra("Search_Str");
        if (!bi.oW(stringExtra)) {
            new ag(Looper.getMainLooper()).post(new 2(this, stringExtra));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        z.Ni().MS();
    }

    protected final void initView() {
        setMMTitle(h.contact_search_recommend_biz_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SearchOrRecommendBizUI.this.YC();
                SearchOrRecommendBizUI.this.finish();
                return true;
            }
        });
        this.hpW = (SearchViewNotRealTimeHelper) findViewById(d.search_view);
        this.hpW.setSearchColor(getResources().getColor(a.normal_text_color));
        this.hpW.setSearchHint(getString(h.contact_search_recommend_biz_title));
        this.hpW.setSearchHintColor(getResources().getColor(a.hint_color_white_bg));
        this.hpW.setSearchIcon(0);
        this.hpW.setShowBackIcon(false);
        this.hpW.setCallBack(new SearchViewNotRealTimeHelper.a() {
            public final boolean pj(String str) {
                wY(str);
                return true;
            }

            public final void wY(String str) {
                if (bi.oW(str)) {
                    com.tencent.mm.ui.base.h.bA(SearchOrRecommendBizUI.this.mController.tml, SearchOrRecommendBizUI.this.getString(h.contact_search_recommend_biz_notext));
                    return;
                }
                SearchOrRecommendBizUI.this.YC();
                SearchOrRecommendBizUI.this.hom.aV(str, 0);
            }

            public final void ava() {
                SearchOrRecommendBizUI.this.showVKB();
            }
        });
        this.hom = (BizSearchResultItemContainer) findViewById(d.searchResultItemContainer);
        this.hom.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SearchOrRecommendBizUI.this.hpW.clearFocus();
                SearchOrRecommendBizUI.this.YC();
                return false;
            }
        });
        f fVar = new f(this);
        fVar.hpR = f.auO();
        this.hom.setAdapter(fVar);
        this.hom.setBusinessTypes(1);
        this.hom.setDisplayArgs$25decb5(false);
        this.hom.setMode(1);
        this.hom.setScene(this.hop);
        this.hom.setIOnSearchStateChangedListener(this);
    }

    public final void auU() {
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(h.app_tip);
        this.hpV = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(h.contact_search_recommend_biz_searching), true, new 6(this));
    }

    public final void auV() {
        if (this.hpV != null) {
            this.hpV.dismiss();
            this.hpV = null;
        }
    }
}
