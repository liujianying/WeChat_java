package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> kYn;
    private r kYo;
    private TextView kYp = ((TextView) LayoutInflater.from(getContext()).inflate(g.banner_activity_view, this, true).findViewById(f.mall_banner_wording));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(new 1(this));
    }

    public void setData(r rVar) {
        this.kYo = rVar;
        if (this.kYo != null) {
            this.kYp.setText(this.kYo.field_bulletin_content);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void setActivityList(List<a> list) {
        this.kYn = list;
        if (this.kYn == null || this.kYn.size() <= 0) {
            x.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
        } else if (b.cE(this.kYn)) {
            this.kYp.setText(((a) this.kYn.get(0)).prQ);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }
}
