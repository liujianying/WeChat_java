package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private String bNH;
    private String bSZ;
    private Context context;
    private ag handler = new ag(Looper.getMainLooper());
    private boolean hasCheck = true;
    private int nLs = 0;
    protected SnsPostDescPreloadTextView nMn;
    protected SnsTextView nMo;
    protected TextView nMp;
    private String nMq;
    private String nMr;
    private HashMap<String, Integer> nMs;
    private Runnable nMt = new 1(this);
    private boolean nkG = false;
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.nMq = this.context.getString(i$j.sns_desc_spread);
        this.nMr = this.context.getString(i$j.sns_desc_shrinkup);
        View inflate = y.gq(this.context).inflate(i$g.collapsible_textview, this);
        inflate.setPadding(0, -3, 0, 0);
        this.nMn = (SnsPostDescPreloadTextView) inflate.findViewById(i$f.desc_tv);
        this.nMp = (TextView) inflate.findViewById(i$f.desc_op_tv);
        this.nMo = (SnsTextView) inflate.findViewById(i$f.desc_tv_single);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, av avVar, String str3, boolean z) {
        this.context = avVar.bGc;
        this.nMs = hashMap;
        this.text = charSequence;
        this.nkG = z;
        this.bNH = str;
        this.bSZ = str2;
        this.nLs = i;
        this.nMq = this.context.getString(i$j.sns_desc_spread);
        this.nMr = this.context.getString(i$j.sns_desc_shrinkup);
        this.nMo.setOriginText(str3);
        as asVar = new as(this.bSZ, this.bNH, false, false, 1);
        if (i == 0) {
            this.nMn.setText(str3);
            this.nMo.setVisibility(8);
            this.nMp.setVisibility(0);
            this.nMn.setVisibility(0);
            this.nMn.setOnTouchListener(new m(this.context));
            this.nMn.setTag(asVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.nMp.setVisibility(8);
                this.nMn.setMaxLines(7);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.nMp.setVisibility(8);
                    return;
                case 1:
                    this.nMn.setMaxLines(6);
                    this.nMp.setVisibility(0);
                    this.nMp.setText(this.nMq);
                    return;
                case 2:
                    this.nMn.setMaxLines(Integer.MAX_VALUE);
                    this.nMp.setVisibility(0);
                    this.nMp.setText(this.nMr);
                    return;
                default:
                    return;
            }
        }
        this.nMo.setText(charSequence, bufferType);
        this.nMo.setTag(asVar);
        this.nMo.setVisibility(0);
        this.nMp.setVisibility(8);
        this.nMn.setVisibility(8);
        this.nMo.setOnClickListener(avVar.ntw.okQ);
    }

    public int getSpreadHeight() {
        x.i("MicroMsg.CollapsibleTextView", "count:" + this.nMn.getLineCount() + "  height:" + this.nMn.getLineHeight());
        return (this.nMn.getLineCount() - 6) * this.nMn.getLineHeight();
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        if (this.nMp != null) {
            this.nMp.setOnClickListener(onClickListener);
        }
    }

    public void setLongClickable(boolean z) {
        this.nMp.setLongClickable(z);
        this.nMo.setLongClickable(z);
        this.nMn.setLongClickable(z);
        super.setLongClickable(z);
    }

    public void setClickable(boolean z) {
        this.nMp.setClickable(z);
        this.nMo.setClickable(z);
        this.nMn.setClickable(z);
        super.setClickable(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nLs == 0 && !this.nkG && !this.hasCheck) {
            this.hasCheck = true;
            if (this.nMn.getLineCount() <= 6) {
                this.nMs.put(this.bNH, Integer.valueOf(0));
                return;
            }
            this.nMs.put(this.bNH, Integer.valueOf(1));
            this.handler.post(this.nMt);
        }
    }
}
