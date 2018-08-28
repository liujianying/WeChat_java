package com.tencent.mm.ac.a;

public class h$a {
    private String bUN;
    private String id;

    public h$a(String str, String str2) {
        this.bUN = str;
        this.id = str2;
    }

    public boolean equals(Object obj) {
        if (obj.getClass() != h$a.class) {
            return false;
        }
        h$a h_a = (h$a) obj;
        if ((this.bUN != null || h_a.bUN != null) && (this.bUN == null || !this.bUN.equals(h_a.bUN))) {
            return false;
        }
        if ((this.id != null || h_a.id != null) && (this.id == null || !this.id.equals(h_a.id))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.bUN.hashCode() + this.id.hashCode();
    }
}
