package com.tencent.mm.plugin.fts.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.b;
import com.tencent.mm.plugin.fts.ui.n.g;

class FTSChattingConvUI$a extends a<b> {
    final /* synthetic */ FTSChattingConvUI jwt;
    String[] jwu;

    FTSChattingConvUI$a(FTSChattingConvUI fTSChattingConvUI) {
        this.jwt = fTSChattingConvUI;
        if (s.fq(FTSChattingConvUI.b(fTSChattingConvUI))) {
            this.jwu = new String[7];
            this.jwu[0] = fTSChattingConvUI.getResources().getString(g.search_chatroom_member);
            this.jwu[1] = fTSChattingConvUI.getResources().getString(g.search_chatroom_date);
            this.jwu[2] = fTSChattingConvUI.getResources().getString(g.search_chatroom_image_or_video);
            this.jwu[3] = fTSChattingConvUI.getResources().getString(g.search_chatroom_file);
            this.jwu[4] = fTSChattingConvUI.getResources().getString(g.search_chatroom_url);
            this.jwu[5] = fTSChattingConvUI.getResources().getString(g.search_chatroom_music);
            this.jwu[6] = fTSChattingConvUI.getResources().getString(g.search_chatroom_pay);
        } else if (FTSChattingConvUI.a(fTSChattingConvUI)) {
            this.jwu = new String[2];
            this.jwu[0] = fTSChattingConvUI.getResources().getString(g.search_chatroom_date);
            this.jwu[1] = fTSChattingConvUI.getResources().getString(g.search_chatroom_image_or_video);
        } else {
            this.jwu = new String[6];
            this.jwu[0] = fTSChattingConvUI.getResources().getString(g.search_chatroom_date);
            this.jwu[1] = fTSChattingConvUI.getResources().getString(g.search_chatroom_image_or_video);
            this.jwu[2] = fTSChattingConvUI.getResources().getString(g.search_chatroom_file);
            this.jwu[3] = fTSChattingConvUI.getResources().getString(g.search_chatroom_url);
            this.jwu[4] = fTSChattingConvUI.getResources().getString(g.search_chatroom_music);
            this.jwu[5] = fTSChattingConvUI.getResources().getString(g.search_chatroom_pay);
        }
    }

    public final int getItemCount() {
        return this.jwu.length;
    }
}
