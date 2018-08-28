package com.tencent.mm.ui;

import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.bi;

class AllRemindMsgUI$d {
    int bID;
    long bJC;
    int bJt;
    String nickname;
    String rBf;
    final /* synthetic */ AllRemindMsgUI tgf;
    bge tgm;
    String tgn;
    long timestamp;
    String title;
    String username;

    AllRemindMsgUI$d(AllRemindMsgUI allRemindMsgUI) {
        this.tgf = allRemindMsgUI;
    }

    public final String toString() {
        return "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bi.Xf(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.bID + ", msgId=" + this.bJC + ", sourceType=" + this.bJt + ", sourceId='" + this.rBf + '\'' + '}';
    }
}
