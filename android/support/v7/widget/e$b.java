package android.support.v7.widget;

class e$b {
    int LY;
    Object LZ;
    int Ma;
    int nc;

    e$b(int i, int i2, int i3, Object obj) {
        this.nc = i;
        this.LY = i2;
        this.Ma = i3;
        this.LZ = obj;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
        switch (this.nc) {
            case 1:
                str = "add";
                break;
            case 2:
                str = "rm";
                break;
            case 4:
                str = "up";
                break;
            case 8:
                str = "mv";
                break;
            default:
                str = "??";
                break;
        }
        return append.append(str).append(",s:").append(this.LY).append("c:").append(this.Ma).append(",p:").append(this.LZ).append("]").toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e$b e_b = (e$b) obj;
        if (this.nc != e_b.nc) {
            return false;
        }
        if (this.nc == 8 && Math.abs(this.Ma - this.LY) == 1 && this.Ma == e_b.LY && this.LY == e_b.Ma) {
            return true;
        }
        if (this.Ma != e_b.Ma) {
            return false;
        }
        if (this.LY != e_b.LY) {
            return false;
        }
        if (this.LZ != null) {
            if (this.LZ.equals(e_b.LZ)) {
                return true;
            }
            return false;
        } else if (e_b.LZ != null) {
            return false;
        } else {
            return true;
        }
    }

    public final int hashCode() {
        return (((this.nc * 31) + this.LY) * 31) + this.Ma;
    }
}
