package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.o;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, a, b, c, VerticalScrollBar.a, l, o.b {
    public o eMS;
    public MultiSelectContactView lbw;
    private ListView mfK;
    private View neM;
    public int scene;
    private AlphabetScrollBar ujZ;
    private o uka;
    public m ukb;
    private com.tencent.mm.ui.base.o ukc;
    private View ukd;
    private View uke;
    private TextView ukf;
    private LabelContainerView ukg;
    private TextView ukh;
    private MMTagPanel uki;
    private boolean ukj = true;
    private List<String> ukk = new ArrayList();

    public abstract boolean Wk();

    public abstract boolean Wl();

    public abstract String Wm();

    public abstract o Wn();

    public abstract m Wo();

    static /* synthetic */ void c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        x.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.mfK, 8);
        mMBaseSelectContactUI.mfK.setAdapter(mMBaseSelectContactUI.ukb);
        mMBaseSelectContactUI.ukb.notifyDataSetChanged();
        if (mMBaseSelectContactUI.Wl() && mMBaseSelectContactUI.ujZ != null) {
            mMBaseSelectContactUI.ujZ.setVisibility(8);
        }
        mMBaseSelectContactUI.uke.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (g.Eg().Dx()) {
            Wj();
            x.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
            initView();
            x.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
            return;
        }
        x.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        x.chS();
        finish();
    }

    public final n cyp() {
        if (getContentLV().getHeaderViewsCount() > 0) {
            return (n) ((HeaderViewListAdapter) getContentLV().getAdapter()).getWrappedAdapter();
        }
        return (n) getContentLV().getAdapter();
    }

    public ListView getContentLV() {
        return this.mfK;
    }

    public o cyq() {
        return this.uka;
    }

    public void Wj() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void initView() {
        setMMTitle(Wm());
        this.mfK = (ListView) findViewById(e.select_contact_lv);
        this.uka = Wn();
        this.ukb = Wo();
        this.neM = findViewById(e.shadow);
        if (cyx()) {
            this.uke = findViewById(e.no_result_view);
            this.ukf = (TextView) findViewById(e.no_result_tv);
            this.uke.setOnTouchListener(new 1(this));
            if (Wk()) {
                this.eMS = new o((byte) 0);
                this.eMS.uBw = this;
                a(this.eMS);
            } else {
                this.lbw = (MultiSelectContactView) findViewById(e.contact_multiselect);
                this.lbw.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
                this.lbw.setOnSearchTextChangeListener(this);
                this.lbw.setOnSearchTextFouceChangeListener(this);
                this.lbw.setOnContactDeselectListener(this);
                this.lbw.setVisibility(0);
                this.ukd = new View(this.mController.tml);
                this.ukd.setLayoutParams(new LayoutParams(-1, this.lbw.getMeasuredHeight()));
                this.ukd.setVisibility(4);
                this.mfK.addHeaderView(this.ukd);
                findViewById(e.padding_view).setVisibility(0);
            }
        }
        a(this.mfK, 0);
        this.mfK.setAdapter(this.uka);
        setBackBtn(new 2(this));
        if (this.ukb != null) {
            this.ukb.a(new 3(this));
        }
        this.mfK.setOnScrollListener(new 4(this));
        this.mfK.setOnItemClickListener(this);
        if (Wl()) {
            this.ujZ = (AlphabetScrollBar) findViewById(e.select_contact_scrollbar);
            this.ujZ.setVisibility(0);
            this.ujZ.setOnScrollBarTouchListener(this);
        }
        if (bcN()) {
            this.ukg = (LabelContainerView) findViewById(e.select_contact_label_container);
            this.ukh = (TextView) this.ukg.findViewById(16908310);
            this.ukh.setText(h.select_contact_by_label_panel);
            this.uki = (MMTagPanel) this.ukg.findViewById(e.contact_label_panel);
            this.uki.setTagSelectedBG(d.tag_white_tab_selector);
            this.uki.setTagSelectedTextColorRes(com.tencent.mm.plugin.selectcontact.a.b.normal_text_color);
            this.ukg.setOnLabelContainerListener(new 5(this));
            this.uki.setCallBack(new 6(this));
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            com.tencent.mm.ui.contact.a.a FM = cyp().FM(headerViewsCount);
            com.tencent.mm.ui.contact.a.a.b Wg = FM.Wg();
            ActionBarActivity actionBarActivity = this.mController.tml;
            Wg.Wi();
            if (FM.djH) {
                headerViewsCount = FM.jtq;
                int i2 = FM.jtr;
                if (FM.aQi()) {
                    headerViewsCount = 15;
                } else if (headerViewsCount == 131072) {
                    switch (i2) {
                        case 1:
                            headerViewsCount = 1;
                            break;
                        case 2:
                            headerViewsCount = 2;
                            break;
                        case 3:
                            headerViewsCount = 3;
                            break;
                        case 4:
                            headerViewsCount = 4;
                            break;
                        case 5:
                            headerViewsCount = 5;
                            break;
                        case 6:
                            headerViewsCount = 6;
                            break;
                        case 7:
                            headerViewsCount = 7;
                            break;
                        case 11:
                            headerViewsCount = 8;
                            break;
                        case 15:
                            headerViewsCount = 16;
                            break;
                        case 16:
                            headerViewsCount = 10;
                            break;
                        case 17:
                        case 18:
                            headerViewsCount = 9;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else if (headerViewsCount == 131075) {
                    switch (i2) {
                        case 1:
                        case 5:
                            headerViewsCount = 12;
                            break;
                        case 2:
                        case 6:
                            headerViewsCount = 13;
                            break;
                        case 3:
                        case 7:
                            headerViewsCount = 14;
                            break;
                        case f$k.AppCompatTheme_actionModeBackground /*29*/:
                        case 30:
                        case f$k.AppCompatTheme_actionModeCloseDrawable /*31*/:
                        case f$k.AppCompatTheme_actionModeCutDrawable /*32*/:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                            headerViewsCount = 11;
                            break;
                        default:
                            headerViewsCount = 0;
                            break;
                    }
                } else {
                    headerViewsCount = headerViewsCount == GLIcon.RIGHT ? 17 : 0;
                }
                switch (FM.jtq) {
                    case GLIcon.RIGHT /*65536*/:
                        i2 = 5;
                        break;
                    case 131072:
                        i2 = 2;
                        break;
                    case 131075:
                        i2 = 3;
                        break;
                    case 131076:
                        i2 = 4;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                if (FM.ump) {
                    i2 = 1;
                }
                if (FM.hER == 5) {
                    i2 = 7;
                }
                x.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", new Object[]{String.format("%s,%d,%d,%d,%d", new Object[]{FM.bWm, Integer.valueOf(FM.scene), Integer.valueOf(i2), Integer.valueOf(FM.jtl), Integer.valueOf(headerViewsCount)})});
                com.tencent.mm.plugin.report.service.h.mEJ.k(13234, r0);
            }
        }
        if (!cyp().FN(i)) {
            iV(i);
        }
    }

    public void iV(int i) {
    }

    private String cyr() {
        if (this.eMS != null) {
            return this.eMS.getSearchContent();
        }
        if (this.lbw != null) {
            return this.lbw.getSearchContent();
        }
        return "";
    }

    private void cys() {
        boolean czu = this.eMS != null ? this.eMS.czu() : this.lbw != null ? this.lbw.hasFocus() : false;
        if (czu && bi.oW(cyr())) {
            if (this.ukk == null || this.ukk.size() <= 0) {
                this.ukg.setVisibility(8);
                return;
            }
            this.ukg.setVisibility(0);
            this.uki.a(null, this.ukk);
        } else if (this.ukg != null) {
            this.ukg.setVisibility(8);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.ukc != null) {
            this.ukc.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        if (bcN() && this.ukj) {
            this.ukj = false;
            g.Em().H(new 7(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ujZ != null) {
            this.ujZ.tBm = null;
        }
        if (this.uka != null) {
            this.uka.finish();
        }
        if (this.ukb != null) {
            this.ukb.finish();
        }
        if (this.ukc != null) {
            this.ukc.dismiss();
        }
    }

    public int getLayoutId() {
        return f.mm_select_contact_ui;
    }

    public final void FW(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", new Object[]{str});
        if (bcN()) {
            cys();
        }
        if (this.ukb == null) {
            return;
        }
        if (bi.oW(str)) {
            this.ukb.acV();
            this.ukb.notifyDataSetChanged();
            cyu();
            return;
        }
        this.ukb.a(str, bbG(), cyt());
    }

    public final void cdq() {
        if (bcN()) {
            cys();
        }
    }

    public int[] bbG() {
        return new int[]{131072, 131075};
    }

    public void a(ListView listView, int i) {
    }

    public void bbH() {
        YC();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            bbH();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void ys(String str) {
        if (this.uka != null) {
            int aaJ = this.uka.aaJ(str);
            if (aaJ == 0) {
                this.mfK.setSelection(0);
            } else if (aaJ <= 0) {
                x.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", new Object[]{Integer.valueOf(aaJ), str});
            } else if (Wk()) {
                this.mfK.setSelection(aaJ);
            } else if (this.lbw != null) {
                this.mfK.setSelectionFromTop(aaJ, this.lbw.getMeasuredHeight());
            }
        }
    }

    public final boolean pj(String str) {
        return false;
    }

    public final void pk(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", new Object[]{str});
        if (bcN()) {
            if (this.eMS != null) {
                this.eMS.czv();
            }
            cys();
        }
        if (bi.oW(str)) {
            this.ukb.acV();
            this.ukb.notifyDataSetChanged();
            cyu();
            return;
        }
        this.ukb.a(str, bbG(), cyt());
    }

    public boolean cyt() {
        return false;
    }

    public final void WW() {
        cyu();
        if (bcN()) {
            cys();
        }
    }

    public final void WX() {
    }

    private void cyu() {
        x.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.mfK, 0);
        this.mfK.setAdapter(this.uka);
        this.uka.notifyDataSetChanged();
        if (Wl() && this.ujZ != null) {
            this.ujZ.setVisibility(0);
        }
        this.uke.setVisibility(8);
    }

    public void pf(String str) {
    }

    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public Activity getActivity() {
        return this;
    }

    public boolean bcN() {
        return false;
    }

    public void Gr(String str) {
        x.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", new Object[]{str});
    }

    public final void cyv() {
        if (this.eMS != null) {
            if (!bi.oW(this.eMS.getSearchContent())) {
                o oVar = this.eMS;
                if (oVar.uBv != null) {
                    oVar.uBv.mt(true);
                }
            }
        } else if (this.lbw != null && !bi.oW(this.lbw.getSearchContent())) {
            this.lbw.qFV.setText("");
        }
    }

    public final void cyw() {
        if (this.eMS != null) {
            if (this.eMS.czu()) {
                this.eMS.clearFocus();
            }
        } else if (this.lbw != null && this.lbw.hasFocus()) {
            this.lbw.clearFocus();
        }
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    public boolean cyx() {
        return this.ukb != null;
    }
}
