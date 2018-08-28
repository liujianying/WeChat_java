package com.tencent.mm.plugin.expt.roomexpt;

final class c implements Comparable<c> {
    String bIY;
    float iIx;
    String nickname;

    c() {
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        if (this.iIx > cVar.iIx) {
            return -1;
        }
        return this.iIx < cVar.iIx ? 1 : 0;
    }

    public final String toString() {
        return String.format("chatroom[%s %s] score[%f]", new Object[]{this.bIY, this.nickname, Float.valueOf(this.iIx)});
    }
}
