package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.y;

public final class a extends x {
    private TextView fAK;
    private ImageView gxd;
    com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a gxe;
    private LinearLayout gxf;
    private View gxg;
    private RecyclerView gxh;
    private TextView gxi;
    private Button gxj;
    private CheckBox gxk;
    private TextView gxl;
    private LinearLayout gxm;
    private View gxn;
    private TextView gxo;
    private TextView gxp;
    private b mActionBarHelper;

    protected final void dealContentView(View view) {
        if (this.gxe == null || this.gxe.anL() == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            return;
        }
        this.gxf = (LinearLayout) view.findViewById(g.app_brand_idcard_show_layout);
        this.gxd = (ImageView) view.findViewById(g.app_brand_idcard_show_icon);
        this.fAK = (TextView) view.findViewById(g.app_brand_idcard_show_desc);
        this.gxh = (RecyclerView) view.findViewById(g.app_brand_idcard_show_list);
        this.gxi = (TextView) view.findViewById(g.app_brand_idcard_show_busi_desc);
        this.gxj = (Button) view.findViewById(g.app_brand_idcard_show_confirm);
        this.gxk = (CheckBox) view.findViewById(g.app_brand_idcard_show_checkbox);
        this.gxl = (TextView) view.findViewById(g.app_brand_show_protocal);
        this.gxm = (LinearLayout) view.findViewById(g.app_brand_idcard_show_bottom_layout);
        this.gxn = view.findViewById(g.app_brand_idcard_show_url_line);
        this.gxo = (TextView) view.findViewById(g.app_brand_idcard_show_url_1);
        this.gxp = (TextView) view.findViewById(g.app_brand_idcard_show_url_2);
        this.gxg = y.gq(getContext()).inflate(h.actionbar_custom_area, null);
        this.gxg.setBackgroundColor(getResources().getColor(d.action_bar_color));
        this.mActionBarHelper = new b(this.gxg);
        this.gxf.addView(this.gxg, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.cM(getActivity())));
        final bnm anL = this.gxe.anL();
        this.mActionBarHelper.setTitle(anL.title);
        this.mActionBarHelper.b(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.gxe != null) {
                    a.this.gxe.back();
                }
            }
        });
        com.tencent.mm.modelappbrand.b.b.Ka().a(this.gxd, anL.rZK, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
        this.fAK.setText(anL.dxK + " " + anL.sly);
        if (anL.slz != null) {
            this.gxh.setVisibility(0);
            RecyclerView recyclerView = this.gxh;
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
            this.gxh.setAdapter(new a(anL.slz));
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.gxh.setVisibility(8);
        }
        this.gxi.setText(anL.slA);
        if (bi.oW(anL.slB)) {
            this.gxj.setText(getString(j.app_brand_idcard_show_default_confirm_text));
        } else {
            this.gxj.setText(anL.slB);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[]{Boolean.valueOf(anL.slF)});
        this.gxk.setChecked(anL.slF);
        this.gxj.setEnabled(anL.slF);
        if (bi.oW(anL.slG)) {
            this.gxk.setText(getString(j.app_brand_idcard_show_legal_agreement_prefix));
        } else {
            this.gxk.setText(anL.slG);
        }
        this.gxk.setOnCheckedChangeListener(new 2(this));
        this.gxj.setOnClickListener(new 3(this));
        if (anL.slC != null) {
            this.gxl.setText(anL.slC.name);
            this.gxl.setOnClickListener(new 4(this, anL));
        }
        if (anL.slD != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[]{Integer.valueOf(anL.slD.size())});
            if (anL.slD.size() == 0) {
                this.gxm.setVisibility(8);
            } else if (anL.slD.size() == 1) {
                this.gxm.setVisibility(0);
                this.gxn.setVisibility(8);
                this.gxp.setVisibility(8);
                if (anL.slD.get(0) != null) {
                    this.gxo.setText(((ei) anL.slD.get(0)).name);
                    this.gxo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.gxe != null) {
                                a.this.gxe.vH(((ei) anL.slD.get(0)).url);
                            }
                        }
                    });
                }
            } else {
                this.gxm.setVisibility(0);
                this.gxn.setVisibility(0);
                this.gxp.setVisibility(0);
                if (anL.slD.get(0) != null) {
                    this.gxo.setText(((ei) anL.slD.get(0)).name);
                    this.gxo.setOnClickListener(new 6(this, anL));
                }
                if (anL.slD.get(1) != null) {
                    this.gxp.setText(((ei) anL.slD.get(1)).name);
                    this.gxp.setOnClickListener(new 7(this, anL));
                }
            }
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    protected final int getLayoutId() {
        return h.app_brand_idcard_show_ui;
    }

    public final void onSwipeBack() {
        if (this.gxe != null) {
            this.gxe.onSwipeBack();
        }
    }
}
