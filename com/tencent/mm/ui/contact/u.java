package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class u extends LinearLayout {
    private Context context;
    private LinearLayout jeZ = null;
    private List<String> ulf;
    private a ulg;
    private b ulh;

    public interface b {
        void mh(boolean z);
    }

    public u(Context context, a aVar) {
        super(context);
        this.context = context;
        this.ulg = aVar;
        reset();
    }

    public final int getOpenIMCount() {
        if (this.ulf == null) {
            return 0;
        }
        return this.ulf.size();
    }

    public final void reset() {
        int i = 0;
        au.HU();
        this.ulf = c.FR().cli();
        if (this.ulf == null || this.ulf.size() <= 0) {
            x.i("MicroMsg.OpenIMListHeaderView", "openimIdList is null");
            return;
        }
        x.i("MicroMsg.OpenIMListHeaderView", "openim list size = %s", new Object[]{Integer.valueOf(this.ulf.size())});
        if (this.jeZ == null) {
            View.inflate(getContext(), R.i.openim_in_addressui_header, this);
            this.jeZ = (LinearLayout) findViewById(R.h.container);
        }
        this.jeZ.removeAllViews();
        while (i < this.ulf.size()) {
            v vVar = new v(getContext(), (String) this.ulf.get(i));
            this.jeZ.addView(vVar);
            if (i == this.ulf.size() - 1) {
                vVar.findViewById(R.h.enterprise_biz_item_ll).setBackgroundResource(R.g.mm_trans);
            }
            i++;
        }
    }

    public final void setVisibility(int i) {
        if (!(this.ulh == null || i == getVisibility())) {
            this.ulh.mh(i == 0);
        }
        super.setVisibility(i);
    }

    public final void setOnVisibilityChangeListener(b bVar) {
        this.ulh = bVar;
    }
}
