package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n$a;
import com.tencent.mm.plugin.scanner.util.n$a.a.b;
import com.tencent.mm.plugin.scanner.util.n.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFurtherInfoUI extends MMPreference {
    protected f gua;
    private MMPageControlView mIA;
    private a mIB;
    private String mIC;
    private ViewPager vp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n$a bY = i.bY(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bY == null || bY.mNY == null) {
            x.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            return;
        }
        this.mIB = bY.mNY;
        this.mIC = bY.field_feedbackurl;
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new 1(this));
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new 2(this));
        this.gua = this.tCL;
        List arrayList = new ArrayList();
        Iterator it = this.mIB.mNZ.iterator();
        while (it.hasNext()) {
            arrayList.add(((a.a) it.next()).egr);
        }
        this.vp = (ViewPager) findViewById(R.h.pager);
        this.mIA = (MMPageControlView) findViewById(R.h.indicator);
        this.mIA.setIndicatorLayoutRes(R.i.page_control_image);
        this.mIA.setVisibility(0);
        this.vp.setOnTouchListener(new 3(this));
        this.vp.setOnPageChangeListener(new 4(this));
        a aVar = new a(this, this);
        this.vp.setAdapter(aVar);
        if (arrayList.size() > 0) {
            aVar.mIG = arrayList;
            aVar.mIE.mIA.eS(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.vp.setVisibility(0);
        }
        while (i < this.mIB.mOa.size()) {
            b bVar = (b) this.mIB.mOa.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(R.i.multiline_text_preference);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.gua.a(preference);
            i++;
        }
        this.gua.notifyDataSetChanged();
    }

    public final int Ys() {
        return R.o.product_further_info;
    }

    protected final int getLayoutId() {
        return R.i.product_further_info;
    }

    public final int auY() {
        return R.i.product_further_info_header;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
