package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElementInfo {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("keyValue")
    @Expose
    private String keyValue;
    @SerializedName("keyType")
    @Expose
    private String keyType;
    @SerializedName("keyIndex")
    @Expose
    private int keyIndex;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }
}
