package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View contentView;
    private Activity ftd;
    private TextView nLA;
    private TextView nLB;
    private PreviewContactView nLC;
    SnsUploadConfigView nLD;
    private List<String> nLE = new LinkedList();
    private boolean nLF = false;
    private ImageView nLz;

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        if (atContactWidget.nLE == null) {
            atContactWidget.nLE = new LinkedList();
        }
        if (atContactWidget.nLD == null || atContactWidget.nLD.getPrivated() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.ftd.getString(i$j.sns_with_you));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", q.GF());
            intent.putExtra("Select_Contact", bi.c(atContactWidget.nLE, ","));
            intent.putExtra("sns_address_count", 0);
            a.ezn.a(intent, atContactWidget.ftd, 6);
            return;
        }
        h.i(atContactWidget.ftd, i$j.sns_tag_privacy_with_others_tip, i$j.app_tip);
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public List<String> getAtList() {
        if (this.nLE == null) {
            this.nLE = new LinkedList();
        }
        return this.nLE;
    }

    public final void bBN() {
        if (this.nLE == null) {
            this.nLE = new LinkedList();
        }
        this.nLE.clear();
        if (this.nLC != null) {
            this.nLC.setList(this.nLE);
        }
        bBO();
        if (this.nLA != null) {
            this.nLA.setVisibility(8);
        }
        if (this.nLB != null) {
            this.nLB.setTextColor(getResources().getColor(c.normal_text_color));
        }
    }

    private void init(Context context) {
        this.ftd = (Activity) context;
        this.contentView = y.gq(context).inflate(getLayoutResource(), this);
        this.nLC = (PreviewContactView) this.contentView.findViewById(i$f.at_contact_avatar);
        this.nLz = (ImageView) this.contentView.findViewById(i$f.at_contact_iv);
        this.nLA = (TextView) this.contentView.findViewById(i$f.at_contact_num);
        this.nLB = (TextView) this.contentView.findViewById(i$f.at_contact_tips);
        this.contentView.setOnClickListener(new 1(this));
        this.contentView.post(new 2(this));
    }

    public final boolean Y(Intent intent) {
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        if (stringExtra == null || stringExtra.equals("")) {
            List linkedList2 = new LinkedList();
        } else {
            Object linkedList22 = bi.F(stringExtra.split(","));
        }
        if (this.nLE == null) {
            this.nLE = new LinkedList();
        }
        this.nLE.clear();
        for (String stringExtra2 : linkedList22) {
            if (!this.nLE.contains(stringExtra2)) {
                this.nLE.add(stringExtra2);
            }
        }
        if (this.nLC != null) {
            this.nLC.setList(this.nLE);
        }
        if (this.nLB != null) {
            this.nLB.setTextColor(getResources().getColor(linkedList22.isEmpty() ? c.normal_text_color : c.green_text_color));
        }
        if (this.nLF) {
            x.d("MicroMsg.AtContactWiget", "withList count " + this.nLE.size());
            if (!this.nLF || this.nLA == null || this.nLE.size() <= 0) {
                this.nLA.setVisibility(8);
            } else {
                this.nLA.setVisibility(0);
                if (this.nLE.size() < 100) {
                    this.nLA.setText(this.nLE.size());
                } else {
                    this.nLA.setText(i$j.unread_count_overt_100);
                }
            }
        }
        bBO();
        return true;
    }

    private void bBO() {
        if (this.nLE.size() > 0) {
            this.nLz.setImageResource(getWithDrawableId());
        } else {
            this.nLz.setImageResource(getWithEmptyDrawableId());
        }
    }

    public void setShowAtList(boolean z) {
        if (this.nLC != null) {
            this.nLC.setVisibility(z ? 0 : 8);
        }
    }

    public void setShowAtTips(boolean z) {
        if (this.contentView != null && this.nLB != null) {
            this.nLB.setVisibility(z ? 0 : 8);
        }
    }

    public void setShowAtNum(boolean z) {
        this.nLF = z;
    }

    protected int getLayoutResource() {
        return i$g.at_contact_widget;
    }

    protected int getWithDrawableId() {
        return i$i.album_mention_icon_pressed;
    }

    protected int getWithEmptyDrawableId() {
        return i$i.album_mention_icon_normal;
    }
}
