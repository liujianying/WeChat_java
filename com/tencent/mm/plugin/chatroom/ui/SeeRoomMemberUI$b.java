package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.List;

class SeeRoomMemberUI$b extends BaseAdapter {
    private List<a> bTR = new ArrayList();
    public String dBm;
    private String fsV;
    private List<String> gRN;
    private u hLB;
    final /* synthetic */ SeeRoomMemberUI hOM;
    private boolean hOP = false;
    private String hOQ = null;
    private List<a> hOR;
    private c hOk;
    private Context mContext;

    public SeeRoomMemberUI$b(SeeRoomMemberUI seeRoomMemberUI, Context context, u uVar, String str, List<String> list, String str2) {
        this.hOM = seeRoomMemberUI;
        this.hLB = uVar;
        this.fsV = str;
        this.gRN = list;
        this.hOQ = str2;
        this.mContext = context;
        this.hOk = au.HU();
        aG(m.gI(str));
    }

    public final void aG(List<String> list) {
        if (list != null) {
            this.bTR.clear();
            for (int i = 0; i < list.size(); i++) {
                ab Yg = c.FR().Yg((String) list.get(i));
                if (Yg == null || !Yg.field_username.equals(this.hOQ)) {
                    this.bTR.add(new a(1, Yg));
                } else {
                    this.bTR.add(0, new a(1, Yg));
                }
            }
            this.bTR.add(new a(2, null));
            if (SeeRoomMemberUI.j(this.hOM)) {
                this.bTR.add(new a(3, null));
            }
            this.hOR = this.bTR;
            notifyDataSetChanged();
        }
    }

    /* renamed from: oi */
    public final a getItem(int i) {
        return (a) this.bTR.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SeeRoomMemberUI.c cVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.see_roommember_item, null);
            cVar = new SeeRoomMemberUI.c((byte) 0);
            cVar.eCl = (ImageView) view.findViewById(R.h.see_roommember_avatar);
            cVar.eMf = (TextView) view.findViewById(R.h.see_roommember_name);
            cVar.eMf.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
            view.setTag(cVar);
        } else {
            cVar = (SeeRoomMemberUI.c) view.getTag();
        }
        a aVar = (a) this.bTR.get(i);
        if (aVar != null && aVar.type == 1) {
            CharSequence charSequence;
            ab abVar = aVar.guS;
            b.a(cVar.eCl, abVar.field_username);
            String a = SeeRoomMemberUI.a(this.hLB, abVar.field_username);
            if (bi.oW(abVar.field_conRemark)) {
                Object charSequence2 = a;
            } else {
                charSequence2 = abVar.field_conRemark;
            }
            if (bi.oW(charSequence2)) {
                charSequence2 = abVar.BK();
            }
            if (!(a == null || a.equals("") || charSequence2.equals(a))) {
                charSequence2 = a + "( " + charSequence2 + " )";
            }
            cVar.eMf.setVisibility(0);
            cVar.eMf.setText(j.a(this.mContext, charSequence2, cVar.eMf.getTextSize()));
        } else if (aVar != null && aVar.type == 2) {
            cVar.eMf.setVisibility(4);
            cVar.eCl.setImageResource(R.g.big_add_selector);
        } else if (aVar != null && aVar.type == 3) {
            cVar.eMf.setVisibility(4);
            cVar.eCl.setImageResource(R.g.big_del_selector);
        }
        return view;
    }

    public final void yr(String str) {
        this.hOP = true;
        this.dBm = str;
        List arrayList = new ArrayList();
        if (bi.oW(str)) {
            this.bTR = this.hOR;
        } else {
            for (a aVar : this.hOR) {
                if (!(aVar == null || aVar.guS == null || aVar.type != 1)) {
                    ab abVar = aVar.guS;
                    if (abVar.field_conRemark != null && abVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (!bi.oW(SeeRoomMemberUI.a(this.hLB, abVar.field_username)) && SeeRoomMemberUI.a(this.hLB, abVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (abVar.BK() != null && abVar.BK().toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (abVar.wP() != null && abVar.wP().toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (abVar.wM() != null && abVar.wM().contains(str)) {
                        arrayList.add(aVar);
                    } else if (abVar.field_username != null && abVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!com.tencent.mm.l.a.gd(abVar.field_type)) {
                        au.HU();
                        bq Hh = c.FS().Hh(abVar.field_username);
                        if (!(Hh == null || Hh.field_conRemark == null || !Hh.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            x.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
            this.bTR = arrayList;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.bTR.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
