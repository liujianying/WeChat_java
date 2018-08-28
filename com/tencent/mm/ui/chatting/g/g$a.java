package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.ui.chatting.a.b.b;

class g$a extends b {
    public String appId;
    public String desc;
    public int iconRes;
    final /* synthetic */ g tYD;
    public int tYF;
    public int tYG = 0;

    public g$a(g gVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
        this.tYD = gVar;
        super(j, i, str, j2, str2, str3, str4, str5);
    }

    public final boolean aak(String str) {
        if (str == null) {
            return false;
        }
        boolean aak = super.aak(str);
        if (aak) {
            return aak;
        }
        return this.title.contains(str);
    }

    public final int getType() {
        return this.type;
    }

    public final String toString() {
        return "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.bJC + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bgo + '\'' + ", nameInRoom='" + this.gBq + '\'' + '}';
    }
}
