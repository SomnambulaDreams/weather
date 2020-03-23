package entity;

import com.google.gson.annotations.SerializedName;


public class ErrorResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("type")
    private String type;

    @SerializedName("info")
    private String info;


    public ErrorResponse() {}


    public ErrorResponse(int code, String type, String info) {
        this.code = code;
        this.type = type;
        this.info = info;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return  "code = " + code + "\n" +
                "type = " + type + "\n" +
                "info = " + info;
    }
}