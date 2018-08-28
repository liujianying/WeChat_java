package com.tencent.mm.plugin.sns.model;

class ap$a {
    String cbd;
    String id;
    String nrF;
    String nrG;
    int type;

    private ap$a() {
    }

    /* synthetic */ ap$a(byte b) {
        this();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ap$a)) {
            return super.equals(obj);
        }
        ap$a ap_a = (ap$a) obj;
        if (this.id.equals(ap_a.id) && this.type == ap_a.type) {
            return true;
        }
        return false;
    }
}
