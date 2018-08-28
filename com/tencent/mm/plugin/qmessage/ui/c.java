package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class c extends r<ai> implements b {
    private final MMActivity bGc;
    protected g hkN;
    protected com.tencent.mm.ui.base.MMSlideDelView.c hkO;
    protected f hkP;
    protected MMSlideDelView$d hkQ = MMSlideDelView.getItemStatusCallBack();

    public static class a {
        public ImageView eCl;
        public TextView eTm;
        public TextView hkS;
        public TextView hkT;
        public ImageView hkU;
        public TextView hkV;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ai aiVar = (ai) obj;
        if (aiVar == null) {
            aiVar = new ai();
        }
        aiVar.ed("");
        aiVar.ee("");
        aiVar.d(cursor);
        return aiVar;
    }

    public c(Context context, com.tencent.mm.ui.r.a aVar) {
        super(context, new ai());
        this.tlG = aVar;
        this.bGc = (MMActivity) context;
    }

    public final void WT() {
        au.HU();
        setCursor(com.tencent.mm.model.c.FW().Yy(s.dAQ));
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.hkP = fVar;
    }

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.hkO = cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        ai aiVar = (ai) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.bGc, R.i.tmessage_item, null);
            aVar2.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar2.eTm = (TextView) view.findViewById(R.h.nickname_tv);
            aVar2.hkS = (TextView) view.findViewById(R.h.update_time_tv);
            aVar2.hkT = (TextView) view.findViewById(R.h.last_msg_tv);
            aVar2.hkU = (ImageView) view.findViewById(R.h.state_iv);
            aVar2.hkV = (TextView) view.findViewById(R.h.tipcnt_tv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eTm.setText(com.tencent.mm.model.r.gT(aiVar.field_username));
        TextView textView = aVar.hkS;
        CharSequence string = aiVar.field_status == 1 ? this.bGc.getString(R.l.main_sending) : aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.bGc, aiVar.field_conversationTime, true);
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, aiVar.field_username);
        au.HU();
        az.b vu = com.tencent.mm.model.c.FW().vu();
        if (!bi.oW(aiVar.field_digest)) {
            if (bi.oW(aiVar.field_digestUser)) {
                string = aiVar.field_digest;
            } else {
                String displayName = (aiVar.field_isSend == 0 && s.fq(aiVar.field_username)) ? com.tencent.mm.model.r.getDisplayName(aiVar.field_digestUser, aiVar.field_username) : com.tencent.mm.model.r.gT(aiVar.field_digestUser);
                try {
                    string = String.format(aiVar.field_digest, new Object[]{displayName});
                } catch (Exception e) {
                }
            }
            aVar.hkT.setText(j.a(this.bGc, string, aVar.hkT.getTextSize()));
            switch (aiVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = R.k.msg_state_sending;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.k.msg_state_failed;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (i2 == -1) {
                aVar.hkU.setBackgroundResource(i2);
                aVar.hkU.setVisibility(0);
            } else {
                aVar.hkU.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (aiVar.field_unReadCount > 100) {
                aVar.hkV.setText("...");
                aVar.hkV.setVisibility(0);
            } else if (aiVar.field_unReadCount > 0) {
                aVar.hkV.setText(aiVar.field_unReadCount);
                aVar.hkV.setVisibility(0);
            } else {
                aVar.hkV.setVisibility(4);
            }
            view.setBackgroundResource(R.g.mm_listitem);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            return view;
        }
        string = vu.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.bGc);
        aVar.hkT.setText(j.a(this.bGc, string, aVar.hkT.getTextSize()));
        switch (aiVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.k.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.k.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 == -1) {
            aVar.hkU.setVisibility(8);
        } else {
            aVar.hkU.setBackgroundResource(i2);
            aVar.hkU.setVisibility(0);
        }
        i2 = view.getPaddingBottom();
        paddingTop = view.getPaddingTop();
        paddingRight = view.getPaddingRight();
        paddingLeft = view.getPaddingLeft();
        if (aiVar.field_unReadCount > 100) {
            aVar.hkV.setText("...");
            aVar.hkV.setVisibility(0);
        } else if (aiVar.field_unReadCount > 0) {
            aVar.hkV.setText(aiVar.field_unReadCount);
            aVar.hkV.setVisibility(0);
        } else {
            aVar.hkV.setVisibility(4);
        }
        view.setBackgroundResource(R.g.mm_listitem);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    private static int wW(String str) {
        int i = 1;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final void onPause() {
        if (this.hkQ != null) {
            this.hkQ.aYl();
        }
    }

    protected final void WS() {
        WT();
    }
}
