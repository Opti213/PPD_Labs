package com.redbox.technology.models;

import java.io.Serializable;

public class Technology implements Serializable {
    private String flags;
    private String graphic;
    private String graphicAlt;
    private String name;
    private String helptext = " ";
    private String req1;
    private String reg2;

    public String getHelpText() {
        return helptext;
    }

    public void setHelpText(String helpText) {
        this.helptext = helpText;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphicAlt() {
        return graphicAlt;
    }

    public void setGraphicAlt(String graphicAlt) {
        this.graphicAlt = graphicAlt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReq1() {
        return req1;
    }

    public void setReq1(String req1) {
        this.req1 = req1;
    }

    public String getReg2() {
        return reg2;
    }

    public void setReg2(String reg2) {
        this.reg2 = reg2;
    }
}
