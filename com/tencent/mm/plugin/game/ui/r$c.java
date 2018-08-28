package com.tencent.mm.plugin.game.ui;

public class r$c {
    public int actionType;
    String appId;
    int bYq;
    int kcf;
    int kcg;
    String kck;
    String kcl;
    int position;
    int type;

    public r$c(String str) {
        this.actionType = 2;
        this.kck = str;
    }

    public r$c(String str, byte b) {
        this.actionType = 2;
        this.type = 3;
        this.kck = str;
    }

    public r$c(int i, int i2, String str, String str2) {
        this.actionType = i;
        this.type = i2;
        this.appId = str;
        if (i == 2) {
            this.kck = str2;
        }
    }
}
