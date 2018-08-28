package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.y;

public final class e extends LinearLayout {
    ImageView hBu;
    TextView iDE;
    b jKc;
    ImageView jKd;
    public i jKe;
    private a jKf;
    public c jKg = null;
    private Context mContext;

    public e(b bVar) {
        super(bVar.getContext());
        this.mContext = bVar.getContext();
        this.jKc = bVar;
        this.jKe = new g(bVar);
        setLayoutParams(new LayoutParams(-1, getActionBarHeight()));
        setBackgroundResource(R.e.action_bar_color);
        View inflate = y.gq(getContext()).inflate(R.i.game_webview_action_bar, this, false);
        addView(inflate);
        this.hBu = (ImageView) inflate.findViewById(R.h.actionbar_back);
        this.hBu.setOnClickListener(new 1(this));
        this.iDE = (TextView) inflate.findViewById(R.h.title);
        this.jKd = (ImageView) inflate.findViewById(R.h.actionbar_option_btn);
        this.jKd.setOnClickListener(new 2(this));
    }

    public final void setTitleText(String str) {
        this.iDE.setText(str);
    }

    public final void setTitleColor(int i) {
        this.iDE.setTextColor(i);
    }

    public final void aTe() {
        if (this.jKe != null) {
            this.jKe.aTe();
        }
    }

    private int getActionBarHeight() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return this.mContext.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
        }
        return this.mContext.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    }

    public final void setCloseWindowConfirmInfo(Bundle bundle) {
        this.jKf = bundle == null ? null : new a(bundle);
    }

    public final boolean aST() {
        if (this.jKf != null) {
            a aVar = this.jKf;
            boolean z = (!aVar.jIv || bi.oW(aVar.aSC()) || bi.oW(aVar.aSD()) || bi.oW(aVar.aSE())) ? false : true;
            if (z) {
                x.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[]{this.jKf.aSC(), this.jKf.aSD(), this.jKf.aSE()});
                View inflate = View.inflate(getContext(), R.i.mm_alert_checkbox, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.mm_alert_dialog_cb);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_info);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.normal_text_color));
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_cb_txt);
                textView.setTextColor(getResources().getColor(R.e.normal_text_color));
                textView.setVisibility(8);
                this.jKg = h.a(getContext(), true, "", inflate, r4, r5, new 3(this), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.this.jKg = null;
                    }
                });
                return true;
            }
        }
        return false;
    }
}
