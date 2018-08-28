package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;

public class ContactCountView extends FrameLayout {
    private boolean YN = true;
    private int count = 0;
    private View ern;
    private TextView kui;
    private int uix = 1;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ContactCountView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.i.contact_count_view, this);
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.ern == null) {
            this.ern = (FrameLayout) findViewById(R.h.contact_count_view_fl);
            this.kui = (TextView) findViewById(R.h.contact_count_tv);
        }
        cyd();
        super.onMeasure(i, i2);
    }

    public void setContactType(int i) {
        this.uix = i;
    }

    public final void cyd() {
        String[] strArr = s.dAV;
        if (this.uix == 1) {
            au.HU();
            this.count = c.FR().b(strArr, new String[]{q.GF(), "weixin", "helper_entry", "filehelper"});
        } else {
            au.HU();
            this.count = c.FR().c(strArr, new String[]{q.GF(), "weixin", "helper_entry", "filehelper"});
        }
        x.d("MicroMsg.ContactCountView", "contact count %d", new Object[]{Integer.valueOf(this.count)});
        if (this.kui != null) {
            if (this.uix == 1) {
                this.kui.setText(getContext().getResources().getQuantityString(R.j.address_contact_count, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.kui.setText(getContext().getResources().getQuantityString(R.j.address_chatroom_contact_count, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.YN);
    }

    public void setVisible(boolean z) {
        this.YN = z;
        if (this.ern != null) {
            View view = this.ern;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
    }
}
