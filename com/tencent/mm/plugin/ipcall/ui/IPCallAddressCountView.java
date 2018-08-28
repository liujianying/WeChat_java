package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View ern;
    private TextView kui;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        init();
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        setAddressCount(i);
    }

    private void init() {
        inflate(getContext(), R.i.ip_call_address_count_view, this);
        this.ern = findViewById(R.h.contact_count_view_fl);
        this.kui = (TextView) findViewById(R.h.contact_count_tv);
    }

    public void setAddressCount(int i) {
        this.kui.setText(getContext().getResources().getQuantityString(R.j.address_contact_count, i, new Object[]{Integer.valueOf(i)}));
    }
}
