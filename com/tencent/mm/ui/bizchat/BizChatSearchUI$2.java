package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ac.a.a;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.g;

class BizChatSearchUI$2 implements OnItemClickListener {
    final /* synthetic */ BizChatSearchUI tEO;

    BizChatSearchUI$2(BizChatSearchUI bizChatSearchUI) {
        this.tEO = bizChatSearchUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long j2 = -1;
        g ED = BizChatSearchUI.a(this.tEO).ED(i);
        BizChatSearchUI bizChatSearchUI = this.tEO;
        Intent intent;
        if (ED.hER == g.tFm || ED.hER == g.tFn) {
            c cVar;
            if (ED.data instanceof c) {
                cVar = (c) ED.data;
                j2 = cVar != null ? cVar.field_bizChatLocalId : -1;
            } else if (ED.data instanceof hw) {
                hz hzVar = ((hw) ED.data).riN;
                String str = bizChatSearchUI.hpJ;
                j jVar = new j();
                jVar.field_userId = hzVar.riL;
                jVar.field_userName = hzVar.hyG;
                jVar.field_brandUserName = str;
                jVar.field_headImageUrl = hzVar.riF;
                jVar.field_profileUrl = hzVar.riT;
                jVar.field_UserVersion = hzVar.ver;
                jVar.field_addMemberUrl = hzVar.riJ;
                if (!z.Nc().b(jVar) ? z.Nc().a(jVar) : true) {
                    cVar = new c();
                    cVar.field_bizChatServId = jVar.field_userId;
                    cVar.field_brandUserName = jVar.field_brandUserName;
                    cVar.field_chatName = jVar.field_userName;
                    cVar.field_chatType = 1;
                    cVar = e.e(cVar);
                    if (cVar != null) {
                        a bd = z.Nb().bd(cVar.field_bizChatLocalId);
                        bd.field_bizChatId = cVar.field_bizChatLocalId;
                        bd.field_unReadCount = 0;
                        if (bi.oW(bd.field_brandUserName)) {
                            bd.field_brandUserName = cVar.field_brandUserName;
                            bd.field_lastMsgTime = System.currentTimeMillis();
                            bd.field_flag = bd.field_lastMsgTime;
                        }
                        if (!z.Nb().b(bd)) {
                            z.Nb().a(bd);
                        }
                        j2 = cVar.field_bizChatLocalId;
                    }
                }
            }
            if (!bi.oW(bizChatSearchUI.hpJ) && j2 >= 0) {
                intent = new Intent();
                intent.putExtra("Chat_User", bizChatSearchUI.hpJ);
                intent.putExtra("key_biz_chat_id", j2);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                d.e(bizChatSearchUI.mController.tml, ".ui.chatting.ChattingUI", intent);
            }
        } else if (ED.hER != g.tFo) {
        } else {
            if (((Integer) ED.data).intValue() == g.tFs) {
                intent = new Intent(bizChatSearchUI.mController.tml, BizChatSearchUI.class);
                intent.putExtra("enterprise_biz_name", bizChatSearchUI.hpJ);
                intent.putExtra("biz_chat_search_scene", 2);
                intent.putExtra("biz_chat_search_text", bizChatSearchUI.hpe.getSearchContent());
                bizChatSearchUI.startActivity(intent);
            } else if (((Integer) ED.data).intValue() == g.tFt) {
                intent = new Intent(bizChatSearchUI.mController.tml, BizChatSearchUI.class);
                intent.putExtra("enterprise_biz_name", bizChatSearchUI.hpJ);
                intent.putExtra("biz_chat_search_scene", 3);
                intent.putExtra("biz_chat_search_text", bizChatSearchUI.hpe.getSearchContent());
                bizChatSearchUI.startActivity(intent);
            }
        }
    }
}
