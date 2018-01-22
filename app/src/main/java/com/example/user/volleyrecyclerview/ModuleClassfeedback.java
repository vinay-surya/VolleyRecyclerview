package com.example.user.volleyrecyclerview;

/**
 * Created by Manju 619 on 19-06-2017.
 */

 class ModuleClassfeedback {
    public String ConsumerNAme,ConsumerGEnder,Comment,DealName;

    public ModuleClassfeedback(String consumerNAme, String consumerGEnder, String comment, String dealName) {

        ConsumerNAme = consumerNAme;
        ConsumerGEnder = consumerGEnder;
        Comment = comment;
        DealName = dealName;
    }

    public String getConsumerNAme() {
        return ConsumerNAme;
    }

    public void setConsumerNAme(String consumerNAme) {
        ConsumerNAme = consumerNAme;
    }

    public String getConsumerGEnder() {
        return ConsumerGEnder;
    }

    public void setConsumerGEnder(String consumerGEnder) {
        ConsumerGEnder = consumerGEnder;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getDealName() {
        return DealName;
    }

    public void setDealName(String dealName) {
        DealName = dealName;
    }
}
