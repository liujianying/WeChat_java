package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectMemberUI$b extends BaseAdapter {
    volatile boolean acT = false;
    List<a> bTR = new ArrayList();
    public String dBm;
    private u hLB;
    private String hMQ;
    String hOQ = null;
    List<a> hOR = new ArrayList(0);
    private c hOk;
    final /* synthetic */ SelectMemberUI hPv;
    public final String hPy = new String(Character.toChars(91));
    HashMap<String, Integer> hPz = new HashMap();
    private Context mContext;

    static /* synthetic */ void b(SelectMemberUI$b selectMemberUI$b) {
        if (selectMemberUI$b.bTR != null) {
            Object obj = null;
            int i = 0;
            for (a aVar : selectMemberUI$b.bTR) {
                String oI;
                if (aVar.guS != null) {
                    oI = h.oI(selectMemberUI$b.c(aVar.guS));
                    oI = bi.oW(oI) ? "" : oI.startsWith(selectMemberUI$b.hPy) ? "#" : oI.toUpperCase().substring(0, 1);
                    if (i == 0) {
                        selectMemberUI$b.hPz.put(oI, Integer.valueOf(i));
                    } else if (!(obj == null || oI.equals(obj))) {
                        selectMemberUI$b.hPz.put(oI, Integer.valueOf(i));
                    }
                } else {
                    oI = null;
                }
                i++;
                String obj2 = oI;
            }
        }
    }

    public SelectMemberUI$b(SelectMemberUI selectMemberUI, Context context, u uVar, String str, String str2) {
        this.hPv = selectMemberUI;
        this.hLB = uVar;
        this.hMQ = str;
        this.hOQ = str2;
        this.mContext = context;
        this.hOk = au.HU();
    }

    public final void yt(String str) {
        x.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
        List arrayList = new ArrayList();
        if (bi.oW(str)) {
            this.bTR = this.hOR;
            return;
        }
        for (a aVar : this.hOR) {
            if (!(aVar == null || aVar.guS == null || aVar.type != 1)) {
                ab abVar = aVar.guS;
                if (abVar.field_conRemark != null && abVar.field_conRemark.contains(str)) {
                    arrayList.add(aVar);
                } else if (!bi.oW(SeeRoomMemberUI.a(this.hLB, abVar.field_username)) && SeeRoomMemberUI.a(this.hLB, abVar.field_username).contains(str)) {
                    arrayList.add(aVar);
                } else if (abVar.BK() != null && abVar.BK().contains(str)) {
                    arrayList.add(aVar);
                } else if (abVar.wP() != null && abVar.wP().contains(str)) {
                    arrayList.add(aVar);
                } else if (abVar.wM() != null && abVar.wM().contains(str)) {
                    arrayList.add(aVar);
                } else if (abVar.field_username != null && abVar.field_username.contains(str)) {
                    arrayList.add(aVar);
                } else if (!com.tencent.mm.l.a.gd(abVar.field_type)) {
                    au.HU();
                    bq Hh = c.FS().Hh(abVar.field_username);
                    if (!(Hh == null || Hh.field_conRemark == null || !Hh.field_conRemark.contains(str))) {
                        arrayList.add(aVar);
                    }
                }
            }
        }
        this.bTR = arrayList;
    }

    public final int getCount() {
        if (this.bTR == null || this.acT) {
            return 0;
        }
        return this.bTR.size();
    }

    /* renamed from: ok */
    public final a getItem(int i) {
        if (this.bTR.size() > i) {
            return (a) this.bTR.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SelectMemberUI.c cVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.select_member_item, null);
            SelectMemberUI.c cVar2 = new SelectMemberUI.c((byte) 0);
            cVar2.hPe = (MaskLayout) view.findViewById(R.h.select_owner_item_avatar);
            cVar2.eMf = (TextView) view.findViewById(R.h.select_owner_item_nick);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            cVar2.eMf.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            cVar2.hPf = (TextView) view.findViewById(R.h.select_owner_item_desc);
            cVar2.hPf.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (SelectMemberUI.c) view.getTag();
        }
        a ok = getItem(i);
        if (ok == null) {
            x.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(getCount())});
        } else {
            ab abVar = ok.guS;
            b.a((ImageView) cVar.hPe.getContentView(), abVar.field_username);
            if (abVar.field_verifyFlag == 0) {
                cVar.hPe.setMaskDrawable(null);
            } else if (am.a.dBt != null) {
                String gY = am.a.dBt.gY(abVar.field_verifyFlag);
                if (gY != null) {
                    cVar.hPe.f(m.kU(gY), MaskLayout.a.tzk);
                } else {
                    cVar.hPe.setMaskDrawable(null);
                }
            } else {
                cVar.hPe.setMaskDrawable(null);
            }
            CharSequence c = c(abVar);
            CharSequence charSequence = "";
            if (com.tencent.mm.l.a.gd(abVar.field_type)) {
                charSequence = abVar.csT;
            }
            if (bi.oW(charSequence)) {
                cVar.hPf.setVisibility(8);
                cVar.hPf.setText("");
            } else {
                cVar.hPf.setVisibility(0);
                cVar.hPf.setText(j.a(this.mContext, charSequence, cVar.hPf.getTextSize()));
            }
            cVar.eMf.setText(j.a(this.mContext, c, cVar.eMf.getTextSize()));
        }
        return view;
    }

    private String c(ab abVar) {
        String a;
        if (bi.oW(abVar.field_conRemark)) {
            a = SelectMemberUI.a(this.hLB, abVar.field_username);
        } else {
            a = abVar.field_conRemark;
        }
        if (bi.oW(a)) {
            a = abVar.BK();
        }
        if (com.tencent.mm.l.a.gd(abVar.field_type)) {
            return a;
        }
        au.HU();
        bq Hh = c.FS().Hh(abVar.field_username);
        if (Hh == null || bi.oW(Hh.field_conRemark)) {
            return a;
        }
        return Hh.field_conRemark;
    }
}
