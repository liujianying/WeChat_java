package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View contentView;
    private Activity ftd;
    SnsUploadConfigView nLD;
    private ImageView nLz;
    private TextView nOx;
    private TextView nQM;
    private boolean nQN = true;
    private int nQO = 0;
    String nQP = "";
    private String nQQ = "";
    private String nQR = "";
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void setEnablePrivate(boolean z) {
        this.nQN = z;
    }

    public int getLabelRange() {
        return this.nQO;
    }

    private void init(Context context) {
        this.ftd = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.nQM = (TextView) this.contentView.findViewById(f.sns_tag_range_list);
        this.nOx = (TextView) this.contentView.findViewById(f.left_tv);
        this.nLz = (ImageView) this.contentView.findViewById(f.rang_icon);
        this.contentView.setOnClickListener(new 1(this));
    }

    private static List<String> aE(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Ek();
        if (!g.Eg().Dx()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Ek();
            ab Yg = ((i) g.l(i.class)).FR().Yg(obj2);
            if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                obj2 = Yg.BL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String c;
        this.nQO = intent.getIntExtra("Ktag_range_index", 0);
        this.nQQ = intent.getStringExtra("Klabel_name_list");
        this.nQR = intent.getStringExtra("Kother_user_name_list");
        int maxTagNameLen = getMaxTagNameLen();
        Object obj = "";
        if (!bi.oW(this.nQQ)) {
            obj = obj + this.nQQ;
        }
        if (!bi.oW(this.nQR)) {
            c = bi.c(aE(Arrays.asList(this.nQR.split(","))), ",");
            if (obj.length() > 0) {
                obj = obj + "," + c;
            } else {
                obj = obj + c;
            }
        }
        if (!(maxTagNameLen == -1 || obj == null || obj.length() <= maxTagNameLen)) {
            obj = obj.substring(0, maxTagNameLen) + "...";
        }
        maxTagNameLen = this.nQO;
        if (this.nLz != null) {
            this.nLz.setImageResource(com.tencent.mm.plugin.sns.i.i.album_group_icon_pressed);
            this.nOx.setTextColor(getResources().getColor(c.green_text_color));
            this.nQM.setTextColor(getResources().getColor(c.green_text_color));
        }
        if (this.nLD != null) {
            this.nLD.setPrivated(false);
        }
        switch (maxTagNameLen) {
            case 0:
                if (this.nLz != null) {
                    this.nLz.setImageResource(com.tencent.mm.plugin.sns.i.i.album_group_icon_normal);
                    this.nOx.setTextColor(getResources().getColor(c.normal_text_color));
                    this.nQM.setTextColor(getResources().getColor(c.hint_text_color));
                }
                this.nQM.setText(j.sns_label_public);
                break;
            case 1:
                if (this.nLD != null) {
                    this.nLD.setPrivated(true);
                }
                if (!(atContactWidget == null || this.nLD == null || atContactWidget.getAtList().size() <= 0)) {
                    h.i(this.ftd, j.sns_tag_privacy_with_others_tip, j.app_tip);
                    atContactWidget.bBN();
                    this.nLD.bEr();
                }
                this.nQM.setText(j.sns_label_private);
                break;
            case 2:
                this.nQM.setText(obj);
                break;
            case 3:
                TextView textView = this.nQM;
                c = this.ftd.getString(j.sns_label_exclide_prefix);
                obj = c + "  " + obj;
                CharSequence spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(-65536), c.length() + 2, obj.length(), 33);
                textView.setText(spannableString);
                break;
        }
        return true;
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.rang_layout;
    }

    protected int getMaxTagNameLen() {
        return -1;
    }
}
