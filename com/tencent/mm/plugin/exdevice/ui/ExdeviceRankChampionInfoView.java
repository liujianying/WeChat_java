package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private TextPaint dG;
    private int duy = 0;
    private String gtX;
    private TextView hEx;
    private ImageView izS;

    public void setAlpha(float f) {
        this.hEx.setAlpha(f);
        this.izS.setAlpha(f);
    }

    public ExdeviceRankChampionInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.exdevice_rank_champion_info_view, this, true);
        this.dG = new TextPaint(1);
        this.hEx = (TextView) inflate.findViewById(R.h.titleTV);
        this.izS = (ImageView) inflate.findViewById(R.h.avatarIV);
        this.izS.setOnClickListener(new 1(this, context));
        this.hEx.setOnClickListener(new 2(this, context));
        try {
            this.duy = context.getResources().getDimensionPixelSize(R.f.ExdeviceUserNameWidth);
            if (this.duy <= 0) {
                this.duy = 128;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.duy <= 0) {
                this.duy = 128;
            }
        } catch (Throwable th) {
            if (this.duy <= 0) {
                this.duy = 128;
            }
        }
        x.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", new Object[]{Integer.valueOf(this.duy)});
    }

    public final void Av(String str) {
        this.gtX = str;
        if (this.hEx != null) {
            if (bi.oW(str)) {
                this.hEx.setVisibility(8);
                this.hEx.setText("");
            } else {
                this.hEx.setVisibility(0);
                Context context = getContext();
                int i = R.l.exdevice_champion_occupy_cover;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(j.a(getContext(), r.gT(this.gtX)), this.dG, (float) this.duy, TruncateAt.END);
                x.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", new Object[]{j.a(getContext(), context.getString(i, objArr))});
                this.hEx.setText(j.a(getContext(), r0, this.hEx.getTextSize()));
            }
        }
        if (this.izS == null) {
            return;
        }
        if (bi.oW(str)) {
            this.izS.setVisibility(4);
            return;
        }
        b.n(this.izS, str);
        this.izS.setVisibility(0);
    }
}
