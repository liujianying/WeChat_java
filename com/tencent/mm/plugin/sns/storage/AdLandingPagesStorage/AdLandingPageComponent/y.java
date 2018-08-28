package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class y extends s {
    public float borderWidth;
    public List<a> mLN = new ArrayList();
    public String nBB = "";
    public String nBC = "";
    public int nBD;
    public int nBE;
    public int nBF;
    public int nBG;
    public String nBH = "";

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (yVar.nBB != null ? !yVar.nBB.equals(this.nBB) : this.nBB != null) {
            if (yVar.borderWidth == this.borderWidth && (yVar.nBC != null ? !yVar.nBC.equals(this.nBC) : this.nBC != null) && yVar.nBD == this.nBD && yVar.nBE == this.nBE && yVar.nBF == this.nBF && yVar.nBG == this.nBG && (yVar.mLN != null ? !yVar.mLN.equals(this.mLN) : this.mLN != null)) {
                if (yVar.nBH == null) {
                    if (this.nBH == null) {
                        return true;
                    }
                } else if (yVar.nBH.equals(this.nBH)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
