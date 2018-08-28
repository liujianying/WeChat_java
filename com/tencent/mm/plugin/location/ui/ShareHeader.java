package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView eBO;
    private ViewGroup kFw;
    private MMImageButton kFx;
    private MMImageButton kFy;
    private Context mContext;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, f.share_header, this);
        this.kFw = (ViewGroup) inflate.findViewById(e.header_bar);
        this.kFx = (MMImageButton) inflate.findViewById(e.title_left_button);
        this.kFy = (MMImageButton) inflate.findViewById(e.title_right_button);
        this.eBO = (TextView) inflate.findViewById(e.title);
    }

    public ViewGroup getHeaderBar() {
        return this.kFw;
    }

    public void setOnLeftClickListener(OnClickListener onClickListener) {
        this.kFx.setOnClickListener(onClickListener);
    }

    public void setOnRightClickListener(OnClickListener onClickListener) {
        this.kFy.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.eBO.setText(str);
    }

    public void setTitleColor(int i) {
        this.eBO.setTextColor(i);
    }
}
