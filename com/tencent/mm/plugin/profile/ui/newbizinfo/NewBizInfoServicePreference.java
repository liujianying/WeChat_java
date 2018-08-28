package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NewBizInfoServicePreference extends Preference {
    MMActivity bGc;
    private TextView fAK;
    ab guS;
    private RecyclerView gxh;
    private boolean iAc = false;
    private ProgressBar lYF;
    a lYU;
    List<d> lYV;
    c lYt;
    int state = 0;

    public static class a extends RecyclerView$a<a> {
        Context context;
        ab guS;
        List<d> lYW = new ArrayList();

        class a extends t implements OnClickListener {
            public TextView eBO;
            public View lYX;
            public d lYY;

            public a(View view) {
                super(view);
                this.eBO = (TextView) view.findViewById(R.h.new_bizinfo_service_item_title);
                this.lYX = view.findViewById(R.h.new_bizinfo_service_item_line);
                view.setOnClickListener(this);
            }

            public final void onClick(View view) {
                if (this.lYY == null) {
                    x.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
                    return;
                }
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(a.this.guS.field_username, 1100);
                x.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[]{Integer.valueOf(this.lYY.type)});
                switch (this.lYY.type) {
                    case 0:
                        d dVar = this.lYY;
                        com.tencent.mm.ui.widget.a.d dVar2 = new com.tencent.mm.ui.widget.a.d(a.this.context, 1, false);
                        dVar2.ofp = new 1(this, dVar);
                        dVar2.ofq = new 2(this, dVar);
                        dVar2.bXO();
                        return;
                    case 2:
                        a(this.lYY);
                        b.a(a.this.guS.field_username, this.lYY.id, this.lYY.aAL, b.lZq, this.lYY.name, b.dl(a.this.lYW.indexOf(this.lYY), -1), this.lYY.ceR);
                        return;
                    case 5:
                        b(this.lYY);
                        b.a(a.this.guS.field_username, this.lYY.id, this.lYY.aAL, b.lZq, this.lYY.name, b.dl(a.this.lYW.indexOf(this.lYY), -1), this.lYY.value);
                        return;
                    default:
                        return;
                }
            }

            private void a(d dVar) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", dVar.value);
                com.tencent.mm.bg.d.b(a.this.context, "webview", ".ui.tools.WebViewUI", intent);
            }

            private void b(d dVar) {
                if (bi.oW(dVar.value)) {
                    x.d("MicroMsg.NewBizInfoServicePreference", "jumpToWeApp serviceInfo.id:%s value is null", new Object[]{dVar.id});
                    return;
                }
                x.d("MicroMsg.NewBizInfoServicePreference", "jumpToWeApp value:%s", new Object[]{dVar.value});
                try {
                    JSONObject jSONObject = new JSONObject(dVar.value);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1102;
                    appBrandStatObject.bGG = a.this.guS.field_username;
                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(a.this.context, jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, null);
                } catch (JSONException e) {
                }
            }
        }

        public a(Context context, List<d> list, ab abVar) {
            this.context = context;
            this.lYW = list;
            this.guS = abVar;
        }

        public final int getItemCount() {
            return this.lYW == null ? 0 : this.lYW.size();
        }
    }

    public NewBizInfoServicePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public NewBizInfoServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
        this.iAc = false;
    }

    public final void onBindView(View view) {
        this.gxh = (RecyclerView) view.findViewById(R.h.new_bizinfo_service_list);
        this.gxh.setLayoutManager(new LinearLayoutManager());
        this.fAK = (TextView) view.findViewById(R.h.new_bizinfo_desc_tv);
        this.lYF = (ProgressBar) view.findViewById(R.h.new_bizinfo_loading);
        this.iAc = true;
        initView();
    }

    final void initView() {
        if (!this.iAc) {
            return;
        }
        if (this.state == 1) {
            this.gxh.setVisibility(8);
            this.lYF.setVisibility(0);
            this.fAK.setVisibility(8);
        } else if (this.state == 2) {
            this.fAK.setText(this.bGc.getString(R.l.contact_info_biz_no_service));
            this.fAK.setVisibility(0);
            this.lYF.setVisibility(8);
            this.gxh.setVisibility(8);
        } else if (this.state == 3) {
            this.gxh.setVisibility(0);
            this.gxh.setAdapter(this.lYU);
            this.fAK.setVisibility(8);
            this.lYF.setVisibility(8);
        } else if (this.state == 4) {
            this.fAK.setText(j.a(this.bGc, this.lYt.field_banReason, (int) this.fAK.getTextSize(), 1));
            this.fAK.setVisibility(0);
            this.lYF.setVisibility(8);
            this.gxh.setVisibility(8);
        }
    }

    static List<d> bI(List<d> list) {
        List<d> arrayList = new ArrayList();
        if (list == null) {
            x.e("MicroMsg.NewBizInfoServicePreference", "serviceInfoList is null, err");
            return arrayList;
        }
        for (d dVar : list) {
            if (dVar.type == 0) {
                List<d> list2 = dVar.lZm;
                dVar.lZm = new ArrayList();
                for (d dVar2 : list2) {
                    if (dVar2.type == 2 || dVar2.type == 5) {
                        dVar.lZm.add(dVar2);
                    }
                }
                if (dVar.lZm.size() > 0) {
                    arrayList.add(dVar);
                }
            } else if (dVar.type == 2) {
                arrayList.add(dVar);
            } else if (dVar.type == 5) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }
}
