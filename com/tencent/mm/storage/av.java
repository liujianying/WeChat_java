package com.tencent.mm.storage;

public final class av {
    public static final av tbm = new av("timeline");
    public static final av tbn = new av("album_friend");
    public static final av tbo = new av("album_self");
    public static final av tbp = new av("album_stranger");
    public static final av tbq = new av("profile_friend");
    public static final av tbr = new av("profile_stranger");
    public static final av tbs = new av("comment");
    public static final av tbt = new av("comment_detail");
    public static final av tbu = new av("other");
    public static final av tbv = new av("snssight");
    public static final av tbw = new av("fts");
    public String tag = "";
    public int time = 0;

    public static av clT() {
        return new av("timeline");
    }

    public static av clU() {
        return new av("album_friend");
    }

    public static av clV() {
        return new av("album_self");
    }

    public static av clW() {
        return new av("album_stranger");
    }

    public static av clX() {
        return new av("comment_detail");
    }

    public static av clY() {
        return new av("snssight");
    }

    public av(String str) {
        this.tag = str;
    }

    public final av Dm(int i) {
        this.time = i;
        return this;
    }

    public static av a(av avVar, int i) {
        av avVar2 = new av(avVar.tag);
        avVar2.time = i;
        return avVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof av) {
            return ((av) obj).tag.equals(this.tag);
        }
        return super.equals(obj);
    }

    public final String toString() {
        return this.tag + "@" + this.time;
    }
}
