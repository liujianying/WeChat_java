package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ax.g;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.applet.b$b;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends r<ai> {
    private String eIQ;
    private com.tencent.mm.ui.applet.b eKg = new com.tencent.mm.ui.applet.b(new 1(this));
    private b$b eKh = null;
    protected List<String> gRN = null;
    private ColorStateList[] tEk = new ColorStateList[2];
    private HashMap<String, a> tEl;
    private b uFA;
    private boolean unU = true;

    public interface b {
    }

    public static class c {
        public ImageView eCl;
        public TextView eTm;
        public TextView hkS;
        public TextView hkT;
        public TextView hkV;
        public ImageView tEs;
        public ImageView tEt;
    }

    public a(Context context, com.tencent.mm.ui.r.a aVar) {
        super(context, new ai());
        this.tlG = aVar;
        this.tEk[0] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_two);
        this.tEk[1] = com.tencent.mm.bp.a.ac(context, R.e.mm_list_textcolor_unread);
        this.tEl = new HashMap();
    }

    public final void dQ(List<String> list) {
        this.gRN = list;
        a(null, null);
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = au.HU().dAb.a(s.dAN, this.gRN, this.eIQ);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.gRN != null && this.gRN.size() > 0) {
            arrayList.addAll(this.gRN);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                x.d("MicroMsg.SearchConversationAdapter", "block user " + string);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = au.HU().dAc.a(this.eIQ, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.uFA == null || this.eIQ == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        rn rnVar;
        if (this.eKh == null) {
            this.eKh = new b$b() {
                public final String jd(int i) {
                    if (i < 0 || i >= a.this.getCount()) {
                        x.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        return null;
                    }
                    ai aiVar = (ai) a.this.getItem(i);
                    return aiVar == null ? null : aiVar.field_username;
                }

                public final int Xy() {
                    return a.this.getCount();
                }
            };
        }
        if (this.eKg != null) {
            this.eKg.a(i, this.eKh);
        }
        ai aiVar = (ai) getItem(i);
        if (wW(aiVar.field_msgType) == 34 && aiVar.field_isSend == 0 && !com.tencent.mm.platformtools.ai.oW(aiVar.field_content)) {
            String str = aiVar.field_content;
            if (aiVar.field_username.equals("qmessage") || aiVar.field_username.equals("floatbottle")) {
                String[] split = str.split(":");
                if (split != null && split.length > 3) {
                    str = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str).enG) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, R.i.search_conversation, null);
                    cVar.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
                    cVar.eTm = (TextView) view.findViewById(R.h.nickname_tv);
                    cVar.hkS = (TextView) view.findViewById(R.h.update_time_tv);
                    cVar.hkT = (TextView) view.findViewById(R.h.last_msg_tv);
                    cVar.hkV = (TextView) view.findViewById(R.h.tipcnt_tv);
                    cVar.hkV.setBackgroundResource(com.tencent.mm.ui.tools.r.hd(this.context));
                    cVar.tEs = (ImageView) view.findViewById(R.h.image_mute);
                    cVar.tEt = (ImageView) view.findViewById(R.h.talkroom_iv);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.tEl.get(aiVar.field_username + aiVar.field_content);
                if (aVar == null) {
                    int i3;
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.nickName = j.a(this.context, com.tencent.mm.model.r.gT(aiVar.field_username), cVar.eTm.getTextSize());
                    CharSequence string = aiVar.field_status == 1 ? this.context.getString(R.l.main_sending) : aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.context, aiVar.field_conversationTime, true);
                    aVar2.uop = string;
                    int textSize = (int) cVar.hkT.getTextSize();
                    int GJ = q.GJ();
                    String str2 = aiVar.field_username;
                    au.HU();
                    Object obj = com.tencent.mm.platformtools.ai.f((Integer) com.tencent.mm.model.c.DT().get(17, null)) == 1 ? 1 : null;
                    if (str2.equals("qqmail") && obj == null) {
                        string = this.context.getString(R.l.settings_plugins_disable);
                    } else {
                        au.HU();
                        bl Hg = com.tencent.mm.model.c.FZ().Hg("@t.qq.com");
                        obj = (Hg == null || !Hg.isEnable()) ? null : 1;
                        if (str2.equals("tmessage") && obj == null) {
                            string = this.context.getString(R.l.settings_plugins_disable);
                        } else {
                            string = (str2.equals("qmessage") && ((GJ & 64) != 0 ? 1 : null) == null) ? this.context.getString(R.l.settings_plugins_disable) : j.a(this.context, com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.context), textSize);
                        }
                    }
                    aVar2.uoq = string;
                    if (s.fq(aiVar.field_username) && m.gK(aiVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(R.l.chatting_roominfo_noname);
                    }
                    switch (aiVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.k.msg_state_sending;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.k.msg_state_failed;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.uor = i3;
                    this.tEl.put(aiVar.field_username + aiVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.hkT.setTextColor(this.tEk[i2]);
                cVar.eTm.setText(aVar.nickName);
                cVar.hkS.setText(aVar.uop);
                cVar.hkT.setText(j.a(this.context, aVar.uoq.toString(), cVar.hkT.getTextSize()));
                if (aiVar.field_conversationTime != 0) {
                    cVar.hkS.setVisibility(8);
                } else {
                    cVar.hkS.setVisibility(0);
                }
                cVar.tEs.setVisibility(8);
                if (s.fq(aiVar.field_username)) {
                    au.HU();
                    ab Yg = com.tencent.mm.model.c.FR().Yg(aiVar.field_username);
                    if (Yg != null && Yg.csI == 0) {
                        cVar.tEs.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.eCl, aiVar.field_username);
                if (this.unU) {
                    if (aiVar.field_unReadCount > 100) {
                        cVar.hkV.setText("...");
                        cVar.hkV.setVisibility(0);
                    } else if (aiVar.field_unReadCount > 0) {
                        cVar.hkV.setText(aiVar.field_unReadCount);
                        cVar.hkV.setVisibility(0);
                    } else {
                        cVar.hkV.setVisibility(4);
                    }
                }
                if (au.HX()) {
                    if (!s.a(aiVar)) {
                        au.HU();
                        if (com.tencent.mm.model.c.FW().g(aiVar)) {
                            au.HU();
                            com.tencent.mm.model.c.FW().f(aiVar);
                        }
                    }
                    au.HU();
                    if (com.tencent.mm.model.c.FW().g(aiVar)) {
                        view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
                    } else {
                        view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
                    }
                }
                rnVar = new rn();
                rnVar.ccn.ccp = true;
                com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 7, 0) || aiVar.field_username.equals(rnVar.cco.ccr))) {
                    aiVar.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 6, aiVar.field_conversationTime));
                    au.HU();
                    com.tencent.mm.model.c.FW().a(aiVar, aiVar.field_username);
                }
                if (g.elf == null && g.elf.nq(aiVar.field_username)) {
                    cVar.tEt.setVisibility(0);
                    if (aiVar.field_username.equals(rnVar.cco.ccr)) {
                        cVar.tEt.setImageResource(R.k.talk_room_mic_speaking);
                    } else {
                        cVar.tEt.setImageResource(R.k.talk_room_mic_idle);
                    }
                } else {
                    cVar.tEt.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c();
            view = View.inflate(this.context, R.i.search_conversation, null);
            cVar.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            cVar.eTm = (TextView) view.findViewById(R.h.nickname_tv);
            cVar.hkS = (TextView) view.findViewById(R.h.update_time_tv);
            cVar.hkT = (TextView) view.findViewById(R.h.last_msg_tv);
            cVar.hkV = (TextView) view.findViewById(R.h.tipcnt_tv);
            cVar.hkV.setBackgroundResource(com.tencent.mm.ui.tools.r.hd(this.context));
            cVar.tEs = (ImageView) view.findViewById(R.h.image_mute);
            cVar.tEt = (ImageView) view.findViewById(R.h.talkroom_iv);
            view.setTag(cVar);
        }
        aVar = (a) this.tEl.get(aiVar.field_username + aiVar.field_content);
        if (aVar == null) {
            int i32;
            a aVar22 = new a(this, (byte) 0);
            aVar22.nickName = j.a(this.context, com.tencent.mm.model.r.gT(aiVar.field_username), cVar.eTm.getTextSize());
            CharSequence string2 = aiVar.field_status == 1 ? this.context.getString(R.l.main_sending) : aiVar.field_conversationTime == Long.MAX_VALUE ? "" : h.c(this.context, aiVar.field_conversationTime, true);
            aVar22.uop = string2;
            int textSize2 = (int) cVar.hkT.getTextSize();
            int GJ2 = q.GJ();
            String str22 = aiVar.field_username;
            au.HU();
            Object obj2 = com.tencent.mm.platformtools.ai.f((Integer) com.tencent.mm.model.c.DT().get(17, null)) == 1 ? 1 : null;
            if (str22.equals("qqmail") && obj2 == null) {
                string2 = this.context.getString(R.l.settings_plugins_disable);
            } else {
                au.HU();
                bl Hg2 = com.tencent.mm.model.c.FZ().Hg("@t.qq.com");
                obj2 = (Hg2 == null || !Hg2.isEnable()) ? null : 1;
                if (str22.equals("tmessage") && obj2 == null) {
                    string2 = this.context.getString(R.l.settings_plugins_disable);
                } else {
                    string2 = (str22.equals("qmessage") && ((GJ2 & 64) != 0 ? 1 : null) == null) ? this.context.getString(R.l.settings_plugins_disable) : j.a(this.context, com.tencent.mm.booter.notification.a.h.a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.context), textSize2);
                }
            }
            aVar22.uoq = string2;
            if (s.fq(aiVar.field_username) && m.gK(aiVar.field_username) == 0) {
                aVar22.nickName = this.context.getString(R.l.chatting_roominfo_noname);
            }
            switch (aiVar.field_status) {
                case 0:
                    i32 = -1;
                    break;
                case 1:
                    i32 = R.k.msg_state_sending;
                    break;
                case 2:
                    i32 = -1;
                    break;
                case 5:
                    i32 = R.k.msg_state_failed;
                    break;
                default:
                    i32 = -1;
                    break;
            }
            aVar22.uor = i32;
            this.tEl.put(aiVar.field_username + aiVar.field_content, aVar22);
            aVar = aVar22;
        }
        cVar.hkT.setTextColor(this.tEk[i2]);
        cVar.eTm.setText(aVar.nickName);
        cVar.hkS.setText(aVar.uop);
        cVar.hkT.setText(j.a(this.context, aVar.uoq.toString(), cVar.hkT.getTextSize()));
        if (aiVar.field_conversationTime != 0) {
            cVar.hkS.setVisibility(0);
        } else {
            cVar.hkS.setVisibility(8);
        }
        cVar.tEs.setVisibility(8);
        if (s.fq(aiVar.field_username)) {
            au.HU();
            ab Yg2 = com.tencent.mm.model.c.FR().Yg(aiVar.field_username);
            if (Yg2 != null && Yg2.csI == 0) {
                cVar.tEs.setVisibility(0);
            }
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.eCl, aiVar.field_username);
        if (this.unU) {
            if (aiVar.field_unReadCount > 100) {
                cVar.hkV.setText("...");
                cVar.hkV.setVisibility(0);
            } else if (aiVar.field_unReadCount > 0) {
                cVar.hkV.setText(aiVar.field_unReadCount);
                cVar.hkV.setVisibility(0);
            } else {
                cVar.hkV.setVisibility(4);
            }
        }
        if (au.HX()) {
            if (!s.a(aiVar)) {
                au.HU();
                if (com.tencent.mm.model.c.FW().g(aiVar)) {
                    au.HU();
                    com.tencent.mm.model.c.FW().f(aiVar);
                }
            }
            au.HU();
            if (com.tencent.mm.model.c.FW().g(aiVar)) {
                view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_item_highlight_selector);
            } else {
                view.findViewById(R.h.conversation_item_ll).setBackgroundResource(R.g.comm_list_item_selector);
            }
        }
        rnVar = new rn();
        rnVar.ccn.ccp = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        aiVar.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 6, aiVar.field_conversationTime));
        au.HU();
        com.tencent.mm.model.c.FW().a(aiVar, aiVar.field_username);
        if (g.elf == null) {
        }
        cVar.tEt.setVisibility(8);
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

    public final void a(String str, l lVar) {
        if (str != null && !str.equals("") && this.tEl != null) {
            this.tEl.remove(str);
        } else if (this.tEl != null) {
            this.tEl.clear();
        }
        super.a(str, lVar);
    }

    public final void pi(String str) {
        this.eIQ = str;
        aYc();
        WT();
    }
}
