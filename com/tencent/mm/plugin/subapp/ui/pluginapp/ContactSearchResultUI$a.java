package com.tencent.mm.plugin.subapp.ui.pluginapp;

abstract class ContactSearchResultUI$a implements Runnable {
    public String iconUrl;
    public String username;

    private ContactSearchResultUI$a() {
    }

    /* synthetic */ ContactSearchResultUI$a(byte b) {
        this();
    }

    public final void eR(String str, String str2) {
        this.username = str;
        this.iconUrl = str2;
    }
}
