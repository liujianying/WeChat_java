package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

public class y$a {
    public String label = "";
    public String nBI = "";
    public float value;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y$a)) {
            return false;
        }
        y$a y_a = (y$a) obj;
        if (y_a.label.equals(this.label) && y_a.nBI.equals(this.nBI) && y_a.value == this.value) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (int) (((float) (this.label.hashCode() + this.nBI.hashCode())) + this.value);
    }
}
