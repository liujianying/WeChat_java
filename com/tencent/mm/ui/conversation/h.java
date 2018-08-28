package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.r;
import java.util.HashMap;
import java.util.Map.Entry;

public final class h extends r<ai> implements b {
    private static long uoj = 2000;
    private String bVX;
    protected g hkN;
    protected c hkO;
    protected f hkP;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    private float tEh = -1.0f;
    private float tEi = -1.0f;
    private float tEj = -1.0f;
    HashMap<String, a> tEl;
    private boolean unX = false;
    private boolean unY = false;
    public String uoe = "";
    private final int uog;
    private final int uoh;
    private boolean uok = false;
    al uol = new al(au.Em().lnJ.getLooper(), new 1(this), false);
    private ColorStateList[] uqm = new ColorStateList[5];

    private class a {
        public int hER;
        public CharSequence nickName;
        public boolean qBs;
        public boolean tEm;
        public int uoA;
        public CharSequence uop;
        public CharSequence uoq;
        public int uor;
        public int uos;
        public boolean uov;
        public boolean uox;
        public boolean uoz;
        public boolean uqo;

        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }
    }

    public h(Context context, String str, com.tencent.mm.ui.r.a aVar) {
        super(context, new ai());
        this.tlG = aVar;
        this.bVX = str;
        this.tEl = new HashMap();
        this.uqm[0] = com.tencent.mm.bp.a.ac(context, R.e.hint_text_color);
        this.uqm[1] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_unread);
        this.uqm[3] = com.tencent.mm.bp.a.ac(context, R.e.normal_text_color);
        this.uqm[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.uqm[2] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_three);
        this.uqm[4] = com.tencent.mm.bp.a.ac(context, R.e.light_text_color);
        if (com.tencent.mm.bp.a.fi(context)) {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBiggerWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallWidth);
        } else {
            this.uoh = context.getResources().getDimensionPixelSize(R.f.ConversationTimeBigWidth);
            this.uog = context.getResources().getDimensionPixelSize(R.f.ConversationTimeSmallerWidth);
        }
        this.tEh = (float) com.tencent.mm.bp.a.ad(context, R.f.NormalTextSize);
        this.tEi = (float) com.tencent.mm.bp.a.ad(context, R.f.HintTextSize);
        this.tEj = (float) com.tencent.mm.bp.a.ad(context, R.f.SmallestTextSize);
        au.HU();
        com.tencent.mm.model.c.FW().a(this);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.hkP = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public final void onPause() {
        if (this.hkQ != null) {
            this.hkQ.aYl();
        }
        this.unX = false;
    }

    public final void onResume() {
        boolean z = true;
        this.unX = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.f.g.a("MM/dd", time).toString();
        if (this.uoe.equals(charSequence)) {
            z = false;
        }
        this.uoe = charSequence;
        if (z) {
            cyH();
        }
        if (this.unY) {
            super.a(null, null);
            this.unY = false;
        }
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        aYc();
        au.HU();
        setCursor(com.tencent.mm.model.c.FW().b(s.dAN, null, this.bVX));
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        ai aiVar = (ai) getItem(i);
        String str = aiVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bp.a.fi(this.context)) {
                inflate = View.inflate(this.context, R.i.conversation_item_large, null);
            } else {
                inflate = View.inflate(this.context, R.i.conversation_item, null);
            }
            bVar.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
            bVar.uqp = (NoMeasuredTextView) inflate.findViewById(R.h.nickname_tv);
            bVar.uqp.setTextSize(0, this.tEh);
            bVar.uqp.setTextColor(this.uqm[3]);
            bVar.uqp.setShouldEllipsize(true);
            bVar.uqq = (NoMeasuredTextView) inflate.findViewById(R.h.update_time_tv);
            bVar.uqq.setTextSize(0, this.tEj);
            bVar.uqq.setTextColor(this.uqm[4]);
            bVar.uqq.setShouldEllipsize(false);
            bVar.uqq.setGravity(5);
            bVar.uqr = (NoMeasuredTextView) inflate.findViewById(R.h.last_msg_tv);
            bVar.uqr.setTextSize(0, this.tEi);
            bVar.uqr.setTextColor(this.uqm[0]);
            bVar.uqr.setShouldEllipsize(true);
            bVar.uqs = (TextView) inflate.findViewById(R.h.tipcnt_tv);
            bVar.uqs.setBackgroundResource(com.tencent.mm.ui.tools.r.hd(this.context));
            bVar.tEs = (ImageView) inflate.findViewById(R.h.image_mute);
            bVar.tEu = inflate.findViewById(R.h.avatar_prospect_iv);
            inflate.findViewById(R.h.talkroom_iv).setVisibility(8);
            inflate.findViewById(R.h.location_share_iv).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.tEl.get(str);
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (aVar2 == null) {
            a aVar3 = new a(this, (byte) 0);
            if (Yg != null) {
                aVar3.uos = (int) Yg.dhP;
            } else {
                aVar3.uos = -1;
            }
            aVar3.uox = Yg != null;
            boolean z = Yg != null && Yg.BE();
            aVar3.uoz = z;
            z = Yg != null && Yg.BD();
            aVar3.uov = z;
            aVar3.uqo = aiVar.field_unReadCount > 0;
            aVar3.hER = 0;
            if (j(aiVar) == 34 && aiVar.field_isSend == 0 && !com.tencent.mm.platformtools.ai.oW(aiVar.field_content) && !new n(aiVar.field_content).enG) {
                aVar3.hER = 1;
            }
            aVar3.nickName = j.a(this.context, com.tencent.mm.model.r.a(Yg, str, false), bVar.uqp.getTextSize());
            aVar3.uop = h(aiVar);
            int textSize = (int) bVar.uqr.getTextSize();
            z = aVar3.uov && aVar3.uqo;
            aVar3.uoq = c(aiVar, textSize, z);
            aVar3.uoA = aiVar.field_attrflag;
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
            aVar3.uor = i2;
            au.HU();
            aVar3.tEm = com.tencent.mm.model.c.FW().g(aiVar);
            aVar3.qBs = w.chL();
            this.tEl.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.uop == null) {
            aVar.uop = h(aiVar);
        }
        if (aVar.uov && aVar.uqo) {
            bVar.uqr.setTextColor(this.uqm[0]);
        } else {
            bVar.uqr.setTextColor(this.uqm[aVar.hER]);
        }
        com.tencent.mm.booter.notification.a.h.fz(bVar.uqr.getWidth());
        com.tencent.mm.booter.notification.a.h.fA((int) bVar.uqr.getTextSize());
        com.tencent.mm.booter.notification.a.h.a(bVar.uqr.getPaint());
        if (aVar.uor != -1) {
            bVar.uqr.setCompoundLeftDrawablesWithIntrinsicBounds(aVar.uor);
            bVar.uqr.setDrawLeftDrawable(true);
        } else {
            bVar.uqr.setDrawLeftDrawable(false);
        }
        bVar.uqr.setText(aVar.uoq);
        bVar.uqp.setDrawRightDrawable(false);
        bVar.uqp.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.uqq.getLayoutParams();
        if (aVar.uop.length() > 9) {
            if (layoutParams.width != this.uoh) {
                layoutParams.width = this.uoh;
                bVar.uqq.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.uog) {
            layoutParams.width = this.uog;
            bVar.uqq.setLayoutParams(layoutParams);
        }
        bVar.uqq.setText(aVar.uop);
        if (aVar.uov) {
            bVar.tEs.setVisibility(0);
        } else {
            bVar.tEs.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.eCl, str);
        bVar.uqs.setVisibility(4);
        bVar.tEu.setVisibility(4);
        if (aVar.uox && aVar.uos != 0) {
            i2 = aiVar.field_unReadCount;
            if (aVar.uov) {
                View view2 = bVar.tEu;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.uqs.setText(R.l.unread_count_overt_100);
                bVar.uqs.setVisibility(0);
            } else if (i2 > 0) {
                bVar.uqs.setText(String.valueOf(i2));
                bVar.uqs.setVisibility(0);
            }
        }
        if (!aVar.tEm || aiVar.field_conversationTime == -1) {
            inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
        } else {
            inflate.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
        }
        com.tencent.mm.ui.a.a.a.cqX().a(inflate, String.valueOf(aVar.nickName), aiVar.field_unReadCount, String.valueOf(aVar.uop), String.valueOf(aVar.uoq));
        return inflate;
    }

    private static int j(ai aiVar) {
        int i = 1;
        String str = aiVar.field_msgType;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    private CharSequence c(ai aiVar, int i, boolean z) {
        CharSequence replace;
        if (com.tencent.mm.platformtools.ai.oW(aiVar.field_editingMsg) || (aiVar.field_atCount > 0 && aiVar.field_unReadCount > 0)) {
            CharSequence charSequence = aiVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(j.c(this.context, charSequence, (float) i));
            }
            String str;
            if (j(aiVar) == 47 || j(aiVar) == 1048625) {
                String aaf = aaf(aiVar.field_digest);
                str = "";
                if (aaf != null) {
                    return "[" + aaf + "]";
                }
                if (aiVar.field_digest != null && aiVar.field_digest.contains(":")) {
                    str = aiVar.field_digest.substring(0, aiVar.field_digest.indexOf(":"));
                    aaf = aaf(aiVar.field_digest.substring(aiVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (aaf != null) {
                        aaf = "[" + aaf + "]";
                        return com.tencent.mm.platformtools.ai.oW(str) ? aaf : str + ": " + aaf;
                    }
                }
                aaf = this.context.getString(R.l.app_emoji);
                aiVar.ed(com.tencent.mm.platformtools.ai.oW(str) ? aaf : str + ": " + aaf);
            }
            if (!com.tencent.mm.platformtools.ai.oW(aiVar.field_digest)) {
                if (com.tencent.mm.platformtools.ai.oW(aiVar.field_digestUser)) {
                    str = aiVar.field_digest;
                } else {
                    str = (aiVar.field_isSend == 0 && s.fq(aiVar.field_username)) ? com.tencent.mm.model.r.getDisplayName(aiVar.field_digestUser, aiVar.field_username) : com.tencent.mm.model.r.gT(aiVar.field_digestUser);
                    try {
                        str = String.format(aiVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace(10, ' ');
                if (aiVar.field_atCount > 0 || aiVar.field_unReadCount <= 0) {
                    if (z && aiVar.field_unReadCount > 1) {
                        replace = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
                    }
                    return j.a(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_chatroom_at_hint));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(j.a(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, j(aiVar), this.context);
            replace = str.replace(10, ' ');
            if (aiVar.field_atCount > 0) {
            }
            replace = this.context.getString(R.l.main_conversation_chatroom_unread_digest, new Object[]{Integer.valueOf(aiVar.field_unReadCount), replace});
            return j.a(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(R.l.main_conversation_last_editing_msg_prefix));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(j.a(this.context, aiVar.field_editingMsg, i));
        return replace;
    }

    private static String aaf(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(str);
    }

    private CharSequence h(ai aiVar) {
        if (aiVar.field_status == 1) {
            return this.context.getString(R.l.main_sending);
        }
        return aiVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.f.h.c(this.context, aiVar.field_conversationTime, true);
    }

    private void cyH() {
        if (this.tEl != null) {
            for (Entry value : this.tEl.entrySet()) {
                ((a) value.getValue()).uop = null;
            }
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[]{Boolean.valueOf(this.unX), Boolean.valueOf(this.unY), str});
        if (!(com.tencent.mm.platformtools.ai.oW(str) || this.tEl == null)) {
            this.tEl.remove(str);
        }
        if (this.unX) {
            x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[]{Boolean.valueOf(this.uok), Boolean.valueOf(this.uol.ciq())});
            this.uok = true;
            if (this.uol.ciq()) {
                cyI();
                return;
            }
            return;
        }
        this.unY = true;
    }

    private void cyI() {
        ah.A(new 2(this));
    }
}
