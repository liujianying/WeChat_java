package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends RelativeLayout {
    private LayoutInflater eMa;
    private int ucc;

    public r(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        this.eMa = layoutInflater;
        this.ucc = i;
        View inflate = this.eMa.inflate(R.i.chatting_history_msg_tip_layout, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        inflate.setId(R.h.chatting_histroy_msg_tip);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        inflate = new TextView(getContext(), null, R.m.ChattingUISplit);
        inflate.setId(R.h.chatting_time_tv);
        int dimensionPixelSize = inflate.getResources().getDimensionPixelSize(R.f.SmallestTextSize);
        if (a.ad(getContext(), R.f.SmallestTextSize) != dimensionPixelSize) {
            x.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", new Object[]{Integer.valueOf(a.ad(getContext(), R.f.SmallestTextSize)), Integer.valueOf(dimensionPixelSize)});
        }
        inflate.setTextSize(0, (float) dimensionPixelSize);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.h.chatting_histroy_msg_tip);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.NormalPadding), 0, getResources().getDimensionPixelSize(R.f.NormalPadding));
        addView(inflate, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(R.i.mm_big_checkbox, this, false);
        checkBox.setId(R.h.chatting_checkbox);
        dimensionPixelSize = a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(R.f.BasicPaddingSize), getResources().getDimensionPixelSize(R.f.SmallPadding), 0);
        layoutParams2.addRule(3, R.h.chatting_time_tv);
        layoutParams2.addRule(11);
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        addView(checkBox, layoutParams2);
        View inflate2 = this.eMa.inflate(this.ucc, null);
        int id = inflate2.getId();
        if (-1 == id) {
            x.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = R.h.chatting_content_area;
            inflate2.setId(R.h.chatting_content_area);
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, R.h.chatting_time_tv);
        layoutParams2.addRule(0, R.h.chatting_checkbox);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(R.h.chatting_maskview);
        inflate2.setVisibility(8);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
    }
}
