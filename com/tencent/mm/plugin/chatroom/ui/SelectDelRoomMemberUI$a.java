package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.List;

class SelectDelRoomMemberUI$a extends BaseAdapter {
    static List<ab> bTR = new ArrayList();
    static List<ab> hOR;
    String dBm;
    private String fsV;
    private List<String> gRN;
    u hLB;
    private String hOQ = null;
    private c hOk;
    a hPc = null;
    private Context mContext;

    private static class a {
        public TextView eMf;
        public MaskLayout hPe;
        public TextView hPf;
        public ImageView hPg;
        public ImageButton hPh;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public SelectDelRoomMemberUI$a(Context context, u uVar, String str, List<String> list, String str2) {
        this.hLB = uVar;
        this.fsV = str;
        this.gRN = list;
        this.mContext = context;
        this.hOQ = str2;
        this.hOk = au.HU();
        aG(m.gI(str));
    }

    public final void aG(List<String> list) {
        if (list != null) {
            bTR.clear();
            for (int i = 0; i < list.size(); i++) {
                ab Yg = c.FR().Yg((String) list.get(i));
                if (Yg == null || !Yg.field_username.equals(this.hOQ)) {
                    bTR.add(Yg);
                } else {
                    bTR.add(0, Yg);
                }
            }
            hOR = bTR;
            notifyDataSetChanged();
        }
    }

    public static ab oj(int i) {
        return (ab) bTR.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ab abVar = (ab) bTR.get(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.delete_roommember_item, null);
            this.hPc = new a();
            this.hPc.hPe = (MaskLayout) view.findViewById(R.h.see_roommember_avatar);
            this.hPc.eMf = (TextView) view.findViewById(R.h.see_roommember_name);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            this.hPc.eMf.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            this.hPc.hPf = (TextView) view.findViewById(R.h.see_roommember_decs);
            this.hPc.hPf.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            this.hPc.hPg = (ImageView) view.findViewById(R.h.room_info_contact_owner);
            this.hPc.hPh = (ImageButton) view.findViewById(R.h.btn_select);
            view.setTag(this.hPc);
            view2 = view;
        } else {
            this.hPc = (a) view.getTag();
            view2 = view;
        }
        if (abVar != null) {
            final String str;
            CharSequence charSequence;
            CharSequence charSequence2;
            this.hPc.eMf.setTextColor(com.tencent.mm.bp.a.ac(this.mContext, !s.hO(abVar.field_username) ? R.e.mm_list_textcolor_one : R.e.mm_list_textcolor_spuser));
            if (this.hLB.field_roomowner.equals(abVar.field_username)) {
                this.hPc.hPh.setVisibility(8);
                ((LargeTouchableAreasItemView) view2).setOnLargeTouchableAreasListener(null);
            } else {
                if (((SelectDelRoomMemberUI) this.mContext).eCr.contains(abVar.field_username)) {
                    ((LargeTouchableAreasItemView) view2).setItemViewSelected(true);
                } else {
                    ((LargeTouchableAreasItemView) view2).setItemViewSelected(false);
                }
                this.hPc.hPh.setVisibility(0);
                str = abVar.field_username;
                ((LargeTouchableAreasItemView) view2).setOnLargeTouchableAreasListener(new com.tencent.mm.plugin.chatroom.ui.LargeTouchableAreasItemView.a() {
                    public final void dZ(boolean z) {
                        if (z) {
                            ((SelectDelRoomMemberUI) SelectDelRoomMemberUI$a.this.mContext).eCr.add(str);
                        } else {
                            ((SelectDelRoomMemberUI) SelectDelRoomMemberUI$a.this.mContext).eCr.remove(str);
                        }
                        SelectDelRoomMemberUI.f((SelectDelRoomMemberUI) SelectDelRoomMemberUI$a.this.mContext);
                    }
                });
            }
            b.a((ImageView) this.hPc.hPe.getContentView(), abVar.field_username);
            if (abVar.field_verifyFlag == 0) {
                this.hPc.hPe.setMaskDrawable(null);
            } else if (com.tencent.mm.model.am.a.dBt != null) {
                String gY = com.tencent.mm.model.am.a.dBt.gY(abVar.field_verifyFlag);
                if (gY != null) {
                    this.hPc.hPe.f(com.tencent.mm.ac.m.kU(gY), com.tencent.mm.ui.base.MaskLayout.a.tzk);
                } else {
                    this.hPc.hPe.setMaskDrawable(null);
                }
            } else {
                this.hPc.hPe.setMaskDrawable(null);
            }
            str = SelectDelRoomMemberUI.b(this.hLB, abVar.field_username);
            if (bi.oW(abVar.field_conRemark)) {
                Object charSequence3 = str;
            } else {
                charSequence3 = abVar.field_conRemark;
            }
            if (bi.oW(charSequence3)) {
                charSequence3 = abVar.BK();
            }
            if (!(str == null || str.equals("") || charSequence3.equals(str))) {
                charSequence3 = str + "( " + charSequence3 + " )";
            }
            str = "";
            if (com.tencent.mm.l.a.gd(abVar.field_type)) {
                charSequence2 = abVar.csT;
            } else {
                au.HU();
                bq Hh = c.FS().Hh(abVar.field_username);
                if (Hh != null) {
                    charSequence2 = Hh.field_conDescription;
                    if (!bi.oW(Hh.field_conRemark)) {
                        charSequence3 = Hh.field_conRemark;
                    }
                } else {
                    Object charSequence22 = str;
                }
            }
            if (bi.oW(charSequence22)) {
                this.hPc.hPf.setText("");
            } else {
                this.hPc.hPf.setText(j.a(this.mContext, charSequence22, this.hPc.hPf.getTextSize()));
            }
            this.hPc.eMf.setText(j.a(this.mContext, charSequence3, this.hPc.eMf.getTextSize()));
        }
        return view2;
    }

    public final int getCount() {
        return bTR.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
