package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bo;

public class FMessageListView extends LinearLayout {
    private Context context;
    private final LayoutParams jZp;
    private com.tencent.mm.sdk.e.j.a qOA;
    private com.tencent.mm.sdk.e.j.a qOB;
    private a qOC;
    private a qOD;
    private TextView qOE;
    private com.tencent.mm.pluginsdk.ui.preference.a.a qOs;
    private com.tencent.mm.pluginsdk.c.a qOz;

    static class a extends View {
        public a(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, 1));
        }
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = " + j);
        ba baVar = new ba();
        if (!d.SG().b(j, baVar)) {
            x.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = " + j);
        } else if (fMessageListView.qOs == null || !fMessageListView.qOs.talker.equals(baVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
        } else {
            if (fMessageListView.qOs.juZ != null && fMessageListView.qOs.juZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, baVar));
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = " + j);
        at atVar = new at();
        if (!d.SE().b(j, atVar)) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = " + j);
        } else if (fMessageListView.qOs == null || !fMessageListView.qOs.talker.equals(atVar.field_talker)) {
            x.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
        } else {
            if (fMessageListView.qOs.juZ != null && fMessageListView.qOs.juZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, atVar));
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = " + j);
        bo boVar = new bo();
        if (!d.SH().b(j, boVar)) {
            x.e("MicroMsg.FMessageListView", "updateShake, get fail, id = " + j);
        } else if (fMessageListView.qOs == null || !fMessageListView.qOs.talker.equals(boVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
        } else {
            if (fMessageListView.qOs.juZ != null && fMessageListView.qOs.juZ.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, boVar));
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.qOz = new 1(this);
        this.qOA = new 2(this);
        this.qOB = new 3(this);
        this.jZp = new LayoutParams(-1, -2);
        this.context = context;
        d.SE().c(this.qOA);
        com.tencent.mm.pluginsdk.c.a.a(iq.class.getName(), this.qOz);
        d.SH().c(this.qOB);
    }

    public void setFMessageArgs(com.tencent.mm.pluginsdk.ui.preference.a.a aVar) {
        this.qOs = aVar;
        a.setFMessageArgs(aVar);
    }

    public final void detach() {
        d.SE().d(this.qOA);
        com.tencent.mm.pluginsdk.c.a.b(iq.class.getName(), this.qOz);
        d.SH().d(this.qOB);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                a aVar = (a) childAt;
                au.DF().b(30, aVar);
                if (aVar.tipDialog != null && aVar.tipDialog.isShowing()) {
                    aVar.tipDialog.dismiss();
                }
            }
        }
        this.qOC = null;
        this.qOD = null;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
        } else if (bVar.id <= 0) {
            x.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
        } else {
            int i;
            String str;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    x.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    return;
                }
            }
            if (bVar.qOI != null) {
                if (this.qOE == null) {
                    this.qOE = (TextView) findViewById(R.h.contact_info_fmessage_listview_safewarning_tv);
                }
                this.qOE.setText(bVar.qOI);
                this.qOE.setVisibility(0);
            }
            x.d("MicroMsg.FMessageListView", "addItem, current child count = " + childCount);
            if (childCount == 6) {
                x.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                x.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.qOC = new a(this.context);
                addView(this.qOC);
                this.qOD = new a(this.context);
                this.qOD.setContentText("");
                this.qOD.setBtnVisibility(0);
                addView(this.qOD, this.jZp);
                au.HU();
                ab Yg = c.FR().Yg(bVar.username);
                if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.qOC.setVisibility(0);
                    this.qOD.setVisibility(0);
                } else {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.qOC.setVisibility(8);
                    this.qOD.setVisibility(8);
                }
            }
            if (bVar.ceW) {
                String string = this.context.getString(R.l.fmessage_reply, new Object[]{bVar.dzA});
                i = 0;
                str = string;
            } else {
                String str2;
                if (bVar.nickname == null || bVar.nickname.length() <= 0) {
                    str2 = bVar.username;
                    au.HU();
                    ab Yg2 = c.FR().Yg(bVar.username);
                    if (Yg2 != null && ((int) Yg2.dhP) > 0) {
                        str2 = Yg2.BL();
                    }
                } else {
                    str2 = bVar.nickname;
                }
                String str3 = str2 + ": " + bVar.dzA;
                i = 1;
                str = str3;
            }
            a aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.setContentText(str);
            aVar.setBtnVisibility(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new 4(this, bVar));
            }
            addView(aVar, getChildCount() - 2, this.jZp);
        }
    }

    public void setReplyBtnVisible(boolean z) {
        int i = 0;
        int childCount = getChildCount();
        x.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
        if (childCount <= 2) {
            x.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + childCount);
            return;
        }
        if (this.qOC != null) {
            a aVar = this.qOC;
            if (z) {
                childCount = 0;
            } else {
                childCount = 8;
            }
            aVar.setVisibility(childCount);
        }
        if (this.qOD != null) {
            a aVar2 = this.qOD;
            if (!z) {
                i = 8;
            }
            aVar2.setVisibility(i);
        }
    }
}
