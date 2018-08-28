package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.y;

public class NotInterestMenu extends LinearLayout {
    private static int[] nhx = new int[]{j.sns_hate_op_un_like, j.sns_hate_op_block, j.sns_hate_op_expose};
    private Context mContext = null;
    private n nhc = null;
    private ListView nhw;
    private c nhy = null;
    private b nhz = null;

    public NotInterestMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public void setOnSelectMenuItemListener(c cVar) {
        this.nhy = cVar;
    }

    public void setOnClickMenuListener(b bVar) {
        this.nhz = bVar;
    }

    public void setSnsInfo(n nVar) {
        this.nhc = nVar;
    }

    private void init() {
        y.gq(this.mContext).inflate(g.not_interest_menu_content, this);
        this.nhw = (ListView) findViewById(f.not_interest_list);
        this.nhw.setAdapter(new a(this));
        this.nhw.setOnItemClickListener(new 1(this));
    }
}
