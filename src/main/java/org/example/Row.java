package org.example;

public class Row {
    private String seq_id;
    private String uid;
    private String chain;
    private String productive;
    private String v_full;
    private String v_gene;
    private String d_full;
    private String d_gene;
    private String j_full;
    private String j_gene;
    private String cdr3_length;
    private String cdr3_nt;
    private String cdr3_aa;
    private String v_start;
    private String vdj_nt;
    private String vj_aa;
    private String var_muts_nt;
    private String var_muts_aa;
    private String var_identity_nt;
    private String var_identity_aa;
    private String var_mut_count_nt;
    private String var_mut_count_aa;
    private String var_ins;
    private String var_del;
    private String isotype;
    private String raw_input;

    // added this to track the num of matches of each CDR3 sequence with "yydfwsgyyt"
    private String numDChainMatches;

    public String getNumDChainMatches() {
        return numDChainMatches;
    }

    public void setNumDChainMatches(String numDChainMatches) {
        this.numDChainMatches = numDChainMatches;
    }

    public String getSeq_id() {
        return seq_id;
    }

    public void setSeq_id(String seq_id) {
        this.seq_id = seq_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getProductive() {
        return productive;
    }

    public void setProductive(String productive) {
        this.productive = productive;
    }

    public String getV_full() {
        return v_full;
    }

    public void setV_full(String v_full) {
        this.v_full = v_full;
    }

    public String getV_gene() {
        return v_gene;
    }

    public void setV_gene(String v_gene) {
        this.v_gene = v_gene;
    }

    public String getD_full() {
        return d_full;
    }

    public void setD_full(String d_full) {
        this.d_full = d_full;
    }

    public String getD_gene() {
        return d_gene;
    }

    public void setD_gene(String d_gene) {
        this.d_gene = d_gene;
    }

    public String getJ_full() {
        return j_full;
    }

    public void setJ_full(String j_full) {
        this.j_full = j_full;
    }

    public String getJ_gene() {
        return j_gene;
    }

    public void setJ_gene(String j_gene) {
        this.j_gene = j_gene;
    }

    public String getCdr3_length() {
        return cdr3_length;
    }

    public void setCdr3_length(String cdr3_length) {
        this.cdr3_length = cdr3_length;
    }

    public String getCdr3_nt() {
        return cdr3_nt;
    }

    public void setCdr3_nt(String cdr3_nt) {
        this.cdr3_nt = cdr3_nt;
    }

    public String getCdr3_aa() {
        return cdr3_aa;
    }

    public void setCdr3_aa(String cdr3_aa) {
        this.cdr3_aa = cdr3_aa;
    }

    public String getV_start() {
        return v_start;
    }

    public void setV_start(String v_start) {
        this.v_start = v_start;
    }

    public String getVdj_nt() {
        return vdj_nt;
    }

    public void setVdj_nt(String vdj_nt) {
        this.vdj_nt = vdj_nt;
    }

    public String getVj_aa() {
        return vj_aa;
    }

    public void setVj_aa(String vj_aa) {
        this.vj_aa = vj_aa;
    }

    public String getVar_muts_nt() {
        return var_muts_nt;
    }

    public void setVar_muts_nt(String var_muts_nt) {
        this.var_muts_nt = var_muts_nt;
    }

    public String getVar_muts_aa() {
        return var_muts_aa;
    }

    public void setVar_muts_aa(String var_muts_aa) {
        this.var_muts_aa = var_muts_aa;
    }

    public String getVar_identity_nt() {
        return var_identity_nt;
    }

    public void setVar_identity_nt(String var_identity_nt) {
        this.var_identity_nt = var_identity_nt;
    }

    public String getVar_identity_aa() {
        return var_identity_aa;
    }

    public void setVar_identity_aa(String var_identity_aa) {
        this.var_identity_aa = var_identity_aa;
    }

    public String getVar_mut_count_nt() {
        return var_mut_count_nt;
    }

    public void setVar_mut_count_nt(String var_mut_count_nt) {
        this.var_mut_count_nt = var_mut_count_nt;
    }

    public String getVar_mut_count_aa() {
        return var_mut_count_aa;
    }

    public void setVar_mut_count_aa(String var_mut_count_aa) {
        this.var_mut_count_aa = var_mut_count_aa;
    }

    public String getVar_ins() {
        return var_ins;
    }

    public void setVar_ins(String var_ins) {
        this.var_ins = var_ins;
    }

    public String getVar_del() {
        return var_del;
    }

    public void setVar_del(String var_del) {
        this.var_del = var_del;
    }

    public String getIsotype() {
        return isotype;
    }

    public void setIsotype(String isotype) {
        this.isotype = isotype;
    }

    public String getRaw_input() {
        return raw_input;
    }

    public void setRaw_input(String raw_input) {
        this.raw_input = raw_input;
    }
}

