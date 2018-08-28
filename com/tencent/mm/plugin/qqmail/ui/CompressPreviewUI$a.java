package com.tencent.mm.plugin.qqmail.ui;

class CompressPreviewUI$a {
    boolean YF;
    String id;
    final /* synthetic */ CompressPreviewUI mfN;
    String mfP;
    String mfQ;
    String name;
    int type;

    public CompressPreviewUI$a(CompressPreviewUI compressPreviewUI, String str, String str2, String str3, int i, String str4, boolean z) {
        this.mfN = compressPreviewUI;
        this.id = str;
        this.name = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.mfP = str3;
        this.type = i;
        this.mfQ = str4;
        this.YF = z;
    }

    public final boolean boP() {
        return this.type == 1;
    }
}
