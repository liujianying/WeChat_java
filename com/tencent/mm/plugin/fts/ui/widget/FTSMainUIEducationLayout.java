package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.g.b;
import com.tencent.mm.plugin.appbrand.n.g.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout extends LinearLayout {
    public float fto;
    public float ftp;
    public float gcx = ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    public OnClickListener jxn;
    public List<LinearLayout> jzM;
    public Map<Integer, TextView> jzN = new HashMap();
    private String jzO = "";
    public long jzP;
    private boolean jzQ = true;
    public TextView jzR;
    protected boolean jzS = true;
    private boolean jzT;
    public OnClickListener jzU;
    private OnClickListener jzV;

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jzM = new ArrayList();
    }

    public void setNeedHotWord(boolean z) {
        this.jzS = z;
    }

    public final void aL() {
        LinearLayout linearLayout;
        aQZ();
        try {
            if (!K(r.PX("educationTab"))) {
                aRa();
            }
        } catch (Exception e) {
            aRa();
        }
        try {
            if (this.jzS) {
                CharSequence optString = r.PX("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!bi.oW(optString)) {
                    linearLayout = (LinearLayout) inflate(getContext(), e.fts_main_ui_education_hotword_layout, null);
                    ((TextView) linearLayout.findViewById(d.hotword_tv)).setText(optString);
                    linearLayout.setOnClickListener(this.jzU);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.jzM.add(linearLayout);
                }
            }
        } catch (Exception e2) {
        }
        if (this.jzT) {
            b adj = ((g) com.tencent.mm.kernel.g.l(g.class)).adj();
            if (adj.dEw != null && adj.dEw.size() > 0) {
                linearLayout = (LinearLayout) inflate(getContext(), e.fts_main_ui_education_wxapp_layout, null);
                ((TextView) linearLayout.findViewById(d.title_tv)).setText(adj.bSc);
                ImageView[] imageViewArr = new ImageView[]{(ImageView) linearLayout.findViewById(d.app1_iv), (ImageView) linearLayout.findViewById(d.app2_iv), (ImageView) linearLayout.findViewById(d.app3_iv), (ImageView) linearLayout.findViewById(d.app4_iv)};
                ImageView imageView = (ImageView) linearLayout.findViewById(d.more_iv);
                int i = 0;
                while (i < adj.dEw.size() && i < 4) {
                    c cVar = (c) adj.dEw.get(i);
                    a aVar = new a();
                    aVar.dXN = f.default_avatar;
                    aVar.dXW = true;
                    o.Pj().a(cVar.fmD, imageViewArr[i], aVar.Pt());
                    imageViewArr[i].setVisibility(0);
                    imageViewArr[i].setTag(cVar);
                    if (this.jzV != null) {
                        imageViewArr[i].setOnClickListener(this.jzV);
                    }
                    i++;
                }
                if (adj.dEw.size() > 0) {
                    imageView.setVisibility(0);
                    imageView.setTag("more-click");
                    imageView.setOnClickListener(this.jzV);
                }
                addView(linearLayout);
                this.jzM.add(linearLayout);
                String str = "";
                Iterator it = adj.dEw.iterator();
                while (true) {
                    String str2 = str;
                    if (it.hasNext()) {
                        str = str2 + ((c) it.next()).username + ";";
                    } else {
                        h.mEJ.h(14630, new Object[]{com.tencent.mm.plugin.fts.a.e.jqM, adj.bSc, str2, Integer.valueOf(adj.gsQ), Long.valueOf(System.currentTimeMillis() / 1000)});
                        return;
                    }
                }
            }
        }
    }

    public void setNeedWXAPP(boolean z) {
        this.jzT = z;
    }

    public final void J(JSONObject jSONObject) {
        aQZ();
        try {
            if (!K(jSONObject)) {
                aRa();
            }
        } catch (Exception e) {
            aRa();
        }
    }

    private void aQZ() {
        for (LinearLayout removeView : this.jzM) {
            removeView(removeView);
        }
        this.jzM.clear();
        this.jzN.clear();
        this.jzO = "";
    }

    public boolean K(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        jSONObject.optString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int ad;
        if (w.fD(ad.getContext()).equalsIgnoreCase("en")) {
            ad = com.tencent.mm.bp.a.ad(getContext(), n.b.BigerMoreTextSize);
        } else {
            ad = com.tencent.mm.bp.a.ad(getContext(), n.b.NormalTextSize);
        }
        Object obj = null;
        Object obj2 = null;
        String str = null;
        String str2 = null;
        for (int i = 0; i < Math.min(optJSONArray.length(), 9); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
                obj2 = optJSONObject;
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject obj3 = optJSONObject;
            } else {
                a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, ad);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            a(str2, obj2, str, obj3, null, null, ad);
        }
        return true;
    }

    private void aRa() {
        a(getContext().getString(n.g.search_education_timeline), null, getContext().getString(n.g.search_education_article), null, getContext().getString(n.g.search_education_biz_contact), null, com.tencent.mm.bp.a.ad(getContext(), n.b.NormalTextSize));
        aRb();
    }

    public void aRb() {
    }

    public final void a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i) {
        x.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[]{str, str2, str3});
        if (!bi.oW(str)) {
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), e.fts_main_ui_education_cell_layout, null);
            TextView textView = (TextView) linearLayout.findViewById(d.textview_1);
            textView.setText(str);
            textView.setTag(obj);
            textView.setVisibility(0);
            textView.setOnClickListener(this.jxn);
            textView.setClickable(this.jzQ);
            this.jzN.put(Integer.valueOf(m.a((JSONObject) obj, str, getContext())), textView);
            bA(obj);
            if (!bi.oW(str2)) {
                textView = (TextView) linearLayout.findViewById(d.textview_2);
                textView.setText(str2);
                textView.setTag(obj2);
                textView.setVisibility(0);
                textView.setOnClickListener(this.jxn);
                textView.setClickable(this.jzQ);
                View findViewById = linearLayout.findViewById(d.divider_1);
                findViewById.getLayoutParams().height = i;
                findViewById.setVisibility(0);
                this.jzN.put(Integer.valueOf(m.a((JSONObject) obj2, str2, getContext())), textView);
                bA(obj2);
                if (!bi.oW(str3)) {
                    textView = (TextView) linearLayout.findViewById(d.textview_3);
                    textView.setText(str3);
                    textView.setTag(obj3);
                    textView.setVisibility(0);
                    textView.setOnClickListener(this.jxn);
                    textView.setClickable(this.jzQ);
                    findViewById = linearLayout.findViewById(d.divider_2);
                    findViewById.getLayoutParams().height = i;
                    findViewById.setVisibility(0);
                    this.jzN.put(Integer.valueOf(m.a((JSONObject) obj3, str3, getContext())), textView);
                    bA(obj3);
                }
            }
            this.jzM.add(linearLayout);
            addView(linearLayout);
        }
    }

    private void bA(Object obj) {
        if (obj != null && (obj instanceof JSONObject)) {
            String optString = ((JSONObject) obj).optString("businessType");
            if (!bi.oW(optString)) {
                this.jzO = this.jzO == null ? "" : this.jzO;
                if (this.jzO.length() > 0) {
                    this.jzO += "|";
                }
                this.jzO += optString;
            }
        }
    }

    public String getVertBizTypes() {
        return this.jzO == null ? "" : this.jzO;
    }

    public void setOnCellClickListener(OnClickListener onClickListener) {
        this.jxn = onClickListener;
    }

    public void setOnHotwordClickListener(OnClickListener onClickListener) {
        this.jzU = onClickListener;
    }

    public void setOnWxAppClickListener(OnClickListener onClickListener) {
        this.jzV = onClickListener;
    }

    public void setSelected(int i) {
        for (Entry entry : this.jzN.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == i) {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#45C01A"));
            }
        }
    }

    public void setCellClickable(boolean z) {
        this.jzQ = z;
    }
}
