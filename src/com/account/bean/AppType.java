package com.account.bean;

import java.io.Serializable;

public class AppType implements Serializable {
    private Integer TypeId;
    private String TypeName;
    private static final long serialVersionUID = 1L;
    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
