package com.tencent.mm.modelsns;

public final class d {
    StringBuffer ehd = new StringBuffer();
    StringBuffer ehe = new StringBuffer();
    private int index = 0;

    public final void q(String str, Object obj) {
        this.ehd.append(this.index + " " + str + "->" + obj + "\n");
        this.ehe.append(obj);
        this.index++;
    }

    public final void r(String str, Object obj) {
        this.ehd.append(str + "->" + obj + "\n");
        this.ehe.append(obj);
    }

    public final String toString() {
        return this.ehe.toString();
    }

    public final String wF() {
        this.index = 0;
        this.ehd.append("--end--\n\n");
        return this.ehd.toString();
    }
}
