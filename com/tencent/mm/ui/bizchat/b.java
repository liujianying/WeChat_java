package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import java.util.HashMap;

public final class b extends r<com.tencent.mm.ac.a.a> implements com.tencent.mm.sdk.e.m.b {
    private c hOC = null;
    protected g hkN;
    protected MMSlideDelView$c hkO;
    protected f hkP;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    private final String hpJ;
    private final MMFragmentActivity tEg;
    private float tEh = -1.0f;
    private float tEi = -1.0f;
    private float tEj = -1.0f;
    private ColorStateList[] tEk = new ColorStateList[5];
    HashMap<String, a> tEl;

    private class a {
        String dQn;
        public boolean hEj;
        String jmW;
        public boolean tEm;
        public com.tencent.mm.ac.a.a tEn;

        private a() {
            this.dQn = null;
            this.jmW = null;
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.ac.a.a aVar = (com.tencent.mm.ac.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.ac.a.a();
        }
        aVar.d(cursor);
        return aVar;
    }

    public b(Context context, com.tencent.mm.ui.r.a aVar, String str) {
        super(context, new com.tencent.mm.ac.a.a());
        this.tlG = aVar;
        this.tEg = (MMFragmentActivity) context;
        this.hpJ = str;
        this.tEl = new HashMap();
        this.tEk[0] = com.tencent.mm.bp.a.ac(context, R.e.hint_text_color);
        this.tEk[1] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_unread);
        this.tEk[3] = com.tencent.mm.bp.a.ac(context, R.e.normal_text_color);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.tEk[4] = com.tencent.mm.bp.a.ac(context, R.e.light_text_color);
        this.tEh = (float) com.tencent.mm.bp.a.ad(context, R.f.NormalTextSize);
        this.tEi = (float) com.tencent.mm.bp.a.ad(context, R.f.HintTextSize);
        this.tEj = (float) com.tencent.mm.bp.a.ad(context, R.f.SmallestTextSize);
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXB = e.cy(this.hpJ);
        aVar2.dXy = true;
        aVar2.dXV = true;
        aVar2.dXN = R.k.default_avatar;
        this.hOC = aVar2.Pt();
    }

    public final void WT() {
        aYc();
        setCursor(z.Nb().kY(this.hpJ));
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.hkP = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView$c mMSlideDelView$c) {
        this.hkO = mMSlideDelView$c;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.hkQ != null) {
            this.hkQ.aYl();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        int i2;
        com.tencent.mm.ac.a.a aVar = (com.tencent.mm.ac.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            bVar2 = new b();
            if (com.tencent.mm.bp.a.fi(this.tEg)) {
                inflate = View.inflate(this.tEg, R.i.conversation_item_large, null);
            } else {
                inflate = View.inflate(this.tEg, R.i.conversation_item, null);
            }
            bVar2.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
            bVar2.tEp = (NoMeasuredTextView) inflate.findViewById(R.h.nickname_tv);
            bVar2.tEq = (NoMeasuredTextView) inflate.findViewById(R.h.update_time_tv);
            bVar2.tEr = (NoMeasuredTextView) inflate.findViewById(R.h.last_msg_tv);
            bVar2.hkV = (TextView) inflate.findViewById(R.h.tipcnt_tv);
            bVar2.hkV.setBackgroundResource(com.tencent.mm.ui.tools.r.hd(this.tEg));
            bVar2.tEs = (ImageView) inflate.findViewById(R.h.image_mute);
            bVar2.tEu = inflate.findViewById(R.h.avatar_prospect_iv);
            bVar2.tEt = (ImageView) inflate.findViewById(R.h.talkroom_iv);
            inflate.setTag(bVar2);
            bVar2.tEr.setTextSize(0, this.tEi);
            bVar2.tEq.setTextSize(0, this.tEj);
            bVar2.tEp.setTextSize(0, this.tEh);
            bVar2.tEr.setTextColor(this.tEk[0]);
            bVar2.tEq.setTextColor(this.tEk[4]);
            bVar2.tEp.setTextColor(this.tEk[3]);
            bVar2.tEr.setShouldEllipsize(true);
            bVar2.tEq.setShouldEllipsize(false);
            bVar2.tEp.setShouldEllipsize(true);
            bVar2.tEq.setGravity(5);
            view = inflate;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.tEl.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a(this, (byte) 0);
            z.Nb();
            aVar2.tEm = com.tencent.mm.ac.a.b.c(aVar);
            com.tencent.mm.ac.a.c ak = z.Na().ak(j);
            if (ak.isGroup()) {
                aVar2.dQn = ak.field_chatName;
                aVar2.hEj = ak.hu(1);
                aVar2.jmW = ak.field_headImageUrl;
            } else {
                j cz = z.Nc().cz(ak.field_bizChatServId);
                if (cz != null) {
                    aVar2.dQn = cz.field_userName;
                    aVar2.hEj = cz.hu(1);
                    aVar2.jmW = cz.field_headImageUrl;
                }
            }
            if (bi.oW(aVar2.dQn)) {
                aVar2.dQn = this.tEg.getString(R.l.room_head_name);
            }
            aVar2.tEn = aVar;
            this.tEl.put(String.valueOf(j), aVar2);
        }
        bVar2.tEt.setVisibility(8);
        bVar2.tEq.setText(aVar2.tEn.field_status == 1 ? this.tEg.getString(R.l.main_sending) : h.c(this.tEg, aVar2.tEn.field_lastMsgTime, true));
        o.Pj().a(aVar2.jmW, bVar2.eCl, this.hOC);
        if (aVar2.hEj) {
            bVar2.tEs.setVisibility(0);
        } else {
            bVar2.tEs.setVisibility(8);
        }
        bVar2.tEp.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.tEg, aVar2.dQn, (int) bVar2.tEp.getTextSize()));
        CharSequence a = a(aVar2.tEn, (int) bVar2.tEr.getTextSize(), aVar2.dQn);
        switch (aVar2.tEn.field_status) {
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
        bVar2.tEp.setDrawRightDrawable(false);
        if (i2 != -1) {
            bVar2.tEr.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            bVar2.tEr.setDrawLeftDrawable(true);
        } else {
            bVar2.tEr.setDrawLeftDrawable(false);
        }
        bVar2.tEr.setText(a);
        bVar2.tEr.setTextColor(com.tencent.mm.bp.a.ac(this.tEg, R.e.mm_list_textcolor_two));
        if (wW(aVar2.tEn.field_msgType) == 34 && aVar2.tEn.field_isSend == 0 && !bi.oW(aVar2.tEn.field_content) && !new n(aVar2.tEn.field_content).enG) {
            bVar2.tEr.setTextColor(com.tencent.mm.bp.a.ac(this.tEg, R.e.mm_list_textcolor_unread));
        }
        if (aVar2.hEj) {
            if (aVar2.tEn.field_unReadCount > 0) {
                bVar2.tEu.setVisibility(0);
            } else {
                bVar2.tEu.setVisibility(4);
            }
            bVar2.hkV.setVisibility(4);
        } else {
            bVar2.tEu.setVisibility(4);
            if (aVar2.tEn.field_unReadCount > 99) {
                bVar2.hkV.setText(R.l.unread_count_overt_100);
                bVar2.hkV.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.tEn.field_unReadCount > 0) {
                bVar2.hkV.setText(aVar2.tEn.field_unReadCount);
                bVar2.hkV.setVisibility(0);
                x.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.hkV.setVisibility(4);
                x.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.tEm) {
            view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        } else {
            view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        }
        return view;
    }

    private static String aaf(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(str);
    }

    private CharSequence a(com.tencent.mm.ac.a.a aVar, int i, String str) {
        CharSequence spannableStringBuilder;
        if (bi.oW(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2 = aVar.field_digest;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String aaf = aaf(aVar.field_digest);
                str2 = "";
                if (aaf != null) {
                    return "[" + aaf + "]";
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    aaf = aaf(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (aaf != null) {
                        aaf = "[" + aaf + "]";
                        return bi.oW(str2) ? aaf : str2 + ": " + aaf;
                    }
                }
                aaf = this.tEg.getString(R.l.app_emoji);
                aVar.field_digest = bi.oW(str2) ? aaf : str2 + ": " + aaf;
            }
            if (bi.oW(aVar.field_digest)) {
                str2 = "";
            } else if (bi.oW(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace(10, ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                return com.tencent.mm.pluginsdk.ui.d.j.a(this.tEg, replace, i);
            }
            spannableStringBuilder = new SpannableStringBuilder(this.tEg.getString(R.l.main_conversation_chatroom_at_hint));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.a(this.tEg, replace, i));
            return spannableStringBuilder;
        }
        spannableStringBuilder = new SpannableStringBuilder(this.tEg.getString(R.l.main_conversation_last_editing_msg_prefix));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.j.a(this.tEg, aVar.field_editingMsg, i));
        return spannableStringBuilder;
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

    protected final void WS() {
        WT();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }

    public final void gr(long j) {
        if (this.tEl != null) {
            this.tEl.remove(String.valueOf(j));
        }
    }
}
